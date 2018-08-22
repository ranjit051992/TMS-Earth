/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.showallpos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalShowAllPos
{
	static Logger logger = Logger.getLogger(ModalShowAllPos.class);

	public static void clickOnSelectPoBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			showAllPos.clickOnSelectPoBtn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectPoBtn " + e, e);
		}

	}

	public static void clickOnHeaderPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			showAllPos.clickOnHeaderPoNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnHeaderPoNo " + e, e);
		}

	}

	public static void clickOnPoNoRadioBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			showAllPos.clickOnPoNoRadioBtn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPoNoRadioBtn " + e, e);
		}

	}

	public static String fillPonoShowAllpo(WebDriver driver, String testCaseName, String searchpono) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.fillPonoShowAllpo(driver, testCaseName, searchpono);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPonoShowAllpo " + e, e);
		}
		return null;
	}

	public static boolean isPoTypeHeaderPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.isPoTypeHeaderPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPoTypeHeaderPresent " + e, e);
		}
		return false;
	}

	public static boolean isPoTypeLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.isPoTypeLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPoTypeLabelPresent " + e, e);
		}
		return false;
	}

	public static boolean isSupplierTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.isSupplierTextBoxPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierTextBoxPresent " + e, e);
		}
		return false;
	}

	public static boolean isSupplierLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.isSupplierLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierLabelPresent " + e, e);
		}
		return false;
	}

	public static String getFirstPOType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.getFirstPOType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstPOType " + e, e);
		}
		return null;
	}

	public static String getFirstSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.getFirstSupplierName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstSupplierName " + e, e);
		}
		return null;
	}

	public static void clickOnCloseShowAllPOs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			showAllPos.clickOnCloseShowAllPOs(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseShowAllPOs " + e, e);
		}
	}

	public static void clickOnFirstPoNoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			showAllPos.clickOnFirstPoNoRadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstPoNoRadioButton " + e, e);
		}
	}

	/**
	 * @author omkar.jagdale
	 *         method to fill the supplier name
	 */
	public static String fillSupplierNameShowAllpo(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.fillSupplierNameShowAllpo(driver, testCaseName, supplierName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierNameShowAllpo " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 *         method to get the first po no
	 */
	public static String getFirstPONumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalShowAllPos showAllPos = FactoryPage.getInstanceOf(IModalShowAllPosImpl.class);
			return showAllPos.getFirstPONumber(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstPONumber " + e, e);
		}
		return null;
	}

}
