package com.zycus.automation.eproc.pageobjects.pages.po;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPagePO
{

	final UI_Elements			BUTTON_ADD				= UIFactory.getElements("BUTTON_ADD");
	final UI_Elements			BUTTON_STANDARD_PO		= UIFactory.getElements("BUTTON_STANDARD_PO");
	final static UI_Elements	BUTTON_BLANKET_PO		= UIFactory.getElements("BUTTON_BLANKET_PO");
	final UI_Elements			TEXTBOX_PO_NUMBER		= UIFactory.getElements("TEXTBOX_PO_NUMBER");
	final UI_Elements			LINK_ACTIONS			= UIFactory.getElements("LINK_ACTIONS");

	final UI_Elements			LINK_PO_NUMBER			= UIFactory.getElements("LINK_PO_NUMBER");
	final UI_Elements			LINK_VIEW_AMMENDED_PO	= UIFactory.getElements("LINK_VIEW_AMMENDED_PO");

	public void clickOnAdd(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnStandardPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException;

	public void clickOnActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPONumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewAmmendedPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isViewAmmendedPOPrsent(WebDriver driver, String testCaseName) throws ActionBotException;

}
