package com.juaracoding.shopsqa.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

	public WebDriver setStrategy() {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Driver Firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		return driver;
	}
	
}
