/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.requisitionApprovalWorkflow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalRequisitionApprovalWorkflow
{

	public static void clickOnSaveReqApprovalWorkflowButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRequisitionApprovalWorkflow requisitionApprovalWorkflow = FactoryPage.getInstanceOf(IModalRequisitionApprovalWorkflowImpl.class);
		requisitionApprovalWorkflow.clickOnSaveReqApprovalWorkflowButton(driver, testCaseName);
	}

	public static void clickOnCancelReqApprovalWorkflowButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRequisitionApprovalWorkflow requisitionApprovalWorkflow = FactoryPage.getInstanceOf(IModalRequisitionApprovalWorkflowImpl.class);
		requisitionApprovalWorkflow.clickOnCancelReqApprovalWorkflowButton(driver, testCaseName);
	}

	public static String getRequesterNodeDisplayName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRequisitionApprovalWorkflow requisitionApprovalWorkflow = FactoryPage.getInstanceOf(IModalRequisitionApprovalWorkflowImpl.class);
		return requisitionApprovalWorkflow.getRequesterNodeDisplayName(driver, testCaseName);
	}

	public static String getRequesterNodeStatus(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRequisitionApprovalWorkflow requisitionApprovalWorkflow = FactoryPage.getInstanceOf(IModalRequisitionApprovalWorkflowImpl.class);
		return requisitionApprovalWorkflow.getRequesterNodeStatus(driver, testCaseName);
	}

	public static String getBuyerNodeDisplayName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRequisitionApprovalWorkflow requisitionApprovalWorkflow = FactoryPage.getInstanceOf(IModalRequisitionApprovalWorkflowImpl.class);
		return requisitionApprovalWorkflow.getBuyerNodeDisplayName(driver, testCaseName);
	}

	public static boolean isModifyWorkFlowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRequisitionApprovalWorkflow requisitionApprovalWorkflow = FactoryPage.getInstanceOf(IModalRequisitionApprovalWorkflowImpl.class);
		return requisitionApprovalWorkflow.isModifyWorkFlowSettingPresent(driver, testCaseName);
	}

}
