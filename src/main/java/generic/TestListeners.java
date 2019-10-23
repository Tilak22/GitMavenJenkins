package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListeners implements ITestListener
{
	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest test;

	public void onFinish(ITestContext result) {
		report.flush();
		
	}

	public void onStart(ITestContext result) {
		reporter=new ExtentHtmlReporter("./report/Report"+System.currentTimeMillis()+".html");
		reporter.config().setDocumentTitle("Justice League");
		reporter.config().setReportName("superman");
		reporter.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("smoke testing", "regression testing");
		report.setSystemInfo("build", "22.13.00");
		report.setSystemInfo("Test environment", "windows 7/8/10");
		report.setSystemInfo("Tester", "Tilak.R");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, report.getClass().getName()+result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, report.getClass().getName()+result.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult result) 
	{
		test=report.createTest("Beta");
		test.log(Status.INFO, report.getClass().getName()+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, report.getClass().getName()+result.getMethod().getMethodName());
		
	}

}
