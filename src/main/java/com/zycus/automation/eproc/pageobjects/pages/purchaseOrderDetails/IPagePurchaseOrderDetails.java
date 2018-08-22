package com.zycus.automation.eproc.pageobjects.pages.purchaseOrderDetails;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPagePurchaseOrderDetails
{

	final UI_Elements	COSTBOOKING_LINK					= UIFactory.getElements("COSTBOOKING_LINK");
	final UI_Elements	PROJECT_TASK_FIELD					= UIFactory.getElements("PROJECT_TASK_FIELD");
	final UI_Elements	REQ_LINK							= UIFactory.getElements("REQ_LINK");
	final UI_Elements	IS_REQUISITION_DETAILS_POPUP_WINDOW	= UIFactory.getElements("IS_REQUISITION_DETAILS_POPUP_WINDOW");
	final UI_Elements	COMMENT_FOR_SUPPLIER				= UIFactory.getElements("COMMENT_FOR_SUPPLIER");
	final UI_Elements	ITEMS_PO_LINK						= UIFactory.getElements("ITEMS_PO_LINK");

	public void clickOnCostBookingLink(WebDriver driver) throws ActionBotException;

	public String getProjectTaskName(WebDriver driver) throws ActionBotException;

	public String getCatalogItemName(WebDriver driver, String testCasename, int index) throws ActionBotException;

	public void clickOnCatalogItem(WebDriver driver, String testCasename, int index) throws ActionBotException;

	public void clickOnReqLink(WebDriver driver, String testCasename) throws ActionBotException;

	boolean veirfyOpenedRequisitionDetailsNewWindow(WebDriver driver, String testCasename, String parentWindow) throws ActionBotException;

	public String getCommentForSupplier(WebDriver driver) throws ActionBotException;

	boolean isCommentForSupplierAvailable(WebDriver driver) throws ActionBotException;

	boolean isAllItemsAvailable(WebDriver driver, int item_count) throws ActionBotException;

}
