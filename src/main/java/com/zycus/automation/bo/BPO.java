/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class BPO
{
	private String								supplierName;
	private String								supplierAddress;
	private String								paymentTerms;
	private String								currencyType;
	private Double								currencyValue;
	private String								deliveryTerms;
	private String								purchaseType;
	private int									contractNo;
	private String								orderDescription;
	private String								buyer;
	private String								requester;
	private String								poContact;
	private String								termsAndConditions;
	private String								notes;
	private Item								items;
	private String								poNumber;
	private BillingRequisitionSummary			billingRequisitionSummary;
	private DeliveryRequisitionSummary			deliveryRequisitionSummary;
	private CostBookingRequisitionSummary		costBookingRequisitionSummary;
	private CostBookingItemSummary				costBookingItemSummary;
	private AttachmentsAndCommentsItemSummary	attachmentsAndCommentsItemSummary;
	private String								nextAction;
	private String								attachmentFileName;
	private String								orderValue								= null;
	private boolean								isAutoUpdate							= true;
	private CustomDate							fromValidityDate						= null;
	private CustomDate							toValidityDate							= null;
	private CustomDate							untilValidityDate						= null;
	private boolean								preventOrderOfItemsOfOtherCategorie		= false;
	private boolean								preventChangingPartNoAndItemDescription	= false;
	private boolean								preventExceedingBlanketValues			= false;
	private boolean								requireReceipt							= false;
	private CustomDate							requiredByDate							= null;
	private String								releaseNo								= null;
	private BPOBuyingScope						bpoBuyingScope							= null;
	private String								totalPrice								= null;
	private String								orderType								= null;
	private boolean								removeAllTaxes							= false;

	public String getOrderType()
	{
		return orderType;
	}

	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}

	public String getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public BPOBuyingScope getBpoBuyingScope()
	{
		return bpoBuyingScope;
	}

	public void setBpoBuyingScope(BPOBuyingScope bpoBuyingScope)
	{
		this.bpoBuyingScope = bpoBuyingScope;
	}

	public String getReleaseNo()
	{
		return releaseNo;
	}

	public void setReleaseNo(String releaseNo)
	{
		this.releaseNo = releaseNo;
	}

	public CustomDate getRequiredByDate()
	{
		return requiredByDate;
	}

	public void setRequiredByDate(CustomDate requiredByDate)
	{
		this.requiredByDate = requiredByDate;
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

	public String getPaymentTerms()
	{
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms)
	{
		this.paymentTerms = paymentTerms;
	}

	public String getCurrencyType()
	{
		return currencyType;
	}

	public void setCurrencyType(String currencyType)
	{
		this.currencyType = currencyType;
	}

	public Double getCurrencyValue()
	{
		return currencyValue;
	}

	public void setCurrencyValue(Double currencyValue)
	{
		this.currencyValue = currencyValue;
	}

	public String getDeliveryTerms()
	{
		return deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms)
	{
		this.deliveryTerms = deliveryTerms;
	}

	public String getPurchaseType()
	{
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType)
	{
		this.purchaseType = purchaseType;
	}

	public int getContractNo()
	{
		return contractNo;
	}

	public void setContractNo(int contractNo)
	{
		this.contractNo = contractNo;
	}

	public String getOrderDescription()
	{
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription)
	{
		this.orderDescription = orderDescription;
	}

	public String getBuyer()
	{
		return buyer;
	}

	public void setBuyer(String buyer)
	{
		this.buyer = buyer;
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

	public Item getItems()
	{
		return items;
	}

	public void setItems(Item items)
	{
		this.items = items;
	}

	public String getPoNumber()
	{
		return poNumber;
	}

	public void setPoNumber(String poNumber)
	{
		this.poNumber = poNumber;
	}

	public BillingRequisitionSummary getBillingRequisitionSummary()
	{
		return billingRequisitionSummary;
	}

	public void setBillingRequisitionSummary(BillingRequisitionSummary billingRequisitionSummary)
	{
		this.billingRequisitionSummary = billingRequisitionSummary;
	}

	public DeliveryRequisitionSummary getDeliveryRequisitionSummary()
	{
		return deliveryRequisitionSummary;
	}

	public void setDeliveryRequisitionSummary(DeliveryRequisitionSummary deliveryRequisitionSummary)
	{
		this.deliveryRequisitionSummary = deliveryRequisitionSummary;
	}

	public CostBookingRequisitionSummary getCostBookingRequisitionSummary()
	{
		return costBookingRequisitionSummary;
	}

	public void setCostBookingRequisitionSummary(CostBookingRequisitionSummary costBookingRequisitionSummary)
	{
		this.costBookingRequisitionSummary = costBookingRequisitionSummary;
	}

	public CostBookingItemSummary getCostBookingItemSummary()
	{
		return costBookingItemSummary;
	}

	public void setCostBookingItemSummary(CostBookingItemSummary costBookingItemSummary)
	{
		this.costBookingItemSummary = costBookingItemSummary;
	}

	public AttachmentsAndCommentsItemSummary getAttachmentsAndCommentsItemSummary()
	{
		return attachmentsAndCommentsItemSummary;
	}

	public void setAttachmentsAndCommentsItemSummary(AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary)
	{
		this.attachmentsAndCommentsItemSummary = attachmentsAndCommentsItemSummary;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getAttachmentFileName()
	{
		return attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName)
	{
		this.attachmentFileName = attachmentFileName;
	}

	public String getOrderValue()
	{
		return orderValue;
	}

	public void setOrderValue(String orderValue)
	{
		this.orderValue = orderValue;
	}

	public boolean isAutoUpdate()
	{
		return isAutoUpdate;
	}

	public void setAutoUpdate(boolean isAutoUpdate)
	{
		this.isAutoUpdate = isAutoUpdate;
	}

	public CustomDate getFromValidityDate()
	{
		return fromValidityDate;
	}

	public void setFromValidityDate(CustomDate fromValidityDate)
	{
		this.fromValidityDate = fromValidityDate;
	}

	public CustomDate getToValidityDate()
	{
		return toValidityDate;
	}

	public void setToValidityDate(CustomDate toValidityDate)
	{
		this.toValidityDate = toValidityDate;
	}

	public CustomDate getUntilValidityDate()
	{
		return untilValidityDate;
	}

	public void setUntilValidityDate(CustomDate untilValidityDate)
	{
		this.untilValidityDate = untilValidityDate;
	}

	public boolean isPreventOrderOfItemsOfOtherCategorie()
	{
		return preventOrderOfItemsOfOtherCategorie;
	}

	public void setPreventOrderOfItemsOfOtherCategorie(boolean preventOrderOfItemsOfOtherCategorie)
	{
		this.preventOrderOfItemsOfOtherCategorie = preventOrderOfItemsOfOtherCategorie;
	}

	public boolean isPreventChangingPartNoAndItemDescription()
	{
		return preventChangingPartNoAndItemDescription;
	}

	public void setPreventChangingPartNoAndItemDescription(boolean preventChangingPartNoAndItemDescription)
	{
		this.preventChangingPartNoAndItemDescription = preventChangingPartNoAndItemDescription;
	}

	public boolean isPreventExceedingBlanketValues()
	{
		return preventExceedingBlanketValues;
	}

	public void setPreventExceedingBlanketValues(boolean preventExceedingBlanketValues)
	{
		this.preventExceedingBlanketValues = preventExceedingBlanketValues;
	}

	public boolean isRequireReceipt()
	{
		return requireReceipt;
	}

	public void setRequireReceipt(boolean requireReceipt)
	{
		this.requireReceipt = requireReceipt;
	}

	public boolean isRemoveAllTaxes()
	{
		return removeAllTaxes;
	}

	public void setRemoveAllTaxes(boolean removeAllTaxes)
	{
		this.removeAllTaxes = removeAllTaxes;
	}

}
