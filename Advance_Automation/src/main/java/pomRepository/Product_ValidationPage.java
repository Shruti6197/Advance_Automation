package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Product_ValidationPage {
	public Product_ValidationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void validate_product(WebDriver driver, String prodName) {
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
	/*	if(actData.contains(prodName)) {
			System.out.println("Product name is created");
		}
		else {
			System.out.println("Product name is not created");
		} */
		Assert.assertEquals(actData, prodName, "Product name is not created");
		System.out.println("Product name is created");
	}
}
