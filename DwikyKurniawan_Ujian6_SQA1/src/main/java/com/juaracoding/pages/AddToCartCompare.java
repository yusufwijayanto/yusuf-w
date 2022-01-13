package com.juaracoding.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.shopqa.driver.DriverSingleton;

public class AddToCartCompare {
private WebDriver driver;
	
	public AddToCartCompare() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='noo-search']")
	WebElement btnSearch;
	
	@FindBy(css = "#noo-site > header > div.search-header.search-header-eff > div.noo-container > form > input.form-control")
	WebElement inpuSearch;
	
	@FindBy(css = "#product-1301 > div.single-product-content > div.summary.entry-summary > a")
	WebElement btnCompare;
	
	@FindBy(css = "#cboxLoadedContent > iframe")
	WebElement iframeCompare;
	
	@FindBy(xpath = "//a[@aria-label='Select options for “nude clear ankle strap court shoes”']")
	WebElement btnCartInCompare;
	
	@FindBy(xpath = "//select[@id='pa_color']")
	WebElement pickColor;
	
	@FindBy(xpath = "//*[@id=\"pa_size\"]//*[@class=\"attached enabled\"]")
	List<WebElement> lstSize;
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	WebElement btnAddCart;
	
	@FindBy(xpath = "//div[@class=\"woocommerce-message\"]/a")
	WebElement txtDisCart;
	
	public void goSearch(String shoes) {
		btnSearch.click();
		inpuSearch.sendKeys(shoes, Keys.ENTER);
	}
	
	public void goPageCompare() {
		btnCompare.click();
		driver.switchTo().frame(iframeCompare);
		btnCartInCompare.click();
	}
	
	public void addToCart() {
		pickColor.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		lstSize.get(2).click();
		btnAddCart.click();
	}
	
	public String getDisCart() {
		return txtDisCart.getText();
	}
}
