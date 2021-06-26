package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.TestBase;
import testPages.HomePage;
import testPages.LoginPage;
import testUtil.TestUtil;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialize();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@DataProvider
	public Object[][] DataCollector(){
		Object[][] data = TestUtil.getTestData(prop.getProperty("SheetName1"));
		return data;
	}
	
	@Test
	public void enterEmail(String email) {
		homePage.goToLoginPage();
		loginPage.enterEmail(email);
	}
	
	@Test(dataProvider = "DataCollector")
	public void login(String email, String password) {
		homePage.goToLoginPage();
		loginPage.login(email, password);
	}
	
	@Test
	public void enterWrongEmail() {
		homePage.goToLoginPage();
		loginPage.enterEmail("m");
		String errorMsg = loginPage.validateErrorMessage();
		Assert.assertEquals(errorMsg, "Invalid email address.");
	}
}
