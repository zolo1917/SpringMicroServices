package com.microservices.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DataBaseServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBaseServerApplication.class, args);
	}

}
