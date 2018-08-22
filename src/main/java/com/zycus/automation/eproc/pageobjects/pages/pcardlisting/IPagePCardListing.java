/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.pcardlisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPagePCardListing
{
	static UI_Elements	BUTTON_ADD_PCARD					= UIFactory.getElements("BUTTON_ADD_PCARD");
	static UI_Elements	TEXTBOX_PCARD_TYPE					= UIFactory.getElements("TEXTBOX_PCARD_TYPE");
	static UI_Elements	TEXTBOX_PCARD_NO_ON_PCARD_LISTING	= UIFactory.getElements("TEXTBOX_PCARD_NO_ON_PCARD_LISTING");
	static UI_Elements	LINK_STATUS_FILTER					= UIFactory.getElements("LINK_STATUS_FILTER");
	static UI_Elements	LABEL_STATUS_OF_PCARD				= UIFactory.getElements("LABEL_STATUS_OF_PCARD");
	static UI_Elements	LINK_CLEAR_STATUS_FILTER_OF_PCARD	= UIFactory.getElements("LINK_CLEAR_STATUS_FILTER_OF_PCARD");
	static UI_Elements	LABEL_PCARD_TYPE_ON_PCARD_LISTING	= UIFactory.getElements("LABEL_PCARD_TYPE_ON_PCARD_LISTING");
	static UI_Elements	LABEL_PCARD_NO_ON_PCARD_LISTING		= UIFactory.getElements("LABEL_PCARD_NO_ON_PCARD_LISTING");
	static UI_Elements	LINK_PCARD_ACTIONS					= UIFactory.getElements("LINK_PCARD_ACTIONS");
	static UI_Elements	PROCESSING_PCARD_LISTING			= UIFactory.getElements("PROCESSING_PCARD_LISTING");

	static UI_Elements	LINK_EDIT_PCARD_ACTIONS				= UIFactory.getElements("LINK_EDIT_PCARD_ACTIONS");
	static UI_Elements	TEXT_ISSUED_TO						= UIFactory.getElements("TEXT_ISSUED_TO");

	public void clickOnAddPCardButtton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnStatusFilterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearStatusFilterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPCardActionsOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillPCardType(WebDriver driver, String testCaseName, String pCardType) throws ActionBotException;

	public String fillPCardNo(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException;

	public String getStatusOfPCard(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPCardTypeOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPCardNoOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException;

	/**
	 * @author sanjay.kundu
	 */
	public boolean isActionLinkEnable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEditLinkEnable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isActionButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	String getIssueToOfPCard(WebDriver driver, String testCaseName) throws ActionBotException;

}
