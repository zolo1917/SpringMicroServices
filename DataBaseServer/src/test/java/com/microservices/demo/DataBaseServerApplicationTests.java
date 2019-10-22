package com.microservices.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservices.demo.Controller.DataServiceRestApi;
import com.microservices.demo.model.ZipCodeModel;
import com.microservices.demo.repositories.ZipCodeRepository;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataBaseServerApplication.class)
public abstract class DataBaseServerApplicationTests {

	@Autowired
	private DataServiceRestApi dataServiceRestApi;

	@MockBean
	private ZipCodeRepository zipRepo;

	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(dataServiceRestApi);
		Mockito.when(zipRepo.getOne(45202L))
				.thenReturn(new ZipCodeModel(45202L, "Cincinnati", "OH", "Ohaio", "Hamilton"));
	}

	@Test
	public void contextLoads() {
	}

}
