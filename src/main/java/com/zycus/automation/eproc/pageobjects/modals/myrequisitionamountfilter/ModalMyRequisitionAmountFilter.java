package com.zycus.automation.eproc.pageobjects.modals.myrequisitionamountfilter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalMyRequisitionAmountFilter
{

	static Logger logger = Logger.getLogger(ModalMyRequisitionAmountFilter.class);

	public int fillFromAmount(WebDriver driver, String testcaseName, int amount) throws ActionBotException
	{

		int frmAmt = 0;
		try
		{
			IModalMyRequisitionAmountFilter amtFilter = FactoryModal.getInstanceOfIModalMyRequisitionAmountFilter();
			frmAmt = amtFilter.fillFromAmount(driver, testcaseName, amount);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFromAmount " + e, e);
		}
		return frmAmt;
	}

	public int fillToAmount(WebDriver driver, String testcaseName, int amount) throws ActionBotException
	{
		int toAmt = 0;
		try
		{
			IModalMyRequisitionAmountFilter amtFilter = FactoryModal.getInstanceOfIModalMyRequisitionAmountFilter();
			toAmt = amtFilter.fillToAmount(driver, testcaseName, amount);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillToAmount " + e, e);
		}
		return toAmt;
	}

	public boolean checkINRCurrency(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionAmountFilter amtFilter = FactoryModal.getInstanceOfIModalMyRequisitionAmountFilter();
			amtFilter.checkINRCurrency(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkINRCurrency " + e, e);
		}
		return false;
	}

	public boolean checkUSDCurrency(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionAmountFilter amtFilter = FactoryModal.getInstanceOfIModalMyRequisitionAmountFilter();
			amtFilter.checkUSDCurrency(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkUSDCurrency " + e, e);
		}
		return false;
	}

	public void toClickClearFilter(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionAmountFilter amtFilter = FactoryModal.getInstanceOfIModalMyRequisitionAmountFilter();
			amtFilter.toClickClearFilter(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickClearFilter " + e, e);
		}

	}

	public void toClickFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionAmountFilter amtFilter = FactoryModal.getInstanceOfIModalMyRequisitionAmountFilter();
			amtFilter.toClickFilterBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickFilterBtn " + e, e);
		}

	}

	public void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionAmountFilter amtFilter = FactoryModal.getInstanceOfIModalMyRequisitionAmountFilter();
			amtFilter.toClickCancelBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCancelBtn " + e, e);
		}

	}

}
