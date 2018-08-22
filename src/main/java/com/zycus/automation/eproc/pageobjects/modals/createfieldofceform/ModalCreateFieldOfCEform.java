/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.createfieldofceform;

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
public class ModalCreateFieldOfCEform
{
	static Logger logger = Logger.getLogger(ModalCreateFieldOfCEform.class);

	public static void clickOnAddTextField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddTextField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextField " + e, e);
		}
	}

	public static void clickOnAddTextArea(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddTextArea(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextArea " + e, e);
		}
	}

	public static void clickOnAddCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddCheckBox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddCheckBox " + e, e);
		}
	}

	public static List<String> enterChoicesForCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			return createFieldOfCEform.enterChoicesForCheckBox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterChoicesForCheckBox " + e, e);
		}
		return null;
	}

	public static void clickOnAddDescriptiveField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddDescriptiveField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextField " + e, e);
		}
	}

	public static void clickOnAddNumeric(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddNumeric(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextField " + e, e);
		}
	}

	public static void clickOnAddDateAndTime(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddDateAndTime(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextField " + e, e);
		}
	}

	public static void clickOnAddRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddRadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextField " + e, e);
		}
	}

	/*
	 * to add checkbox
	 */
	public static void clickOnAddCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextField " + e, e);
		}
	}

	public static void clickOnAddDropDown(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddDropDown(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextField " + e, e);
		}
	}

	public static void clickOnAddMultiSelect(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateFieldOfCEform createFieldOfCEform = FactoryPage.getInstanceOf(IModalCreateFieldOfCEformImpl.class);
			createFieldOfCEform.clickOnAddMultiSelect(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddTextField " + e, e);
		}
	}

}
