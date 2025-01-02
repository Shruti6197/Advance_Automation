package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.excelUtility;
import GenericUtility.javaUtility;

public class DataProvider4 {
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
		
		javaUtility ju = new javaUtility();
		int ranNum = ju.RandomNumber();
		driver.findElement(By.name("accountname")).sendKeys(name+ranNum);
		driver.findElement(By.id("email1")).sendKeys(Email);
		driver.findElement(By.name("button")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src = \"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		excelUtility eu = new excelUtility();
		Object[][] values = eu.readDatafromDataProvider("DataProvider");
		return values;
	}
}
