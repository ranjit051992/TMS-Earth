const { I,randomNumber } = inject();
const iCreateInvoice = require("./IcreateInvoice");
const commonElements = require("../../pages/Common/commonElements");
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");
const addInvoicePage = require("../../pages/Invoice/addInvoicePage");
let NON_PO="NON_PO";
module.exports = {  
    clickOnBasicDetailsTab() {
        I.click(global.uiElements.get(iCreateInvoice.basicDetailsTab));
    },
    clickOnBillingAndCostBookingDetailsTab() {
        I.click(global.uiElements.get(iCreateInvoice.billingAndCostBookingTab));
    },   
    clickOnAddItemsTab() {
        I.click(global.uiElements.get(iCreateInvoice.addItemsTab));
    },
   
    clickOnSendForConfirmationBtn() {
        //I.wait(10);
        I.waitForElement(global.uiElements.get(iCreateInvoice.sendForConfirmationBtn), 30);
        I.click(global.uiElements.get(iCreateInvoice.sendForConfirmationBtn));
    },
    createInvoice(type) {
        if(type==NON_PO){
            invoiceHomePage.clickOnAddInvoiceBtn();
            addInvoicePage.selectNonPoInvoice();
            commonElements.selectSupplier(global.testData.get("SUPPLIER"));
            var randomNumber=commonElements.getRandomNumber(5);
            addInvoicePage.enterInvocieNumber(randomNumber);
            addInvoicePage.selectInvoiceDate();
            commonElements.clickOnNextBtn();
            commonElements.selectAddress();
            commonElements.selectRemitToAddress();
            this.clickOnBasicDetailsTab();
            commonElements.selectRequester(global.testData.get("REQUESTER"));
            commonElements.selectPurchaseType(global.testData.get("PURCHASE_TYPE"));
            this.clickOnAddItemsTab();
            commonElements.addItem(global.testData.get("ITEM_NAME"),global.testData.get("CATEGORY"),global.testData.get("QTY_OR_AMT"),global.testData.get("UOM"),global.testData.get("PRICE"));
            this.clickOnBillingAndCostBookingDetailsTab();
            commonElements.addCBL(global.testData.get("COMPANY"),global.testData.get("BUSINESS_UNIT"),global.testData.get("LOCATION"));
            commonElements.addCostBookingDetails(global.testData.get("BU"),global.testData.get("COST_CENTER"),global.testData.get("PERCENTAGE"));
            this.clickOnAddItemsTab();
            commonElements.selectGLAccount(global.testData.get("GL_ACCOUNT"))
            commonElements.clickOnSubmitBtn();
            this.clickOnSendForConfirmationBtn();
        }
    }
}