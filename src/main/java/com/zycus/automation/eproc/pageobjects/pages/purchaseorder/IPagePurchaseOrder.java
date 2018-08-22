package com.zycus.automation.eproc.pageobjects.pages.purchaseorder;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPagePurchaseOrder
{

	// .//*[@id='changeDelBillingSumm']
	final static UI_Elements PURCHASE_ORDER_BILLING_EDIT_LINK = UIFactory.getElements("PURCHASE_ORDER_BILLING_EDIT_LINK");

	public void clickOnEditLink(WebDriver driver, String testCaseName) throws Exception;

}
