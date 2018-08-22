/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.othernotification;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageOtherNotificationSetting
{
	static UI_Elements	LINK_BUYERS_DESK_INFO		= UIFactory.getElements("LINK_BUYERS_DESK_INFO");
	static UI_Elements	LINK_PO_RELEASED_INFO		= UIFactory.getElements("LINK_PO_RELEASED_INFO");
	static UI_Elements	TEXTBOX_SUBJECT_TEMPLATE	= UIFactory.getElements("TEXTBOX_SUBJECT_TEMPLATE");
	static UI_Elements	TEXTBOX_BODY_TEMPLATE		= UIFactory.getElements("TEXTBOX_BODY_TEMPLATE");

	public void clickOnBuyersDeskInfoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPOReleasedInfoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSubjectTemplate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBodyTemplate(WebDriver driver, String testCaseName) throws ActionBotException;
}
