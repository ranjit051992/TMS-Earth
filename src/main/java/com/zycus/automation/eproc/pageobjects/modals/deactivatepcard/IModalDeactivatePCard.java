/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.deactivatepcard;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalDeactivatePCard
{
	UI_Elements	TEXTBOX_DEACTIVATE_COMMENTS		= UIFactory.getElements("TEXTBOX_DEACTIVATE_COMMENTS");
	UI_Elements	SELECT_DEACTIVATE_REASONS		= UIFactory.getElements("SELECT_DEACTIVATE_REASONS");
	UI_Elements	BUTTON_DEACTIVATE_PCARD			= UIFactory.getElements("BUTTON_DEACTIVATE_PCARD");
	UI_Elements	BUTTON_CANCE_DEACTIVATE_PCARD	= UIFactory.getElements("BUTTON_CANCE_DEACTIVATE_PCARD");

	public String fillDeactivateComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException;

	public String selectDeactivateReasons(WebDriver driver, String testCaseName, String deactivateReasons) throws ActionBotException;

	public void clickOnDeactivateButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelDeactivateButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
