const {I} = inject();
const prop = global.confi_prop;
const reqListingImpl = require("../RequisitionListing/RequisitionListingImpl");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const viewReqImpl = require("./ViewRequisitionImpl");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");

Then("I should be able to see submitted requisition with updated details", async function(){
    let verifyQuantity = false;
    let verifyTaxes = false;
    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));

    this.fetchQuantity = await viewReqImpl.fetchQuantity(this.reqBO.itemName);
    if(this.updateQuantity.toString().trim() === this.fetchQuantity.toString().trim())
    {
        verifyQuantity = true;
        logger.info("Verified updated Quantity");
    }

    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    let taxDetailsMap = new Map();
    let taxValueArray = new Array();

    taxDetailsMap = await viewReqImpl.fetchTaxesDetails();
    let itr = taxDetailsMap.keys();
    for(let key of itr)
    {
        let value = taxDetailsMap.get(key);
        taxValueArray.push(value);
    }

    if(taxValueArray.includes(this.reqBO.taxType))
    {
        verifyTaxes = true;
    }
});