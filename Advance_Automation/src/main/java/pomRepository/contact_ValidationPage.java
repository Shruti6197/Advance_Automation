package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class contact_ValidationPage {
	public contact_ValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void contactValidate(WebDriver driver, String name) {
		String actData = driver.findElement(By.xpath("//span[@id = \"dtlview_First Name\"]")).getText();
	/*	if(actData.contains(name)) {
			System.out.println("Contact has created");
		}
		else {
			System.out.println("Contact hasn't created");
		} */
		Assert.assertEquals(actData, name, "Contact hasn't created");
		System.out.println("Contact has created");
	}
}
