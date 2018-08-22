/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsdocumenttypefilter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAllRequestsDocumentTypeFilter
{

	static Logger logger = Logger.getLogger(IModalAllRequestsDocumentTypeFilter.class);

	public boolean clickToApplyRequisitionDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			result = documentTypeFilter.clickToApplyRequisitionDocumentTypeFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyRequisitionDocumentTypeFilter " + e, e);
		}
		return result;
	}

	public boolean clickToApplyPurchaseOrderDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			result = documentTypeFilter.clickToApplyPurchaseOrderDocumentTypeFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyPurchaseOrderDocumentTypeFilter " + e, e);
		}
		return result;
	}

	public boolean clickToApplyPOAmendDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			result = documentTypeFilter.clickToApplyPOAmendDocumentTypeFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyPOAmendDocumentTypeFilter " + e, e);
		}
		return result;
	}

	public boolean clickToApplyInvoiceDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			result = documentTypeFilter.clickToApplyInvoiceDocumentTypeFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyInvoiceDocumentTypeFilter " + e, e);
		}
		return result;
	}

	public boolean isRequisitionDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			result = documentTypeFilter.isRequisitionDocumentTypeFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRequisitionDocumentTypeFilterSelected " + e, e);
		}
		return result;
	}

	public boolean isPurchaseOrderDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			result = documentTypeFilter.isPurchaseOrderDocumentTypeFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPurchaseOrderDocumentTypeFilterSelected " + e, e);
		}
		return result;
	}

	public boolean isPOAmendDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			result = documentTypeFilter.isPOAmendDocumentTypeFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPOAmendDocumentTypeFilterSelected " + e, e);
		}
		return result;
	}

	public boolean isInvoiceDocumentTypeFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			result = documentTypeFilter.isInvoiceDocumentTypeFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isInvoiceDocumentTypeFilterSelected " + e, e);
		}
		return result;
	}

	public void clickOnApplyDocumentTypeFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			documentTypeFilter.clickOnApplyDocumentTypeFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApplyDocumentTypeFilterButton " + e, e);
		}

	}

	public void clickOnDocumentTypeCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			documentTypeFilter.clickOnDocumentTypeCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDocumentTypeCancelButton " + e, e);
		}

	}

	public void clickOnDocumentTypeClearButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsDocumentTypeFilter documentTypeFilter = FactoryModal.getInstanceOfIModalAllRequestsDocumentTypeFilter();
			documentTypeFilter.clickOnDocumentTypeClearButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDocumentTypeClearButton " + e, e);
		}

	}

}
