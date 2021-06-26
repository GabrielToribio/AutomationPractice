package testPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class CheckoutPage extends TestBase{

	
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-default button-plus product_quantity_up']") WebElement UP_BUTTON;
	@FindBy(how = How.XPATH, using = "//select[@name='group_1']") WebElement SIZE_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//button[@name='Submit']") WebElement ADD_TO_CART_BUTTON;
	@FindBy(how = How.XPATH, using = "//a[@title='Proceed to checkout']") WebElement CHECKOUT_BUTTON;
	@FindBy(how = How.XPATH, using = "//span[text()='Proceed to checkout']") WebElement CHECKOUT_BUTTON_II;
	@FindBy(how = How.XPATH, using = "//button[@name='processAddress']") WebElement PROCESS_ADDRESS_BUTTON;
	@FindBy(how = How.XPATH, using = "//button[@name='processCarrier']") WebElement PROCESS_CARRIER_BUTTON;
	@FindBy(how = How.XPATH, using = "//input[@name='cgv']") WebElement TOS_CHECKER;
	@FindBy(how = How.XPATH, using = "//a[@class='bankwire']") WebElement BANKWIRE_BUTTON;
	@FindBy(how = How.XPATH, using = "//span[text()='I confirm my order']") WebElement ORDER_BUTTON;
	
	Actions act = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectQuantity() {
		UP_BUTTON.click();
	}
	
	public void selectSize() {
		Select selectSize = new Select(SIZE_DROPDOWN);
		selectSize.selectByVisibleText("M");
	}
	
	public void confirmChoice() {
		ADD_TO_CART_BUTTON.click();
	}
	
	public void goToCheckout() {
		CHECKOUT_BUTTON.click();
 		js.executeScript("scroll(0,500)");
		
		CHECKOUT_BUTTON_II.click();
	}
	
	public void checkOut() {
		PROCESS_ADDRESS_BUTTON.click();
		TOS_CHECKER.click();
		PROCESS_CARRIER_BUTTON.click();
	}
	
	public void selectPaymentMethod() {
		BANKWIRE_BUTTON.click();
	}
	
	public void confirmOrder() {
		ORDER_BUTTON.click();
	}
	
}
