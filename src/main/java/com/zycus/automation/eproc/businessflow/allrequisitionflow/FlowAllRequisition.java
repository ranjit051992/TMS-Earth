/**
 * 
 */
package com.zycus.automation.eproc.businessflow.allrequisitionflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.IFlowMyRequisitionUtil;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class FlowAllRequisition
{
	static Logger logger = Logger.getLogger(FlowAllRequisition.class);

	public static Requisition searchReqInAllRequisitionTab(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnAllRequisitionsSubTab(driver);
		
		if (requisition.getReqNo() != null)
		{
			logger.info("Searching requisition using requisition number");
			String reqNo = requisition.getReqNo();
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, reqNo);
			ActionBot.defaultMediumSleep();
			requisition.setResult(IFlowMyRequisitionUtil.checkIfRequisitionSearched(driver, testCaseName, requisition));
		}
		else if (requisition.getReqName() != null)
		{
			logger.info("Searching requisition using requisition name");
			String reqName = requisition.getReqName();
			PageMyRequisition.fillReqName(driver, testCaseName, reqName);
			// ActionBot.defaultMediumSleep();
			requisition.setResult(IFlowMyRequisitionUtil.checkIfRequisitionSearched(driver, testCaseName, requisition));
		}
		// to fetch req external id if requisiton is searched
		if (requisition.isResult())
		{
			requisition.setId(PageMyRequisition.getRequisitionId(driver, testCaseName));
			if (requisition.getId() != null)
			{
				requisition.setRequisitionExternalId(PageMyRequisition.getRequisitionExternalId(driver, testCaseName, requisition.getId()));
			}
			else
			{
				logger.info("Requisiton Id not found. Req Id: " + requisition.getId());
			}
			requisition.setReqNo(PageMyRequisition.getFirstReqNo(driver, testCaseName));
			requisition.setRequesterName(PageMyRequisition.getFirstRequester(driver, testCaseName));
			requisition.setStatus(PageMyRequisition.getStatusOfFirstReq(driver, testCaseName));
			ScreenShot.screenshot(driver, testCaseName, "Search in All req tab");
		}

		return requisition;
	}
}
