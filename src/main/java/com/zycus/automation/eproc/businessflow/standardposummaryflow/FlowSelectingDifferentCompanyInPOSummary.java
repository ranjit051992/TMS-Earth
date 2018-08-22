package com.zycus.automation.eproc.businessflow.standardposummaryflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarybilling.ModalPurchaseOrderSummaryBilling;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class FlowSelectingDifferentCompanyInPOSummary
{
	static Logger				logger							= Logger.getLogger(FlowSelectingDifferentCompanyInPOSummary.class);

	final static UI_Elements	DIFFERENT_COMPANIES_PO_SUMMARY	= UIFactory.getElements("DIFFERENT_COMPANIES_PO_SUMMARY");

	/**
	 * 
	 * <b>Created On</b> : 21-Nov-2014 : 2:13:46 pm <b>User</b> : payal.alag
	 * <b>method Name</b> : selectDifferentCompanies <b>Description</b> :
	 * 
	 * @param driver
	 * @param testCaseName
	 * @param companies
	 * @throws ActionBotException
	 */

	public static void selectDifferentCompanies(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			/*
			 * int i = 1; List<WebElement> elements =
			 * ActionBot.findElements(driver, DIFFERENT_COMPANIES_PO_SUMMARY);
			 * for (WebElement ele : elements) { if
			 * (!ele.getText().trim().equalsIgnoreCase(companies)) { break; }
			 * i++; }
			 * 
			 * String str = ".//div[@class='treeContainer treeview']/ul/li[" + i
			 * + "]/"; ActionBot.click(driver, By.xpath(str + "/div"));
			 * ActionBot.click(driver, By.xpath(str + "ul/li[1]/div"));
			 * ActionBot.click(driver, By.xpath(str + "ul/li[1]//input"));
			 */

			ModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
			ModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
			ModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));

		}

		catch (Exception e)
		{
			logger.error("Exception in method selectDifferentCompanies", e);
		}
	}

}
