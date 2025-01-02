/* Test Case:
 * Login to vtiger application->mouseOverOn more Link
 * ->click on campaigns->click on create campaign lookup image
 * ->Enter campaignName
 * ->click on save Btn
 * ->verify whether the campaign is created in campaign Information page and Logout from the application. 
 */

package VtigerCRM;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.TestNG_BaseClass;
import GenericUtility.excelUtility;
import GenericUtility.javaUtility;
import pomRepository.CampLookUp;
import pomRepository.Campaign_ValidatePage;
import pomRepository.Create_CampaignPage;
import pomRepository.Vtiger_HomePage;

//@Listeners(GenericUtility.Listener_Implementation.class)
public class createCampaignsTest extends TestNG_BaseClass{
	
	@Test(retryAnalyzer = GenericUtility.RetryConfig.class)
	public void createCampaigns() throws Throwable {
	
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.selectCamp();

		CampLookUp look = new CampLookUp(driver);
		look.clickCampLook();

		// To Avoid the Duplicate		
		javaUtility jutility = new javaUtility();
		int ranNum = jutility.RandomNumber();
		 
		excelUtility EU = new excelUtility();
		String camp_Name = EU.getworkbookData("Campaign", 0, 0) + ranNum;
		System.out.println(camp_Name);
	
		Create_CampaignPage camPage = new Create_CampaignPage(driver);
		camPage.enterCampName(camp_Name);
		camPage.clickSaveButton();
		
		Campaign_ValidatePage validate = new Campaign_ValidatePage(driver);
		validate.validateCamp(driver,camp_Name);		

	}
}
