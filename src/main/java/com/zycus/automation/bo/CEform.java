/**
 * 
 */
package com.zycus.automation.bo;

import java.util.List;

/**
 * @author ankita.sawant
 *
 */
public class CEform
{
	private String				ceformName					= null;
	private String				ceformDisplayName			= null;
	private String				category;
	private String				OU;
	private String				sectionName;
	private String				fieldName;
	private String				regionName;

	private boolean				isFileUpload				= false;
	private boolean				isLogoUpload				= false;
	private String				fieldTextAreaName;
	private String				fieldDescriptiveName;
	private String				fieldNumericName;
	private String				fieldDateAndTimeName;
	private String				fieldRadioButtonName;
	private String				fieldRadioButtonChoice;

	private String				fieldCheckboxName;
	private String				fieldCheckboxChoice;

	private String				fieldDropdownName;
	private String				fieldDropdownChoice;

	private String				fieldMultiselectName;
	private String				fieldMultiselectChoice;

	public String				fieldDefaultValues			= null;
	public String				fieldToolTipValue			= null;

	private String				nextAction;

	private boolean				changeOU					= false;
	private boolean				addSectionAndField			= false;
	private boolean				changeCategory				= false;
	private boolean				result						= false;
	private boolean				isCarlsonOU					= false;
	private boolean				isAddSectionMultipleFields	= false;
	private List<EformField>	eformFileds					= null;

	public boolean				isAddTextField				= false;
	public boolean				isAddTextArea				= false;
	public boolean				isAddDescriptiveField		= false;
	public boolean				isAddNumeric				= false;
	public boolean				isAddRadioButton			= false;
	public boolean				isAddDropdown				= false;
	public boolean				isAddDateAndTime			= false;
	public boolean				isAddCheckBox				= false;
	public boolean				isAddMultiSelect			= false;
	private String 	attachmentFileName 		= null;
	
	public String getFieldDefaultValues()
	{
		return fieldDefaultValues;
	}

	public void setFieldDefaultValues(String fieldDefaultValues)
	{
		this.fieldDefaultValues = fieldDefaultValues;
	}

	public String getFieldToolTipValue()
	{
		return fieldToolTipValue;
	}

	public void setFieldToolTipValue(String fieldToolTipValue)
	{
		this.fieldToolTipValue = fieldToolTipValue;
	}

	public boolean isLogoUpload()
	{
		return isLogoUpload;
	}

	public void setLogoUpload(boolean isLogoUpload)
	{
		this.isLogoUpload = isLogoUpload;
	}

	public void setFieldCheckboxChoice(String fieldCheckboxChoice)
	{
		this.fieldCheckboxChoice = fieldCheckboxChoice;
	}

	public void setFieldMultiselectChoice(String fieldMultiselectChoice)
	{
		this.fieldMultiselectChoice = fieldMultiselectChoice;
	}

	public String getFieldCheckboxChoice()
	{
		return fieldCheckboxChoice;
	}

	public String getFieldDropdownChoice()
	{
		return fieldDropdownChoice;
	}

