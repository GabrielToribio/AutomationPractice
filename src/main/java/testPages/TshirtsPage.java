package testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class TshirtsPage extends TestBase{

	@FindBy(how = How.XPATH, using = "//a[@title='View']") WebElement MORE_BUTTON;
	@FindBy(how = How.XPATH, using = "//a[@class='addToWishlist wishlistProd_1']") WebElement WISHLIST_BUTTON;
	@FindBy(how = How.XPATH, using = "//p[@class='fancybox-error']") WebElement WISHLIST_ERROR;
	@FindBy(how = How.XPATH, using = "//div[@class='product-container']") WebElement PRODUCT_CONTAINER;
	
	public TshirtsPage() {
		PageFactory.initElements(driver, this);
	}
	
	Actions act = new Actions(driver);
	
	public void selectProduct() {
		act.moveToElement(PRODUCT_CONTAINER).build().perform();
		MORE_BUTTON.click();
	}
	
	public void addToWishlist() {
		act.moveToElement(PRODUCT_CONTAINER).build().perform();
		WISHLIST_BUTTON.click();		
	}
	
	public String validateErrorMsg() {
		return WISHLIST_ERROR.getText();
	}
	
}
