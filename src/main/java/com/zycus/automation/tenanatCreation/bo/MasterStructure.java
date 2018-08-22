package com.zycus.automation.tenanatCreation.bo;

public class MasterStructure
{
	public String	columnName;
	public String	displayField;
	public String	fieldType;
	public String	fieldLength;
	public boolean	isRequired;

	public String getColumnName()
	{
		return columnName;
	}

	public void setColumnName(String columnName)
	{
		this.columnName = columnName;
	}

	public String getDisplayField()
	{
		return displayField;
	}

	public void setDisplayField(String displayField)
	{
		this.displayField = displayField;
	}

	public String getFieldType()
	{
		return fieldType;
	}

	public void setFieldType(String fieldType)
	{
		this.fieldType = fieldType;
	}

	public String getFieldLength()
	{
		return fieldLength;
	}

	public void setFieldLength(String fieldLength)
	{
		this.fieldLength = fieldLength;
	}

	public boolean isRequired()
	{
		return isRequired;
	}

	public void setRequired(boolean isRequired)
	{
		this.isRequired = isRequired;
	}

	public String getConstraint()
	{
		return constraint;
	}

	public void setConstraint(String constraint)
	{
		this.constraint = constraint;
	}

	public String constraint;

}
