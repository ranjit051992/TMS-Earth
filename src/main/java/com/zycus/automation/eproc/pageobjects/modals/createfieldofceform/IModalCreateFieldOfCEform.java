/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.createfieldofceform;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalCreateFieldOfCEform
{

	static UI_Elements	BUTTON_TEXT_FIELD_CEFORM		= UIFactory.getElements("BUTTON_TEXT_FIELD_CEFORM");
	static UI_Elements	BUTTON_TEXT_AREA_CEFORM			= UIFactory.getElements("BUTTON_TEXT_AREA_CEFORM");
	static UI_Elements	BUTTON_DESCRIPTIVE_FIELD_CEFORM	= UIFactory.getElements("BUTTON_DESCRIPTIVE_FIELD_CEFORM");
	static UI_Elements	BUTTON_NUMERIC_CEFORM			= UIFactory.getElements("BUTTON_NUMERIC_CEFORM");
	static UI_Elements	BUTTON_DATE_AND_TIME_CEFORM		= UIFactory.getElements("BUTTON_DATE_AND_TIME_CEFORM");
	static UI_Elements	BUTTON_RADIO_BUTTON_CEFORM		= UIFactory.getElements("BUTTON_RADIO_BUTTON_CEFORM");
	static UI_Elements	BUTTON_CHECK_BOX_CEFORM			= UIFactory.getElements("BUTTON_CHECK_BOX_CEFORM");
	static UI_Elements	BUTTON_DROP_DOWN_CEFORM			= UIFactory.getElements("BUTTON_DROP_DOWN_CEFORM");
	static UI_Elements	BUTTON_MULTI_SELECT_CEFORM		= UIFactory.getElements("BUTTON_MULTI_SELECT_CEFORM");
	static UI_Elements	TEXTBOX_ENTER_CHECKBOX_CHOICES	= UIFactory.getElements("TEXTBOX_ENTER_CHECKBOX_CHOICES");

	public void clickOnAddTextField(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddTextArea(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> enterChoicesForCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddDescriptiveField(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddNumeric(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddDateAndTime(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddDropDown(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddMultiSelect(WebDriver driver, String testCaseName) throws ActionBotException;

}
