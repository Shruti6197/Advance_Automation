package VtigerCRM;

import org.testng.annotations.Test;
import GenericUtility.TestNG_BaseClass;
import GenericUtility.excelUtility;
import GenericUtility.javaUtility;
import pomRepository.Create_ContactPage;
import pomRepository.Vtiger_HomePage;
import pomRepository.contactLookUp;
import pomRepository.contact_ValidationPage;


public class createContactTest extends TestNG_BaseClass {
	@Test
	public void createContact() throws Throwable {
	
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.clickContactLink();
		
		contactLookUp look = new contactLookUp(driver);
		look.click();
		Thread.sleep(3000);
		
		//To avoid the duplicate values
		javaUtility JU = new javaUtility();
		int ranNum = JU.RandomNumber();
		
		excelUtility EU = new excelUtility();
		String FirstName = EU.getworkbookData("Contacts", 3, 0) + ranNum;
		
		Create_ContactPage contact = new Create_ContactPage(driver);
		contact.enterFirstName(FirstName);
		
		String LastName = EU.getworkbookData("Contacts", 3, 1);
		contact.enterLastName(LastName);
		contact.clickButton();
		
		contact_ValidationPage validate = new contact_ValidationPage(driver);
		validate.contactValidate(driver, FirstName);
		
	}
}

