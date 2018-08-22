package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankita.sawant
 * 
 */
public class ItemMasterCatalog
{
	private String					itemMasterName				= null;
	private boolean					itemMasterType_inventory	= false;
	private boolean					itemMasterType_nonInventory	= false;
	private String					description					= null;
	private String					nextActionItemMasterDetails	= null;
	private String					fileName					= null;
	private List<ItemMasterItem>	itemMasterItems				= new ArrayList<ItemMasterItem>();
	private String					nextActionItemDetails		= null;
	private String					organizationUnit			= null;
	private String					nextActionScopeAndValidity	= null;
	private boolean					isFillItemMasterDetails		= true;
	private String					nextActionAddItem			= null;
	private String					region						= null;
	private String					company						= null;
	private String					businessUnit				= null;
	private String					location					= null;
	private String					warehouse					= null;
	private boolean					isWarehouseFieldPresent		= false;
	private boolean					isFillScopeAndValidity		= true;
	private String					regionName					= null;

	public String getWarehouse()
	{
		return warehouse;
	}

	public void setWarehouse(String warehouse)
	{
		this.warehouse = warehouse;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getBusinessUnit()
	{
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit)
	{
		this.businessUnit = businessUnit;
	}

	public String getNextActionAddItem()
	{
		return nextActionAddItem;
	}

	public void setNextActionAddItem(String nextActionAddItem)
	{
		this.nextActionAddItem = nextActionAddItem;
	}

	public boolean isFillItemMasterDetails()
	{
		return isFillItemMasterDetails;
	}

	public void setFillItemMasterDetails(boolean isFillItemMasterDetails)
	{
		this.isFillItemMasterDetails = isFillItemMasterDetails;
	}

	public String getItemMasterName()
	{
		return itemMasterName;
	}

	public void setItemMasterName(String itemMasterName)
	{
		this.itemMasterName = itemMasterName;
	}

	public boolean isItemMasterType_inventory()
	{
		return itemMasterType_inventory;
	}

	public void setItemMasterType_inventory(boolean itemMasterType_inventory)
	{
		this.itemMasterType_inventory = itemMasterType_inventory;
	}

	public boolean isItemMasterType_nonInventory()
	{
		return itemMasterType_nonInventory;
	}

	public void setItemMasterType_nonInventory(boolean itemMasterType_nonInventory)
	{
		this.itemMasterType_nonInventory = itemMasterType_nonInventory;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getNextActionItemMasterDetails()
	{
		return nextActionItemMasterDetails;
	}

	public void setNextActionItemMasterDetails(String nextActionItemMasterDetails)
	{
		this.nextActionItemMasterDetails = nextActionItemMasterDetails;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public List<ItemMasterItem> getItemMasterItems()
	{
		return itemMasterItems;
	}

	public void setItemMasterItems(List<ItemMasterItem> itemMasterItems)
	{
		this.itemMasterItems = itemMasterItems;
	}

	public String getNextActionItemDetails()
	{
		return nextActionItemDetails;
	}

	public void setNextActionItemDetails(String nextActionItemDetails)
	{
		this.nextActionItemDetails = nextActionItemDetails;
	}

	public String getOrganizationUnit()
	{
		return organizationUnit;
	}

	public void setOrganizationUnit(String organizationUnit)
	{
		this.organizationUnit = organizationUnit;
	}

	public String getNextActionScopeAndValidity()
	{
		return nextActionScopeAndValidity;
	}

	public void setNextActionScopeAndValidity(String nextActionScopeAndValidity)
	{
		this.nextActionScopeAndValidity = nextActionScopeAndValidity;
	}

	public void setWarehouseFieldPresent(boolean isWarehouseFieldPresent)
	{
		this.isWarehouseFieldPresent = isWarehouseFieldPresent;
	}

	public String getRegionName()
	{
		return regionName;
	}

	public void setRegionName(String regionName)
	{
		this.regionName = regionName;
	}

	public boolean isFillScopeAndValidity()
	{
		return isFillScopeAndValidity;
	}

	public void setFillScopeAndValidity(boolean isFillScopeAndValidity)
	{
		this.isFillScopeAndValidity = isFillScopeAndValidity;
	}

}
