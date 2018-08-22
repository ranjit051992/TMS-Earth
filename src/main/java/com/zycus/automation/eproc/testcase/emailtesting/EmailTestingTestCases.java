/**
 * 
 */
package com.zycus.automation.eproc.testcase.emailtesting;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.ApprovalAllRequestsStatusFilter;
import com.zycus.automation.bo.AttachmentsAndCommentsItemSummary;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.DocumentInformation;
import com.zycus.automation.bo.DocumentInformationSetting;
import com.zycus.automation.bo.EmailDetails;
import com.zycus.automation.bo.EmailResult;
import com.zycus.automation.bo.FileAttachment;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MySettings;
import com.zycus.automation.bo.OtherNotificationSetting;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.PurchaseOrderSettings;
import com.zycus.automation.bo.Receipt;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.UserUtil;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.appovalworkflowcustomizesettingflow.FlowApprovalWorkflowCustomizeSetting;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.documentInfoSettingFlow.FlowDocumentInformationSetting;
import com.zycus.automation.eproc.businessflow.emailTesting.FlowEmailTesting;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.IFlowMyRequisitionUtil;
import com.zycus.automation.eproc.businessflow.mysettingsflow.FlowMySettings;
import com.zycus.automation.eproc.businessflow.othernotificationsettingflow.FlowOtherNotificationSetting;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.purchaseordersetting.FlowPurchaseOrderSetting;
import com.zycus.automation.eproc.businessflow.receiptflow.FlowReceipt;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.businessflow.viewpoflow.FlowViewPO;
import com.zycus.automation.eproc.pageobjects.modals.emailpo.ModalEmailPODocument;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions.ModalMyRequisitionActions;
import com.zycus.automation.eproc.pageobjects.modals.viewpoactions.ModalViewPOActions;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders.PageAmmendedPO;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.reader.PropertyReader;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.testdata.IEmailTestingConstants;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.framework.framework_version_2_4.listener.CustomRetryListener;
import com.zycus.framework.framework_version_2_4.startup.Startup;

/**
 * @author ankita.sawant
 *
 */
public class EmailTestingTestCases extends TestDataProvider
{
	static Logger logger = Logger.getLogger(EmailTestingTestCases.class);

