package testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyser implements IRetryAnalyzer{
	
	int failedCount = 0;
	int retryLimit = 4;
	public boolean retry(ITestResult result) {
		if(failedCount<retryLimit) {
			failedCount++;
			return true;
		}
		return false;
	}

}