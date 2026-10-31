package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public static ExtentTest stest;
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtenReports/report.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ShopKart Report");
		spark.config().setReportName("Extent Report");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("JDK Version", System.getProperty("java.specification.version"));
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		stest = test;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName() + " Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName() + " Fail");
		test.fail(result.getThrowable());
		test.addScreenCaptureFromPath(Screenshot.captureScreenshot(BaseClass.sdriver));
	}
	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
