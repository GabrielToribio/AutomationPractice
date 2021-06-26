package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testBase.TestBase;
import testPages.CheckoutPage;
import testPages.HomePage;
import testPages.LoginPage;
import testPages.TshirtsPage;

public class CheckoutPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TshirtsPage tshirtsPage;
	CheckoutPage checkoutPage;

	public CheckoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialize();
		loginPage = new LoginPage();
		homePage = new HomePage();
		checkoutPage = new CheckoutPage();		
	}
	
	@Test
	public void goToTshirtsPage() {
		homePage.goToLoginPage();
		loginPage.login("moeromoetsuke@gmail.com", "password");
		homePage.goToTshirtsPage();
	}
	
	@Test
	public void buySomething() {
		homePage.goToLoginPage();
		loginPage.login("moeromoetsuke@gmail.com", "password");
		homePage.goToTshirtsPage();
		tshirtsPage.selectProduct();
		checkoutPage.selectQuantity();
		checkoutPage.selectSize();
		checkoutPage.confirmChoice();
		checkoutPage.goToCheckout();
		checkoutPage.checkOut();
		checkoutPage.selectPaymentMethod();
	}
	
	
}
