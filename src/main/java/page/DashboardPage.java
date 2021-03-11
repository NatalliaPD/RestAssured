package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage{

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Lib

	@FindBy(how = How.XPATH, using = "//h2[contains(text(), ' Dashboard ')]")
	WebElement DASHBOARD_HEADER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement CUSTOMER_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMER_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_FIELD_LOCATOR;

	// Interactive Method
	public void validateDashboardHeader() {

		waitForElement(driver, 5, DASHBOARD_HEADER_FIELD);
		Assert.assertEquals(DASHBOARD_HEADER_FIELD.getText(), "Dashboard", "Dashboard page not found!!");
	}

	public void clickOnCustomerButton() {
		CUSTOMER_FIELD_LOCATOR.click();
	}

	public void clickOnAddCustomerButton() {
		waitForElement(driver, 3, ADD_CUSTOMER_FIELD_LOCATOR);
		ADD_CUSTOMER_FIELD_LOCATOR.click();
	}
	
	public void clickOnListCustomerButton() {
		LIST_CUSTOMER_FIELD_LOCATOR.click();
	}

}
