package com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalRequisitionFilter
{

	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public boolean clickToApplyDraftFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyDraftFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyDraftFilter " + e, e);
		}
		return false;
	}

	public boolean clickToApplyReadyForApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyReadyForApprovalFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyReadyForApprovalFilter " + e, e);
		}
		return false;
	}

	public boolean clickToApplyInApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyInApprovalFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyInApprovalFilter " + e, e);
		}
		return false;
	}

	public boolean clickToApplyWithBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyWithBuyerFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyWithBuyerFilter " + e, e);
		}
		return false;
	}

	public boolean clickToApplyScheduledFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyScheduledFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyScheduledFilter " + e, e);
		}
		return false;
	}

	public boolean clickToApplyReleasedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyReleasedFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyReleasedFilter " + e, e);
		}
		return false;
	}

	public boolean clickToApplyPartiallyOrderedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyPartiallyOrderedFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyPartiallyOrderedFilter" + e, e);
		}
		return false;
	}

	public boolean clickToApplyFullyReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyFullyReceivedFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyFullyReceivedFilter" + e, e);
		}
		return false;
	}

	public boolean clickToApplyRejectedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyRejectedFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyRejectedFilter" + e, e);
		}
		return false;
	}

	public boolean clickToApplyClosedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyClosedFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyDraftFilter" + e, e);
		}
		return false;
	}

	public boolean clickToApplyCancelledFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyDraftFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyDraftFilter" + e, e);
		}
		return false;
	}

	public boolean clickToApplyReturnedWithQouteFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyDraftFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyDraftFilter" + e, e);
		}
		return false;
	}

	public boolean clickToApplySetForQuoteFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModalRequisitionFilter filter = FactoryModal.getInstanceOfIHomePageMainTab();
			filter.clickToApplyDraftFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyDraftFilter" + e, e);
		}
		return false;
	}

}
