package com.zycus.automation.eproc.pageobjects.modals.pcardstatusfilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author Sanjay.kundu
 * 
 */
public interface IModalPCardListingStatusFilter
{

	static UI_Elements	CHECKBOX_SELECT_FILTER_DRAFT		= UIFactory.getElements("CHECKBOX_SELECT_FILTER_DRAFT");
	static UI_Elements	CHECKBOX_SELECT_FILTER_INUSE		= UIFactory.getElements("CHECKBOX_SELECT_FILTER_INUSE");
	static UI_Elements	CHECKBOX_SELECT_FILTER_DEACTIVATED	= UIFactory.getElements("CHECKBOX_SELECT_FILTER_DEACTIVATED");
	static UI_Elements	CHECKBOX_SELECT_FILTER_ARCHIVED		= UIFactory.getElements("CHECKBOX_SELECT_FILTER_ARCHIVED");
	static UI_Elements	LINK_FILTER_STATUS					= UIFactory.getElements("LINK_FILTER_STATUS");
	static UI_Elements	LINK_CANCEL_FILTER_STATUS			= UIFactory.getElements("LINK_CANCEL_FILTER_STATUS");

	public void clickOnDraftCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnInUseCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactivatedCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnArchivedCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFilterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFilterCancelLink(WebDriver driver, String testCaseName) throws ActionBotException;

}
