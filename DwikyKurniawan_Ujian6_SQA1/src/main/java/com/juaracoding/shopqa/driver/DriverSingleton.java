package com.juaracoding.shopqa.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.juaracoding.shopsqa.driver.strategies.DriverStrategy;
import com.juaracoding.shopsqa.driver.strategies.DriverStrategyImplementor;

public class DriverSingleton {
	
	private static DriverSingleton instance = null;
	private static WebDriver driver;
	
	public DriverSingleton(String driver) {
		intantiate(driver);
	}
	
	public WebDriver intantiate(String strategy) {
		DriverStrategy driverstrategy = DriverStrategyImplementor.chooseStrategy(strategy);
		driver = driverstrategy.setStrategy();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static DriverSingleton getInstance(String driver) {
		if(instance == null) {
			instance = new DriverSingleton(driver);
		}
		return instance;
	}
	
	public static void closeObjectInstance() {
		instance=null;
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}
