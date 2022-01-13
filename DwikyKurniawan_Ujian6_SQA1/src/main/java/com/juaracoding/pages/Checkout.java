package com.juaracoding.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.shopqa.driver.DriverSingleton;

public class Checkout {
	WebDriver driver;
	
	public Checkout() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(3)")
	WebElement btnCheckout;
	
	@FindBy(id = "billing_first_name")
	WebElement txtFirstName;
	
	@FindBy(id = "billing_last_name")
	WebElement txtLastName;
	
	@FindBy(id = "billing_company")
	WebElement txtCompany;
	
	@FindBy(xpath = "//span[@id='select2-billing_country-container']")
	WebElement selectCountry;
	
	@FindBy(css = "body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement inputCountry;
	
	@FindBy(id = "billing_address_1")
	WebElement txtAddress;
	
	@FindBy(id = "billing_address_2")
	WebElement txtAddress2;
	
	@FindBy(id = "billing_city")
	WebElement txtCity;
	
	@FindBy(xpath = "//span[@id='select2-billing_state-container']")
	WebElement selectProvince;
	
	@FindBy(css = "body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement inputProvince;
	
	@FindBy(id = "billing_postcode")
	WebElement txtPostcode;
	
	@FindBy(id = "billing_phone")
	WebElement txtPhone;
	
	@FindBy(id = "billing_email")
	WebElement txtEmail;
	
	@FindBy(id = "order_comments")
	WebElement txtAdditionalInfo;
	
	@FindBy(xpath = "//input[@id='terms']")
	WebElement checkboxTerms;
	
	@FindBy(xpath = "//button[@id='place_order']")
	WebElement btnPlaceOrder;
	
	@FindBy(css = "#post-7 > div > div > div > p.woocommerce-thankyou-order-received")
	WebElement txtDisPlaceOrder;
	
	public void goToCheckout() {
		btnCheckout.click();
	}
	
	public void goForm(String fName, String lName, String company, String country, String address, String address2, String city,
			String province, String postcode, String phone, String email, String option) {
		txtFirstName.sendKeys(fName);
		txtLastName.sendKeys(lName);
		txtCompany.sendKeys(company);
		selectCountry.click();
		inputCountry.sendKeys(country, Keys.ENTER);
		txtAddress.sendKeys(address);
		txtAddress2.sendKeys(address2);
		txtCity.sendKeys(city);
		selectProvince.click();
		inputProvince.sendKeys(province, Keys.ENTER);
		txtPostcode.sendKeys(postcode);
		txtPhone.sendKeys(phone);
		txtEmail.sendKeys(Keys.CONTROL+"a",email);
		txtAdditionalInfo.sendKeys(option);
	}
	
	public void goPlaceOrder() {
		checkboxTerms.click();
		btnPlaceOrder.click();
	}
	
	public String getDispPlaceOrder() {
		return txtDisPlaceOrder.getText();
	}
}
