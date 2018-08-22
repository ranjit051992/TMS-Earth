/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.myreqactionsrecallapprovalrequest;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalRecallApprovalRequest
{

	public static String fillRecallComment(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException, FactoryMethodException
	{
		IModalRecallApprovalRequest recallApprovalRequest = FactoryPage.getInstanceOf(IModalRecallApprovalRequestImpl.class);
		return recallApprovalRequest.fillRecallComment(driver, testCaseName, recallComment);

	}

	public static void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRecallApprovalRequest recallApprovalRequest = FactoryPage.getInstanceOf(IModalRecallApprovalRequestImpl.class);
		recallApprovalRequest.clickOnRecallButton(driver, testCaseName);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRecallApprovalRequest recallApprovalRequest = FactoryPage.getInstanceOf(IModalRecallApprovalRequestImpl.class);
		recallApprovalRequest.clickOnCancelButton(driver, testCaseName);

	}

	public static void waitTillSaveCommentProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRecallApprovalRequest recallApprovalRequest = FactoryPage.getInstanceOf(IModalRecallApprovalRequestImpl.class);
		recallApprovalRequest.waitTillSaveCommentProcessingDivPresent(driver, testCaseName);

	}

}
