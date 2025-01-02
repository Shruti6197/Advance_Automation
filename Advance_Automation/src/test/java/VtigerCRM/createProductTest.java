package VtigerCRM;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.TestNG_BaseClass;
import GenericUtility.excelUtility;
import GenericUtility.javaUtility;
import pomRepository.Create_ProductPage;
import pomRepository.ProdLookUp;
import pomRepository.Product_ValidationPage;
import pomRepository.Vtiger_HomePage;

@Listeners(GenericUtility.ExtendReportConfig.class)
public class createProductTest extends TestNG_BaseClass{
	
	@Test(groups = "sanityTest")
	public void createProduct() throws Throwable {
		
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
		
		Thread.sleep(2000);
		Product_ValidationPage validate = new Product_ValidationPage(driver);
		validate.validate_product(driver, Prod_Name);
		
	}
}
