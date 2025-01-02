package VtigerCRM;

import org.testng.annotations.Test;

import GenericUtility.TestNG_BaseClass;
import GenericUtility.excelUtility;
import GenericUtility.javaUtility;
import pomRepository.CreateOragnizationPage;
import pomRepository.Create_ContactPage;
import pomRepository.OrgLookUp;
import pomRepository.Vtiger_HomePage;
import pomRepository.WindowSwitching;
import pomRepository.contactLookUp;
import pomRepository.contact_ValidationPage;
import pomRepository.organizationValidatePage;

public class CreateContactwithOrganizationTest extends TestNG_BaseClass {
	
	@Test
	public void CreateContactwithOrganizationTest() throws Throwable {
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.clickOrgLink();
		
		OrgLookUp look = new OrgLookUp(driver);
		look.click();
		
		// To Avoid the Duplicates
		javaUtility jutility = new javaUtility();
		int ranNum = jutility.RandomNumber();
		
		excelUtility EU = new excelUtility();
		String OrganizationName = EU.getworkbookData("OrganizationDetails", 5, 0) + ranNum;
		
		CreateOragnizationPage createOrg = new CreateOragnizationPage(driver);
		createOrg.enterOrgName(OrganizationName);
		
		//using dataformatter to convert the numbers into string
		String Phone = EU.handleDataFormatter("OrganizationDetails", 5, 1);
		createOrg.enterPhnNum(Phone);
		
		String email = EU.getworkbookData("OrganizationDetails", 5, 2);
		createOrg.enterEmailID(email);
		createOrg.clickButton();
		
		Thread.sleep(2000);
		organizationValidatePage orgVal = new organizationValidatePage(driver);
		orgVal.validateOrganization(driver, OrganizationName);
		
		home.clickContactLink();
		contactLookUp clook = new contactLookUp(driver);
		clook.click();
		
		excelUtility CEU = new excelUtility();
		String FirstName = CEU.getworkbookData("Contacts", 1, 0) + ranNum;
		
		Create_ContactPage contact = new Create_ContactPage(driver);
		contact.enterFirstName(FirstName);
		
		String LastName = CEU.getworkbookData("Contacts", 1, 1);
		contact.enterLastName(LastName);
		contact.clickPlusImg();
		System.out.println(FirstName+" "+LastName);
		
		WDU.switchWindow2(driver,"Accounts&action");
		
		WindowSwitching WS = new WindowSwitching(driver);
		WS.enterName(OrganizationName);
		WS.clickSearchBar();
		WS.selectOrgName(driver, OrganizationName);	
		
		WDU.switchWindow(driver,"Contacts&action");
		
		contact.clickButton();
		
		contact_ValidationPage CV = new contact_ValidationPage(driver);
		CV.contactValidate(driver, FirstName);
	}
}
