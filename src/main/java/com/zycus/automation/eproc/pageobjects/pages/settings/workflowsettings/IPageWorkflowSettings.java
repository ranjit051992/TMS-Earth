package com.zycus.automation.eproc.pageobjects.pages.settings.workflowsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageWorkflowSettings
{
	final static UI_Elements	AUTO_APPROVE_DOCUMENT_WHEN_APPROVAL_IS_ROUTED_TO_WORKFLOW_ADMIN_YES			= UIFactory
		.getElements("AUTO_APPROVE_DOCUMENT_WHEN_APPROVAL_IS_ROUTED_TO_WORKFLOW_ADMIN_YES");
	final static UI_Elements	AUTO_APPROVE_DOCUMENT_WHEN_APPROVAL_IS_ROUTED_TO_WORKFLOW_ADMIN_NO			= UIFactory
		.getElements("AUTO_APPROVE_DOCUMENT_WHEN_APPROVAL_IS_ROUTED_TO_WORKFLOW_ADMIN_NO");
	final static UI_Elements	WORKFLOW_SETTINGS_SAVE_BUTTON												= UIFactory.getElements("WORKFLOW_SETTINGS_SAVE_BUTTON");
	final static UI_Elements	REPLACING_AN_APPROVER_WITH_NON_OVERLAPPING_SCOPE_BLOCK						= UIFactory
		.getElements("REPLACING_AN_APPROVER_WITH_NON_OVERLAPPING_SCOPE_BLOCK");
	final static UI_Elements	REPLACING_AN_APPROVER_WITH_NON_OVERLAPPING_SCOPE_DISPLAY_WARNING			= UIFactory
		.getElements("REPLACING_AN_APPROVER_WITH_NON_OVERLAPPING_SCOPE_DISPLAY_WARNING");

	final static UI_Elements	REPLACING_AN_APPROVER_WITH_HIGHER_APPROVAL_LIMIT_THAN_NEW_APPROVER_WARNING	= UIFactory
		.getElements("REPLACING_AN_APPROVER_WITH_HIGHER_APPROVAL_LIMIT_THAN_NEW_APPROVER_WARNING");
	final static UI_Elements	REPLACING_AN_APPROVER_WITH_HIGHER_APPROVAL_LIMIT_THAN_NEW_APPROVER_BLOCK	= UIFactory
		.getElements("REPLACING_AN_APPROVER_WITH_HIGHER_APPROVAL_LIMIT_THAN_NEW_APPROVER_BLOCK");

	final static UI_Elements	REPLACING_AN_APPROVER_WITH_DIFFERENT_DESIGNATION_WARNING					= UIFactory
		.getElements("REPLACING_AN_APPROVER_WITH_DIFFERENT_DESIGNATION_WARNING");
	final static UI_Elements	REPLACING_AN_APPROVER_WITH_DIFFERENT_DESIGNATION_BLOCK						= UIFactory
		.getElements("REPLACING_AN_APPROVER_WITH_DIFFERENT_DESIGNATION_BLOCK");

	final static UI_Elements	REPLACING_AN_APPROVER_WITH_HIGHER_DESIGNATION_THAN_NEW_APPROVER_WARNING		= UIFactory
		.getElements("REPLACING_AN_APPROVER_WITH_HIGHER_DESIGNATION_THAN_NEW_APPROVER_WARNING");
	final static UI_Elements	REPLACING_AN_APPROVER_WITH_HIGHER_DESIGNATION_THAN_NEW_APPROVER_BLOCK		= UIFactory
		.getElements("REPLACING_AN_APPROVER_WITH_HIGHER_DESIGNATION_THAN_NEW_APPROVER_BLOCK");

	public void clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowYES(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowNO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnSaveWorkflowSettings(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReplacingAnApproverWithNonOverlappingScopeBLOCK(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReplacingAnApproverWithNonOverLappingScopeDISPLAY_WARNING(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_WARNING(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_BLOCK(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReplacingAnApproverWithDifferentDesignation_WARNING(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReplacingAnApproverWithDifferentDesignation_BLOCK(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReplacingAnApproverWithHigherDesignationThanNewApprover_WARNING(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReplacingAnApproverWithHigherDesignationThanNewApprover_BLOCK(WebDriver driver, String testCaseName) throws ActionBotException;

}
