const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iReceiptObject = require("./ReceiptObject");
const iSpoObject = require("../../implementation/PO/Spo/SpoObject")
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const approvalImpl = require("../Approval/ApprovalImpl")
const poListingImpl = require("../PO/PoListing/PoListingImpl")
const prop = global.confi_prop;
const commonKeywordImpl= require("../../commonKeywords/CommonComponent")
const poListingObject = require("../PO/PoListing/PoListingObject");


module.exports = {
    async viewPO()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.PO_VIEW));
        await I.click(I.getElement(iReceiptObject.PO_VIEW));
    },
    async viewReceiptTab()
    {   
        await I.waitForVisible(I.getElement(iReceiptObject.RECEIPT_TAB_PO_VIEW));
        await I.click(I.getElement(iReceiptObject.RECEIPT_TAB_PO_VIEW));
    },
    async createReceipt()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.CREATE_RECEIPT_BUTTON));
        await I.click(I.getElement(iReceiptObject.CREATE_RECEIPT_BUTTON));
        logger.info("Receipt created");
    },
    async clickCreateReturnNoteButton()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.CREATE_BUTTON));
        await I.click(I.getElement(iReceiptObject.CREATE_BUTTON));
        await I.waitForVisible(I.getElement(iReceiptObject.CREATE_RETURN_NOTE_BUTTON));
        await I.click(I.getElement(iReceiptObject.CREATE_RETURN_NOTE_BUTTON));
        logger.info("ReturnNote created");
    },
    async clickDeleteAction()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.SECONDARY_ACTION_SELECTION));
        await I.click(I.getElement(iReceiptObject.SECONDARY_ACTION_SELECTION));
        await I.waitForVisible(I.getElement(iReceiptObject.DELETE_ACTION));
        await I.click(I.getElement(iReceiptObject.DELETE_ACTION));
        logger.info("Clicked on Delete action");
    },
    async clickDeleteActionConfirmation()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.DELETE_ACTION_CONFIRMATION_YES));
        await I.click(I.getElement(iReceiptObject.DELETE_ACTION_CONFIRMATION_YES));
    },
    async fetchStatus()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.STATUS));
        let status = await I.grabTextFrom(I.getElement(iReceiptObject.STATUS));
        logger.info("Status of the Receipt/ ReturnNote is "+status);
        return status;
    },

    async clickSelectionCheckbox()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.ALL_ITEM_SELECTION_CHECKBOX));
        await I.click(I.getElement(iReceiptObject.ALL_ITEM_SELECTION_CHECKBOX));
    },
    async updateReceivedQty()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.RECEIVED_QTY));
        await I.click(I.getElement(iReceiptObject.RECEIVED_QTY));
        await I.fillField(I.getElement(iReceiptObject.RECEIVED_QTY), 1);
    },
    async clickSaveAsDraft()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.SAVE_AS_DRAFT_BUTTON));
        await I.click(I.getElement(iReceiptObject.SAVE_AS_DRAFT_BUTTON));
        logger.info("Receipt/ ReturnNote saved as draft");
        I.saveScreenshot("ReceiptDraft.png");
    },
    async clickSubmitReceipt()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.SUBMIT_BUTTON));
        await I.click(I.getElement(iReceiptObject.SUBMIT_BUTTON));
        logger.info("Receipt/ ReturnNote submitted");
    },
    async clickConfirmation()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.CONFIRMATION_POPUP_YES));
        await I.click(I.getElement(iReceiptObject.CONFIRMATION_POPUP_YES));
    },
    async searchPONumber(poNumber)
    {
        await I.waitForVisible(I.getElement(iReceiptObject.SEARCH_BUTTON));
        await I.click(I.getElement(iReceiptObject.SEARCH_BUTTON));
        await I.fillField(I.getElement(iReceiptObject.SEARCH_BUTTON), poNumber);
        await I.pressKey('Enter');
    },
    async enterReceivedQty()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.RECEIVED_QTY));
        await I.click(I.getElement(iReceiptObject.RECEIVED_QTY));
        await I.fillField(I.getElement(iReceiptObject.RECEIVED_QTY), 1);
    },
    async verifyNoDataAvailable()
    {
        let noDataText = await I.grabTextFrom(I.getElement(iReceiptObject.NO_DATA_AVAILABLE_TEXT));
        return noDataText;
    },
    async receiptCreation()
    {
        await receiptImpl.viewPO();
        await receiptImpl.viewReceiptTab();
        await receiptImpl.createReceipt();
        await receiptImpl.clickSelectionCheckbox();
        await receiptImpl.clickSubmitReceipt()
        await receiptImpl.clickConfirmation();
    },

    async searchRequisition(reqNo){
        await I.wait(prop.DEFAULT_HIGH_WAIT);
        await I.waitForVisible(I.getElement(iReceiptObject.SEARCH_BUTTON));
        await I.click(I.getElement(iReceiptObject.SEARCH_BUTTON));
        await I.fillField(I.getElement(iReceiptObject.SEARCH_BUTTON), reqNo);
        await I.waitForVisible(I.getElement(iReceiptObject.SELECT_PO_DESCRIPTION));
        await I.waitForClickable(I.getElement(iReceiptObject.SELECT_PO_DESCRIPTION));
        await I.click(I.getElement(iReceiptObject.SELECT_PO_DESCRIPTION));
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
    },
    async getPoNumber(){
        this.poNumber = await I.grabTextFrom(I.getElement(iReceiptObject.PO_VIEW));
        logger.info("Get PO number"+this.poNumber);
        return this.poNumber;
    },

    async createReceiptFlow()
    {
        await this.viewReceiptTab();
        await this.createReceipt();
        await this.clickSelectionCheckbox();
        await this.clickSubmitReceipt()
        await this.clickConfirmation();
    },

    async releasePoFlow() {
            await approvalImpl.navigateToApprovalListing();
            await approvalImpl.navigateToPOApprovalListingTab();
            await approvalImpl.approveDoc(this.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
            await approvalImpl.checkPOApprovalStatus(this.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
            let status = await approvalImpl.getSpoStatus();

            let flag = status.toString() === lmtVar.getLabel("APPROVED_STATUS")
            if(!flag) {
                logger.info(`Failed to approve spo because status is ${status} on Approval listing after approving`);
                throw new Error(`Failed to approve spo because status is ${status} on Approval listing after approving`);
            }
            else {
                logger.info("Spo is approved successfully");
            }
            
            await I.wait(prop.DEFAULT_MEDIUM_WAIT);
            await poListingImpl.navigateToPoListing();
            await commonKeywordImpl.searchDocOnListing(this.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
            status = await poListingImpl.getPoStatus();
            logger.info(`Status in db --> ${lmtVar.getLabel("RELEASED_STATUS")}`);
            flag = status.toString().includes(lmtVar.getLabel("RELEASED_STATUS"));
            if(!flag) {
                logger.info(`Failed to release spo because status is ${status} on po listing after approving`);
                throw new Error(`Failed to release spo because status is ${status} on po listing after approving`);
            }
            else {
                logger.info("PO is released successfully");
            }
    }
 

}