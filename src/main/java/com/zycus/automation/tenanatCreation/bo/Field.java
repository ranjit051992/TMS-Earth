package com.zycus.automation.tenanatCreation.bo;

public class Field
{
	private String	fieldType;
	private String	displayName;
	private String	fieldName;
	private String	mandatory;
	private String	characterType;
	private String	valueType;
	private boolean	valueStatic;
	private boolean	referrenceMasterTable;
	private String	referenceMasterValue;
	private String	refrenceMasterDisplayCode;
	private String	refrenceMasterDisplayValue;
	private boolean	commonMasterDataTable;
	private String	maximumCharactersAllowed;
	private String	nextAction;

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getFieldType()
	{
		return fieldType;
	}

	public void setFieldType(String fieldType)
	{
		this.fieldType = fieldType;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}

	public String getMandatory()
	{
		return mandatory;
	}

	public void setMandatory(String mandatory)
	{
		this.mandatory = mandatory;
	}

	public String getCharacterType()
	{
		return characterType;
	}

	public void setCharacterType(String characterType)
	{
		this.characterType = characterType;
	}

	public String getValueType()
	{
		return valueType;
	}

	public void setValueType(String valueType)
	{
		this.valueType = valueType;
	}

	public boolean isValueStatic()
	{
		return valueStatic;
	}

	public void setValueStatic(boolean valueStatic)
	{
		this.valueStatic = valueStatic;
	}

	public boolean isReferrenceMasterTable()
	{
		return referrenceMasterTable;
	}

	public void setReferrenceMasterTable(boolean referrenceMasterTable)
	{
		this.referrenceMasterTable = referrenceMasterTable;
	}

	public String getReferenceMasterValue()
	{
		return referenceMasterValue;
	}

	public void setReferenceMasterValue(String referenceMasterValue)
	{
		this.referenceMasterValue = referenceMasterValue;
	}

	public String getRefrenceMasterDisplayCode()
	{
		return refrenceMasterDisplayCode;
	}

	public void setRefrenceMasterDisplayCode(String refrenceMasterDisplayCode)
	{
		this.refrenceMasterDisplayCode = refrenceMasterDisplayCode;
	}

	public String getRefrenceMasterDisplayValue()
	{
		return refrenceMasterDisplayValue;
	}

	public void setRefrenceMasterDisplayValue(String refrenceMasterDisplayValue)
	{
		this.refrenceMasterDisplayValue = refrenceMasterDisplayValue;
	}

	public boolean isCommonMasterDataTable()
	{
		return commonMasterDataTable;
	}

	public void setCommonMasterDataTable(boolean commonMasterDataTable)
	{
		this.commonMasterDataTable = commonMasterDataTable;
	}

	public String getMaximumCharactersAllowed()
	{
		return maximumCharactersAllowed;
	}

	public void setMaximumCharactersAllowed(String maximumCharactersAllowed)
	{
		this.maximumCharactersAllowed = maximumCharactersAllowed;
	}

}
