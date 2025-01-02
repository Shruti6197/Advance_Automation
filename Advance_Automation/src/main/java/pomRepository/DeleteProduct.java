package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteProduct {
	public DeleteProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "[value=\"Delete\"]")
	private WebElement deleteProd;
	
	public void select_ProdName(WebDriver driver, String prdName) {
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='" + prdName
				+ "']/../preceding-sibling::td/input[@type=\"checkbox\"]")).click();
	}
	public void selectDeleteButton() {
		deleteProd.click();
	}
	public void Validate_Prod_Delete(WebDriver driver, String ProdName) {
		WebElement prd = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='\" + PrdName + \"']"));
	/*	if(prd.equals(PrdName)) {
			System.out.println("Product name is present");
		}
		else {
			System.out.println("Product name is not present");
		} */
		Assert.assertEquals(prd, ProdName,"Product name is not present");
		System.out.println("Product name is present");
	}
}
