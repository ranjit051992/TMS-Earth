const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iReceiptObject = require("./ReceiptObject");
const iSpoObject = require("../../implementation/PO/Spo/SpoObject")
const prop = global.confi_prop;

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
        let status = await I.grabTextFrom(I.getElement(iReceiptObject.STATUS));
        logger.info("Status of the Receipt/ ReturnNote is "+status);
        return status;
    },
    async clickSelectionCheckbox()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.FIRST_ITEM_SELECTION_CHECKBOX));
        await I.click(I.getElement(iReceiptObject.FIRST_ITEM_SELECTION_CHECKBOX));
    },
    async clickSaveAsDraft()
    {
        await I.waitForVisible(I.getElement(iReceiptObject.SAVE_AS_DRAFT_BUTTON));
        await I.click(I.getElement(iReceiptObject.SAVE_AS_DRAFT_BUTTON));
        logger.info("Receipt/ ReturnNote saved as draft");
        I.saveScreenshot("Clicked on Save as Draft");
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

}