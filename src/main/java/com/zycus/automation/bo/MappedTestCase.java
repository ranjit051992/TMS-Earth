/**
 * 
 */
package com.zycus.automation.bo;

import java.util.Map;

/**
 * @author puneet.sharma
 *
 */
public class MappedTestCase
{
	// REGRESSION-TESTCASE-NAME TEST-SENARIO MODULE-NAME EXECUTION TestData
	// Comments

	private String				testCaseName;
	private String				description;
	private String				moduleName;
	private boolean				execution;
	private Map<String, String>	testData;
	private boolean				testResult;
	private boolean				testSkipped		= true;
	private String				error			= null;
	private AssertionError		assertionError	= null;
	private String				jiraId			= null;

	public String getJiraId()
	{
		return jiraId;
	}

	public void setJiraId(String jiraId)
	{
		this.jiraId = jiraId;
	}

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}

	public AssertionError getAssertionError()
	{
		return assertionError;
	}

	public void setAssertionError(AssertionError assertionError)
	{
		this.assertionError = assertionError;
	}

	public boolean isTestSkipped()
	{
		return testSkipped;
	}

	public void setTestSkipped(boolean testSkipped)
	{
		this.testSkipped = testSkipped;
	}

	public boolean isTestResult()
	{
		return testResult;
	}

	public void setTestResult(boolean testResult)
	{
		this.testResult = testResult;
		this.testSkipped = false;
	}

	public MappedTestCase()
	{
		super();
	}

	public final String getTestCaseName()
	{
		return testCaseName;
	}

	public final void setTestCaseName(String testCaseName)
	{
		this.testCaseName = testCaseName;
	}

	public final String getDescription()
	{
		return description;
	}

	public final void setDescription(String description)
	{
		this.description = description;
	}

	public final String getModuleName()
	{
		return moduleName;
	}

	public final void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	public final boolean isExecution()
	{
		return execution;
	}

	public final void setExecution(boolean execution)
	{
		this.execution = execution;
	}

	public final Map<String, String> getTestData()
	{
		return testData;
	}

	public final void setTestData(Map<String, String> testData)
	{
		this.testData = testData;
	}

	public MappedTestCase(String testCaseName, String description, String moduleName, boolean execution, Map<String, String> testData)
	{
		super();
		this.testCaseName = testCaseName;
		this.description = description;
		this.moduleName = moduleName;
		this.execution = execution;
		this.testData = testData;
	}

	@Override
	public String toString()
	{
		return "MappedTestCase [testCaseName=" + testCaseName + ", description=" + description + ", moduleName=" + moduleName + " jiraId = " + jiraId + ", execution=" + execution
			+ ", testData=" + testData + "]";
	}

}
