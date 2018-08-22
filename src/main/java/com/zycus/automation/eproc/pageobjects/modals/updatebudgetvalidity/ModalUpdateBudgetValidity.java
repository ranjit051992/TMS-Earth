/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.updatebudgetvalidity;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalUpdateBudgetValidity
{
	static Logger logger = Logger.getLogger(ModalUpdateBudgetValidity.class);

	public static String selectEndDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IModalUpdateBudgetValidity updateBudgetValidity = FactoryPage.getInstanceOf(IModalUpdateBudgetValidityImpl.class);
			return updateBudgetValidity.selectEndDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in selectEndDate method");
		}
		return null;
	}

	public static void clickOnUpdateBudgetValidityButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUpdateBudgetValidity updateBudgetValidity = FactoryPage.getInstanceOf(IModalUpdateBudgetValidityImpl.class);
			updateBudgetValidity.clickOnUpdateBudgetValidityButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnUpdateBudgetValidityButton method");
		}
	}

	public static void clickOnCloseUpdateBudgetValidityButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUpdateBudgetValidity updateBudgetValidity = FactoryPage.getInstanceOf(IModalUpdateBudgetValidityImpl.class);
			updateBudgetValidity.clickOnCloseUpdateBudgetValidityButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnCloseUpdateBudgetValidityButton method");
		}
	}

}
