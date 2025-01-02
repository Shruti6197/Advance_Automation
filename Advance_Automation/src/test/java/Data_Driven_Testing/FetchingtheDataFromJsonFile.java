package Data_Driven_Testing;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingtheDataFromJsonFile {

	public static void main(String[] args) throws Throwable {
		
		//Read the JSON file path where data has been stored
		File file = new File("./src/test/resources/jsonFile.json");
		
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);   //using this class to call the file path
		
		String BROWSER = data.get("browser").asText();
		String URL = data.get("url").asText();
		String USERNAME = data.get("username").asText();
		String PASSWORD = data.get("password").asText();
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
	}

}
