package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdLookUp {
	public ProdLookUp(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "[title=\"Create Product...\"]")
	private WebElement prodLook;
	public WebElement getProdLook() {
		return prodLook;
	}
	
	public void clickProdLook() {
		prodLook.click();
	}
}
