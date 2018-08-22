/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.previewceform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalPreviewCEform
{
	static Logger logger = Logger.getLogger(ModalPreviewCEform.class);

	public static String getSectionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPreviewCEform modalPreviewCEform = FactoryPage.getInstanceOf(IModalPreviewCEformImpl.class);
			return modalPreviewCEform.getSectionName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in getSectionName method " + e, e);
		}
		return null;
	}

	public static String getFieldName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPreviewCEform modalPreviewCEform = FactoryPage.getInstanceOf(IModalPreviewCEformImpl.class);
			return modalPreviewCEform.getFieldName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in getFieldName method " + e, e);
		}
		return null;
	}

	public static String getTagNameOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPreviewCEform modalPreviewCEform = FactoryPage.getInstanceOf(IModalPreviewCEformImpl.class);
			return modalPreviewCEform.getTagNameOfFieldValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in getTagNameOfFieldValue method " + e, e);
		}
		return null;
	}

	public static void clickOnClosePreviewButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPreviewCEform modalPreviewCEform = FactoryPage.getInstanceOf(IModalPreviewCEformImpl.class);
			modalPreviewCEform.clickOnClosePreviewButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.info("Factory method exception in clickOnClosePreviewButton method " + e, e);
		}
	}

}
