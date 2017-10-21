package libraries;

import java.io.File;
/**
 * This class file contains URL 
 * @author Madhukara R S
 *
 */
public class Configurations {
	
	public static String Url = "https://www.amazon.in/";
	public static String testDataPath = System.getProperty("user.dir")+File.separator+"src"+
			File.separator+"testData"+File.separator+"TestData";
	public static String resultsPath = System.getProperty("user.dir")+File.separator+"ExtentReports.html";
}

