package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingBrowserValueFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT-Advance.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		WebDriver driver;
		
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}

		driver.close();
	}
}
