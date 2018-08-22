/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.createsectionofceform;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalCreateSectionOfCEform
{
	static UI_Elements	TEXTBOX_SECTION_NAME_CEFORM		= UIFactory.getElements("TEXTBOX_SECTION_NAME_CEFORM");
	static UI_Elements	BUTTON_SAVE_SECTION_CEFORM		= UIFactory.getElements("BUTTON_SAVE_SECTION_CEFORM");
	static UI_Elements	BUTTON_CANCEL_SECTION_CEFORM	= UIFactory.getElements("BUTTON_CANCEL_SECTION_CEFORM");

	public String fillSectionName(WebDriver driver, String testCaseName, String sectionName) throws ActionBotException;

	public void clickOnSaveSectionButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelSectionButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
