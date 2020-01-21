package eProc.bo;

import java.util.List;
import java.util.Map;

public class RequisitionBO
{


    private int noOfItem;


    private String itemType;

    private String[] CoaDataType;
    private int noOfCoaSplit;
    private String splitBy;


    private String requesterName;
    private String reqName;
    private boolean urgentRequirement;


    private String reqNo;
    private boolean isRequired;
    private String attactmentFile;
    private String reasonForOrdering;
    private String commentForSupplier;
    private String onBehalfOf;
    private String settleMentVia;
    private String assignedBuyer;
    private String purchaseType;
    private String settlementvia;
    private String createdDate;
    private boolean isActive;
    private String status;
    private boolean result;
    private boolean buyingUnit;

    //for catalog item;
    private List<CatalogItemBO> catalogItemList;
    //For guided Item;
    //private List<GuidedItemBO> guidedItemList;
    //Billing requisition summary;

    private String reqCurrency;
    private String reqCompany;
    private String reqbBusinessUnit;
    private String reqLocation;
    private String reqBilllingNextAction;
    private String reqDeliveryAddress;
    private String reqBillToAddress;
    private String reqDeliveryAddressCode;
    private String reqBillToAddressCode;


    //Delivery requisition summary;
    private String reqDeliverTo;
    private boolean reqDefaultAddressOption;
    private boolean reqOtherAddressesOption;
    private boolean reqMyAddressOption;


    private String reqOtherAddresses;
    private String reqDefaultDeliveryAddress;
    private String reqMyAddress_Name;
    private String reqMyAddress_Street1;
    private String reqMyAddress_Street2;
    private String reqMyAddress_city;
    private String reqMyAddress_country;
    private String reqMyAddress_state;
    private int reqMyAddress_zip;
    private String reqDeliveryNextAction;

    //Cost Booking Requisition Summary;
    private String reqAssignedCost;
    private boolean reqBookCostToSingleCostCenter;
    private boolean reqSplitCostToMultipleCostCenter;
    private boolean reqSplitCostAtLineItemLevel;
    private String reqCostCenter;
    private String reqBudget;
    private String reqProject;
    private String reqGlAccount = null;
    private String reqCostBookingNextAction;


    //Delivery Item Summary;
    //Keeping it null;
    //Cost Booking item summary;
    private boolean splitCostCenterAtItemLevel;


    private boolean splitCostCenterAtItemLevel_percentage;
    private boolean splitCostCenterAtItemLevel_quantity;
    private String costBookingItemNextAction;
    private String costBookingItemGlAccountType;
    private String costBookingItemGlAccount;
    private String costBookingItemAssetCode;
    private String pcard;
    private boolean isRetrospectivePurchase;
    private boolean budgetUtilization;

    //Accounting Item Summary;
    private String accountingItemGlAccountType;
    private String accountingItemGlAccount;
    private String accountingItemNextAction;
    private String accountingItemAssetCode;
    private boolean editHeaderLevelInfo;
    private boolean showAllPos;
    private boolean editItemLevelInfo;
    private boolean modifyWorkflowSettings = false;
    private boolean verifyWorkflow = false;
    private String totalPrice = null;
    private boolean overrideGlAccount = false;
    private boolean isChangeMultiple = false;

    private String approver = null;
    private boolean editCOAInfo = false;

    private boolean editMiscellaneous = false;

    private String reqNextAction;

    //Select via;
    private boolean selectViaInvoice;
    private boolean selectViaUserPCard;
    private boolean selectViaDisburesement;
    private String selectPurchaseOrder;

    //attachment file;
    private String attachmentFile;
    private String requiredBy =null;
   /* private List<VirtualItemBO> virtualItemList;
    private List<NonStockItemBO> nonStockItemList;
    private List<StockItemBO> stockItemList;*/

    //shipping and Asset tagging details;
    private boolean isAssetTagging = false;
    private String assetNumber;
    private String manufacturerNumber;
    private String notes;

    private List<String> attachmentsList;

    private String reqPoNumber;

    private String sendToApproval;
    private String returnToMe;

    private Map<String,List<String>> assetTagDetails;

    private String assignedBuyerGroup;


    //Cost Allocation;
    private boolean isBookCostToSingleCostCenter;
    private boolean isBookCostAtLineItemLevel;

    private String CostCenter;
    private String Project;
    private String Budget;

