package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import testBase.TestBase;
import testPages.HomePage;


public class HomePageTest extends TestBase{

	HomePage homePage;

	public HomePageTest() {
		super();
	}
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
	ExtentTest test1 = extent.createTest("Go to Login Page");

	@BeforeMethod
	public void SetUp() {
		initialize();
		homePage = new HomePage();
	}
	
	@Test
	public void goToLoginPage() {
		extent.attachReporter(spark);
		test1.log(Status.INFO, "Starting Test Case");
		homePage.goToLoginPage();
		test1.pass("Navigated to login page");
		test1.info("Test Completed");
		extent.flush();
	}

}
