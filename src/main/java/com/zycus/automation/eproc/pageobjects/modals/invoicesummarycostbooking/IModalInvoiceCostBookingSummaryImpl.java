/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicesummarycostbooking;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking.IModalPOSummaryCostBooking;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalInvoiceCostBookingSummaryImpl implements IModalInvoiceCostBookingSummary
{
	@Override
	public String getAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, IModalPOSummaryCostBooking.ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY);
	}

	@Override
	public boolean isElementYesSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, IModalPOSummaryCostBooking.RADIO_BUTTON_YES_PO_SUMMARY);
	}

	@Override
	public boolean isElementNoSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, IModalPOSummaryCostBooking.RADIO_BUTTON_NO_PO_SUMMARY);

	}

	@Override
	public boolean isElementAssignProjectToPurchaseCostDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, IModalPOSummaryCostBooking.ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY).getAttribute("class");

		if (str.equalsIgnoreCase("clearfix disableMe"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isFieldProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IModalPOSummaryCostBooking.FIELD_PROJECT_PO_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public void clickOnProjectField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IModalPOSummaryCostBooking.FIELD_PROJECT_PO_SUMMARY);
	}

	@Override
	public String fillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException
	{
		String project = null;
		if (ActionBot.isElementPresent(driver, IModalPOSummaryCostBooking.FIELD_PROJECT_PO_SUMMARY))
		{
			WebElement ele = ActionBot.findElement(driver, IModalPOSummaryCostBooking.FIELD_PROJECT_PO_SUMMARY);
			ele.clear();
			ele.sendKeys(projectField);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			project = ele.getAttribute("value").trim();
			ScreenShot.screenshot(driver, testCaseName, "After changing project name");

		}
		return project;
	}

	@Override
	public String fillInBudgetField(WebDriver driver, String testCaseName, String budgetField) throws ActionBotException
	{
		String budget = null;
		if (ActionBot.isElementPresent(driver, IModalPOSummaryCostBooking.FIELD_BUDGET_PO_SUMMARY))
		{
			WebElement ele = ActionBot.findElement(driver, IModalPOSummaryCostBooking.FIELD_BUDGET_PO_SUMMARY);
			ele.clear();
			ele.sendKeys(budgetField);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			budget = ele.getAttribute("value").trim();
			ScreenShot.screenshot(driver, testCaseName, "After changing budget name");

		}
		return budget;
	}

	@Override
	public String fillInCostCenterField(WebDriver driver, String testCaseName, String costCenterField) throws ActionBotException
	{
		String costCenter = null;
		WebElement ele = ActionBot.findElement(driver, IModalPOSummaryCostBooking.FIELD_COST_CENTER_PO_SUMMARY);
		ele.clear();
		ele.sendKeys(costCenterField);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		costCenter = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After changing cost center name");
		return costCenter;
	}

	@Override
	public boolean isAutocompleteFieldOfProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IModalPOSummaryCostBooking.FIELD_AUTOCOMPLETE_PROJECT_PO_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public String getProjectCodeAndProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String project = ActionBot.getTextWithInElement(driver, IModalPOSummaryCostBooking.FIELD_AUTOCOMPLETE_PROJECT_PO_SUMMARY);
		String projectName = StringUtils.split(project, ":")[1].toString().trim();
		return projectName;

	}

	@Override
	public boolean isProjectInAutocompleteFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, IModalPOSummaryCostBooking.FIELD_AUTOCOMPLETE_PROJECT_PO_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnNoRadioBttn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IModalPOSummaryCostBooking.RADIO_BUTTON_NO_PO_SUMMARY);

	}

	@Override
	public boolean isInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IModalPOSummaryCostBooking.FIELD_PROJECT_INFO))
		{
			return true;
		}
		return false;
	}

}
