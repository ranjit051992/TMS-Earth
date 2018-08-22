package com.zycus.automation.eproc.pageobjects.pages.settings.locationmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageLocationMasterDataSettings
{

	final static String	ACTIVE							= "active";
	final static String	INACTIVE						= "inactivate";

	final UI_Elements	TEXTBOX_SEARCH_LOCATION			= UIFactory.getElements("TEXTBOX_SEARCH_LOCATION");
	final UI_Elements	BUTTON_GO						= UIFactory.getElements("BUTTON_GO");
	final UI_Elements	BILL_TO_ADDRESS_OF_LOCATION		= UIFactory.getElements("BILL_TO_ADDRESS_OF_LOCATION");
	final UI_Elements	DELIVERY_ADDRESS_OF_LOCATION	= UIFactory.getElements("DELIVERY_ADDRESS_OF_LOCATION");
	final UI_Elements	LINK_ACTIVE_LOCATION			= UIFactory.getElements("LINK_ACTIVE_LOCATION");
	final UI_Elements	LINK_INACTIVE_LOCATION			= UIFactory.getElements("LINK_INACTIVE_LOCATION");

	public String fillSearchBox(WebDriver driver, String testCaseName, String location) throws ActionBotException;

	public void clickOnGo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBillTOAddressLocationFromMasterData(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDeliveryAddressLocationFromMasterData(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnInactiveLink(WebDriver driver, String testCaseName) throws ActionBotException;
}
