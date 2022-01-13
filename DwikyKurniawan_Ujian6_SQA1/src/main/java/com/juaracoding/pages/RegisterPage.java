package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.shopqa.driver.DriverSingleton;

public class RegisterPage {

	private WebDriver driver;
	
	public RegisterPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy (css = "body > p > a")
	WebElement btnDismiss;
	
	@FindBy (css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(2) > a")
	WebElement btnMyAccount;
	
	@FindBy (id = "reg_username")
	WebElement txtRegUsername;
	
	@FindBy (id = "reg_email")
	WebElement txtRegEmail;
	
	@FindBy (id = "reg_password")
	WebElement txtRegPassword;
	
	@FindBy (css = "#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button")
	WebElement btnRegister;
	
	@FindBy (css = "#login > p.login.message")
	WebElement txtDisplayRegister;
	
	public void goMyAccount() {
		btnDismiss.click();
		btnMyAccount.click();
	}
	
	public void goRegister(String username, String email, String password) {
		txtRegUsername.sendKeys(username);
		txtRegEmail.sendKeys(email);
		txtRegPassword.sendKeys(password);
		btnRegister.click();
	}
	
	public String getDisRegister() {
		return txtDisplayRegister.getText();
	}
}
