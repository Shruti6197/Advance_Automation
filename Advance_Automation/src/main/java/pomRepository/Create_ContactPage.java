package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_ContactPage {
	public Create_ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement fname;
	
	@FindBy(name = "lastname")
	private WebElement lname;
	
	@FindBy(name = "button")
	private WebElement clickonButton;
	
	@FindBy(css = "[title='Select']")
	private WebElement selectPlusImg;
	
	public void enterFirstName(String fn) {
		fname.sendKeys(fn);
	}
	
	public void enterLastName(String ln) {
		lname.sendKeys(ln);
	}
	public void enterUserDetails(String fn, String ln) {
		fname.sendKeys(fn);
		lname.sendKeys(ln);
	}
	public void clickButton() {
		clickonButton.click();
	}
	public void clickPlusImg() {
		selectPlusImg.click();
	}
}
