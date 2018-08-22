package com.zycus.automation.eproc.pageobjects.pages.settings.configurationSetting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageConfigurationSetting
{
	final static UI_Elements	LINK_COMPANY									= UIFactory.getElements("LINK_COMPANY");
	final static UI_Elements	DROPDOWN_COMPANY_NAME							= UIFactory.getElements("DROPDOWN_COMPANY_NAME");
	final static UI_Elements	DEFAULT_BUYER_FOR_AUTO_COMPANY					= UIFactory.getElements("DEFAULT_BUYER_FOR_AUTO_COMPANY");
	final static UI_Elements	BUTTON_UPDATE_COMPANY							= UIFactory.getElements("BUTTON_UPDATE_COMPANY");
	final static UI_Elements	LINK_BUSSINESS_UNIT								= UIFactory.getElements("LINK_BUSSINESS_UNIT");
	final static UI_Elements	DROPDOWN_SELECT_COMPANY_BU						= UIFactory.getElements("DROPDOWN_SELECT_COMPANY_BU");
	final static UI_Elements	DROPDOWN_SELECT_BUSINESS_UNIT					= UIFactory.getElements("DROPDOWN_SELECT_BUSINESS_UNIT");
	final static UI_Elements	LINK_LOCATION									= UIFactory.getElements("LINK_LOCATION");
	final static UI_Elements	DEFAULT_BUYER_FOR_AUTO_BU						= UIFactory.getElements("DEFAULT_BUYER_FOR_AUTO_BU");
	final static UI_Elements	BUTTON_UPDATE_BU								= UIFactory.getElements("BUTTON_UPDATE_BU");
	final static UI_Elements	DROPDOWN_LOCATION_COMPANY						= UIFactory.getElements("DROPDOWN_LOCATION_COMPANY");
	final static UI_Elements	DROPDOWN_LOCATION_BU							= UIFactory.getElements("DROPDOWN_LOCATION_BU");
	final static UI_Elements	DROPDOWN_LOCATION								= UIFactory.getElements("DROPDOWN_LOCATION");
	final static UI_Elements	DEFAULT_BUYER_FOR_AUTO_LOCATION					= UIFactory.getElements("DEFAULT_BUYER_FOR_AUTO_LOCATION");
	final static UI_Elements	BUTTON_UPDATE_LOCATION							= UIFactory.getElements("BUTTON_UPDATE_LOCATION");
	final static UI_Elements	TEXTBOX_EPROC_COMPANY_PO_TERMS_AND_CONDITIONS	= UIFactory.getElements("TEXTBOX_EPROC_COMPANY_PO_TERMS_AND_CONDITIONS");

	public void clickOnCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException;

	public String enterDefaultBuyerForCompany(WebDriver driver, String testCaseName, String defaultBuyer) throws ActionBotException;

	public void clickOnUpdateCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectCompanyForBU(WebDriver driver, String testCaseName, String companyForBU) throws ActionBotException;

	public String selectBU(WebDriver driver, String testCaseName, String BU) throws ActionBotException;

	public String enterDefaultBuyerForBU(WebDriver driver, String testCaseName, String BUBuyer) throws ActionBotException;

	public void clickOnUpdateBU(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectCompanyForLocation(WebDriver driver, String testCaseName, String companyForLocation) throws ActionBotException;

	public String selectBUForLocation(WebDriver driver, String testCaseName, String BUForLocation) throws ActionBotException;

	public String selectLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException;

	public String enterDefaultBuyerForLocation(WebDriver driver, String testCaseName, String LocationBuyer) throws ActionBotException;

	public void clickOnUpdateLocation(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterMaxTermsAndConditions(WebDriver driver, String testCaseName, String termsAndConditions) throws ActionBotException;
}
