/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.continueshopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.popups.defaults.IPopUpDefaultOperations;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author puneet.sharma
 *
 */
public interface IPopUpContinueShopping extends IPopUpDefaultOperations
{

	UI_Elements	CONTINUE_SHOPPING			= UIFactory.getElements("BUTTON_CONTINUE_SHOPPING_FOR_EMPTY_CART");
	By			CLOSE						= By.xpath("//*[text()='close']");
	By			CONTINUE_SHOPPING_POP_UP	= By.id("cart_noItemsContainer");

	void continueShopping(WebDriver driver, String testCaseName) throws ActionBotException;
}
