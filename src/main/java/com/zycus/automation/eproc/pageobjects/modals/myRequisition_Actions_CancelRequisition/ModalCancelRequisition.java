package com.zycus.automation.eproc.pageobjects.modals.myRequisition_Actions_CancelRequisition;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalCancelRequisition
{

	static Logger logger = Logger.getLogger(ModalCancelRequisition.class);

	public static void fillCancelRequisitionComment(WebDriver driver, String testcaseName, String comment) throws ActionBotException
	{

		try
		{
			IModalCancelRequisition cancelReq = FactoryModal.getInstanceOfIModalCancelRequisition();
			cancelReq.fillCancelRequisitionComment(driver, testcaseName, comment);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCancelRequisitionComment " + e, e);
		}

	}

	public static void toClickCancelRequisitionBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalCancelRequisition cancelReq = FactoryModal.getInstanceOfIModalCancelRequisition();
			cancelReq.toClickCancelRequisitionBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCancelRequisitionBtn " + e, e);
		}

	}

	public static void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalCancelRequisition cancelReq = FactoryModal.getInstanceOfIModalCancelRequisition();
			cancelReq.toClickCancelBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCancelBtn " + e, e);
		}

	}

}
