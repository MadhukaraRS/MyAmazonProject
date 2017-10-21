package testData;

import libraries.PropertiesReader;
/**
 * This class file contains Test Data Reader details
 * @author Madhukara R S
 *
 */
public class TestDataReader {
	
	private static PropertiesReader propertiesReader = new PropertiesReader();
	
	public static String email = propertiesReader.getUsername();
	public static String password = propertiesReader.getPassword();
	public static String signInAssertion = propertiesReader.getsignInAssertion();
	public static String signInAssertionFailMessage = propertiesReader.getsignInAssertionFailMessage();
	public static String myAccountAssertion = propertiesReader.getmyAccountAssertion();
	public static String myAccountAssertionFailMessage = propertiesReader.getmyAccountAssertionFailMessage();

	public static String customerName = propertiesReader.getCustomerName();
	public static String phoneNumber = propertiesReader.getPhoneNumber();
	public static String customerPassword = propertiesReader.getCustomerPassword();
	

}
