/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentdelegate;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.User;
import com.zycus.automation.eproc.pageobjects.pages.approval.IPageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.approvaldocumentviewmode.PageApprovalDocumentViewMode;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalAllRequestsApprovalDocumentDelegateImpl implements IModalAllRequestsApprovalDocumentDelegate
{

	static Logger logger = Logger.getLogger(IModalAllRequestsApprovalDocumentDelegateImpl.class);

	@Override
	public String fillDelegateComments(WebDriver driver, String testCaseName, String delegateComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, DELEGATE_COMMENTS, delegateComment);
		ScreenShot.screenshot(driver, testCaseName, "After filling Delegate Comment");
		String delegate_comment = ActionBot.findElement(driver, DELEGATE_COMMENTS).getAttribute("value");
		logger.info("Delegate Comment : " + delegate_comment);
		return delegate_comment;
	}

	@Override
	public String getDelegateComments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Delegate Comment");
		String delegate_comment = ActionBot.findElement(driver, DELEGATE_COMMENTS).getAttribute("value");
		logger.info("Delegate Comment : " + delegate_comment);
		return delegate_comment;
	}

	@Override
	public void clickOnDelegateSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELEAGTE_SAVE_BUTTON);
		PageAllRequestsApproval.waitTillApprovalActionProcessingDivPresent(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Delegate Button");
	}

	@Override
	public void clickOnDelegateCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELEGATE_CANCEL_BUTTON);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Delegate Cancel Button");
	}

	@Override
	public String fillDelegateToName(WebDriver driver, String testCaseName, String delegateTo) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, DELEGATE_APPROVAL_TO_NAME);
		/*
		 * element.clear(); element.sendKeys(delegateTo);
		 * ActionBot.defaultSleep(); element.sendKeys(Keys.ARROW_DOWN);
		 * element.sendKeys(Keys.ENTER);
		 */
		ActionBot.fillAutoCompleteField(driver, element, delegateTo);
		ScreenShot.screenshot(driver, testCaseName, "After filling delegate to name");

		String delegate_to = element.getAttribute("value");
		logger.info("Delegate To : " + delegate_to);
		return delegate_to;
	}

	@Override
	public String getDelegateToName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Delegate to name");

		String delegate_to = ActionBot.findElement(driver, DELEGATE_APPROVAL_TO_NAME).getAttribute("value");
		logger.info("Delegate To : " + delegate_to);
		return delegate_to;
	}

	@Override
	public boolean delegateMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.click(driver, IPageAllRequestsApproval.AUTO_CHECK_ALL);
		ActionBot.click(driver, By.xpath("(.//*[contains(@class,'autoCheckItem')])[1]"));
		ActionBot.click(driver, By.xpath("(.//*[contains(@class,'autoCheckItem')])[2]"));
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After selecting multiple items");
		ActionBot.click(driver, LINK_DELEGATE_MULTIPLE_ITEMS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking delegate link");
		try
		{
			fillDelegateToName(driver, testCaseName, CommonServices.getTestData(IConstantsData.BUYER_NAME));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		fillDelegateComments(driver, testCaseName, IConstantsData.DELEGATE_COMMENT);
		clickOnDelegateSaveButton(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After delegating multiple items");
		return PageAllRequestsApproval.isSuccessMessage(driver, testCaseName);
	}

}
