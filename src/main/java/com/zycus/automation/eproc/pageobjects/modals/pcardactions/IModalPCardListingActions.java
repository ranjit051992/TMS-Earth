/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.pcardactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalPCardListingActions
{
	static UI_Elements	LINK_ACTIVATE_PCARD_ACTIONS		= UIFactory.getElements("LINK_ACTIVATE_PCARD_ACTIONS");
	static UI_Elements	LINK_EDIT_PCARD_ACTIONS			= UIFactory.getElements("LINK_EDIT_PCARD_ACTIONS");
	static UI_Elements	LINK_ARCHIVE_PCARD_ACTIONS		= UIFactory.getElements("LINK_ARCHIVE_PCARD_ACTIONS");
	static UI_Elements	LINK_DEACTIVATE_PCARD_ACTIONS	= UIFactory.getElements("LINK_DEACTIVATE_PCARD_ACTIONS");

	public void clickOnActivatePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditPCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnArchivePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactivatePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;
}
