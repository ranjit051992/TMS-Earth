package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

public class StandardPO
{
	// Standard PO form
	String										supplierName;
	String										supplierAddress;
	String										paymentTerms;
	String										currencyType;
	Double										currencyValue;
	String										deliveryTerms;
	String										purchaseType;
	int											contractNo;
	String										orderDescription;
	String										buyer;
	String										requester;
	String										poContact;
	String										termsAndConditions;
	String										notes;
	String										poChange;
	Item										items;
	String										poNumber;
	private BillingRequisitionSummary			billingRequisitionSummary;
	private DeliveryRequisitionSummary			deliveryRequisitionSummary;
	private CostBookingRequisitionSummary		costBookingRequisitionSummary;
	private DeliveryItemSummary					deliveryItemSummary;
	private CostBookingItemSummary				costBookingItemSummary;
	private AccountingItemSummary				accountingItemSummary;
	private AttachmentsAndCommentsItemSummary	attachmentsAndCommentsItemSummary;
	private CustomDate							customDate;
	String										nextAction;
	private List<FileAttachment>				attachments				= new ArrayList<FileAttachment>();
	String										poTotal					= null;
	private boolean								removeAllTaxes			= false;
	private boolean								markForAddingApprovers	= false;
	private String								approver				= null;
	private boolean								editHeaderLevelInfo;

	public String getApprover()
	{
		return approver;
	}

	public void setApprover(String approver)
	{
		this.approver = approver;
	}

	public List<FileAttachment> getAttachments()
	{
		return attachments;
	}

	public void setAttachments(List<FileAttachment> attachments)
	{
		this.attachments = attachments;
	}

	public boolean isMarkForAddingApprovers()
	{
		return markForAddingApprovers;
	}

	public void setMarkForAddingApprovers(boolean markForAddingApprovers)
	{
		this.markForAddingApprovers = markForAddingApprovers;
	}

	public boolean isRemoveAllTaxes()
	{
		return removeAllTaxes;
	}

	public void setRemoveAllTaxes(boolean removeAllTaxes)
	{
		this.removeAllTaxes = removeAllTaxes;
	}

	public String getPoTotal()
	{
		return poTotal;
	}

	public void setPoTotal(String poTotal)
	{
		this.poTotal = poTotal;
	}

	public String getPoChange()
	{
		return poChange;
	}

	public void setPoChange(String poChange)
	{
		this.poChange = poChange;
	}

	public String getRequester()
	{
		return requester;
	}

	public void setRequester(String requester)
	{
		this.requester = requester;
	}

	public String getPoContact()
	{
		return poContact;
	}

	public void setPoContact(String poContact)
	{
		this.poContact = poContact;
	}

	public String getTermsAndConditions()
	{
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions)
	{
		this.termsAndConditions = termsAndConditions;
	}

	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public AccountingItemSummary getAccountingItemSummary()
	{
		return accountingItemSummary;
	}

	public AttachmentsAndCommentsItemSummary getAttachmentsAndCommentsItemSummary()
	{
		return attachmentsAndCommentsItemSummary;
	}

	public BillingRequisitionSummary getBillingRequisitionSummary()
	{
		return billingRequisitionSummary;
	}

	public String getBuyer()
	{
		return buyer;
	}

	public int getContractNo()
	{
		return contractNo;
	}

	public CostBookingItemSummary getCostBookingItemSummary()
	{
		return costBookingItemSummary;
	}

	public CostBookingRequisitionSummary getCostBookingRequisitionSummary()
	{
		return costBookingRequisitionSummary;
	}

	public String getCurrencyType()
	{
		return currencyType;
	}

	public Double getCurrencyValue()
	{
		return currencyValue;
	}

	public CustomDate getCustomDate()
	{
		return customDate;
	}

	public DeliveryItemSummary getDeliveryItemSummary()
	{
		return deliveryItemSummary;
	}

	public DeliveryRequisitionSummary getDeliveryRequisitionSummary()
	{
		return deliveryRequisitionSummary;
	}

	public String getDeliveryTerms()
	{
		return deliveryTerms;
	}

