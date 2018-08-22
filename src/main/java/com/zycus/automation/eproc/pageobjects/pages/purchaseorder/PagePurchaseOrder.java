package com.zycus.automation.eproc.pageobjects.pages.purchaseorder;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * 
 * @author amitkumar.dash
 *
 */
public class PagePurchaseOrder
{

	static Logger logger = Logger.getLogger(PagePurchaseOrder.class);

	public static void clickOnEditLink(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPagePurchaseOrder purchaseOrderImpl = FactoryPage.getInstanceOf(IPagePurchaseOrderImpl.class);
			purchaseOrderImpl.clickOnEditLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditLink " + e, e);
		}
	}

}
