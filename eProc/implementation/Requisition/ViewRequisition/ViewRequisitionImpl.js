const { I } = inject();
const iViewReq= require("./ViewRequisitionObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const faker = require("faker");

module.exports = {


    async getShipToAnotherAddress()
    {
        await I.waitForVisible(I.getElement(iViewReq.VIEW_REQ_SHIP_TO_ANOTHER_ADDRESS),prop.DEFAULT_MEDIUM_WAIT);
        let address = await I.grabTextFrom(I.getElement(iViewReq.VIEW_REQ_SHIP_TO_ANOTHER_ADDRESS));
        address = address.toString().replace('\n','').trim();
        logger.info("Custom address on view page : "+address);
        return address;
    },

    async checkLineItems(items)
    {
        let isPresent = false;
        let flag = 1;
        for(let item of items)
        {
            let check = await commonComponent.waitForElementVisible("//span[contains(@title,'"+item+"')]");
            if(!check)
            {
                flag = 1;
            }
        }

        if(flag===1)
        {
            isPresent = true;
        }

        return isPresent;
    },
}