/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addassignedbuyer;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalAddAssignedBuyer
{
	static UI_Elements	INPUT_ASSIGNED_BUYER_AT_BUYERS_DESK_LISTING				= UIFactory.getElements("INPUT_ASSIGNED_BUYER_AT_BUYERS_DESK_LISTING");
	static UI_Elements	TEXTAREA_BUYER_COMMENTS									= UIFactory.getElements("TEXTAREA_BUYER_COMMENTS");
	static UI_Elements	BUTTON_SAVE_BUYER										= UIFactory.getElements("BUTTON_SAVE_BUYER");
	static UI_Elements	BUTTON_BUYER_CANCEL										= UIFactory.getElements("BUTTON_BUYER_CANCEL");
	static UI_Elements	LABEL_ASSIGNED_BUYER_ON_CHANGED_BUYER_MODAL				= UIFactory.getElements("LABEL_ASSIGNED_BUYER_ON_CHANGED_BUYER_MODAL");
	static UI_Elements	DROPDOWN_BUYER_ICON										= UIFactory.getElements("DROPDOWN_BUYER_ICON");
	static UI_Elements	SELECT_SINGLE_BUYER_ICON								= UIFactory.getElements("SELECT_SINGLE_BUYER_ICON");
	static UI_Elements	SELECT_GROUP_BUYER_ICON									= UIFactory.getElements("SELECT_GROUP_BUYER_ICON");
	static UI_Elements	REMOVE_ASSIGNED_BUYER									= UIFactory.getElements("REMOVE_ASSIGNED_BUYER");
	UI_Elements			LABEL_ASSIGNED_BUYER_MANDATORY_READY_FOR_APPROVAL_PAGE	= UIFactory.getElements("LABEL_ASSIGNED_BUYER_MANDATORY_READY_FOR_APPROVAL_PAGE");

	public String fillAssignedBuyerName(WebDriver driver, String testCaseName, String assignedBuyerName) throws ActionBotException;

	public String fillChangedBuyerComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException;

	public void clickOnSaveAssignedBuyerButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelAssignedBuyerButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDropdownBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSingleBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGroupBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAssignedBuyerTextbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAssignedBuyerNameLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAssignedBuyerIsMandatoryPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
