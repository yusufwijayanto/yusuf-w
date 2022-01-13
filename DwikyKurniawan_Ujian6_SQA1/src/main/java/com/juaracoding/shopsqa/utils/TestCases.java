package com.juaracoding.shopsqa.utils;

public enum TestCases {

	T1("Testing register page"),
	T2("Testing login page"),
	T3("Testing add cart from compare page"),
	T4("Testing add cart from compare page"),
	T5("Testing checkout page");
	
	private String testName;
	
	TestCases(String value) {
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
