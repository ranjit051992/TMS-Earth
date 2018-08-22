/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class BudgetAudit
{
	private String	date						= null;
	private String	docName						= null;
	private String	docType						= null;
	private String	event						= null;
	private String	user						= null;
	private String	reqReserved					= null;
	private String	poReserved					= null;
	private String	invoiceReserved				= null;
	private String	utilizedAmount				= null;
	private String	netAmount					= null;
	private String	balanceAmount				= null;
	private String	balanaceAmountWithTolerance	= null;

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getDocName()
	{
		return docName;
	}

	public void setDocName(String docName)
	{
		this.docName = docName;
	}

	public String getDocType()
	{
		return docType;
	}

	public void setDocType(String docType)
	{
		this.docType = docType;
	}

	public String getEvent()
	{
		return event;
	}

	public void setEvent(String event)
	{
		this.event = event;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getReqReserved()
	{
		return reqReserved;
	}

	public void setReqReserved(String reqReserved)
	{
		this.reqReserved = reqReserved;
	}

	public String getPoReserved()
	{
		return poReserved;
	}

	public void setPoReserved(String poReserved)
	{
		this.poReserved = poReserved;
	}

	public String getInvoiceReserved()
	{
		return invoiceReserved;
	}

	public void setInvoiceReserved(String invoiceReserved)
	{
		this.invoiceReserved = invoiceReserved;
	}

	public String getUtilizedAmount()
	{
		return utilizedAmount;
	}

	public void setUtilizedAmount(String utilizedAmount)
	{
		this.utilizedAmount = utilizedAmount;
	}

	public String getNetAmount()
	{
		return netAmount;
	}

	public void setNetAmount(String netAmount)
	{
		this.netAmount = netAmount;
	}

	public String getBalanceAmount()
	{
		return balanceAmount;
	}

	public void setBalanceAmount(String balanceAmount)
	{
		this.balanceAmount = balanceAmount;
	}

	public String getBalanaceAmountWithTolerance()
	{
		return balanaceAmountWithTolerance;
	}

	public void setBalanaceAmountWithTolerance(String balanaceAmountWithTolerance)
	{
		this.balanaceAmountWithTolerance = balanaceAmountWithTolerance;
	}

}
