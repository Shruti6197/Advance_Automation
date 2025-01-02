package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactLookUp {
	public contactLookUp(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "[title =\"Create Contact...\"]")
	private WebElement createContact;

	public WebElement getCreateContact() {
		return createContact;
	}
	
	public void click() {
		createContact.click();
	}
	
}
