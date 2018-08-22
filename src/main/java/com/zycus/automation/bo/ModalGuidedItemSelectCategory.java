package com.zycus.automation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ModalGuidedItemSelectCategory")
public class ModalGuidedItemSelectCategory
{
	@Id
	@GeneratedValue
	private int		id;

	// private int itemId;
	private String	category;
	private String	categoryEFormName	= null;

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

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getCategoryEFormName()
	{
		return categoryEFormName;
	}

	public void setCategoryEFormName(String categoryEFormName)
	{
		this.categoryEFormName = categoryEFormName;
	}
}
