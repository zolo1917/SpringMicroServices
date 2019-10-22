package com.microservices.demo;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.model.ZipCodeModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LimitServiceApplicationTests {

	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
			.downloadStubs("com.microservices", "DatabaseService", "0.0.1-SNAPSHOT", "stubs").maxPort(8100).minPort(8100)
			.stubsMode(StubRunnerProperties.StubsMode.LOCAL);

	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void get_person_from_service_contract() {	
		// given:
		RestTemplate restTemplate = new RestTemplate();

		// when:
		ResponseEntity<ZipCodeModel> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/getCityState/45202", ZipCodeModel.class);

		// then:
		BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(personResponseEntity.getBody().getZip()).isEqualTo(45202L);
	}

}
