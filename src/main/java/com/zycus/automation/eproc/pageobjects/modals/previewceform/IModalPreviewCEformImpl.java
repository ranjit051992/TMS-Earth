/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.previewceform;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalPreviewCEformImpl implements IModalPreviewCEform
{
	static Logger logger = Logger.getLogger(IModalPreviewCEformImpl.class);

	@Override
	public String getSectionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String sectionName = ActionBot.getTextWithInElement(driver, LABEL_PREVIEW_CEFORM_SECTION_NAME);
		logger.info("Section name : " + sectionName);
		return sectionName;
	}

	@Override
	public String getFieldName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldName = ActionBot.getTextWithInElement(driver, LABEL_PREVIEW_CEFORM_FIELD_NAME);
		if (fieldName.contains(":"))
		{
			String[] temp = StringUtils.split(fieldName, ":");
			fieldName = "";
			fieldName = temp[0].trim();
		}
		logger.info("Field name : " + fieldName);
		return fieldName;
	}

	@Override
	public String getTagNameOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagOfFieldValue = ActionBot.findElement(driver, LABEL_PREVIEW_CEFORM_FIELD_VALUE).getTagName();
		logger.info("Tag Name of Field Value : " + tagOfFieldValue);
		return tagOfFieldValue;
	}

	@Override
	public void clickOnClosePreviewButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close preview button");
		ActionBot.click(driver, BUTTON_CLOSE_PREVIEW_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close preview button");
	}

}