	public Item getItems()
	{
		return items;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public String getOrderDescription()
	{
		return orderDescription;
	}

	public String getPaymentTerms()
	{
		return paymentTerms;
	}

	public String getPoNumber()
	{
		return poNumber;
	}

	public String getPurchaseType()
	{
		return purchaseType;
	}

	public String getSupplierAddress()
	{
		return supplierAddress;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setAccountingItemSummary(AccountingItemSummary accountingItemSummary)
	{
		this.accountingItemSummary = accountingItemSummary;
	}

	public void setAttachmentsAndCommentsItemSummary(AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary)
	{
		this.attachmentsAndCommentsItemSummary = attachmentsAndCommentsItemSummary;
	}

	public void setBillingRequisitionSummary(BillingRequisitionSummary billingRequisitionSummary)
	{
		this.billingRequisitionSummary = billingRequisitionSummary;
	}

	public void setBuyer(String buyer)
	{
		this.buyer = buyer;
	}

	public void setContractNo(int contractNo)
	{
		this.contractNo = contractNo;
	}

	public void setCostBookingItemSummary(CostBookingItemSummary costBookingItemSummary)
	{
		this.costBookingItemSummary = costBookingItemSummary;
	}

	public void setCostBookingRequisitionSummary(CostBookingRequisitionSummary costBookingRequisitionSummary)
	{
		this.costBookingRequisitionSummary = costBookingRequisitionSummary;
	}

	public void setCurrencyType(String currencyType)
	{
		this.currencyType = currencyType;
	}

	public void setCurrencyValue(Double currencyValue)
	{
		this.currencyValue = currencyValue;
	}

	public void setCustomDate(CustomDate customDate)
	{
		this.customDate = customDate;
	}

	public void setDeliveryItemSummary(DeliveryItemSummary deliveryItemSummary)
	{
		this.deliveryItemSummary = deliveryItemSummary;
	}

	public void setDeliveryRequisitionSummary(DeliveryRequisitionSummary deliveryRequisitionSummary)
	{
		this.deliveryRequisitionSummary = deliveryRequisitionSummary;
	}

	public void setDeliveryTerms(String deliveryTerms)
	{
		this.deliveryTerms = deliveryTerms;
	}

	public void setItems(Item items)
	{
		this.items = items;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public void setOrderDescription(String orderDescription)
	{
		this.orderDescription = orderDescription;
	}

	public void setPaymentTerms(String paymentTerms)
	{
		this.paymentTerms = paymentTerms;
	}

	public void setPoNumber(String poNumber)
	{
		this.poNumber = poNumber;
	}

	public void setPurchaseType(String purchaseType)
	{
		this.purchaseType = purchaseType;
	}

	public void setSupplierAddress(String supplierAddress)
	{
		this.supplierAddress = supplierAddress;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	@Override
	public String toString()
	{
		return "StandardPO [supplierName=" + supplierName + ", supplierAddress=" + supplierAddress + ", paymentTerms=" + paymentTerms + ", currencyType=" + currencyType
			+ ", currencyValue=" + currencyValue + ", deliveryTerms=" + deliveryTerms + ", purchaseType=" + purchaseType + ", contractNo=" + contractNo + ", orderDescription="
			+ orderDescription + ", buyer=" + buyer + ", requester=" + requester + ", poContact=" + poContact + ", termsAndConditions=" + termsAndConditions + ", notes=" + notes
			+ ", poChange=" + poChange + ", items=" + items + ", poNumber=" + poNumber + ", billingRequisitionSummary=" + billingRequisitionSummary
			+ ", deliveryRequisitionSummary=" + deliveryRequisitionSummary + ", costBookingRequisitionSummary=" + costBookingRequisitionSummary + ", deliveryItemSummary="
			+ deliveryItemSummary + ", costBookingItemSummary=" + costBookingItemSummary + ", accountingItemSummary=" + accountingItemSummary
			+ ", attachmentsAndCommentsItemSummary=" + attachmentsAndCommentsItemSummary + ", customDate=" + customDate + ", nextAction=" + nextAction + "]";
	}

	public boolean isEditHeaderLevelInfo()
	{
		return editHeaderLevelInfo;
	}

	public void setEditHeaderLevelInfo(boolean editHeaderLevelInfo)
	{
		this.editHeaderLevelInfo = editHeaderLevelInfo;
	}
}
