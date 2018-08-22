package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class ModalSelectCategory
{

	static Logger logger = Logger.getLogger(ModalSelectCategory.class);

	public static String fillSelectCategory(WebDriver driver, String testcaseName, String selectCategory) throws ActionBotException
	{
		String category = null;
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			category = Category.fillSelectCategory(driver, testcaseName, selectCategory);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSelectCategory " + e, e);
		}

		return category;
	}

	public static void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{

		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.toClickCancelBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCancelBtn " + e, e);
		}

	}

	public static void toClickCrossBtnAtHeader(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.toClickCrossBtnAtHeader(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCrossBtnAtHeader " + e, e);
		}

	}

	public static void toClickSelectThisCategoryLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.toClickSelectThisCategoryLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickSelectThisCategoryLink " + e, e);
		}
	}

	public static void toClickClearSearchResults(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.toClickClearSearchResults(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickClearSearchResults " + e, e);
		}
	}

	public static boolean isCancelButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			return Category.isCancelButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCancelButtonPresent " + e, e);
		}
		return false;
	}

	public static boolean isSelectEformIsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			return Category.isSelectEformIsPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSelectEformIsPresent " + e, e);
		}
		return false;
	}

	public static void clickOnSelectEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.clickOnSelectEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectEform " + e, e);
		}
	}

	/*
	 * method to select category eform
	 */
	public static void selectCategoryEform(WebDriver driver, String testCaseName, String categoryEFormName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.selectCategoryEform(driver, testCaseName, categoryEFormName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCategoryEform " + e, e);
		}
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on see all category eFrom
	 */
	public static void clickOnSeeAlleForms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.clickOnSeeAlleForms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSeeAlleForms " + e, e);
		}
	}

	/**
	 * @author omkar.jagdale
	 *         method to fill search category eForm
	 */
	public static String fillSelectEform(WebDriver driver, String testcaseName, String eFormName) throws ActionBotException
	{
		String eFormName1 = null;
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			eFormName1 = Category.fillSelectEform(driver, testcaseName, eFormName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSelectEform " + e, e);
		}

		return eFormName1;
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on category eForm item
	 */
	public static void clickOnCategoryEformItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.clickOnCategoryEformItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCategoryEformItem " + e, e);
		}
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on category eForm
	 */
	public static void clickOnCategoryEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCategory Category = FactoryModal.getInstanceOfIModalSelectCategory();
			Category.clickOnCategoryEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCategoryEform " + e, e);

		}
	}
}
