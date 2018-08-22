package com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageProjectsSettings
{
	final static String			ALWAYS																= "always";
	final static String			NEVER																= "never";
	final static String			LET_USERS_DECIDE													= "letUsersdecide";

	final static UI_Elements	ASSIGN_PROJECT_TO_PURCHASE_COST_ALWAYS_PROJECT_SETTINGS				= UIFactory
		.getElements("ASSIGN_PROJECT_TO_PURCHASE_COST_ALWAYS_PROJECT_SETTINGS");
	final static UI_Elements	ASSIGN_PROJECT_TO_PURCHASE_COST_NEVER_PROJECT_SETTINGS				= UIFactory
		.getElements("ASSIGN_PROJECT_TO_PURCHASE_COST_NEVER_PROJECT_SETTINGS");
	final static UI_Elements	ASSIGN_PROJECT_TO_PURCHASE_COST_LET_USERS_DECIDE_PROJECT_SETTINGS	= UIFactory
		.getElements("ASSIGN_PROJECT_TO_PURCHASE_COST_LET_USERS_DECIDE_PROJECT_SETTINGS");
	final static UI_Elements	SAVE_PROJECT_SETTINGS												= UIFactory.getElements("SAVE_PROJECT_SETTINGS");

	final static UI_Elements	PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_NO_LINK					= UIFactory.getElements("PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_NO_LINK");

	//
	final static UI_Elements	PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_YES_LINK					= UIFactory.getElements("PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_YES_LINK");

	//
	final static UI_Elements	PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_LETS_USER_DECIDE_LINK	= UIFactory
		.getElements("PURCHASE_ORDER_COST_BOOKING_ASSIGN_PROJECT_LETS_USER_DECIDE_LINK");

	final static UI_Elements	RADIOBUTTON_ASSET_CODE_FOR_ASSIGNING_CODE_TO_ITEM_YES				= UIFactory
		.getElements("RADIOBUTTON_ASSET_CODE_FOR_ASSIGNING_CODE_TO_ITEM_YES");
	final static UI_Elements	RADIOBUTTON_ASSET_CODE_FOR_ASSIGNING_CODE_TO_ITEM_NO				= UIFactory.getElements("RADIOBUTTON_ASSET_CODE_FOR_ASSIGNING_CODE_TO_ITEM_NO");

	public boolean isAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isYesSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean assignProjectSettingEnabledOrDisabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAlways(WebDriver driver) throws ActionBotException;

	public boolean clickOnNever(WebDriver driver) throws ActionBotException;

	public boolean clickOnLetUsersDecide(WebDriver driver) throws ActionBotException;

	public String getAssignProjectToPurchaseCost(WebDriver driver) throws ActionBotException;

	public boolean clickOnSave(WebDriver driver) throws ActionBotException;
	
	public boolean clickOnDisplayAssetCodeForAssigningCodeToItem_Yes(WebDriver driver) throws ActionBotException;
	
	public boolean clickOnDisplayAssetCodeForAssigningCodeToItem_No(WebDriver driver) throws ActionBotException;

}
