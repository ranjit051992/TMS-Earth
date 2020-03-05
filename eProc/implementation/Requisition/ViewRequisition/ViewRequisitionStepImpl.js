const {I} = inject();
const prop = global.confi_prop;
const reqListingImpl = require("../RequisitionListing/RequisitionListingImpl");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const viewReqImpl = require("./ViewRequisitionImpl");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");

Then("I should be able to see submitted requisition with updated details", async function(){
    let isReqUpdated = false;
    let verifyQuantity = false;
    let verifyTaxes = false;

    await reqListingImpl.searchAndViewReqByName(this.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));

    this.fetchQuantity = await viewReqImpl.fetchQuantity(this.reqBO.itemName);
    
    if(this.fetchQuantity.toString().trim().includes(this.updateQuantity.toString().trim()))
    {
        verifyQuantity = true;
        logger.info("Verified updated Quantity-->"+verifyQuantity);
    }

    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
   
    let taxValueArray = new Array();

    taxValueArray = await viewReqImpl.fetchTaxesDetails(this.reqBO.itemName);
    logger.info("Tax Deatils Array--->>"+taxValueArray);
    
    if(taxValueArray.toString().includes(this.reqBO.taxType.toString()) && taxValueArray.includes(this.reqBO.taxName.toString()))
    {
        verifyTaxes = true;
        logger.info("Verified updated Taxes-->"+verifyTaxes);
    }

    isReqUpdated = (verifyQuantity && verifyTaxes);

    I.assertEqual(isReqUpdated, true);

});

Then("I should be able see the taxes added on view requisition", async function(){
    let verifyTaxes = false;

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
   
    let taxValueArray = new Array();

    taxValueArray = await viewReqImpl.fetchTaxesDetails(this.reqBO.itemName);
    logger.info("Tax Deatils Array--->>"+taxValueArray);
    
    if(taxValueArray.toString().includes(this.reqBO.taxType.toString()) && taxValueArray.includes(this.reqBO.taxName.toString()))
    {
        verifyTaxes = true;
        logger.info("Verified updated Taxes-->"+verifyTaxes);
    }

    I.assertEqual(verifyTaxes, true);
});