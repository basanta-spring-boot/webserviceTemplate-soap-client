package com.soap.ws.client.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.soap.ws.client.api.schemas.ValidateCardNumber;
import com.soap.ws.client.api.schemas.ValidateCardNumberResponse;

@SpringBootApplication
public class WebserviceTemplateSoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceTemplateSoapClientApplication.class, args);
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(ValidateCardNumber.class, ValidateCardNumberResponse.class);
		return marshaller;
	}
}
