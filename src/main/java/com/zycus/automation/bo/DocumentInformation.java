/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class DocumentInformation
{
	public static final String	docType_Requisition			= "Requisition";
	public static final String	docType_PO					= "Purchase Order";
	public static final String	docType_STANDARD_PO			= "Standard PO";
	public static final String	docType_BPO					= "Blanket Purchase Order";
	public static final String	docType_Invoice				= "Invoice";

	private String				docType						= null;
	private String				docName						= null;
	private String				docNo						= null;
	private String				docStatus					= null;
	// delegator
	private String				requester					= null;
	// todate
	private String				createdOn					= null;
	private Requisition			requisition					= null;
	private StandardPO			standardPO					= null;
	private BPO					bpo							= null;
	private Invoice				invoice						= null;
	private PurchaseOrder		purchaseOrder				= null;
	private User				user						= null;
	private Item				item						= null;
	private String				commentForActionPerformed	= null;
	private MySettings			mySettingsForApproval		= null;

	public MySettings getMySettingsForApproval()
	{
		return mySettingsForApproval;
	}

	public void setMySettingsForApproval(MySettings mySettingsForApproval)
	{
		this.mySettingsForApproval = mySettingsForApproval;
	}

	public String getCommentForActionPerformed()
	{
		return commentForActionPerformed;
	}

	public void setCommentForActionPerformed(String commentForActionPerformed)
	{
		this.commentForActionPerformed = commentForActionPerformed;
	}

	public Item getItem()
	{
		return item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public PurchaseOrder getPurchaseOrder()
	{
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder)
	{
		this.purchaseOrder = purchaseOrder;
	}

	public String getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(String createdOn)
	{
		this.createdOn = createdOn;
	}

	public String getRequester()
	{
		return requester;
	}

	public void setRequester(String requester)
	{
		this.requester = requester;
	}

	public String getDocStatus()
	{
		return docStatus;
	}

	public void setDocStatus(String docStatus)
	{
		this.docStatus = docStatus;
	}

	public String getDocType()
	{
		return docType;
	}

	public void setDocType(String docType)
	{
		this.docType = docType;
	}

	public String getDocName()
	{
		return docName;
	}

	public void setDocName(String docName)
	{
		this.docName = docName;
	}

	public String getDocNo()
	{
		return docNo;
	}

	public void setDocNo(String docNo)
	{
		this.docNo = docNo;
	}

	public Requisition getRequisition()
	{
		return requisition;
	}

	public void setRequisition(Requisition requisition)
	{
		this.requisition = requisition;
	}

	public StandardPO getStandardPO()
	{
		return standardPO;
	}

	public void setStandardPO(StandardPO standardPO)
	{
		this.standardPO = standardPO;
	}

	public BPO getBpo()
	{
		return bpo;
	}

	public void setBpo(BPO bpo)
	{
		this.bpo = bpo;
	}

	public Invoice getInvoice()
	{
		return invoice;
	}

	public void setInvoice(Invoice invoice)
	{
		this.invoice = invoice;
	}

}
