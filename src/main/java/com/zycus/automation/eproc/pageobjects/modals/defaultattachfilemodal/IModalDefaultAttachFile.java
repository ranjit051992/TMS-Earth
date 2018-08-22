/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.defaultattachfilemodal;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalDefaultAttachFile
{
	public void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName, UI_Elements ui_Elements) throws ActionBotException;

	public String getAttachmentName(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException;

	public String getAttachmentStatus(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException;

	public String getAttachmentSize(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException;

	public String selectItemVisibility(WebDriver driver, String testCaseName, UI_Elements ui_Elements, int index) throws ActionBotException;

	public String selectItemVisibility(WebDriver driver, String testCaseName, UI_Elements ui_Elements, String visibleText) throws ActionBotException;

	public void clickOnDoneButton(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException;

	public void clickOnDownloadAttachment(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException;

	public void clickOnFirstFileCheckbox(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException;

}
