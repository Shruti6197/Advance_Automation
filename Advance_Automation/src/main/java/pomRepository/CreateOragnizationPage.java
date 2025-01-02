package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOragnizationPage {
	public CreateOragnizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "accountname")
	private WebElement username;
	
	@FindBy(id = "phone")
	private WebElement userphone;
	
	@FindBy(id= "email1")
	private WebElement usermail;
	
	@FindBy(name = "button")
	private WebElement createOrgbutton;

	public void enterOrgName(String name) {
		username.sendKeys(name);
	}
	
	public void enterPhnNum(String no) {
		userphone.sendKeys(no);
	}
	
	public void enterEmailID(String email) {
		usermail.sendKeys(email);
	}
	
	public void enterOrgDetails(String name, String number, String mail) {
		username.sendKeys(name);
		userphone.sendKeys(number);
		usermail.sendKeys(mail);
	}
	
	public void clickButton() {
		createOrgbutton.click();
	}
}
