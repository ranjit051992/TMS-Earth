/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class ExistingSupplier
{
	private String	supplierName	= null;
	private String	supplierAddress	= null;
	private String	supplierContact	= null;
	private String	emailId			= null;
	private String	phone			= null;
	private String	contractNo		= null;
	private String	otherDetails	= null;
	private String	nextAction		= null;

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public String getSupplierAddress()
	{
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress)
	{
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierContact()
	{
		return supplierContact;
	}

	public void setSupplierContact(String supplierContact)
	{
		this.supplierContact = supplierContact;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getContractNo()
	{
		return contractNo;
	}

	public void setContractNo(String contractNo)
	{
		this.contractNo = contractNo;
	}

	public String getOtherDetails()
	{
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails)
	{
		this.otherDetails = otherDetails;
	}

}
