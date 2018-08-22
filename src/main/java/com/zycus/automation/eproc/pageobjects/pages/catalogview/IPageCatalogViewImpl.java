/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.catalogview;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IPageCatalogViewImpl implements IPageCatalogView
{
	static Logger logger = Logger.getLogger(IPageCatalogViewImpl.class);

	@Override
	public String getCatalogValidity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String validity = ActionBot.getTextWithInElement(driver, LABEL_VALIDITY_ON_CATALOG_VIEW);
		logger.info("Validity : " + validity);
		return validity;
	}

	@Override
	public String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_VIEW_CATALOG);
		logger.info("Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, LINK_ITEM_NAMES_VIEW_CATALOG);
		List<String> itemNames = new ArrayList<String>();
		for (WebElement element : elements)
		{
			itemNames.add(element.getText().trim());
		}
		return itemNames;
	}

	@Override
	public List<String> getOUs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String log = "";
		List<WebElement> elements = ActionBot.findElements(driver, LABEL_OU_VIEW_CATALOG);
		List<String> ou = new ArrayList<String>();
		for (WebElement element : elements)
		{
			log += element.getText().trim() + "\n";
			ou.add(element.getText().trim());
		}
		logger.info("Selected OUs : " + log);
		return ou;
	}

	@Override
	public void clickOnItemActionsLink(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='browseItems']//tr[.//*[text()='" + itemName + "']]//a[contains(@class,'actLnk')]"));
	}

	@Override
	public void clickOnHideItemLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_HIDE_ITEM);
	}

	@Override
	public void clickOnUnHideItemLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UNHIDE_ITEM);
	}

	@Override
	public boolean isItemHiddenStatusIconPresent(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(".//*[@id='browseItems']//tr[.//*[text()='" + itemName + "']]//a[contains(@title,'Hidden')]"));
	}

	@Override
	public boolean isItemUnHideStatusIconPresent(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(".//*[@id='browseItems']//tr[.//*[text()='" + itemName + "']]//a[contains(@title,'Visible')]"));
	}

	@Override
	public void waitTillSuccessMsgPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, SUCCESS_MSG_VISIBILITY_UPDATED);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnSubmitForApprovalButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SBUMIT_FOR_APPROVAL_CATALOG_VIEW_PAGE);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_SUBMIT_CATALOG);
	}

	@Override
	public boolean isSubmitForApprovalButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_SBUMIT_FOR_APPROVAL_CATALOG_VIEW_PAGE);
	}

	@Override
	public void clickOnAuditTrailTabLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AUDIT_TRAIL_TAB_LINK);
		ActionBot.defaultSleep();
	}

	@Override
	public boolean isAuditTrailTablePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TABLE_AUDIT_TRAIL);
	}

}
