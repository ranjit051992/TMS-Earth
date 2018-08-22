package com.zycus.automation.eproc.pageobjects.modals.returnNoteItemAttachment;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.modals.returninvoice.IModalReturnInvoiceImpl;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author sameer.zilpilwar
 *
 */
public class IModelReturnNoteItemAttachmentImpl implements IModelReturnNoteItemAttachment
{
	static Logger logger = Logger.getLogger(IModalReturnInvoiceImpl.class);

	@Override
	public List<WebElement> getWebElementCommentsAndAttachment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, COMMENTS_AND_ATTACHMENT_ITEM);
	}

	@Override
	public void clickOnCommentAndAttachment(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		ActionBot.click(driver, element);
	}

	@Override
	public String fillTextItemInternalComment(WebDriver driver, String testCaseName, String internalComment) throws ActionBotException
	{
		String internal_comment = null;
		if (internalComment != null)
		{
			internal_comment = ActionBot.sendKeys(driver, TEXT_ITEM_INTERNAL_COMMENT, internalComment);
		}
		else
		{
			internal_comment = ActionBot.sendKeys(driver, TEXT_ITEM_INTERNAL_COMMENT, "Auto generated return note number");
		}
		logger.info("Internal Comment Description: " + internal_comment);
		return internal_comment;
	}

	@Override
	public String fillTextItemSupplierComment(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{
		String supplier_comment = null;
		if (supplierComment != null)
		{
			supplier_comment = ActionBot.sendKeys(driver, TEXT_ITEM_SUPPLIER_COMMENT, supplierComment);
		}
		else
		{
			supplier_comment = ActionBot.sendKeys(driver, TEXT_ITEM_SUPPLIER_COMMENT, "Auto generated return note number");
		}
		logger.info("Supplier Comment Description: " + supplier_comment);
		return supplier_comment;
	}

	@Override
	public boolean selectFileForAttachmentInItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			WebElement element = ActionBot.getElement(driver, ATTACHMENT_RETURN_NOTE_ITEM_ATTACHMENTS);
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("free_text_item_Attachment"));
			ActionBot.defaultMediumSleep();
			if (ActionBot.isElementPresent(driver, ATTACHMENT_RETURN_NOTE_ITEM_ATTACHMENTS))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public void selectSupplierInAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.click(driver, ATTACHMENT_VISIBILITY_ITEM);
		//ActionBot.click(driver, ATTACHMENT_VISIBILITY_SUPPLIER);
		List<WebElement> visibility = ActionBot.findElements(driver, ATTACHMENT_VISIBILITY_ITEM);
		for (WebElement tmp : visibility)
		{

			Select select = new Select(tmp);
			select.selectByValue("SUPPLIER");
			String selectedvalue = select.getFirstSelectedOption().getText().trim();
			logger.info("Select Supplier : " + selectedvalue);
		}
	}

	@Override
	public void selectSupplierInAttachmentVisibilityAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> visibility = ActionBot.findElements(driver, ATTACHMENT_VISIBILITY_AT_ITEM_LEVEL);
		for (WebElement tmp : visibility)
		{

			Select select = new Select(tmp);
			select.selectByValue("SUPPLIER");
			String selectedvalue = select.getFirstSelectedOption().getText().trim();
			logger.info("Select Supplier : " + selectedvalue);
		}
	}

	@Override
	public void clickOnSaveAttachmentButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SAVE_ATTACHMENT_DIALOG_BUTTON);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnSaveAttachmentOkButtonItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SAVE_ATTACHMENT_OK_BUTTON_ITEM_LEVEL);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnCloseAttachmentbutton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLOSE_ATTACHMENT_DIALOG_BUTTON);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public String getValueOfAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String attachmentVisibility = ActionBot.getTextWithInElement(driver, ATTACHMENT_VISIBILITY_RETURN_NOTE);
		logger.info("Item Name " + attachmentVisibility);
		return attachmentVisibility;
	}

	@Override
	public boolean checkSupplierCommentTextFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXT_ITEM_SUPPLIER_COMMENT);
	}

	@Override
	public boolean checkSupplierFieldInAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.click(driver, ATTACHMENT_VISIBILITY_ITEM);
		//return ActionBot.isElementPresent(driver, ATTACHMENT_VISIBILITY_SUPPLIER);
		WebElement dropdown = ActionBot.findElement(driver, ATTACHMENT_VISIBILITY_ITEM);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for (WebElement item : options)
		{
			String value = item.getText();
			if (value.equals("Supplier"))
				return true;
		}
		return false;
	}

	@Override
	public boolean checkSupplierFieldInAttachmentVisibilityItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement dropdown = ActionBot.findElement(driver, ATTACHMENT_VISIBILITY_AT_ITEM_LEVEL);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for (WebElement item : options)
		{
			String value = item.getText();
			if (value.equals("Supplier"))
				return true;
		}
		return false;
	}

	@Override
	public boolean selectFileForAttachmentHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			WebElement element = ActionBot.getElement(driver, ATTACHMENT_RN_HEADER_LEVEL_ATTACHMENTS);
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("free_text_item_Attachment"));
			ActionBot.defaultMediumSleep();
			if (ActionBot.isElementPresent(driver, ATTACHMENT_RN_HEADER_LEVEL_ATTACHMENTS))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getAttachmentVisibilityWhenNotifySupplierUncheck(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String attachmentVisibility = ActionBot.getTextWithInElement(driver, ATTACHMENT_VISIBILITY_WHEN_NOTFY_SUPPLER_UNCHECK);
		logger.info("Item Name " + attachmentVisibility);
		return attachmentVisibility;
	}

	@Override
	public String getAttachmentVisibilityWhenNotifySupplierUncheckItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String attachmentVisibility = ActionBot.getTextWithInElement(driver, ATTACHMENT_VISIBILITY_WHEN_NOTFY_SUPPLER_UNCHECK_ITEM_LEVEL);
		logger.info("Item Name " + attachmentVisibility);
		return attachmentVisibility;
	}

}
