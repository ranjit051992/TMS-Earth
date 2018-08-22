/**
 * 
 */
package com.zycus.automation.eproc.businessflow.appovalworkflowcustomizesettingflow;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.approvalworkflowcustomizesetting.PageApprovalWorkflowCustomizeSetting;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.reader.PropertyReader;
import com.zycus.automation.eproc.testdata.IEmailTestingConstants;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public class FlowApprovalWorkflowCustomizeSetting
{
	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Get email templates <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws IOException </b> <br>
	 */
	public static void getEmailTemplates(WebDriver driver, String testCaseName) throws ActionBotException, IOException
	{
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		PageCustomizeSettings.clickOnApprovalWorkflowLink(driver, testCaseName);

		// request submitted
		PageApprovalWorkflowCustomizeSetting.clickOnRequestSubmittedLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Request_Submitted,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Request_Submitted, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// awaiting approval
		PageApprovalWorkflowCustomizeSetting.clickOnAwaitingApprovalLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Request_Awaiting_Approval,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Request_Awaiting_Approval,
			PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// request approved
		PageApprovalWorkflowCustomizeSetting.clickOnRequestApprovedLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Request_Approved,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Request_Approved, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// request reject
		PageApprovalWorkflowCustomizeSetting.clickOnRequestRejectedLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Request_Rejected,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Request_Rejected, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// request delegated
		PageApprovalWorkflowCustomizeSetting.clickOnRequestDelegatedLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Request_Delegated,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Request_Delegated, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// request returned
		PageApprovalWorkflowCustomizeSetting.clickOnRequestReturnedLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Request_Returned,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Request_Returned, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// request recalled
		PageApprovalWorkflowCustomizeSetting.clickOnRequestRecalledLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Request_Recalled,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Request_Recalled, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// request cancelled
		PageApprovalWorkflowCustomizeSetting.clickOnRequestCancelledLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Request_Cancelled,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Request_Cancelled, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		/*
		 * //obserer added
		 * PageApprovalWorkflowCustomizeSetting.clickOnObserverAddedLink(driver,
		 * testCaseName);
		 * PropertyReader.addProperty(PropertyReader.emailProperty,
		 * IEmailTestingConstants.Subject_Observer_Added,
		 * PageApprovalWorkflowCustomizeSetting.getSubject(driver,
		 * testCaseName));
		 * 
		 * PropertyReader.addProperty(PropertyReader.emailProperty,
		 * IEmailTestingConstants.Body_Observer_Added,
		 * PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));
		 */

		// approver replaced old
		PageApprovalWorkflowCustomizeSetting.clickOnApproverReplacedOldLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Approver_Replaced_Old,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Approver_Replaced_Old,
			PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// approver replaced new
		PageApprovalWorkflowCustomizeSetting.clickOnApproverReplacedNewLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Approver_Replaced_New,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Approver_Replaced_New,
			PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// approver added
		PageApprovalWorkflowCustomizeSetting.clickOnApproverAddedLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Approver_Added,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Approver_Added, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

		// approver removed
		PageApprovalWorkflowCustomizeSetting.clickOnApproverRemovedLink(driver, testCaseName);
		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Approver_Removed,
			PageApprovalWorkflowCustomizeSetting.getSubject(driver, testCaseName));

		PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Body_Approver_Removed, PageApprovalWorkflowCustomizeSetting.getBody(driver, testCaseName));

	}

}
