/**
 * 
 */
package com.zycus.automation.bo;

import java.util.List;

/**
 * @author ankita.sawant
 *
 */

public class PEform
{
	private String				peformName					= null;
	private String				processName					= null;
	private String				OU							= null;
	private String				purchaseType				= null;
	private String				sectionName;
	private String				fieldName;
	private String				nextAction;
	private boolean				changeOU					= false;
	private boolean				addSectionAndField			= false;
	private boolean				result;
	private boolean				isCarlsonOU					= false;
	private boolean				isAddSectionMultipleFields	= false;
	private List<EformField>	eformFileds					= null;
	private boolean				isFileUpload				= false;
	private String				businessUnit				= null;
	private String 				attachmentFileName 			= null;

	//client specific - Carlson
	private String				regionName					= null;

	public boolean isResult()

	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public boolean isAddSectionAndField()
	{
		return addSectionAndField;
	}

	public void setAddSectionAndField(boolean addSectionAndField)
	{
		this.addSectionAndField = addSectionAndField;
	}

	public boolean isChangeOU()
	{
		return changeOU;
	}

	public void setChangeOU(boolean changeOU)
	{
		this.changeOU = changeOU;
	}

	public String getSectionName()
	{
		return sectionName;
	}

	public void setSectionName(String sectionName)
	{
		this.sectionName = sectionName;
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getPeformName()
	{
		return peformName;
	}

	public void setPeformName(String peformName)
	{
		this.peformName = peformName;
	}

	public String getProcessName()
	{
		return processName;
	}

	public void setProcessName(String processName)
	{
		this.processName = processName;
	}

	public String getOU()
	{
		return OU;
	}

	public void setOU(String oU)
	{
		OU = oU;
	}

	public String getPurchaseType()
	{
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType)
	{
		this.purchaseType = purchaseType;
	}

	public boolean isCarlsonOU()
	{
		return isCarlsonOU;
	}

	public void setCarlsonOU(boolean isCarlsonOU)
	{
		this.isCarlsonOU = isCarlsonOU;
	}

	public boolean isFileUpload()
	{
		return isFileUpload;
	}

	public void setFileUpload(boolean isFileUpload)
	{
		this.isFileUpload = isFileUpload;
	}

	public List<EformField> getEformFileds()
	{
		return eformFileds;
	}

	public void setEformFileds(List<EformField> eformFileds)
	{
		this.eformFileds = eformFileds;
	}

	public boolean isAddSectionAndMultipleFields()
	{
		return isAddSectionMultipleFields;
	}

	public void setAddMultipleFields(boolean isAddMultipleFields)
	{
		this.isAddSectionMultipleFields = isAddMultipleFields;
	}

	public String getBusinessUnit()
	{
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit)
	{
		this.businessUnit = businessUnit;
	}

	public String getRegionName()
	{
		return regionName;
	}

	public void setRegionName(String regionName)
	{
		this.regionName = regionName;
	}

	public String getAttachmentFileName()
	{
		return attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName)
	{
		this.attachmentFileName = attachmentFileName;
	}
}
