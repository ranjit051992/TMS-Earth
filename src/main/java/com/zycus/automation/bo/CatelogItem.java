package com.zycus.automation.bo;

import java.util.List;
import java.util.Map;

public class CatelogItem
{

	private String								itemName;
	private String								itemNo;
	private String								description;
	private String								category;
	private String								itemID;
	private String								supplier;
	private int									delieveryDays;
	private String								unitCurrency;
	private double								unitPrice;
	private String								userCurrency;
	private double								userCurrencyConversionRate;
	private double								itemPriceInUserCurrency;
	private int									quantity;
	private boolean								result;
	private boolean								isFavorite;
	private String								supplierPartID;
	private String								nextAction;
	private DeliveryItemSummary					deliveryItemSummary;
	private CostBookingItemSummary				costBookingItemSummary;
	private AccountingItemSummary				accountingItemSummary;
	private AttachmentsAndCommentsItemSummary	attachmentsAndCommentsItemSummary;
	private String								totalItemPrice;
	private String								marketPrice;
	private String								manufacturerName;
	private String								manufacturerPartId;
	private Map<String, String>					speckey_valueMap;
	private List<String>						attachments;
	private String								unit_Price;
	private String								availability;
	private String								supplierContact	= null;
	private String								contractNo;
	private String								uom				= null;
	private String								productURL;
	private String								manufacturerURL;
	private boolean								isGreen;
	private boolean								isPreferred;
	private String								specificationName;
	private String								specificationType;
	private String								specificationValue;
	private String								erpPartNo;

	public boolean isGreen()
	{
		return isGreen;
	}

	public void setGreen(boolean isGreen)
	{
		this.isGreen = isGreen;
	}

	public boolean isPreferred()
	{
		return isPreferred;
	}

	public void setPreferred(boolean isPreferred)
	{
		this.isPreferred = isPreferred;
	}

	public String getSpecificationName()
	{
		return specificationName;
	}

	public void setSpecificationName(String specificationName)
	{
		this.specificationName = specificationName;
	}

	public String getSpecificationType()
	{
		return specificationType;
	}

	public void setSpecificationType(String specificationType)
	{
		this.specificationType = specificationType;
	}

	public String getSpecificationValue()
	{
		return specificationValue;
	}

	public void setSpecificationValue(String specificationValue)
	{
		this.specificationValue = specificationValue;
	}

	public String getManufacturerURL()
	{
		return manufacturerURL;
	}

	public void setManufacturerURL(String manufacturerURL)
	{
		this.manufacturerURL = manufacturerURL;
	}

	public String getProductURL()
	{
		return productURL;
	}

	public void setProductURL(String productURL)
	{
		this.productURL = productURL;
	}

	public String getUom()
	{
		return uom;
	}

	public void setUom(String uom)
	{
		this.uom = uom;
	}

	public String getUnit_Price()
	{
		return unit_Price;
	}

	public void setUnit_Price(String unit_Price)
	{
		this.unit_Price = unit_Price;
	}

	public String getAvailability()
	{
		return availability;
	}

	public void setAvailability(String availability)
	{
		this.availability = availability;
	}

	public String getMarketPrice()
	{
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice)
	{
		this.marketPrice = marketPrice;
	}

	public String getManufacturerName()
	{
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName)
	{
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerPartId()
	{
		return manufacturerPartId;
	}

	public void setManufacturerPartId(String manufacturerPartId)
	{
		this.manufacturerPartId = manufacturerPartId;
	}

	public Map<String, String> getSpeckey_valueMap()
	{
		return speckey_valueMap;
	}

	public void setSpeckey_valueMap(Map<String, String> speckey_valueMap)
	{
		this.speckey_valueMap = speckey_valueMap;
	}

	public List<String> getAttachments()
	{
		return attachments;
	}

	public void setAttachments(List<String> attachments)
	{
		this.attachments = attachments;
	}

	public String getTotalItemPrice()
	{
		return totalItemPrice;
	}

	public void setTotalItemPrice(String totalItemPrice)
	{
		this.totalItemPrice = totalItemPrice;
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

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getSupplierPartID()
	{
		return supplierPartID;
	}

	public void setSupplierPartID(String supplierPartID)
	{
		this.supplierPartID = supplierPartID;
	}

	public String getItemNo()
	{
		return itemNo;
	}

	public void setItemNo(String itemNo)
	{
		this.itemNo = itemNo;
	}

	public boolean isFavorite()
	{
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite)
	{
		this.isFavorite = isFavorite;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getItemID()
	{
		return itemID;
	}

	public void setItemID(String itemID)
	{
		this.itemID = itemID;
	}

	public String getSupplier()
	{
		return supplier;
	}

	public void setSupplier(String supplier)
	{
		this.supplier = supplier;
	}

	public int getDelieveryDays()
	{
		return delieveryDays;
	}

	public void setDelieveryDays(int delieveryDays)
	{
		this.delieveryDays = delieveryDays;
	}

	public String getUnitCurrency()
	{
		return unitCurrency;
	}

	public void setUnitCurrency(String unitCurrency)
	{
		this.unitCurrency = unitCurrency;
	}

	public double getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public String getUserCurrency()
	{
		return userCurrency;
	}

	public void setUserCurrency(String userCurrency)
	{
		this.userCurrency = userCurrency;
	}

	public double getUserCurrencyConversionRate()
	{
		return userCurrencyConversionRate;
	}

	public void setUserCurrencyConversionRate(double userCurrencyConversionRate)
	{
		this.userCurrencyConversionRate = userCurrencyConversionRate;
	}

	public double getItemPriceInUserCurrency()
	{
		return itemPriceInUserCurrency;
	}

	public void setItemPriceInUserCurrency(double itemPriceInUserCurrency)
	{
		this.itemPriceInUserCurrency = itemPriceInUserCurrency;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public String getSupplierContact()
	{
		return supplierContact;
	}

	public void setSupplierContact(String supplierContact)
	{
		this.supplierContact = supplierContact;
	}

	public String getContractNo()
	{
		return contractNo;
	}

	public void setContractNo(String contractNumber)
	{
		this.contractNo = contractNumber;
	}

	@Override
	public String toString()
	{
		return "CatelogItem [itemName=" + itemName + ", description=" + description + ", category=" + category + ", itemID=" + itemID + ", supplier=" + supplier
			+ ", delieveryDays=" + delieveryDays + ", unitCurrency=" + unitCurrency + ", unitPrice=" + unitPrice + ", userCurrency=" + userCurrency
			+ ", userCurrencyConversionRate=" + userCurrencyConversionRate + ", itemPriceInUserCurrency=" + itemPriceInUserCurrency + ", quantity=" + quantity + "]";
	}

	public String getErpPartNo()
	{
		return erpPartNo;
	}

	public void setErpPartNo(String erpPartNo)
	{
		this.erpPartNo = erpPartNo;
	}

}
