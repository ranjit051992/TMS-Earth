package com.zycus.automation.tenanatCreation.bo;

import java.util.List;

public class Master
{
	private String					tableName;
	private String					displayName;
	private List<MasterStructure>	masterStructure;

	public String getTableName()
	{
		return tableName;
	}

	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public List<MasterStructure> getMasterStructure()
	{
		return masterStructure;
	}

	public void setMasterStructure(List<MasterStructure> masterStructure)
	{
		this.masterStructure = masterStructure;
	}

}
