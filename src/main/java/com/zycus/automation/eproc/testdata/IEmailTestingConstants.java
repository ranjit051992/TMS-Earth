/**
 * 
 */
package com.zycus.automation.eproc.testdata;

import com.zycus.automation.eproc.reader.PropertyReader;

/**
 * @author ankita.sawant
 *
 */
public interface IEmailTestingConstants
{
	public String	EventType_Document_Submitted			= "Document_Submitted";
	public String	EventType_Document_Approval_Pending		= "Document_Approval_Pending";
	public String	EventType_Document_Recalled				= "Document_Recalled";
	public String	EventType_Document_Approved				= "Document_Approved";
	public String	EventType_Remind_Buyer					= "EventType_Remind_Buyer";
	public String	EventType_Assigned_Buyer_Changed		= "EventType_Assigned_Buyer_Changed";
	public String	EventType_Assigned_Buyer_Removed		= "EventType_Assigned_Buyer_Removed";
	public String	EventType_Requisition_Modified_By_Buyer	= "EventType_Requisition_Modified_By_Buyer";
	public String	EventType_Released_PO					= "EventType_Released_PO";
	public String	EventType_Released_Requisition			= "EventType_Released_Requisition";
	public String	EventType_Amended_Released_PO			= "EventType_Amended_Released_PO	";
	public String	EventType_Email_PO						= "EventType_Email_PO";
	public String	EventType_Remind_Receipt				= "EventType_Remind_Receipt";
	public String	EventType_Cancel_PO						= "EventType_Cancel_PO";
	public String	EventType_Sent_For_Quote				= "EventType_Sent_For_Quote";
	public String	EventType_Document_Rejected				= "EventType_Document_Rejected";
	public String	EventType_Returned_Req_From_Buyers_Desk	= "EventType_Returned_Req_From_Buyers_Desk";
	public String	EventType_Delegate_Assigned				= "EventType_Delegate_Assigned";
	public String	EventType_Delegate_Revoked				= "EventType_Delegate_Revoked";
	public String	EventType_Approval_Delegated			= "EventType_Approval_Delegated";
	public String	EventType_Parked						= "EventType_Parked";

	public String	Subject_Document_Submitted				= PropertyReader.emailProperty.getProperty("Subject_Document_Submitted");
	public String	Subject_Document_Awaiting_Approval		= PropertyReader.emailProperty.getProperty("Subject_Document_Awaiting_Approval");
	public String	Subject_Document_Recalled				= PropertyReader.emailProperty.getProperty("Subject_Document_Recalled");
	public String	Subject_Document_Approved				= PropertyReader.emailProperty.getProperty("Subject_Document_Approved");
	public String	Subject_On_Buyer_Desk					= PropertyReader.emailProperty.getProperty("Subject_On_Buyer_Desk");
	public String	Subject_Assigned_Buyer_Changed			= PropertyReader.emailProperty.getProperty("Subject_Assigned_Buyer_Changed");
	public String	Subject_Assigned_Buyer_Removed			= PropertyReader.emailProperty.getProperty("Subject_Assigned_Buyer_Removed");
	public String	Subject_Requisition_Modified_By_Buyer	= PropertyReader.emailProperty.getProperty("Subject_Requisition_Modified_By_Buyer");
	public String	Subject_Released_PO						= PropertyReader.emailProperty.getProperty("Subject_Released_PO");
	public String	Subject_Released_Requisition			= PropertyReader.emailProperty.getProperty("Subject_Released_Requisition");
	public String	Subject_Amended_Released_PO				= PropertyReader.emailProperty.getProperty("Subject_Amended_Released_PO");
	public String	Subject_Email_PO						= PropertyReader.emailProperty.getProperty("Subject_Email_PO");
	public String	Subject_Remind_Receipt					= PropertyReader.emailProperty.getProperty("Subject_Remind_Receipt");
	public String	Subject_Cancel_PO						= PropertyReader.emailProperty.getProperty("Subject_Cancel_PO");

	public String	Subject_Sent_For_Quote					= PropertyReader.emailProperty.getProperty("Subject_Sent_For_Quote");
	public String	Subject_Document_Rejected				= PropertyReader.emailProperty.getProperty("Subject_Document_Rejected");
	public String	Subject_Returned_Req_From_Buyers_Desk	= PropertyReader.emailProperty.getProperty("Subject_Returned_Req_From_Buyers_Desk");
	public String	Subject_Delegate_Assigned				= PropertyReader.emailProperty.getProperty("Subject_Delegate_Assigned");

	public String	Subject_Delegate_Revoked				= PropertyReader.emailProperty.getProperty("Subject_Delegate_Revoked");

