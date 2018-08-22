package com.zycus.framework.framework_version_2_4.bo;

public class TestCaseResult
{

	public static String	STATUS_PASS			= "PASS";
	public static String	STATUS_FAIL			= "FAIL";
	public static String	STATUS_SKIPPED		= "SKIP";

	private String			testMethodName		= null;
	private String			testClassName		= null;
	private String			testStatus			= null;
	private String			startedAt			= null;
	private String			endedAt				= null;
	private String			testParam			= null;
	private String			exceptionMessage	= null;
	private String			exceptionTrace		= null;
	private String			testDescription		= null;
	private String			mappedWith			= null;

	public String getMappedWith()
	{
		return mappedWith;
	}

	public void setMappedWith(String mappedWith)
	{
		this.mappedWith = mappedWith;
	}

	public String getTestDescription()
	{
		return testDescription;
	}

	public void setTestDescription(String testDescription)
	{
		this.testDescription = testDescription;
	}

	public String getTestMethodName()
	{
		return testMethodName;
	}

	public void setTestMethodName(String testMethodName)
	{
		this.testMethodName = testMethodName;
	}

	public String getTestStatus()
	{
		return testStatus;
	}

	public void setTestStatus(String testStatus)
	{
		this.testStatus = testStatus;
	}

	public String getStartedAt()
	{
		return startedAt;
	}

	public void setStartedAt(String startedAt)
	{
		this.startedAt = startedAt;
	}

	public String getEndedAt()
	{
		return endedAt;
	}

	public void setEndedAt(String endedAt)
	{
		this.endedAt = endedAt;
	}

	public String getTestParam()
	{
		return testParam;
	}

	public void setTestParam(String testParam)
	{
		this.testParam = testParam;
	}

	public String getExceptionMessage()
	{
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage)
	{
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionTrace()
	{
		return exceptionTrace;
	}

	public void setExceptionTrace(String exceptionTrace)
	{
		this.exceptionTrace = exceptionTrace;
	}

	public String getTestClassName()
	{
		return testClassName;
	}

	public void setTestClassName(String testClassName)
	{
		this.testClassName = testClassName;
	}

	@Override
	public String toString()
	{
		return "TestCaseResult [testMethodName=" + testMethodName + ", testClassName=" + testClassName + ", testStatus=" + testStatus + ", startedAt=" + startedAt + ", endedAt="
			+ endedAt + ", testParam=" + testParam + ", exceptionMessage=" + exceptionMessage + ", exceptionTrace=" + exceptionTrace + ", testDescription=" + testDescription
			+ ", mappedWith=" + mappedWith + "]";
	}

}
