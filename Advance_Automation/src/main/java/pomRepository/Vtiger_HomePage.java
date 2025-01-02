package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vtiger_HomePage {
	
	// Initialize
	public Vtiger_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Element Declaration and getter method for click on the links to open the campaign page
	@FindBy(linkText = "More")
	private WebElement moreLink;
	public WebElement getMoreLink() {
		return moreLink;
	}
	
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	public WebElement getCampLink() {
		return campLink;
	}
	
	// Element declaration for logout process
	@FindBy(css = "[src=\"themes/softed/images/user.PNG\"]")
	private WebElement admLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "Products")
	private WebElement prodLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	/**
	 * This method is used to select campaign module
	 */
	public void selectCamp() {
		moreLink.click();
		campLink.click();
	}
	
	/**
	 * This method is used to logout from application
	 */
	public void logOut() {
		admLink.click();
		signOutLink.click();
	}
	
	public void clickProdLink() {
		prodLink.click();
	}
	
	public void clickOrgLink() {
		orgLink.click();
	}
	
	public void clickContactLink() {
		contactLink.click();
	}
}
