/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.previewpeform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalPreviewPEformImpl implements IModalPreviewPEform
{
	static Logger logger = Logger.getLogger(IModalPreviewPEformImpl.class);

	@Override
	public String getLabelValueOfSection(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String sectionName = ActionBot.getTextWithInElement(driver, LABEL_SECTION_TITLE_PEFORM_PREVIEW);
		logger.info("Section Name : " + sectionName);
		return sectionName;
	}

	@Override
	public String getLabelValueOfField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldName = ActionBot.getTextWithInElement(driver, LABEL_FIELD_TITLE_PEFORM_PREVIEW);
		logger.info("Field Name : " + fieldName);
		return fieldName;
	}

	@Override
	public String getTagOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, LABEL_FIELD_VALUE_TITLE_PEFORM_PREVIEW).getTagName();
		logger.info("Tag Name of Field Value: " + tagName);
		return tagName;
	}

	@Override
	public void clickOnClosePreviewButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close preview button");
		ActionBot.click(driver, BUTTON_CLOSE_PEFORM_PREVIEW);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close preview button");
	}

}
