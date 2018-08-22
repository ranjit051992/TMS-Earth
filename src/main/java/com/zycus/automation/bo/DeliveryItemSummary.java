/**
 * 
 */
package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ankita.sawant
 *
 */
@Entity
@Table(name = "DeliveryItemSummary")
public class DeliveryItemSummary
{
	@Id
	@GeneratedValue
	private int						id;
	// private int itemId;
	private boolean					useDeliveryInfoFromReqSummary;
	private boolean					splitDeliveryToMultipleLocations;
	private boolean					createAssetTags		= false;
	@OneToMany(cascade = CascadeType.ALL)
	private List<DeliverySplitInfo>	deliverySplitInfo	= new ArrayList<DeliverySplitInfo>();
	private String					nextAction;
	private List<AssetTagging>		assetTaggings		= new ArrayList<AssetTagging>();

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

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public boolean isUseDeliveryInfoFromReqSummary()
	{
		return useDeliveryInfoFromReqSummary;
	}

	public void setUseDeliveryInfoFromReqSummary(boolean useDeliveryInfoFromReqSummary)
	{
		this.useDeliveryInfoFromReqSummary = useDeliveryInfoFromReqSummary;
	}

	public boolean isSplitDeliveryToMultipleLocations()
	{
		return splitDeliveryToMultipleLocations;
	}

	public void setSplitDeliveryToMultipleLocations(boolean splitDeliveryToMultipleLocations)
	{
		this.splitDeliveryToMultipleLocations = splitDeliveryToMultipleLocations;
	}

	public List<DeliverySplitInfo> getDeliverySplitInfo()
	{
		return deliverySplitInfo;
	}

	public void setDeliverySplitInfo(List<DeliverySplitInfo> deliverySplitInfo)
	{
		this.deliverySplitInfo = deliverySplitInfo;
	}

	public boolean isCreateAssetTags()
	{
		return createAssetTags;
	}

	public void setCreateAssetTags(boolean createAssetTags)
	{
		this.createAssetTags = createAssetTags;
	}

	public List<AssetTagging> getAssetTaggings()
	{
		return assetTaggings;
	}

	public void setAssetTaggings(List<AssetTagging> assetTaggings)
	{
		this.assetTaggings = assetTaggings;
	}

}
