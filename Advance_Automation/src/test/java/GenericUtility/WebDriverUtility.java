package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	public void maximizatheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitfortheElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void switchWindow(WebDriver driver, String childWindow) {
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> it = allWins.iterator();
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains("Products&action")) {
				break;
			}
		}
	}
		
	public void handlePopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	//method to fetch the organization name for contact creation
	public void switchWindow2(WebDriver driver, String childWindow) {
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> it = allWins.iterator();
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains("Accounts&action")) {
				break;
			}
		}
	}
	
	public void screenshot() {
		TakesScreenshot ts = (TakesScreenshot)TestNG_BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/image.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String takeScreenShot1(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot takescreenShot = (TakesScreenshot)driver;
		File src = takescreenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+screenshotName +".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
}

