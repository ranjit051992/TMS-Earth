/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.budgetlineactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IModalBudgetLineActionsImpl implements IModalBudgetLineActions
{
	@Override
	public void clickOnEditAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[.//*[contains(text(),'" + budgetLineName + "')]]//a[contains(@class,'edit')]"));
	}

	@Override
	public void clickOndeleteAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[.//*[contains(text(),'" + budgetLineName + "')]]//a[contains(@class,'delete')]"));
	}

	@Override
	public void clickOnAuditAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[.//*[contains(text(),'" + budgetLineName + "')]]//a[contains(@class,'audit')]"));

	}
}
