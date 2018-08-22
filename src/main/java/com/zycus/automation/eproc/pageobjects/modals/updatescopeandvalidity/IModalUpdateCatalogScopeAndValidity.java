/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.updatescopeandvalidity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalUpdateCatalogScopeAndValidity
{
	static UI_Elements	DATE_PICKER_TO_VALIDITY_DATE						= UIFactory.getElements("DATE_PICKER_TO_VALIDITY_DATE");
	static UI_Elements	TO_VALIDITY_DATE									= UIFactory.getElements("TO_VALIDITY_DATE");
	static UI_Elements	FROM_VALIDITY_DATE									= UIFactory.getElements("FROM_VALIDITY_DATE");
	static UI_Elements	CHECKBOX_SELECT_SCOPE								= UIFactory.getElements("CHECKBOX_SELECT_SCOPE");
	static UI_Elements	BUTTON_PUBLISH_CATALOG_ON_UPDATE_SCOPE_AND_VALIDITY	= UIFactory.getElements("BUTTON_PUBLISH_CATALOG_ON_UPDATE_SCOPE_AND_VALIDITY");
	static UI_Elements	BUTTON_CANCEL_CATALOG_ON_UPDATE_SCOPE_AND_VALIDITY	= UIFactory.getElements("BUTTON_CANCEL_CATALOG_ON_UPDATE_SCOPE_AND_VALIDITY");

	public String selectToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public List<WebElement> getListOfScopes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnScope(WebDriver driver, String testCaseName, String scopeName) throws ActionBotException;

	public void clickOnPublishButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFromDate(WebDriver driver, String testCaseName) throws ActionBotException;

}
