package com.zycus.automation.eproc.pageobjects.tabs.checkoutTabRequisitionSummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ASyncRequestNotCompletedInSpecifiedTimeException;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.PageloadNotCompletedInSpecifiedTimeException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface ITabCheckoutReqSummary
{

	final static UI_Elements	BILLING_TAB		= UIFactory.getElements("BILLING_TAB");
	final static UI_Elements	DELIVERY_TAB	= UIFactory.getElements("DELIVERY_TAB");
	final static UI_Elements	COSTBOOKING_TAB	= UIFactory.getElements("COSTBOOKING_TAB");

	void clickBillingTab(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickCostBookingTab(WebDriver driver, String testCaseName)
		throws ActionBotException, ASyncRequestNotCompletedInSpecifiedTimeException, PageloadNotCompletedInSpecifiedTimeException;

	void clickDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException;

}
