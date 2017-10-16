package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import libraries.GenericMethods;
/**
 * This class file contains Sign In Details of Amazon
 * @author Madhukara R S
 *
 */
public class SigninPageObject {
	
		WebDriver driver;
		WebDriverWait wait;
		GenericMethods genericMethods;
		
		public SigninPageObject(WebDriver driver, WebDriverWait wait) {
			this.driver = driver;
			this.wait = wait;
			genericMethods = new GenericMethods(driver, wait);
		}
		
		public void login(String email, String password) throws Exception {
			enterEmail(email);
			enterPassword(password);
			clickSignInButton();
		}
			
			
		public String getSignInText( ) throws Exception {
			String text = genericMethods.getTextByXpath("//a[@id='nav-link-yourAccount']","FAIL - Sign In text did not display");
			Reporter.log("Sign in buttpn text is:" +text, true);
			return text;
		}
		
		public void getSignInLink( ) throws Exception {
			genericMethods.clickByXpath("//a[@id='nav-link-yourAccount']", "FAIL - Sign In Link did not clicked" );
			Reporter.log("Sign in Link is clicked:", true);
		}
		
		public void enterEmail(String email ) throws Exception {
			genericMethods.enterBYXpath("//input[@id='ap_email']", email, "Fail - Email did not entered");
			Reporter.log("Email entered successfully", true);
		}
		
		public void enterPassword(String password ) throws Exception {
			genericMethods.enterBYXpath("//input[@id='ap_password']", password,"Fail - Password did not entered"); 
			Reporter.log("Password entered successfully", true);
		}
		
		public void clickSignInButton() throws Exception {
			genericMethods.clickByXpath("//input[@id='signInSubmit']", "FAIL -  Sign In button did not clicked" );
			Reporter.log("Password entered successfully", true);
		}
		

 
		

}
