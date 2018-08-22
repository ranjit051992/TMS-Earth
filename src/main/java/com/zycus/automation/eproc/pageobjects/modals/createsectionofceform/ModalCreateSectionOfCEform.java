/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.createsectionofceform;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalCreateSectionOfCEform
{
	static Logger logger = Logger.getLogger(ModalCreateSectionOfCEform.class);

	public static String fillSectionName(WebDriver driver, String testCaseName, String sectionName) throws ActionBotException
	{
		try
		{
			IModalCreateSectionOfCEform createSectionOfCEform = FactoryPage.getInstanceOf(IModalCreateSectionOfCEformImpl.class);
			return createSectionOfCEform.fillSectionName(driver, testCaseName, sectionName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSectionName " + e, e);
		}
		return null;
	}

	public static void clickOnSaveSectionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateSectionOfCEform createSectionOfCEform = FactoryPage.getInstanceOf(IModalCreateSectionOfCEformImpl.class);
			createSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveSectionButton " + e, e);
		}
	}

	public static void clickOnCancelSectionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCreateSectionOfCEform createSectionOfCEform = FactoryPage.getInstanceOf(IModalCreateSectionOfCEformImpl.class);
			createSectionOfCEform.clickOnCancelSectionButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelSectionButton " + e, e);
		}
	}

}
