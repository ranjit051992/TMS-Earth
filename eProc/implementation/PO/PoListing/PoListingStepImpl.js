const {I} = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const poListingImpl = require("./PoListingImpl");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");

Then("I should see that PR is directly flipped to PO", async function(){
    let isPOcreated = false;
    if(this.reqStatus.toString() === lmtVar.getLabel("APPROVED_STATUS").toString())
    {
        await poListingImpl.navigateToPoListing();
        await commonComponent.searchDocOnListing(this.reqBO.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION"));
        let poNumber = await commonComponent.getDocNumber();
        if(poNumber.toString() !== null)
        {
            isPOcreated = true;
            logger.info("PR flipped PO Number is ----> "+poNumber);
        }
    }
    I.assertEqual(isPOcreated, true);
});
