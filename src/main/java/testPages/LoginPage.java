package testPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase{

	@FindBy(how = How.XPATH, using = "//input[@name='email_create']") WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement LOGIN_EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement LOGIN_BUTTON;
	@FindBy(how = How.XPATH, using = "//li[text()='Invalid email address.']") WebElement INVALID_EMAIL_MESSAGE;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		EMAIL_FIELD.sendKeys(email);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void login(String ColumnA, String ColumnD) {
		LOGIN_EMAIL_FIELD.sendKeys(ColumnA);
		PASSWORD_FIELD.sendKeys(ColumnD);
		LOGIN_BUTTON.click();
	}
	
	public String validateErrorMessage() {
		return INVALID_EMAIL_MESSAGE.getText();
	}
}
