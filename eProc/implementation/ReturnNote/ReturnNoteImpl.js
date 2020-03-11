const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iReceiptObject = require("../Receipt/ReceiptObject");
const iReturnNoteObject = require("./ReturnNoteObject");
const prop = global.confi_prop;
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");

module.exports = {
        async selectItemReturnNote()
        {
            await I.waitForVisible(I.getElement(iReturnNoteObject.ITEM_SELECTION_CHECKBOX));
            await I.click(I.getElement(iReturnNoteObject.ITEM_SELECTION_CHECKBOX));
        },
    
        async addQuantity()
        {
            await I.waitForVisible(I.getElement(iReturnNoteObject.QUANTITY));
            await I.click(I.getElement(iReturnNoteObject.QUANTITY));
            await I.fillField(I.getElement(iReturnNoteObject.QUANTITY), 1);
            logger.info("Added quantity for Return Note");
        },
    
        async addReasonForReturn()
        {
            await I.waitForVisible(I.getElement(iReturnNoteObject.REASON_FOR_RETURN_DROPDOWN));
            await I.click(I.getElement(iReturnNoteObject.REASON_FOR_RETURN_DROPDOWN));
            await I.waitForVisible(I.getElement(iReturnNoteObject.REASON_FOR_RETURN_SELECTION));
            await I.click(I.getElement(iReturnNoteObject.REASON_FOR_RETURN_SELECTION));
            logger.info("Added Reason for Return for Return Note");
        },
    
        async addReturnMethod()
        {
            await I.waitForVisible(I.getElement(iReturnNoteObject.RETURN_METHOD_DROPDOWN));
            await I.click(I.getElement(iReturnNoteObject.RETURN_METHOD_DROPDOWN));
            await I.waitForVisible(I.getElement(iReturnNoteObject.RETURN_METHOD_SELECTION));
            await I.click(I.getElement(iReturnNoteObject.RETURN_METHOD_SELECTION));
            logger.info("Added Return Method for Return Note");
        },
        async createReturnNote()
        {
            await I.waitForVisible(I.getElement(iReturnNoteObject.CREATE_BUTTON));
            await I.click(I.getElement(iReturnNoteObject.CREATE_BUTTON));
            await I.waitForVisible(I.getElement(iReturnNoteObject.CREATE_RETURN_NOTE_BUTTON));
            await I.click(I.getElement(iReturnNoteObject.CREATE_RETURN_NOTE_BUTTON));
            logger.info("ReturnNote created");
        },
        async clickReturnNoteSaveAsDraft()
        {
            await I.waitForVisible(I.getElement(iReceiptObject.SAVE_AS_DRAFT_BUTTON));
            await I.click(I.getElement(iReceiptObject.SAVE_AS_DRAFT_BUTTON));
            await I.waitForVisible(I.getElement(iReceiptObject.CONFIRMATION_POPUP_YES));
            await I.click(I.getElement(iReceiptObject.CONFIRMATION_POPUP_YES));
            logger.info("Receipt/ ReturnNote saved as draft");
            I.saveScreenshot("ReturnNoteDraft.png");
        },
        async getReturnNoteNumber()
        {
            await I.waitForVisible(I.getElement(iReturnNoteObject.RETURN_NOTE_NUMBER));
            let returnNoteNumber = await I.grabTextFrom(I.getElement(iReturnNoteObject.RETURN_NOTE_NUMBER));           
            return returnNoteNumber;
        },
        async waitForReturnNoteCreation()
        {
            let returnNote = lmtVar.getLabel("RETURN_NOTE");
            await I.waitForVisible("//dew-col[contains(text(),'"+ returnNote +"')]");
        }
        

}