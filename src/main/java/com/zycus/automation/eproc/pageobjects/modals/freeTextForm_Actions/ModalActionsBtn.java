package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_Actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalActionsBtn
{

	static Logger logger = Logger.getLogger(ModalActionsBtn.class);

	public void toClickViewLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalActionsBtn actionBtn = FactoryModal.getInstanceOfIModalActionsBtn();
			actionBtn.toClickViewLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickViewLink  " + e, e);
		}
	}

	public void toClickCopyLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalActionsBtn actionBtn = FactoryModal.getInstanceOfIModalActionsBtn();
			actionBtn.toClickCopyLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCopyLink " + e, e);
		}

	}

}
