package com.microservices.demo.model;

public class LimitConfiguration {
	private int maxium;
	private int minium;
	
	public LimitConfiguration(int a, int b) {
		this.maxium = a;
		this.minium = b;
	}
	public int getMaxium() {
		return maxium;
	}
	public void setMaxium(int maxium) {
		this.maxium = maxium;
	}
	public int getMinium() {
		return minium;
	}
	public void setMinium(int minium) {
		this.minium = minium;
	}
	
	
}
