package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitching {
	public WindowSwitching(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "search_text")
	private WebElement TextField;
	
	@FindBy(name = "search")
	private WebElement searchBar;
	
	/*@FindBy(name = "search_text")
	private WebElement orgTextField; */
	
	public void enterName(String name) {
		TextField.sendKeys(name);
	}
	
	public void clickSearchBar() {
		searchBar.click();
	}
	
	public void selectProdName(WebDriver driver, String prodName) {
		driver.findElement(By.xpath("//a[text()='" + prodName + "']")).click();
	}
	
	public void selectOrgName(WebDriver driver, String orgName) {
		driver.findElement(By.xpath("//a[text() = '" + orgName +"']")).click();
	}
}
