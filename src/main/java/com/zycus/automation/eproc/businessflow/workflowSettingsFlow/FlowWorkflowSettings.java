package com.zycus.automation.eproc.businessflow.workflowSettingsFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.WorkflowSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.workflowsettings.PageWorkflowSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class FlowWorkflowSettings
{
	public static WorkflowSettings changeWorkflowSettings(WebDriver driver, String testCaseName, WorkflowSettings workflowSettings)
		throws ActionBotException, FactoryMethodException
	{
		// to click on customize tab
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);

		// click on workflow link
		PageCustomizeSettings.clickOnWorkflowLink(driver, testCaseName);
		ActionBot.defaultSleep();

		// change auto approve document when routed to workflow admin
		if (workflowSettings.isAutoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin())
		{
			// YES
			PageWorkflowSettings.clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowYES(driver, testCaseName);
		}
		else
		{
			// NO
			PageWorkflowSettings.clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowNO(driver, testCaseName);
		}

		// Replacing approver with non overlapping scope
		if (workflowSettings.getReplacingAprroverWithNonOverlappingScope() != null)
		{
			// DISPLAY WARNING
			if (workflowSettings.getReplacingAprroverWithNonOverlappingScope().equalsIgnoreCase(IConstantsData.DISPLAY_WARNING))
			{
				PageWorkflowSettings.clickOnReplacingAnApproverWithNonOverLappingScopeDISPLAY_WARNING(driver, testCaseName);
			}

			// BLOCK
			if (workflowSettings.getReplacingAprroverWithNonOverlappingScope().equalsIgnoreCase(IConstantsData.BLOCK))
			{
				PageWorkflowSettings.clickOnReplacingAnApproverWithNonOverlappingScopeBLOCK(driver, testCaseName);
			}
		}
		ActionBot.defaultSleep();
		PageWorkflowSettings.clickOnSaveWorkflowSettings(driver, testCaseName);
		return workflowSettings;
	}
}
