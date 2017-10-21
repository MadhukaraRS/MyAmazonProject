package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import libraries.GenericMethods;
import results.ExtentResults;

public class RegistrationPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public RegistrationPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void registration(String customerName, String moblieNumb, String custPassword ) throws Exception {
		enterName(customerName);
		enterPhoneNumber(moblieNumb);
		enterCustomerPassword(custPassword);
		clickContinueButton();
	}
	
	public void getClickAccountButton() throws Exception {
		genericMethods.clickById("createAccountSubmit", "Fail - Create Account button did not clicked");
		Reporter.log("Sign in buttpn text is clicked", true);
	}
		
		
	public String getCreateAccountText( ) throws Exception {
		String text = genericMethods.getTextById("createAccountSubmit","FAIL - Create Account In text did not display");
		Reporter.log("Create Account buttpn text is:" +text, true);
		return text;
	}
	
	public void getCreateAccountForm( ) throws Exception {
		genericMethods.clickByXpath("//form[@id='ap_register_form']//h1[contains(text(), 'Create Account')]", 
										"Fail - Account Form did not displayed ");
		Reporter.log("Account Form is :", true);
	}
	
	public void enterName(String customerName ) throws Exception {
		genericMethods.enterById("ap_customer_name", customerName, "Fail - Name did not entered");
		Reporter.log("Name entered successfully", true);
	}
	
	public void enterPhoneNumber(String mobileNumb ) throws Exception {
		genericMethods.enterById("ap_phone_number", mobileNumb, "Fail - Mobile Number did not entered");
		Reporter.log("Mobile Number entered successfully", true);
	}
	
	
	public void enterCustomerPassword(String custPassword ) throws Exception {
		genericMethods.enterById("ap_password", custPassword,"Fail - Password did not entered"); 
		Reporter.log("Password entered successfully", true);
	}
	
	public void clickContinueButton() throws Exception {
		genericMethods.clickByXpath("//span[@id='auth-continue-announce']", "Fail - Continue Button did not clicked");
		Reporter.log("Continue Button did not clicked successfully", true);
	}
	
	
	
	public void clickCustomerMyAccountPage() throws Exception {
		genericMethods.clickById("//div[@class='a-box-inner']", "Fail - Verification  page did not displayed");
		Reporter.log("Verification Page displayed Successfully");
		
	}

	
}
