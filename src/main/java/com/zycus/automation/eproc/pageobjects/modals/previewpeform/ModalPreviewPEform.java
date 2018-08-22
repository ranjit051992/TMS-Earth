/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.previewpeform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalPreviewPEform
{
	static Logger logger = Logger.getLogger(ModalPreviewPEform.class);

	public static String getLabelValueOfSection(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPreviewPEform modalPreviewPEform = FactoryPage.getInstanceOf(IModalPreviewPEformImpl.class);
			return modalPreviewPEform.getLabelValueOfSection(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getLabelValueOfSection method " + e, e);
		}
		return null;
	}

	public static String getLabelValueOfField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPreviewPEform modalPreviewPEform = FactoryPage.getInstanceOf(IModalPreviewPEformImpl.class);
			return modalPreviewPEform.getLabelValueOfField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getLabelValueOfField method " + e, e);
		}
		return null;
	}

	public static String getTagOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPreviewPEform modalPreviewPEform = FactoryPage.getInstanceOf(IModalPreviewPEformImpl.class);
			return modalPreviewPEform.getTagOfFieldValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getTagOfFieldValue method " + e, e);
		}
		return null;
	}

	public static void clickOnClosePreviewButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPreviewPEform modalPreviewPEform = FactoryPage.getInstanceOf(IModalPreviewPEformImpl.class);
			modalPreviewPEform.clickOnClosePreviewButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnClosePreviewButton method " + e, e);
		}
	}

}
