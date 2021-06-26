package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.TestBase;
import testPages.HomePage;
import testPages.LoginPage;
import testPages.RegisterPage;
import testUtil.TestUtil;

public class RegisterPageTest extends TestBase{
	RegisterPage registerPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public RegisterPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialize();
		loginPage = new LoginPage();
		homePage = new HomePage();
		registerPage = new RegisterPage();
	}
	
	@DataProvider
	public Object[][] DataCollector(){
		Object[][] data = TestUtil.getTestData(prop.getProperty("SheetName1"));
		return data;
	}
	
	@Test(dataProvider = "DataCollector")
	public void enterInformation(String email, String fname, String lname, String password, String address, String city, String state, String post, String country, String number, String alias) {
		homePage.goToLoginPage();
		loginPage.enterEmail(email);
		registerPage.enterPersonalInfo(fname, lname, password, "m");
		registerPage.enterAddress(address, city, state, post, country, number, alias);
	}
	
	@Test
	public void verifyError() {
		homePage.goToLoginPage();
		loginPage.enterEmail("gabriel.j.toribio@gmail.com");
		boolean errorMsg = registerPage.verifyErrorMessage();
		Assert.assertTrue(errorMsg);
	}
}
