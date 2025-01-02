package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class organizationValidatePage {

		public organizationValidatePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public String validateOrganization(WebDriver driver,String OrgName) {
			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		/*	if (actData.contains(OrgName)) {
				System.out.println("Organization name is created");
			} else {
				System.out.println("Organization name is not created");
			} */
			Assert.assertEquals(actData, OrgName,"Organization name is not created");
			System.out.println("Organization name is created");
			return actData;
		}
	}
