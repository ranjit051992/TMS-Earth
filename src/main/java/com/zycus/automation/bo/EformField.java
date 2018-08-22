package com.zycus.automation.bo;

import java.util.List;

/**
 * @author bhakti.sawant
 *
 */
public class EformField
{
	private String			fieldName			= null;
	private String			fieldType			= null;
	private List<String>	checkBoxChoicesList	= null;

	public EformField()
	{
		super();
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}

	public String getFieldType()
	{
		return fieldType;
	}

	public void setFieldType(String fieldType)
	{
		this.fieldType = fieldType;
	}

	public EformField(String fieldName, String fieldType)
	{
		super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
	}

	public List<String> getCheckBoxChoicesList()
	{
		return checkBoxChoicesList;
	}

	public void setCheckBoxChoicesList(List<String> checkBoxChoicesList)
	{
		this.checkBoxChoicesList = checkBoxChoicesList;
	}

}
