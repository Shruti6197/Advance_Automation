package VtigerCRM;

import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtility.TestNG_BaseClass;
import GenericUtility.excelUtility;
import GenericUtility.javaUtility;
import pomRepository.Create_ProductPage;
import pomRepository.ProdLookUp;
import pomRepository.Product_ValidationPage;
import pomRepository.Vtiger_HomePage;
import pomRepository.deleteProduct_Validate;
		
public class CreateProductandDeleteProductTest extends TestNG_BaseClass{
	
	@Test
	public void CreateProductandDeleteProduct() throws Throwable {
		
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.clickProdLink();
		
		ProdLookUp look = new ProdLookUp(driver);
		look.clickProdLook();
        
        // To Avoid the Duplicates
        javaUtility jutility = new javaUtility();
		int ranNum = jutility.RandomNumber();
		
		excelUtility EU = new excelUtility();
		String prdName = EU.getworkbookData("Product", 0, 0) + ranNum;
		System.out.println(prdName);
		
		Create_ProductPage Page = new Create_ProductPage(driver);
		Page.prodDetails(prdName);
		Page.getSaveButton();
	
		Thread.sleep(3000);
		Product_ValidationPage validate = new Product_ValidationPage(driver);
		//String actData = validate.validate_product(driver, prdName);
		validate.validate_product(driver, prdName);
		
		home.clickProdLink();
		
		deleteProduct_Validate delProd = new deleteProduct_Validate(driver);
		delProd.selectPrdCheckBox(driver, prdName);
		delProd.clickDeleteButton();
	
		//statement for handling the alert popup
		WDU.handlePopup(driver); 
		Thread.sleep(2000);
		String actData = delProd.validatePrdDeleted(driver, prdName);
		Assert.assertEquals(actData,prdName);		
		System.out.println("Product Deleted");
		Thread.sleep(2000);
	}
}
