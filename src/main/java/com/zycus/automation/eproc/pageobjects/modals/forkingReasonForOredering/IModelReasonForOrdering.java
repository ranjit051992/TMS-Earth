package com.zycus.automation.eproc.pageobjects.modals.forkingReasonForOredering;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelReasonForOrdering
{
	final static UI_Elements	FORKING_SAVE_REASON_FOR_ORDERING	= UIFactory.getElements("FORKING_SAVE_REASON_FOR_ORDERING");
	final static UI_Elements	FORKING_CANCLE_REASON_FOR_ORDERING	= UIFactory.getElements("FORKING_CANCLE_REASON_FOR_ORDERING");
	final static UI_Elements	FORKING_REASON_FOR_ORDERING_TEXT	= UIFactory.getElements("FORKING_REASON_FOR_ORDERING_TEXT");

	void clickCancleReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickSaveReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException;

	String provideReasonForOrdering(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException;
}
