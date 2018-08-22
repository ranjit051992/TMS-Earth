/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcategoryofceform;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalSelectCategoryOfCEform
{
	static Logger logger = Logger.getLogger(ModalSelectCategoryOfCEform.class);

	public static void clickOnSelectAllCategories(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategoryOfCEform selectCategoryOfCEform = FactoryPage.getInstanceOf(IModalSelectCategoryOfCEformImpl.class);
			selectCategoryOfCEform.clickOnSelectAllCategories(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllOU " + e, e);
		}
	}

	public static List<WebElement> getAllCategories(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategoryOfCEform selectCategoryOfCEform = FactoryPage.getInstanceOf(IModalSelectCategoryOfCEformImpl.class);
			return selectCategoryOfCEform.getAllCategories(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllCategories " + e, e);
		}
		return null;
	}

	public static void clickOnSaveCEfromCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategoryOfCEform selectCategoryOfCEform = FactoryPage.getInstanceOf(IModalSelectCategoryOfCEformImpl.class);
			selectCategoryOfCEform.clickOnSaveCEfromCategoryButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveCEfromCategoryButton " + e, e);
		}
	}

	public static void clickOnCancelCEfromCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategoryOfCEform selectCategoryOfCEform = FactoryPage.getInstanceOf(IModalSelectCategoryOfCEformImpl.class);
			selectCategoryOfCEform.clickOnCancelCEfromCategoryButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelCEfromCategoryButton " + e, e);
		}
	}

	public static String fillSearchCategory(WebDriver driver, String testCaseName, String categoryToBeSearched) throws ActionBotException
	{
		try
		{
			IModalSelectCategoryOfCEform selectCategoryOfCEform = FactoryPage.getInstanceOf(IModalSelectCategoryOfCEformImpl.class);
			return selectCategoryOfCEform.fillSearchCategory(driver, testCaseName, categoryToBeSearched);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSearchCategory " + e, e);
		}
		return null;
	}

	public static void clickOnGoSearchCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategoryOfCEform selectCategoryOfCEform = FactoryPage.getInstanceOf(IModalSelectCategoryOfCEformImpl.class);
			selectCategoryOfCEform.clickOnGoSearchCategoryButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGoSearchCategoryButton " + e, e);
		}
	}

	public static String clickOnCategoryCheckbox(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{
		try
		{
			IModalSelectCategoryOfCEform selectCategoryOfCEform = FactoryPage.getInstanceOf(IModalSelectCategoryOfCEformImpl.class);
			return selectCategoryOfCEform.clickOnCategoryCheckbox(driver, testCaseName, category);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCategoryCheckbox " + e, e);
		}
		return null;
	}

	public static boolean isCategoryPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategoryOfCEform selectCategoryOfCEform = FactoryPage.getInstanceOf(IModalSelectCategoryOfCEformImpl.class);
			return selectCategoryOfCEform.isCategoryPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCategoryPresent " + e, e);
		}
		return false;
	}

}
