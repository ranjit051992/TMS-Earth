/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.archivepcard;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalArchivePCard
{
	UI_Elements	TEXTBOX_ARCHIVE_COMMENTS	= UIFactory.getElements("TEXTBOX_ARCHIVE_COMMENTS");
	UI_Elements	SELECT_ARCHIVE_REASONS		= UIFactory.getElements("SELECT_ARCHIVE_REASONS");
	UI_Elements	BUTTON_ARCHIVE_PCARD		= UIFactory.getElements("BUTTON_ARCHIVE_PCARD");
	UI_Elements	BUTTON_CANCE_ARCHIVE_PCARD	= UIFactory.getElements("BUTTON_CANCE_ARCHIVE_PCARD");

	public String fillArchivingComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException;

	public String selectArchiveReasons(WebDriver driver, String testCaseName, String archiveReasons) throws ActionBotException;

	public void clickOnArchiveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelArchiveButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
