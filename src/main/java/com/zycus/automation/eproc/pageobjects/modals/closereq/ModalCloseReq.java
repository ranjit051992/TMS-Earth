/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closereq;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.closepo.ModalClosePO;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalCloseReq
{

	static Logger logger = Logger.getLogger(ModalClosePO.class);

	public static String fillCloseComment(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException
	{
		try
		{
			IModalCloseReq modalCloseReq = FactoryPage.getInstanceOf(IModalCloseReqImpl.class);
			return modalCloseReq.fillCloseComment(driver, testCaseName, closeComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCloseComment " + e, e);
		}
		return null;
	}

	public static void clickOnCloseReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCloseReq modalCloseReq = FactoryPage.getInstanceOf(IModalCloseReqImpl.class);
			modalCloseReq.clickOnCloseReqButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseReqButton " + e, e);
		}
	}

	public static void clickOnCancelCloseReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalCloseReq modalCloseReq = FactoryPage.getInstanceOf(IModalCloseReqImpl.class);
			modalCloseReq.clickOnCancelCloseReqButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelCloseReqButton " + e, e);
		}
	}

}
