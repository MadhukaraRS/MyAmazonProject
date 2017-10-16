package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class file contains Generic methods 
 * @author Madhukara R S
 *
 */
public class GenericMethods {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public GenericMethods(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clickByXpath(String xpath, String message) throws Exception {
		
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			throw new Exception(message);
		}
	}
	
	public String getTextByXpath(String xpath, String message) throws Exception {
		
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			return driver.findElement(By.xpath(xpath)).getText();
			
		} catch (Exception e) {
			throw new Exception(message);
		}
	}
	
	public void enterBYXpath (String xpath, String value, String message) throws Exception {
		
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).sendKeys(value);
			} catch (Exception e) {
			throw new Exception(message);
		}
	}
	
	public void enterById (String id, String value, String message) throws Exception {
		
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(id)));
			driver.findElement(By.id(id)).sendKeys(value);
			} catch (Exception e) {
			throw new Exception(message);
		}
	}
	
	public void mouseHoverByXpath(String xpath, String message) throws Exception {
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement element = driver.findElement(By.xpath(xpath));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		}catch (Exception e) {
			throw new Exception(message);
		}
	}

	public void enterById(String id, String message) throws Exception {
		
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(id)));
			driver.findElement(By.id(id));
			} catch (Exception e) {
			throw new Exception(message);
		}
		
	}
	
	
}

	
		

	
	


