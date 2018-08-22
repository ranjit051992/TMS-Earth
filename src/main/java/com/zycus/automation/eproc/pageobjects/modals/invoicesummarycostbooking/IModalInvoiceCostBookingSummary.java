/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicesummarycostbooking;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public interface IModalInvoiceCostBookingSummary
{
	public String getAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isElementYesSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isElementNoSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isElementAssignProjectToPurchaseCostDisabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFieldProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnProjectField(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException;

	public String fillInBudgetField(WebDriver driver, String testCaseName, String budgetField) throws ActionBotException;

	public String fillInCostCenterField(WebDriver driver, String testCaseName, String costCenterField) throws ActionBotException;

	public boolean isAutocompleteFieldOfProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectCodeAndProjectName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectInAutocompleteFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNoRadioBttn(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;
}
