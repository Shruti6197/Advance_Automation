package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_CampaignPage {
	
	// Initialization
	public Create_CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	// Element Declaration and getter method
	@FindBy(name = "campaignname")
	private WebElement campName;
	public WebElement getCampName() {
		return campName;
	}
	
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	@FindBy(css = "[title='Select']")
	private WebElement selectPlusImg;
	
	// Business Logic
	public void enterCampName(String name) {
		campName.sendKeys(name);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void clickPlusImg() {
		selectPlusImg.click();
	}
	
}
