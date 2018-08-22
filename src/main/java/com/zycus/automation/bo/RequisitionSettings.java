/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class RequisitionSettings
{

	private String	reqNumberFormat;
	private int		reqNoStartsAt							= 0;
	private int		reqNoEndsAt								= 0;
	private String	reqNameFormat;
	private String	mostFrequentlySearchedItems;
	private int		itemQuantityThreshold					= 0;
	private String	allowRequetserToOrderFreeTextItemsType;
	private String	allowFreeTextItemsRequestedWithoutSelectingCategoryOption;
	private String	allowReqToBeSubmittedWithoutRequiredByDateOption;
	private String	allowBuyerToModifyRequiredByDateOption;
	private String	allowReqToBeSubmittedWithoutCostCenterInfoOption;
	private String	allowBuyerToModifyCostCenterInfoOption;
	private String	displayAccountingInfoToRequesterOption;
	private String	requesterIsRequiredToProvideAccountingInfoOption;
	private String	allowRequesterToOverrideDefaultGLAccountOption;
	private String	requesterRequiredToAssignBuyerOption;
	private String	applyCategoryBasedWorkflowOption;
	private boolean	enableReqForking						= false;
	private boolean	forReqByCategory						= false;
	private boolean	forReqBySourcingStatus					= false;
	private boolean	result;
	private boolean	addDisbursementAsSettlementViaOption	= false;
	private boolean	sendPOToSupplier						= false;
	private boolean	quotedBySupplier_SourcingStatus			= true;
	private boolean	estimatedPrice_SourcingStatus			= true;
	private boolean	needAQuote_SourcingStatus				= true;

	public boolean isQuotedBySupplier_SourcingStatus()
	{
		return quotedBySupplier_SourcingStatus;
	}

	public void setQuotedBySupplier_SourcingStatus(boolean quotedBySupplier_SourcingStatus)
	{
		this.quotedBySupplier_SourcingStatus = quotedBySupplier_SourcingStatus;
	}

	public boolean isEstimatedPrice_SourcingStatus()
	{
		return estimatedPrice_SourcingStatus;
	}

	public void setEstimatedPrice_SourcingStatus(boolean estimatedPrice_SourcingStatus)
	{
		this.estimatedPrice_SourcingStatus = estimatedPrice_SourcingStatus;
	}

	public boolean isNeedAQuote_SourcingStatus()
	{
		return needAQuote_SourcingStatus;
	}

	public void setNeedAQuote_SourcingStatus(boolean needAQuote_SourcingStatus)
	{
		this.needAQuote_SourcingStatus = needAQuote_SourcingStatus;
	}

	public boolean isAddDisbursementAsSettlementViaOption()
	{
		return addDisbursementAsSettlementViaOption;
	}

	public void setAddDisbursementAsSettlementViaOption(boolean addDisbursementAsSettlementViaOption)
	{
		this.addDisbursementAsSettlementViaOption = addDisbursementAsSettlementViaOption;
	}

	public boolean isSendPOToSupplier()
	{
		return sendPOToSupplier;
	}

	public void setSendPOToSupplier(boolean sendPOToSupplier)
	{
		this.sendPOToSupplier = sendPOToSupplier;
	}

	public boolean isEnableReqForking()
	{
		return enableReqForking;
	}

	public void setEnableReqForking(boolean enableReqForking)
	{
		this.enableReqForking = enableReqForking;
	}

	public boolean isForReqByCategory()
	{
		return forReqByCategory;
	}

	public void setForReqByCategory(boolean forReqByCategory)
	{
		this.forReqByCategory = forReqByCategory;
	}

	public boolean isForReqBySourcingStatus()
	{
		return forReqBySourcingStatus;
	}

	public void setForReqBySourcingStatus(boolean forReqBySourcingStatus)
	{
		this.forReqBySourcingStatus = forReqBySourcingStatus;
	}

	public void setEnableRequisitionForkingOption(boolean enableRequisitionForkingOption)
	{
	}

	public String getReqNumberFormat()
	{
		return reqNumberFormat;
	}

	public void setReqNumberFormat(String reqNumberFormat)
	{
		this.reqNumberFormat = reqNumberFormat;
	}

	public int getReqNoStartsAt()
	{
		return reqNoStartsAt;
	}

	public void setReqNoStartsAt(int reqNoStartsAt)
	{
		this.reqNoStartsAt = reqNoStartsAt;
	}

	public int getReqNoEndsAt()
	{
		return reqNoEndsAt;
	}

	public void setReqNoEndsAt(int reqNoEndsAt)
	{
		this.reqNoEndsAt = reqNoEndsAt;
	}

	public String getReqNameFormat()
	{
		return reqNameFormat;
	}

	public void setReqNameFormat(String reqNameFormat)
	{
		this.reqNameFormat = reqNameFormat;
	}

	public String getMostFrequentlySearchedItems()
	{
		return mostFrequentlySearchedItems;
	}

	public void setMostFrequentlySearchedItems(String mostFrequentlySearchedItems)
	{
		this.mostFrequentlySearchedItems = mostFrequentlySearchedItems;
	}

	public int getItemQuantityThreshold()
	{
		return itemQuantityThreshold;
	}

	public void setItemQuantityThreshold(int itemQuantityThreshold)
	{
		this.itemQuantityThreshold = itemQuantityThreshold;
	}

	public String getAllowRequetserToOrderFreeTextItemsType()
	{
		return allowRequetserToOrderFreeTextItemsType;
	}

	public void setAllowRequetserToOrderFreeTextItemsType(String allowRequetserToOrderFreeTextItemsType)
	{
		this.allowRequetserToOrderFreeTextItemsType = allowRequetserToOrderFreeTextItemsType;
	}

	public String getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption()
	{
		return allowFreeTextItemsRequestedWithoutSelectingCategoryOption;
	}

	public void setAllowFreeTextItemsRequestedWithoutSelectingCategoryOption(String allowFreeTextItemsRequestedWithoutSelectingCategoryOption)
	{
		this.allowFreeTextItemsRequestedWithoutSelectingCategoryOption = allowFreeTextItemsRequestedWithoutSelectingCategoryOption;
	}

	public String getAllowReqToBeSubmittedWithoutRequiredByDateOption()
	{
		return allowReqToBeSubmittedWithoutRequiredByDateOption;
	}

	public void setAllowReqToBeSubmittedWithoutRequiredByDateOption(String allowReqToBeSubmittedWithoutRequiredByDateOption)
	{
		this.allowReqToBeSubmittedWithoutRequiredByDateOption = allowReqToBeSubmittedWithoutRequiredByDateOption;
	}

	public String getAllowBuyerToModifyRequiredByDateOption()
	{
		return allowBuyerToModifyRequiredByDateOption;
	}

	public void setAllowBuyerToModifyRequiredByDateOption(String allowBuyerToModifyRequiredByDateOption)
	{
		this.allowBuyerToModifyRequiredByDateOption = allowBuyerToModifyRequiredByDateOption;
	}

	public String getAllowReqToBeSubmittedWithoutCostCenterInfoOption()
	{
		return allowReqToBeSubmittedWithoutCostCenterInfoOption;
	}

	public void setAllowReqToBeSubmittedWithoutCostCenterInfoOption(String allowReqToBeSubmittedWithoutCostCenterInfoOption)
	{
		this.allowReqToBeSubmittedWithoutCostCenterInfoOption = allowReqToBeSubmittedWithoutCostCenterInfoOption;
	}

	public String getAllowBuyerToModifyCostCenterInfoOption()
	{
		return allowBuyerToModifyCostCenterInfoOption;
	}

	public void setAllowBuyerToModifyCostCenterInfoOption(String allowBuyerToModifyCostCenterInfoOption)
	{
		this.allowBuyerToModifyCostCenterInfoOption = allowBuyerToModifyCostCenterInfoOption;
	}

	public String getDisplayAccountingInfoToRequesterOption()
	{
		return displayAccountingInfoToRequesterOption;
	}

	public void setDisplayAccountingInfoToRequesterOption(String displayAccountingInfoToRequesterOption)
	{
		this.displayAccountingInfoToRequesterOption = displayAccountingInfoToRequesterOption;
	}

	public String getRequesterIsRequiredToProvideAccountingInfoOption()
	{
		return requesterIsRequiredToProvideAccountingInfoOption;
	}

	public void setRequesterIsRequiredToProvideAccountingInfoOption(String requesterIsRequiredToProvideAccountingInfoOption)
	{
		this.requesterIsRequiredToProvideAccountingInfoOption = requesterIsRequiredToProvideAccountingInfoOption;
	}

	public String getAllowRequesterToOverrideDefaultGLAccountOption()
	{
		return allowRequesterToOverrideDefaultGLAccountOption;
	}

	public void setAllowRequesterToOverrideDefaultGLAccountOption(String allowRequesterToOverrideDefaultGLAccountOption)
	{
		this.allowRequesterToOverrideDefaultGLAccountOption = allowRequesterToOverrideDefaultGLAccountOption;
	}

	public String getRequesterRequiredToAssignBuyerOption()
	{
		return requesterRequiredToAssignBuyerOption;
	}

	public void setRequesterRequiredToAssignBuyerOption(String requesterRequiredToAssignBuyerOption)
	{
		this.requesterRequiredToAssignBuyerOption = requesterRequiredToAssignBuyerOption;
	}

	public String getApplyCategoryBasedWorkflowOption()
	{
		return applyCategoryBasedWorkflowOption;
	}

	public void setApplyCategoryBasedWorkflowOption(String applyCategoryBasedWorkflowOption)
	{
		this.applyCategoryBasedWorkflowOption = applyCategoryBasedWorkflowOption;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

}