	public String getFieldMultiselectChoice()
	{
		return fieldMultiselectChoice;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public boolean isChangeCategory()
	{
		return changeCategory;
	}

	public void setChangeCategory(boolean changeCategory)
	{
		this.changeCategory = changeCategory;
	}

	public boolean isChangeOU()
	{
		return changeOU;
	}

	public void setChangeOU(boolean changeOU)
	{
		this.changeOU = changeOU;
	}

	public boolean isAddSectionAndField()
	{
		return addSectionAndField;
	}

	public void setAddSectionAndField(boolean addSectionAndField)
	{
		this.addSectionAndField = addSectionAndField;
	}

	public String getCeformName()
	{
		return ceformName;
	}

	public void setCeformName(String ceformName)
	{
		this.ceformName = ceformName;
	}

	public String getCeformDisplayName()
	{
		return ceformDisplayName;
	}

	public void setCeformDisplayName(String ceformDisplayName)
	{
		this.ceformDisplayName = ceformDisplayName;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getOU()
	{
		return OU;
	}

	public void setOU(String oU)
	{
		OU = oU;
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

	public boolean isCarlsonOU()
	{
		return isCarlsonOU;
	}

	public void setCarlsonOU(boolean isCarlsonOU)
	{
		this.isCarlsonOU = isCarlsonOU;
	}

	public boolean isAddSectionMultipleFields()
	{
		return isAddSectionMultipleFields;
	}

	public void setAddSectionMultipleFields(boolean isAddSectionMultipleFields)
	{
		this.isAddSectionMultipleFields = isAddSectionMultipleFields;
	}

	public List<EformField> getEformFileds()
	{
		return eformFileds;
	}

	public void setEformFileds(List<EformField> eformFileds)
	{
		this.eformFileds = eformFileds;
	}

	public boolean isAddTextField()
	{
		return isAddTextField;
	}

	public void setAddTextField(boolean isAddTextField)
	{
		this.isAddTextField = isAddTextField;
	}

	public boolean isAddTextArea()
	{
		return isAddTextArea;
	}

	public void setAddTextArea(boolean isAddTextArea)
	{
		this.isAddTextArea = isAddTextArea;
	}

	public boolean isAddDescriptiveField()
	{
		return isAddDescriptiveField;
	}

	public void setAddDescriptiveField(boolean isAddDescriptiveField)
	{
		this.isAddDescriptiveField = isAddDescriptiveField;
	}

	public boolean isAddNumeric()
	{
		return isAddNumeric;
	}

	public void setAddNumeric(boolean isAddNumeric)
	{
		this.isAddNumeric = isAddNumeric;
	}

	public boolean isAddRadioButton()
	{
		return isAddRadioButton;
	}

	public void setAddRadioButton(boolean isAddRadioButton)
	{
		this.isAddRadioButton = isAddRadioButton;
	}

	public boolean isAddDropdown()
	{
		return isAddDropdown;
	}

	public void setAddDropdown(boolean isAddDropdown)
	{
		this.isAddDropdown = isAddDropdown;
	}

	public boolean isAddDateAndTime()
	{
		return isAddDateAndTime;
	}

	public void setAddDateAndTime(boolean isAddDateAndTime)
	{
		this.isAddDateAndTime = isAddDateAndTime;
	}

	public boolean isAddCheckBox()
	{
		return isAddCheckBox;
	}

	public void setAddCheckBox(boolean isAddCheckBox)
	{
		this.isAddCheckBox = isAddCheckBox;
	}

	public boolean isAddMultiSelect()
	{
		return isAddMultiSelect;
	}

	public void setAddMultiSelect(boolean isAddMultiSelect)
	{
		this.isAddMultiSelect = isAddMultiSelect;
	}

	public String getFieldTextAreaName()
	{
		return fieldTextAreaName;
	}

	public String getFieldDescriptiveName()
	{
		return fieldDescriptiveName;
	}

	public String getFieldNumericName()
	{
		return fieldNumericName;
	}

	public String getFieldDateAndTimeName()
	{
		return fieldDateAndTimeName;
	}

	public String getFieldRadioButtonName()
	{
		return fieldRadioButtonName;
	}

	public String getFieldRadioButtonChoice()
	{
		return fieldRadioButtonChoice;
	}

	public void setFieldRadioButtonChoice(String fieldRadioButtonChoice)
	{
		this.fieldRadioButtonChoice = fieldRadioButtonChoice;
	}

	public String getFieldCheckboxName()
	{
		return fieldCheckboxName;
	}

	public String getFieldDropdownName()
	{
		return fieldDropdownName;
	}

	public String getFieldMultiselectName()
	{
		return fieldMultiselectName;
	}

	public void setFieldTextAreaName(String fieldTextAreaName)
	{
		this.fieldTextAreaName = fieldTextAreaName;
	}

	public void setFieldDescriptiveName(String fieldDescriptiveName)
	{
		this.fieldDescriptiveName = fieldDescriptiveName;
	}

	public void setFieldNumericName(String fieldNumericName)
	{
		this.fieldNumericName = fieldNumericName;
	}

	public void setFieldDateAndTimeName(String fieldDateAndTimeName)
	{
		this.fieldDateAndTimeName = fieldDateAndTimeName;
	}

	public void setFieldRadioButtonName(String fieldRadioButtonName)
	{
		this.fieldRadioButtonName = fieldRadioButtonName;
	}

	public void setFieldCheckboxName(String fieldCheckboxName)
	{
		this.fieldCheckboxName = fieldCheckboxName;
	}

	public void setFieldDropdownName(String fieldDropdownName)
	{
		this.fieldDropdownName = fieldDropdownName;
	}

	public void setFieldDropdownChoice(String fieldDropdownChoice)
	{
		this.fieldDropdownChoice = fieldDropdownChoice;
	}

	public void setFieldMultiselectName(String fieldMultiselectName)
	{
		this.fieldMultiselectName = fieldMultiselectName;
	}

	public boolean isFileUpload()
	{
		return isFileUpload;
	}

	public void setFileUpload(boolean isFileUpload)
	{
		this.isFileUpload = isFileUpload;
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
