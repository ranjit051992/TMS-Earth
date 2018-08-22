package com.zycus.automation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author himanshu.singh
 *
 */
@Entity
@Table(name = "GuidedItemSuggestSupplier")
public class GuidedItemSuggestSupplier
{
	@Id
	@GeneratedValue
	private int		id;
	// private int itemId;
	private String	suggestNewSupplierName;
	private String	existingSupplierName;
	private String	supplierAddress;
	private String	supplierContact;
	private String	emailId;
	private int		phone;
	private String	otherDetails;
	private String	contractNo;
	private String	nextAction;
	private boolean	result;
	private boolean	verifyAddedSupplier	= true;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	/*
	 * public int getItemId() { return itemId; }
	 * 
	 * public void setItemId(int itemId) { this.itemId = itemId; }
	 */

	public boolean isVerifyAddedSupplier()
	{
		return verifyAddedSupplier;
	}

	public void setVerifyAddedSupplier(boolean verifyAddedSupplier)
	{
		this.verifyAddedSupplier = verifyAddedSupplier;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getSuggestNewSupplierName()
	{
		return suggestNewSupplierName;
	}

	public void setSuggestNewSupplierName(String suggestNewSupplierName)
	{
		this.suggestNewSupplierName = suggestNewSupplierName;
	}

	public String getExistingSupplierName()
	{
		return existingSupplierName;
	}

	public void setExistingSupplierName(String existingSupplierName)
	{
		this.existingSupplierName = existingSupplierName;
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

	public int getPhone()
	{
		return phone;
	}

	public void setPhone(int phone)
	{
		this.phone = phone;
	}

	public String getOtherDetails()
	{
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails)
	{
		this.otherDetails = otherDetails;
	}

	public String getContractNo()
	{
		return contractNo;
	}

	public void setContractNo(String contractNo)
	{
		this.contractNo = contractNo;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

}
