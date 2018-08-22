/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.pcardlisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPagePCardListingImpl implements IPagePCardListing
{
	static Logger logger = Logger.getLogger(IPagePCardListingImpl.class);

	@Override
	public void clickOnAddPCardButtton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_PCARD);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Add Pcard Button");
	}

	@Override
	public void clickOnStatusFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_STATUS_FILTER);
	}

	@Override
	public void clickOnClearStatusFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLEAR_STATUS_FILTER_OF_PCARD);
	}

	@Override
	public void clickOnPCardActionsOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PCARD_ACTIONS);
		ActionBot.defaultSleep();
	}

	@Override
	public String fillPCardType(WebDriver driver, String testCaseName, String pCardType) throws ActionBotException
	{
		String enteredPCardType = null;
		WebElement element = ActionBot.findElement(driver, TEXTBOX_PCARD_TYPE);
		element.clear();
		element.sendKeys(pCardType);
		element.sendKeys(Keys.RETURN);
		enteredPCardType = element.getAttribute("value");
		logger.info("Entered PCard Type : " + enteredPCardType);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_PCARD_LISTING);
		ScreenShot.screenshot(driver, testCaseName, "After searching pcard using pcard type");
		return enteredPCardType;
	}

	@Override
	public String fillPCardNo(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException
	{
		String enteredPCardNo = null;
		WebElement element = ActionBot.findElement(driver, TEXTBOX_PCARD_NO_ON_PCARD_LISTING);
		element.clear();
		element.sendKeys(pCardNo);
		element.sendKeys(Keys.RETURN);
		enteredPCardNo = element.getAttribute("value");
		logger.info("Entered PCard No : " + enteredPCardNo);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_PCARD_LISTING);
		ScreenShot.screenshot(driver, testCaseName, "After searching pcard using pcard no");
		return enteredPCardNo;
	}

	@Override
	public String getStatusOfPCard(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_STATUS_OF_PCARD);
		logger.info("Status of PCard : " + status);
		return status;
	}

	@Override
	public String getPCardTypeOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String pCardType = ActionBot.getTextWithInElement(driver, LABEL_PCARD_TYPE_ON_PCARD_LISTING);
		logger.info("PCard Type : " + pCardType);
		return pCardType;
	}

	@Override
	public String getPCardNoOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String pCardNo = ActionBot.getTextWithInElement(driver, LABEL_PCARD_NO_ON_PCARD_LISTING);
		logger.info("PCard No : " + pCardNo);
		return pCardNo;
	}

	@Override
	public boolean isActionLinkEnable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, LINK_PCARD_ACTIONS).isEnabled();
	}

	@Override
	public boolean isEditLinkEnable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, LINK_EDIT_PCARD_ACTIONS).isEnabled();
	}

	@Override
	public boolean isActionButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, LINK_PCARD_ACTIONS);
	}

	@Override
	public String getIssueToOfPCard(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXT_ISSUED_TO))
			return ActionBot.getTextWithInElement(driver, TEXT_ISSUED_TO);
		return null;
	}

}
