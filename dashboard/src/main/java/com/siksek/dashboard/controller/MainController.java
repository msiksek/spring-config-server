package com.siksek.dashboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RequestMapping("/dashboard")
@RestController
public class MainController {

	@GetMapping("/echo-dash")
	@HystrixCommand(fallbackMethod = "defaultGreeting")
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>("Echo from dashboard", HttpStatus.OK);
	}
	
	private ResponseEntity<String> defaultGreeting() {
		return new ResponseEntity<String>("We are down!", HttpStatus.OK);
    }
}
