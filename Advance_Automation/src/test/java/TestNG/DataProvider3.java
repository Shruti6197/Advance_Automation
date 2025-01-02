package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import GenericUtility.javaUtility;

public class DataProvider3 {
	@Test(dataProvider = "getData")
	public void createOrganization(String name, String Email) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("shruti");
		driver.findElement(By.id("submitButton")).click();
		
		//Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		//Thread.sleep(2000);
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("email1")).sendKeys(Email);
		driver.findElement(By.name("button")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src = \"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		javaUtility ju = new javaUtility();
		int ranNum = ju.RandomNumber();
		Object[][] obj = new Object[3][2];
		
		obj[0][0] = "AAA"+ranNum;
		obj[0][1] = "abc@gmail.com";
		
		obj[1][0] = "BBB"+ranNum;
		obj[1][1] = "chd@gmail.com";
		
		obj[2][0] = "CCC"+ranNum;
		obj[2][1] = "abasc@gmail.com";
		
		return obj;
	}
}
