package com.soap.ws.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private Service service;

	@RequestMapping("/call")
	public String call() {
		return service.callAPI();
	}
}
