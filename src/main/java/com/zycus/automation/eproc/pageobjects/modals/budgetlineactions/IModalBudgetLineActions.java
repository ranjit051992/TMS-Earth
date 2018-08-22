/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.budgetlineactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public interface IModalBudgetLineActions
{
	public void clickOnEditAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;

	public void clickOndeleteAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;

	public void clickOnAuditAction(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException;
}
