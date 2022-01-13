package com.juaracoding.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.shopqa.driver.DriverSingleton;

public class AddToCart {

	WebDriver driver;
	
	public AddToCart() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='noo-search']")
	WebElement btnSearchGlass;
	
	@FindBy(css = "#noo-site > header > div.search-header.search-header-eff > div.noo-container > form > input.form-control")
	WebElement inputSearchGlass;
	
	@FindBy(xpath = "//div//*[@class=\"noo-product-inner\"]/h3")
	List<WebElement> lstGlass;
	
	@FindBy(xpath = "//*[@id=\"pa_color\"]//*[@class=\"attached enabled\"]")
	List<WebElement> lstColor;
	
	@FindBy(xpath = "//select[@id='pa_size']")
	WebElement pickSize;
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	WebElement btnAddCartGlass;
	
	@FindBy(xpath = "//div[@class=\"woocommerce-message\"]/a")
	WebElement txtDisGlass;
	
	public void goSearchGlass(String sunglass) {
		btnSearchGlass.click();
		inputSearchGlass.sendKeys(sunglass, Keys.ENTER);
	}
	
	public void chooseGlass() {
		lstGlass.get(2).click();
	}
	
	public void addToCart2() {
		lstColor.get(1).click();
		pickSize.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		btnAddCartGlass.click();
	}
	
	public String getDispGlass() {
		return txtDisGlass.getText();
	}
}
