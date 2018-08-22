/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.approvaldocumentviewmode;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class PageApprovalDocumentViewMode
{
	static Logger logger = Logger.getLogger(PageApprovalDocumentViewMode.class);

	public static String fillApprovalComment(WebDriver driver, String testCaseName, String approvalComment) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			return approvalDocumentViewMode.fillApprovalComment(driver, testCaseName, approvalComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApproveRequestOnToolTip " + e, e);
		}
		return null;
	}

	public static void clickOnApproveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			approvalDocumentViewMode.clickOnApproveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApproveButton " + e, e);
		}
	}

	public static void clickOnRejectButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			approvalDocumentViewMode.clickOnRejectButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRejectButton " + e, e);
		}
	}

	public static void clickOnDelegateButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			approvalDocumentViewMode.clickOnDelegateButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDelegateButton " + e, e);
		}
	}

	public static boolean isMandatoryCommentsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			return approvalDocumentViewMode.isMandatoryCommentsErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMandatoryCommentsErrorPresent " + e, e);
		}
		return false;
	}

	public static void clickOnAddApproverButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			approvalDocumentViewMode.clickOnAddApproverButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddApproverButton " + e, e);
		}

	}

	public static String getWorkflowActorName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			return approvalDocumentViewMode.getWorkflowActorName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getWorkflowActorName " + e, e);
		}
		return null;
	}

	public static void clickOnViewItemSummaryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.waitForElementToBeDisplayed(driver, IPageApprovalDocumentViewMode.MY_APPROVAL_VIEW_ITEM_COMMENTS, 6);
		ActionBot.click(driver, IPageApprovalDocumentViewMode.MY_APPROVAL_VIEW_ITEM_COMMENTS);

	}

	/**
	 * @author omkar.jagdale
	 *         method to check approver is added or not to work flow by name
	 */
	public static boolean checkAddedApproverByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			return approvalDocumentViewMode.checkAddedApproverByName(driver, testCaseName, approverName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkAddedApproverByName " + e, e);
		}
		return false;
	}

	/**
	 * @author omkar.jagdale
	 *         method to fill delegate to name
	 */
	public static String fillDelegateToName(WebDriver driver, String testCaseName, String delegateTo) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			return approvalDocumentViewMode.fillDelegateToName(driver, testCaseName, delegateTo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDelegateToName " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on delegate button
	 */
	public static void clickDelegateButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			approvalDocumentViewMode.clickDelegateButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDelegateButton " + e, e);
		}
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on change approver link
	 */
	public static void clickOnChangeApproverLinkByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			approvalDocumentViewMode.clickOnChangeApproverLinkByName(driver, testCaseName, approverName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnChangeApproverLinkByName " + e, e);
		}
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on remove approver link
	 */
	public static void clickOnRemoveApproverLinkByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException
	{
		try
		{
			IPageApprovalDocumentViewMode approvalDocumentViewMode = FactoryPage.getInstanceOf(IPageApprovalDocumentViewModeImpl.class);
			approvalDocumentViewMode.clickOnRemoveApproverLinkByName(driver, testCaseName, approverName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemoveApproverLinkByName " + e, e);
		}
	}

}
