package com.zycus.automation.eproc.pageobjects.pages.settings.addressmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageAddressMasterDataSettings
{
	final static UI_Elements	LINK_ADD_ADDRESS			= UIFactory.getElements("LINK_ADD_ADDRESS");
	final static UI_Elements	TEXTBOX_CITY_ADDRESS		= UIFactory.getElements("TEXTBOX_CITY_ADDRESS");
	final static UI_Elements	TEXTBOX_COUNTY_ADDRESS		= UIFactory.getElements("TEXTBOX_COUNTY_ADDRESS");
	final static UI_Elements	AUTOCOMPLETE_COUNTY_FIELD	= UIFactory.getElements("AUTOCOMPLETE_COUNTY_FIELD");

	public void clickOnAddAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterCity(WebDriver driver, String testCaseName, String city) throws ActionBotException;

	public String enterCounty(WebDriver driver, String testCaseName, String county) throws ActionBotException;

	public String enterFreeTextCounty(WebDriver driver, String testCaseName, String freeTextCounty) throws ActionBotException;

}
