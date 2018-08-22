package com.zycus.automation.eproc.pageobjects.modals.myRequisition_Actions_CancelRequisition;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalCancelRequisition
{
	final static UI_Elements	CANCEL_REQUISITION_COMMENT_BOX	= UIFactory.getElements("CANCEL_REQUISITION_COMMENT_BOX");
	final static UI_Elements	CANCEL_REQUISITION_BTN			= UIFactory.getElements("CANCEL_REQUISITION_BTN");
	final static UI_Elements	CANCEL_BOX						= UIFactory.getElements("CANCEL_BOX");

	void fillCancelRequisitionComment(WebDriver driver, String testcaseName, String comment) throws ActionBotException;

	void toClickCancelRequisitionBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException;

}
