package Listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzer_Example implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count = 0, retrylimit = 3;

		if (count < retrylimit) {
			count++;
			return true;
		} else
			return false;
	}

}
