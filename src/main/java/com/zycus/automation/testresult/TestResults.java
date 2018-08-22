package com.zycus.automation.testresult;

import java.util.Map;

public class TestResults
{
	private String				testCaseName			= null;
	private boolean				isSanityTC				= false;
	private String				parentTC				= null;
	private boolean				resultOfTC				= false;
	private Map<String, String>	testData				= null;
	private String				browser					= null;
	private String				version					= null;
	private Map<String, String>	statusoFChildTC			= null;
	private String				PASS					= "1";
	private String				FAIL					= "0";
	private String				exception				= null;
	private String				assertError				= null;
	private boolean				isPrerequisiteMethod	= false;
	private String				skipException			= null;
	private String				status					= null;
	private String				jiraId					= null;

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String stat)
	{
		this.status = stat;
	}

	public String getSkipException()
	{
		return skipException;
	}

	public void setSkipException(String skipException)
	{
		this.skipException = skipException;
	}

	public boolean isPrerequisiteMethod()
	{
		return isPrerequisiteMethod;
	}

	public void isPrerequisiteMethod(boolean isPrerequisiteMethod)
	{
		this.isPrerequisiteMethod = isPrerequisiteMethod;
	}

	public String getAssertError()
	{
		return assertError;
	}

	public void setAssertError(String assertError)
	{
		this.assertError = assertError;
	}

	private String	Summary				= null;
	private String	moduleName			= null;
	private String	usernameFromExcel	= null;
	private String	passwordFromExcel	= null;
	private String	nodeAddress			= null;
	private String	browserVersionID	= null;
	private String	linkToScreenShot	= null;

	public String getLinkToScreenShot()
	{
		return linkToScreenShot;
	}

	public void setLinkToScreenShot(String linkToScreenShot)
	{
		this.linkToScreenShot = linkToScreenShot;
	}

	public String getBrowserVersionID()
	{
		return browserVersionID;
	}

	public void setBrowserVersionID(String browserVersionID)
	{
		this.browserVersionID = browserVersionID;
	}

	public String getBrowser()
	{
		return browser;
	}

	public String getModuleName()
	{
		return moduleName;
	}

	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	public String getUsernameFromExcel()
	{
		return usernameFromExcel;
	}

	public void setUsernameFromExcel(String usernameFromExcel)
	{
		this.usernameFromExcel = usernameFromExcel;
	}

	public String getPasswordFromExcel()
	{
		return passwordFromExcel;
	}

	public void setPasswordFromExcel(String passwordFromExcel)
	{
		this.passwordFromExcel = passwordFromExcel;
	}

	public String getNodeAddress()
	{
		return nodeAddress;
	}

	public void setNodeAddress(String nodeAddress)
	{
		this.nodeAddress = nodeAddress;
	}

	public void setBrowser(String browser)
	{
		this.browser = browser;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public Map<String, String> getTestData()
	{
		return testData;
	}

	public void setTestData(Map<String, String> testDatas)
	{
		this.testData = testDatas;
	}

	public String getSummary()
	{
		return Summary;
	}

	public void setSummary(String summary)
	{
		this.Summary = summary;
	}

	public String getTestCaseName()
	{
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName)
	{
		this.testCaseName = testCaseName;
	}

	public boolean getIsSanityTC()
	{
		return isSanityTC;
	}

	public void setIsSanityTC(boolean isSanityTC)
	{
		this.isSanityTC = isSanityTC;
	}

	public String getParentTC()
	{
		return parentTC;
	}

	public void setParentTC(String parentTC)
	{
		this.parentTC = parentTC;
	}

	public boolean getResultOfTC()
	{
		return resultOfTC;
	}

	public void setResultOfTC(boolean resultOfTC)
	{
		this.resultOfTC = resultOfTC;
	}

	public Map<String, String> getStatusoFChildTC()
	{
		return statusoFChildTC;
	}

	public void setStatusoFChildTC(Map<String, String> statusoFChildTC)
	{
		this.statusoFChildTC = statusoFChildTC;
	}

	public String getPASS()
	{
		return PASS;
	}

	public void setPASS(String pASS)
	{
		PASS = pASS;
	}

	public String getFAIL()
	{
		return FAIL;
	}

	public void setFAIL(String fAIL)
	{
		FAIL = fAIL;
	}

	public String getException()
	{
		return exception;
	}

	public void setException(String exception)
	{
		this.exception = exception;
	}

	@Override
	public String toString()
	{
		return "TestResults [testCaseName=" + testCaseName + ", isSanityTC=" + isSanityTC + ", parentTC=" + parentTC + ", resultOfTC=" + resultOfTC + ", testData=" + testData
			+ ", browser=" + browser + ", version=" + version + ", statusoFChildTC=" + statusoFChildTC + ", PASS=" + PASS + ", FAIL=" + FAIL + ", exception=" + exception
			+ ", Summary=" + Summary + ", moduleName=" + moduleName + ", usernameFromExcel=" + usernameFromExcel + ", passwordFromExcel=" + passwordFromExcel + ", nodeAddress="
			+ nodeAddress + ", browserVersionID=" + browserVersionID + "]";
	}

	public String getJiraId()
	{
		return jiraId;
	}

	public void setJiraId(String jiraId)
	{
		this.jiraId = jiraId;
	}

}
