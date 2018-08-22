/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addassignedbuyer;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAddAssignedBuyer
{
	static Logger logger = Logger.getLogger(ModalAddAssignedBuyer.class);

	public static String fillAssignedBuyerName(WebDriver driver, String testCaseName, String assignedBuyerName) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			return addAssignedBuyer.fillAssignedBuyerName(driver, testCaseName, assignedBuyerName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in fillAssignedBuyerName method" + e, e);
		}
		return null;
	}

	public static String fillChangedBuyerComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			return addAssignedBuyer.fillChangedBuyerComments(driver, testCaseName, comments);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in fillChangedBuyerComments method" + e, e);
		}
		return null;
	}

	public static void clickOnSaveAssignedBuyerButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			addAssignedBuyer.clickOnSaveAssignedBuyerButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnSaveAssignedBuyerButton method" + e, e);
		}
	}

	public static void clickOnCancelAssignedBuyerButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			addAssignedBuyer.clickOnCancelAssignedBuyerButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnCancelAssignedBuyerButton method" + e, e);
		}
	}

	public static void clickOnDropdownBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			addAssignedBuyer.clickOnDropdownBuyerIcon(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnDropdownBuyerIcon method" + e, e);
		}
	}

	public static void clickOnSingleBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			addAssignedBuyer.clickOnSingleBuyerIcon(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnSingleBuyerIcon method" + e, e);
		}
	}

	public static void clickOnGroupBuyerIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			addAssignedBuyer.clickOnGroupBuyerIcon(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnGroupBuyerIcon method" + e, e);
		}
	}

	public static void clickOnAssignedBuyerTextbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			addAssignedBuyer.clickOnAssignedBuyerTextbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnAssignedBuyerTextbox method" + e, e);
		}
	}

	public static boolean isAssignedBuyerNameLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			return addAssignedBuyer.isAssignedBuyerNameLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isAssignedBuyerNameLabelPresent method" + e, e);
		}
		return flag;
	}

	public static void clickOnRemoveBuyer(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
		addAssignedBuyer.clickOnRemoveBuyer(driver, testCaseName);
	}

	public static boolean isAssignedBuyerIsMandatoryPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddAssignedBuyer addAssignedBuyer = FactoryPage.getInstanceOf(IModalAddAssignedBuyerImpl.class);
			return addAssignedBuyer.isAssignedBuyerIsMandatoryPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAssignedBuyerIsMandatoryPresent " + e, e);
		}
		return false;
	}

}
