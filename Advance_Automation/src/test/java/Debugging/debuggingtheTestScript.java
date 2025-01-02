package Debugging;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class debuggingtheTestScript {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SampleClass win = new SampleClass();
		win.maximizetheBrowser(driver);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("sneakers");
		Thread.sleep(5000);
		driver.close();
	}

}
