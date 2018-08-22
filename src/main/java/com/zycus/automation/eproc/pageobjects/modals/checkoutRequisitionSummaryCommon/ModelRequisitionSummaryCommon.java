package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCommon;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelRequisitionSummaryCommon
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickCancleReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelRequisitionSummaryCommon reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCommon();
			reqSummary.clickCancleReqSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancleReqSummary " + e, e);
		}
	}

	public static void clickSaveReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelRequisitionSummaryCommon reqSummary = FactoryModal.getInstanceOfIModelRequisitionSummaryCommon();
			reqSummary.clickSaveReqSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSaveReqSummary " + e, e);
		}

	}

}