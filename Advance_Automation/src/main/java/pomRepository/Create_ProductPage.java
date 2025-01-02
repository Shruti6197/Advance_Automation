package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_ProductPage {
	public Create_ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "productname")
	private WebElement prdName;
	public WebElement getPrdName() {
		return prdName;
	}

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void prodDetails(String name) {
		prdName.sendKeys(name);
		saveButton.click();
	}
}
