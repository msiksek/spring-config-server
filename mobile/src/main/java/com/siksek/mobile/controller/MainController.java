package com.siksek.mobile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/mobile")
@RestController
@Log4j2
public class MainController {

	@Value(value="${test.value}")
	private String test;
	
	@GetMapping("/echo")
	@HystrixCommand(fallbackMethod = "defaultGreeting")
	public ResponseEntity<String> echo() throws IOException {
		log.info("mobile api call");
		throw new IOException("error");
		//return new ResponseEntity<String>("Echo from mobile " + test, HttpStatus.OK);
	}
	
	private ResponseEntity<String> defaultGreeting() {
		return new ResponseEntity<String>("We are down!", HttpStatus.OK);
    }
}
