package com.zycus.automation.iConsole.businessFlows.apiConsoleFlow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zycus.automation.bo.ApiConsole;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.iConsole.pageObjects.pages.apiConsole.PageApiConsole;
import com.zycus.automation.iConsole.pageObjects.tabs.headerLevelTabs.MainPageHeaderLevelTab;

/**
 * @author kunal.ashar
 */

public class FlowApiConsole
{
	static Logger logger = Logger.getLogger(FlowApiConsole.class);

	public static ApiConsole searchAndPerformApiActions(WebDriver driver, String testCaseName, ApiConsole apiConsole) throws ActionBotException
	{
		//navigate to API Console Page
		MainPageHeaderLevelTab.clickOnApiConsoleTab(driver, testCaseName);

		//to authenticate user
		if (apiConsole.isUserAuthenticationRequired())
		{
			//flow to authenticate user
			userAuthentication(driver, testCaseName, apiConsole);
		}

		//to select product
		if (apiConsole.getProductName() != null)
		{
			logger.info("------------Selecting Product: " + apiConsole.getProductName() + "------------");
			if (apiConsole.getProductName().equalsIgnoreCase(IConstants.eProc))
			{
				PageApiConsole.clickOnLinkEprocHeaderMenu(driver, testCaseName);
			}
		}

		//to select action (search/update)
		if (apiConsole.getApiAction() != null)
		{
			logger.info("------------Selecting Action: " + apiConsole.getApiAction() + "------------");
			if (apiConsole.getApiAction().equalsIgnoreCase(IConstantsData.API_ACTION_SEARCH))
			{
				apiConsole.setActionDisplayed(PageApiConsole.clickOnLinkSearchUnderEprocMenu(driver, testCaseName));
			}
			else if (apiConsole.getApiAction().equalsIgnoreCase(IConstantsData.API_ACTION_UPDATE))
			{
				apiConsole.setActionDisplayed(PageApiConsole.clickOnLinkUpdateUnderEprocMenu(driver, testCaseName));
			}
			else
			{
				logger.info("Invalid api action provided. Action: " + apiConsole.getApiAction());
			}
		}

		//to select api
		if (apiConsole.getApiName() != null)
		{
			logger.info("------------Selecting API: " + apiConsole.getApiName() + "------------");
			if (apiConsole.getApiName().equalsIgnoreCase(IConstantsData.API_REQUISITION_APPROVAL))
			{
				PageApiConsole.clickOnApiEprocRequisitonApproval(driver, testCaseName);
				apiConsole = performRequisitionAction(driver, testCaseName, apiConsole);
			}

			if (apiConsole.getApiName().equalsIgnoreCase(IConstantsData.API_PURCHASE_ORDER_APPROVAL))
			{
				PageApiConsole.clickOnApiEprocPOApproval(driver, testCaseName);
				apiConsole = performPurchaseOrderAction(driver, testCaseName, apiConsole);
			}

		}

		return apiConsole;
	}

	public static ApiConsole performRequisitionAction(WebDriver driver, String testCaseName, ApiConsole apiConsole) throws ActionBotException
	{
		//fill req ID
		if (apiConsole.getRequisitonId() != null)
		{
			PageApiConsole.fillRequisitonId(driver, testCaseName, apiConsole.getRequisitonId());
		}

		//fill req Action (approve/reject)
		if (apiConsole.getRequisitionAction() != null)
		{
			PageApiConsole.fillRequisitionApprovalAction(driver, testCaseName, apiConsole.getRequisitionAction());
		}

		//to click on Try It button
		PageApiConsole.clickOnButtonTryItReqApproval(driver, testCaseName);

		//to get response body
		PageApiConsole.clickOnTabResponseBodyReqApproval(driver, testCaseName);
		apiConsole.setResponseBody(PageApiConsole.getApiResponseBodyReqApproval(driver, testCaseName));

		return apiConsole;
	}

	public static ApiConsole performPurchaseOrderAction(WebDriver driver, String testCaseName, ApiConsole apiConsole) throws ActionBotException
	{
		//fill req ID
		if (apiConsole.getPurchaseOrderId() != null)
		{
			PageApiConsole.fillPurchaseOrderId(driver, testCaseName, apiConsole.getPurchaseOrderId());
		}

		//fill req Action (approve/reject)
		if (apiConsole.getPurchaseOrderAction() != null)
		{
			PageApiConsole.fillPOApprovalAction(driver, testCaseName, apiConsole.getPurchaseOrderAction());
		}

		//to click on Try It button
		PageApiConsole.clickOnButtonTryItPOApproval(driver, testCaseName);

		//to get response body
		PageApiConsole.clickOnTabResponseBodyPOApproval(driver, testCaseName);
		apiConsole.setResponseBody(PageApiConsole.getApiResponseBodyPOApproval(driver, testCaseName));

		return apiConsole;
	}

	public static ApiConsole userAuthentication(WebDriver driver, String testCaseName, ApiConsole apiConsole) throws ActionBotException
	{
		PageApiConsole.clickOnLinkAuthenticate(driver, testCaseName);
		PageApiConsole.clickOnButtonGoAuthenticationMechanismPopup(driver, testCaseName);

		if (apiConsole.getAuthenticationMpin() != null)
		{
			PageApiConsole.fillTextMpin(driver, testCaseName, apiConsole.getAuthenticationMpin());
		}

		PageApiConsole.clickOnButtonGoAuthenticationPopup(driver, testCaseName);
		boolean flag = PageApiConsole.verifyAuthenticationSuccessMessage(driver, testCaseName);
		Assert.assertTrue(flag, "failed to authenticate user");
		return apiConsole;
	}
}