	@BeforeClass
	public void getEmailTemplates() throws Exception
	{
		WebDriver driver = null;
		TestCase testCase = new TestCase();
		User user = null;
		String testCaseName = null;
		try
		{
			testCase.setTestMethodName("getEmailTemplates");
			testCase.setDescription("getEmailTemplates");
			testCase.setModuleName("Email Testing");
			testCase.setBrowser(Startup.browserEnvironments.get(0).getBrowser());
			testCase.setVersion(Startup.browserEnvironments.get(0).getVersion());
			driver = DriverSelector.getDriver(testCase);
			testCaseName = testCase.getTestMethodName();

			CommonServices.startTestCase(driver, testCase);
			// login
			user = LoginLogoutServices.login(driver, testCase);
			// get email templates
			FlowApprovalWorkflowCustomizeSetting.getEmailTemplates(driver, testCaseName);

			DocumentInformationSetting documentInformationSetting = new DocumentInformationSetting();
			OtherNotificationSetting otherNotificationSetting = new OtherNotificationSetting();
			documentInformationSetting.setRequisitionInfo(true);
			documentInformationSetting.setPoInfo(true);
			otherNotificationSetting.setOnBuyersDesk(true);
			otherNotificationSetting.setOnPOReleased(true);

			// to get email configuration settings
			documentInformationSetting = FlowDocumentInformationSetting.getDocumentInformationSetting(driver, testCaseName, documentInformationSetting);
			otherNotificationSetting = FlowOtherNotificationSetting.getOtherNotificationSetting(driver, testCaseName, otherNotificationSetting);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Req_Doc_Details_Template, documentInformationSetting.getReqDetailsTemplate());
			PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.PO_Doc_Details_Template, documentInformationSetting.getPoDetailsTemplate());
			PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Req_Item_Row_Template, documentInformationSetting.getReqItemRowTemplate());
			PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.PO_Item_Row_Template, documentInformationSetting.getPoItemRowTemplate());
			PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Buyers_Desk_Details_Template, otherNotificationSetting.getBuyersDeskBody());
			PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_Buyers_Desk_Template, otherNotificationSetting.getBuyersDeskSubject());
			PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.PO_Released_Details_Template, otherNotificationSetting.getPoReleasedBody());
			PropertyReader.addProperty(PropertyReader.emailProperty, IEmailTestingConstants.Subject_PO_Released_Template, otherNotificationSetting.getPoReleasedSubject());

			/*
			 * if (FlowEmailTesting.Email_Body_For_BuyersDesk.contains(
			 * IEmailTestingConstants.DOC_DETAILS)) {
			 * FlowEmailTesting.Email_Body_For_BuyersDesk =
			 * FlowEmailTesting.Email_Body_For_BuyersDesk.replace(
			 * IEmailTestingConstants.DOC_DETAILS,
			 * FlowEmailTesting.Email_Body_For_Requisition); }
			 */

			CommonServices.successfulExecution(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionOccurred(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionOccurred(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, user);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check email send for receipt created
	 * from PO which is generated from requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void emailTesting_forReqToReceiptFlow(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new LinkedHashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		DocumentInformation documentInformation = new DocumentInformation();
		List<EmailResult> emailResults = new ArrayList<>();
		List<EmailResult> emailResultsForEmailBody = new ArrayList<>();
		LinkedList<EmailDetails> emailResultDetails = new LinkedList<>();
		String status = null, log = "";
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// to get Item object
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			// to get requisition object
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ);
			requisition.setAssignedBuyer(UserUtil.getAvailableUser().get(0).getDisplayName());

			logger.info("==================== Create Requisition ====================");
			// to create req
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			logger.info("==================== Recall Requisition ====================");
			// recall req
			FlowMyRequisitions.recallApprovalRequest(driver, testCaseName, requisition);

			// check req is recalled or not
			assertTrue("Recalled requisition not in drafts status", IFlowMyRequisitionUtil.checkIfRequisitionRecalled(driver, testCaseName, requisition));

			logger.info("==================== View Requisition ====================");
			// view req
			FlowMyRequisitions.viewRequisition(driver, testCaseName);

			logger.info("==================== Submit Requisition ====================");
			// submit req
			FlowRequisition.submitReq(driver, testCaseName, false);

			logger.info("==================== Search Requisition ====================");
			// search req
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition", requisition.isResult());

			documentInformation = ObjectCreation.getObjectOfDocumentInformation(DocumentInformation.docType_Requisition, requisition, null, null, null);
			documentInformation.setUser(user);

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			logger.info("==================== Approve Requisition ====================");
			// approve req
			approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			assertTrue("Error while approving requisition", approvalAllRequests.isResult());
			documentInformation.setCommentForActionPerformed(IConstantsData.APPROVE_COMMENT);

			ActionBot.defaultHighSleep();
			ActionBot.defaultHighSleep();

			logger.info("============================= Email testing =============================");

			// req submitted
			EmailDetails emailDetails_documentSubmitted = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Submitted, documentInformation);

			EmailDetails emailDetails1 = FlowEmailTesting.readEmail(emailDetails_documentSubmitted);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails1, emailDetails_documentSubmitted, "Subject of Email after requisition submitted",
				IEmailTestingConstants.EventType_Document_Submitted));

			logger.info("============================= Email Body Testing =============================");
			emailDetails1 = FlowEmailTesting.readContentsOfMail(emailDetails1);
			logger.info("Email body : " + emailDetails1.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_Requisition);

			String emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_Requisition, documentInformation);

			emailDetails1.setEventType(IEmailTestingConstants.EventType_Document_Submitted);

			emailDetails1.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails1.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Submitted));

			emailResultsForEmailBody.add(emailDetails1.getEmailResultForBody());
			emailResultDetails.add(emailDetails1);

			// req pending for approval
			EmailDetails emailDetails_reqApprovalPending = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approval_Pending, documentInformation);

			EmailDetails emailDetails2 = FlowEmailTesting.readEmail(emailDetails_reqApprovalPending);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails2, emailDetails_reqApprovalPending, "Subject of Email for requisition approval pending",
				IEmailTestingConstants.EventType_Document_Approval_Pending));
			emailResultDetails.add(emailDetails2);

			// req recalled
			EmailDetails emailDetails_reqRecalled = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Recalled, documentInformation);

			EmailDetails emailDetails3 = FlowEmailTesting.readEmail(emailDetails_reqRecalled);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails3, emailDetails_reqRecalled, "Subject of Email after requisition recalled",
				IEmailTestingConstants.EventType_Document_Recalled));

			logger.info("============================= Email Body Testing =============================");
			emailDetails3 = FlowEmailTesting.readContentsOfMail(emailDetails3);
			logger.info("Email body : " + emailDetails3.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Document_Recalled);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Document_Recalled, documentInformation);

			emailDetails3.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails3.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Recalled));

			emailResultsForEmailBody.add(emailDetails3.getEmailResultForBody());
			emailResultDetails.add(emailDetails3);

			logger.info("==================== Search Requisition ====================");
			// search req
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition", requisition.isResult());
			flag = IConstantsData.WITH_BUYER_FILTER_LABEL.equalsIgnoreCase(PageMyRequisition.getStatusOfFirstReq(driver, testCaseName));
			assertTrue("Requisition status was not With Buyer", flag);

			logger.info("==================== Search Requisition at buyers desk ====================");
			// search at buyers desk
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition at buyers desk", requisition.isResult());

			logger.info("============================= Email testing =============================");
			// req submitted
			emailDetails_documentSubmitted = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Submitted, documentInformation);

			EmailDetails emailDetails4 = FlowEmailTesting.readEmail(emailDetails_documentSubmitted);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails4, emailDetails_documentSubmitted, "Subject of Email after requisition submitted",
				IEmailTestingConstants.EventType_Document_Submitted));

			// email body testing
			logger.info("============================= Email Body Testing =============================");
			emailDetails4 = FlowEmailTesting.readContentsOfMail(emailDetails4);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_Requisition);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_Requisition, documentInformation);

			emailDetails4.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails4.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Submitted));
			emailResultsForEmailBody.add(emailDetails4.getEmailResultForBody());
			emailResultDetails.add(emailDetails4);

			// req pending for approval
			emailDetails_reqApprovalPending = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approval_Pending, documentInformation);

			EmailDetails emailDetails5 = FlowEmailTesting.readEmail(emailDetails_reqApprovalPending);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails5, emailDetails_reqApprovalPending, "Subject of Email for requisition approval pending",
				IEmailTestingConstants.EventType_Document_Approval_Pending));

			// email body testing
			logger.info("============================= Email Body Testing =============================");
			emailDetails5 = FlowEmailTesting.readContentsOfMail(emailDetails5);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_Requisition);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_Requisition, documentInformation);

			emailDetails5.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails5.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approval_Pending));

			emailResultsForEmailBody.add(emailDetails5.getEmailResultForBody());
			emailResultDetails.add(emailDetails5);

			// req approved
			EmailDetails emailDetails_reqApproved = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approved, documentInformation);

			EmailDetails emailDetails6 = FlowEmailTesting.readEmail(emailDetails_reqApproved);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails6, emailDetails_reqApproved, "Subject of Email for requisition approved",
				IEmailTestingConstants.EventType_Document_Approved));

			// email body testing
			logger.info("============================= Email Body Testing =============================");
			emailDetails6 = FlowEmailTesting.readContentsOfMail(emailDetails6);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Document_Approved);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Document_Approved, documentInformation);

			emailDetails6.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails6.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approved));
			emailResultsForEmailBody.add(emailDetails6.getEmailResultForBody());
			emailResultDetails.add(emailDetails6);

			Requisition editReqAtBuyersDesk = new Requisition();

			editReqAtBuyersDesk.setItems(requisition.getItems());
			editReqAtBuyersDesk.setCommentForSupplier(IConstantsData.COMMENT_FOR_SUPPLIER);
			String newAssignBuyer = CommonServices.getTestData(IConstantsData.BUYER_NAME);

			// cost booking object
			CostBookingItemSummary costBookingItemSummary = ObjectCreation.getDefaultObjectOfCostBookingItemSummary();
			editReqAtBuyersDesk.setCostBookingItemSummary(costBookingItemSummary);

			logger.info("==================== View Requisition at Buyers Desk ====================");
			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			logger.info("==================== Remove and change assigned buyer ====================");
			// to remove and change assign buyer
			flag = FlowBuyersDesk.removeAndChangeAssignedBuyer(driver, testCaseName, requisition.getAssignedBuyer(), newAssignBuyer);
			// assertTrue("New buyer was not assigned", flag);

			logger.info("==================== Edit Requisition at Buyers Desk ====================");
			// edit req
			editReqAtBuyersDesk = FlowBuyersDesk.editRequisitionAtBuyersDesk(driver, testCaseName, editReqAtBuyersDesk);

			logger.info("==================== Save Requisition from Buyers Desk ====================");
			// save the req
			FlowBuyersDesk.saveRequisitionFromBuyersDesk(driver, testCaseName);

			logger.info("==================== Search at Buyers Desk ====================");
			// search at buyers desk
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);

			logger.info("==================== View Requisition at Buyers Desk ====================");
			// to view the req
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

			ActionBot.defaultHighSleep();
			ActionBot.defaultHighSleep();
			ActionBot.defaultHighSleep();
			ActionBot.defaultHighSleep();

			logger.info("============================= Email testing =============================");
			// remind buyer
			EmailDetails emailDetails_remindBuyer = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Remind_Buyer, documentInformation);

			EmailDetails emailDetails7 = FlowEmailTesting.readEmail(emailDetails_remindBuyer);
			emailResults.add(
				FlowEmailTesting.checkIfEmailSent(emailDetails7, emailDetails_remindBuyer, "Subject of Email for remind buyer", IEmailTestingConstants.EventType_Remind_Buyer));

			// email body testing
			logger.info("============================= Email Body Testing =============================");
			emailDetails7 = FlowEmailTesting.readContentsOfMail(emailDetails7);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_On_Buyers_Desk);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_On_Buyers_Desk, documentInformation);

			emailDetails7
				.setEmailResultForBody(FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails7.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Remind_Buyer));
			emailResultsForEmailBody.add(emailDetails7.getEmailResultForBody());
			emailResultDetails.add(emailDetails7);

			/*
			 * //removed assigned buyer EmailDetails emailDetails_removeBuyer =
			 * ObjectCreation.getEmailDetailsObject(
			 * IConstantsData.Email_Testing_Username,
			 * IConstantsData.Email_Testing_Password,
			 * IConstantsData.Email_Testing_Default_Folder_Of_Emails,
			 * IEmailTestingConstants.EventType_Assigned_Buyer_Removed,
			 * documentInformation);
			 * 
			 * emailDetails =
			 * FlowEmailTesting.readEmail(emailDetails_removeBuyer); map =
			 * FlowEmailTesting.checkIfEmailSend(emailDetails,
			 * emailDetails_removeBuyer,
			 * "Subject of email for assigned buyer removed was wrong",
			 * "Subject of Email for assigned buyer removed", map);
			 */

			/*
			 * //changed assigned buyer
			 * documentInformation.getRequisition().setAssignedBuyer(
			 * newAssignBuyer); EmailDetails emailDetails_changeAssignBuyer =
			 * ObjectCreation.getEmailDetailsObject(
			 * IConstantsData.Email_Testing_Username,
			 * IConstantsData.Email_Testing_Password,
			 * IConstantsData.Email_Testing_Default_Folder_Of_Emails,
			 * IEmailTestingConstants.EventType_Assigned_Buyer_Changed,
			 * documentInformation);
			 * 
			 * emailDetails =
			 * FlowEmailTesting.readEmail(emailDetails_changeAssignBuyer); map =
			 * FlowEmailTesting.checkIfEmailSend(emailDetails,
			 * emailDetails_changeAssignBuyer,
			 * "Subject of email for assigned buyer changed was wrong",
			 * "Subject of Email for assigned buyer changed", map);
			 * 
			 */

			/*
			 * //modified req by buyer EmailDetails
			 * emailDetails_modifiedReqByBuyer =
			 * ObjectCreation.getEmailDetailsObject(
			 * IConstantsData.Email_Testing_Username,
			 * IConstantsData.Email_Testing_Password,
			 * IConstantsData.Email_Testing_Default_Folder_Of_Emails,
			 * IEmailTestingConstants.EventType_Requisition_Modified_By_Buyer,
			 * documentInformation);
			 * 
			 * EmailDetails emailDetails8 =
			 * FlowEmailTesting.readEmail(emailDetails_modifiedReqByBuyer);
			 * emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails8,
			 * emailDetails_modifiedReqByBuyer,
			 * "Subject of Email for requisition modified by buyer",
			 * IEmailTestingConstants.EventType_Requisition_Modified_By_Buyer));
			 * 
			 * //email body testing logger.info(
			 * "============================= Email Body Testing ============================="
			 * ); emailDetails8 =
			 * FlowEmailTesting.readContentsOfMail(emailDetails8); logger.info(
			 * "Email body created from file : " +
			 * IEmailTestingConstants.Body_Document_Modified_By_Buyer + " \n " +
			 * FlowEmailTesting.Email_Body_For_Requisition);
			 * 
			 * emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(
			 * IEmailTestingConstants.Body_Document_Modified_By_Buyer + " \n " +
			 * FlowEmailTesting.Email_Body_For_Requisition,
			 * documentInformation);
			 * 
			 * emailDetails8.setEmailResultForBody(FlowEmailTesting.
			 * checkIfBodyOfEmailIsRight( emailDetails8.getEmailBody(),
			 * emailBody, "\n",
			 * IEmailTestingConstants.EventType_Requisition_Modified_By_Buyer));
			 * emailResultsForEmailBody.add(emailDetails8.getEmailResultForBody(
			 * )); emailResultDetails.add(emailDetails8);
			 */

			logger.info("==================== Convert To PO ====================");
			// convert To Po
			FlowBuyersDesk.convertToPo(driver, testCaseName);

			// submit all POs
			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);

			// to search po
			for (PurchaseOrder purchaseOrder : purchaseOrders)
			{
				flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Purchase order was not created", flag);
				status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
				if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
				{
					// to approve po
					approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
					approvalAllRequests.setDocumentNo(purchaseOrder.getPoNo());
					FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
				}

				ActionBot.defaultHighSleep();
				ActionBot.defaultMediumSleep();
				flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Purchase order was not searched", flag);
				status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
				flag = status.equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				assertTrue("Status of PO was not Released after approving it", flag);
				purchaseOrder.setStatus(status);
				purchaseOrder.setRequisition(requisition);
			}

			Item item2 = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);

			logger.info("==================== Search PO ====================");
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Purchase order was not searched", flag);

			logger.info("==================== View PO ====================");
			// view po
			FlowPoListing.viewPO(driver, testCaseName);
			purchaseOrders.get(0).setPoName(PageViewPurchaseOrder.getPOName(driver, testCaseName));
			purchaseOrders.get(0).setRequisition(requisition);
			String comment = PageViewPurchaseOrder.getPOComment(driver, testCaseName);
			purchaseOrders.get(0).setApprover(PageViewPurchaseOrder.getFirstApproverNameOnWorkflow(driver, testCaseName));
			purchaseOrders.get(0).setCreatedOn(requisition.getCustomDate());

			logger.info("==================== Amend PO ====================");
			// to amend the PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnAmendPoLink(driver, testCaseName);

			logger.info("============= Amending PO by adding new Guided Item ===============");
			ActionBot.scroll(driver, "350");

			// to Amend PO
			item = FlowStandardPo.addItemToReqToPO(driver, testCaseName, item2);

			logger.info("==================== Submit PO ====================");
			// submit po
			String poTotal_AfterAmendment = PageStandardPO.getPOTotalPrice(driver, testCaseName);
			FlowStandardPo.submitPoForProcessing(driver, testCaseName);

			DocumentInformation documentInformation_forPO = ObjectCreation.getObjectOfDocumentInformation(DocumentInformation.docType_PO, null, null, null, purchaseOrders.get(0));
			documentInformation_forPO.getPurchaseOrder().setPoName(purchaseOrders.get(0).getPoName());
			documentInformation_forPO.setDocName(purchaseOrders.get(0).getPoName());
			documentInformation_forPO.getPurchaseOrder().setComment(comment);
			documentInformation_forPO.setUser(user);
			documentInformation_forPO.setCreatedOn(requisition.getCustomDate().getDate());
			documentInformation_forPO.setCommentForActionPerformed(IConstantsData.APPROVE_COMMENT);

			PageAmmendedPO.getFirstAmendedPONo(driver, testCaseName);

			// to check status of amended po
			status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, purchaseOrders.get(0).getPoNo());
			flag = status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL);

			// to approve po
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
				approvalAllRequests.setDocumentNo(purchaseOrders.get(0).getPoNo());
				logger.info("==================== Approve PO ====================");
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			}

			logger.info("============================= Email testing =============================");
			// po submitted
			emailDetails_documentSubmitted = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Submitted, documentInformation_forPO);

			EmailDetails emailDetails9 = FlowEmailTesting.readEmail(emailDetails_documentSubmitted);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails9, emailDetails_documentSubmitted, "Subject of Email after Purchase Order submitted",
				IEmailTestingConstants.EventType_Document_Submitted));
			driver.navigate().refresh();
			if (ActionBot.isAlertPresent(driver, testCaseName))
			{
				ActionBot.acceptAlert(driver, testCaseName);
			}
			logger.info("============================= Email Body Testing =============================");
			emailDetails9 = FlowEmailTesting.readContentsOfMail(emailDetails9);
			logger.info("Email body : " + emailDetails9.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_PO);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_PO, documentInformation_forPO);

			emailDetails9.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails9.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Submitted));
			emailResultsForEmailBody.add(emailDetails9.getEmailResultForBody());
			emailResultDetails.add(emailDetails9);

			// po pending for approval
			emailDetails_reqApprovalPending = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approval_Pending, documentInformation_forPO);

			EmailDetails emailDetails10 = FlowEmailTesting.readEmail(emailDetails_reqApprovalPending);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails10, emailDetails_reqApprovalPending, "Subject of Email for Purchase Order approval pending",
				IEmailTestingConstants.EventType_Document_Approval_Pending));

			logger.info("============================= Email Body Testing =============================");
			// email body testing
			emailDetails10 = FlowEmailTesting.readContentsOfMail(emailDetails10);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_PO);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_PO, documentInformation_forPO);

			emailDetails10.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails10.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approval_Pending));
			emailResultsForEmailBody.add(emailDetails10.getEmailResultForBody());
			emailResultDetails.add(emailDetails10);

			// po approved
			EmailDetails emailDetails_poApproved = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approved, documentInformation_forPO);

			EmailDetails emailDetails11 = FlowEmailTesting.readEmail(emailDetails_poApproved);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails11, emailDetails_poApproved, "Subject of Email for Purchase Order approved",
				IEmailTestingConstants.EventType_Document_Approved));
			driver.navigate().refresh();
			if (ActionBot.isAlertPresent(driver, testCaseName))
			{
				ActionBot.acceptAlert(driver, testCaseName);
			}

			logger.info("============================= Email Body Testing =============================");
			// email body testing
			emailDetails11 = FlowEmailTesting.readContentsOfMail(emailDetails11);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Document_Approved);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Document_Approved, documentInformation_forPO);

			emailDetails11.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails11.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approved));
			emailResultsForEmailBody.add(emailDetails11.getEmailResultForBody());
			emailResultDetails.add(emailDetails11);

			logger.info("==================== Search PO ====================");
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrders.get(0).getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Purchase order was not searched", flag);

			logger.info("==================== View PO ====================");
			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			logger.info("==================== Create Receipt ====================");
			// to create receipt
			Receipt receipt = ObjectCreation.getDefaultReceiptObject();
			ActionBot.defaultSleep();
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnCreateReceiptPoLink(driver, testCaseName);
			// ModalPOListingActions.clickOnCreateReceiptLink(driver,
			// testCaseName);

			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);
			receipt.setPurchaseOrder(purchaseOrders.get(0));

			ActionBot.defaultHighSleep();
			ActionBot.defaultHighSleep();
			ActionBot.defaultHighSleep();
			driver.navigate().refresh();
			if (ActionBot.isAlertPresent(driver, testCaseName))
			{
				ActionBot.acceptAlert(driver, testCaseName);
			}
			ActionBot.defaultHighSleep();
			ActionBot.defaultHighSleep();
			logger.info("============================= Email testing =============================");

			/*
			 * //req released
			 * documentInformation.setDocNo(requisition.getReqNo());
			 * EmailDetails emailDetails_reqReleased =
			 * ObjectCreation.getEmailDetailsObject(
			 * IConstantsData.Email_Testing_Username,
			 * IConstantsData.Email_Testing_Password,
			 * IConstantsData.Email_Testing_Default_Folder_Of_Emails,
			 * IEmailTestingConstants.EventType_Released_Requisition,
			 * documentInformation);
			 * 
			 * EmailDetails emailDetails13 =
			 * FlowEmailTesting.readEmail(emailDetails_reqReleased);
			 * emailResults.add(FlowEmailTesting.checkIfEmailSent(
			 * emailDetails13, emailDetails_reqReleased,
			 * "Subject of Email after Requisition Released",
			 * IEmailTestingConstants.EventType_Released_Requisition));
			 * 
			 * logger.info(
			 * "============================= Email Body Testing ============================="
			 * ); emailDetails13 =
			 * FlowEmailTesting.readContentsOfMail(emailDetails13); logger.info(
			 * "Email body : " + emailDetails13.getEmailBody()); logger.info(
			 * "Email body created from file : " +
			 * IEmailTestingConstants.Body_For_PO_Released);
			 * 
			 * emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(
			 * IEmailTestingConstants.Body_For_PO_Released,
			 * documentInformation_forPO);
			 * 
			 * emailDetails13.setEmailResultForBody(FlowEmailTesting.
			 * checkIfBodyOfEmailIsRight( emailDetails13.getEmailBody(),
			 * emailBody, "\n",
			 * IEmailTestingConstants.EventType_Released_Requisition));
			 * emailResultsForEmailBody.add(emailDetails13.getEmailResultForBody
			 * ()); emailResultDetails.add(emailDetails13);
			 */

			// po released
			EmailDetails emailDetails_poReleased = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Released_PO, documentInformation_forPO);

			EmailDetails emailDetails12 = FlowEmailTesting.readEmail(emailDetails_poReleased);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails12, emailDetails_poReleased, "Subject of Email after Purchase Order Released",
				IEmailTestingConstants.EventType_Released_PO));
			emailResultDetails.add(emailDetails12);

			// amended released po
			documentInformation_forPO.getPurchaseOrder().setPoTotal(poTotal_AfterAmendment);
			EmailDetails emailDetails_amendedReleasedPO = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Amended_Released_PO, documentInformation_forPO);

			EmailDetails emailDetails14 = FlowEmailTesting.readEmail(emailDetails_amendedReleasedPO);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails14, emailDetails_amendedReleasedPO, "Subject of Email after Released PO Amended",
				IEmailTestingConstants.EventType_Amended_Released_PO));
			emailResultDetails.add(emailDetails14);

			driver.navigate().refresh();
			if (ActionBot.isAlertPresent(driver, testCaseName))
			{
				ActionBot.acceptAlert(driver, testCaseName);
			}

			// remind receipt
			EmailDetails emailDetails_remindReceipt = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Remind_Receipt, documentInformation_forPO);

			EmailDetails emailDetails15 = FlowEmailTesting.readEmail(emailDetails_remindReceipt);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails15, emailDetails_remindReceipt, "Subject of Email after Remind Receipt",
				IEmailTestingConstants.EventType_Remind_Receipt));
			emailResultDetails.add(emailDetails15);

			// assertion : email sent check
			flag = emailResults.get(0).isResult();
			for (EmailResult emailResult : emailResults)
			{
				flag = flag && emailResult.isResult();
				if (emailResult.getMessage() != null)
				{
					log += emailResult.getMessage() + "\n";
				}
				map.putAll(emailResult.getMap());
			}
			assertTrue(log, flag);

			// assertion : email body check
			log = "";
			flag = emailResultsForEmailBody.get(0).isResult();
			for (EmailResult emailResult : emailResultsForEmailBody)
			{
				flag = flag && emailResult.isResult();
				if (emailResult.getMessage() != null)
				{
					log += emailResult.getMessage() + "\n";
				}
				map.putAll(emailResult.getMap());
			}
			assertTrue(log, flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (MessagingException e)
		{
			logger.error("\n Messaging Exception while reading email from outlook");
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, emailResultDetails);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check email send after req submit
	 * having need a quote item <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void emailTesting_submitReqWithNeedAQuoteItem(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new LinkedHashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Item items = null;
		Requisition requisition = null;
		List<EmailResult> emailResults = new ArrayList<EmailResult>();
		List<EmailResult> emailResultsForEmailBody = new ArrayList<EmailResult>();
		LinkedList<EmailDetails> emailResultDetails = new LinkedList<>();
		String status = null, emailBodyTemplate = null, log = "";
		boolean flag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			items = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			items.getGuidedItems().get(0).setSourcingStatus(IConstantsData.Need_a_Quote);

			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(items);

			// create req
			logger.info("============================= Create Requisition =============================");
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// search req
			logger.info("============================= Search Requisition =============================");
			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			assertTrue("Error while searching requisition", requisition.isResult());

			// check status
			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of requisition was wrong, it should be Sent for Quote", status.equalsIgnoreCase(IConstantsData.SENT_FOR_QUOTE_FILTER_LABEL));

			// search req at buyers desk
			logger.info("============================= Search Requisition At Buyers Desk =============================");
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Requisition was not found at buyers desk", requisition.isResult());

			// check status
			status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			assertTrue("Status of requisition at buyers desk was wrong,it should be Awaiting Quote", status.equalsIgnoreCase(IConstantsData.AWAITING_QUOTE_FILTER_LABEL));

			GuidedItem guidedItem = new GuidedItem();
			guidedItem.setSourcingStatus(IConstantsData.Quoted_by_supplier);
			guidedItem.setNextAction(IConstantsData.SAVE);

			// view req
			logger.info("============================= View Requisition =============================");
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);
			ActionBot.scroll(driver, "350");

			// view item details
			PageBuyersDesk.clickOnItemName(driver, testCaseName, requisition.getItems().getGuidedItems().get(0).getItemID());
			ActionBot.defaultSleep();

			// change item details
			logger.info("============================= Edit Item Details =============================");
			guidedItem = FlowBuyersDesk.editGuidedItemDetailsatBuyersDesk(driver, testCaseName, guidedItem);

			// send for apporval
			logger.info("============================= Send Requisition For Approval =============================");
			FlowBuyersDesk.sendReqForApproval(driver, testCaseName);

			// reject req
			ApprovalAllRequests approvalAllRequests_for_rejection = new ApprovalAllRequests();
			approvalAllRequests_for_rejection.setDocumentType(IConstantsData.REQUISITION);
			approvalAllRequests_for_rejection.setDocumentNo(requisition.getReqNo());
			approvalAllRequests_for_rejection.setActions(IConstantsData.REJECT);
			approvalAllRequests_for_rejection.setComment(IConstantsData.REJECT_COMMENT);

			logger.info("============================= Reject Requisition =============================");
			approvalAllRequests_for_rejection = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests_for_rejection);
			assertTrue("Error while rejecting requisition", approvalAllRequests_for_rejection.isResult());

			// search in my req tab
			logger.info("============================= Search Requisition =============================");
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			assertTrue("Requisition was not found at my requisition page", requisition.isResult());

			// check status
			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of requisition was wrong, it should be rejected", status.equalsIgnoreCase(IConstantsData.REJECTED_FILTER_LABEL));

			// edit req
			logger.info("============================= Edit and Submit Requisition =============================");
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnEditLink(driver, testCaseName);

			// submit req
			FlowRequisition.submitReq(driver, testCaseName, true);

			// search in my req tab
			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			assertTrue("Requisition was not found at my requisition page", requisition.isResult());

			// check status
			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			assertTrue("Status of requisition was wrong, it should be In Approval", status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL));

			// approve req
			ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION,
				IConstantsData.APPROVE);

			logger.info("============================= Approve Requisition =============================");
			approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			assertTrue("Error while approving requisition", approvalAllRequests.isResult());

			ActionBot.defaultMediumSleep();
			ActionBot.defaultHighSleep();

			logger.info("============================= Email testing =============================");

			DocumentInformation documentInformation = ObjectCreation.getObjectOfDocumentInformation(DocumentInformation.docType_Requisition, requisition, null, null, null);
			documentInformation.setUser(user);

			// req submitted
			EmailDetails emailDetails_documentSubmitted = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Submitted, documentInformation);

			EmailDetails emailDetails = FlowEmailTesting.readEmail(emailDetails_documentSubmitted);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails, emailDetails_documentSubmitted, "Subject of Email after requisition submitted",
				IEmailTestingConstants.EventType_Document_Submitted));

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			logger.info("============================= Email Body Testing =============================");
			emailDetails = FlowEmailTesting.readContentsOfMail(emailDetails);
			logger.info("Email body : " + emailDetails.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_Requisition);

			String emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_Requisition, documentInformation);

			emailDetails.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Submitted));
			emailResultsForEmailBody.add(emailDetails.getEmailResultForBody());
			emailResultDetails.add(emailDetails);

			// sent for quote
			EmailDetails emailDetails_sentForQuote = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Sent_For_Quote, documentInformation);

			EmailDetails emailDetails1 = FlowEmailTesting.readEmail(emailDetails_sentForQuote);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails1, emailDetails_sentForQuote, "Subject of Email after requisition sent for quote",
				IEmailTestingConstants.EventType_Sent_For_Quote));

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			logger.info("============================= Email Body Testing =============================");

			emailDetails1 = FlowEmailTesting.readContentsOfMail(emailDetails1);
			logger.info("Email body : " + emailDetails1.getEmailBody());
			emailBodyTemplate = IEmailTestingConstants.Body_Requisition_Submitted_For_Sourcing + "\n" + IEmailTestingConstants.Body_For_Requisition;
			logger.info("Email body created from file : " + emailBodyTemplate);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_Requisition, documentInformation);

			emailDetails1.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails1.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Submitted));
			emailResultsForEmailBody.add(emailDetails1.getEmailResultForBody());
			emailResultDetails.add(emailDetails1);

			// req pending for approval
			EmailDetails emailDetails_reqApprovalPending = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approval_Pending, documentInformation);

			EmailDetails emailDetails2 = FlowEmailTesting.readEmail(emailDetails_reqApprovalPending);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails2, emailDetails_reqApprovalPending, "Subject of Email for requisition approval pending",
				IEmailTestingConstants.EventType_Document_Approval_Pending));

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			logger.info("============================= Email Body Testing =============================");
			emailDetails2 = FlowEmailTesting.readContentsOfMail(emailDetails2);
			logger.info("Email body : " + emailDetails2.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_Requisition);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_Requisition, documentInformation);

			emailDetails2.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails2.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approval_Pending));
			emailResultsForEmailBody.add(emailDetails2.getEmailResultForBody());
			emailResultDetails.add(emailDetails2);

			// search req at buyers desk
			logger.info("============================= Search Requisition At Buyers Desk =============================");
			requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			assertTrue("Requisition was not found at buyers desk", requisition.isResult());

			// to return req from buyers desk
			logger.info("============================= Return Requisition from Buyers Desk =============================");
			flag = FlowBuyersDeskListing.returnRequisitionFromBuyersDesk(driver, testCaseName, requisition, true);
			assertTrue("Pending Requisition was not returned", flag);

			logger.info("============================= Email testing =============================");

			// req rejected
			documentInformation.setCommentForActionPerformed(approvalAllRequests_for_rejection.getComment());
			EmailDetails emailDetails_reqRejected = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Rejected, documentInformation);

			EmailDetails emailDetails3 = FlowEmailTesting.readEmail(emailDetails_reqRejected);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails3, emailDetails_reqRejected, "Subject of Email for requisition rejected",
				IEmailTestingConstants.EventType_Document_Rejected));
			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			logger.info("============================= Email Body Testing =============================");
			emailDetails3 = FlowEmailTesting.readContentsOfMail(emailDetails3);
			logger.info("Email body : " + emailDetails3.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Document_Rejected);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Document_Rejected, documentInformation);

			emailDetails3.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails3.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Rejected));
			emailResultsForEmailBody.add(emailDetails3.getEmailResultForBody());
			emailResultDetails.add(emailDetails3);

			// req submitted
			emailDetails_documentSubmitted = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Submitted, documentInformation);

			EmailDetails emailDetails4 = FlowEmailTesting.readEmail(emailDetails_documentSubmitted);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails4, emailDetails_documentSubmitted, "Subject of Email after requisition submitted",
				IEmailTestingConstants.EventType_Document_Submitted));

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			logger.info("============================= Email Body Testing =============================");
			emailDetails4 = FlowEmailTesting.readContentsOfMail(emailDetails4);
			logger.info("Email body : " + emailDetails4.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_Requisition);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_Requisition, documentInformation);

			emailDetails4.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails4.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Submitted));
			emailResultsForEmailBody.add(emailDetails4.getEmailResultForBody());
			emailResultDetails.add(emailDetails4);

			// req pending for approval
			emailDetails_reqApprovalPending = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approval_Pending, documentInformation);

			EmailDetails emailDetails5 = FlowEmailTesting.readEmail(emailDetails_reqApprovalPending);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails5, emailDetails_reqApprovalPending, "Subject of Email for requisition approval pending",
				IEmailTestingConstants.EventType_Document_Approval_Pending));

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			logger.info("============================= Email Body Testing =============================");
			emailDetails5 = FlowEmailTesting.readContentsOfMail(emailDetails5);
			logger.info("Email body : " + emailDetails5.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_Requisition);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_Requisition, documentInformation);

			emailDetails5.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails5.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approval_Pending));
			emailResultsForEmailBody.add(emailDetails5.getEmailResultForBody());
			emailResultDetails.add(emailDetails5);

			// req approved
			EmailDetails emailDetails_reqApproved = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approved, documentInformation);

			EmailDetails emailDetails6 = FlowEmailTesting.readEmail(emailDetails_reqApproved);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails6, emailDetails_reqApproved, "Subject of Email for requisition approved",
				IEmailTestingConstants.EventType_Document_Approved));

			// email body testing
			logger.info("============================= Email Body Testing =============================");
			documentInformation.setCommentForActionPerformed(approvalAllRequests.getComment());
			emailDetails6 = FlowEmailTesting.readContentsOfMail(emailDetails6);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Document_Approved);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Document_Approved, documentInformation);

			emailDetails6.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails6.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approved));
			emailResultsForEmailBody.add(emailDetails6.getEmailResultForBody());
			emailResultDetails.add(emailDetails6);

			// returned req from buyers desk
			EmailDetails emailDetails_returnedReqFromBuyersDesk = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Returned_Req_From_Buyers_Desk, documentInformation);

			EmailDetails emailDetails7 = FlowEmailTesting.readEmail(emailDetails_returnedReqFromBuyersDesk);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails7, emailDetails_returnedReqFromBuyersDesk, "Subject of Email for Returned Requisition From Buyers Desk",
				IEmailTestingConstants.EventType_Returned_Req_From_Buyers_Desk));

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			// email body testing
			logger.info("============================= Email Body Testing =============================");
			documentInformation.setCommentForActionPerformed(IConstantsData.COMMENT_FOR_RETURN_REQUISITION);
			emailDetails7 = FlowEmailTesting.readContentsOfMail(emailDetails7);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Requisition_Returned);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Requisition_Returned, documentInformation);

			emailDetails7.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails7.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Returned_Req_From_Buyers_Desk));

			emailResultsForEmailBody.add(emailDetails7.getEmailResultForBody());
			emailResultDetails.add(emailDetails7);

			// assertion : email sent check
			flag = emailResults.get(0).isResult();
			for (EmailResult emailResult : emailResults)
			{
				flag = flag && emailResult.isResult();
				if (emailResult.getMessage() != null)
				{
					log += emailResult.getMessage() + "\n";
				}
				if (emailResult.getMap() != null)
				{
					map.putAll(emailResult.getMap());
				}
			}
			assertTrue(log, flag);

			// assertion : email body check
			log = "";
			flag = emailResultsForEmailBody.get(0).isResult();
			for (EmailResult emailResult : emailResultsForEmailBody)
			{
				flag = flag && emailResult.isResult();
				if (emailResult.getMessage() != null)
				{
					log += emailResult.getMessage() + "\n";
				}
				if (emailResult.getMap() != null)
				{
					map.putAll(emailResult.getMap());
				}
			}
			assertTrue(log, flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (MessagingException e)
		{
			logger.error("Messaging Exception while reading email from outlook" + e, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, emailResultDetails);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check email send after req is delegated
	 * and delegation revoked <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 1)
	public void emailTesting_reqDelegationAndDeleagtionRevoked(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new LinkedHashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		MySettings delegateSettings = new MySettings();
		MySettings revokeSettings = new MySettings();
		String status = null, log = "";
		List<EmailResult> emailResults = new ArrayList<>();
		List<EmailResult> emailResultsForEmailBody = new ArrayList<>();
		List<EmailDetails> emailDetailsList = new ArrayList<>();
		LinkedList<EmailDetails> emailResultDetails = new LinkedList<>();
		boolean delegatedFlag = false, flag = false;
		try
		{
			user = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, IConstantsData.Delegate_Role);
			LoginLogoutServices.login(driver, testCase, user);

			// to delegate to user
			User user2 = UserUtilHelper.getAvailableUserFromList();

			// req object creation
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);

			// default object of my settings
			delegateSettings = ObjectCreation.getDefaultObjectOfMySettings(IConstantsData.DELEGATE, user.getUsername(), user2.getUsername(), null);
			revokeSettings = ObjectCreation.getDefaultObjectOfMySettings(IConstantsData.REVOKE, null, null, user.getUsername());

			// delegate approval
			logger.info("===================== Delegate Assigned =====================");
			delegateSettings = FlowMySettings.performActions(driver, testCaseName, delegateSettings);
			delegatedFlag = true;

			MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// create Req
			logger.info("===================== Create Requisition =====================");

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search in my req tab
			logger.info("===================== Search in My Requisition =====================");
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests.setDocumentNo(requisition.getReqNo());
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);

			logger.info("===================== Search in All Requests =====================");
			FlowAllRequestsApproval.searchInAllRequestsApprovalTab(driver, testCaseName, approvalAllRequests);
			status = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName);
			status.equalsIgnoreCase(IConstantsData.DELEGATED_FILTER_STATUS);

			// revoke approval
			logger.info("===================== Delegate Revoked =====================");
			revokeSettings = FlowMySettings.performActions(driver, testCaseName, revokeSettings);
			delegatedFlag = false;

			DocumentInformation documentInformation = new DocumentInformation();
			// documentInformation.setDocType(IConstantsData.REQUISITION);
			documentInformation.setRequester(user.getDisplayName());
			documentInformation.setCreatedOn(delegateSettings.getDelegateDateTo().getDate());
			documentInformation.setUser(user);

			// delegate approval
			logger.info("===================== Delegate Document =====================");
			ApprovalAllRequestsStatusFilter approvalAllRequestsStatusFilter = new ApprovalAllRequestsStatusFilter();
			approvalAllRequestsStatusFilter.setPending(true);
			approvalAllRequestsStatusFilter = FlowAllRequestsApproval.applyApprovalAllRequestsStatusFilter(driver, testCaseName, approvalAllRequestsStatusFilter);
			// assertTrue("Pending status filter was not applied properly",
			// approvalAllRequestsStatusFilter.isResult());

			approvalAllRequests.setComment(IConstantsData.DELEGATE_COMMENT);
			approvalAllRequests.setDelegateTo(user2.getUsername());
			approvalAllRequests.setActions(IConstantsData.DELEGATE);
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
			approvalAllRequests.setDocumentNo(PageAllRequestsApproval.getFirstRowDocumentNo(driver, testCaseName));
			documentInformation.setDocNo(approvalAllRequests.getDocumentNo());
			documentInformation.setDocType(IConstantsData.REQUISITION);
			documentInformation.setCommentForActionPerformed(IConstantsData.DELEGATE_COMMENT);
			documentInformation.setRequisition(requisition);
			documentInformation.setItem(item);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			status = PageAllRequestsApproval.getDocumentStatus(driver, testCaseName);
			assertTrue("Status of document was wrong,ite should be Delegated", status.equalsIgnoreCase(IConstantsData.DELEGATED_FILTER_STATUS));

			ActionBot.defaultMediumSleep();
			ActionBot.defaultMediumSleep();
			ActionBot.defaultMediumSleep();

			logger.info("============================= Email testing =============================");

			// ALL req delegated
			// date formatting
			/*
			 * documentInformation.setMySettingsForApproval(delegateSettings);
			 * SimpleDateFormat dateFormat = new
			 * SimpleDateFormat("dd-MMM-yyyy"); SimpleDateFormat dateFormat2 =
			 * new SimpleDateFormat("dd/MM/yyyy");
			 * 
			 * Date date2 =
			 * dateFormat2.parse(delegateSettings.getDelegateDateFrom().getDate(
			 * )); documentInformation.getMySettingsForApproval().
			 * getDelegateDateFrom().setDate(dateFormat.format(date2));
			 * 
			 * dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy"); date2 =
			 * dateFormat2.parse(delegateSettings.getDelegateDateTo().getDate())
			 * ;
			 * documentInformation.getMySettingsForApproval().getDelegateDateTo(
			 * ).setDate(dateFormat2.format(date2));
			 */
			documentInformation.setMySettingsForApproval(delegateSettings);
			documentInformation.getMySettingsForApproval().getDelegateDateFrom()
				.setDate(CommonUtilities.getProperDateForEmailTesting(delegateSettings.getDelegateDateFrom().getDate()));
			documentInformation.getMySettingsForApproval().getDelegateDateTo()
				.setDate(CommonUtilities.getProperDateForEmailTesting(delegateSettings.getDelegateDateTo().getDate()));

			EmailDetails emailDetails_delegated = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Delegate_Assigned, documentInformation);

			EmailDetails emailDetails = FlowEmailTesting.readEmail(emailDetails_delegated);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails, emailDetails_delegated, "Subject of Email for delegation assigned",
				IEmailTestingConstants.EventType_Delegate_Assigned));
			emailDetails.setEventType(IEmailTestingConstants.EventType_Delegate_Assigned);

			// email body testing
			emailDetails = FlowEmailTesting.readContentsOfMail(emailDetails);
			logger.info("Email body : " + emailDetails.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_All_Document_Delegated);
			emailDetailsList.add(emailDetails);

			String emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_All_Document_Delegated, documentInformation);

			emailDetails.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Delegate_Assigned));
			emailResultsForEmailBody.add(emailDetails.getEmailResultForBody());
			emailResultDetails.add(emailDetails);

			// delegation revoked
			// documentInformation.setMySettingsForApproval(delegateSettings);

			/*
			 * date2 =
			 * dateFormat2.parse(revokeSettings.getDelegateDateFrom().getDate())
			 * ; documentInformation.getMySettingsForApproval().
			 * getDelegateDateFrom().setDate(dateFormat.format(date2));
			 */

			/*
			 * date2 =
			 * dateFormat2.parse(revokeSettings.getDelegateDateTo().getDate());
			 * documentInformation.getMySettingsForApproval().getDelegateDateTo(
			 * ).setDate(dateFormat.format(date2));
			 */

			EmailDetails emailDetails_revoked = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Delegate_Revoked, documentInformation);

			EmailDetails emailDetails1 = FlowEmailTesting.readEmail(emailDetails_revoked);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails1, emailDetails_revoked, "Subject of Email after delegation revoked",
				IEmailTestingConstants.EventType_Delegate_Revoked));
			emailDetails1.setEventType(IEmailTestingConstants.EventType_Delegate_Revoked);

			// email body testing
			documentInformation.setMySettingsForApproval(delegateSettings);
			emailDetails1 = FlowEmailTesting.readContentsOfMail(emailDetails1);
			logger.info("Email body : " + emailDetails1.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_All_Document_Delegation_Revoked);
			emailDetailsList.add(emailDetails1);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_All_Document_Delegation_Revoked, documentInformation);

			emailDetails1.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails1.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Delegate_Revoked));
			emailResultsForEmailBody.add(emailDetails1.getEmailResultForBody());
			emailResultDetails.add(emailDetails1);

			// req delegated
			EmailDetails emailDetails_approvalDelegatedt = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Approval_Delegated, documentInformation);

			EmailDetails emailDetails2 = FlowEmailTesting.readEmail(emailDetails_approvalDelegatedt);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails2, emailDetails_approvalDelegatedt, "Subject of Email after approval delegation",
				IEmailTestingConstants.EventType_Approval_Delegated));
			emailDetails2.setEventType(IEmailTestingConstants.EventType_Approval_Delegated);

			// email body testing
			documentInformation.setMySettingsForApproval(delegateSettings);
			emailDetails2 = FlowEmailTesting.readContentsOfMail(emailDetails2);
			logger.info("Email body : " + emailDetails2.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Document_Delegated);
			emailDetailsList.add(emailDetails2);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Document_Delegated, documentInformation);

			emailDetails2.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails2.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Approval_Delegated));
			emailResultsForEmailBody.add(emailDetails2.getEmailResultForBody());
			emailResultDetails.add(emailDetails2);

			// assertion : email sent check
			flag = emailResults.get(0).isResult();
			for (EmailResult emailResult : emailResults)
			{
				flag = flag && emailResult.isResult();
				if (emailResult.getMessage() != null)
				{
					log += emailResult.getMessage() + "\n";
				}
				map.putAll(emailResult.getMap());
			}
			assertTrue(log, flag);

			// assertion : email body check
			log = "";
			flag = emailResultsForEmailBody.get(0).isResult();
			for (EmailResult emailResult : emailResultsForEmailBody)
			{
				flag = flag && emailResult.isResult();
				if (emailResult.getMessage() != null)
				{
					log += emailResult.getMessage() + "\n";
				}
				map.putAll(emailResult.getMap());
			}
			assertTrue(log, flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (MessagingException e)
		{
			logger.error("Messaging Exception while reading email from outlook" + e, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			try
			{
				if (delegatedFlag)
				{
					logger.info("===================== Delegate Revoked =====================");
					FlowMySettings.performActions(driver, testCaseName, revokeSettings);
				}
			}
			catch (Exception e)
			{
				logger.info("Error while revoking delegation : " + e, e);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, emailResultDetails);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Email testing for touchless po generation
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the status of req in buyers
	 * desk </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", priority = 2)
	public void emailTesting_generateTouchlessPO(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		Requisition requisition = new Requisition();
		Item item = new Item();
		PurchaseOrderSettings purchaseOrderSettings = new PurchaseOrderSettings();
		PurchaseOrderSettings defaultPurchaseOrderSettings = new PurchaseOrderSettings();
		String status, log = "";
		List<EmailResult> emailResults = new ArrayList<>();
		LinkedList<EmailDetails> emailResultDetails = new LinkedList<>();
		boolean flag = false, purchaseOrderSettingChanged = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);

			// default PO Settings
			defaultPurchaseOrderSettings.setReleaseOrdersImmediately(true);
			defaultPurchaseOrderSettings.setAutomaticallyGenerateOrders(false);
			defaultPurchaseOrderSettings.setNextAction(IConstantsData.SAVE);

			// to change purchase order setting
			purchaseOrderSettings.setReleaseOrdersImmediately(true);
			purchaseOrderSettings.setAutomaticallyGenerateOrders(true);
			purchaseOrderSettings.setNextAction(IConstantsData.SAVE);
			purchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, purchaseOrderSettings);
			purchaseOrderSettingChanged = true;

			// to get default req object
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);

			// to click on online store tab
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// req to buyers desk
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			// to search in my req
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);
			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			flag = (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL));
			assertTrue("Status of requisition was wrong", flag);

			// to approve
			ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
			approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION, IConstantsData.APPROVE);

			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

			requisition.setReqNo(approvalAllRequests.getDocumentNo());
			// check if auto po generated- search in my req tab
			requisition = FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

			status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
			flag = (status.equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL)) || (status.equalsIgnoreCase(IConstantsData.SCHEDULED_FILTER_LABEL))
				|| (status.equalsIgnoreCase(IConstantsData.ORDERING_FILTER_LABEL));
			assertTrue("Status of Requisition in My Requisition Tab was wrong. Touchless po was not generated", flag);

			// search at buyers desk
			FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
			status = PageBuyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
			flag = (status.equalsIgnoreCase(IConstantsData.PARKED_FILTER_LABEL)) || (status.equalsIgnoreCase(IConstantsData.SCHEDULED_FILTER_LABEL))
				|| (status.equalsIgnoreCase(IConstantsData.ORDERING_FILTER_LABEL));
			assertTrue("Status of Requisition at buyers desk was wrong. Touchless po was not generated", flag);

			logger.info("============================= Email testing =============================");

			DocumentInformation documentInformation = new DocumentInformation();
			documentInformation.setDocNo(requisition.getReqNo());

			// req parked
			EmailDetails emailDetails_parked = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Parked, documentInformation);

			EmailDetails emailDetails = FlowEmailTesting.readEmail(emailDetails_parked);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails, emailDetails_parked, "Subject of Email after PR parked", IEmailTestingConstants.EventType_Parked));
			emailResultDetails.add(emailDetails);

			for (EmailResult emailResult : emailResults)
			{
				if (emailResult.getMessage() != null)
				{
					log += emailResult.getMessage();
				}
				map.putAll(emailResult.getMap());
			}
			assertTrue(log, emailResults.get(0).isResult());

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			try
			{
				if (purchaseOrderSettingChanged)
				{
					// purchaseOrderSettings.setAutomaticallyGenerateOrders(false);
					defaultPurchaseOrderSettings = FlowPurchaseOrderSetting.changePOSetting(driver, testCaseName, defaultPurchaseOrderSettings);
				}
			}
			catch (Exception exception)
			{
				logger.error("Error while changing PO setting : " + exception, exception);
			}
			finally
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, emailResultDetails);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Email PO and check visibility of
	 * attachments <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b>Checks for the PO email success
	 * div </font><b><br>
	 * @param testCase </font><b><br>
	 * @throws Exception </b> <br>
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class, priority = 1)
	public void emailPOAndCheckVisibilityOfAttachments(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		StandardPO standardPO = new StandardPO();
		List<EmailResult> emailResults = new ArrayList<>();
		List<EmailResult> emailResultsForEmailBody = new ArrayList<>();
		LinkedList<EmailDetails> emailResultDetails = new LinkedList<>();
		EmailResult emailResultForAttachments = null;
		EmailResult emailResultForAttachments_notPresent = null;
		String emailBody, log_subject = "", log_body = "", log = "";
		boolean flag = false, emailSubjectFlag = false, emailBodyFlag = false;
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			driver.getCurrentUrl();
			// to get Standard PO object
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.BOTH);

			// attachment and comments
			AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary_catalogItem = ObjectCreation.getDefaultObjectOfAttachmentAnCommentsItemSummary();
			AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary_guidedItem = ObjectCreation.getDefaultObjectOfAttachmentAnCommentsItemSummary();
			attachmentsAndCommentsItemSummary_catalogItem.setNextAction(IConstantsData.NONE);
			attachmentsAndCommentsItemSummary_guidedItem.setNextAction(IConstantsData.NONE);
			attachmentsAndCommentsItemSummary_guidedItem.getAttachments().get(0).setFileName(IConstants.ATTACHMENT_FILES_PATH + IConstantsData.ITEM_ATTACHMENT_VALIDATION);
			attachmentsAndCommentsItemSummary_guidedItem.getAttachments().get(0).setFileVisibility(IConstantsData.supplier_file_visibility);

			standardPO.getItems().getCatelogItems().get(0).setAttachmentsAndCommentsItemSummary(attachmentsAndCommentsItemSummary_catalogItem);
			standardPO.getItems().getGuidedItems().get(0).setAttachmentsAndCommentsItemSummary(attachmentsAndCommentsItemSummary_guidedItem);

			// create standard PO
			standardPO = FlowStandardPo.createStandardPo(driver, testCaseName, standardPO);

			/*
			 * ActionBot.defaultSleep();
			 * MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			 * driver.get(url);
			 */
			// search po
			flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("Error while searching PO", flag);

			String status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
				approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, standardPO.getPoNumber(), IConstantsData.PURCHASE_ORDER,
					IConstantsData.APPROVE);

				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultSleep();
				ActionBot.defaultHighSleep();
				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();
				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, standardPO.getPoNumber(), IConstantsData.SEARCH_BY_PO_NO);
				assertTrue("Error while searching PO", flag);

				flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
				// assertTrue("Status of PO was not Released", flag);
			}

			// view po
			FlowPoListing.viewPO(driver, testCaseName);

			standardPO.setApprover(PageViewPurchaseOrder.getFirstApproverNameOnWorkflow(driver, testCaseName));

			// to email the PO
			PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
			ModalViewPOActions.clickOnEmailPoLink(driver, testCaseName);

			// to send email
			Map<String, String> emailPODetails = FlowViewPO.emailPO(driver, testCaseName);

			flag = ModalEmailPODocument.isSendEmailSuccessDivPresent(driver, testCaseName);

			ActionBot.threadSleep(30);

			ActionBot.refreshPage(driver, testCaseName);

			// to add attachments to be send in mail
			List<FileAttachment> attachments = new ArrayList<>();
			FileAttachment emailPOAttachment = new FileAttachment();
			emailPOAttachment.setFileName(emailPODetails.get(IConstantsData.EMAIL_PO_ATTACHMENT_NAME).replace("/", ""));
			attachments.add(attachmentsAndCommentsItemSummary_guidedItem.getAttachments().get(0));
			attachments.add(emailPOAttachment);

			// create document info object for email testing
			DocumentInformation documentInformation_forPO = ObjectCreation.getObjectOfDocumentInformation(DocumentInformation.docType_STANDARD_PO, null, standardPO, null, null);
			documentInformation_forPO.setUser(user);
			documentInformation_forPO.setRequester(user.getDisplayName());
			documentInformation_forPO.setCommentForActionPerformed(IConstantsData.APPROVE_COMMENT);

			logger.info("=================================== Email Testing : po submitted =====================================");
			// po submitted
			EmailDetails emailDetails_documentSubmitted = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Submitted, documentInformation_forPO);

			EmailDetails emailDetails = FlowEmailTesting.readEmail(emailDetails_documentSubmitted);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails, emailDetails_documentSubmitted, "Subject of Email after Purchase Order submitted",
				IEmailTestingConstants.EventType_Document_Submitted));

			logger.info("============================= Email Body Testing : po submitted =============================");
			emailDetails = FlowEmailTesting.readContentsOfMail(emailDetails);
			logger.info("Email body : " + emailDetails.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_PO);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_PO, documentInformation_forPO);

			emailDetails.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Submitted));
			emailResultsForEmailBody.add(emailDetails.getEmailResultForBody());
			// emailDetails.setEmailResultForSubject(emailResults.get(0));
			// emailDetails.setEmailResultForBody(emailResultsForEmailBody.get(0));
			emailResultDetails.add(emailDetails);

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			logger.info("=================================== Email Testing : po pending for approval =====================================");
			// po pending for approval
			EmailDetails emailDetails_reqApprovalPending = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approval_Pending, documentInformation_forPO);

			EmailDetails emailDetails1 = FlowEmailTesting.readEmail(emailDetails_reqApprovalPending);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails1, emailDetails_reqApprovalPending, "Subject of Email for Purchase Order approval pending",
				IEmailTestingConstants.EventType_Document_Approval_Pending));

			logger.info("============================= Email Body Testing : po pending for approval =============================");
			// email body testing
			emailDetails1 = FlowEmailTesting.readContentsOfMail(emailDetails1);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_For_PO);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_For_PO, documentInformation_forPO);

			emailDetails1.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails1.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approval_Pending));
			emailResultsForEmailBody.add(emailDetails1.getEmailResultForBody());
			// emailDetails1.setEmailResultForSubject(emailResults.get(1));
			// emailDetails1.setEmailResultForBody(emailResultsForEmailBody.get(1));
			emailResultDetails.add(emailDetails1);

			logger.info("=================================== Email Testing : po approved =====================================");
			// po approved
			EmailDetails emailDetails_poApproved = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Document_Approved, documentInformation_forPO);

			EmailDetails emailDetails2 = FlowEmailTesting.readEmail(emailDetails_poApproved);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails2, emailDetails_poApproved, "Subject of Email for Purchase Order approved",
				IEmailTestingConstants.EventType_Document_Approved));
			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			logger.info("============================= Email Body Testing : po approved =============================");
			// email body testing
			emailDetails2 = FlowEmailTesting.readContentsOfMail(emailDetails2);
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Document_Approved);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Document_Approved, documentInformation_forPO);

			emailDetails2.setEmailResultForBody(
				FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails2.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Document_Approved));
			emailResultsForEmailBody.add(emailDetails2.getEmailResultForBody());

			// emailDetails2.setEmailResultForSubject(emailResults.get(2));
			// emailDetails2.setEmailResultForBody(emailResultsForEmailBody.get(2));
			emailResultDetails.add(emailDetails2);

			/*
			 * logger.info(
			 * "=================================== Email Testing : po released ====================================="
			 * ); //po released EmailDetails emailDetails_poReleased =
			 * ObjectCreation.getEmailDetailsObject(
			 * IConstantsData.Email_Testing_Username,
			 * IConstantsData.Email_Testing_Password,
			 * IConstantsData.Email_Testing_Default_Folder_Of_Emails,
			 * IEmailTestingConstants.EventType_Released_PO,
			 * documentInformation_forPO);
			 * 
			 * EmailDetails emailDetails3 =
			 * FlowEmailTesting.readEmail(emailDetails_poReleased);
			 * emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails3,
			 * emailDetails_poReleased,
			 * "Subject of Email after Purchase Order Released",
			 * IEmailTestingConstants.EventType_Released_PO));
			 * 
			 * emailDetails_poReleased.setEmailResultForSubject(emailResults.get
			 * (3));
			 * //emailDetails.setEmailResultForBody(emailResultsForEmailBody.get
			 * (0)); emailResultDetails.add(emailDetails_poReleased);
			 */

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);
			ActionBot.threadSleep(50);

			logger.info("=================================== Email Testing : email po =====================================");
			// email po
			EmailDetails emailDetails_emailPO = ObjectCreation.getEmailDetailsObject(IConstantsData.Email_Testing_Username, IConstantsData.Email_Testing_Password,
				IConstantsData.Email_Testing_Default_Folder_Of_Emails, IEmailTestingConstants.EventType_Email_PO, documentInformation_forPO);

			EmailDetails emailDetails4 = FlowEmailTesting.readEmail(emailDetails_emailPO);
			emailResults.add(FlowEmailTesting.checkIfEmailSent(emailDetails4, emailDetails_emailPO, "Subject of Email after Email PO", IEmailTestingConstants.EventType_Email_PO));

			logger.info("============================= Email Body Testing : email po =============================");
			// email body testing
			emailDetails4 = FlowEmailTesting.readContentsOfMail(emailDetails4);
			logger.info("Email body : " + emailDetails4.getEmailBody());
			logger.info("Email body created from file : " + IEmailTestingConstants.Body_Email_PO);

			emailBody = FlowEmailTesting.getBodyOfEmailFromBodyTemplate(IEmailTestingConstants.Body_Email_PO, documentInformation_forPO);

			emailDetails4
				.setEmailResultForBody(FlowEmailTesting.checkIfBodyOfEmailIsRight(emailDetails4.getEmailBody(), emailBody, "\n", IEmailTestingConstants.EventType_Email_PO));
			emailResultsForEmailBody.add(emailDetails4.getEmailResultForBody());

			// refresh page
			ActionBot.refreshPage(driver, testCaseName);

			// attachment check : proper attachments are present
			emailResultForAttachments = FlowEmailTesting.checkIfAttachmentsInBodyAreRight(attachments, emailDetails4.getAttachments());

			// attachment check : proper attachments are not present in body
			emailResultForAttachments_notPresent = FlowEmailTesting.checkIfGivenAttachmentsAreNotPresentInBody(attachmentsAndCommentsItemSummary_catalogItem.getAttachments(),
				emailDetails4.getAttachments());

			// emailDetails4.setEmailResultForSubject(emailResults.get(3));
			// emailDetails4.setEmailResultForBody(emailResultsForEmailBody.get(3));
			emailResultDetails.add(emailDetails4);

			// assertion : email sent check
			log_subject = "";
			emailSubjectFlag = emailResults.get(0).isResult();
			for (EmailResult emailResult : emailResults)
			{
				emailSubjectFlag = emailSubjectFlag && emailResult.isResult();
				if (emailResult.getMessage() != null)
				{
					log_subject += emailResult.getMessage() + "\n";
				}
				map.putAll(emailResult.getMap());
			}

			// assertion : email body check
			log_body = "";
			emailBodyFlag = emailResultsForEmailBody.get(0).isResult();
			for (EmailResult emailResult : emailResultsForEmailBody)
			{
				emailBodyFlag = emailBodyFlag && emailResult.isResult();
				if (emailResult.getMessage() != null)
				{
					log_body += emailResult.getMessage() + "\n";
				}
				map.putAll(emailResult.getMap());
			}

			// assertion for subject , body and attachment
			log = log_subject + "\n" + log_body + "\n" + emailResultForAttachments.getMessage() + "\n" + emailResultForAttachments_notPresent.getMessage();
			assertTrue(log, emailSubjectFlag && emailBodyFlag && emailResultForAttachments.isResult() && emailResultForAttachments_notPresent.isResult());

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, emailResultDetails);
		}
	}

}
