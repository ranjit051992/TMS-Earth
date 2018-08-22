/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class Invoice
{
	private String		invoiceNo;
	private CustomDate	invoiceDueDate;
	private CustomDate	invoiceDate;
	private String		buyer;
	private String		purchaseType;
	private StandardPO	standardPO;
	private String		nextAction;
	private boolean		result;
	private String		approver	= null;
	private boolean		addAttachment;
	private String		fileName;

	public String getApprover()
	{
		return approver;
	}

	public void setApprover(String approver)
	{
		this.approver = approver;
	}

	public String getInvoiceNo()
	{
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo)
	{
		this.invoiceNo = invoiceNo;
	}

	public CustomDate getInvoiceDueDate()
	{
		return invoiceDueDate;
	}

	public void setInvoiceDueDate(CustomDate invoiceDueDate)
	{
		this.invoiceDueDate = invoiceDueDate;
	}

	public CustomDate getInvoiceDate()
	{
		return invoiceDate;
	}

	public void setInvoiceDate(CustomDate invoiceDate)
	{
		this.invoiceDate = invoiceDate;
	}

	public String getBuyer()
	{
		return buyer;
	}

	public void setBuyer(String buyer)
	{
		this.buyer = buyer;
	}

	public String getPurchaseType()
	{
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType)
	{
		this.purchaseType = purchaseType;
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

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public boolean isAddAttachment()
	{
		return addAttachment;
	}

	public void setAddAttachment(boolean addAttachment)
	{
		this.addAttachment = addAttachment;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

}
