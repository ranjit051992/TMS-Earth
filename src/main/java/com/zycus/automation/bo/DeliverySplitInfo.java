/**
 * 
 */
package com.zycus.automation.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author ankita.sawant
 *
 */
@Entity
@Table(name = "DeliverySplitInfo")
public class DeliverySplitInfo
{
	@Id
	@GeneratedValue
	private int			id;
	private String		deliverTo;
	private String		deliveryAddress;
	private int			quantity;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomDate	customDate;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomDate	toCustomDate;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public CustomDate getToCustomDate()
	{
		return toCustomDate;
	}

	public void setToCustomDate(CustomDate toCustomDate)
	{
		this.toCustomDate = toCustomDate;
	}

	public CustomDate getCustomDate()
	{
		return customDate;
	}

	public void setCustomDate(CustomDate customDate)
	{
		this.customDate = customDate;
	}

	public String getDeliverTo()
	{
		return deliverTo;
	}

	public void setDeliverTo(String deliverTo)
	{
		this.deliverTo = deliverTo;
	}

	public String getDeliveryAddress()
	{
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

}