    private String assignCost;
    private String allowBudget;

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }

    public String getCostCenter() {
        return CostCenter;
    }

    public void setCostCenter(String costCenter) {
        CostCenter = costCenter;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public Map<String, List<String>> getAssetTagDetails() {
        return assetTagDetails;
    }

    public void setAssetTagDetails(Map<String, List<String>> assetTagDetails) {
        this.assetTagDetails = assetTagDetails;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getManufacturerNumber() {
        return manufacturerNumber;
    }

    public void setManufacturerNumber(String manufacturerNumber) {
        this.manufacturerNumber = manufacturerNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isAssetTagging() {
        return isAssetTagging;
    }

    public void setAssetTagging(boolean isAssetTagging) {
        this.isAssetTagging = isAssetTagging;
    }


    /*public List<StockItemBO> getStockItemList() {
        return stockItemList;
    }

    public void setStockItemList(List<StockItemBO> stockItemList) {
        this.stockItemList = stockItemList;
    }*/

    private String poNextAction = null;


    public String getSettleMentVia() {
        return settleMentVia;
    }

    public void setSettleMentVia(String settleMentVia) {
        this.settleMentVia = settleMentVia;
    }


    public boolean isReqDefaultAddressOption() {
        return reqDefaultAddressOption;
    }

    public void setReqDefaultAddressOption(boolean reqDefaultAddressOption) {
        this.reqDefaultAddressOption = reqDefaultAddressOption;
    }

    public String getReqDefaultDeliveryAddress() {
        return reqDefaultDeliveryAddress;
    }

    public void setReqDefaultDeliveryAddress(String reqDefaultDeliveryAddress) {
        this.reqDefaultDeliveryAddress = reqDefaultDeliveryAddress;
    }

    public boolean isBookCostToSingleCostCenter() {
        return isBookCostToSingleCostCenter;
    }

    public void setBookCostToSingleCostCenter(boolean isBookCostToSingleCostCenter) {
        this.isBookCostToSingleCostCenter = isBookCostToSingleCostCenter;
    }

    public boolean isBookCostAtLineItemLevel() {
        return isBookCostAtLineItemLevel;
    }

    public void setBookCostAtLineItemLevel(boolean isBookCostAtLineItemLevel) {
        this.isBookCostAtLineItemLevel = isBookCostAtLineItemLevel;
    }



    public String getRequiredBy() {
        return requiredBy;
    }

    public void setRequiredBy(String requiredBy) {
        this.requiredBy = requiredBy;
    }

    public boolean isBuyingUnit() {
        return buyingUnit;
    }

    public void setBuyingUnit(boolean buyingUnit) {
        this.buyingUnit = buyingUnit;
    }

    public String getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(String attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

    public String getSelectPurchaseOrder() {
        return selectPurchaseOrder;
    }

    public void setSelectPurchaseOrder(String selectPurchaseOrder) {
        this.selectPurchaseOrder = selectPurchaseOrder;
    }

    public boolean isSelectViaInvoice() {
        return selectViaInvoice;
    }

    public void setSelectViaInvoice(boolean selectViaInvoice) {
        this.selectViaInvoice = selectViaInvoice;
    }

    public boolean isSelectViaUserPCard() {
        return selectViaUserPCard;
    }

    public void setSelectViaUserPCard(boolean selectViaUserPCard) {
        this.selectViaUserPCard = selectViaUserPCard;
    }


    public boolean isSelectViaDisburesement() {
        return selectViaDisburesement;
    }

    public void setSelectViaDisburesement(boolean selectViaDisburesement) {
        this.selectViaDisburesement = selectViaDisburesement;
    }

    public int getNoOfItem()
    {
        return noOfItem;
    }

    public void setNoOfItem(int noOfItem)
    {
        this.noOfItem = noOfItem;
    }

    public String getItemType()
    {
        return itemType;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }


    public boolean isRetrospectivePurchase()
    {
        return isRetrospectivePurchase;
    }

    public void setRetrospectivePurchase(boolean retrospectivePurchase)
    {
        isRetrospectivePurchase = retrospectivePurchase;
    }

    public boolean isBudgetUtilization()
    {
        return budgetUtilization;
    }

    public void setBudgetUtilization(boolean budgetUtilization)
    {
        this.budgetUtilization = budgetUtilization;
    }

    public String getRequesterName()
    {
        return requesterName;
    }

    public void setRequesterName(String requesterName)
    {
        this.requesterName = requesterName;
    }

    public String getPcard()
    {
        return pcard;
    }

    public void setPcard(String pcard)
    {
        this.pcard = pcard;
    }


    public String getReqName()
    {
        return reqName;
    }

    public void setReqName(String reqName)
    {
        this.reqName = reqName;
    }

    public boolean isUrgentRequirement()
    {
        return urgentRequirement;
    }

    public void setUrgentRequirement(boolean urgentRequirement)
    {
        this.urgentRequirement = urgentRequirement;
    }

    public String getReqNo()
    {
        return reqNo;
    }

    public void setReqNo(String reqNo)
    {
        this.reqNo = reqNo;
    }

    public boolean isRequired()
    {
        return isRequired;
    }

    public void setRequired(boolean required)
    {
        isRequired = required;
    }

    public String getAttactmentFile()
    {
        return attactmentFile;
    }

    public void setAttactmentFile(String attactmentFile)
    {
        this.attactmentFile = attactmentFile;
    }

    public String getReasonForOrdering()
    {
        return reasonForOrdering;
    }

    public void setReasonForOrdering(String reasonForOrdering)
    {
        this.reasonForOrdering = reasonForOrdering;
    }

    public String getCommentForSupplier()
    {
        return commentForSupplier;
    }

    public void setCommentForSupplier(String commentForSupplier)
    {
        this.commentForSupplier = commentForSupplier;
    }

    public String getOnBehalfOf()
    {
        return onBehalfOf;
    }

    public void setOnBehalfOf(String onBehalfOf)
    {
        this.onBehalfOf = onBehalfOf;
    }

    public String getAssignedBuyer()
    {
        return assignedBuyer;
    }

    public void setAssignedBuyer(String assignedBuyer)
    {
        this.assignedBuyer = assignedBuyer;
    }

    public String getPurchaseType()
    {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType)
    {
        this.purchaseType = purchaseType;
    }

    public String getSettlementvia()
    {
        return settlementvia;
    }

    public void setSettlementvia(String settlementvia)
    {
        this.settlementvia = settlementvia;
    }

    public String getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(String createdDate)
    {
        this.createdDate = createdDate;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isResult()
    {
        return result;
    }

    public void setResult(boolean result)
    {
        this.result = result;
    }

    public String getReqCurrency()
    {
        return reqCurrency;
    }

    public void setReqCurrency(String reqCurrency)
    {
        this.reqCurrency = reqCurrency;
    }

    public String getReqCompany()
    {
        return reqCompany;
    }

    public void setReqCompany(String reqCompany)
    {
        this.reqCompany = reqCompany;
    }

    public String getReqbBusinessUnit()
    {
        return reqbBusinessUnit;
    }

    public void setReqbBusinessUnit(String reqbBusinessUnit)
    {
        this.reqbBusinessUnit = reqbBusinessUnit;
    }

    public String getReqLocation()
    {
        return reqLocation;
    }

    public void setReqLocation(String reqLocation)
    {
        this.reqLocation = reqLocation;
    }

    public String getReqBilllingNextAction()
    {
        return reqBilllingNextAction;
    }

    public void setReqBilllingNextAction(String reqBilllingNextAction)
    {
        this.reqBilllingNextAction = reqBilllingNextAction;
    }

    public String getReqDeliveryAddress()
    {
        return reqDeliveryAddress;
    }

    public void setReqDeliveryAddress(String reqDeliveryAddress)
    {
        this.reqDeliveryAddress = reqDeliveryAddress;
    }

    public String getReqBillToAddress()
    {
        return reqBillToAddress;
    }

    public void setReqBillToAddress(String reqBillToAddress)
    {
        this.reqBillToAddress = reqBillToAddress;
    }

    public String getReqDeliverTo()
    {
        return reqDeliverTo;
    }

    public void setReqDeliverTo(String reqDeliverTo)
    {
        this.reqDeliverTo = reqDeliverTo;
    }

    public boolean isReqOUAddressOption()
    {
        return reqDefaultAddressOption;
    }

    public void setReqOUAddressOption(boolean reqOUAddressOption)
    {
        this.reqDefaultAddressOption = reqOUAddressOption;
    }

    public boolean isReqOtherAddressesOption()
    {
        return reqOtherAddressesOption;
    }

    public void setReqOtherAddressesOption(boolean reqOtherAddressesOption)
    {
        this.reqOtherAddressesOption = reqOtherAddressesOption;
    }

    public boolean isReqMyAddressOption()
    {
        return reqMyAddressOption;
    }

    public void setReqMyAddressOption(boolean reqMyAddressOption)
    {
        this.reqMyAddressOption = reqMyAddressOption;
    }

    public String getReqOtherAddresses()
    {
        return reqOtherAddresses;
    }

    public void setReqOtherAddresses(String reqOtherAddresses)
    {
        this.reqOtherAddresses = reqOtherAddresses;
    }

    public String getReqSelectDeliveryAddress()
    {
        return reqDefaultDeliveryAddress;
    }

    public void setReqSelectDeliveryAddress(String reqSelectDeliveryAddress)
    {
        this.reqDefaultDeliveryAddress = reqSelectDeliveryAddress;
    }

    public String getReqMyAddress_Name()
    {
        return reqMyAddress_Name;
    }

    public void setReqMyAddress_Name(String reqMyAddress_Name)
    {
        this.reqMyAddress_Name = reqMyAddress_Name;
    }

    public String getReqMyAddress_Street1()
    {
        return reqMyAddress_Street1;
    }

    public void setReqMyAddress_Street1(String reqMyAddress_Street1)
    {
        this.reqMyAddress_Street1 = reqMyAddress_Street1;
    }

    public String getReqMyAddress_Street2()
    {
        return reqMyAddress_Street2;
    }

    public void setReqMyAddress_Street2(String reqMyAddress_Street2)
    {
        this.reqMyAddress_Street2 = reqMyAddress_Street2;
    }

    public String getReqMyAddress_city()
    {
        return reqMyAddress_city;
    }

    public void setReqMyAddress_city(String reqMyAddress_city)
    {
        this.reqMyAddress_city = reqMyAddress_city;
    }

    public String getReqMyAddress_country()
    {
        return reqMyAddress_country;
    }

    public void setReqMyAddress_country(String reqMyAddress_country)
    {
        this.reqMyAddress_country = reqMyAddress_country;
    }

    public String getReqMyAddress_state()
    {
        return reqMyAddress_state;
    }

    public void setReqMyAddress_state(String reqMyAddress_state)
    {
        this.reqMyAddress_state = reqMyAddress_state;
    }

    public int getReqMyAddress_zip()
    {
        return reqMyAddress_zip;
    }

    public void setReqMyAddress_zip(int reqMyAddress_zip)
    {
        this.reqMyAddress_zip = reqMyAddress_zip;
    }

    public String getReqDeliveryNextAction()
    {
        return reqDeliveryNextAction;
    }

    public void setReqDeliveryNextAction(String reqDeliveryNextAction)
    {
        this.reqDeliveryNextAction = reqDeliveryNextAction;
    }

    public String getReqAssignedCost()
    {
        return reqAssignedCost;
    }

    public void setReqAssignedCost(String reqAssignedCost)
    {
        this.reqAssignedCost = reqAssignedCost;
    }

    public boolean isReqBookCostToSingleCostCenter()
    {
        return reqBookCostToSingleCostCenter;
    }

    public void setReqBookCostToSingleCostCenter(boolean reqBookCostToSingleCostCenter)
    {
        this.reqBookCostToSingleCostCenter = reqBookCostToSingleCostCenter;
    }

    public boolean isReqSplitCostToMultipleCostCenter()
    {
        return reqSplitCostToMultipleCostCenter;
    }

    public void setReqSplitCostToMultipleCostCenter(boolean reqSplitCostToMultipleCostCenter)
    {
        this.reqSplitCostToMultipleCostCenter = reqSplitCostToMultipleCostCenter;
    }

    public boolean isReqSplitCostAtLineItemLevel()
    {
        return reqSplitCostAtLineItemLevel;
    }

    public void setReqSplitCostAtLineItemLevel(boolean reqSplitCostAtLineItemLevel)
    {
        this.reqSplitCostAtLineItemLevel = reqSplitCostAtLineItemLevel;
    }

    public String getReqCostCenter()
    {
        return reqCostCenter;
    }

    public void setReqCostCenter(String reqCostCenter)
    {
        this.reqCostCenter = reqCostCenter;
    }

    public String getReqBudget()
    {
        return reqBudget;
    }

    public void setReqBudget(String reqBudget)
    {
        this.reqBudget = reqBudget;
    }

    public String getReqProject()
    {
        return reqProject;
    }

    public void setReqProject(String reqProject)
    {
        this.reqProject = reqProject;
    }

    public String getReqGlAccount()
    {
        return reqGlAccount;
    }

    public void setReqGlAccount(String reqGlAccount)
    {
        this.reqGlAccount = reqGlAccount;
    }

    public String getReqCostBookingNextAction()
    {
        return reqCostBookingNextAction;
    }

    public void setReqCostBookingNextAction(String reqCostBookingNextAction)
    {
        this.reqCostBookingNextAction = reqCostBookingNextAction;
    }

    public boolean isSplitCostCenterAtItemLevel()
    {
        return splitCostCenterAtItemLevel;
    }

    public void setSplitCostCenterAtItemLevel(boolean splitCostCenterAtItemLevel)
    {
        this.splitCostCenterAtItemLevel = splitCostCenterAtItemLevel;
    }

    public boolean isSplitCostCenterAtItemLevel_percentage()
    {
        return splitCostCenterAtItemLevel_percentage;
    }

    public void setSplitCostCenterAtItemLevel_percentage(boolean splitCostCenterAtItemLevel_percentage)
    {
        this.splitCostCenterAtItemLevel_percentage = splitCostCenterAtItemLevel_percentage;
    }

    public boolean isSplitCostCenterAtItemLevel_quantity()
    {
        return splitCostCenterAtItemLevel_quantity;
    }

    public void setSplitCostCenterAtItemLevel_quantity(boolean splitCostCenterAtItemLevel_quantity)
    {
        this.splitCostCenterAtItemLevel_quantity = splitCostCenterAtItemLevel_quantity;
    }

    public String getCostBookingItemNextAction()
    {
        return costBookingItemNextAction;
    }

    public void setCostBookingItemNextAction(String costBookingItemNextAction)
    {
        this.costBookingItemNextAction = costBookingItemNextAction;
    }

    public String getCostBookingItemGlAccountType()
    {
        return costBookingItemGlAccountType;
    }

    public void setCostBookingItemGlAccountType(String costBookingItemGlAccountType)
    {
        this.costBookingItemGlAccountType = costBookingItemGlAccountType;
    }

    public String getCostBookingItemGlAccount()
    {
        return costBookingItemGlAccount;
    }

    public void setCostBookingItemGlAccount(String costBookingItemGlAccount)
    {
        this.costBookingItemGlAccount = costBookingItemGlAccount;
    }

    public String getCostBookingItemAssetCode()
    {
        return costBookingItemAssetCode;
    }

    public void setCostBookingItemAssetCode(String costBookingItemAssetCode)
    {
        this.costBookingItemAssetCode = costBookingItemAssetCode;
    }

    public String getAccountingItemGlAccountType()
    {
        return accountingItemGlAccountType;
    }

    public void setAccountingItemGlAccountType(String accountingItemGlAccountType)
    {
        this.accountingItemGlAccountType = accountingItemGlAccountType;
    }

    public String getAccountingItemGlAccount()
    {
        return accountingItemGlAccount;
    }

    public void setAccountingItemGlAccount(String accountingItemGlAccount)
    {
        this.accountingItemGlAccount = accountingItemGlAccount;
    }

    public String getAccountingItemNextAction()
    {
        return accountingItemNextAction;
    }

    public void setAccountingItemNextAction(String accountingItemNextAction)
    {
        this.accountingItemNextAction = accountingItemNextAction;
    }

    public String getAccountingItemAssetCode()
    {
        return accountingItemAssetCode;
    }

    public void setAccountingItemAssetCode(String accountingItemAssetCode)
    {
        this.accountingItemAssetCode = accountingItemAssetCode;
    }

    public boolean isEditHeaderLevelInfo()
    {
        return editHeaderLevelInfo;
    }

    public void setEditHeaderLevelInfo(boolean editHeaderLevelInfo)
    {
        this.editHeaderLevelInfo = editHeaderLevelInfo;
    }

    public boolean isShowAllPos()
    {
        return showAllPos;
    }

    public void setShowAllPos(boolean showAllPos)
    {
        this.showAllPos = showAllPos;
    }

    public boolean isEditItemLevelInfo()
    {
        return editItemLevelInfo;
    }

    public void setEditItemLevelInfo(boolean editItemLevelInfo)
    {
        this.editItemLevelInfo = editItemLevelInfo;
    }

    public boolean isModifyWorkflowSettings()
    {
        return modifyWorkflowSettings;
    }
    public String[] getCoaDataType() {
        return CoaDataType;
    }

    public void setCoaDataType(String[] coaDataType) {
        CoaDataType = coaDataType;
    }

    public int getNoOfCoaSplit() {
        return noOfCoaSplit;
    }

    public void setNoOfCoaSplit(int noOfCoaSplit) {
        this.noOfCoaSplit = noOfCoaSplit;
    }

    public String getSplitBy() {
        return splitBy;
    }

    public void setSplitBy(String splitBy) {
        this.splitBy = splitBy;
    }

    public void setModifyWorkflowSettings(boolean modifyWorkflowSettings)
    {
        this.modifyWorkflowSettings = modifyWorkflowSettings;
    }

    public boolean isVerifyWorkflow()
    {
        return verifyWorkflow;
    }

    public void setVerifyWorkflow(boolean verifyWorkflow)
    {
        this.verifyWorkflow = verifyWorkflow;
    }

    public String getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public boolean isOverrideGlAccount()
    {
        return overrideGlAccount;
    }

    public void setOverrideGlAccount(boolean overrideGlAccount)
    {
        this.overrideGlAccount = overrideGlAccount;
    }

    public boolean isChangeMultiple()
    {
        return isChangeMultiple;
    }

    public void setChangeMultiple(boolean changeMultiple)
    {
        isChangeMultiple = changeMultiple;
    }

    public String getApprover()
    {
        return approver;
    }

    public void setApprover(String approver)
    {
        this.approver = approver;
    }

    public boolean isEditCOAInfo()
    {
        return editCOAInfo;
    }

    public void setEditCOAInfo(boolean editCOAInfo)
    {
        this.editCOAInfo = editCOAInfo;
    }

    public boolean isEditMiscellaneous()
    {
        return editMiscellaneous;
    }

    public void setEditMiscellaneous(boolean editMiscellaneous)
    {
        this.editMiscellaneous = editMiscellaneous;
    }

    public String getReqNextAction()
    {
        return reqNextAction;
    }

    public void setReqNextAction(String reqNextAction)
    {
        this.reqNextAction = reqNextAction;
    }

    public List<CatalogItemBO> getCatalogItemList()
    {
        return catalogItemList;
    }

    public void setCatalogItemList(List<CatalogItemBO> catalogItemList)
    {
        this.catalogItemList = catalogItemList;
    }

    /*public List<GuidedItemBO> getGuidedItemList()
    {
        return guidedItemList;
    }

    public void setGuidedItemList(List<GuidedItemBO> guidedItemList)
    {
        this.guidedItemList = guidedItemList;
    }

    public List<VirtualItemBO> getVirtualItemList() {
        return virtualItemList;
    }

    public void setVirtualItemList(List<VirtualItemBO> virtualItemList) {
        this.virtualItemList = virtualItemList;
    }

    public List<NonStockItemBO> getNonStockItemList() {
        return nonStockItemList;
    }

    public void setNonStockItemList(List<NonStockItemBO> nonStockItemList) {
        this.nonStockItemList = nonStockItemList;
    }*/

    public String getReqDeliveryAddressCode() {
        return reqDeliveryAddressCode;
    }

    public void setReqDeliveryAddressCode(String reqDeliveryAddressCode) {
        this.reqDeliveryAddressCode = reqDeliveryAddressCode;
    }

    public String getReqBillToAddressCode() {
        return reqBillToAddressCode;
    }

    public void setReqBillToAddressCode(String reqBillToAddressCode) {
        this.reqBillToAddressCode = reqBillToAddressCode;
    }


    public void setPoNextAction(String poNextAction)
    {
        this.poNextAction = poNextAction;
    }

    public String getPoNextAction() {
        return poNextAction;
    }

    public List<String> getAttachmentsList() {
        return attachmentsList;
    }

    public void setAttachmentsList(List<String> attachmentsList) {
        this.attachmentsList = attachmentsList;
    }


    public String getReqPoNumber() {
        return reqPoNumber;
    }

    public void setReqPoNumber(String reqPoNumber) {
        this.reqPoNumber = reqPoNumber;
    }



    public String getSendToApproval() {
        return sendToApproval;
    }

    public void setSendToApproval(String sendToApproval) {
        this.sendToApproval = sendToApproval;
    }

    public String getReturnToMe() {
        return returnToMe;
    }

    public void setReturnToMe(String returnToMe) {
        this.returnToMe = returnToMe;
    }

    public String getAssignedBuyerGroup()
    {
        return assignedBuyerGroup;
    }

    public void setAssignedBuyerGroup(String assignedBuyerGroup)
    {
        this.assignedBuyerGroup = assignedBuyerGroup;
    }


    public String getAllowBudget() {
        return allowBudget;
    }

    public void setAllowBudget(String allowBudget) {
        this.allowBudget = allowBudget;
    }


}
