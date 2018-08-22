/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.budgetlinesetting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalBudgetLineSetting
{
	static Logger				logger												= Logger.getLogger(ModalBudgetLineSetting.class);
	static public UI_Elements	TEXTBOX_BUDGET_EXCEPTION_WORKFLOW_UTILIZATION_LIMIT	= UIFactory.getElements("TEXTBOX_BUDGET_EXCEPTION_WORKFLOW_UTILIZATION_LIMIT");
	static public UI_Elements	TEXTBOX_OWNER_INCLUSION_UTILIZATION_LIMIT			= UIFactory.getElements("TEXTBOX_OWNER_INCLUSION_UTILIZATION_LIMIT");
	static public UI_Elements	TEXTBOX_EXCEED_PERCENTAGE_TOLERANCE					= UIFactory.getElements("TEXTBOX_EXCEED_PERCENTAGE_TOLERANCE");
	static public UI_Elements	TEXTBOX_EXCEED_AMOUNT_TOLERANCE						= UIFactory.getElements("TEXTBOX_EXCEED_AMOUNT_TOLERANCE");
	static public UI_Elements	BUTTON_SAVE_BUDGET_LINE_SETTINGS					= UIFactory.getElements("BUTTON_SAVE_BUDGET_LINE_SETTINGS");
	static public UI_Elements	BUTTON_CANCEL_BUDGET_LINE_SETTINGS					= UIFactory.getElements("BUTTON_CANCEL_BUDGET_LINE_SETTINGS");

	public static int fillBudgetExceptionWorkflowUtilizationLimit(WebDriver driver, String testCaseName, int percentage) throws ActionBotException
	{
		int enteredPercentage = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_BUDGET_EXCEPTION_WORKFLOW_UTILIZATION_LIMIT, Integer.toString(percentage)));
		logger.info("Entered Budget Exception Workflow Utilization Limit : " + enteredPercentage);
		return enteredPercentage;
	}

	public static float fillBudgetOwnerInclusionUtilizationLimit(WebDriver driver, String testCaseName, float limit) throws ActionBotException
	{
		float enteredLimit = Float.parseFloat(ActionBot.sendKeys(driver, TEXTBOX_OWNER_INCLUSION_UTILIZATION_LIMIT, Float.toString(limit)));
		logger.info("Entered Budget Owner Inclusion Utilization Limit : " + enteredLimit);
		return enteredLimit;
	}

	public static int fillExceedPercentageTolerance(WebDriver driver, String testCaseName, int percentage) throws ActionBotException
	{
		int enteredPercentage = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_EXCEED_PERCENTAGE_TOLERANCE, Integer.toString(percentage)));
		logger.info("Entered Exceed Percentage Tolerance : " + enteredPercentage);
		return enteredPercentage;
	}

	public static float fillExceedAmountTolerance(WebDriver driver, String testCaseName, float amount) throws ActionBotException
	{
		float enteredAmount = Float.parseFloat(ActionBot.sendKeys(driver, TEXTBOX_EXCEED_AMOUNT_TOLERANCE, Float.toString(amount)));
		logger.info("Entered Exceed Amount Tolerance : " + enteredAmount);
		return enteredAmount;
	}

	public static void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Button");
		ActionBot.click(driver, BUTTON_SAVE_BUDGET_LINE_SETTINGS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Button");
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Button");
		ActionBot.click(driver, BUTTON_CANCEL_BUDGET_LINE_SETTINGS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Button");
	}

	public static void clearExceedAmountTolerance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_EXCEED_AMOUNT_TOLERANCE);
	}

	public static void clearExceedPercentageTolerance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_EXCEED_PERCENTAGE_TOLERANCE);
	}

}
