/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class Receipt
{
	private String			receiptNo;
	private CustomDate		receiptDate;
	private String			receiptComment;
	private String			nextAction;
	private StandardPO		standardPO;
	private String			status;
	private PurchaseOrder	purchaseOrder;

	public PurchaseOrder getPurchaseOrder()
	{
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder)
	{
		this.purchaseOrder = purchaseOrder;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public StandardPO getStandardPO()
	{
		return standardPO;
	}

	public void setStandardPO(StandardPO standardPO)
	{
		this.standardPO = standardPO;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getReceiptNo()
	{
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo)
	{
		this.receiptNo = receiptNo;
	}

	public CustomDate getReceiptDate()
	{
		return receiptDate;
	}

	public void setReceiptDate(CustomDate receiptDate)
	{
		this.receiptDate = receiptDate;
	}

	public String getReceiptComment()
	{
		return receiptComment;
	}

	public void setReceiptComment(String receiptComment)
	{
		this.receiptComment = receiptComment;
	}

}
