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
        I.fillField(global.uiElements.get(iCommon.supplierField), supplierName);
        I.click(`//div//dew-col[text()="${supplierName}"]`);
    },
    clickOnNextBtn() {
        I.click(global.uiElements.get(iCommon.nextBtn));
    },
    selectAddress() {
        I.click(global.uiElements.get(iCommon.addressField));
        I.click(global.uiElements.get(iCommon.firstAddress));
    },
    selectRemitToAddress() {
        I.click(global.uiElements.get(iCommon.remitAddressField));
        I.click(global.uiElements.get(iCommon.firstRemitAddress));
    },
    selectRequester(requester) {
        I.fillField(global.uiElements.get(iCommon.requesterField), requester);
        I.click(`//div[@class="ac-body"]//span[text()="${requester}"]`);
    },
    selectPurchaseType(purchaseType) {
        I.click(global.uiElements.get(iCommon.purchaseTypeField));
        I.click(`//div[@class="dropdown-content pointer ps scrollable ps--active-y"]//div[text()="${purchaseType}"]`);
    },
    addCBL(company, businessUnit, location) {
        I.clearField(global.uiElements.get(iCommon.companyField));
        I.fillField(global.uiElements.get(iCommon.companyField), company);
        I.click(`//div[@class="ac-body cbl"]//div[contains(text(),"${company}")]`);
        I.clearField(global.uiElements.get(iCommon.businessUnitField));
        I.fillField(global.uiElements.get(iCommon.businessUnitField), businessUnit);
        I.click(`//div[@class="ac-body cbl"]//div[contains(text(),"${businessUnit}")]`)
        I.clearField(global.uiElements.get(iCommon.locationField));
        I.fillField(global.uiElements.get(iCommon.locationField), location);
        I.click(`//div[@class="ac-body cbl"]//div[contains(text(),"${location}")]`)
    },
    addCostBookingDetails(businessUnit, costCenter, percentage) {
        I.click(global.uiElements.get(iCommon.addSplitBtn));
        I.fillField(global.uiElements.get(iCommon.buField), businessUnit);
        I.click(`//div[@class="ac-body"]//div[contains(text(),"${businessUnit}")]`);
        I.fillField(global.uiElements.get(iCommon.costCenterField), costCenter);
        I.click(`//div[@class="ac-body"]//div[contains(text(),"${costCenter}")]`);
        I.fillField(global.uiElements.get(iCommon.percentageField), percentage);
    },
    addItem(itemName, category, qty, uom, price) {
        I.click(global.uiElements.get(iCommon.addLineItemBtn));
        I.fillField(global.uiElements.get(iCommon.itemNameField), itemName);
        I.fillField(global.uiElements.get(iCommon.categoryField), category);
        I.click(`//div[@class="ac-body"]//div[contains(text(),"${category}")]`);
        I.fillField(global.uiElements.get(iCommon.qtyOrAmtField), qty);
        I.fillField(global.uiElements.get(iCommon.uomField), uom);
        I.click(`//div[@class="ac-body forUom"]//div[contains(text(),"${uom}")]`);
        I.fillField(global.uiElements.get(iCommon.priceField), price)
        I.click(global.uiElements.get(iCommon.nextBtn));
    },
    selectGLAccount(glAccount) {
        I.click(global.uiElements.get(iCommon.costBookingDetailsLink));
        I.fillField(global.uiElements.get(iCommon.glAccountField), glAccount);
        I.click(`//div[@class="ac-body"]//div[contains(text(),"${glAccount}")]`);
        I.click(global.uiElements.get(iCommon.saveBtn));
        I.wait(2);
    },
    clickOnSubmitBtn() {
        I.click(global.uiElements.get(iCommon.submitBtn));
    },
}   