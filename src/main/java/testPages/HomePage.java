package testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase{

	@FindBy(how = How.XPATH, using = "//a[@class='login']") WebElement LOGIN_BUTTON;
	@FindBy(how = How.XPATH, using = "//a[@title='Women']") WebElement WOMENS_LINK;
	@FindBy(how = How.XPATH, using = "//a[@title='T-shirts']") WebElement TSHIRTS_LINK;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	Actions act = new Actions(driver);
	
	public void goToTshirtsPage() {
		act.moveToElement(WOMENS_LINK).build().perform();
		TSHIRTS_LINK.click();
	}
	
	public void goToLoginPage() {
		LOGIN_BUTTON.click();
	}
	
}
