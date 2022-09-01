package Test;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listerners implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("<a href=\"D:\\Selenium Training\\Screenshots\\screenshot.png\" target=\"_blank\">Screenshot link</a>");
		System.out.println("Successfully executed listerners.");
	}
	
	public void onTestFailure(ITestResult result)
	{
		Reporter.log("Test failed");
	}
}
