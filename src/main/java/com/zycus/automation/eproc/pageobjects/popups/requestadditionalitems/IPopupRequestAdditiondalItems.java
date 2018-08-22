/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.requestadditionalitems;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPopupRequestAdditiondalItems
{
	UI_Elements	BUTTON_KEEP_ITEM_AS_IT_IS		= UIFactory.getElements("BUTTON_KEEP_ITEM_AS_IT_IS");
	UI_Elements	BUTTON_DELETE_ITEM_IN_CART		= UIFactory.getElements("BUTTON_DELETE_ITEM_IN_CART");
	UI_Elements	BUTTON_CREATE_DRAFT_REQUISITION	= UIFactory.getElements("BUTTON_CREATE_DRAFT_REQUISITION");

	public void clickOnKeepItemAsItIsButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteItemInCart(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateDraftReauisition(WebDriver driver, String testCaseName) throws ActionBotException;

}
