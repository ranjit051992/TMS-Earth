/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectbuofceform;

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
public interface IModalSelectBUOfCEform
{
	static UI_Elements	CHECKBOX_COMPANIES_NAMES_FOR_CEFORM	= UIFactory.getElements("CHECKBOX_COMPANIES_NAMES_FOR_CEFORM");
	static UI_Elements	BUTTON_SAVE_ORG_UNIT_FOR_CFORM		= UIFactory.getElements("BUTTON_SAVE_ORG_UNIT_FOR_CFORM");
	static UI_Elements	BUTTON_CANCEL_ORG_UNIT_FOR_CFORM	= UIFactory.getElements("BUTTON_CANCEL_ORG_UNIT_FOR_CFORM");
	static UI_Elements	CHECKBOX_SELECT_IST_COMPANY			= UIFactory.getElements("CHECKBOX_SELECT_IST_COMPANY");
	static UI_Elements	CHECKBOX_SELECT_SEC_COMPANY			= UIFactory.getElements("CHECKBOX_SELECT_SEC_COMPANY");
	static UI_Elements	TAB_BU_SELECT_OU					= UIFactory.getElements("TAB_BU_SELECT_OU");
	static UI_Elements	LINK_SELECT_BU						= UIFactory.getElements("LINK_SELECT_BU");
	static UI_Elements	CHECKBOX_SELECT_ALL_OU_MODAL		= UIFactory.getElements("CHECKBOX_SELECT_ALL_OU_MODAL");
	static UI_Elements	BTN_SAVE_SELECTED_OUS				= UIFactory.getElements("BTN_SAVE_SELECTED_OUS");
	static UI_Elements	LINK_SELECT_ALL_BU					= UIFactory.getElements("LINK_SELECT_ALL_BU");
	static UI_Elements	SELECT_SEARCH_IN					= UIFactory.getElements("SELECT_SEARCH_IN");
	static UI_Elements	SEARCH_BU_TEXTBOX_EFORM				= UIFactory.getElements("SEARCH_BU_TEXTBOX_EFORM");
	static UI_Elements	SELECT_SEARCHED_FIRST_BU_EFORM		= UIFactory.getElements("SELECT_SEARCHED_FIRST_BU_EFORM");

	static UI_Elements	SELECT_SEARCH_NAME					= UIFactory.getElements("SELECT_SEARCH_NAME");
	static UI_Elements	SEARCH_COMPANY_TEXTBOX_EFORM		= UIFactory.getElements("SEARCH_COMPANY_TEXTBOX_EFORM");
	static UI_Elements	SELECT_SEARCHED_FIRST_COMPANY_EFORM	= UIFactory.getElements("SELECT_SEARCHED_FIRST_COMPANY_EFORM");

	public List<WebElement> getListOfCompanyNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveORGUnitButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelORGUnitButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String clickOnOU(WebDriver driver, String testCaseName, String OU) throws ActionBotException;

	public void selectAllOU(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListSelectedOFOUsForPEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearAllSelectedOUs(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isOUSelectedOrNot(WebDriver driver, String testCaseName, String ou) throws ActionBotException;

	public boolean isOUPresentOrNot(WebDriver driver, String testCaseName) throws ActionBotException;

	// select Ou [temp code till ui is not updated ]
	public void selectIstOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectSecOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickTabBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickLinkSelectBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void SelectCheckBoxOU(WebDriver driver, String testCaseName) throws ActionBotException;

	public void BtnSaveSelectedOU(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickLinkSelectAllBU(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickLink1StOU(WebDriver driver, String testCaseName) throws ActionBotException;

	public void SelectCheckBoxBusinessUnit(WebDriver driver, String testCaseName, String businessUnit) throws ActionBotException;

	public void SelectCheckBoxBusinessUnitByCode(WebDriver driver, String testCaseName, String businessUnit) throws ActionBotException;

	public void selectCompanyByName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

}
