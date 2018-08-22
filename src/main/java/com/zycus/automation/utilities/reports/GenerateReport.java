package com.zycus.automation.utilities.reports;

import com.zycus.automation.bo.TestResult;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.utilities.reports.excel.write.ExcelWriter;
import com.zycus.automation.utilities.utilitieshelpers.TimeFunctions;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

public class GenerateReport
{

	public static void startAddingTestCaseData(TestCase testCase)
	{
		if (ExcelWriter.isFileCreated() == false)
		{
			ExcelWriter.createExcel();
		}
		TestResult results = new TestResult(testCase.getTestMethodName(), testCase.getDescription(), null, TimeFunctions.getStartTime(), null,
			ExcelWriter.createSheetName(testCase), testCase.getBrowser(), testCase.getVersion(), null, testCase.getModuleName(), testCase.getNodeAddress(),
			IConstants.STATUS_RUNNING);
		ExcelWriter.writeData(results);
	}

	public void addTestCaseResult(TestCase testCase)
	{

	}
}