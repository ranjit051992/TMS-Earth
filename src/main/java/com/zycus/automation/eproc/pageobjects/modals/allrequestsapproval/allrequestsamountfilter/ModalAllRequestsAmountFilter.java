/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsamountfilter;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAllRequestsAmountFilter
{

	static Logger logger = Logger.getLogger(ModalAllRequestsAmountFilter.class);

	public double fillFromAmountRange(WebDriver driver, String testCaseName, double fromAmountRange) throws ActionBotException
	{
		double result = 0;
		try
		{
			IModalAllRequestsAmountFilter allRequestsAmountFilter = FactoryModal.getInstanceOfIModalAllRequestsAmountFilter();
			result = allRequestsAmountFilter.fillFromAmountRange(driver, testCaseName, fromAmountRange);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFromAmountRange " + e, e);
		}
		return result;
	}

	public double fillToAmountRange(WebDriver driver, String testCaseName, double toAmountRange) throws ActionBotException
	{
		double result = 0;
		try
		{
			IModalAllRequestsAmountFilter allRequestsAmountFilter = FactoryModal.getInstanceOfIModalAllRequestsAmountFilter();
			result = allRequestsAmountFilter.fillToAmountRange(driver, testCaseName, toAmountRange);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillToAmountRange " + e, e);
		}
		return result;
	}

	public double getFromAmountRange(WebDriver driver, String testCaseName) throws ActionBotException
	{
		double result = 0;
		try
		{
			IModalAllRequestsAmountFilter allRequestsAmountFilter = FactoryModal.getInstanceOfIModalAllRequestsAmountFilter();
			result = allRequestsAmountFilter.getFromAmountRange(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFromAmountRange " + e, e);
		}
		return result;
	}

	public double getToAmountRange(WebDriver driver, String testCaseName) throws ActionBotException
	{
		double result = 0;
		try
		{
			IModalAllRequestsAmountFilter allRequestsAmountFilter = FactoryModal.getInstanceOfIModalAllRequestsAmountFilter();
			result = allRequestsAmountFilter.getToAmountRange(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getToAmountRange " + e, e);
		}
		return result;
	}

	public List<WebElement> selectAllCurrencies(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> result = null;
		try
		{
			IModalAllRequestsAmountFilter allRequestsAmountFilter = FactoryModal.getInstanceOfIModalAllRequestsAmountFilter();
			result = allRequestsAmountFilter.selectAllCurrencies(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllCurrencies " + e, e);
		}
		return result;
	}

	public void clickOnApplyAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsAmountFilter allRequestsAmountFilter = FactoryModal.getInstanceOfIModalAllRequestsAmountFilter();
			allRequestsAmountFilter.clickOnApplyAmountFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApplyAmountFilterButton " + e, e);
		}

	}

	public void clickOnCancelAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsAmountFilter allRequestsAmountFilter = FactoryModal.getInstanceOfIModalAllRequestsAmountFilter();
			allRequestsAmountFilter.clickOnCancelAmountFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelAmountFilterButton " + e, e);
		}

	}

	public void clickOnClearAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsAmountFilter allRequestsAmountFilter = FactoryModal.getInstanceOfIModalAllRequestsAmountFilter();
			allRequestsAmountFilter.clickOnClearAmountFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearAmountFilterButton " + e, e);
		}

	}

}
