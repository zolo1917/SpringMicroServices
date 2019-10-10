package com.microservices.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.demo.configuration.limitsConfig;
import com.microservices.demo.model.LimitConfiguration;

@RestController
public class LimitServiceRestController {
	
	@Autowired
	private limitsConfig config;

	@GetMapping("/limitConfiguration")
	public LimitConfiguration limitconfig() {
		return new LimitConfiguration(2, 22);
	}
}
