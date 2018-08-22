/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.fieldpropertiesofceform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalFieldPropertiesOfCEform
{
	static Logger logger = Logger.getLogger(ModalFieldPropertiesOfCEform.class);

	public static String fillFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillFieldName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillNumericFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillNumericName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillDescriptiveFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillDescriptiveName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillRadioButtonFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillRadioButtonName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillRadioButtonFieldChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillRadioButtonChoice(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillDropdownFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillDropdownName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillDropdownFieldChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillDropdownChoice(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillDateAndTimeFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillDateAndTimeName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillCheckboxFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillCheckboxName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillCheckboxFieldChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillCheckboxChoice(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillMultiselectFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillMultiselectName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillMultiselectFieldChoice(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillMultiselectChoice(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillAreaName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillTextAreaName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static void clickOnSaveFieldButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			fieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveFieldButton " + e, e);
		}
	}

	public static void clickOnCancelFieldButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			fieldPropertiesOfCEform.clickOnCancelFieldButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelFieldButton " + e, e);
		}
	}

	public static String fillFieldDefaultValue(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillFieldDefaultValue(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

	public static String fillFieldToolTip(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IModalFieldPropertiesOfCEform fieldPropertiesOfCEform = FactoryPage.getInstanceOf(IModalFieldPropertiesOfCEformImpl.class);
			return fieldPropertiesOfCEform.fillFieldToolTip(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}
		return null;
	}

}
