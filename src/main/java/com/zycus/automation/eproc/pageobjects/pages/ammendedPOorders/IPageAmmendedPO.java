package com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageAmmendedPO
{
	final UI_Elements	LINK_EDIT_AMMENDED_PO				= UIFactory.getElements("LINK_EDIT_AMMENDED_PO");
	final UI_Elements	BUTTON_ROLL_BACK					= UIFactory.getElements("BUTTON_ROLL_BACK");
	final UI_Elements	LINK_VIEW_All_PO_ON_AMMENDMENT_PAGE	= UIFactory.getElements("LINK_VIEW_All_PO_ON_AMMENDMENT_PAGE");
	final UI_Elements	LINK_FIRST_AMENDED_PO_NO			= UIFactory.getElements("LINK_FIRST_AMENDED_PO_NO");
	final UI_Elements	LINK_AMENDED_PO_NO_SAME_BUYER		= UIFactory.getElements("LINK_AMENDED_PO_NO_SAME_BUYER");
	final UI_Elements	LINK_AMENDED_PO_NO_DIFFERENT_BUYER	= UIFactory.getElements("LINK_AMENDED_PO_NO_DIFFERENT_BUYER");
	final UI_Elements	PO_NO_ALREADY_AMENDED_ALEART_MSG	= UIFactory.getElements("PO_NO_ALREADY_AMENDED_ALEART_MSG");
	final UI_Elements	LINK_LIST_OF_ALL_AMENDED_PO_NO		= UIFactory.getElements("LINK_LIST_OF_ALL_AMENDED_PO_NO");
	final UI_Elements	LINK_RECALL_APPROVAL_REQUEST		= UIFactory.getElements("LINK_RECALL_APPROVAL_REQUEST");
	static UI_Elements	PROCESSING_DIV_AMENDED_PO_LISTING	= UIFactory.getElements("PROCESSING_DIV_AMENDED_PO_LISTING");
	UI_Elements			LABEL_SUCCESS_MSG_AMENDED_BPO		= UIFactory.getElements("LABEL_SUCCESS_MSG_AMENDED_BPO");

	public void clickOnActions(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnEdit(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRollBackPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRollBack(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isViewAllPOPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmmendPONumberOfSameBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstAmendedPONo(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllAmendedPONos(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmmendPONumberOfDifferentBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getStatusOfAmendedPO(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnActionsOfSingleApprovalPO(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public void clickOnRecallApprovalRequestOfApprovalPO(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnActions(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public String getStatusOfAmendedPO(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException;

	public void clickOnAmendedPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException;

	public void clickOnFirstAmendAmendPoNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPoNoAlreadyAmendedAlertDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAmendedPOPresentInListing(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public int getNoOfAmendedPOPresentInListing(WebDriver driver, String testCaseName, String poNo) throws ActionBotException;

	public void waitTillRollBackPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRollBackButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewAllPO(WebDriver driver, String testCaseName) throws ActionBotException;

}
