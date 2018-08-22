/**
 * 
 */
package com.zycus.automation.eproc.businessflow.myrequisitionsflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.MyRequisitionFilter;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IFlowMyRequisitionUtil
{

	static Logger logger = Logger.getLogger(IFlowMyRequisitionUtil.class);

	public static boolean checkIfRequisitionSearched(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		boolean result = false;
		if (ActionBot.isElementPresent(driver, IPageMyRequisition.DATA_TABLE_EMPTY))
		{
			logger.info("No records found");
			return result;
		}
		else
		{
			if (requisition.getReqNo() != null)
			{
				String searchedReqNo = PageMyRequisition.getFirstReqNo(driver, testCaseName);
				result = searchedReqNo.equalsIgnoreCase(requisition.getReqNo());
			}
			else if (requisition.getReqName() != null)
			{
				String searchedReqName = PageMyRequisition.getFirstReqName(driver, testCaseName);
				result = searchedReqName.contains(requisition.getReqName());
			}
			else if (requisition.getRequesterName() != null)
			{
				String searchedRequesterName = PageMyRequisition.getFirstRequester(driver, testCaseName);
				result = searchedRequesterName.equalsIgnoreCase(requisition.getRequesterName());
			}
		}
		return result;
	}

	public static boolean checkForStatusFilter(WebDriver driver, String testCaseName, MyRequisitionFilter myRequisitionFilter) throws ActionBotException
	{
		boolean statusFilterResult = false;
		int i = 0, totalReqCount = 0;
		String statusName, statusName2 = null, log = "";

		// list of status taken from My req page
		List<String> statusList = PageMyRequisition.getRequisitionStatusList(driver, testCaseName);
		totalReqCount = statusList.size();
		logger.info("After appying filter Total Requisition Count : " + totalReqCount);

		// list of status taken from MyRequisitionFilter bo
		List<String> statusOfFilter = myRequisitionFilter.getStatusOfFilter();
		statusName = statusOfFilter.get(0);
		if (statusOfFilter.size() > 1)
		{
			statusName2 = statusOfFilter.get(1);
		}
		if (totalReqCount != 0)
		{
			for (String status : statusList)
			{
				if (status.equalsIgnoreCase(statusName) || status.equalsIgnoreCase(statusName2) && statusName2 != null)
				{
					log += status + "\n";
					i++;
					if (i == totalReqCount)
					{
						statusFilterResult = true;
						break;
					}
				}
			}
			logger.info("Status of Requisitions are : \n " + log);
		}
		else
		{
			logger.info("No requisition found");
			statusFilterResult = true;
		}
		return statusFilterResult;
	}

	public static boolean checkIfRequisitionRecalled(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
		return PageMyRequisition.getStatusOfFirstReq(driver, testCaseName).equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
	}
}
