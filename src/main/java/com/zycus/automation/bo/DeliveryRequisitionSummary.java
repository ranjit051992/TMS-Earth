/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class DeliveryRequisitionSummary
{
	private String		deliverTo;
	private boolean		OUAddressOption;
	private boolean		otherAddressesOption;
	private boolean		myAddressOption;
	private String		otherAddresses;
	private String		selectDeliveryAddress;
	private String		myAddress_Name;
	private String		myAddress_Street1;
	private String		myAddress_Street2;
	private String		myAddress_city;
	private String		myAddress_country;
	private String		myAddress_state;
	private int			myAddress_zip;
	private String		nextAction;
	private CustomDate	customDate;

	public CustomDate getCustomDate()
	{
		return customDate;
	}

	public void setCustomDate(CustomDate customDate)
	{
		this.customDate = customDate;
	}

	public String getSelectDeliveryAddress()
	{
		return selectDeliveryAddress;
	}

	public void setSelectDeliveryAddress(String selectDeliveryAddress)
	{
		this.selectDeliveryAddress = selectDeliveryAddress;
	}

	public boolean isOUAddressOption()
	{
		return OUAddressOption;
	}

	public void setOUAddressOption(boolean oUAddressOption)
	{
		OUAddressOption = oUAddressOption;
	}

	public boolean isOtherAddressesOption()
	{
		return otherAddressesOption;
	}

	public void setOtherAddressesOption(boolean otherAddressesOption)
	{
		this.otherAddressesOption = otherAddressesOption;
	}

	public boolean isMyAddressOption()
	{
		return myAddressOption;
	}

	public void setMyAddressOption(boolean myAddressOption)
	{
		this.myAddressOption = myAddressOption;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getDeliverTo()
	{
		return deliverTo;
	}

	public void setDeliverTo(String deliverTo)
	{
		this.deliverTo = deliverTo;
	}

	public String getOtherAddresses()
	{
		return otherAddresses;
	}

	public void setOtherAddresses(String otherAddresses)
	{
		this.otherAddresses = otherAddresses;
	}

	public String getMyAddress_Name()
	{
		return myAddress_Name;
	}

	public void setMyAddress_Name(String myAddress_Name)
	{
		this.myAddress_Name = myAddress_Name;
	}

	public String getMyAddress_Street1()
	{
		return myAddress_Street1;
	}

	public void setMyAddress_Street1(String myAddress_Street1)
	{
		this.myAddress_Street1 = myAddress_Street1;
	}

	public String getMyAddress_Street2()
	{
		return myAddress_Street2;
	}

	public void setMyAddress_Street2(String myAddress_Street2)
	{
		this.myAddress_Street2 = myAddress_Street2;
	}

	public String getMyAddress_city()
	{
		return myAddress_city;
	}

	public void setMyAddress_city(String myAddress_city)
	{
		this.myAddress_city = myAddress_city;
	}

	public String getMyAddress_country()
	{
		return myAddress_country;
	}

	public void setMyAddress_country(String myAddress_country)
	{
		this.myAddress_country = myAddress_country;
	}

	public String getMyAddress_state()
	{
		return myAddress_state;
	}

	public void setMyAddress_state(String myAddress_state)
	{
		this.myAddress_state = myAddress_state;
	}

	public int getMyAddress_zip()
	{
		return myAddress_zip;
	}

	public void setMyAddress_zip(int myAddress_zip)
	{
		this.myAddress_zip = myAddress_zip;
	}

}
