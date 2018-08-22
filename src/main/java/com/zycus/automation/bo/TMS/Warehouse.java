package com.zycus.automation.bo.TMS;

/**
 * 
 * @author t.amarnath
 *
 */
public class Warehouse
{
	private String	warehouseName;
	private String	warehouseAddress;
	private String	warehouseStatus;
	private String	warehouseCode;
	private String	warehouseLocation;
	private boolean	isfillWarehouseScope;
	private String	nextActionFillWarehouseDetails;

	public String getWarehouseName()
	{
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName)
	{
		this.warehouseName = warehouseName;
	}

	public String getWarehouseAddress()
	{
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress)
	{
		this.warehouseAddress = warehouseAddress;
	}

	public String getWarehouseStatus()
	{
		return warehouseStatus;
	}

	public void setWarehouseStatus(String warehouseStatus)
	{
		this.warehouseStatus = warehouseStatus;
	}

	public String getWarehouseCode()
	{
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode)
	{
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseLocation()
	{
		return warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation)
	{
		this.warehouseLocation = warehouseLocation;
	}

	public boolean isIsfillWarehouseScope()
	{
		return isfillWarehouseScope;
	}

	public void setIsfillWarehouseScope(boolean isfillWarehouseScope)
	{
		this.isfillWarehouseScope = isfillWarehouseScope;
	}

	public String getNextActionFillWarehouseDetails()
	{
		return nextActionFillWarehouseDetails;
	}

	public void setNextActionFillWarehouseDetails(String nextActionFillWarehouseDetails)
	{
		this.nextActionFillWarehouseDetails = nextActionFillWarehouseDetails;
	}
}
