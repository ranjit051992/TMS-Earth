const { I } = inject();
const iCreateInvoice = require("./IcreateInvoice");
let NON_PO="Non_Po";
module.exports = {  
    clickOnBasicDetailsTab() {
        I.click(global.uiElements.get(iCreateInvoice.basicDetailsTab));
    },
    selectPurchaseType(purchaseType) {
        I.click(this.purchaseTypeField);
        I.click(`//div[@class="dropdown-content pointer ps scrollable ps--active-y"]//div[text()="${purchaseType}"]`);
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

        }
    }
}