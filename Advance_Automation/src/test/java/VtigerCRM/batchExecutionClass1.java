package VtigerCRM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericUtility.TestNG_BaseClass;
import GenericUtility.excelUtility;
import GenericUtility.javaUtility;
import pomRepository.CampLookUp;
import pomRepository.Campaign_ValidatePage;
import pomRepository.Create_CampaignPage;
import pomRepository.Create_ProductPage;
import pomRepository.ProdLookUp;
import pomRepository.Product_ValidationPage;
import pomRepository.Vtiger_HomePage;
import pomRepository.WindowSwitching;

public class batchExecutionClass1 extends TestNG_BaseClass{
	@Test
	public void batchExecutionClass1() throws Throwable {
		WebDriver driver = null;
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.clickProdLink();
		
		ProdLookUp look = new ProdLookUp(driver);
		look.clickProdLook();
		
		//To avoid the duplicate value
		javaUtility ju = new javaUtility();
		int ranNum = ju.RandomNumber();
		
		excelUtility EU = new excelUtility();
		String Prod_Name = EU.getworkbookData("Product", 0, 0) + ranNum;
		
		Create_ProductPage PP = new Create_ProductPage(driver);
		PP.prodDetails(Prod_Name);
		System.out.println(Prod_Name);
		
		Product_ValidationPage validate = new Product_ValidationPage(driver);
		validate.validate_product(driver, Prod_Name);
		
	}
	
	@Test
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
		
		Campaign_ValidatePage validate = new Campaign_ValidatePage(driver);
		validate.validateCamp(driver,camp_Name);		

	}
	
	@Test
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
	
		Product_ValidationPage validate1 = new Product_ValidationPage(driver);
		validate1.validate_product(driver, prdName); 
	
	}

}
