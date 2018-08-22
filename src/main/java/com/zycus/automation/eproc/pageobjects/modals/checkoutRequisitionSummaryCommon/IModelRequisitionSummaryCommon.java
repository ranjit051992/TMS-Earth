package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCommon;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelRequisitionSummaryCommon
{

	final static UI_Elements	SAVEREQSUMMARY		= UIFactory.getElements("SAVEREQSUMMARY");
	final static UI_Elements	CANCLEREQSUMMARY	= UIFactory.getElements("CANCLEREQSUMMARY");

	void clickCancleReqSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickSaveReqSummary(WebDriver driver, String testCaseName) throws ActionBotException;

}
