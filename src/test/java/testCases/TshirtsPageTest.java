package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testBase.TestBase;
import testPages.HomePage;
import testPages.LoginPage;
import testPages.TshirtsPage;

public class TshirtsPageTest extends TestBase {

	HomePage homePage;
	TshirtsPage tshirtsPage;
	
	public TshirtsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialize();
		tshirtsPage = new TshirtsPage();
		homePage = new HomePage();
	}
	
	@Test
	public void AddToWishlist() {
		homePage.goToTshirtsPage();
		tshirtsPage.addToWishlist();
		String errorMsg = tshirtsPage.validateErrorMsg();
		Assert.assertEquals(errorMsg, "You must be logged in to manage your wishlist.");
	}
}
