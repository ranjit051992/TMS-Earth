package com.zycus.automation.bo;

public class BusinessUnitSettings
{
	String	BUName;
	String	changStatus;

	public String getBUName()
	{
		return BUName;
	}

	public void setBUName(String bUName)
	{
		BUName = bUName;
	}

	public String getChangStatus()
	{
		return changStatus;
	}

	public void setChangStatus(String changStatus)
	{
		this.changStatus = changStatus;
	}

	@Override
	public String toString()
	{
		return "BusinessUnitSettings [BUName=" + BUName + ", changStatus=" + changStatus + "]";
	}

}
