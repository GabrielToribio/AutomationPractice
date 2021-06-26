package testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class RegisterPage extends TestBase{

	@FindBy(how = How.XPATH, using = "//input[@id='id_gender1']") WebElement TITLE_MR;
	@FindBy(how = How.XPATH, using = "//input[@id='id_gender2']") WebElement TITLE_MRS;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']") WebElement FIRST_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']") WebElement LAST_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='firstname']") WebElement A_FIRST_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='lastname']") WebElement A_LAST_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address1']") WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='postcode']") WebElement POSTAL_CODE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='phone_mobile']") WebElement MOBILE_NUMBER_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='alias']") WebElement ALIAS_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='id_state']") WebElement STATE_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//select[@id='id_country']") WebElement COUNTRY_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//button[@name='submitAccount']") WebElement SUBMIT_BUTTON;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']") WebElement ERROR_MESSAGE;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPersonalInfo(String ColumnB, String ColumnC, String ColumnD, String gender) {
		
		if (gender.equalsIgnoreCase("m")) {
			TITLE_MR.click();
		} else if (gender.equalsIgnoreCase("f")) {
			TITLE_MRS.click();
		}
		
		FIRST_NAME_FIELD.sendKeys(ColumnB);
		LAST_NAME_FIELD.sendKeys(ColumnC);
		PASSWORD_FIELD.sendKeys(ColumnD);
	}
	
	public void enterAddress(String ColumnE, String ColumnF, String ColumnG, String ColumnH, String ColumnI, String ColumnJ, String ColumnK) {
		
		ADDRESS_FIELD.sendKeys(ColumnE);
		CITY_FIELD.sendKeys(ColumnF);
		POSTAL_CODE_FIELD.sendKeys(ColumnG);
		MOBILE_NUMBER_FIELD.sendKeys(ColumnH);
		ALIAS_FIELD.clear();
		ALIAS_FIELD.sendKeys(ColumnK);
		Select selectState = new Select(STATE_DROPDOWN);
		Select selectCountry = new Select(COUNTRY_DROPDOWN);
		
		selectState.selectByVisibleText(ColumnI);
		selectCountry.selectByVisibleText(ColumnJ);
		
//		SUBMIT_BUTTON.click();
	}
	
	public boolean verifyErrorMessage() {
		SUBMIT_BUTTON.click();
		return ERROR_MESSAGE.isDisplayed();
	}
}
