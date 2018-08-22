package com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryAttachment;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryAttachment.IModelItemSummaryAttachment;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModelBuyersItemSummaryAttachmentImpl implements IModelItemSummaryAttachment
{

	@Override
	public String fillAttachmentInternalComment(WebDriver driver, String testCaseName, String internalComment) throws ActionBotException
	{

		ActionBot.sendKeys(driver, INTERNAL_COMMENT, internalComment);
		String str = ActionBot.findElement(driver, INTERNAL_COMMENT).getText();
		if (str != null)
		{
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillAttachmentSupplierlComment(WebDriver driver, String testCaseName, String supplierlComment) throws ActionBotException
	{

		ActionBot.sendKeys(driver, SUPPLIER_COMMENT, supplierlComment);
		String str = ActionBot.findElement(driver, SUPPLIER_COMMENT).getText();
		if (str != null)
		{
			return str;
		}
		else
		{
			return null;
		}
	}

}
