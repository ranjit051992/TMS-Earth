/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalPOItemSummaryCostAllocation
{
	static Logger logger = Logger.getLogger(ModalPOItemSummaryCostAllocation.class);

	public static void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			poItemSummaryCostAllocation.clickOnCostBookingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCostBookingTab " + e, e);
		}
	}

	public static String fillAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.fillAmount(driver, testCaseName, amount);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAmount " + e, e);
		}
		return null;
	}

	public static String clearAndfillAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.clearAndfillAmount(driver, testCaseName, amount);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearAndfillAmount " + e, e);
		}
		return null;
	}

	public static String fillBudget(WebDriver driver, String testCaseName, String budget) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.fillBudget(driver, testCaseName, budget);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBudget " + e, e);
		}
		return null;
	}

	public static String fillCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.fillCostCenter(driver, testCaseName, costCenter);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostCenter " + e, e);
		}
		return null;
	}

	public static String fillProject(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.fillProject(driver, testCaseName, project);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProject " + e, e);
		}
		return null;
	}

	public static String getAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAmount " + e, e);
		}
		return null;
	}

	public static boolean isEditableAmendItemDescription(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isEditableAmendItemDescription(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEditableAmendItemDescription " + e, e);
		}
		return false;
	}

	public static boolean isEditableAmendModelItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isEditableAmendModelItemQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEditableAmendModelItemQuantity " + e, e);
		}
		return false;
	}

	public static boolean isEditableMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isEditableMarketPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEditableMarketPrice " + e, e);
		}
		return false;
	}

	public static String getCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getCostCenter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenter " + e, e);
		}
		return null;
	}

	public static String fillGLAccount(WebDriver driver, String glAccount) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillGLAccount " + e, e);
		}
		return null;
	}

	public static boolean isGLAccountFieldFilled(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isGLAccountFieldFilled(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isGLAccountFieldFilled " + e, e);
		}
		return false;
	}

	public static void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			poItemSummaryCostAllocation.clickOnSave(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSave " + e, e);
		}
	}

	public static void clickOnCancel(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			poItemSummaryCostAllocation.clickOnCancel(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancel " + e, e);
		}
	}

	public static boolean isGLAccountSameAsGLMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isGLAccountSameAsGLMap(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isGLAccountSameAsGLMap " + e, e);
		}
		return false;
	}

	public static String getGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getGLAccount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getGLAccount " + e, e);
		}
		return null;
	}

	public static String getTagNameOfProjectFieldLabel(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getTagNameOfProjectFieldLabel(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTagNameOfProjectFieldLabel " + e, e);
		}
		return null;
	}

	public static String getItemlevelCostingdetails(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getItemlevelCostingdetails(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemlevelCostingdetails " + e, e);
		}
		return null;
	}

	public static String getItemlevelProjectdetails(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getItemlevelProjectdetails(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemlevelProjectdetails " + e, e);
		}
		return null;
	}

	public static boolean isProjectFieldALabel(WebDriver driver)
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isProjectFieldALabel(driver);
		}
		catch (Exception e)
		{
			logger.error("Exception in method isProjectFieldALabel " + e, e);
		}
		return false;
	}

	public static boolean isProjectOrTaskIconPresent(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isProjectOrTaskIconPresent(driver);
		}
		catch (Exception e)
		{
			logger.error("Exception in method isProjectOrTaskIconPresent " + e, e);
		}
		return false;
	}

	public static boolean isProjectInfoIconPresent(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isProjectInfoIconPresent(driver);
		}
		catch (Exception e)
		{
			logger.error("Exception in method isProjectInfoIconPresent " + e, e);
		}
		return false;
	}

	public static String getaccuntTypeErrorMsg(WebDriver driver, String accountTypeErrorMsg) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getaccuntTypeErrorMsg(driver, accountTypeErrorMsg);
		}
		catch (Exception e)
		{
			logger.error("Exception in method getaccuntTypeErrorMsg " + e, e);
		}
		return null;
	}

	public static boolean isGLAccountNotEmpty(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.isGLAccountNotEmpty(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Exception in method isGLAccountNotEmpty " + e, e);
		}
		return false;
	}

	public static void clearGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			poItemSummaryCostAllocation.clearGLAccount(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Exception in method clearGLAccount " + e, e);
		}
	}

	public static List<String> getListOfGLAccountsNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getListOfGLAccountsNames(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Exception in method getListOfGLAccountsNames " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 *         method to get the default value of project
	 */
	public static String getProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getProject(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Exception in method getProject " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 *         method to get the default value of budget
	 */
	public static String getBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.getBudget(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Exception in method getBudget " + e, e);
		}
		return null;
	}

	public static void clickOnDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			poItemSummaryCostAllocation.clickOnDeliveryTab(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Exception in method clickOnDeliveryTab " + e, e);
		}
	}

	public static void clickOnOtherAddressOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			poItemSummaryCostAllocation.clickOnOtherAddressOption(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Exception in method clickOnOtherAddressOption " + e, e);
		}
	}

	public static String fillOtherDeliveryAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException
	{
		try
		{
			IModalPOItemSummaryCostAllocation poItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOItemSummaryCostAllocationImpl.class);
			return poItemSummaryCostAllocation.fillOtherDeliveryAddress(driver, testCaseName, address);
		}
		catch (Exception e)
		{
			logger.error("Exception in method fillOtherDeliveryAddress " + e, e);
		}
		return null;
	}
}
