/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.updatebudgetvalidity;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalUpdateBudgetValidity
{
	static UI_Elements	DATE_PICKER_UPDATE_VALIDITY_END_DATE	= UIFactory.getElements("DATE_PICKER_UPDATE_VALIDITY_END_DATE");

	static UI_Elements	INPUT_UPDATE_VALIDITY_END_DATE			= UIFactory.getElements("INPUT_UPDATE_VALIDITY_END_DATE");
	static UI_Elements	BUTTON_UPDATE_BUDGET_VALIDITY			= UIFactory.getElements("BUTTON_UPDATE_BUDGET_VALIDITY");
	static UI_Elements	BUTTON_CLOSE_BUDGET_VALIDITY			= UIFactory.getElements("BUTTON_CLOSE_BUDGET_VALIDITY");
	static UI_Elements	LOADING_STATUS_OVERLAY					= UIFactory.getElements("LOADING_STATUS_OVERLAY");

	public String selectEndDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public void clickOnUpdateBudgetValidityButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseUpdateBudgetValidityButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
