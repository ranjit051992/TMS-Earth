package com.zycus.automation.bo;

public class LocationSettings
{
	String	locationName;
	String	changStatus;

	public String getLocationName()
	{
		return locationName;
	}

	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
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
		return "LocationSettings [locationName=" + locationName + ", changStatus=" + changStatus + "]";
	}

}