	public String	Subject_Approval_Delegated				= PropertyReader.emailProperty.getProperty("Subject_Approval_Delegated");
	public String	Subject_Parked							= PropertyReader.emailProperty.getProperty("Subject_Parked");

	public String	Body_Document_Submitted					= PropertyReader.emailProperty.getProperty("Body_Document_Submitted");
	public String	Body_Document_Awaiting_Approval			= PropertyReader.emailProperty.getProperty("Body_Document_Awaiting_Approval");
	public String	Body_Document_Recalled					= PropertyReader.emailProperty.getProperty("Body_Document_Recalled");
	public String	Body_Document_Approved					= PropertyReader.emailProperty.getProperty("Body_Document_Approved");
	public String	Body_Document_Modified_By_Buyer			= PropertyReader.emailProperty.getProperty("Body_Document_Modified_By_Buyer");
	public String	Email_signature							= PropertyReader.emailProperty.getProperty("Email_Signature");
	public String	Body_Document_Delegated					= PropertyReader.emailProperty.getProperty("Body_Document_Delegated");
	public String	Body_All_Document_Delegated				= PropertyReader.emailProperty.getProperty("Body_All_Document_Delegated");
	public String	Body_All_Document_Delegation_Revoked	= PropertyReader.emailProperty.getProperty("Body_All_Document_Delegation_Revoked");
	public String	Body_Requisition_Submitted_For_Sourcing	= PropertyReader.emailProperty.getProperty("Body_Requisition_Submitted_For_Sourcing");
	public String	Body_Document_Rejected					= PropertyReader.emailProperty.getProperty("Body_Document_Rejected");
	public String	Body_Requisition_Returned				= PropertyReader.emailProperty.getProperty("Body_Requisition_Returned");
	public String	Body_PO_Approved						= PropertyReader.emailProperty.getProperty("Body_PO_Approved");
	public String	Body_On_Buyers_Desk						= PropertyReader.emailProperty.getProperty("Body_On_Buyers_Desk");
	public String	Body_For_Requisition					= PropertyReader.emailProperty.getProperty("Body_For_Requisition");
	public String	Body_For_PO								= PropertyReader.emailProperty.getProperty("Body_For_PO");
	public String	Body_For_PO_Released					= PropertyReader.emailProperty.getProperty("Body_For_PO_Released");
	public String	Body_For_PO_Item_Row_Template			= PropertyReader.emailProperty.getProperty("Body_For_PO_Item_Row_Template");
	public String	Body_For_Req_Item_Row_Template			= PropertyReader.emailProperty.getProperty("Body_For_Req_Item_Row_Template");
	public String	Body_Email_PO							= PropertyReader.emailProperty.getProperty("Body_Email_PO");

	public String	Subject_PO_Released						= PropertyReader.emailProperty.getProperty("Subject_PO_Released");
	public String	Subject_Buyers_Desk						= PropertyReader.emailProperty.getProperty("Subject_Buyers_Desk");

	public String	Subject_Request_Submitted				= "Subject_Document_Submitted";
	public String	Subject_Request_Awaiting_Approval		= "Subject_Document_Awaiting_Approval";
	public String	Subject_Request_Recalled				= "Subject_Document_Recalled";
	public String	Subject_Request_Approved				= "Subject_Document_Approved";
	public String	Subject_Request_Cancelled				= "Subject_Cancel_PO";
	public String	Subject_Request_Rejected				= "Subject_Document_Rejected";
	public String	Subject_Request_Returned				= "Subject_Returned_Req_From_Buyers_Desk";
	public String	Subject_Request_Delegated				= "Subject_Approval_Delegated";
	public String	Subject_Observer_Added					= "Subject_Observer_Added";
	public String	Subject_Approver_Replaced_Old			= "Subject_Approver_Replaced_Old";
	public String	Subject_Approver_Replaced_New			= "Subject_Approver_Replaced_New";
	public String	Subject_Approver_Added					= "Subject_Approver_Added";
	public String	Subject_Approver_Removed				= "Subject_Approver_Removed";

	public String	Body_Request_Submitted					= "Body_Document_Submitted";
	public String	Body_Request_Awaiting_Approval			= "Body_Document_Awaiting_Approval";
	public String	Body_Request_Recalled					= "Body_Document_Recalled";
	public String	Body_Request_Approved					= "Body_Document_Approved";
	public String	Body_Request_Cancelled					= "Body_Cancel_PO";
	public String	Body_Request_Rejected					= "Body_Document_Rejected";
	public String	Body_Request_Returned					= "Body_Requisition_Returned";
	public String	Body_Request_Delegated					= "Body_Document_Delegated";
	public String	Body_Observer_Added						= "Body_Observer_Added";
	public String	Body_Approver_Replaced_Old				= "Body_Approver_Replaced_Old";
	public String	Body_Approver_Replaced_New				= "Body_Approver_Replaced_New";
	public String	Body_Approver_Added						= "Body_Approver_Added";
	public String	Body_Approver_Removed					= "Body_Approver_Removed";

