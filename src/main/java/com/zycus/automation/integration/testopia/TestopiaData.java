package com.zycus.automation.integration.testopia;

public class TestopiaData
{

	private String	tcSummary;
	private boolean	tcResult;
	private String	tcName;
	private String	browserVersionID;

	public String getTcSummary()
	{
		return tcSummary;
	}

	public void setTcSummary(String tcSummary)
	{
		this.tcSummary = tcSummary;
	}

	public boolean isTcResult()
	{
		return tcResult;
	}

	public void setTcResult(boolean tcResult)
	{
		this.tcResult = tcResult;
	}

	public String getTcName()
	{
		return tcName;
	}

	public void setTcName(String tcName)
	{
		this.tcName = tcName;
	}

	public String getBrowserVersionID()
	{
		return browserVersionID;
	}

	public void setBrowserVersionID(String browserVersionID)
	{
		this.browserVersionID = browserVersionID;
	}

	@Override
	public String toString()
	{
		return "testopiaData [tcSummary=" + tcSummary + ", tcResult=" + tcResult + ", tcName=" + tcName + ", browserVersionID=" + browserVersionID + "]";
	}

}
