/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addtobasket;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalAddToBasket
{

	final static UI_Elements	SELECT_EXISTING_BASKET				= UIFactory.getElements("SELECT_EXISTING_BASKET");
	final static UI_Elements	SELECT_NEW_BASKET					= UIFactory.getElements("SELECT_NEW_BASKET");
	final static UI_Elements	SELECT_BASKET						= UIFactory.getElements("SELECT_BASKET");
	final static UI_Elements	TEXT_BASKET_NAME					= UIFactory.getElements("TEXT_BASKET_NAME");
	final static UI_Elements	BUTTON_ADD_TO_BASKET_CREATE_BASKET	= UIFactory.getElements("BUTTON_ADD_TO_BASKET_CREATE_BASKET");
	final static UI_Elements	BUTTON_CANCEL_ADD_TO_BASKET			= UIFactory.getElements("BUTTON_CANCEL_ADD_TO_BASKET");
	final static UI_Elements	ADD_TO_BASKET_SUCCESS_MSG			= UIFactory.getElements("ADD_TO_BASKET_SUCCESS_MSG");

	public void clickOnSelectExistingBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectExistingBasket(WebDriver driver, String testCaseName, String basketName) throws ActionBotException;

	public void clickOnCreateNewBasket(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillNewBasketName(WebDriver driver, String testCaseName, String basketName) throws ActionBotException;

	public void clickOnAddToBasketButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillAddToBasketSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException;

}
