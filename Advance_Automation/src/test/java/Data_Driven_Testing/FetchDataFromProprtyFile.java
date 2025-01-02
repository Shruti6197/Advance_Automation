package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataFromProprtyFile {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream("D:\\Qspider Automation\\DDT-Advance.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PSWD = p.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(UN);
		driver.findElement(By.id("password")).sendKeys(PSWD);
		driver.findElement(By.id("login-button")).click();
		
		driver.close();
	}

}
