package com.microservices.demo.model;

public class ValueObject {
	private Long id;
	private String from;
	private String to;
	private Long conversionMultiple;
	private int port;
	
	public ValueObject(Long id, String from, String to, Long conversionMultiple) {
		super();
		this.from=from;
		this.to=to;
		this.id=id;
		this.conversionMultiple=conversionMultiple;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(Long conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
	
}
