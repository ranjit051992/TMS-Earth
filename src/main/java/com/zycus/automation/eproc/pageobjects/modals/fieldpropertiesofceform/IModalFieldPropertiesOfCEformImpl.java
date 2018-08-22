/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.fieldpropertiesofceform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalFieldPropertiesOfCEformImpl implements IModalFieldPropertiesOfCEform
{
	static Logger logger = Logger.getLogger(IModalFieldPropertiesOfCEformImpl.class);

	@Override
	public String fillFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_FIELD_PROPERTIES_NAME, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_FIELD_PROPERTIES_NAME).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillTextAreaName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_TEXT_AREA_PROPERTIES_NAME, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_TEXT_AREA_PROPERTIES_NAME).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillDescriptiveName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DESCRIPTIVE_PROPERTIES_TEXT, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_DESCRIPTIVE_PROPERTIES_TEXT).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillNumericName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_NUMERIC_PROPERTIES_NAME, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_NUMERIC_PROPERTIES_NAME).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillDateAndTimeName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DATE_AND_TIME_PROPERTIES_NAME, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_DATE_AND_TIME_PROPERTIES_NAME).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillRadioButtonName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_RADIO_BUTTON_PROPERTIES_NAME, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_RADIO_BUTTON_PROPERTIES_NAME).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillRadioButtonChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_RADIO_BUTTON_PROPERTIES_CHOICE, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_RADIO_BUTTON_PROPERTIES_CHOICE).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillCheckboxName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CHECK_BOX_PROPERTIES_NAME, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_CHECK_BOX_PROPERTIES_NAME).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillCheckboxChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CHECK_BOX_PROPERTIES_CHOICE, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_CHECK_BOX_PROPERTIES_CHOICE).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillDropdownName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DROP_DOWN_PROPERTIES_NAME, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_DROP_DOWN_PROPERTIES_NAME).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillDropdownChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DROP_DOWN_PROPERTIES_CHOICE, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_DROP_DOWN_PROPERTIES_CHOICE).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillMultiselectName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_MULTI_SELECT_PROPERTIES_NAME, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_MULTI_SELECT_PROPERTIES_NAME).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public String fillMultiselectChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_MULTI_SELECT_PROPERTIES_CHOICE, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_MULTI_SELECT_PROPERTIES_CHOICE).getAttribute("value").trim();
		logger.info("Entered Field Name : " + field_name);
		return field_name;
	}

	@Override
	public void clickOnSaveFieldButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save field button");
		ActionBot.click(driver, BUTTON_SAVE_FIELD_PROPERTIES);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save field button");
	}

	@Override
	public void clickOnCancelFieldButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel field button");
		ActionBot.click(driver, BUTTON_CANCEL_FIELD_PROPERTIES);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel field button");
	}

	@Override
	public String fillFieldDefaultValue(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_FIELD_PROPERTIES_DEFAULT_VALUE, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_FIELD_PROPERTIES_DEFAULT_VALUE).getAttribute("value").trim();
		logger.info("Entered Field Default value is : " + field_name);
		return field_name;
	}

	@Override
	public String fillFieldToolTip(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_FIELD_PROPERTIES_TOOL_TIP, fieldName);
		String field_name = ActionBot.findElement(driver, TEXTBOX_FIELD_PROPERTIES_TOOL_TIP).getAttribute("value").trim();
		logger.info("Entered Field Tool Tip value is : " + field_name);
		return field_name;
	}

}
