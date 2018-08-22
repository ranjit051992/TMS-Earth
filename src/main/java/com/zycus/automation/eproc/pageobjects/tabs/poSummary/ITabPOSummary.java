package com.zycus.automation.eproc.pageobjects.tabs.poSummary;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface ITabPOSummary
{
	final UI_Elements	TAB_COST_BOOKING_PO_SUMMARY	= UIFactory.getElements("TAB_COST_BOOKING_PO_SUMMARY");

	final UI_Elements	TAB_BILLING_PO_SUMMARY		= UIFactory.getElements("TAB_BILLING_PO_SUMMARY");

	final UI_Elements	TAB_DELIVERY_PO_SUMMARY		= UIFactory.getElements("TAB_DELIVERY_PO_SUMMARY");
	

	public void clickOnCostBookingPOSummary(WebDriver driver) throws ActionBotException;

	public void clickOnBillingPOSummary(WebDriver driver) throws ActionBotException;

	public void clickOnDeliveryPOSummary(WebDriver driver) throws ActionBotException;

}
