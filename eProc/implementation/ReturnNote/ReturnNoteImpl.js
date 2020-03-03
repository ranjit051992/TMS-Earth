const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iReceiptObject = require("../Receipt/ReceiptObject");
const iReturnNoteObject = require("./ReturnNoteObject");
const iSpoObject = require("../PO/Spo/SpoObject")

const prop = global.confi_prop;

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
        

}