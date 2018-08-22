/**
 * 
 */
package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankita.sawant
 *
 */
public class Catalog
{
	private String				catalogName;
	private String				supplierName;
	private String				supplierAddress;
	private List<CatelogItem>	catelogItems				= new ArrayList<CatelogItem>();
	private String				organizationUnit;
	private String				nextAction;
	private boolean				fillCatalogDetails			= false;
	private String				catalogDetailsNextAction	= null;
	private String				itemDetailsNextAction		= null;
	private String				fileName					= null;
	private String				region						= null;
	private String				company						= null;
	private String				businessUnit				= null;
	private String				location					= null;
	private boolean				markForAddingApprover		= false;
	private CustomDate			fromScopeValidityDate		= null;
	private CustomDate			toScopeValidityDate			= null;
	private boolean				isCarlsonOU					= false;
	private String				supplierERPId				= null;
	private String				contractNumber				= null;

	public String getSupplierERPId()
	{
		return supplierERPId;
	}

	public void setSupplierERPId(String supplierERPId)
	{
		this.supplierERPId = supplierERPId;
	}

	public CustomDate getFromScopeValidityDate()
	{
		return fromScopeValidityDate;
	}

	public void setFromScopeValidityDate(CustomDate fromScopeValidityDate)
	{
		this.fromScopeValidityDate = fromScopeValidityDate;
	}

	public CustomDate getToScopeValidityDate()
	{
		return toScopeValidityDate;
	}

	public void setToScopeValidityDate(CustomDate toScopeValidityDate)
	{
		this.toScopeValidityDate = toScopeValidityDate;
	}

	public boolean isMarkForAddingApprover()
	{
		return markForAddingApprover;
	}

	public void setMarkForAddingApprover(boolean markForAddingApprover)
	{
		this.markForAddingApprover = markForAddingApprover;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getBusinessUnit()
	{
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit)
	{
		this.businessUnit = businessUnit;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public boolean isFillCatalogDetails()
	{
		return fillCatalogDetails;
	}

	public void setFillCatalogDetails(boolean fillCatalogDetails)
	{
		this.fillCatalogDetails = fillCatalogDetails;
	}

	public String getCatalogDetailsNextAction()
	{
		return catalogDetailsNextAction;
	}

	public void setCatalogDetailsNextAction(String catalogDetailsNextAction)
	{
		this.catalogDetailsNextAction = catalogDetailsNextAction;
	}

	public String getItemDetailsNextAction()
	{
		return itemDetailsNextAction;
	}

	public void setItemDetailsNextAction(String itemDetailsNextAction)
	{
		this.itemDetailsNextAction = itemDetailsNextAction;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getCatalogName()
	{
		return catalogName;
	}

	public void setCatalogName(String catalogName)
	{
		this.catalogName = catalogName;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public String getSupplierAddress()
	{
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress)
	{
		this.supplierAddress = supplierAddress;
	}

	public List<CatelogItem> getCatelogItems()
	{
		return catelogItems;
	}

	public void setCatelogItems(List<CatelogItem> catelogItems)
	{
		this.catelogItems = catelogItems;
	}

	public String getOrganizationUnit()
	{
		return organizationUnit;
	}

	public void setOrganizationUnit(String organizationUnit)
	{
		this.organizationUnit = organizationUnit;
	}

	public boolean getIsCarlsonOU()
	{
		return isCarlsonOU;
	}

	public void setCarlsonOU(boolean isCarlsonOU)
	{
		this.isCarlsonOU = isCarlsonOU;
	}

	public String getContractNumber()
	{
		return contractNumber;
	}

	public void setContractNumber(String contractNumber)
	{
		this.contractNumber = contractNumber;
	}
}
