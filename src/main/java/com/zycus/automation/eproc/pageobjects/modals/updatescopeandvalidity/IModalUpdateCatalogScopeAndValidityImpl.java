/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.updatescopeandvalidity;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.cataloglisting.IPageCatalogListing;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalUpdateCatalogScopeAndValidityImpl implements IModalUpdateCatalogScopeAndValidity
{
	static Logger logger = Logger.getLogger(IModalUpdateCatalogScopeAndValidityImpl.class);

	@Override
	public String selectToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_TO_VALIDITY_DATE);

		// year
		Select select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String toDate = ActionBot.findElement(driver, TO_VALIDITY_DATE).getAttribute("value").trim();
		logger.info("Selected To Date : " + toDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing To date");

		return toDate;
	}

	@Override
	public List<WebElement> getListOfScopes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, CHECKBOX_SELECT_SCOPE);
	}

	@Override
	public void clickOnScope(WebDriver driver, String testCaseName, String scopeName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//*[contains(text(),'" + scopeName + "')]/input"));
		if (!element.isSelected())
		{
			element.click();
		}
	}

	@Override
	public void clickOnPublishButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_PUBLISH_CATALOG_ON_UPDATE_SCOPE_AND_VALIDITY);
		ActionBot.waitTillPopUpIsPresent(driver, IPageCatalogListing.PROGRESSING_DIV_FOR_UPDATE_CATALOG);
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_CATALOG_ON_UPDATE_SCOPE_AND_VALIDITY);
	}

	@Override
	public String getFromDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fromDate = ActionBot.findElement(driver, FROM_VALIDITY_DATE).getAttribute("value");
		logger.info("From Date : " + fromDate);
		return fromDate;
	}

}
