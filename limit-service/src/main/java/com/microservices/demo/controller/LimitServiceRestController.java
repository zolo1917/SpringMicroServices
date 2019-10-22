package com.microservices.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.configuration.limitsConfig;
import com.microservices.demo.model.LimitConfiguration;
import com.microservices.demo.model.ZipCodeModel;

@RestController
public class LimitServiceRestController {
	
	@Autowired
	private limitsConfig config;
	
	private final RestTemplate restTemplate;
	
	LimitServiceRestController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build(); 
	}
	
	@GetMapping("/limitConfiguration")
	public LimitConfiguration limitconfig() {
		return new LimitConfiguration(config.getMaxium(), config.getMinium());
	}
	
	@GetMapping("/getCityState/{zipCode}")
	public ZipCodeModel getzipStateDetails(@PathVariable Long zipCode) {
		ZipCodeModel zip = this.restTemplate.getForObject("http://localhost:8001/getCityState/{zipCode}", ZipCodeModel.class,zipCode);
		return zip;
	}
}
