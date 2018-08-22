package com.zycus.automation.eproc.pageobjects.pages.viewReceipt;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class PageViewReceipt
{
	public static String getShippedViaLabel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewReceipt iPageViewReceipt = FactoryPage.getInstanceOf(IPageViewReceiptImpl.class);
		return iPageViewReceipt.getShippedViaLabel(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 */

	public static String getItemInfoByHeaderName(WebDriver driver, String testCaseName, UI_Elements ui_Elements, String headerName, int index)
		throws ActionBotException, FactoryMethodException
	{
		IPageViewReceipt iPageViewReceipt = FactoryPage.getInstanceOf(IPageViewReceiptImpl.class);
		return iPageViewReceipt.getItemInfoByHeaderName(driver, testCaseName, ui_Elements, headerName, index);
	}

}
