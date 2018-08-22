/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.createsectionofceform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalCreateSectionOfCEformImpl implements IModalCreateSectionOfCEform
{
	static Logger logger = Logger.getLogger(IModalCreateSectionOfCEformImpl.class);

	@Override
	public String fillSectionName(WebDriver driver, String testCaseName, String sectionName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SECTION_NAME_CEFORM, sectionName);
		String enteredSectionName = ActionBot.findElement(driver, TEXTBOX_SECTION_NAME_CEFORM).getAttribute("value").trim();
		logger.info("Entered Section Name : " + enteredSectionName);
		return enteredSectionName;
	}

	@Override
	public void clickOnSaveSectionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save section button");
		ActionBot.click(driver, BUTTON_SAVE_SECTION_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save section button");
	}

	@Override
	public void clickOnCancelSectionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel section button");
		ActionBot.click(driver, BUTTON_CANCEL_SECTION_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel section button");
	}

}
