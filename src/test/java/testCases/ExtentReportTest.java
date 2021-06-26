package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTest {

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		extent.createTest("MyFirstTest")
		  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extent.flush();
	}
	
}
