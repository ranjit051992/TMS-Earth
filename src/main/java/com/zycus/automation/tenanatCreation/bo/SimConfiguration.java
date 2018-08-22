package com.zycus.automation.tenanatCreation.bo;

public class SimConfiguration
{
	public boolean	viewAccessesCompany				= false;
	public boolean	viewAccessesAddress				= false;
	public boolean	viewAccessesProductAndServices	= false;
	public boolean	viewAccessesSpendInformation	= false;
	public boolean	viewAccessesDiversity			= false;
	public boolean	viewAccessesFinancial			= false;
	public boolean	viewAccessesInsurance			= false;
	public boolean	viewAccessesPurchasing			= false;
	public String	simMasterDataFilesLocation;

	public String getSimMasterDataFilesLocation()
	{
		return simMasterDataFilesLocation;
	}

	public void setSimMasterDataFilesLocation(String simMasterDataFilesLocation)
	{
		this.simMasterDataFilesLocation = simMasterDataFilesLocation;
	}

	public boolean isViewAccessesCompany()
	{
		return viewAccessesCompany;
	}

	public void setViewAccessesCompany(boolean viewAccessesCompany)
	{
		this.viewAccessesCompany = viewAccessesCompany;
	}

	public boolean isViewAccessesAddress()
	{
		return viewAccessesAddress;
	}

	public void setViewAccessesAddress(boolean viewAccessesAddress)
	{
		this.viewAccessesAddress = viewAccessesAddress;
	}

	public boolean isViewAccessesProductAndServices()
	{
		return viewAccessesProductAndServices;
	}

	public void setViewAccessesProductAndServices(boolean viewAccessesProductAndServices)
	{
		this.viewAccessesProductAndServices = viewAccessesProductAndServices;
	}

	public boolean isViewAccessesSpendInformation()
	{
		return viewAccessesSpendInformation;
	}

	public void setViewAccessesSpendInformation(boolean viewAccessesSpendInformation)
	{
		this.viewAccessesSpendInformation = viewAccessesSpendInformation;
	}

	public boolean isViewAccessesDiversity()
	{
		return viewAccessesDiversity;
	}

	public void setViewAccessesDiversity(boolean viewAccessesDiversity)
	{
		this.viewAccessesDiversity = viewAccessesDiversity;
	}

	public boolean isViewAccessesFinancial()
	{
		return viewAccessesFinancial;
	}

	public void setViewAccessesFinancial(boolean viewAccessesFinancial)
	{
		this.viewAccessesFinancial = viewAccessesFinancial;
	}

	public boolean isViewAccessesInsurance()
	{
		return viewAccessesInsurance;
	}

	public void setViewAccessesInsurance(boolean viewAccessesInsurance)
	{
		this.viewAccessesInsurance = viewAccessesInsurance;
	}

	public boolean isViewAccessesPurchasing()
	{
		return viewAccessesPurchasing;
	}

	public void setViewAccessesPurchasing(boolean viewAccessesPurchasing)
	{
		this.viewAccessesPurchasing = viewAccessesPurchasing;
	}

}
