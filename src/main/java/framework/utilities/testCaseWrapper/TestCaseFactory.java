package framework.utilities.testCaseWrapper;

import org.apache.log4j.Logger;

import framework.frameworkUtilies.testResult.TestReportingBO;
import framework.startup.Startup;

public class TestCaseFactory
{
	static Logger logger = Logger.getLogger(TestCaseFactory.class);

	public static TestReportingBO findTestCase(String testcaseName)
	{

		TestReportingBO testcase = new TestReportingBO();

		//String testCaseName = testcaseName.replace("-", "_");

		testcase = Startup.testMethodTestCaseMap.get(testcaseName);

		logger.info("\n \n ****************************************** AUTOMATION TESTCASE =>> " + testcase.getTestCaseName() + "*************************************************************" + "\n \t \t \t \t DESCRIPTION OF TESTCASE : " + testcase.getTestcaseDescription() + "\n \t \t \t \t JIRA IDs : " + testcaseName + "\n \t \t \t \t \n ******************************************************************************************************************************************" + "\n \n");
		return testcase;

	}

}
