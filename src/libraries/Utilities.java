package libraries;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

/**
 * This class file contains launch browser method
 * @author Madhukara R S
 */
public class Utilities {

public WebDriver launchBrowser() {
		
		// TODO Auto-generated method stub
	//Checking the OS and finding the directory
			if(System.getProperty("os.name").contains("Windows")){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver.exe");
				}
				else{
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver");	
				}
			
			WebDriver driver = new FirefoxDriver();    //Lunches Firefox browser
			Reporter.log("Firefox browser launched successfully", true);
			driver.get(Configurations.Url); //Launch the URL in the browser
			String title = driver.getTitle();    //Get the Window title
			Reporter.log("Window title is : "+ title, true);
			String url = driver.getCurrentUrl();
			Reporter.log("Windows URL is :"+ url, true);
			return driver;
		
		
	}
}
