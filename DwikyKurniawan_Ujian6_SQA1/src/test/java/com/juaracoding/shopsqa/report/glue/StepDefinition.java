package com.juaracoding.shopsqa.report.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.pages.AddToCart;
import com.juaracoding.pages.AddToCartCompare;
import com.juaracoding.pages.Checkout;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RegisterPage;
import com.juaracoding.shopqa.driver.DriverSingleton;
import com.juaracoding.shopsqa.config.AutomationFrameworkConfiguration;
import com.juaracoding.shopsqa.utils.ConfigurationProperties;
import com.juaracoding.shopsqa.utils.Constants;
import com.juaracoding.shopsqa.utils.TestCases;
import com.juaracoding.shopsqa.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {

	private WebDriver driver;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	private AddToCartCompare cartCompare;
	private AddToCart addCart;
	private Checkout checkout;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");
	
	@Autowired
	ConfigurationProperties configuration;
	
	@Before
	public void initializeObjects() {
	DriverSingleton.getInstance(configuration.getBrowser());
	registerPage = new RegisterPage();
	loginPage = new LoginPage();
	cartCompare = new AddToCartCompare();
	addCart = new AddToCart();
	checkout = new Checkout();
	TestCases[] tests = TestCases.values();
	extentTest = report.startTest(tests[Utils.testCount].getTestName());
	Utils.testCount++;
	}

	@Given("^User go to the website")
	public void goTOWebsite() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "User go to the website");
	}
	
	@When("^User click my account page button")
	public void goPageRegister() {
		registerPage.goMyAccount();
		extentTest.log(LogStatus.PASS, "User click my account page button");
	}
	
	@When("^User input username, email, and password to register")
	public void InputRegister() {
		registerPage.goRegister(configuration.getUsername(), configuration.getEmail(), configuration.getPassword());
		extentTest.log(LogStatus.PASS, "User input username, email, and password to register");
	}
	
	@Then("^User can register to the website")
	public void getDisplayRegister() {
		registerPage.getDisRegister();
		assertEquals(configuration.getDisplayRegister(), registerPage.getDisRegister());
		extentTest.log(LogStatus.PASS, "User can register to the website");
	}
	
	@When("^User input username and password to login")
	public void goToLogin() {
		loginPage.goLogin(configuration.getUsername(), configuration.getPassword());
		extentTest.log(LogStatus.PASS, "User input username and password to login");
	}
	
	@Then("^User can login to the website")
	public void getDisplayLogin() {
		loginPage.getDisLogin();
		assertEquals(configuration.getDisplayLogin(), loginPage.getDisLogin());
		extentTest.log(LogStatus.PASS, "User can login to the website");
	}
	
	@When("^User go to page search and input item")
	public void goSearchShoes() {
		cartCompare.goSearch(configuration.getShoes());
		extentTest.log(LogStatus.PASS, "User go to page search and input item");
	}
	
	@When("^User click compare page button")
	public void comparePage() {
		cartCompare.goPageCompare();
		extentTest.log(LogStatus.PASS, "User click compare page button");
	}
	
	@When("^User pick color, size, and then click add to cart button")
	public void CartFromCompare() {
		cartCompare.addToCart();
		extentTest.log(LogStatus.PASS, "User pick color, size, and then click add to cart button");
	}
	
	@Then("^User can add item to cart from compare page")
	public void getDisplayShoes() {
		cartCompare.getDisCart();
		assertEquals(configuration.getDisShoes(), cartCompare.getDisCart());
		extentTest.log(LogStatus.PASS, "User can add item to cart from compare page");
	}
	
	@When("^User go to page search and input glass")
	public void goSearchGlass() {
		addCart.goSearchGlass(configuration.getSunglass());
		extentTest.log(LogStatus.PASS, "User go to page search and input glass");
	}
	
	@When("^User choose sunglasses")
	public void chooseGlass() {
		addCart.chooseGlass();
		extentTest.log(LogStatus.PASS, "User choose sunglasses");
	}
	
	@When("^pick color, size, and then click add to cart button")
	public void CartGlass() {
		addCart.addToCart2();
		extentTest.log(LogStatus.PASS, "pick color, size, and then click add to cart button");
	}
	
	@Then("^User can add glass to cart")
	public void getDisplayGlass() {
		addCart.getDispGlass();
		assertEquals(configuration.getDisGlass(), addCart.getDispGlass());
		extentTest.log(LogStatus.PASS, "User can add glass to cart");
	}
	
	
	@When("^User go to page checkout")
	public void goCheckout() {
		checkout.goToCheckout();
		extentTest.log(LogStatus.PASS, "User go to page checkout");
	}
	
	@When("^User input data form")
	public void inputData() {
		checkout.goForm(configuration.getfName(), configuration.getlName(), configuration.getCompany(), configuration.getCountry(), configuration.getAddress(), configuration.getAddress2(), configuration.getCity(), configuration.getProvince(), configuration.getPostcode(), configuration.getPhone(), configuration.getEmail(), configuration.getOption());
		extentTest.log(LogStatus.PASS, "User input data form");
	}
	
	@When("^User click checkbox term&conditions, and then click place order button")
	public void ChekckboxTerms() {
		checkout.goPlaceOrder();	
		extentTest.log(LogStatus.PASS, "User click checkbox term&conditions, and then click place order button");
	}
	
	@Then("^User complete checkout item")
	public void getcompleteCheckout() {
		checkout.getDispPlaceOrder();
		assertEquals(configuration.getDisPlaceOrder(), checkout.getDispPlaceOrder());
		extentTest.log(LogStatus.PASS, "User complete checkout item");
	}
	@After
	public void CloseObject() {
		report.endTest(extentTest);
		report.flush();	
		
	}
}
