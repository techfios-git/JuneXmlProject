package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	
	WebDriver driver;
	
	
/*	String userName = null;
	String password = null;
	String name = null;
	String company = null;
	String email = null;
	String phoneNum = null;
	String address = null;
	String city = null;
	String state = null;
	String zip = null;
	String country = null;*/
	
	//@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void userShouldBeAbleToCreateNewCustomer(String userName, String password, String name, String company, String email, String phoneNum, String address, String city,String country, String state, String zip) throws InterruptedException {
		
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validateDashboard();
		
		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.clickOnCustomerButton();
		addCustomer.clickOnAddCustomerButton();
		addCustomer.enterName(name);
		addCustomer.enterCompanyName(company);
		addCustomer.enterEmail(email);
		addCustomer.enterPhoneNumber(phoneNum);
		addCustomer.enterAddress(address);
		addCustomer.enterCity(city);
		addCustomer.enterState(state);
		addCustomer.enterZip(zip);
		addCustomer.enterCountryName(country);
		addCustomer.clickSubmitButton();
		
		addCustomer.clickListCustomersButton();
		addCustomer.verifyEnteredNameAndDelete();
		
		
		BrowserFactory.tearDown();
		
	}
	
	@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToAddCustomerFromListPageVerifySearch(String userName, String password, String name, String company, String email, String phoneNum, String address, String city,String country, String state, String zip) throws InterruptedException {
		
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validateDashboard();
		
		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		
		addCustomer.clickOnCustomerButton();
		addCustomer.clickListCustomersButton();
		addCustomer.clickOnAddCustomerButtonOnListCustomerPage();
		
		addCustomer.enterName(name);
		addCustomer.enterCompanyName(company);
		addCustomer.enterEmail(email);
		addCustomer.enterPhoneNumber(phoneNum);
		addCustomer.enterAddress(address);
		addCustomer.enterCity(city);
		addCustomer.enterState(state);
		addCustomer.enterZip(zip);
		addCustomer.enterCountryName(country);
		addCustomer.clickSubmitButton();
		
		addCustomer.clickListCustomersButton();
		addCustomer.testSearchBarOnListCustomerPage();
		addCustomer.verifyEnteredNameAndCheckView();
		
		
		//BrowserFactory.tearDown();
		
	}

}
