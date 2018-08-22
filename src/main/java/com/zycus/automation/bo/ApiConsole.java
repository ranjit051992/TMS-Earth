package com.zycus.automation.bo;

public class ApiConsole
{
	private String	productName;
	private String	apiAction;
	private boolean	isActionDisplayed;
	private String	apiName;
	private String	requisitonId;
	private String	requisitionAction;
	private String	responseBody;
	private boolean	isUserAuthenticationRequired;
	private String	authenticationMpin;

	private String	purchaseOrderId;
	private String	purchaseOrderAction;

	public String getRequisitonId()
	{
		return requisitonId;
	}

	public void setRequisitonId(String requisitonId)
	{
		this.requisitonId = requisitonId;
	}

	public String getRequisitionAction()
	{
		return requisitionAction;
	}

	public void setRequisitionAction(String requisitionAction)
	{
		this.requisitionAction = requisitionAction;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getApiAction()
	{
		return apiAction;
	}

	public void setApiAction(String apiAction)
	{
		this.apiAction = apiAction;
	}

	public String getApiName()
	{
		return apiName;
	}

	public void setApiName(String apiName)
	{
		this.apiName = apiName;
	}

	public boolean isActionDisplayed()
	{
		return isActionDisplayed;
	}

	public void setActionDisplayed(boolean isActionDisplayed)
	{
		this.isActionDisplayed = isActionDisplayed;
	}

	public String getResponseBody()
	{
		return responseBody;
	}

	public void setResponseBody(String responseBody)
	{
		this.responseBody = responseBody;
	}

	public boolean isUserAuthenticationRequired()
	{
		return isUserAuthenticationRequired;
	}

	public void setUserAuthenticationRequired(boolean isUserAuthenticationRequired)
	{
		this.isUserAuthenticationRequired = isUserAuthenticationRequired;
	}

	public String getAuthenticationMpin()
	{
		return authenticationMpin;
	}

	public void setAuthenticationMpin(String authenticationMpin)
	{
		this.authenticationMpin = authenticationMpin;
	}

	public String getPurchaseOrderId()
	{
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId)
	{
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getPurchaseOrderAction()
	{
		return purchaseOrderAction;
	}

	public void setPurchaseOrderAction(String purchaseOrderAction)
	{
		this.purchaseOrderAction = purchaseOrderAction;
	}

}
