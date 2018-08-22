/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.porecallapprovalrequest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalPORecallApprovalRequest
{

	static Logger logger = Logger.getLogger(ModalPORecallApprovalRequest.class);

	public static String fillRecallComments(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException
	{
		try
		{
			IModalPORecallApprovalRequest recallApprovalRequest = FactoryPage.getInstanceOf(IModalPORecallApprovalRequestImpl.class);
			return recallApprovalRequest.fillRecallComments(driver, testCaseName, recallComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRecallComments " + e, e);
		}
		return null;
	}

	public static void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPORecallApprovalRequest recallApprovalRequest = FactoryPage.getInstanceOf(IModalPORecallApprovalRequestImpl.class);
			recallApprovalRequest.clickOnRecallButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecallButton " + e, e);
		}
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalPORecallApprovalRequest recallApprovalRequest = FactoryPage.getInstanceOf(IModalPORecallApprovalRequestImpl.class);
			recallApprovalRequest.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

}
