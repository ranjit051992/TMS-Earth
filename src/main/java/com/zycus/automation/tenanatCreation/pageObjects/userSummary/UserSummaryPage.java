package com.zycus.automation.tenanatCreation.pageObjects.userSummary;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.bo.Roles;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface UserSummaryPage
{

	public static UI_Elements	ROLE_EDIT_ICON						= UIFactory.getElements("ROLE_EDIT_ICON");
	public static UI_Elements	TEXT_PAGE_NUMBER_ROLES				= UIFactory.getElements("TEXT_PAGE_NUMBER_ROLES");
	public static UI_Elements	TEXTBOX_PAGE_NUMBER_DISPLAYED_ROLES	= UIFactory.getElements("TEXTBOX_PAGE_NUMBER_DISPLAYED_ROLES");
	public static UI_Elements	BUTTON_NAVIGATE_TO_NEXT_PAGE_ROLES	= UIFactory.getElements("BUTTON_NAVIGATE_TO_NEXT_PAGE_ROLES");

	static String				xpath_RoleName_label				= ".//*[@id='dataGrid']/tbody//td[2]";
	static String				xpath_AssignedToProduct_Label		= ".//*[@id='dataGrid']/tbody//td[3]";
	static String				xpath_RoleType_Label				= ".//*[@id='dataGrid']/tbody//td[4]";
	static String				xpath_checkbox_roles				= ".//input[@type='checkBox']";

	public void selectRoles(WebDriver driver, String testCaseName, List<Roles> roles) throws ActionBotException;
	
	public void searchRole(WebDriver driver, String testCaseName, String role) throws ActionBotException;
	

}
