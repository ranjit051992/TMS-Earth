/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcompanypcard;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalSelectCompanyForPCard
{
	static UI_Elements	CHECKBOX_SELECT_COMPANY			= UIFactory.getElements("CHECKBOX_SELECT_COMPANY");
	static UI_Elements	BUTTON_SAVE_SELECTED_COMPANY	= UIFactory.getElements("BUTTON_SAVE_SELECTED_COMPANY");
	static UI_Elements	BUTTON_CANCEL_SELECTED_COMPANY	= UIFactory.getElements("BUTTON_CANCEL_SELECTED_COMPANY");

	public void selectAllCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException;

	public void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
