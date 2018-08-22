/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.updatescopeandvalidity;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalUpdateCatalogScopeAndValidity
{
	static Logger logger = Logger.getLogger(ModalUpdateCatalogScopeAndValidity.class);

	public static String selectToValidityDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		try
		{
			IModalUpdateCatalogScopeAndValidity scopeAndValidity = FactoryPage.getInstanceOf(IModalUpdateCatalogScopeAndValidityImpl.class);
			return scopeAndValidity.selectToValidityDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectToValidityDate " + e, e);
		}
		return null;
	}

	public static List<WebElement> getListOfScopes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUpdateCatalogScopeAndValidity scopeAndValidity = FactoryPage.getInstanceOf(IModalUpdateCatalogScopeAndValidityImpl.class);
			return scopeAndValidity.getListOfScopes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfScopes " + e, e);
		}
		return null;
	}

	public static void clickOnScope(WebDriver driver, String testCaseName, String scopeName) throws ActionBotException
	{
		try
		{
			IModalUpdateCatalogScopeAndValidity scopeAndValidity = FactoryPage.getInstanceOf(IModalUpdateCatalogScopeAndValidityImpl.class);
			scopeAndValidity.clickOnScope(driver, testCaseName, scopeName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnScope " + e, e);
		}
	}

	public static void clickOnPublishButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUpdateCatalogScopeAndValidity scopeAndValidity = FactoryPage.getInstanceOf(IModalUpdateCatalogScopeAndValidityImpl.class);
			scopeAndValidity.clickOnPublishButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPublishButton " + e, e);
		}
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUpdateCatalogScopeAndValidity scopeAndValidity = FactoryPage.getInstanceOf(IModalUpdateCatalogScopeAndValidityImpl.class);
			scopeAndValidity.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

	public static String getFromDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalUpdateCatalogScopeAndValidity scopeAndValidity = FactoryPage.getInstanceOf(IModalUpdateCatalogScopeAndValidityImpl.class);
			return scopeAndValidity.getFromDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFromDate " + e, e);
		}
		return null;
	}

}
