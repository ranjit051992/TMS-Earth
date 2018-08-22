package com.zycus.automation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ModalGuidedItemSelectSupplierContract")
public class ModalGuidedItemSelectSupplierContract
{
	@Id
	@GeneratedValue
	private int		id;
	// private int itemId;
	private String	contract;

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

	public String getcontract()
	{
		return contract;
	}

	public void setcontract(String contract)
	{
		this.contract = contract;
	}
}
