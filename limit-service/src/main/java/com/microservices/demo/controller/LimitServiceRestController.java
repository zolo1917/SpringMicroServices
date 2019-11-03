package com.microservices.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.configuration.limitsConfig;
import com.microservices.demo.model.LimitConfiguration;
import com.microservices.demo.model.ZipCodeModel;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class LimitServiceRestController {
	
	@Autowired
	private limitsConfig config;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	private final RestTemplate restTemplate;
	
	@Value("${eureka.DataBaseService.serviceId}")
	private String zipCodeSearchId;
	
	LimitServiceRestController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build(); 
	}
	
	@GetMapping("/limitConfiguration")
	public LimitConfiguration limitconfig() {
		return new LimitConfiguration(config.getMaxium(), config.getMinium());
	}
	
	@GetMapping("/getCityState/{zipCode}")
	public ZipCodeModel getzipStateDetails(@PathVariable Long zipCode) {
        Application application = eurekaClient.getApplication(zipCodeSearchId);

        InstanceInfo instanceInfo = application.getInstances().get(0);

        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "/getCityState/"+zipCode.toString();

        System.out.println("URL" + url);
		ZipCodeModel zip = this.restTemplate.getForObject("http://localhost:8001/getCityState/{zipCode}", ZipCodeModel.class,zipCode);
		return zip;
	}
}
