package com.zycus.automation.bo;

/**
 * @author bhakti.sawant
 */
public class AssetTagging
{

	private int		serialNo;
	private String	assetNo;
	private String	manufacturerSrNo;
	private String	assetNotes;

	public int getSerialNo()
	{
		return serialNo;
	}

	public void setSerialNo(int serialNo)
	{
		this.serialNo = serialNo;
	}

	public String getAssetNo()
	{
		return assetNo;
	}

	public void setAssetNo(String assetNo)
	{
		this.assetNo = assetNo;
	}

	public String getManufacturerSrNo()
	{
		return manufacturerSrNo;
	}

	public void setManufacturerSrNo(String manufacturerSrNo)
	{
		this.manufacturerSrNo = manufacturerSrNo;
	}

	public String getAssetNotes()
	{
		return assetNotes;
	}

	public void setAssetNotes(String assetNotes)
	{
		this.assetNotes = assetNotes;
	}

}
