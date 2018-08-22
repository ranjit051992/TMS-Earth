/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.blanketorderforfreetextitem;

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
public class IModalBlanketOrdersForFreeTextItemImpl implements IModalBlanketOrdersForFreeTextItem
{
	static Logger logger = Logger.getLogger(IModalBlanketOrdersForFreeTextItemImpl.class);

	@Override
	public String fillBPONumber(WebDriver driver, String testCaseName, String BPONumber) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_BPO_NO);
		element.sendKeys(BPONumber);
		ActionBot.defaultSleep();
		String searchedBPONo = "";
		searchedBPONo = ActionBot.sendKeys(driver, TEXTBOX_BPO_NO, BPONumber);
		element.sendKeys(Keys.RETURN);
		ActionBot.defaultSleep();
		logger.info("Searched BPO Number : " + searchedBPONo);
		return searchedBPONo;
	}

	@Override
	public String fillBPOName(WebDriver driver, String testCaseName, String BPOName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_BPO_NAME);
		element.sendKeys(BPOName);
		ActionBot.defaultSleep();
		String searchedBPOName = "";
		searchedBPOName = ActionBot.sendKeys(driver, TEXTBOX_BPO_NAME, BPOName);
		element.sendKeys(Keys.RETURN);
		ActionBot.defaultSleep();
		logger.info("Searched BPO Name : " + searchedBPOName);
		return searchedBPOName;
	}

	@Override
	public String fillCreatedByForBPO(WebDriver driver, String testCaseName, String createdBy) throws Exception
	{
		if (ActionBot.isElementPresent(driver, TEXTBOX_BPO_CREATED_BY))
		{
			ActionBot.defaultSleep();
			ActionBot.moveToElement(driver, TEXTBOX_BPO_CREATED_BY);
			return ActionBot.fillAutoCompleteField(driver, TEXTBOX_BPO_CREATED_BY, createdBy);
		}
		else
		{
			return null;
		}
	}

	@Override
	public void selectFirstBPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.focusAndclick(driver, RADIO_BUTTON_SELECT_BPO);
		// ActionBot.defaultSleep();
		if (!ActionBot.isElementSelected(driver, RADIO_BUTTON_SELECT_BPO))
		{
			ActionBot.focusAndclick(driver, RADIO_BUTTON_SELECT_BPO);
			// ActionBot.defaultSleep();
		}
	}

	@Override
	public void clickOnFirstBPOLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_FIRST_BPO_NO);
	}

	@Override
	public void clickOnSelectBPOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Select Button");
		ActionBot.click(driver, BUTTON_SELECT_BPO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Select Button");
	}

	@Override
	public void clickOnCloseBPOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Close Button");
		ActionBot.click(driver, BUTTON_CLOSE_BPO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Close Button");
	}

	@Override
	public String getFirstBPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String bpoNo = ActionBot.getTextWithInElement(driver, LINK_FIRST_BPO_NO);
		logger.info("First BPO No : " + bpoNo);
		return bpoNo;
	}

	@Override
	public String getFirstBPOName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String bpoName = ActionBot.getTextWithInElement(driver, LABEL_FIRST_BPO_NAME);
		logger.info("First BPO Name : " + bpoName);
		return bpoName;
	}

	@Override
	public String getFirstBPOCreatedBy(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String createdBy = ActionBot.getTextWithInElement(driver, LABEL_FIRST_CREATED_BY);
		logger.info("BPO Created By : " + createdBy);
		return createdBy;
	}

	@Override
	public int fillBPOPaginateValue(WebDriver driver, String testCaseName, int value) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_BPO_PAGINATE, " " + value);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_BPO_PAGINATE);
		if (str != null)
		{
			int no = Integer.parseInt(str);
			return no;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public int getNoOfRecordsCount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		String str = ActionBot.getTextWithInElement(driver, LABEL_FILTER_COUNT_OF_RECORDS);
		if (str != null)
		{
			int no = Integer.parseInt(str);
			return no;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public void clickOnNextPageOnBPOListing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, ICON_BPO_LISTING_NEXT_PAGINATION);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isBalanceAmountColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, COLUMN_BALANCE_AMOUNT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isTextboxBPONoPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_BPO_NO);
	}

	@Override
	public int getNoOfBPOCount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int rowCount = ActionBot.findElements(driver, LINK_FIRST_BPO_NO).size();
		logger.info(rowCount + "number of BPO are listed in table");
		return rowCount;
	}

	@Override
	public boolean isValidUntilSortingPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, SORT_VALID_UNTIL);
	}

	@Override
	public boolean isNoResultsTablePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, NO_RESULTS_TABLE).equalsIgnoreCase("No results found");
	}

	@Override
	public boolean isFromDateAndToDateFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		ActionBot.click(driver, FILTER_VALID_UNTIL);
		ActionBot.moveToElement(driver, FILTER_VALID_UNTIL_FROM_DATE);
		flag = ActionBot.isElementDisplayed(driver, FILTER_VALID_UNTIL_FROM_DATE);
		if (flag == true)
		{
			ActionBot.moveToElement(driver, FILTER_VALID_UNTIL_TO_DATE);
			flag = ActionBot.isElementDisplayed(driver, FILTER_VALID_UNTIL_TO_DATE);
		}
		return flag;
	}

	@Override
	public String getContractNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_CONTRACT_NUMBER);
	}
}
