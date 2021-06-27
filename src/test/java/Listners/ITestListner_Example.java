package Listners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListner_Example implements ITestListener {

	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started  " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success  " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failure  " + result.getName());
		TakesScreenshot ts = (TakesScreenshot) LoginPage.driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir") + "//screenshot//" + result.getName() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped  " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed but within success percentage  " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out
				.println("Invoked after the test class is instantiated and before any configuration method is called.  "
						+ context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Invoked after all the tests have run and all their Configuration methods have been called. "
				+ context.getName());
	}

}
