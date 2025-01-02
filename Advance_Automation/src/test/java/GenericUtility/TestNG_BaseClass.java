package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pomRepository.LoginPage_Vtiger;
import pomRepository.Vtiger_HomePage;

public class TestNG_BaseClass {
	public WebDriver driver;
	public WebDriverUtility WDU = new WebDriverUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"regressionTest","sanityTest"})
	public void beforeSuiteAnn() {
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest (groups = {"regressionTest","sanityTest"})
	public void beforeTestAnn() {
		System.out.println("Parallel Execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass (groups = {"regressionTest","sanityTest"})
//	public void beforeClassAnn(String BROWSER ) throws IOException {
	public void beforeClassAnn() throws IOException {
		System.out.println("Launching the browser");
		fileUtility futility = new fileUtility();
		String BROWSER = futility.getKeyandValuePair("browser"); 
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver = driver;
	}
	
//	@Parameters({"URL","USERNAME","PASSWORD"})   //Using this only for parallel execution
	@BeforeMethod (groups = {"regressionTest","sanityTest"})
//	public void beforeMethodAnn(String URL, String USERNAME, String PASSWORD) throws Throwable {
	public void beforeMethodAn() throws Throwable {
		System.out.println("Login into the Application");
		fileUtility futility = new fileUtility();
		String URL = futility.getKeyandValuePair("url");
		String USERNAME = futility.getKeyandValuePair("username");
		String PASSWORD = futility.getKeyandValuePair("password");  

		WDU.maximizatheWindow(driver);
		WDU.waitfortheElement(driver);
		driver.get(URL);
		
		LoginPage_Vtiger login = new LoginPage_Vtiger(driver);
		login.LoginintoApplication(USERNAME, PASSWORD);
	}
	
	@AfterMethod (groups = {"regressionTest","sanityTest"})
	public void afterMethodAnn() {
		Vtiger_HomePage home = new Vtiger_HomePage(driver);
		home.logOut();
		System.out.println("Logout from the Application");
	}
	
	@AfterClass (groups = {"regressionTest","sanityTest"})
	public void afterClassAnn() {
		driver.close();
		System.out.println("close browser");
	}
	
	@AfterTest (groups = {"regressionTest","sanityTest"})
	public void afterTestAnn() {
		System.out.println("close parallel execution");
	}
	
	@AfterSuite (groups = {"regressionTest","sanityTest"})
	public void afterSuitAnn() {
		System.out.println("Close DataBase");
	}
}
