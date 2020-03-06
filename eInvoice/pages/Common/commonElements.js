const { I } = inject();
const iCommon = require("./Icommon");
module.exports = {

    getRandomNumber(length) {
        var result           = '';
        var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var charactersLength = characters.length;
        for ( var i = 0; i < length; i++ ) {
           result += characters.charAt(Math.floor(Math.random() * charactersLength));
        }
        return result+"_auto";
     },

    selectSupplier(supplierName) {
        I.fillField(I.getElement(iCommon.supplierField), supplierName);
        I.click(`//div//dew-col[text()="${supplierName}"]`);
    },
    clickOnNextBtn() {
        I.click(I.getElement(iCommon.nextBtn));
    },
    selectAddress() {
        I.click(I.getElement(iCommon.addressField));
        I.click(I.getElement(iCommon.firstAddress));
    },
    selectRemitToAddress() {
        I.click(I.getElement(iCommon.remitAddressField));
        I.click(I.getElement(iCommon.firstRemitAddress));
    },
    selectRequester(requester) {
        I.fillField(I.getElement(iCommon.requesterField), requester);
        I.click(`//div[@class="ac-body"]//span[text()="${requester}"]`);
    },
    selectPurchaseType(purchaseType) {
        I.click(I.getElement(iCommon.purchaseTypeField));
        I.click(`//div[@class="dropdown-content pointer ps scrollable ps--active-y"]//div[text()="${purchaseType}"]`);
    },
    addAttachment() {
        I.attachFile(I.getElement(iCommon.attachmentField),'ProcureToPay.png');
    },
    addAttachmentFromExisting() {
        I.click(I.getElement(iCommon.pickFromExistingBtn));
        I.click(I.getElement(iCommon.firstFile));
        I.click(I.getElement(iCommon.doneBtn));
    },
    addCBL(company, businessUnit, location) {
        I.clearField(I.getElement(iCommon.companyField));
        I.fillField(I.getElement(iCommon.companyField), company);
        I.click(`//div[@class="ac-body cbl"]//div[contains(text(),"${company}")]`);
        I.clearField(I.getElement(iCommon.businessUnitField));
        I.fillField(I.getElement(iCommon.businessUnitField), businessUnit);
        I.click(`//div[@class="ac-body cbl"]//div[contains(text(),"${businessUnit}")]`)
        I.clearField(I.getElement(iCommon.locationField));
        I.fillField(I.getElement(iCommon.locationField), location);
        I.click(`//div[@class="ac-body cbl"]//div[contains(text(),"${location}")]`)
    },
    addCostBookingDetails(costCenter, percentage) {
        I.click(I.getElement(iCommon.addSplitBtn));
        //I.fillField(global.uiElements.get(iCommon.buField), businessUnit);
        //I.click(`//div[@class="ac-body"]//div[contains(text(),"${businessUnit}")]`);
        I.fillField(I.getElement(iCommon.costCenterField), costCenter);
        I.click(`//div[@class="ac-body"]//div[contains(text(),"${costCenter}")]`);
        I.fillField(I.getElement(iCommon.percentageField), percentage);
    },
    addItem(itemName, category, qty, uom, price) {
        I.click(I.getElement(iCommon.addLineItemBtn));
        I.fillField(I.getElement(iCommon.itemNameField), itemName);
        I.fillField(I.getElement(iCommon.categoryField), category);
        I.click(`//div[@class="ac-body"]//div[contains(text(),"${category}")]`);
        I.fillField(I.getElement(iCommon.qtyOrAmtField), qty);
        I.fillField(I.getElement(iCommon.uomField), uom);
        I.click(`//div[@class="ac-body forUom"]//div[contains(text(),"${uom}")]`);
        I.fillField(I.getElement(iCommon.priceField), price)
        I.click(I.getElement(iCommon.nextBtn));
    },
    selectGLAccount(glAccount) {
        I.click(I.getElement(iCommon.costBookingDetailsLink));
        I.fillField(I.getElement(iCommon.glAccountField), glAccount);
        I.click(`//div[@class="ac-body"]//div[contains(text(),"${glAccount}")]`);
        I.click(I.getElement(iCommon.saveBtn));
        I.wait(2);
    },
    clickOnSubmitBtn() {
        I.click(I.getElement(iCommon.submitBtn));
    },
}   