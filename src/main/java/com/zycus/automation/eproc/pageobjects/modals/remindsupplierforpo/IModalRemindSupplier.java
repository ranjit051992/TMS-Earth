/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.remindsupplierforpo;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalRemindSupplier
{
	static UI_Elements	TEXTBOX_REMIND_SUPPLIER_TO			= UIFactory.getElements("TEXTBOX_REMIND_SUPPLIER_TO");
	static UI_Elements	CHECKBOX_SEND_COPY_REMIND_SUPPLIER	= UIFactory.getElements("CHECKBOX_SEND_COPY_REMIND_SUPPLIER");
	static UI_Elements	LABEL_SELECTED_REMIND_SUPPLIER_TO	= UIFactory.getElements("LABEL_SELECTED_REMIND_SUPPLIER_TO");
	static UI_Elements	TEXTBOX_REMIND_MESSAGE				= UIFactory.getElements("TEXTBOX_REMIND_MESSAGE");
	static UI_Elements	LINK_REMIND_SUPPLIER_ATTACHMENT		= UIFactory.getElements("LINK_REMIND_SUPPLIER_ATTACHMENT");
	static UI_Elements	BUTTON_SEND_REMIND_SUPPLIER			= UIFactory.getElements("BUTTON_SEND_REMIND_SUPPLIER");
	static UI_Elements	BUTTON_CANCEL_REMIND_SUPPLIER		= UIFactory.getElements("BUTTON_CANCEL_REMIND_SUPPLIER");
	static UI_Elements	SUCCESS_MESSAGE_REMIND_SUPPLIER		= UIFactory.getElements("SUCCESS_MESSAGE_REMIND_SUPPLIER");

	public String fillRemindSupplierTo(WebDriver driver, String testCaseName, String to) throws ActionBotException;

	public String getSelectedRemindSupplierTo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendCopyCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillMessageForRemindSupplier(WebDriver driver, String testCaseName, String message) throws ActionBotException;

	public String getNameOfAttachment(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSuccessMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

}
