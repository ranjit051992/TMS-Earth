/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsreceivedonfilter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAllRequestsApprovalReceivedOnFilter
{

	static Logger logger = Logger.getLogger(ModalAllRequestsApprovalReceivedOnFilter.class);

	public void clickOnFromDatePicker(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			receivedOnFilter.clickOnFromDatePicker(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFromDatePicker " + e, e);
		}

	}

	public void clickOnToDatePicker(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			receivedOnFilter.clickOnToDatePicker(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnToDatePicker " + e, e);
		}

	}

	public String selectFromDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			result = receivedOnFilter.selectFromDate(driver, testCaseName, day, month, year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFromDate " + e, e);
		}
		return result;
	}

	public String selectToDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			result = receivedOnFilter.selectToDate(driver, testCaseName, day, month, year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectToDate " + e, e);
		}
		return result;
	}

	public String getFromDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			result = receivedOnFilter.getFromDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFromDate " + e, e);
		}
		return result;
	}

	public String getToDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			result = receivedOnFilter.getToDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getToDate " + e, e);
		}
		return result;
	}

	public void clickOnReceivedOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			receivedOnFilter.clickOnReceivedOnFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReceivedOnFilterButton " + e, e);
		}

	}

	public void clickOnReceivedOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			receivedOnFilter.clickOnReceivedOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReceivedOnCancelButton " + e, e);
		}

	}

	public void clickOnReceivedOnClearButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalReceivedOnFilter receivedOnFilter = FactoryModal.getInstanceOfIModalAllRequestsApprovalReceivedOnFilter();
			receivedOnFilter.clickOnReceivedOnClearButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReceivedOnClearButton " + e, e);
		}

	}

}
