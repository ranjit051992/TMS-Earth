package eProc.bo;



import java.util.List;

public class CatalogItemBO
{
	private String itemName;
	private int quantity;
	private List<String> attachments;
	private String maximumItemTotalAcrossReleases;
	private String maximumUnitPricePerRelease;
	private String marketPrice;

	public List<String> getAttachments()
	{
		return attachments;
	}

	public void setAttachments(List<String> attachments)
	{
		this.attachments = attachments;
	}

	public String getItemName()
	{
		return itemName;
	}

	public String supplierName;

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public String getMaximumItemTotalAcrossReleases() {
		return maximumItemTotalAcrossReleases;
	}

	public void setMaximumItemTotalAcrossReleases(String maximumItemTotalAcrossReleases) {
		this.maximumItemTotalAcrossReleases = maximumItemTotalAcrossReleases;
	}

	public String getMaximumUnitPricePerRelease() {
		return maximumUnitPricePerRelease;
	}

	public void setMaximumUnitPricePerRelease(String maximumUnitPricePerRelease) {
		this.maximumUnitPricePerRelease = maximumUnitPricePerRelease;
	}

	public String getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}
	
}
