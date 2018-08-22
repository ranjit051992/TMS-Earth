/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.deactivatepcard;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.pcardlisting.IPagePCardListing;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalDeactivatePCardImpl implements IModalDeactivatePCard
{
	static Logger logger = Logger.getLogger(IModalDeactivatePCardImpl.class);

	@Override
	public String fillDeactivateComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException
	{
		String enteredComments = ActionBot.sendKeys(driver, TEXTBOX_DEACTIVATE_COMMENTS, comments);
		logger.info("Entered Comments : " + enteredComments);
		return enteredComments;
	}

	@Override
	public String selectDeactivateReasons(WebDriver driver, String testCaseName, String deactivateReasons) throws ActionBotException
	{
		String reason = ActionBot.selectElement(driver, SELECT_DEACTIVATE_REASONS, IConstantsData.SELECT_BY_VALUE, deactivateReasons);
		logger.info("Selected Deactivate Reason : " + reason);
		return reason;
	}

	@Override
	public void clickOnDeactivateButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on deactivate button");
		ActionBot.click(driver, BUTTON_DEACTIVATE_PCARD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on deactivate button");
		ActionBot.findElement(driver, IPagePCardListing.BUTTON_ADD_PCARD);
	}

	@Override
	public void clickOnCancelDeactivateButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel deactivate button");
		ActionBot.click(driver, BUTTON_CANCE_DEACTIVATE_PCARD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel deactivate button");
		ActionBot.findElement(driver, IPagePCardListing.BUTTON_ADD_PCARD);
	}

}
