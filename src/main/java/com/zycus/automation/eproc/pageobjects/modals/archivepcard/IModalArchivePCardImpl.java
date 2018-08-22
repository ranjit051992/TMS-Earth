/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.archivepcard;

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
public class IModalArchivePCardImpl implements IModalArchivePCard
{
	static Logger logger = Logger.getLogger(IModalArchivePCardImpl.class);

	@Override
	public String fillArchivingComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException
	{
		String enteredComments = ActionBot.sendKeys(driver, TEXTBOX_ARCHIVE_COMMENTS, comments);
		logger.info("Entered Comments : " + enteredComments);
		return enteredComments;
	}

	@Override
	public String selectArchiveReasons(WebDriver driver, String testCaseName, String archiveReasons) throws ActionBotException
	{
		String reason = ActionBot.selectElement(driver, SELECT_ARCHIVE_REASONS, IConstantsData.SELECT_BY_VALUE, archiveReasons);
		logger.info("Selected Archive Reason : " + reason);
		return reason;
	}

	@Override
	public void clickOnArchiveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on archive button");
		ActionBot.click(driver, BUTTON_ARCHIVE_PCARD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on archive button");
		ActionBot.defaultSleep();
		ActionBot.findElement(driver, IPagePCardListing.BUTTON_ADD_PCARD);
	}

	@Override
	public void clickOnCancelArchiveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel archive button");
		ActionBot.click(driver, BUTTON_CANCE_ARCHIVE_PCARD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel archive button");
		ActionBot.findElement(driver, IPagePCardListing.BUTTON_ADD_PCARD);
	}

}
