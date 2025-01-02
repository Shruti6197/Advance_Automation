package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Campaign_ValidatePage {
	
	public Campaign_ValidatePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void validateCamp(WebDriver driver, String camName) {
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
	/*	if(actData.contains(camName)) {
			System.out.println("Campaign is created");
		}
		else {
			System.out.println("Campaign is not created");
		} */
		Assert.assertEquals(actData, camName, "Campaign is not created");
		System.out.println("Campaign is created");
	}
}
