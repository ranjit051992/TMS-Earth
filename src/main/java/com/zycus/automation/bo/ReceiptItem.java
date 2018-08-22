package com.zycus.automation.bo;

/**
 * 
 * @author omkar.jagdale
 *
 */
public class ReceiptItem
{
	private String	status;
	//received item
	private String	itemName;
	private String	supplierName;
	private String	itemRate;
	private String	requisitionNo;
	private String	unitPrice;
	private String	orderedQuantity;
	private String	receivedQuantity;
	private String	approvedQuantity;
	private String	acceptedGoodsValue;
	//returned item
	private String	returnedQuantity;
	private String	returnedGoodsOrServiceValue;
	private String	reasonForReturn;
	private String	returnMethod;

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public String getItemRate()
	{
		return itemRate;
	}

	public void setItemRate(String itemRate)
	{
		this.itemRate = itemRate;
	}

	public String getRequisitionNo()
	{
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo)
	{
		this.requisitionNo = requisitionNo;
	}

	public String getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public String getOrderedQuantity()
	{
		return orderedQuantity;
	}

	public void setOrderedQuantity(String orderedQuantity)
	{
		this.orderedQuantity = orderedQuantity;
	}

	public String getReceivedQuantity()
	{
		return receivedQuantity;
	}

	public void setReceivedQuantity(String receivedQuantity)
	{
		this.receivedQuantity = receivedQuantity;
	}

	public String getApprovedQuantity()
	{
		return approvedQuantity;
	}

	public void setApprovedQuantity(String approvedQuantity)
	{
		this.approvedQuantity = approvedQuantity;
	}

	public String getAcceptedGoodsValue()
	{
		return acceptedGoodsValue;
	}

	public void setAcceptedGoodsValue(String acceptedGoodsValue)
	{
		this.acceptedGoodsValue = acceptedGoodsValue;
	}

	public String getReturnedQuantity()
	{
		return returnedQuantity;
	}

	public void setReturnedQuantity(String returnedQuantity)
	{
		this.returnedQuantity = returnedQuantity;
	}

	public String getReturnedGoodsOrServiceValue()
	{
		return returnedGoodsOrServiceValue;
	}

	public void setReturnedGoodsOrServiceValue(String returnedGoodsOrServiceValue)
	{
		this.returnedGoodsOrServiceValue = returnedGoodsOrServiceValue;
	}

	public String getReasonForReturn()
	{
		return reasonForReturn;
	}

	public void setReasonForReturn(String reasonForReturn)
	{
		this.reasonForReturn = reasonForReturn;
	}

	public String getReturnMethod()
	{
		return returnMethod;
	}

	public void setReturnMethod(String returnMethod)
	{
		this.returnMethod = returnMethod;
	}

	@Override
	public String toString()
	{
		return "ReceiptItem [status=" + status + ", itemName=" + itemName + ", supplierName=" + supplierName + ", itemRate=" + itemRate + ", requisitionNo=" + requisitionNo
			+ ", unitPrice=" + unitPrice + ", orderedQuantity=" + orderedQuantity + ", receivedQuantity=" + receivedQuantity + ", approvedQuantity=" + approvedQuantity
			+ ", acceptedGoodsValue=" + acceptedGoodsValue + ", returnedQuantity=" + returnedQuantity + ", returnedGoodsOrServiceValue=" + returnedGoodsOrServiceValue
			+ ", reasonForReturn=" + reasonForReturn + ", returnMethod=" + returnMethod + "]";
	}

}
