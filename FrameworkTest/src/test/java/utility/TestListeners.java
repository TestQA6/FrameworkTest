package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListeners implements ITestListener,ISuiteListener {
	Screenshots ss = new Screenshots();

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		Reporter.log("on start suite"+ arg0.getName(), true);
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		Reporter.log("onFinish suite"+ arg0.getName(), true);

	}

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Executing test"+ arg0.getName(), true);
		
	}

	public void onTestSuccess(ITestResult arg0) {
		Object currentClass = arg0.getInstance();
        WebDriver driver =  ((tests.Login_Test)currentClass).getDriver();
        try {
			ss.takeScreenshot(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
        printTestResults(arg0);
	}

	public void onTestFailure(ITestResult arg0) {
		Object currentClass = arg0.getInstance();
		WebDriver driver = ((tests.Login_Test)currentClass).getDriver();
		try {
			ss.takeScreenshot(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
        printTestResults(arg0);

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("About to begin executing all tests"+ arg0.getName(), true);
		
	}

	public void onFinish(ITestContext arg0	) {
		Reporter.log("Completed executing all tests"+ arg0.getName(), true);
		
	}
	private void printTestResults(ITestResult result) {
		Reporter.log("Test Method resides in "
				+ result.getTestClass().getName(), true);

		String status = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "Pass";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
		}
		Reporter.log("Test Status: " + status, true);
	}

}
