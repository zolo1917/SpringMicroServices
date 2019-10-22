package com.microservices.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ZipCodeModel {
	private Long zip;
	private String city;
	private String stateId;
	private String stateName;
	private String countyName;

	public ZipCodeModel(Long zip,String city,String stateId, String stateName, String countyName) {
		this.zip=zip;
		this.city=city;
		this.stateId=stateId;
		this.stateName=stateName;
		this.countyName=countyName;
	}
	
	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

}
