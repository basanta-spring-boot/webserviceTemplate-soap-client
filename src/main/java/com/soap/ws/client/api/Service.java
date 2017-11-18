package com.soap.ws.client.api;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;

import com.soap.ws.client.api.schemas.ValidateCardNumber;
import com.soap.ws.client.api.schemas.ValidateCardNumberResponse;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private Jaxb2Marshaller marshaller;

	public String callAPI() {
		String URI = "http://www.webservicex.net/CreditCard.asmx";
		ValidateCardNumber card = new ValidateCardNumber();
		card.setCardNumber("5318491020527815");
		card.setCardType("MASTERCARD");
		WebServiceTemplate template = new WebServiceTemplate(marshaller);
		ValidateCardNumberResponse response = (ValidateCardNumberResponse) template.marshalSendAndReceive(URI, card,
				new WebServiceMessageCallback() {

					@Override
					public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
						((SoapMessage) message).setSoapAction("http://www.webservicex.net/ValidateCardNumber");

					}
				});
		System.out.println(response.getValidateCardNumberResult());

		return response.getValidateCardNumberResult();
	}

}
