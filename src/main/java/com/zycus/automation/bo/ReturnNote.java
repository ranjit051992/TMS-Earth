/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author sameer.zilpilwar
 *
 */
public class ReturnNote
{
	private String			returnNoteNo;
	private String			returnNoteDescription;
	private String			returnNoteNotes;
	private String			returnNoteRMA;
	private String			returnNoteSupplierContact;
	private String			returnNoteSupplierEmail;
	private String			returnNoteComments;
	private boolean			notifySupplier	= true;
	private String			nextAction;
	private String			status;
	private StandardPO		standardPO;
	private PurchaseOrder	purchaseOrder;

	public String getReturnNoteNo()
	{
		return returnNoteNo;
	}

	public void setReturnNoteNo(String returnNoteNo)
	{
		this.returnNoteNo = returnNoteNo;
	}

	public String getReturnNoteDescription()
	{
		return returnNoteDescription;
	}

	public void setReturnNoteDescription(String returnNoteDescription)
	{
		this.returnNoteDescription = returnNoteDescription;
	}

	public String getReturnNoteNotes()
	{
		return returnNoteNotes;
	}

	public void setReturnNoteNotes(String returnNoteNotes)
	{
		this.returnNoteNotes = returnNoteNotes;
	}

	public String getReturnNoteRMA()
	{
		return returnNoteRMA;
	}

	public void setReturnNoteRMA(String returnNoteRMA)
	{
		this.returnNoteRMA = returnNoteRMA;
	}

	public String getReturnNoteSupplierContact()
	{
		return returnNoteSupplierContact;
	}

	public void setReturnNoteSupplierContact(String returnNoteSupplierContact)
	{
		this.returnNoteSupplierContact = returnNoteSupplierContact;
	}

	public String getReturnNoteSupplierEmail()
	{
		return returnNoteSupplierEmail;
	}

	public void setReturnNoteSupplierEmail(String returnNoteSupplierEmail)
	{
		this.returnNoteSupplierEmail = returnNoteSupplierEmail;
	}

	public String getReturnNoteComments()
	{
		return returnNoteComments;
	}

	public void setReturnNoteComments(String returnNoteComments)
	{
		this.returnNoteComments = returnNoteComments;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
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

	public PurchaseOrder getPurchaseOrder()
	{
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder)
	{
		this.purchaseOrder = purchaseOrder;
	}

	public boolean isNotifySupplier()
	{
		return notifySupplier;
	}

	public void setNotifySupplier(boolean notifySupplier)
	{
		this.notifySupplier = notifySupplier;
	}

}
