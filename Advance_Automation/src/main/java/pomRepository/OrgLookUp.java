package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUp {
	public OrgLookUp(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "[alt =\"Create Organization...\"]")
	private WebElement createOrg;
	public WebElement getCreateOrg() {
		return createOrg;
	}
	
	public void click() {
		createOrg.click();
	}
}
