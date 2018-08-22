package com.zycus.automation.eproc.pageobjects.pages.settings.workflowsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageWorkflowSettings
{
	public static void clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowYES(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		iPageWorkflowSettings.clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowYES(driver, testCaseName);
	}

	public static void clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowNO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		iPageWorkflowSettings.clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowNO(driver, testCaseName);
	}

	public static boolean clickOnSaveWorkflowSettings(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnSaveWorkflowSettings(driver, testCaseName);
	}

	public static boolean clickOnReplacingAnApproverWithNonOverlappingScopeBLOCK(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnReplacingAnApproverWithNonOverlappingScopeBLOCK(driver, testCaseName);
	}

	public static boolean clickOnReplacingAnApproverWithNonOverLappingScopeDISPLAY_WARNING(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnReplacingAnApproverWithNonOverLappingScopeDISPLAY_WARNING(driver, testCaseName);
	}

	public static boolean clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_WARNING(WebDriver driver, String testCaseName)
		throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_WARNING(driver, testCaseName);
	}

	public static boolean clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_BLOCK(WebDriver driver, String testCaseName)
		throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_BLOCK(driver, testCaseName);
	}

	public static boolean clickOnReplacingAnApproverWithDifferentDesignation_WARNING(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnReplacingAnApproverWithDifferentDesignation_WARNING(driver, testCaseName);
	}

	public static boolean clickOnReplacingAnApproverWithDifferentDesignation_BLOCK(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnReplacingAnApproverWithDifferentDesignation_BLOCK(driver, testCaseName);
	}

	public static boolean clickOnReplacingAnApproverWithHigherDesignationThanNewApprover_WARNING(WebDriver driver, String testCaseName)
		throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnReplacingAnApproverWithNonOverLappingScopeDISPLAY_WARNING(driver, testCaseName);
	}

	public static boolean clickOnReplacingAnApproverWithHigherDesignationThanNewApprover_BLOCK(WebDriver driver, String testCaseName)
		throws ActionBotException, FactoryMethodException
	{
		IPageWorkflowSettings iPageWorkflowSettings = FactoryPage.getInstanceOf(IPageWorkflowSettingsImpl.class);
		return iPageWorkflowSettings.clickOnReplacingAnApproverWithNonOverLappingScopeDISPLAY_WARNING(driver, testCaseName);
	}
}
