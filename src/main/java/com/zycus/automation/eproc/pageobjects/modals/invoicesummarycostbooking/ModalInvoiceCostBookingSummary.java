/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoicesummarycostbooking;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalInvoiceCostBookingSummary
{
	static Logger logger = Logger.getLogger(ModalInvoiceCostBookingSummary.class);

	public static String getAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.getAssignProjectToPurchaseCost(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAssignProjectToPurchaseCost " + e, e);
		}
		return null;
	}

	public static boolean isElementYesSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.isElementYesSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isElementYesSelected " + e, e);
		}
		return false;
	}

	public static boolean isElementNoSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.isElementNoSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isElementNoSelected " + e, e);
		}
		return false;
	}

	public static boolean isElementAssignProjectToPurchaseCostDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.isElementAssignProjectToPurchaseCostDisabled(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isElementAssignProjectToPurchaseCostDisabled " + e, e);
		}
		return false;
	}

	public static boolean isFieldProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.isFieldProjectDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isFieldProjectDisplayed " + e, e);
		}
		return false;
	}

	public static void clickOnProjectField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			costBookingSummary.clickOnProjectField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnProjectField " + e, e);
		}
	}

	public static String fillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.fillInProjectField(driver, testCaseName, projectField);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInProjectField " + e, e);
		}
		return null;
	}

	public static String fillInBudgetField(WebDriver driver, String testCaseName, String budgetField) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.fillInBudgetField(driver, testCaseName, budgetField);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInBudgetField " + e, e);
		}
		return null;
	}

	public static String fillInCostCenterField(WebDriver driver, String testCaseName, String costCenterField) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.fillInCostCenterField(driver, testCaseName, costCenterField);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInCostCenterField " + e, e);
		}
		return null;
	}

	public static boolean isAutocompleteFieldOfProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.isAutocompleteFieldOfProjectDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAutocompleteFieldOfProjectDisplayed " + e, e);
		}
		return false;
	}

	public static String getProjectCodeAndProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.getProjectCodeAndProjectName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getProjectCodeAndProjectName " + e, e);
		}
		return null;
	}

	public static boolean isProjectInAutocompleteFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.isProjectInAutocompleteFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isProjectInAutocompleteFieldPresent " + e, e);
		}
		return false;
	}

	public static void clickOnNoRadioBttn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			costBookingSummary.clickOnNoRadioBttn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNoRadioBttn " + e, e);
		}
	}

	public static boolean isInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalInvoiceCostBookingSummary costBookingSummary = FactoryPage.getInstanceOf(IModalInvoiceCostBookingSummaryImpl.class);
			return costBookingSummary.isInfoIconDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isInfoIconDisplayed " + e, e);
		}
		return false;
	}

}
