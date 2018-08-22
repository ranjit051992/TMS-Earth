package com.zycus.framework.framework_version_2_4.listener;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class CustomRetryListener implements IRetryAnalyzer
{

	private Logger						logger				= Logger.getLogger(CustomRetryListener.class);
	private static int					RETRY_LIMIT			= Integer.parseInt(ConfigProperty.getConfig("RETRY_LIMIT"));

	public static Map<String, Integer>	methodRetryCountMap	= new HashMap<String, Integer>();

	@Override
	public boolean retry(ITestResult testResult)
	{
		String testSuiteName = testResult.getTestContext().getSuite().getName();
		String retryMethodName = testResult.getMethod().getMethodName();

		String key = testSuiteName + "_" + retryMethodName;

		boolean retry = false;
		int currentCount = 1;
		if (methodRetryCountMap.containsKey(key))
		{
			currentCount = methodRetryCountMap.get(key);
			currentCount++;
		}
		if (RETRY_LIMIT < currentCount)
		{
			methodRetryCountMap.remove(key);
			retry = false;
			logger.info("Giving Up Method[" + retryMethodName + "] as Retry Limit Reached");
		}
		else
		{
			methodRetryCountMap.put(key, currentCount);
			retry = true;
			logger.info("Retring Method[" + retryMethodName + "], Retry Count :" + currentCount);
		}
		return retry;
	}
}
