package com.zycus.automation.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.utilities.SupportingFunctions;

public class Requisition implements Serializable
{
	private static final long serialVersionUID = -3165901294237349967L;

	public Requisition()
	{
		setCreatedDate(SupportingFunctions.getDate());
		setActive(IConstants.ACTIVE);
	}

	private String											id;
	private String											requesterName;
	private String											reqName;
	private String											reqNo;
	private boolean											isRequired;
	private String											attactmentFile;
	private String											reasonForOrdering;
	private String											commentForSupplier;
	private String											onBehalfOf;
	private String											assignedBuyer;
	private String											purchaseType;
	private String											settlementvia;
	private String											createdDate;
	private boolean											isActive;
	private String											status;
	private boolean											result;
	private Item											items;
	private BillingRequisitionSummary						billingRequisitionSummary;
	private DeliveryRequisitionSummary						deliveryRequisitionSummary;
	private CostBookingRequisitionSummary					costBookingRequisitionSummary;
	private DeliveryItemSummary								deliveryItemSummary;
	private CostBookingItemSummary							costBookingItemSummary;
	private AccountingItemSummary							accountingItemSummary;
	private AttachmentsAndCommentsItemSummary				attachmentsAndCommentsItemSummary;
	private CustomDate										customDate;
	private String											nextAction;
	private String											pcard;
	private boolean											editHeaderLevelInfo;
	private boolean											showAllPos;
	private boolean											editItemLevelInfo;
	private boolean											modifyWorkflowSettings			= false;
	private boolean											verifyWorkflow					= false;
	private String											totalPrice						= null;
	private boolean											overrideGlAccount				= false;
	private boolean											isChangeMultiple				= false;
	private ChangeMultiple									changeMultiple					= new ChangeMultiple();
	private String											poNo							= null;
	private List<PurchaseOrder>								purchaseOrdersList				= new ArrayList<PurchaseOrder>();
	private String											approver						= null;
	private boolean											editCOAInfo						= false;

	private boolean											editMiscellaneous				= false;

	private String											coaAction;
	private List<CostBookingAndAccountingItemSummaryCOA>	coaDataList						= new ArrayList<CostBookingAndAccountingItemSummaryCOA>();

	private CostBookingAndAccountingItemSummaryCOA			itemSummaryCoa;

	private boolean											isVerificationRequiredOnPO		= false;

	private String											recallRequisitionVia			= null;
	private String											assignedBuyerGroup				= null;

	//Client Specific: SAWater
	private String											sharePointURL_eForm				= null;
	private String											internalDeliveryLocation_eForm	= null;
	private String											deliveryInstruction_eForm		= null;
	private String											estimatedFreight_eForm			= null;
	private String											purchasingInstructions_eForm	= null;
	private boolean											isExternalAgentAvailable		= false;
	private String											requisitionExternalId			= null;

	//QTS eForm fields
	private String											isThePurchaseBudgeted			= null;
	private String											whatIsPurchasedandWHY			= null;
	private String											isPurchasedBefore				= null;
	private String											isPriceIncrease					= null;
	private String											isAdditionalSavings				= null;
	private String											SavingsAchieved					= null;

	private boolean											retrospectivePurchase			= false;

	public String getApprover()
	{
		return approver;
	}

	public void setApprover(String approver)
	{
		this.approver = approver;
	}

	public void setPurchaseOrdersList(List<PurchaseOrder> purchaseOrdersList)
	{
		this.purchaseOrdersList = purchaseOrdersList;
	}

	public List<PurchaseOrder> getPurchaseOrdersList()
	{
		return purchaseOrdersList;
	}

	public String getPoNo()
	{
		return poNo;
	}

	public void setPoNo(String poNo)
	{
		this.poNo = poNo;
	}

	public boolean isChangeMultiple()
	{
		return isChangeMultiple;
	}

	public void setChangeMultiple(boolean isChangeMultiple)
	{
		this.isChangeMultiple = isChangeMultiple;
	}

	public ChangeMultiple getChangeMultiple()
	{
		return changeMultiple;
	}

