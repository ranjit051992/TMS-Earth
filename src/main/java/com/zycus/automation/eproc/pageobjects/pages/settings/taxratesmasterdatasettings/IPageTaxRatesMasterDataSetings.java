package com.zycus.automation.eproc.pageobjects.pages.settings.taxratesmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageTaxRatesMasterDataSetings
{
	final static UI_Elements	LINK_ADD_TAX_RATE					= UIFactory.getElements("LINK_ADD_TAX_RATE");
	final static UI_Elements	SEARCH_TAX_TEXT_BOX					= UIFactory.getElements("SEARCH_TAX_TEXT_BOX");
	final static UI_Elements	TEXTBOX_TAXRATE						= UIFactory.getElements("TEXTBOX_TAXRATE");
	final static UI_Elements	ADD_TAX_TYPE						= UIFactory.getElements("ADD_TAX_TYPE");
	final static UI_Elements	TEXTBOX_NAME						= UIFactory.getElements("TEXTBOX_NAME");
	final static UI_Elements	TEXTBOX_UNIQUE_CODE					= UIFactory.getElements("TEXTBOX_UNIQUE_CODE");
	final static UI_Elements	COUNTRY_DROP_DOWN					= UIFactory.getElements("COUNTRY_DROP_DOWN");
	final static UI_Elements	TEXTBOX_CITY_TAX_RATE				= UIFactory.getElements("TEXTBOX_CITY_TAX_RATE");
	final static UI_Elements	TEXTBOX_COUNTY_TAX_RATE				= UIFactory.getElements("TEXTBOX_COUNTY_TAX_RATE");
	final static UI_Elements	AUTOCOMPLETE_CITY					= UIFactory.getElements("AUTOCOMPLETE_CITY");
	final static UI_Elements	ADD_TAX_RATE_BUTTON					= UIFactory.getElements("ADD_TAX_RATE_BUTTON");
	final static UI_Elements	FIRST_TAX_NAME						= UIFactory.getElements("FIRST_TAX_NAME");
	final static UI_Elements	TAX_DELETE_LINK						= UIFactory.getElements("TAX_DELETE_LINK");
	final static UI_Elements	TAX_DELETE_YES_BUTTON				= UIFactory.getElements("TAX_DELETE_YES_BUTTON");
	final static UI_Elements	TAX_EDIT_LINK						= UIFactory.getElements("TAX_EDIT_LINK");
	final static UI_Elements	TAX_BUTTON_GO						= UIFactory.getElements("TAX_BUTTON_GO");
	final static UI_Elements	TAX_SELECT_OPTION					= UIFactory.getElements("TAX_SELECT_OPTION");
	final static UI_Elements	SELECT_APPLY_THIS_TAX_MANUALLY		= UIFactory.getElements("SELECT_APPLY_THIS_TAX_MANUALLY");
	final static UI_Elements	SELECT_APPLY_THIS_TAX_AUTOMATICALLY	= UIFactory.getElements("SELECT_APPLY_THIS_TAX_AUTOMATICALLY");

	public void clickOnAddTaxRate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddTaxRateBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteTaxLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTaxEditLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteTaxYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyThisTaxManuallyBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyThisAutomaticallyBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillNameTaxRate(WebDriver driver, String testCaseName, String zycustax) throws ActionBotException;

	public String SearchTax(WebDriver driver, String testCaseName, String searchTax) throws ActionBotException;

	public String fillTaxType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillUniqueCode(WebDriver driver, String testCaseName, int Code) throws ActionBotException;

	public void fillTaxRate(WebDriver driver, String testCaseName, int Rate) throws ActionBotException;

	public String fillCountry(WebDriver driver, String testCaseName) throws ActionBotException;

	public int SelectCountry(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getTaxName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTaxRate(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isCityFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCountyFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean allowToEnterFreeTextCity(WebDriver driver, String testCaseName, String city) throws ActionBotException;

	public String selectOption(WebDriver driver, String testCaseName, String option) throws ActionBotException;

	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterCity(WebDriver driver, String testCaseName, String city) throws ActionBotException;

	public String enterCounty(WebDriver driver, String testCaseName, String county) throws ActionBotException;

}
