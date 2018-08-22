package com.zycus.automation.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author himanshu.singh
 *
 */
@Entity
@Table(name = "Guided_Item")
public class GuidedItem
{
	@Id
	@GeneratedValue
	private int										guidedItem_id;

	private String									itemID;
	private String									itemName;
	private String									shortDescription;
	private String									longDescription;
	private String									partNumber;
	private Float									quantity;
	private float									price;
	private String									uom;
	private String									itemType;
	private String									sourcingStatus;
	private String									receiveBy;
	private String									currency;
	private String									supplierNameInSuppInfo;
	private String									addressInSuppInfo;
	private String									contractNoInSuppInfo;
	private String									activity;
	@OneToOne(cascade = CascadeType.ALL)
	private ModalGuidedItemSelectCategory			category;

	@OneToOne(cascade = CascadeType.ALL)
	private ModalGuidedItemSelectSupplierContract	suppliercontract;

	private String									supplierName;
	@OneToOne(cascade = CascadeType.ALL)
	private GuidedItemSuggestSupplier				guidedItemSuggestSupplier;

	private String									nextAction;
	private int										line_No;
	private String									supplierType;
	private String									isGreen;
	private String									isPreferred;
	private String									specification;
	private String									contractNo;
	private String									BPONo;
	@OneToOne(cascade = CascadeType.ALL)
	private DeliveryItemSummary						deliveryItemSummary;

	@OneToOne(cascade = CascadeType.ALL)
	private CostBookingItemSummary					costBookingItemSummary;

	@OneToOne(cascade = CascadeType.ALL)
	private AccountingItemSummary					accountingItemSummary;

	@OneToOne(cascade = CascadeType.ALL)
	private AttachmentsAndCommentsItemSummary		attachmentsAndCommentsItemSummary;
	private boolean									zeroPriceItem;
	private boolean									editCategory							= false;
	private float									maxTotalPrice;
	private float									maxUnitPrice;
	private int										flowId;
	private int										eventId;

	//variables for requirementDetails form SA Water
	private boolean									isRequirementDetails					= false;
	private String									requisitionAppliesTo_RequirementDetail	= null;
	private String									response_RequirementDetail				= null;
	private String									poSentToSupplier_RequirementDetail		= null;
	private String									quoteObtained_RequirementDetail			= null;
	//add the rest of the non-mandatory fields yourself according to your needs.

	public int getEventId()
	{
		return eventId;
	}

	public void setEventId(int eventId)
	{
		this.eventId = eventId;
	}

	public int getFlowId()
	{
		return flowId;
	}

	public void setFlowId(int flowId)
	{
		this.flowId = flowId;
	}

	public float getMaxTotalPrice()
	{
		return maxTotalPrice;
	}

	public void setMaxTotalPrice(float maxTotalPrice)
	{
		this.maxTotalPrice = maxTotalPrice;
	}

	public float getMaxUnitPrice()
	{
		return maxUnitPrice;
	}

	public void setMaxUnitPrice(float maxUnitPrice)
	{
		this.maxUnitPrice = maxUnitPrice;
	}

	public boolean isEditCategory()
	{
		return editCategory;
	}

	public void setEditCategory(boolean editCategory)
	{
		this.editCategory = editCategory;
	}

	public DeliveryItemSummary getDeliveryItemSummary()
	{
		return deliveryItemSummary;
	}

	public void setDeliveryItemSummary(DeliveryItemSummary deliveryItemSummary)
	{
		this.deliveryItemSummary = deliveryItemSummary;
	}

	public CostBookingItemSummary getCostBookingItemSummary()
	{
		return costBookingItemSummary;
	}

	public void setCostBookingItemSummary(CostBookingItemSummary costBookingItemSummary)
	{
		this.costBookingItemSummary = costBookingItemSummary;
	}

	public AccountingItemSummary getAccountingItemSummary()
	{
		return accountingItemSummary;
	}

	public void setAccountingItemSummary(AccountingItemSummary accountingItemSummary)
	{
		this.accountingItemSummary = accountingItemSummary;
	}

	public AttachmentsAndCommentsItemSummary getAttachmentsAndCommentsItemSummary()
	{
		return attachmentsAndCommentsItemSummary;
	}

	public void setAttachmentsAndCommentsItemSummary(AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary)
	{
		this.attachmentsAndCommentsItemSummary = attachmentsAndCommentsItemSummary;
	}

	public String getContractNo()
	{
		return contractNo;
	}

	public void setContractNo(String contractNo)
	{
		this.contractNo = contractNo;
	}

	public String getBPONo()
	{
		return BPONo;
	}

	public void setBPONo(String bPONo)
	{
		BPONo = bPONo;
	}

	public String getIsGreen()
	{
		return isGreen;
	}

	public void setIsGreen(String isGreen)
	{
		this.isGreen = isGreen;
	}

	public String getIsPreferred()
	{
		return isPreferred;
	}

	public void setIsPreferred(String isPreferred)
	{
		this.isPreferred = isPreferred;
	}

	public String getSpecification()
	{
		return specification;
	}

	public void setSpecification(String specification)
	{
		this.specification = specification;
	}

	public String getSupplierType()
	{
		return supplierType;
	}

	public void setSupplierType(String supplierType)
	{
		this.supplierType = supplierType;
	}

	public int getLineNo()
	{
		return line_No;
	}

