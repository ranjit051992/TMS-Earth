/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalBuersDeskListingActions
{

	static UI_Elements	BUYERS_DESK_LISTING_EDIT_ACTION				= UIFactory.getElements("BUYERS_DESK_LISTING_EDIT_ACTION");
	static UI_Elements	BUYERS_DESK_LISTING_CONVERT_TO_PO_ACTION	= UIFactory.getElements("BUYERS_DESK_LISTING_CONVERT_TO_PO_ACTION");
	static UI_Elements	BUYERS_DESK_LISTING_CHANGE_BUYER_ACTION		= UIFactory.getElements("BUYERS_DESK_LISTING_CHANGE_BUYER_ACTION");
	static UI_Elements	BUYERS_DESK_LISTING_REJECT_ACTION			= UIFactory.getElements("BUYERS_DESK_LISTING_REJECT_ACTION");
	static UI_Elements	BUYERS_DESK_LISTING_VIEW_ACTION				= UIFactory.getElements("BUYERS_DESK_LISTING_VIEW_ACTION");

	public void clickOnEditAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnConvertToPOAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnChangeBuyerAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRejectAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRejectActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEditActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isViewActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isConvertToPOActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isChangeBuyerActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