	public void setChangeMultiple(ChangeMultiple changeMultiple)
	{
		this.changeMultiple = changeMultiple;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public boolean isVerificationRequiredOnPO()
	{
		return isVerificationRequiredOnPO;
	}

	public void setVerificationRequiredOnPO(boolean isVerificationRequiredOnPO)
	{
		this.isVerificationRequiredOnPO = isVerificationRequiredOnPO;
	}

	public boolean isOverrideGlAccount()
	{
		return overrideGlAccount;
	}

	public void setOverrideGlAccount(boolean overrideGlAccount)
	{
		this.overrideGlAccount = overrideGlAccount;
	}

	public String getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public boolean isModifyWorkflowSettings()
	{
		return modifyWorkflowSettings;
	}

	public void setModifyWorkflowSettings(boolean modifyWorkflowSettings)
	{
		this.modifyWorkflowSettings = modifyWorkflowSettings;
	}

	public boolean isEditItemLevelInfo()
	{
		return editItemLevelInfo;
	}

	public boolean isShowAllPos()
	{
		return showAllPos;
	}

	public void setShowAllPos(boolean showAllPos)
	{
		this.showAllPos = showAllPos;
	}

	public void setEditItemLevelInfo(boolean editItemLevelInfo)
	{
		this.editItemLevelInfo = editItemLevelInfo;
	}

	public boolean isEditHeaderLevelInfo()
	{
		return editHeaderLevelInfo;
	}

	public void setEditHeaderLevelInfo(boolean editHeaderLevelInfo)
	{
		this.editHeaderLevelInfo = editHeaderLevelInfo;
	}

	public String getPcard()
	{
		return pcard;
	}

	public void setPcard(String pcard)
	{
		this.pcard = pcard;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public CustomDate getCustomDate()
	{
		return customDate;
	}

	public void setCustomDate(CustomDate customDate)
	{
		this.customDate = customDate;
	}

	public BillingRequisitionSummary getBillingRequisitionSummary()
	{
		return billingRequisitionSummary;
	}

	public void setBillingRequisitionSummary(BillingRequisitionSummary billingRequisitionSummary)
	{
		this.billingRequisitionSummary = billingRequisitionSummary;
	}

	public DeliveryRequisitionSummary getDeliveryRequisitionSummary()
	{
		return deliveryRequisitionSummary;
	}

	public void setDeliveryRequisitionSummary(DeliveryRequisitionSummary deliveryRequisitionSummary)
	{
		this.deliveryRequisitionSummary = deliveryRequisitionSummary;
	}

	public CostBookingRequisitionSummary getCostBookingRequisitionSummary()
	{
		return costBookingRequisitionSummary;
	}

	public void setCostBookingRequisitionSummary(CostBookingRequisitionSummary costBookingRequisitionSummary)
	{
		this.costBookingRequisitionSummary = costBookingRequisitionSummary;
	}

	public DeliveryItemSummary getDeliveryItemSummary()
	{
		return deliveryItemSummary;
	}

	public void setDeliveryItemSummary(DeliveryItemSummary deliveryItemSummary)
	{
		this.deliveryItemSummary = deliveryItemSummary;
	}

	public CostBookingItemSummary getCostBookingItemSummary()
	{
		return costBookingItemSummary;
	}

	public void setCostBookingItemSummary(CostBookingItemSummary costBookingItemSummary)
	{
		this.costBookingItemSummary = costBookingItemSummary;
	}

	public AccountingItemSummary getAccountingItemSummary()
	{
		return accountingItemSummary;
	}

	public void setAccountingItemSummary(AccountingItemSummary accountingItemSummary)
	{
		this.accountingItemSummary = accountingItemSummary;
	}

	public AttachmentsAndCommentsItemSummary getAttachmentsAndCommentsItemSummary()
	{
		return attachmentsAndCommentsItemSummary;
	}

	public void setAttachmentsAndCommentsItemSummary(AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary)
	{
		this.attachmentsAndCommentsItemSummary = attachmentsAndCommentsItemSummary;
	}

	public final String getId()
	{
		return id;
	}

	public final void setId(String id)
	{
		this.id = id;
	}

	public final String getRequesterName()
	{
		return requesterName;
	}

	public final void setRequesterName(String requesterName)
	{
		this.requesterName = requesterName;
	}

	public final String getReqName()
	{
		return reqName;
	}

	public final void setReqName(String reqName)
	{
		this.reqName = reqName;
	}

	public final String getReqNo()
	{
		return reqNo;
	}

	public final void setReqNo(String reqNo)
	{
		this.reqNo = reqNo;
	}

	public final boolean isRequired()
	{
		return isRequired;
	}

	public final void setRequired(boolean isRequired)
	{
		this.isRequired = isRequired;
	}

	public final String getAttactmentFile()
	{
		return attactmentFile;
	}

	public final void setAttactmentFile(String attactmentFile)
	{
		this.attactmentFile = attactmentFile;
	}

	public final String getReasonForOrdering()
	{
		return reasonForOrdering;
	}

	public final void setReasonForOrdering(String reasonForOrdering)
	{
		this.reasonForOrdering = reasonForOrdering;
	}

	public final String getCommentForSupplier()
	{
		return commentForSupplier;
	}

	public final void setCommentForSupplier(String commentForSupplier)
	{
		this.commentForSupplier = commentForSupplier;
	}

	public final String getOnBehalfOf()
	{
		return onBehalfOf;
	}

	public final void setOnBehalfOf(String onBehalfOf)
	{
		this.onBehalfOf = onBehalfOf;
	}

	public final String getAssignedBuyer()
	{
		return assignedBuyer;
	}

	public final void setAssignedBuyer(String assignedBuyer)
	{
		this.assignedBuyer = assignedBuyer;
	}

	public final String getPurchaseType()
	{
		return purchaseType;
	}

	public final void setPurchaseType(String purchaseType)
	{
		this.purchaseType = purchaseType;
	}

	public final String getSettlementvia()
	{
		return settlementvia;
	}

	public final void setSettlementvia(String settlementvia)
	{
		this.settlementvia = settlementvia;
	}

	public final String getCreatedDate()
	{
		return createdDate;
	}

	public final void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}

	public final boolean isActive()
	{
		return isActive;
	}

	public final void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public final Item getItems()
	{
		return items;
	}

	public final void setItems(Item items)
	{
		this.items = items;
	}

	public final boolean isResult()
	{
		return result;
	}

	public final void setResult(boolean result)
	{
		this.result = result;
	}

	public boolean isEditCOAInfo()
	{
		return editCOAInfo;
	}

	public void setEditCOAInfo(boolean editCOAInfo)
	{
		this.editCOAInfo = editCOAInfo;
	}

	public CostBookingAndAccountingItemSummaryCOA getItemSummaryCoa()
	{
		return itemSummaryCoa;
	}

	public void setItemSummaryCoa(CostBookingAndAccountingItemSummaryCOA itemSummaryCoa)
	{
		this.itemSummaryCoa = itemSummaryCoa;
	}

	public List<CostBookingAndAccountingItemSummaryCOA> getCoaDataList()
	{
		return coaDataList;
	}

	public void setCoaDataList(List<CostBookingAndAccountingItemSummaryCOA> coaDataList)
	{
		this.coaDataList = coaDataList;
	}

	/*@Override
	public String toString()
	{
		return "Requisition [id=" + id + ", requesterName=" + requesterName + ", reqName=" + reqName + ", reqNo=" + reqNo + ", isRequired=" + isRequired + ", attactmentFile="
			+ attactmentFile + ", reasonForOrdering=" + reasonForOrdering + ", commentForSupplier=" + commentForSupplier + ", onBehalfOf=" + onBehalfOf + ", assignedBuyer="
			+ assignedBuyer + ", purchaseType=" + purchaseType + ", settlementvia=" + settlementvia + ", createdDate=" + createdDate + ", isActive=" + isActive + ", result="
			+ result + ", items=" + items + ", billingRequisitionSummary=" + billingRequisitionSummary + ", deliveryRequisitionSummary=" + deliveryRequisitionSummary
			+ ", costBookingRequisitionSummary=" + costBookingRequisitionSummary + ", deliveryItemSummary=" + deliveryItemSummary + ", costBookingItemSummary="
			+ costBookingItemSummary + ", accountingItemSummary=" + accountingItemSummary + ", attachmentsAndCommentsItemSummary=" + attachmentsAndCommentsItemSummary
			+ ", customDate=" + customDate + ", nextAction=" + nextAction + ", pcard=" + pcard + ", editHeaderLevelInfo=" + editHeaderLevelInfo + ", editItemLevelInfo="
			+ editItemLevelInfo + ", modifyWorkflowSettings=" + modifyWorkflowSettings + "]";
	}*/

	@Override
	public String toString()
	{
		return "Requisition [id=" + id + ", requesterName=" + requesterName + ", reqName=" + reqName + ", reqNo=" + reqNo + ", isRequired=" + isRequired + ", attactmentFile="
			+ attactmentFile + ", reasonForOrdering=" + reasonForOrdering + ", commentForSupplier=" + commentForSupplier + ", onBehalfOf=" + onBehalfOf + ", assignedBuyer="
			+ assignedBuyer + ", purchaseType=" + purchaseType + ", settlementvia=" + settlementvia + ", createdDate=" + createdDate + ", isActive=" + isActive + ", status="
			+ status + ", result=" + result + ", items=" + items + ", billingRequisitionSummary=" + billingRequisitionSummary + ", deliveryRequisitionSummary="
			+ deliveryRequisitionSummary + ", costBookingRequisitionSummary=" + costBookingRequisitionSummary + ", deliveryItemSummary=" + deliveryItemSummary
			+ ", costBookingItemSummary=" + costBookingItemSummary + ", accountingItemSummary=" + accountingItemSummary + ", attachmentsAndCommentsItemSummary="
			+ attachmentsAndCommentsItemSummary + ", customDate=" + customDate + ", nextAction=" + nextAction + ", pcard=" + pcard + ", editHeaderLevelInfo=" + editHeaderLevelInfo
			+ ", showAllPos=" + showAllPos + ", editItemLevelInfo=" + editItemLevelInfo + ", modifyWorkflowSettings=" + modifyWorkflowSettings + ", verifyWorkflow="
			+ verifyWorkflow + ", totalPrice=" + totalPrice + ", overrideGlAccount=" + overrideGlAccount + ", isChangeMultiple=" + isChangeMultiple + ", changeMultiple="
			+ changeMultiple + ", poNo=" + poNo + ", purchaseOrdersList=" + purchaseOrdersList + ", approver=" + approver + ", editCOAInfo=" + editCOAInfo + ", editMiscellaneous="
			+ editMiscellaneous + ", coaAction=" + coaAction + ", coaDataList=" + coaDataList + ", itemSummaryCoa=" + itemSummaryCoa + ", isVerificationRequiredOnPO="
			+ isVerificationRequiredOnPO + ", recallRequisitionVia=" + recallRequisitionVia + ", assignedBuyerGroup=" + assignedBuyerGroup + ", sharePointURL_eForm="
			+ sharePointURL_eForm + ", internalDeliveryLocation_eForm=" + internalDeliveryLocation_eForm + ", deliveryInstruction_eForm=" + deliveryInstruction_eForm
			+ ", estimatedFreight_eForm=" + estimatedFreight_eForm + ", purchasingInstructions_eForm=" + purchasingInstructions_eForm + ", isExternalAgentAvailable="
			+ isExternalAgentAvailable + ", requisitionExternalId=" + requisitionExternalId + ", isThePurchaseBudgeted=" + isThePurchaseBudgeted + ", whatIsPurchasedandWHY="
			+ whatIsPurchasedandWHY + ", isPurchasedBefore=" + isPurchasedBefore + ", isPriceIncrease=" + isPriceIncrease + ", isAdditionalSavings=" + isAdditionalSavings
			+ ", SavingsAchieved=" + SavingsAchieved + ", retrospectivePurchase=" + retrospectivePurchase + "]";
	}

	public String getCoaAction()
	{
		return coaAction;
	}

	public void setCoaAction(String coaAction)
	{
		this.coaAction = coaAction;
	}

	public boolean isVerifyWorkflow()
	{
		return verifyWorkflow;
	}

	public void setVerifyWorkflow(boolean verifyWorkflow)
	{
		this.verifyWorkflow = verifyWorkflow;
	}

	public boolean isEditMiscellaneous()
	{
		return editMiscellaneous;
	}

	public void setEditMiscellaneous(boolean editMiscellaneous)
	{
		this.editMiscellaneous = editMiscellaneous;
	}

	public String getIsThePurchaseBudgeted()
	{
		return isThePurchaseBudgeted;
	}

	public void setIsThePurchaseBudgeted(String isThePurchaseBudgeted)
	{
		this.isThePurchaseBudgeted = isThePurchaseBudgeted;
	}

	public String getWhatIsPurchasedandWHY()
	{
		return whatIsPurchasedandWHY;
	}

	public void setWhatIsPurchasedandWHY(String whatIsPurchasedandWHY)
	{
		this.whatIsPurchasedandWHY = whatIsPurchasedandWHY;
	}

	public String getIsPurchasedBefore()
	{
		return isPurchasedBefore;
	}

	public void setIsPurchasedBefore(String isPurchasedBefore)
	{
		this.isPurchasedBefore = isPurchasedBefore;
	}

	public String getIsPriceIncrease()
	{
		return isPriceIncrease;
	}

	public void setIsPriceIncrease(String isPriceIncrease)
	{
		this.isPriceIncrease = isPriceIncrease;
	}

	public String getIsAdditionalSavings()
	{
		return isAdditionalSavings;
	}

	public void setIsAdditionalSavings(String isAdditionalSavings)
	{
		this.isAdditionalSavings = isAdditionalSavings;
	}

	public String getSavingsAchieved()
	{
		return SavingsAchieved;
	}

	public void setSavingsAchieved(String savingsAchieved)
	{
		SavingsAchieved = savingsAchieved;
	}

	public String getSharePointURL_eForm()
	{
		return sharePointURL_eForm;
	}

	public void setSharePointURL_eForm(String sharePointURL_eForm)
	{
		this.sharePointURL_eForm = sharePointURL_eForm;
	}

	public String getInternalDeliveryLocation_eForm()
	{
		return internalDeliveryLocation_eForm;
	}

	public void setInternalDeliveryLocation_eForm(String internalDeliveryLocation_eForm)
	{
		this.internalDeliveryLocation_eForm = internalDeliveryLocation_eForm;
	}

	public String getDeliveryInstruction_eForm()
	{
		return deliveryInstruction_eForm;
	}

	public void setDeliveryInstruction_eForm(String deliveryInstruction_eForm)
	{
		this.deliveryInstruction_eForm = deliveryInstruction_eForm;
	}

	public String getEstimatedFreight_eForm()
	{
		return estimatedFreight_eForm;
	}

	public void setEstimatedFreight_eForm(String estimatedFreight_eForm)
	{
		this.estimatedFreight_eForm = estimatedFreight_eForm;
	}

	public String getPurchasingInstructions_eForm()
	{
		return purchasingInstructions_eForm;
	}

	public void setPurchasingInstructions_eForm(String purchasingInstructions_eForm)
	{
		this.purchasingInstructions_eForm = purchasingInstructions_eForm;
	}

	public boolean isExternalAgentAvailable()
	{
		return isExternalAgentAvailable;
	}

	public void setExternalAgentAvailable(boolean isExternalAgentAvailable)
	{
		this.isExternalAgentAvailable = isExternalAgentAvailable;
	}

	public String getRequisitionExternalId()
	{
		return requisitionExternalId;
	}

	public void setRequisitionExternalId(String requisitionExternalId)
	{
		this.requisitionExternalId = requisitionExternalId;
	}

	public String getAssignedBuyerGroup()
	{
		return assignedBuyerGroup;
	}

	public void setAssignedBuyerGroup(String assignedBuyerGroup)
	{
		this.assignedBuyerGroup = assignedBuyerGroup;
	}

	public String getRecallRequisitionVia()
	{
		return recallRequisitionVia;
	}

	public void setRecallRequisitionVia(String recallRequisitionVia)
	{
		this.recallRequisitionVia = recallRequisitionVia;

	}

	public boolean isRetrospectivePurchase()
	{
		return retrospectivePurchase;
	}

	public void setRetrospectivePurchase(boolean retrospectivePurchase)
	{
		this.retrospectivePurchase = retrospectivePurchase;
	}

}
