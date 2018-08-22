package com.zycus.automation.bo;

public class PurchaseOrder
{

	private String						poNo;
	private String						supplierName;
	private String						BUName;
	private String						DeliveryDate;
	private String						BaseCurrency;
	private String						Status;
	private String						ReqNo;
	private String						ItemName;
	private String						itemNo;
	private String						DeliveryTo;
	private String						UnitPrice;
	private String						Qty;
	private String						TotalPrice;
	private String						PoTotal;

	private CustomDate					customDate;
	private Item						item;
	private boolean						result;
	private StandardPO					standardPO;
	private String						searchType;
	private Requisition					requisition;
	private String						poName;
	private String						comment;
	private CustomDate					createdOn;
	private String						approver;
	private BillingRequisitionSummary	billingRequisitionSummary;

	//SA Water further Details
	private String						recommendationMemoProvided;
	private String						quote;
	private String						cmsRegistered;
	private String						proccurementInvolvement;
	private String						poMedium;
	private String						panelApply;
	private String						isPOValue;

	public String getApprover()
	{
		return approver;
	}

	public void setApprover(String approver)
	{
		this.approver = approver;
	}

	public CustomDate getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(CustomDate createdOn)
	{
		this.createdOn = createdOn;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getPoName()
	{
		return poName;
	}

	public void setPoName(String poName)
	{
		this.poName = poName;
	}

	public Requisition getRequisition()
	{
		return requisition;
	}

	public void setRequisition(Requisition requisition)
	{
		this.requisition = requisition;
	}

	public String getBaseCurrency()
	{
		return BaseCurrency;
	}

	public String getBUName()
	{
		return BUName;
	}

	public CustomDate getCustomDate()
	{
		return customDate;
	}

	public String getDeliveryDate()
	{
		return DeliveryDate;
	}

	public String getDeliveryTo()
	{
		return DeliveryTo;
	}

	public Item getItem()
	{
		return item;
	}

	public String getItemName()
	{
		return ItemName;
	}

	public String getItemNo()
	{
		return itemNo;
	}

	public void setItemNo(String itemNo)
	{
		this.itemNo = itemNo;
	}

	public String getPoNo()
	{
		return poNo;
	}

	public String getPoTotal()
	{
		return PoTotal;
	}

	public String getQty()
	{
		return Qty;
	}

	public String getReqNo()
	{
		return ReqNo;
	}

	public String getSearchType()
	{
		return searchType;
	}

	public StandardPO getStandardPO()
	{
		return standardPO;
	}

	public String getStatus()
	{
		return Status;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public String getTotalPrice()
	{
		return TotalPrice;
	}

	public String getUnitPrice()
	{
		return UnitPrice;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setBaseCurrency(String baseCurrency)
	{
		BaseCurrency = baseCurrency;
	}

	public void setBUName(String bUName)
	{
		BUName = bUName;
	}

	public void setCustomDate(CustomDate customDate)
	{
		this.customDate = customDate;
	}

	public void setDeliveryDate(String deliveryDate)
	{
		DeliveryDate = deliveryDate;
	}

	public void setDeliveryTo(String deliveryTo)
	{
		DeliveryTo = deliveryTo;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public void setItemName(String itemName)
	{
		ItemName = itemName;
	}

	public void setPoNo(String poNo)
	{
		this.poNo = poNo;
	}

	public void setPoTotal(String poTotal)
	{
		PoTotal = poTotal;
	}

	public void setQty(String qty)
	{
		Qty = qty;
	}

	public void setReqNo(String reqNo)
	{
		ReqNo = reqNo;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public void setSearchType(String searchType)
	{
		this.searchType = searchType;
	}

	public void setStandardPO(StandardPO standardPO)
	{
		this.standardPO = standardPO;
	}

	public void setStatus(String status)
	{
		Status = status;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public void setTotalPrice(String totalPrice)
	{
		TotalPrice = totalPrice;

	}

	public void setUnitPrice(String unitPrice)
	{
		UnitPrice = unitPrice;
	}

	public BillingRequisitionSummary getBillingRequisitionSummary()
	{
		return billingRequisitionSummary;
	}

	public void setBillingRequisitionSummary(BillingRequisitionSummary billingRequisitionSummary)
	{
		this.billingRequisitionSummary = billingRequisitionSummary;
	}

	@Override
	public String toString()
	{
		return "PurchaseOrder [poNo=" + poNo + ", supplierName=" + supplierName + ", BUName=" + BUName + ", DeliveryDate=" + DeliveryDate + ", BaseCurrency=" + BaseCurrency
			+ ", Status=" + Status + ", ReqNo=" + ReqNo + ", ItemName=" + ItemName + ", DeliveryTo=" + DeliveryTo + ", UnitPrice=" + UnitPrice + ", Qty=" + Qty + ", TotalPrice="
			+ TotalPrice + ", PoTotal=" + PoTotal + ", customDate=" + customDate + ", item=" + item + ", result=" + result + ", standardPO=" + standardPO + ", searchType="
			+ searchType + "]";
	}

	public String getRecommendationMemoProvided()
	{
		return recommendationMemoProvided;
	}

	public void setRecommendationMemoProvided(String recommendationMemoProvided)
	{
		this.recommendationMemoProvided = recommendationMemoProvided;
	}

	public String getQuote()
	{
		return quote;
	}

	public void setQuote(String quote)
	{
		this.quote = quote;
	}

	public String getCmsRegistered()
	{
		return cmsRegistered;
	}

	public void setCmsRegistered(String cmsRegistered)
	{
		this.cmsRegistered = cmsRegistered;
	}

	public String getProccurementInvolvement()
	{
		return proccurementInvolvement;
	}

	public void setProccurementInvolvement(String proccurementInvolvement)
	{
		this.proccurementInvolvement = proccurementInvolvement;
	}

	public String getPoMedium()
	{
		return poMedium;
	}

	public void setPoMedium(String poMedium)
	{
		this.poMedium = poMedium;
	}

	public String getPanelApply()
	{
		return panelApply;
	}

	public void setPanelApply(String panelApply)
	{
		this.panelApply = panelApply;
	}

	public String getIsPOValue()
	{
		return isPOValue;
	}

	public void setIsPOValue(String isPOValue)
	{
		this.isPOValue = isPOValue;
	}

}
