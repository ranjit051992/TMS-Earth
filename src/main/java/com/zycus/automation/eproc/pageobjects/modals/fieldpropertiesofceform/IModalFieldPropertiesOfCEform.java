/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.fieldpropertiesofceform;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalFieldPropertiesOfCEform
{
	static UI_Elements	TEXTBOX_FIELD_PROPERTIES_NAME			= UIFactory.getElements("TEXTBOX_FIELD_PROPERTIES_NAME");
	static UI_Elements	TEXTBOX_TEXT_AREA_PROPERTIES_NAME		= UIFactory.getElements("TEXTBOX_TEXT_AREA_PROPERTIES_NAME");
	static UI_Elements	TEXTBOX_DESCRIPTIVE_PROPERTIES_TEXT		= UIFactory.getElements("TEXTBOX_DESCRIPTIVE_PROPERTIES_TEXT");
	static UI_Elements	TEXTBOX_NUMERIC_PROPERTIES_NAME			= UIFactory.getElements("TEXTBOX_NUMERIC_PROPERTIES_NAME");
	static UI_Elements	TEXTBOX_DATE_AND_TIME_PROPERTIES_NAME	= UIFactory.getElements("TEXTBOX_DATE_AND_TIME_PROPERTIES_NAME");
	static UI_Elements	TEXTBOX_RADIO_BUTTON_PROPERTIES_NAME	= UIFactory.getElements("TEXTBOX_RADIO_BUTTON_PROPERTIES_NAME");
	static UI_Elements	TEXTBOX_RADIO_BUTTON_PROPERTIES_CHOICE	= UIFactory.getElements("TEXTBOX_RADIO_BUTTON_PROPERTIES_CHOICE");
	static UI_Elements	TEXTBOX_CHECK_BOX_PROPERTIES_NAME		= UIFactory.getElements("TEXTBOX_CHECK_BOX_PROPERTIES_NAME");
	static UI_Elements	TEXTBOX_CHECK_BOX_PROPERTIES_CHOICE		= UIFactory.getElements("TEXTBOX_CHECK_BOX_PROPERTIES_CHOICE");
	static UI_Elements	TEXTBOX_DROP_DOWN_PROPERTIES_NAME		= UIFactory.getElements("TEXTBOX_DROP_DOWN_PROPERTIES_NAME");
	static UI_Elements	TEXTBOX_DROP_DOWN_PROPERTIES_CHOICE		= UIFactory.getElements("TEXTBOX_DROP_DOWN_PROPERTIES_CHOICE");
	static UI_Elements	TEXTBOX_MULTI_SELECT_PROPERTIES_NAME	= UIFactory.getElements("TEXTBOX_MULTI_SELECT_PROPERTIES_NAME");
	static UI_Elements	TEXTBOX_MULTI_SELECT_PROPERTIES_CHOICE	= UIFactory.getElements("TEXTBOX_MULTI_SELECT_PROPERTIES_CHOICE");
	static UI_Elements	TEXTBOX_FIELD_PROPERTIES_DEFAULT_VALUE	= UIFactory.getElements("TEXTBOX_FIELD_PROPERTIES_DEFAULT_VALUE");
	static UI_Elements	TEXTBOX_FIELD_PROPERTIES_TOOL_TIP		= UIFactory.getElements("TEXTBOX_FIELD_PROPERTIES_TOOL_TIP");

	static UI_Elements	BUTTON_SAVE_FIELD_PROPERTIES			= UIFactory.getElements("BUTTON_SAVE_FIELD_PROPERTIES");
	static UI_Elements	BUTTON_CANCEL_FIELD_PROPERTIES			= UIFactory.getElements("BUTTON_CANCEL_FIELD_PROPERTIES");

	public String fillFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillTextAreaName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillDescriptiveName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillNumericName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillDateAndTimeName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillRadioButtonName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillRadioButtonChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillCheckboxName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillCheckboxChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillDropdownName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillDropdownChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillMultiselectName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillMultiselectChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public void clickOnSaveFieldButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelFieldButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillFieldDefaultValue(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

	public String fillFieldToolTip(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException;

}