	public String	Req_Doc_Details_Template				= "Body_For_Requisition";
	public String	PO_Doc_Details_Template					= "Body_For_PO";
	public String	Buyers_Desk_Details_Template			= "Body_On_Buyers_Desk";
	public String	PO_Released_Details_Template			= "Body_For_PO_Released";
	public String	Subject_PO_Released_Template			= "Subject_Released_PO";
	public String	Subject_Buyers_Desk_Template			= "Subject_On_Buyer_Desk";
	public String	Req_Item_Row_Template					= "Body_For_Req_Item_Row_Template";
	public String	PO_Item_Row_Template					= "Body_For_PO_Item_Row_Template";

	public String	DOC_TYPE								= "%DOC_TYPE%";
	public String	DOC_NO									= "%DOC_NO%";
	public String	DOC_NAME								= "%DOC_NAME%";
	public String	REQUESTOR								= "%REQUESTOR%";
	public String	POSTED_ON								= "%POSTED_ON%";
	public String	BUYING_JUSTIFICATION					= "%BUYING_JUSTIFICATION%";
	public String	ITEMS									= "%ITEMS%";
	public String	DOC_TOTAL								= "%DOC_TOTAL%";
	public String	COMMENTS								= "%COMMENTS%";
	public String	DOC_DETAILS								= "%DOC_DETAILS%";
	public String	DOC_LINK								= "%DOC_LINK%";
	public String	INITIATOR								= "%INITIATOR%";
	public String	PO_NO_LIST								= "%PO_NO_LIST%";
	public String	SIGNATURE								= "%SIGNATURE%";
	public String	ITEM_NAME								= "%ITEM_NAME%";
	public String	UNIT_PRICE								= "%UNIT_PRICE%";
	public String	QTY										= "%QTY%";
	public String	UOM										= "%UOM%";
	public String	ACTOR									= "%ACTOR%";
	public String	NEW_BUYER								= "%NEW_BUYER%";
	public String	OLD_BUYER								= "%OLD_BUYER%";
	public String	PO_NO									= "%PO_NO%";
	public String	COMPANY_NAME							= "%COMPANY_NAME%";
	public String	RECALLED_ACTOR							= "%RECALLED_ACTOR%";
	public String	ACTOR_WHO_RETURNED						= "%ACTOR_WHO_RETURNED%";
	public String	DELEGATED_FROM							= "%DELEGATED_FROM%";
	public String	DESIGNATION								= "%DESIGNATION%";
	public String	DEPARTMENT								= "%DEPARTMENT%";
	public String	COMMENT_FOR_ACTION_PERFORMED			= "%COMMENT_FOR_ACTION_PERFORMED%";
	public String	ACTOR_DELEGATE							= "%ACTOR_DELEGATE%";
	public String	FROM_DATE								= "%FROM_DATE%";
	public String	TO_DATE									= "%TO_DATE%";

	public String	CREATED_BY								= "%CREATED_BY%";
	public String	DOC_AMOUNT								= "%DOC_AMOUNT%";
	public String	ITEM_TABLE								= "%ITEM_TABLE%";
	public String	DOC_VERSION								= "%DOC_VERSION%";
	public String	SUPPLIER_NAME							= "%SUPPLIER_NAME%";
	public String	APPROVER								= "%APPROVER%";
	public String	STATUS									= "%STATUS%";
	public String	CONTRACT_NO								= "%CONTRACT_NO%";
	public String	PO_TEMPLATE								= "%PO_TEMPLATE%";
	public String	ORDER_VALUE								= "%ORDER_VALUE%";
	public String	ACTOR_DESIGNATION						= "%ACTOR_DESIGNATION%";
	public String	ACTION_COMMENTS							= "%ACTION_COMMENTS%";
	public String	NEXT_ACTION								= "%NEXT_ACTION%";

	public String	ACTOR_WHO_RECALLED						= "%ACTOR_WHO_RECALLED%";
	public String	DELIVERY_DATE							= "%DELIVERY_DATE%";
	/*
	 * public String ORDER_VALUE = "%ORDER_VALUE%"; public String ORDER_VALUE =
	 * "%ORDER_VALUE%"; public String ORDER_VALUE = "%ORDER_VALUE%";
	 */

	public String	Next_Action_For_Req_Rejection			= "The Requisition has been rejected. It can be modified and resubmitted if required.";

}
