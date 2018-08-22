/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class MasterDataTenantConfig
{
	private String	purchaseType									= null;
	private String	nextAction										= null;
	private boolean	enforcePurchaseTypeBasedValidationOfGLAccounts	= false;
	private boolean	result											= false;
	private String	usePurchaseTypeFieldToClassifyPurchases			= null;

	public boolean isEnforcePurchaseTypeBasedValidationOfGLAccounts()
	{
		return enforcePurchaseTypeBasedValidationOfGLAccounts;
	}

	public void setEnforcePurchaseTypeBasedValidationOfGLAccounts(boolean enforcePurchaseTypeBasedValidationOfGLAccounts)
	{
		this.enforcePurchaseTypeBasedValidationOfGLAccounts = enforcePurchaseTypeBasedValidationOfGLAccounts;
	}

	public String getPurchaseType()
	{
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType)
	{
		this.purchaseType = purchaseType;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getUsePurchaseTypeFieldToClassifyPurchases()
	{
		return usePurchaseTypeFieldToClassifyPurchases;
	}

	public void setUsePurchaseTypeFieldToClassifyPurchases(String usePurchaseTypeFieldToClassifyPurchases)
	{
		this.usePurchaseTypeFieldToClassifyPurchases = usePurchaseTypeFieldToClassifyPurchases;
	}

}
