/**
 * 
 */
package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankita.sawant
 *
 */
public class ItemMasterItem
{
	public String				scopeId					= "";
	public int					supplierId;
	public String				supplierName			= "";
	public String				supplierAuxPartId		= "";
	public int					catalogVersion;
	public int					catalogItemId;
	public String				supplierPartId			= "";
	public String				categoryName			= "";
	public String				name					= "";
	public String				description				= "";
	public String				uom						= "";
	public String				currency				= "";
	public int					sourceType;
	public String				sourceRefNo				= "";
	public Double				price;
	public String				marketPrice;
	public int					leadTime;
	public String				categoryCode			= "";
	public String				manufacturerPartId		= "";
	public String				manufacturerName		= "";
	public String				supplierProductURL		= "";
	public String				manufacturerProductURL	= "";
	public String				imageURL				= "";
	public String				thumbnailURL			= "";
	public boolean				active;
	public boolean				hidden;
	public boolean				greenItem;
	public boolean				preferredItem;
	public boolean				outOfStock;
	public List<ItemAttribute>	itemAttributes			= new ArrayList<ItemAttribute>();
	private int					quantity;
	private String				itemId;
	private String				sourcingStatus			= null;
	private boolean				addSupplier				= false;
	private boolean				addSecondSupplier		= false;

	public boolean isAddSecondSupplier()
	{
		return addSecondSupplier;
	}

	public void setAddSecondSupplier(boolean addSecondSupplier)
	{
		this.addSecondSupplier = addSecondSupplier;
	}

	public String getSourcingStatus()
	{
		return sourcingStatus;
	}

	public void setSourcingStatus(String sourcingStatus)
	{
		this.sourcingStatus = sourcingStatus;
	}

	public String getItemId()
	{
		return itemId;
	}

	public void setItemId(String itemId)
	{
		this.itemId = itemId;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public String getScopeId()
	{
		return scopeId;
	}

	public void setScopeId(String scopeId)
	{
		this.scopeId = scopeId;
	}

	public int getSupplierId()
	{
		return supplierId;
	}

	public void setSupplierId(int supplierId)
	{
		this.supplierId = supplierId;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public String getSupplierAuxPartId()
	{
		return supplierAuxPartId;
	}

	public void setSupplierAuxPartId(String supplierAuxPartId)
	{
		this.supplierAuxPartId = supplierAuxPartId;
	}

	public int getCatalogVersion()
	{
		return catalogVersion;
	}

	public void setCatalogVersion(int catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public int getCatalogItemId()
	{
		return catalogItemId;
	}

	public void setCatalogItemId(int catalogItemId)
	{
		this.catalogItemId = catalogItemId;
	}

	public String getSupplierPartId()
	{
		return supplierPartId;
	}

	public void setSupplierPartId(String supplierPartId)
	{
		this.supplierPartId = supplierPartId;
	}

	public String getCategoryName()
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getUom()
	{
		return uom;
	}

	public void setUom(String uom)
	{
		this.uom = uom;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public int getSourceType()
	{
		return sourceType;
	}

	public void setSourceType(int sourceType)
	{
		this.sourceType = sourceType;
	}

	public String getSourceRefNo()
	{
		return sourceRefNo;
	}

	public void setSourceRefNo(String sourceRefNo)
	{
		this.sourceRefNo = sourceRefNo;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public String getMarketPrice()
	{
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice)
	{
		this.marketPrice = marketPrice;
	}

	public int getLeadTime()
	{
		return leadTime;
	}

	public void setLeadTime(int leadTime)
	{
		this.leadTime = leadTime;
	}

	public String getCategoryCode()
	{
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode)
	{
		this.categoryCode = categoryCode;
	}

	public String getManufacturerPartId()
	{
		return manufacturerPartId;
	}

	public void setManufacturerPartId(String manufacturerPartId)
	{
		this.manufacturerPartId = manufacturerPartId;
	}

	public String getManufacturerName()
	{
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName)
	{
		this.manufacturerName = manufacturerName;
	}

	public String getSupplierProductURL()
	{
		return supplierProductURL;
	}

	public void setSupplierProductURL(String supplierProductURL)
	{
		this.supplierProductURL = supplierProductURL;
	}

	public String getManufacturerProductURL()
	{
		return manufacturerProductURL;
	}

	public void setManufacturerProductURL(String manufacturerProductURL)
	{
		this.manufacturerProductURL = manufacturerProductURL;
	}

	public String getImageURL()
	{
		return imageURL;
	}

	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}

	public String getThumbnailURL()
	{
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL)
	{
		this.thumbnailURL = thumbnailURL;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public boolean isHidden()
	{
		return hidden;
	}

	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
	}

	public boolean isGreenItem()
	{
		return greenItem;
	}

	public void setGreenItem(boolean greenItem)
	{
		this.greenItem = greenItem;
	}

	public boolean isPreferredItem()
	{
		return preferredItem;
	}

	public void setPreferredItem(boolean preferredItem)
	{
		this.preferredItem = preferredItem;
	}

	public boolean isOutOfStock()
	{
		return outOfStock;
	}

	public void setOutOfStock(boolean outOfStock)
	{
		this.outOfStock = outOfStock;
	}

	public List<ItemAttribute> getItemAttributes()
	{
		return itemAttributes;
	}

	public void setItemAttributes(List<ItemAttribute> itemAttributes)
	{
		this.itemAttributes = itemAttributes;
	}

	public boolean isSupplierRequired()
	{
		return addSupplier;
	}

	public void setSupplierRequired(boolean addSupplier)
	{
		this.addSupplier = addSupplier;
	}

	@Override
	public String toString()
	{
		return "ItemMasterItem [scopeId=" + scopeId + ", supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierAuxPartId=" + supplierAuxPartId
			+ ", catalogVersion=" + catalogVersion + ", catalogItemId=" + catalogItemId + ", supplierPartId=" + supplierPartId + ", categoryName=" + categoryName + ", name=" + name
			+ ", description=" + description + ", uom=" + uom + ", currency=" + currency + ", sourceType=" + sourceType + ", sourceRefNo=" + sourceRefNo + ", price=" + price
			+ ", marketPrice=" + marketPrice + ", leadTime=" + leadTime + ", categoryCode=" + categoryCode + ", manufacturerPartId=" + manufacturerPartId + ", manufacturerName="
			+ manufacturerName + ", supplierProductURL=" + supplierProductURL + ", manufacturerProductURL=" + manufacturerProductURL + ", imageURL=" + imageURL + ", thumbnailURL="
			+ thumbnailURL + ", active=" + active + ", hidden=" + hidden + ", greenItem=" + greenItem + ", preferredItem=" + preferredItem + ", outOfStock=" + outOfStock
			+ ", itemAttributes=" + itemAttributes + ", quantity=" + quantity + ", SupplierRequired=" + addSupplier + "]";
	}

}
