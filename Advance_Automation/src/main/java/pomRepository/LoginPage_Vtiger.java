package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Vtiger {
	
	// Initialization
	public LoginPage_Vtiger(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Element Declaration and getter method
	@FindBy(name = "user_name")
	private WebElement UserTextField;
	public WebElement getUserTextField() {
		return UserTextField;
	}

	@FindBy(name = "user_password")
	private WebElement PasswordTextField;
	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}
	
	@FindBy(id = "submitButton")
	private WebElement LoginButton;
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Business Logic
	/**
	 * This method is used to login into vtiger application
	 * @param username
	 * @param password
	 */
	public void LoginintoApplication(String username, String password) {
		UserTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		LoginButton.click();
	}
}
