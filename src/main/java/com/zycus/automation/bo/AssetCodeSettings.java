package com.zycus.automation.bo;

public class AssetCodeSettings
{
	String	assetCodeName;
	String	changeStatus;

	public String getAssetCodeName()
	{
		return assetCodeName;
	}

	public void setAssetCodeName(String assetCodeName)
	{
		this.assetCodeName = assetCodeName;
	}

	public String getChangeStatus()
	{
		return changeStatus;
	}

	public void setChangeStatus(String changeStatus)
	{
		this.changeStatus = changeStatus;
	}

	@Override
	public String toString()
	{
		return "AssetCodeSettings [assetCodeName=" + assetCodeName + ", changeStatus=" + changeStatus + "]";
	}

}
