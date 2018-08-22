package com.zycus.automation.bo;

public class TestResult
{
	private String	name				= null;
	private String	description			= null;
	private String	result				= null;
	private String	startTime			= null;
	private String	endTime				= null;
	private String	sheetName			= null;
	private String	browser				= null;
	private String	version				= null;
	private String	timeTakenByTestCase	= null;
	private String	module				= null;
	private String	nodeAddress			= null;
	private String	executionStatus		= null;

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public String isResult()
	{
		return result;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public String getSheetName()
	{
		return sheetName;
	}

	public String getBrowser()
	{
		return browser;
	}

	public String getVersion()
	{
		return version;
	}

	public String getTimeTakenByTestCase()
	{
		return timeTakenByTestCase;
	}

	public String getResult()
	{
		return result;
	}

	public String getModule()
	{
		return module;
	}

	public String getNodeAddress()
	{
		return nodeAddress;
	}

	public String getExecutionStatus()
	{
		return executionStatus;
	}

	public TestResult(String name, String description, String result, String startTime, String endTime, String sheetName, String browser, String version,
		String timeTakenByTestCase, String module, String nodeAddress, String executionStatus)
	{
		super();
		this.name = name;
		this.description = description;
		this.result = result;
		this.startTime = startTime;
		this.endTime = endTime;
		this.sheetName = sheetName;
		this.browser = browser;
		this.version = version;
		this.timeTakenByTestCase = timeTakenByTestCase;
		this.module = module;
		this.nodeAddress = nodeAddress;
		this.executionStatus = executionStatus;
	}

}