	public void setLineNo(int lineNo)
	{
		this.line_No = lineNo;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getItemID()
	{
		return itemID;
	}

	public void setItemID(String itemID)
	{
		this.itemID = itemID;
	}

	public String getSupplierNameInSuppInfo()
	{
		return supplierNameInSuppInfo;
	}

	public void setSupplierNameInSuppInfo(String supplierNameInSuppInfo)
	{
		this.supplierNameInSuppInfo = supplierNameInSuppInfo;
	}

	public String getAddressInSuppInfo()
	{
		return addressInSuppInfo;
	}

	public void setAddressInSuppInfo(String addressInSuppInfo)
	{
		this.addressInSuppInfo = addressInSuppInfo;
	}

	public String getContractNoInSuppInfo()
	{
		return contractNoInSuppInfo;
	}

	public void setContractNoInSuppInfo(String contractNoInSuppInfo)
	{
		this.contractNoInSuppInfo = contractNoInSuppInfo;
	}

	public GuidedItemSuggestSupplier getGuidedItemSuggestSupplier()
	{
		return guidedItemSuggestSupplier;
	}

	public void setGuidedItemSuggestSupplier(GuidedItemSuggestSupplier guidedItemSuggestSupplier)
	{
		this.guidedItemSuggestSupplier = guidedItemSuggestSupplier;
	}

	public String getShortDescription()
	{
		return shortDescription;
	}

	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}

	public String getLongDescription()
	{
		return longDescription;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public void setLongDescription(String longDescription)
	{
		this.longDescription = longDescription;
	}

	public String getPartNumber()
	{
		return partNumber;
	}

	public void setPartNumber(String partNumber)
	{
		this.partNumber = partNumber;
	}

	public Float getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Float quantity)
	{
		this.quantity = quantity;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public String getUom()
	{
		return uom;
	}

	public void setUom(String uom)
	{
		this.uom = uom;
	}

	public String getItemType()
	{
		return itemType;
	}

	public void setItemType(String itemType)
	{
		this.itemType = itemType;
	}

	public String getSourcingStatus()
	{
		return sourcingStatus;
	}

	public void setSourcingStatus(String sourcingStatus)
	{
		this.sourcingStatus = sourcingStatus;
	}

	public String getReceiveBy()
	{
		return receiveBy;
	}

	public void setReceiveBy(String receiveBy)
	{
		this.receiveBy = receiveBy;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public String getActivity()
	{
		return activity;
	}

	public void setActivity(String activity)
	{
		this.activity = activity;
	}

	public ModalGuidedItemSelectCategory getCategory()
	{
		return category;
	}

	public ModalGuidedItemSelectSupplierContract getSuppliercontract()
	{
		return suppliercontract;
	}

	public void setSuppliercontract(ModalGuidedItemSelectSupplierContract suppliercontract)
	{
		this.suppliercontract = suppliercontract;
	}

	public void setCategory(ModalGuidedItemSelectCategory category)
	{
		this.category = category;
	}

	public final String getItemName()
	{
		return itemName;
	}

	public final void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public boolean isZeroPriceItem()
	{
		return zeroPriceItem;
	}

	public void setZeroPriceItem(boolean zeroPriceItem)
	{
		this.zeroPriceItem = zeroPriceItem;
	}

	public String getRequisitionAppliesTo_RequirementDetail()
	{
		return requisitionAppliesTo_RequirementDetail;
	}

	public void setRequisitionAppliesTo_RequirementDetail(String requisitionAppliesTo_RequirementDetail)
	{
		this.requisitionAppliesTo_RequirementDetail = requisitionAppliesTo_RequirementDetail;
	}

	public String getResponse_RequirementDetail()
	{
		return response_RequirementDetail;
	}

	public void setResponse_RequirementDetail(String response_RequirementDetail)
	{
		this.response_RequirementDetail = response_RequirementDetail;
	}

	public String getPoSentToSupplier_RequirementDetail()
	{
		return poSentToSupplier_RequirementDetail;
	}

	public void setPoSentToSupplier_RequirementDetail(String poSentToSupplier_RequirementDetail)
	{
		this.poSentToSupplier_RequirementDetail = poSentToSupplier_RequirementDetail;
	}

	public String getQuoteObtained_RequirementDetail()
	{
		return quoteObtained_RequirementDetail;
	}

	public void setQuoteObtained_RequirementDetail(String quoteObtained_RequirementDetail)
	{
		this.quoteObtained_RequirementDetail = quoteObtained_RequirementDetail;
	}

	public boolean isRequirementDetails()
	{
		return isRequirementDetails;
	}

	public void setRequirementDetails(boolean isRequirementDetails)
	{
		this.isRequirementDetails = isRequirementDetails;
	}

	@Override
	public String toString()
	{
		return "GuidedItem [itemID=" + itemID + ", itemName=" + itemName + ", shortDescription=" + shortDescription + ", longDescription=" + longDescription + ", partNumber="
			+ partNumber + ", quantity=" + quantity + ", price=" + price + ", uom=" + uom + ", itemType=" + itemType + ", sourcingStatus=" + sourcingStatus + ", receiveBy="
			+ receiveBy + ", currency=" + currency + ", supplierNameInSuppInfo=" + supplierNameInSuppInfo + ", addressInSuppInfo=" + addressInSuppInfo + ", contractNoInSuppInfo="
			+ contractNoInSuppInfo + ", activity=" + activity + ", category=" + category + ", modalGuidedItemSuggestSupplier=" + guidedItemSuggestSupplier + ", nextAction="
			+ nextAction + ", lineNo=" + line_No + ", supplierType=" + supplierType + ", isGreen=" + isGreen + ", isPreferred=" + isPreferred + ", specification=" + specification
			+ "]";
	}

}
