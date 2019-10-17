package com.microservices.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.demo.model.ValueObject;
import com.microservices.demo.model.ZipCodeModel;
import com.microservices.demo.repositories.ZipCodeRepository;

@RestController
public class DataServiceRestApi {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ZipCodeRepository zipRepo;
	
	@GetMapping("/from/{from}/to/{to}")
	public ValueObject retriveValueObject(@PathVariable String from, @PathVariable String to) {
		ValueObject valueObject = new ValueObject(1L, from, to, 65L);
		valueObject.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return valueObject;
	}
	
	@GetMapping("/getCityState/{zipCode}")
	public ZipCodeModel retriveZipCode(@PathVariable Long zipCode) {
		return zipRepo.getOne(zipCode);
	}

}
