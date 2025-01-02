/* Test Case:
 * Login to vtiger application->mouseOverOn more Link
 * ->click on campaigns->click on create campaign lookup image
 * ->Enter campaignName
 * ->Create campaign with Product
 * ->click on save Btn
 * ->verify whether the campaign is created in campaign Information page and Logout from the application. 
 */

package VtigerCRM;


import org.testng.annotations.Test;
import GenericUtility.TestNG_BaseClass;
import GenericUtility.WebDriverUtility;
import GenericUtility.excelUtility;
import GenericUtility.fileUtility;
import GenericUtility.javaUtility;
import pomRepository.CampLookUp;
import pomRepository.Campaign_ValidatePage;
import pomRepository.Create_CampaignPage;
import pomRepository.Create_ProductPage;
import pomRepository.LoginPage_Vtiger;
import pomRepository.ProdLookUp;
import pomRepository.Product_ValidationPage;
import pomRepository.Vtiger_HomePage;
import pomRepository.WindowSwitching;

public class CreateCampaignsWithProductTest extends TestNG_BaseClass {
	
	@Test(groups = "regressionTest")
	public void CreateCampaignsWithProduct() throws Throwable {
		
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.clickProdLink();
		
		ProdLookUp look = new ProdLookUp(driver);
		look.clickProdLook();

		// To Avoid the Duplicates
		javaUtility jutility = new javaUtility();
		int ranNum = jutility.RandomNumber();
		
		excelUtility EU = new excelUtility();
		String prdName = EU.getworkbookData("Product", 0, 0)+ ranNum;
		
		Create_ProductPage pp = new Create_ProductPage(driver);
		pp.prodDetails(prdName);
		System.out.println(prdName);
		
		Product_ValidationPage validate1 = new Product_ValidationPage(driver);
		validate1.validate_product(driver, prdName);
		
		home.selectCamp();
		CampLookUp clook = new CampLookUp(driver);
		clook.clickCampLook();
		
		String camName = EU.getworkbookData("Campaign", 0, 0) + ranNum;
		Create_CampaignPage cp = new Create_CampaignPage(driver);
		cp.enterCampName(camName);
		cp.clickPlusImg();
		System.out.println(camName);
		
		WDU.switchWindow(driver, "Products&action");

		WindowSwitching ws = new WindowSwitching(driver);
		ws.enterName(prdName);
		ws.clickSearchBar();
		ws.selectProdName(driver, prdName);
		
		WDU.switchWindow(driver, "Campaigns*action");
		
		cp.clickSaveButton();
		
		Campaign_ValidatePage validate = new Campaign_ValidatePage(driver);
		validate.validateCamp(driver, camName);
	}
}
 
