package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.shopqa.driver.DriverSingleton;

public class LoginPage {
private WebDriver driver;
	
	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy (id = "user_login")
	WebElement txtUsername;
	
	@FindBy (id = "user_pass")
	WebElement txtPassword;
	
	@FindBy (id = "wp-submit")
	WebElement btnLogin;
	
	@FindBy (css = "#post-8 > div > div > div > p:nth-child(2)")
	WebElement txtDisplayLogin;
	
	public void goLogin(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getDisLogin() {
		return txtDisplayLogin.getText();
	}
}

