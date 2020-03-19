const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("../Spo/SpoObject");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");
const approvalImpl = require("../../Approval/ApprovalImpl");
const poListingImpl = require("../PoListing/PoListingImpl");
const poListingObject = require("../PoListing/PoListingObject");
const objectCreation = require("../../../dataCreation/ObjectCreation")
const coaImpl = require("../../Coa/CoaImpl");
const iBpoObject =require("./BpoObject");
const spoImpl = require("../Spo/SpoImpl")
const datePicker = require("../../../commonKeywords/CommonComponent")
const bpo = require("./../../../dataCreation/bo/Bpo");
module.exports = {
    async clickOnBlanketPOButton() {
        await I.waitForVisible(I.getElement(iBpoObject.BLANKET_PO_BUTTON));
        await I.click(I.getElement(iBpoObject.BLANKET_PO_BUTTON));
        await I.waitForVisible(I.getElement(iSpoObject.poNumberTextbox));
        I.saveScreenshot("CreateBpo.png");
        logger.info("Clicked on create blanket po button.");
    },

    async addAllRequiredDetails(bpo)
    {
        bpo = await this.fillBasicDetails(bpo);

        bpo = await this.fillBillingInformation(bpo);

        bpo = await this.fillSupplierDetails(bpo);

        bpo = await this.fillBuyerAndOtherInformation(bpo);

        bpo = await this.fillShippingDetails(bpo);

        bpo = await this.fillCostAllocation(bpo);

        bpo = await this.fillControlSettings(bpo);

        bpo = await this.fillLineItems(bpo);

        bpo = await this.storePoAmount(bpo);

        bpo = await this.fillTaxes(bpo);

        bpo = await this.fillAdditionalDetails(bpo);

        await this.fillAgreementDetails(bpo);

        bpo = await this.fillValidity(bpo);

        return bpo;

    },

    async createBpoFlow(bpo){
        await poListingImpl.navigateToPoListing();
        await spoImpl.clickOnCreatePOButton();
        await this.clickOnBlanketPOButton();
        bpo = await this.fillBasicDetails(bpo);

        bpo = await this.fillBillingInformation(bpo);

        bpo = await this.fillSupplierDetails(bpo);

        bpo = await this.fillBuyerAndOtherInformation(bpo);

        bpo = await this.fillShippingDetails(bpo);

        bpo = await this.fillCostAllocation(bpo);

        bpo = await this.fillControlSettings(bpo);

        bpo = await this.fillLineItems(bpo);

        bpo = await this.storePoAmount(bpo);

        bpo = await this.fillTaxes(bpo);

        bpo = await this.fillAdditionalDetails(bpo);

        await this.fillAgreementDetails(bpo);

        bpo = await this.fillValidity(bpo);

        await this.submitPo();

        await commonKeywordImpl.waitForElementVisible(iSpoObject.spinner);

        await I.waitForInvisible(I.getElement(iSpoObject.spinner));

        await poListingImpl.navigateToPoListing();
        
        await commonKeywordImpl.searchDocOnListing(bpo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));

        let poNumber = await commonKeywordImpl.getDocNumber();

        if(!poNumber.toString() === bpo.poNumber) {
            logger.info(`PO is not submitted. PO number fetched after submission --> ${poNumber}`);
            throw new Error(`PO is not submitted. PO number fetched after submission --> ${poNumber}`);
        }
        else {
            logger.info("Bpo is submitted successfully");
        }

        bpo.status = await poListingImpl.getPoStatus();
        logger.info(`PO status is --> ${bpo.status.toString()}`);

        return bpo;
    },


    async fillBasicDetails(bpo) {
        logger.info(`**************Filling Basic Details**************`);
        await spoImpl.fillPONumber(bpo.poNumber);
        logger.info("PO Number "+bpo.poNumber);
        await spoImpl.fillPODescription(bpo.poDescription);
        await spoImpl.selectPurchaseType(bpo.purchaseType);
        return bpo;
    },
    async fillBillingInformation(bpo) {
        logger.info(`**************Filling Billing Information**************`);
        await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_BILLING_INFORMATION_SECTION"));
        if(bpo.fillCbl) {
            await spoImpl.clickOnBuyingUnitLink();
            await spoImpl.fillCompany(bpo.company);
            await spoImpl.fillBusinessUnit(bpo.businessUnit);
            await spoImpl.fillLocation(bpo.location);
            await spoImpl.clickOnOuModalDoneButton();
        }
        bpo.setBillToAddress(spoImpl.fetchBillToAddress());
        return bpo;
    },
    async fillSupplierDetails(bpo) {
        logger.info(`**************Filling Supplier Details**************`);
        await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_SUPPLIER_DETAILS_SECTION"));
        await spoImpl.fillSupplierName(bpo.supplierName);
        await spoImpl.selectSupplierName(bpo.supplierName);
        await spoImpl.fillSupplierAddress(bpo.supplierAddress);
        await spoImpl.selectSupplierAddress(bpo.supplierAddress)
        await spoImpl.clickOnPaymentTermDropdown();
        await spoImpl.selectPaymentTerm(bpo.paymentTerm);
        await spoImpl.clickOnDeliveryTermDropdown();
        await spoImpl.selectDeliveryTerm(bpo.deliveryTerm);
        await spoImpl.fillCurrency(bpo.currency);
        await spoImpl.selectCurrency(bpo.currency);
        return bpo
    },
    async fillBuyerAndOtherInformation(bpo) {
        logger.info(`**************Filling Buyer and Other Information**************`);
        await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_BUYER_AND_OTHER_INFORMATION_SECTION"));
        let buyer = await spoImpl.fillBuyer(bpo.buyer);
        bpo.setBuyer(buyer);
        return bpo
    },
    async fillShippingDetails(bpo) {
        if(bpo.fillShippingDetails) {
            logger.info(`**************Filling Shipping Details**************`);
            await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_SHIPPING_DETAILS_SECTION"));
            let deliverTo = await spoImpl.selectDeliverTo(bpo.deliverTo);
            bpo.setDeliverTo(deliverTo);
            // await spoImpl.selectRequiredByDate();
            let requiredBy = await spoImpl.fetchRequiredBy();
            bpo.setRequiredBy(requiredBy);
        }
        return bpo;
    },
    async fillCostAllocation(bpo) {
        if(!prop.isCoa) {
            logger.info(`**************Filling Cost Allocation**************`);
            await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_COST_ALLOCATION_SECTION"));
            await spoImpl.clickOnAssignCostNOButton();
            await spoImpl.clickOnBookCostToSingle_MultipleCostCenter();
            let costCenter = await spoImpl.enterCostCenter(bpo.costCenter);
            // bpo.setCostCenter(costCenter);
        }
        return bpo;
    },
    async fillControlSettings(bpo) {
        if(bpo.fillControlSettings) {
            logger.info(`**************Filling Control Settings**************`);
            await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_CONTROL_SETTINGS_SECTION"));
            if (bpo.receiptRuleAtHeaderLevel) {
                await spoImpl.selectReceiptCreationAtHeaderLevel();
                if (bpo.receiptCreationDefault) {
                    await spoImpl.selectDefaultReceiptCreation();
                }
            }
        }
        return bpo;
    },
    async fillLineItems(bpo) {
        logger.info(`**************Filling Line Items**************`);
        if(bpo.taxInclusive) {
            await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_TAXES_SECTION_SECTION"));
            await spoImpl.selectTaxInclusive();
            await spoImpl.clickRemoveTaxesConfirmButton();
        }

        for(let i = 0; i < bpo.items.length; i++) {
            await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
            await spoImpl.clickOnAddLineItemButton();
            await spoImpl.enterItemName(bpo.items[i].itemName);
            await spoImpl.selectItemOption(bpo.items[i].itemName);
            await this.clickOnCostBookingLink(bpo.items[i].itemName);
            await coaImpl.fillCoaDetails();
            await this.addMaxUnitPrice(bpo);
        }

        return bpo;
    },
    async fillTaxes(bpo) {
        logger.info(`**************Filling Taxes**************`);
        await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_TAXES_SECTION_SECTION"));
        await spoImpl.clickOnRemoveAllTaxesButton();
        return bpo;
    },
    async fillAdditionalDetails(bpo) {
        if(bpo.fillAdditionalDetails) {
            logger.info(`**************Filling Additional Details**************`);
            await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_ADDITIONAL_DETAILS_SECTION"));
            await spoImpl.fillTermsAndConditions(bpo.termsAndConditions);
            await spoImpl.fillNotes(bpo.notes);
        }
        return bpo;
    },
    async fillAgreementDetails(bpo){
        logger.info(`**************Filling Agreement Details**************`);
        if(!prop.isCoa) {
            await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("BPO_AGREEMENT_DETAILS_SECTION"));
            await this.clickDefineBuyingScope();
            await this.fillBusinessUnit(bpo.businessUnit);
            await this.fillLocation(bpo.location);
            await this.fillCostCenter(bpo.costCenter);
        }
        else {
            logger.info(`****************Define Buying scope skipped in COA Form******************`);
        }
    },
    async fillValidity(bpo){
        logger.info(`*****************Filling Validity*****************`);
        await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("BPO_VALIDITY_SECTION"));
        let fromDate = await this.selectFromDate();
        let toDate = await this.selectToDate(bpo);
        // await this.selectAcceptInvoicesUntil();
        bpo.setFromDate(fromDate);
        bpo.setToDate(toDate);
        return bpo;
    },

    async storePoAmount(bpo) {
        I.scrollIntoView(I.getElement(iSpoObject.TOTAL_ORDER_AMOUNT));
        I.waitForVisible(I.getElement(iSpoObject.TOTAL_ORDER_AMOUNT));
        let PoAmount = await I.grabTextFrom(I.getElement(iSpoObject.TOTAL_ORDER_AMOUNT));
        bpo.setPoAmount(PoAmount);
        return bpo;
    },

    async submitPo() {
        logger.info(`**************Submitting BPO**************`);
        await spoImpl.clickOnSubmitPOButton();
        await spoImpl.clickOnConfirmButton();
    },

    async clickOnCostBookingLink(itemName) {
        let costBookingLink = `(//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[1])`;
        await I.waitForVisible(costBookingLink);
        await I.click(costBookingLink);
        logger.info("Clicked on Cost booking Link");
    },
    async clickDefineBuyingScope(){
        await I.waitForVisible(I.getElement(iBpoObject.DEFINE_BUYING_SCOPE));
        await I.click(I.getElement(iBpoObject.DEFINE_BUYING_SCOPE));
    },
    async fillBusinessUnit(businessUnit){
        await I.waitForVisible(I.getElement(iBpoObject.BUSINESS_UNIT_DROPDOWN));
        await I.click(I.getElement(iBpoObject.BUSINESS_UNIT_DROPDOWN));
        await I.fillField(I.getElement(iBpoObject.BUSINESS_UNIT_DROPDOWN), businessUnit);
        await I.waitForVisible(I.getElement(iBpoObject.BUSINESS_UNIT_LOCATION_SELECTION));
        await I.click(I.getElement(iBpoObject.BUSINESS_UNIT_LOCATION_SELECTION));
    },
    async fillLocation(location){
        await I.waitForVisible(I.getElement(iBpoObject.LOCATION_DROPDOWN));
        await I.click(I.getElement(iBpoObject.LOCATION_DROPDOWN));
        await I.fillField(I.getElement(iBpoObject.LOCATION_DROPDOWN), location);
        await I.waitForVisible(I.getElement(iBpoObject.BUSINESS_UNIT_LOCATION_SELECTION));
        await I.click(I.getElement(iBpoObject.BUSINESS_UNIT_LOCATION_SELECTION));
    },
    async fillCostCenter(costCenter){
        await I.waitForVisible(I.getElement(iBpoObject.COST_CENTER_DROPDOWN));
        await I.click(I.getElement(iBpoObject.COST_CENTER_DROPDOWN));
        let xpath = `//span[contains(text(),'${costCenter}')]`;
        // await I.fillField(I.getElement(iBpoObject.COST_CENTER_DROPDOWN), costCenter);
        await I.scrollIntoView(xpath);
        await I.click(xpath);
        await I.waitForVisible(I.getElement(iBpoObject.OK_BUTTON));
        await I.click(I.getElement(iBpoObject.OK_BUTTON));
    },
    async selectFromDate(){
        await I.waitForVisible(I.getElement(iBpoObject.FROM_DATE));
        await datePicker.selectToday(I.getElement(iBpoObject.FROM_DATE));
        let fromDate = await I.grabAttributeFrom(I.getElement(iBpoObject.FROM_DATE),"value");
        fromDate = fromDate.toString();
        return fromDate;
    },
    async selectToDate(bpo){
        await I.waitForVisible(I.getElement(iBpoObject.TO_DATE));
        await datePicker.selectInNextMonth(I.getElement(iBpoObject.TO_DATE), bpo.date);
        let toDate = await I.grabAttributeFrom(I.getElement(iBpoObject.TO_DATE),"value");
        toDate = toDate.toString();
        return toDate;
    },
    async selectAcceptInvoicesUntil(){
        await I.waitForVisible(I.getElement(iBpoObject.ACCEPT_INVOICES_UNTIL));
        await datePicker.selectInNextMonth(I.getElement(iBpoObject.ACCEPT_INVOICES_UNTIL),"15");
    },
    async addAttachment(attachment){
        await I.fillField(I.getElement(iBpoObject.ADD_ATTACHMENT), attachment.toString());
        await I.wait(prop.DEFAULT_LOW_WAIT);
    },

    async updateOrderValue(bpo){
        await I.waitForVisible(I.getElement(iBpoObject.AUTO_UPDATE_CHECKBOX));
        await I.click(I.getElement(iBpoObject.AUTO_UPDATE_CHECKBOX));
        await I.waitForVisible(I.getElement(iBpoObject.ORDER_VALUE));
        await I.clearField(I.getElement(iBpoObject.ORDER_VALUE));
        await I.click(I.getElement(iBpoObject.ORDER_VALUE));
        let orderValue = bpo.PoAmount.toString();
        orderValue = orderValue.substring(orderValue.indexOf(" ")+1);
        orderValue = orderValue.replace(",","");
        orderValue = parseFloat(orderValue)* parseFloat(bpo.date);
        await I.fillField(I.getElement(iBpoObject.ORDER_VALUE), orderValue);
        return orderValue;
    },
    async getOrderValue(){
        let orderValueView = await I.grabTextFrom(I.getElement(iBpoObject.ORDER_VALUE_VIEW));
        orderValueView= orderValueView.toString();
        orderValueView = orderValueView.substring(orderValueView.indexOf(" ")+1);
        return parseFloat(orderValueView);

    },
    async addMaxUnitPrice(bpo)
    {
        await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
        await I.waitForVisible(I.getElement(iBpoObject.ITEM_EDIT));
        await I.click(I.getElement(iBpoObject.ITEM_EDIT));
        let marketPrice = lmtVar.getLabel("MARKET_PRICE");
        let maxPrice = lmtVar.getLabel("MAXIMUM_RELEASE_AMOUNT");
        let marketPriceXpath = `//input[@aria-label='${marketPrice}']`;
        let maxPriceXpath = `//input[@aria-label='${maxPrice}']`;
        await I.scrollIntoView(marketPriceXpath);
        let itemPrice = await I.grabAttributeFrom(marketPriceXpath, "value");
        bpo.setItemPrice(itemPrice);
        await I.fillField(maxPriceXpath, itemPrice.toString());
        await I.waitForVisible(I.getElement(iBpoObject.ITEM_SUMMARY_OK_BUTTON));
        await I.click(I.getElement(iBpoObject.ITEM_SUMMARY_OK_BUTTON));
    },

    async createMultipleBPOs(noOfPOs, noOfItems, itemType) {
        let bpoArray = new Array();
        
        for(let i=0; i<noOfPOs; i++)
        {
        let bpo = await objectCreation.getObjectOfBlanketPO(noOfItems, itemType);
        bpo = await this.createBpoFlow(bpo);
        await bpoArray.push(bpo);
        }

        return bpoArray;
    },
    async approveBpoFlow(poNumber) {
        await approvalImpl.navigateToApprovalListing();
        await approvalImpl.navigateToBPOApprovalListingTab();
        await approvalImpl.approveDoc(poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        await approvalImpl.checkPOApprovalStatus(poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        let status = await approvalImpl.getSpoStatus();

        let flag = status.toString() === lmtVar.getLabel("APPROVED_STATUS")
        if(!flag) {
            logger.info(`Failed to approve bpo because status is ${status} on Approval listing after approving`);
            throw new Error(`Failed to approve bpo because status is ${status} on Approval listing after approving`);
        }
        else {
            logger.info("Bpo is approved successfully");
        }
        
        await I.wait(prop.DEFAULT_HIGH_WAIT);
        await poListingImpl.navigateToPoListing();
        await commonKeywordImpl.searchDocOnListing(poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        status = await poListingImpl.getPoStatus();
        logger.info(`Status in db --> ${lmtVar.getLabel("RELEASED_STATUS")}`);
        flag = status.toString().includes(lmtVar.getLabel("RELEASED_STATUS"));
        if(!flag) {
            logger.info(`Failed to release bpo because status is ${status} on po listing after approving`);
            throw new Error(`Failed to release bpo because status is ${status} on po listing after approving`);
        }
        else {
            logger.info("Bpo is released successfully");
        }
    },

    async createReleaseOrder()
    {
        await I.waitForVisible(I.getElement(iBpoObject.CREATE_RELEASE_BUTTON));
        await I.click(I.getElement(iBpoObject.CREATE_RELEASE_BUTTON));
        await this.submitPo();
    },

    async compareReleaseOrderData()
    {
        await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("BPO_SUPPLIER_DETAILS_SECTION"));
        await I.waitForVisible(I.getElement(iBpoObject.SUPPLIER_NAME));
        let supplierName = await I.grabTextFrom(I.getElement(iBpoObject.SUPPLIER_NAME));
        await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("BPO_LINE_ITEMS_SECTION"));
        await I.waitForVisible(I.getElement(iBpoObject.ITEM_NAME));
        let itemName = await I.grabTextFrom(I.getElement(iBpoObject.ITEM_NAME));
        let itemPrice = await I.grabTextFrom(I.getElement(iBpoObject.ITEM_PRICE));
        itemPrice = itemPrice.substring(itemPrice.indexOf(" ")+1);
        itemPrice = itemPrice.replace(",","");
        itemPrice = parseFloat(itemPrice);
        await I.click(I.getElement(iBpoObject.COST_BOOKING_DETAILS_TAB));
        await I.waitForVisible(I.getElement(iBpoObject.GL_ACCOUNT));
        let glAccount = await I.grabTextFrom(I.getElement(iBpoObject.GL_ACCOUNT));
        glAccount = glAccount.substring(glAccount.indexOf(" ")+1);
        let array = new Array;
        array.push(supplierName);
        array.push(itemName);
        array.push(itemPrice);
        array.push(glAccount);
        return array;
    },
    async createAndReleaseBpoFlow(bpo) {
        bpo = await this.createBpoFlow(bpo);
        if(bpo.status.toString() === lmtVar.getLabel("IN_APPROVAL_STATUS")) {
            await this.approveBpoFlow(bpo.poNumber);
        }
        else {
            logger.info(`PO status after submission was ${bpo.status} and not ${lmtVar.getLabel("IN_APPROVAL_STATUS")}. Hence, not executing the Approve PO action.`);
        }
        return bpo;
    },
    async getReleaseOrderPoNumberHeader(){
        await I.waitForVisible(I.getElement(iBpoObject.RELEASE_ORDER_PO_NUMBER_HEADER));
        await I.scrollIntoView(I.getElement(iBpoObject.RELEASE_ORDER_PO_NUMBER_HEADER));
        let releaseOrderNumber = await I.grabTextFrom(I.getElement(iBpoObject.RELEASE_ORDER_PO_NUMBER_HEADER));
        releaseOrderNumber = releaseOrderNumber.substring(releaseOrderNumber.indexOf(":")+2);
        releaseOrderNumber = releaseOrderNumber.substring(0, releaseOrderNumber.indexOf(" "));
        return releaseOrderNumber;
    },
    async getReleaseOrderPoNumber(){

        await I.waitForVisible(I.getElement(iBpoObject.RELEASE_ORDER_TAB));
        await I.click(I.getElement(iBpoObject.RELEASE_ORDER_TAB));
        await I.waitForVisible(I.getElement(iBpoObject.RELEASE_ORDER_PO_NUMBER));
        let releaseOrderPONumber = await I.grabTextFrom(I.getElement(iBpoObject.RELEASE_ORDER_PO_NUMBER));
        return releaseOrderPONumber;

    },
    async viewBPO()
    {
        await I.waitForVisible(I.getElement(iBpoObject.BPO_VIEW));
        await I.click(I.getElement(iBpoObject.BPO_VIEW));

    },


    async clickOnReleaseOrderTab(){
        
        await I.waitForVisible("//*[contains(text(),'"+lmtVar.getLabel("RELEASE_ORDER_TAB")+"')]");
        await I.waitForClickable("//*[contains(text(),'"+lmtVar.getLabel("RELEASE_ORDER_TAB")+"')]");
        await I.click("//*[contains(text(),'"+lmtVar.getLabel("RELEASE_ORDER_TAB")+"')]");
    },

    async clickOnPoNumberLinkOnReleaseOrderTab(poNumber){
        
        await I.waitForVisible("//a[contains(text(),'"+poNumber+"')]");
        await I.waitForClickable("//a[contains(text(),'"+poNumber+"')]");
        await I.click("//a[contains(text(),'"+poNumber+"')]");
    },

    async checkReqNumberOnReleaseOrders(reqNumber)
    {
        
        let xpath = "//span[contains(text(),'"+reqNumber+"')]";
        await I.waitForVisible(xpath);
        let noOfElements = await I.grabNumberOfVisibleElements(xpath);
        let isPresent = false;
        if(noOfElements>0)
        {
            isPresent = true;
            logger.info("Requisition number is present on release order.")
        }
        else
        {
            logger.info("Requisition number is not present on release order.")
        }

        return isPresent;

    },



}