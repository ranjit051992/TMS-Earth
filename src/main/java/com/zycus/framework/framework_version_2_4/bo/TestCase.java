package com.zycus.framework.framework_version_2_4.bo;

import java.util.Map;

/**
 * 
 * @author aryasindhu.sahu
 *
 */

public class TestCase
{

	private String				testMethodName		= null;
	private String				description			= null;
	private String				moduleName			= null;
	private boolean				execution			= false;
	private String				username			= null;
	private String				password			= null;
	private String				browser				= null;
	private String				version				= null;
	private Map<String, String>	testData			= null;
	private String				nodeAddress			= null;
	private String				browserVersionID	= null;
	private boolean				isSanityTC;
	private boolean				ResultOfTC;
	private String				exceptionMessage	= null;
	private String				className			= null;
	private String				jiraId				= null;
	private String				isCOATC				= null;
	private String				isTempTC			= null;

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public String getJiraId()
	{
		return jiraId;
	}

	public void setJiraId(String jiraId)
	{
		this.jiraId = jiraId;
	}

	public String getExceptionMessage()
	{
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage)
	{
		this.exceptionMessage = exceptionMessage;
	}

	public boolean isResultOfTC()
	{
		return ResultOfTC;
	}

	public void setResultOfTC(boolean resultOfTC)
	{
		ResultOfTC = resultOfTC;
	}

	public boolean isSanityTC()
	{
		return isSanityTC;
	}

	public void setSanityTC(boolean isSanityTC)
	{
		this.isSanityTC = isSanityTC;
	}

	public String getBrowserVersionID()
	{
		return browserVersionID;
	}

	public void setBrowserVersionID(String browserVersionID)
	{
		this.browserVersionID = browserVersionID;
	}

	public String getNodeAddress()
	{
		return nodeAddress;
	}

	public void setNodeAddress(String nodeAddress)
	{
		this.nodeAddress = nodeAddress;
	}

	public String getTestMethodName()
	{
		return testMethodName;
	}

	public void setTestMethodName(String testMethodName)
	{
		this.testMethodName = testMethodName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getModuleName()
	{
		return moduleName;
	}

	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	public boolean isExecution()
	{
		return execution;
	}

	public void setExecution(boolean execution)
	{
		this.execution = execution;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getBrowser()
	{
		return browser;
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

	public void setTestData(Map<String, String> testData)
	{
		this.testData = testData;
	}

	@Override
	public String toString()
	{
		return "TestCase [testMethodName=" + testMethodName + ", description=" + description + ", moduleName=" + moduleName + ", jiraId=" + jiraId + ", execution=" + execution
			+ ", username=" + username + ", password=" + password + ", browser=" + browser + ", version=" + version + ", testData=" + testData + ", nodeAddress=" + nodeAddress
			+ ", browserVersionID=" + browserVersionID + ", isSanityTC=" + isSanityTC + ", ResultOfTC=" + ResultOfTC + ", exceptionMessage=" + exceptionMessage + "]";
	}

	public String getIsCOATC()
	{
		return isCOATC;
	}

	public void setIsCOATC(String isCOATC)
	{
		this.isCOATC = isCOATC;
	}

	public String getIsTempTC()
	{
		return isTempTC;
	}

	public void setIsTempTC(String isTempTC)
	{
		this.isTempTC = isTempTC;
	}

}