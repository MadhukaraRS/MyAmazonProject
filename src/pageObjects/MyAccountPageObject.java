package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import libraries.GenericMethods;
import results.ExtentResults;
/**
 * This class file contains My Account page details
 * @author Madhukara R S
 *
 */
public class MyAccountPageObject {
	
	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public MyAccountPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	

	public String getPageTitle() throws Exception {
		return genericMethods.getTextByXpath("//div[@class='a-row a-spacing-base']", "FAIL - My Account page is not displayed");
		
	}
	
	public void clickSignOut() throws Exception {
		genericMethods.clickByXpath("//div[@class='a-row a-spacing-base']/h1", "FAIL - Sign Out Button Did not Click Successfully");
		Reporter.log("PASS - Sign Out Button Clicked Successfully", true);
	}																								
	
	

}
