package com.juaracoding.shopsqa.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	
	@Value("${browser}")
	private String browser;
	
	@Value("${usernamex}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Value("${email}")
	private String email;
	
	@Value("${register}")
	private String displayRegister;
	
	@Value("${login}")
	private String displayLogin;
	
	@Value("${shoes}")
	private String shoes;
	
	@Value("${disaddcartshooes}")
	private String disShoes;

	@Value("${sunglass}")
	private String sunglass;

	@Value("${disaddcartglass}")
	private String disGlass;
	
	@Value("${fName}")
	private String fName;	

	@Value("${lName}")
	private String lName;
	
	@Value("${company}")
	private String company;
	
	@Value("${address}")
	private String address;
	
	@Value("${address2}")
	private String address2;
	
	@Value("${city}")
	private String city;
	
	@Value("${province}")
	private String province;
	
	@Value("${postcode}")
	private String postcode;
	
	@Value("${phone}")
	private String phone;
	
	@Value("${option}")
	private String option;
	
	@Value("${displaceorder}")
	private String disPlaceOrder;
	
	@Value("${country}")
	private String country;
	

	public String getCountry() {
		return country;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getPhone() {
		return phone;
	}

	public String getOption() {
		return option;
	}

	public String getDisPlaceOrder() {
		return disPlaceOrder;
	}

	public String getShoes() {
		return shoes;
	}

	public String getDisShoes() {
		return disShoes;
	}

	public String getSunglass() {
		return sunglass;
	}

	public String getDisGlass() {
		return disGlass;
	}

	public String getDisplayLogin() {
		return displayLogin;
	}

	public String getDisplayRegister() {
		return displayRegister;
	}

	public String getBrowser() {
		return browser;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	

}

