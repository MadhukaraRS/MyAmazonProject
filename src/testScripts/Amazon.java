package testScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraries.ProjectSpecificMethods;
import libraries.Utilities;
import pageObjects.MyAccountPageObject;
import pageObjects.SigninPageObject;
import testData.TestDataReader;

/**
 * This class file contains Test scripts
 * @author Madhukara R S
 */
public class Amazon {

		public static int i =0;
		WebDriver driver;
		WebDriverWait wait;
		Utilities utilities = new Utilities();
		SigninPageObject signIn;
		MyAccountPageObject myAccount;
		ProjectSpecificMethods projectSpecificMethods;
			
		
		
		@BeforeTest
		public void startBrowser() {
			driver = utilities.launchBrowser();
			wait = new WebDriverWait(driver, 30);
			signIn = new SigninPageObject(driver, wait);
			myAccount = new MyAccountPageObject(driver, wait);
			
		}
		
		@Test(enabled = true)
		public void webdriverCommands() throws Exception {
		
		signIn.getSignInText();
		signIn.getSignInLink();
		String signInTitle = driver.getTitle();  //Gets the window title
		Assert.assertEquals(signInTitle, TestDataReader.signInAssertion, TestDataReader.signInAssertionFailMessage);
		
				
		signIn.login(TestDataReader.email, TestDataReader.password);
		
		String myAccountText = myAccount.getPageTitle();
		Assert.assertEquals(myAccountText,TestDataReader.myAccountAssertion, TestDataReader.myAccountAssertionFailMessage);
		
		myAccount.clickSignOut();
		
	}

		@AfterTest
		public void endBrowser() {
			
		}
}
