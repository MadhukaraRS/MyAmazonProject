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
import pageObjects.RegistrationPageObject;
import pageObjects.SigninPageObject;
import results.ExtentResults;
import testData.TestDataReader;

/**
 * This class file contains Amazon Test scripts
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
		ExtentResults results = new ExtentResults();
		RegistrationPageObject register;
		
		
		@BeforeTest
		public void startBrowser() {
			driver = utilities.launchBrowser();
			wait = new WebDriverWait(driver, 30);
			signIn = new SigninPageObject(driver, wait);
			myAccount = new MyAccountPageObject(driver, wait);
			
		}
		
		@Test(groups= {"Sanity", "Smoke"},enabled = true)
		public void demoLogin() throws Exception {
		
		results.createtestcase(Thread.currentThread().getStackTrace()[1].getMethodName(), this.getClass().getSimpleName());
		
		signIn.getSignInText();
		signIn.getSignInLink();
		String signInTitle = driver.getTitle();  //Gets the window title
		results.assertEquals(signInTitle, TestDataReader.signInAssertion, TestDataReader.signInAssertionFailMessage);
		
				
		signIn.login(TestDataReader.email, TestDataReader.password);
		
		signIn.clickMyAccountPage();
		String myAccountText = myAccount.getPageTitle();
		results.assertEquals(myAccountText,TestDataReader.myAccountAssertion, TestDataReader.myAccountAssertionFailMessage);
		
		myAccount.clickSignOut();
		
	}

		


		@Test(groups = {"Regression"}, enabled = true) 
		public  void amazonAccountCreation() throws Exception {
			
		driver = utilities.launchBrowser();
		wait = new WebDriverWait(driver, 30);
		signIn = new SigninPageObject(driver, wait);
		register = new RegistrationPageObject(driver, wait);
		myAccount = new MyAccountPageObject(driver, wait);
		ExtentResults results = new ExtentResults();
		//RegistrationPageObject register;
		
		
		results.createtestcase(Thread.currentThread().getStackTrace()[1].getMethodName(), this.getClass().getSimpleName());
		
		signIn.getSignInText();
		signIn.getSignInLink();
		String signInTitle = driver.getTitle();  //Gets the window title
		results.assertEquals(signInTitle, TestDataReader.signInAssertion, TestDataReader.signInAssertionFailMessage);
		
		register.getClickAccountButton();
		register.getCreateAccountText();
		register.getCreateAccountForm();
		register.registration(TestDataReader.customerName, TestDataReader.phoneNumber, TestDataReader.customerPassword);
		register.clickContinueButton();
		register.clickCustomerMyAccountPage();
		
		
		}
		
		@AfterTest
		public void endBrowser() {
			//driver.close();
		}
}
