const { I } = inject();
const iViewReq = require("./ViewRequisitionObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const faker = require("faker");
const iViewReqObject = require("./ViewRequisitionObject");
const checkoutImp = require("../Checkout/CheckoutImpl");
module.exports = {


    async getShipToAnotherAddress() {
        await I.waitForVisible(I.getElement(iViewReq.VIEW_REQ_SHIP_TO_ANOTHER_ADDRESS), prop.DEFAULT_MEDIUM_WAIT);
        let address = await I.grabTextFrom(I.getElement(iViewReq.VIEW_REQ_SHIP_TO_ANOTHER_ADDRESS));
        address = address.toString().replace('\n', '').trim();
        logger.info("Custom address on view page : " + address);
        return address;
    },

    async fetchQuantity(itemName) {
        let xpath = `//span[contains(text(),'${itemName}')]//following::dew-col[5]`;
        await I.waitForVisible(xpath);
        let fetchQuantity = await I.grabTextFrom(xpath);
        //fetchQuantity = fetchQuantity.toString().replaceAll("[A-Za-z]", "");
        logger.info("Fetched Quantity is --->" + fetchQuantity);
        return fetchQuantity;
    },

    async fetchTaxesDetails(itemName) {
        let taxLinkPath = `//span[contains(text(),'${itemName}')]//following::a[6]`;
        await I.waitForVisible(taxLinkPath);
        await I.click(taxLinkPath);
        logger.info("Clicked on Taxes Link");
        //let taxDetailsMap = new Map();
        let taxDetailsArray = new Array();
        let noOfHeaders = await I.grabNumberOfVisibleElements(I.getElement(iViewReqObject.TAXES_HEADER_COLUMN));
        //let noOfValus = await I.grabNumberOfVisibleElements(I.getElement(iViewReqObject.TAXES_VALUE_COLUMN));
        let i = 1;
        for (let j = 0; j < noOfHeaders; j++) {
            let headerXpath = (I.getElement(iViewReqObject.TAXES_HEADER_COLUMN) + "[" + i + "]");
            let colValueXpath = (I.getElement(iViewReqObject.TAXES_VALUE_COLUMN) + "[" + i + "]");
            let headerValue = await I.grabTextFrom(headerXpath);
            let colValue = await I.grabTextFrom(colValueXpath);
            logger.info("headerValue " + headerValue + " " + "colValue " + colValue);
            // taxDetailsMap.set(headerValue, colValue);
            taxDetailsArray.push(colValue);
            i++;
        }
        // return taxDetailsMap;
        return taxDetailsArray;
    },


    async checkLineItems(items) {
        let isPresent = false;
        let flag = 1;
        for (let item of items) {
            let check = await commonComponent.waitForElementVisible("//span[contains(@title,'" + item + "')]");
            if (!check) {
                flag = 1;
            }
        }

        if (flag === 1) {
            isPresent = true;
        }

        return isPresent;
    },

    async fetchCostCenter()
    {
       let fetchCostCenter =  await I.grabTextFrom(I.getElement(iViewReqObject.COST_CENTER));

       return fetchCostCenter;
    },  

    async clickOnBackArrow()
    {
        await commonComponent.waitForElementVisible(I.getElement(iViewReqObject.BACK_ARROW));
        await I.waitForClickable(I.getElement(iViewReqObject.BACK_ARROW));
        await I.click(I.getElement(iViewReqObject.BACK_ARROW));

    },
    // async verifySplitCostCenterAddedForItems(items)
    // {
    //     let isSplitCostCenter = false;
    //     for(let item of items)
    //     {
    //         await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    //         await I.click("//span[contains(text(),'"+item+"')]//following::a[2]");
    //         let costCenter = await this.fetchCostCenter();
    //         pause();
    //         logger.info("fetchCostCenter "+costCenter)
            
    //         if(costCenter.toString() === this.costCenter.toString())
    //         {
    //             isSplitCostCenter = true;
    //             logger.info("Verified Cost Center for item at line Level");
    //         }
    //     }
    //     return isSplitCostCenter;
    // },

    async verifyWorkflowApprovalHierarchy() {

        let workflowNodes = await checkoutImp.fetchWorkflowNodes();
        let isPresent = false;
        let flag = new Array();
        
        for (let i = 0; i < workflowNodes.length; i++) {
            if (workflowNodes[i].includes(lmtVar.getLabel("REQUIRE_APPROVAL_AFTER_REQUESTER"))) 
            {
                flag.push(true);
                break;
            }
            else {
                flag.push(false);
                break;
            }
            if (workflowNodes[i].includes(lmtVar.getLabel("REQUIRE_APPROVAL_AFTER_REPORTING_MANAGER"))) {
                flag.push(true);
                break;
            }
            else {
                flag.push(false);
                break;
            }
            if (workflowNodes[i].includes(lmtVar.getLabel("SEARCH_BY_BUYER"))) {
                flag.push(true);
                break;
            }
            else {
                flag.push(false);
                break;
            }
            if (workflowNodes[i].includes(lmtVar.getLabel("SUPPLIER"))) {
                flag.push(true);
                break;
            }
            else {
                flag.push(false);
                break;

            }
        }

        if (flag.includes(false)) {
            isPresent = false;
        }
        else {
            isPresent = true;
        }

        logger.info("flag "+flag);
        return isPresent;


    },

    async verifyWorkflowRequester(requester) 
    {

        let workflowNodes = await checkoutImp.fetchWorkflowNodes();
        let isPresent = false;
        if (workflowNodes[0].includes(lmtVar.getLabel("REQUIRE_APPROVAL_AFTER_REQUESTER"))) 
        {
            if(workflowNodes[0].includes(requester))
            {
                isPresent = true;
            }
        }
        
        return isPresent;

    }

}