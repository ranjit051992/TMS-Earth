const { I,randomNumber } = inject();
const iCreateInvoice = require("./IcreateInvoice");
const commonElements = require("../../pages/Common/commonElements");
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");
const addInvoicePage = require("../../pages/Invoice/addInvoicePage");
let NON_PO="NON_PO";
module.exports = {  
    clickOnBasicDetailsTab() {
        I.click(I.getElement(iCreateInvoice.basicDetailsTab));
    },
    clickOnBillingAndCostBookingDetailsTab() {
        I.click(I.getElement(iCreateInvoice.billingAndCostBookingTab));
    },   
    clickOnAddItemsTab() {
        I.click(I.getElement(iCreateInvoice.addItemsTab));
    },
   
    clickOnSendForConfirmationBtn() {
        I.waitForElement(I.getElement(iCreateInvoice.sendForConfirmationBtn), 30);
        I.click(I.getElement(iCreateInvoice.sendForConfirmationBtn));
    },
    clickOnIgnoreAndSubmitBtn() {
        I.waitForElement(I.getElement(iCreateInvoice.ignoreAndSubmitBtn), 30);
        I.click(I.getElement(iCreateInvoice.ignoreAndSubmitBtn));
    },
    createInvoice(type,invoiceNumber) {
        if(type==NON_PO){
            invoiceHomePage.clickOnAddInvoiceBtn();
            addInvoicePage.selectNonPoInvoice();
            commonElements.selectSupplier(I.getData("SUPPLIER"));
            //var randomNumber=commonElements.getRandomNumber(5);
            addInvoicePage.enterInvocieNumber(invoiceNumber);
            addInvoicePage.selectInvoiceDate();
            commonElements.clickOnNextBtn();
            commonElements.selectAddress();
            commonElements.selectRemitToAddress();
            this.clickOnBasicDetailsTab();
            commonElements.selectRequester(I.getData("REQUESTER"));
            commonElements.selectPurchaseType(I.getData("PURCHASE_TYPE"));
            //commonElements.addAttachment();
            commonElements.addAttachmentFromExisting();
            this.clickOnAddItemsTab();
            commonElements.addItem(I.getData("ITEM_NAME"),I.getData("CATEGORY"),I.getData("QTY_OR_AMT"),I.getData("UOM"),I.getData("PRICE"));
            this.clickOnBillingAndCostBookingDetailsTab();
            commonElements.addCBL(I.getData("COMPANY"),I.getData("BUSINESS_UNIT"),I.getData("LOCATION"));
            commonElements.addCostBookingDetails(I.getData("COST_CENTER"),I.getData("PERCENTAGE"));
            this.clickOnAddItemsTab();
            commonElements.selectGLAccount(I.getData("GL_ACCOUNT"))
            commonElements.clickOnSubmitBtn();
            this.clickOnIgnoreAndSubmitBtn();
            this.clickOnSendForConfirmationBtn();
        }
    }
}