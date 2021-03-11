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
	
//	
//	String userName = null;
//	String password = null;
//	String FullName = null;
//	String CompanyName = null;
//	String Email = null;
//	String Phone = null;
//	String Address = null;
//	String City = null;
//	String State = null;
//	String Zip = null;
//	String Country = null;
	
	
	@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String FullName, String CompanyName, String Email, String Phone, String Address, String City, String State, String Zip, String Country) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardHeader();
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertfullName(FullName);;
		addCustomerPage.insertCompanyName(CompanyName);
		addCustomerPage.insertEmailAddress(Email);
		addCustomerPage.insertPhoneNumber(Phone);
		addCustomerPage.insertAddress(Address);
		addCustomerPage.insertCity(City);
		addCustomerPage.insertState(State);
		addCustomerPage.insertZip(Zip);
		addCustomerPage.enterCountryName(Country);
		addCustomerPage.clickSubmitButton();
		
		addCustomerPage.clickOnListCustomerButton();
		addCustomerPage.verifyEnteredName();
		
		BrowserFactory.tearDown();
		
	}

}
