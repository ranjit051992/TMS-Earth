const { I } = inject();
const iViewReq= require("./ViewRequisitionObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const faker = require("faker");
const iViewReqObject = require("./ViewRequisitionObject");
module.exports = {


    async getShipToAnotherAddress()
    {
        await I.waitForVisible(I.getElement(iViewReq.VIEW_REQ_SHIP_TO_ANOTHER_ADDRESS),prop.DEFAULT_MEDIUM_WAIT);
        let address = await I.grabTextFrom(I.getElement(iViewReq.VIEW_REQ_SHIP_TO_ANOTHER_ADDRESS));
        address = address.toString().replace('\n','').trim();
        logger.info("Custom address on view page : "+address);
        return address;
    },

    async fetchQuantity(itemName)
    {
        let xpath = `//span[contains(text(),'${itemName}')]//following::dew-col[5]`;
        await I.waitForVisible(xpath);
        let fetchQuantity = await I.grabTextFrom(xpath);
        fetchQuantity = fetchQuantity.toString().replaceAll("[A-Za-z]", "");
        logger.info("Fetched Quantity is --->"+fetchQuantity);
        return fetchQuantity;
    },
    
    async fetchTaxesDetails(itemName)
    {
        let taxLinkPath = `//span[contains(text(),'${itemName}')]//following::a[6]`;
        await I.waitForVisible(taxLinkPath);
        await I.click(taxLinkPath);
        logger.info("Clicked on Taxes Link");

        let taxDetailsMap = new Map();

        let noOfHeaders = await I.grabNumberOfVisibleElements(I.getElement(iViewReqObject.TAXES_HEADER_COLUMN));
        //let noOfValus = await I.grabNumberOfVisibleElements(I.getElement(iViewReqObject.TAXES_VALUE_COLUMN));
        let i=1;
        for(let header of noOfHeaders)
        {
            let headerXpath = (I.getElement(iViewReqObject.TAXES_HEADER_COLUMN)+"["+i+"]");
            let colValueXpath = (I.getElement(iViewReqObject.TAXES_VALUE_COLUMN)+"["+i+"]");

            let headerValue = await I.grabTextFrom(headerXpath);
            let colValue = await I.grabTextFrom(colValueXpath);

            taxDetailsMap.set(header, colValue);
            i++;
        }
        return taxDetailsMap;
    },

    
}