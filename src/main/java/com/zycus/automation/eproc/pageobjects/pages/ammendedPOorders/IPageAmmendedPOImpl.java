package com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.bpo.IPageBPO;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageAmmendedPOImpl implements IPageAmmendedPO
{
	static Logger logger = Logger.getLogger(IPageAmmendedPOImpl.class);

	@Override
	public void clickOnActions(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.defaultSleep();
		String xpathPart1 = ".//*[@id='amendedPurchaseOrderGrid']//tr[";
		String xpathPart2 = "]//a[@class='icon actLnk']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		ActionBot.click(driver, xpath);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_AMMENDED_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on edit ammended po");

	}

	@Override
	public boolean isRollBackPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_ROLL_BACK))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnRollBack(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ROLL_BACK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on roll back");
	}

	@Override
	public boolean isViewAllPOPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_VIEW_All_PO_ON_AMMENDMENT_PAGE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnAmmendPONumberOfSameBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_AMENDED_PO_NO_SAME_BUYER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on po number");

	}

	@Override
	public String getFirstAmendedPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String amended_po_no = ActionBot.getTextWithInElement(driver, LINK_FIRST_AMENDED_PO_NO);
		logger.info("First Amended PO No : " + amended_po_no);
		ScreenShot.screenshot(driver, testCaseName, "First Amended PO No");
		return amended_po_no;
	}

	@Override
	public List<WebElement> getAllAmendedPONos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_LIST_OF_ALL_AMENDED_PO_NO);
	}

	@Override
	public void clickOnAmmendPONumberOfDifferentBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_AMENDED_PO_NO_DIFFERENT_BUYER);

	}

	@Override
	public String getStatusOfAmendedPO(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='amendedPurchaseOrderGrid']//tr[" + index + "]/td[contains(@class,'status')]/div"));
		logger.info("Status : " + status);
		return status;
	}

	@Override
	public void clickOnActionsOfSingleApprovalPO(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='amendedPurchaseOrderGrid']//tr[(.//*[contains(text(),'" + poNo + "')])]//a[contains(@class,'actLnk')]"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on actions of approval PO");

	}

	@Override
	public void clickOnRecallApprovalRequestOfApprovalPO(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='amendedPurchaseOrderGrid']//tr[" + index + "]//a[contains(@class,'terminate downArrow')]"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on recall approvals request");

	}

	@Override
	public void clickOnActions(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//tr[.//*[contains(text(),'" + poNo + "')]]//a[contains(@class,'actLnk')]"));
	}

	@Override
	public String getStatusOfAmendedPO(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='amendedPurchaseOrderGrid']//tr[.//*[contains(text(),'" + poNumber + "')]]/td[contains(@class,'status')]/div"));
		logger.info("Status of " + poNumber + " amended po : " + status);
		return status;
	}

	@Override
	public void clickOnAmendedPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='amendedPurchaseOrderGrid']//tr[.//*[contains(text(),'" + poNumber + "')]]//a[contains(@class,'amendmentAction')]"));
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view amended po");
	}

	@Override
	public void clickOnFirstAmendAmendPoNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_FIRST_AMENDED_PO_NO);

	}

	@Override
	public boolean isPoNoAlreadyAmendedAlertDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, PO_NO_ALREADY_AMENDED_ALEART_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isAmendedPOPresentInListing(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver,
			By.xpath(".//*[@id='amendedPurchaseOrderGrid']//tr[.//*[contains(text(),'" + poNo + "')]]//a[contains(@class,'amendmentAction')]"));
	}

	@Override
	public int getNoOfAmendedPOPresentInListing(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		return ActionBot.findElements(driver, By.xpath(".//*[@id='amendedPurchaseOrderGrid']//tr[.//*[contains(text(),'" + poNo + "')]]//a[contains(@class,'amendmentAction')]"))
			.size();
	}

	@Override
	public void waitTillRollBackPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, IPageBPO.PROGRESSING_DIV_ROLL_BACK_BPO);
	}

	@Override
	public boolean isRollBackButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_ROLL_BACK);
	}

	@Override
	public String getSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String msg = ActionBot.getTextWithInElement(driver, LABEL_SUCCESS_MSG_AMENDED_BPO);
		logger.info("Success Message : " + msg);
		return msg;
	}

	@Override
	public void clickOnViewAllPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_All_PO_ON_AMMENDMENT_PAGE);
		ActionBot.defaultSleep();

	}

}
