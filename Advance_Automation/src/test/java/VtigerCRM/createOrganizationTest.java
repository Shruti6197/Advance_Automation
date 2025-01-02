package VtigerCRM;

import org.testng.annotations.Test;
import GenericUtility.TestNG_BaseClass;
import GenericUtility.excelUtility;
import GenericUtility.javaUtility;
import pomRepository.CreateOragnizationPage;
import pomRepository.OrgLookUp;
import pomRepository.Vtiger_HomePage;
import pomRepository.organizationValidatePage;

public class createOrganizationTest extends TestNG_BaseClass {
	@Test
	public void createOrganization() throws Throwable {
		
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.clickOrgLink();
		
		OrgLookUp look = new OrgLookUp(driver);
		look.click();
		Thread.sleep(3000);
		
		//To avoid the duplicate data
		javaUtility jUtility = new javaUtility();
		int ranNum = jUtility.RandomNumber();
		
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
		
		
	}
}
