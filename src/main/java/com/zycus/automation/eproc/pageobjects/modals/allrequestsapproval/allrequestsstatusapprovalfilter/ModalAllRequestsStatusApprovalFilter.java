/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsstatusapprovalfilter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAllRequestsStatusApprovalFilter
{

	static Logger logger = Logger.getLogger(ModalAllRequestsStatusApprovalFilter.class);

	public static boolean clickToApplyPendingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.clickToApplyPendingStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyPendingStatusFilter " + e, e);
		}
		return result;
	}

	public static boolean clickToApplyApprovedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.clickToApplyApprovedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyApprovedStatusFilter " + e, e);
		}
		return result;
	}

	public static boolean clickToApplyRejectedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.clickToApplyRejectedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyRejectedStatusFilter " + e, e);
		}
		return result;
	}

	public static boolean clickToApplyDelegatedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.clickToApplyDelegatedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyDelegatedStatusFilter " + e, e);
		}
		return result;
	}

	public static boolean clickToApplyUrgentRequestsOnlyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.clickToApplyUrgentRequestsOnlyStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyUrgentRequestsOnlyStatusFilter " + e, e);
		}
		return result;
	}

	public static boolean clickToApplyPendingSinceStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.clickToApplyPendingSinceStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyPendingSinceStatusFilter " + e, e);
		}
		return result;
	}

	public static boolean isPendingStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.isPendingStatusFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPendingStatusFilterSelected " + e, e);
		}
		return result;
	}

	public static boolean isApprovedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.isApprovedStatusFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isApprovedStatusFilterSelected " + e, e);
		}
		return result;
	}

	public static boolean isRejectedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.isRejectedStatusFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRejectedStatusFilterSelected " + e, e);
		}
		return result;
	}

	public static boolean isDelegatedStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.isDelegatedStatusFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDelegatedStatusFilterSelected " + e, e);
		}
		return result;
	}

	public static boolean isUrgentRequestsOnlyStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.isUrgentRequestsOnlyStatusFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isUrgentRequestsOnlyStatusFilterSelected " + e, e);
		}
		return result;
	}

	public static boolean isPendingSinceStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.isPendingSinceStatusFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPendingSinceStatusFilterSelected " + e, e);
		}
		return result;
	}

	public static int fillPendingSinceDaysInput(WebDriver driver, String testCaseName, int pendingSinceDays) throws ActionBotException
	{
		int result = 0;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.fillPendingSinceDaysInput(driver, testCaseName, pendingSinceDays);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPendingSinceDaysInput " + e, e);
		}
		return result;
	}

	public static int getPendingSinceDaysInput(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			result = statusApprovalFilter.getPendingSinceDaysInput(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPendingSinceDaysInput " + e, e);
		}
		return result;
	}

	public static void clickOnApplyStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			statusApprovalFilter.clickOnApplyStatusFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApplyStatusFilterButton " + e, e);
		}

	}

	public static void clickOnCancelStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			statusApprovalFilter.clickOnCancelStatusFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelStatusFilterButton " + e, e);
		}

	}

	public static void clickOnClearStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsStatusApprovalFilter statusApprovalFilter = FactoryModal.getInstanceOfIModalAllRequestsStatusApprovalFilter();
			statusApprovalFilter.clickOnClearStatusFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearStatusFilterButton " + e, e);
		}

	}

}
