/**
 * 
 */
package com.zycus.automation.eproc.businessflow.readyforapporvalflow;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.AddApprover;
import com.zycus.automation.bo.AuditTrail;
import com.zycus.automation.eproc.pageobjects.modals.addapprover.ModalAddApprover;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowReadyForApproval
{
	static Logger logger = Logger.getLogger(FlowReadyForApproval.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add approver in ready for approval
	 * requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param addApprover </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static AddApprover addApproverInReadyForApprovalRequisition(WebDriver driver, String testCaseName, AddApprover addApprover) throws Exception
	{
		boolean flag = false;

		ActionBot.scroll(driver, "400");
		PageRequisitionView.clickOnAddApproverButton(driver, testCaseName);

		addApprover.setApproverName(ModalAddApprover.fillApproverName(driver, testCaseName, addApprover.getApproverName()));

		// add approver node after
		if (addApprover.getAddApproverAfter().equalsIgnoreCase(IConstantsData.Requester))
		{
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 1);
		}
		else if (addApprover.getAddApproverAfter().equalsIgnoreCase(IConstantsData.Approver))
		{
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, 2);
		}
		else
		{
			logger.info("Invalid add approver node after option");
		}

		// verify added approver node
		String addedApproverName = ModalAddApprover.getAddedApproverName(driver, testCaseName);
		flag = addApprover.getApproverName().contains(addedApproverName);
		assertTrue("Added approver name to workflow on add aprrover modal box was wrong", flag);

		String approverInfo = ModalAddApprover.getAddedApproverExtraInfo(driver, testCaseName);
		flag = approverInfo.equalsIgnoreCase("Ad-hoc Approver");
		assertTrue("Added approver information to workflow on add aprrover modal box was wrong", flag);
		addApprover.setResult(flag);

		if (addApprover.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
		}
		else if (addApprover.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalAddApprover.clickOnCancelAddApprover(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid next action");
		}
		return addApprover;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To verify added approver <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param addApprover </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean verifyAddedApprover(WebDriver driver, String testCaseName, AddApprover addApprover) throws ActionBotException
	{
		boolean flag1 = false, flag2 = false;
		String addedApproverName, approverInfo, log = "";

		// verify approver name
		addedApproverName = PageRequisitionView.getAddedApproverNameFromWorkflow(driver, testCaseName);
		flag1 = addApprover.getApproverName().contains(addedApproverName);
		if (!flag1)
		{
			log += "\n Added approver name displayed on req view page was wrong";
		}

		// verify approver info
		approverInfo = PageRequisitionView.getAddedApproverExtraInfoFromWorkflow(driver, testCaseName);
		flag2 = approverInfo.equalsIgnoreCase("Ad-hoc Approver");
		if (!flag2)
		{
			log += "\n Added approver information displayed on req view page was wrong";
		}

		logger.info(log);
		return flag1 && flag2;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get audit trail information <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param rowNo </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static AuditTrail getAuditTrailInformation(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		AuditTrail auditTrail = new AuditTrail();

		logger.info("====================== Audit Trail Information : ======================");
		auditTrail.setAction(PageRequisitionView.getAuditTrailAction(driver, testCaseName, rowNo));
		auditTrail.setUser(PageRequisitionView.getAuditTrailActor(driver, testCaseName, rowNo));
		auditTrail.setSharedWith(PageRequisitionView.getAuditTrailSharedWith(driver, testCaseName, rowNo));
		auditTrail.setRole(PageRequisitionView.getAuditTrailRole(driver, testCaseName, rowNo));
		auditTrail.setDateTime(PageRequisitionView.getAuditTrailDateTime(driver, testCaseName, rowNo));
		auditTrail.setVersion(PageRequisitionView.getAuditTrailVersion(driver, testCaseName, rowNo));
		auditTrail.setMessage(PageRequisitionView.getAuditTrailMessage(driver, testCaseName, rowNo));
		logger.info("=======================================================================");

		return auditTrail;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To remove first added approver <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean removeFirstAddedApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String firstApproverName_beforeRemoval, firstApproverName_afterRemoval;
		boolean flag = false;

		firstApproverName_beforeRemoval = PageRequisitionView.getAddedApproverNameFromWorkflow(driver, testCaseName);
		// remove first added approver
		PageRequisitionView.clickOnRemoveFirstAddedApprover(driver, testCaseName);
		firstApproverName_afterRemoval = PageRequisitionView.getAddedApproverNameFromWorkflow(driver, testCaseName);

		// verify removal of approver
		flag = !firstApproverName_beforeRemoval.equalsIgnoreCase(firstApproverName_afterRemoval);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Verify audit trail information <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param auditTrail </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean verifyAuditTrailInformation(WebDriver driver, String testCaseName, AuditTrail auditTrail, String userDisplayName, String eventName, String approverName)
		throws ActionBotException
	{
		boolean flag = true;
		String log = "";

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String todaysDate = dateFormat.format(date);
		logger.info("Todays Date : " + todaysDate);

		// check events
		// initial event
		if (eventName.equalsIgnoreCase(IConstantsData.Requisition_Ready_For_Approval))
		{
			if (!auditTrail.getAction().equalsIgnoreCase(IConstantsData.AUDIT_TRAIL_ACTION_READY_FOR_APPROVAL.trim()))
			{
				log += "\n Action in audit trail was wrong, it should be " + IConstantsData.AUDIT_TRAIL_ACTION_READY_FOR_APPROVAL;
				flag = false;
			}
			if (!auditTrail.getMessage().equalsIgnoreCase(IConstantsData.AUDIT_TRAIL_ACTION_MESSAGE.trim()))
			{
				log += "\n Message in audit trail was wrong, it should be " + IConstantsData.AUDIT_TRAIL_ACTION_MESSAGE;
				flag = false;
			}
		}
		// add event
		if (eventName.equalsIgnoreCase(IConstantsData.Added_Approver_In_Ready_For_Approval_Requisition))
		{
			if (!auditTrail.getAction().equalsIgnoreCase(IConstantsData.AUDIT_TRAIL_ACTION_MODIFIED_WORKFLOW.trim()))
			{
				log += "\n Action in audit trail was wrong, it should be Modified workflow";
				flag = false;
			}
			if (!auditTrail.getMessage().equalsIgnoreCase("Added " + approverName))
			{
				log += "\n Message in audit trail was wrong, it should be Added " + approverName;
				flag = false;
			}
		}
		// remove event
		if (eventName.equalsIgnoreCase(IConstantsData.Removed_Approver_From_Ready_For_Approval_Requisition))
		{
			if (!auditTrail.getAction().equalsIgnoreCase(IConstantsData.AUDIT_TRAIL_ACTION_MODIFIED_WORKFLOW.trim()))
			{
				log += "\n Action in audit trail was wrong, it should be Modified workflow";
				flag = false;
			}
			if (!auditTrail.getMessage().equalsIgnoreCase("Removed " + approverName))
			{
				log += "\n Message in audit trail was wrong, it should be Removed " + approverName;
				flag = false;
			}
		}

		if (!auditTrail.getUser().equalsIgnoreCase(userDisplayName))
		{
			log += "\n User in audit trail was wrong, it should be " + userDisplayName;
			flag = false;
		}
		if (!auditTrail.getSharedWith().equalsIgnoreCase("-"))
		{
			log += "\n Shared with in audit trail was wrong, it should be -";
			flag = false;
		}
		if (!auditTrail.getRole().equalsIgnoreCase(IConstantsData.AUDIT_TRAIL_ACTION_ROLE.trim()))
		{
			log += "\n Role in audit trail was wrong, it should be " + IConstantsData.AUDIT_TRAIL_ACTION_ROLE;
			flag = false;
		}
		if (!auditTrail.getDateTime().contains(todaysDate))
		{
			log += "\n Date/Time in audit trail was wrong, it should be " + todaysDate;
			flag = false;
		}
		if (!auditTrail.getVersion().equalsIgnoreCase("v1"))
		{
			log += "\n Version in audit trail was wrong, it should be v1";
			flag = false;
		}

		logger.info(log);
		return flag;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add assign buyer <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param buyerName </font><b><br>
	 * @param buyerGroup </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static void addAssignBuyer(WebDriver driver, String testCaseName, String buyerName, String buyerGroup) throws Exception
	{
		ActionBot.scroll(driver);
		PageRequisitionView.clickOnAssignBuyerlink(driver, testCaseName);
		if (buyerName != null)
		{
			PageRequisitionView.fillAssignBuyerField(driver, testCaseName, buyerName);
		}
		else if (buyerGroup != null)
		{
			PageRequisitionView.clickOnAssignGroupOfBuyer(driver, testCaseName);
			PageRequisitionView.fillAssignedBuyerGroupName(driver, testCaseName, buyerGroup);
		}
		else
		{
			logger.info("Invalid input");
		}
		PageRequisitionView.clickOnSaveAssignBuyer(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add approver in ready for approval
	 * requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param addApprover </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static AddApprover addApproverInReadyForApprovalPO(WebDriver driver, String testCaseName, AddApprover addApprover) throws Exception
	{
		boolean flag = false;
		int index = 0;

		ActionBot.scroll(driver, "400");
		PageViewPurchaseOrder.clickOnAddApprover(driver, testCaseName);

		addApprover.setApproverName(ModalAddApprover.fillApproverName(driver, testCaseName, addApprover.getApproverName()));

		// add approver node after
		if (addApprover.getAddApproverAfter().equalsIgnoreCase(IConstantsData.Add_Approver_After_PO_Creator))
		{
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, IConstantsData.Add_Approver_After_PO_Creator);
			index = 2;
		}
		else if (addApprover.getAddApproverAfter().equalsIgnoreCase(IConstantsData.Add_Approver_After_Reporting_Manager))
		{
			ModalAddApprover.selectRequireApprovalAfter(driver, testCaseName, IConstantsData.Add_Approver_After_Reporting_Manager);
			index = 4;
		}
		else
		{
			logger.info("Invalid add approver node after option");
		}

		// verify added approver node
		String addedApproverName = ModalAddApprover.getAddedApproverName(driver, testCaseName, index);
		flag = addApprover.getApproverName().contains(addedApproverName);
		assertTrue("Added approver name to workflow on add aprrover modal box was wrong", flag);

		String approverInfo = ModalAddApprover.getAddedApproverExtraInfo(driver, testCaseName, index);
		flag = approverInfo.equalsIgnoreCase("Ad-hoc Approver");
		assertTrue("Added approver information to workflow on add aprrover modal box was wrong", flag);
		addApprover.setResult(flag);

		if (addApprover.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
		}
		else if (addApprover.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalAddApprover.clickOnCancelAddApprover(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid next action");
		}
		return addApprover;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To verify added approver for PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param addApprover </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean verifyAddedApproverForPO(WebDriver driver, String testCaseName, AddApprover addApprover, int index) throws ActionBotException, FactoryMethodException
	{
		boolean flag1 = false, flag2 = false;
		String addedApproverName, approverInfo, log = "";

		// verify approver name
		addedApproverName = PageViewPurchaseOrder.getWorkflowNodeDisplayName(driver, testCaseName, index);
		flag1 = addApprover.getApproverName().contains(addedApproverName);
		if (!flag1)
		{
			log += "\n Added approver name displayed on req view page was wrong";
		}

		// verify approver info
		approverInfo = PageViewPurchaseOrder.getWorkflowNodeExtraInfo(driver, testCaseName, index);
		flag2 = approverInfo.equalsIgnoreCase("Ad-hoc Approver");
		if (!flag2)
		{
			log += "\n Added approver information displayed on req view page was wrong";
		}

		logger.info(log);
		return flag1 && flag2;
	}

}
