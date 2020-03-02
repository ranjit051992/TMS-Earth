const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./SpoObject");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");
const approvalImpl = require("../../Approval/ApprovalImpl");
const poListingImpl = require("../PoListing/PoListingImpl");
const poListingObject = require("../PoListing/PoListingObject");

module.exports = {
    async clickOnCreatePOButton() {
        await I.waitForVisible(I.getElement(iSpoObject.createPOButton));
        await I.click(I.getElement(iSpoObject.createPOButton));
        logger.info("Clicked on Create PO button");
    },
    async clickOnStandardPOButton() {
        await I.waitForVisible(I.getElement(iSpoObject.standardPOButton));
        await I.click(I.getElement(iSpoObject.standardPOButton));
        await I.waitForVisible(I.getElement(iSpoObject.poNumberTextbox), prop.DEFAULT_MEDIUM_WAIT);
        I.saveScreenshot("CreateSpo.png");
        logger.info("Clicked on create standard po button.");
    },
    async fillPONumber(poNumber) {
        await I.waitForVisible(I.getElement(iSpoObject.poNumberTextbox));
        await I.fillField(I.getElement(iSpoObject.poNumberTextbox), poNumber);
        logger.info("Filled po number :" + poNumber);
    },
    async fetchPONumber() {
        let poNumber = await I.grabAttributeFrom(I.getElement(iSpoObject.poNumberTextbox), "value");
        logger.info("Fetched po number :" + poNumber);
        return poNumber;
    },
    async fillPODescription(poDescription) {
        await I.waitForVisible(I.getElement(iSpoObject.poDescriptionTextbox));
        await I.fillField(I.getElement(iSpoObject.poDescriptionTextbox), poDescription);
        logger.info("Filled po description :" + poDescription);
    },
    async clickOnPurchaseTypeDropdown() {
        await I.waitForVisible(I.getElement(iSpoObject.purchaseTypeDropdown));
        await I.click(I.getElement(iSpoObject.purchaseTypeDropdown));
    },
    async selectPurchaseType(purchaseType) {
        await this.clickOnPurchaseTypeDropdown();
        await I.waitForVisible("//a[contains(text(),'" + purchaseType + "')]");
        await I.click("//a[contains(text(),'" + purchaseType + "')]");
        logger.info("Selected purchase type :" + purchaseType);
    },
    async clickOnBuyingUnitLink() {
        await I.waitForVisible(I.getElement(iSpoObject.BUYING_UNIT_LINK));
        await I.click(I.getElement(iSpoObject.BUYING_UNIT_LINK));
        logger.info("Clicked on Buying Unit link");
    },
    async fillCompany(company) {
        await I.waitForVisible(I.getElement(iSpoObject.COMPANY_TEXTBOX));
        await I.click(I.getElement(iSpoObject.COMPANY_TEXTBOX));
        await I.clearField(I.getElement(iSpoObject.COMPANY_TEXTBOX));
        await I.fillField(I.getElement(iSpoObject.COMPANY_TEXTBOX), company);
        await this.selectOrganizationUnitOption(company);
        company = await I.grabAttributeFrom(I.getElement(iSpoObject.COMPANY_TEXTBOX), "value");
        logger.info(`Selected company --> ${company}`);
        return company;
    },
    async fillBusinessUnit(businessUnit) {
        await I.waitForVisible(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX));
        await I.click(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX));
        await I.clearField(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX));
        await I.fillField(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX), businessUnit);
        await this.selectOrganizationUnitOption(businessUnit);
        businessUnit = await I.grabAttributeFrom(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX), "value");
        logger.info(`Selected business unit --> ${businessUnit}`);
        return businessUnit;
    },
    async fillLocation(location) {
        await I.waitForVisible(I.getElement(iSpoObject.LOCATION_TEXTBOX));
        await I.click(I.getElement(iSpoObject.LOCATION_TEXTBOX));
        await I.clearField(I.getElement(iSpoObject.LOCATION_TEXTBOX));
        await I.fillField(I.getElement(iSpoObject.LOCATION_TEXTBOX), location);
        await this.selectOrganizationUnitOption(location);
        location = await I.grabAttributeFrom(I.getElement(iSpoObject.LOCATION_TEXTBOX), "value");
        logger.info(`Selected location --> ${location}`);
        return location;
    },
    async clickOnOuModalDoneButton() {
        await I.waitForVisible(I.getElement(iSpoObject.OU_MODAL_DONE_BUTTON));
        await I.click(I.getElement(iSpoObject.OU_MODAL_DONE_BUTTON));
        await I.waitForInvisible(I.getElement(iSpoObject.OU_MODAL_DONE_BUTTON));
        logger.info(`Clicked on OU modal Done button`);
    },
    async fetchBillToAddress() {
        await I.waitForVisible(I.getElement(iSpoObject.BILL_TO_ADDRESS_VALUE));
        let billToAddress = await I.grabTextFrom(I.getElement(iSpoObject.BILL_TO_ADDRESS_VALUE));
        logger.info(`Clicked on OU modal Done button`);
        return billToAddress;
    },
    async fillSupplierName(supplierName) {
        await I.waitForVisible(I.getElement(iSpoObject.supplierNameTextbox), supplierName);
        await I.fillField(I.getElement(iSpoObject.supplierNameTextbox), supplierName);
    },
    async selectSupplierName(supplierName) {
        let supplierNameXpath = "//p[@title='" + supplierName + "']";
        await I.waitForVisible(supplierNameXpath);
        await I.click(supplierNameXpath);
        logger.info("Selected supplier name :" + supplierName);
    },
    async fillSupplierAddress(address) {
        await I.waitForVisible(I.getElement(iSpoObject.supplierAddressTextbox), address);
        await I.fillField(I.getElement(iSpoObject.supplierAddressTextbox), address);
    },
    async selectSupplierAddress(address) {
        let supplierAddressXpath = "//p[contains(text(),'" + address + "')]";
        await I.waitForVisible(supplierAddressXpath);
        await I.click(supplierAddressXpath);
        logger.info("Selected supplier address :" + address);
    },
    async clickOnPaymentTermDropdown() {
        await I.waitForVisible(I.getElement(iSpoObject.paymentTermDropdown));
        await I.click(I.getElement(iSpoObject.paymentTermDropdown));
    },
    async selectPaymentTerm(paymentTerm) {
        let paymentTermXpath = "//div[contains(@title,'" + paymentTerm + "')]";
        await I.scrollIntoView(paymentTermXpath);
        await I.wait(prop.DEFAULT_WAIT);
        await I.waitForVisible(paymentTermXpath);
        await I.click(paymentTermXpath);
        logger.info("Selected payment term :" + paymentTerm);
        return paymentTerm;
    },
    async clickOnDeliveryTermDropdown() {
        await I.waitForVisible(I.getElement(iSpoObject.deliveryTermDropdown));
        await I.click(I.getElement(iSpoObject.deliveryTermDropdown));
    },
    async selectDeliveryTerm(deliveryTerm) {
        let deliveryTermXpath = "//div[contains(@title,'" + deliveryTerm + "')]";
        await I.waitForVisible(deliveryTermXpath);
        await I.click(deliveryTermXpath);
        logger.info("Selected delivery term :" + deliveryTerm);
    },
    async fillCurrency(currency) {
        await I.waitForVisible(I.getElement(iSpoObject.currencyTextbox));
        await I.fillField(I.getElement(iSpoObject.currencyTextbox), currency);
    },
    async selectCurrency(currency) {
        let currencyXpath = "//span[contains(text(),'" + currency + "')]";
        await I.waitForVisible(currencyXpath);
        await I.click(currencyXpath);
        logger.info("Selected currency :" + currency);
    },
    async fillBuyer(buyer) {
        await I.waitForVisible(I.getElement(iSpoObject.buyerTextbox));
        await I.fillField(I.getElement(iSpoObject.buyerTextbox), buyer);
        await this.selectBuyer(buyer);
        buyer = await I.grabAttributeFrom(I.getElement(iSpoObject.buyerTextbox), "value");
        return buyer;
    },
    async selectBuyer(buyer) {
        await I.waitForVisible("//span[contains(text(),'" + buyer + "')]");
        await I.click("//span[contains(text(),'" + buyer + "')]");
        logger.info("Selected buyer :" + buyer);
    },
    async selectDeliverTo(deliverTo) {
        await I.waitForVisible(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX));
        await I.click(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX));
        await I.clearField(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX));
        await I.fillField(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX), deliverTo);
        await this.selectDeliverToOption(deliverTo);
        deliverTo = await I.grabAttributeFrom(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX), "value");
        logger.info(`Selected deliverTo -->${deliverTo}`);
        return deliverTo;
    },
    async selectRequiredByDate() {
        logger.info("Selecting date");
        let day = new Date().getDate();
        let dayXpath = `//div[text()='${day}']/..`;
        I.click(I.getElement(iSpoObject.REQUIRED_BY));
        let numberOfElements = await I.grabNumberOfVisibleElements(dayXpath);
        for (let i = 0; i < numberOfElements; i++) {
            dayXpath = `(//div[text()='${day}']/..)[${i + 1}]`;
            try {
                await I.waitForEnabled(dayXpath, 2);
                logger.info(`Date enabled for xpath --> ${dayXpath}`);
                I.click(dayXpath);
                logger.info(`Clicked on date ${day}`);
                break;
            } catch (e) {
                logger.info(`Date disabled for xpath --> ${dayXpath}`);
            }

            if (i == numberOfElements) {
                throw new Error(`Day --> ${day} not present in the datepicker`);
            }
        }
    },
    async clickonTab(tabList, tabName) {
        await I.scrollIntoView("//dew-section//div[contains(text(),'" + tabName + "')]");
        await I.wait(prop.DEFAULT_WAIT);
        logger.info(`Scrolled to section --> ${tabName}`);
    },
    async clickOnCostAllocationTab() {
        await I.waitForVisible(I.getElement(iSpoObject.COST_ALLOCATION_TAB));
        await I.click(I.getElement(iSpoObject.COST_ALLOCATION_TAB));
        logger.info("Clicked on Cost Allocation Tab");
    },
    async clickOnAssignCostNOButton() {
        await I.waitForVisible(I.getElement(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
        await I.click(I.getElement(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
        logger.info("Clicked on Assign cost Project No Button");
    },
    async clickOnBookCostToSingle_MultipleCostCenter() {
        await I.waitForVisible(I.getElement(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
        await I.click(I.getElement(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
        logger.info("Clicked on Book Cost To Single/Multiple Cost center");
    },
    async enterCostCenter(costCenter) {
        await I.waitForVisible(I.getElement(iSpoObject.COST_CENTER_INPUT_FIELD));
        await I.fillField(I.getElement(iSpoObject.COST_CENTER_INPUT_FIELD), costCenter);
        const xpath = `//div[contains(text(),'${costCenter}')]`;
        await I.waitForVisible(xpath, prop.DEFAULT_MEDIUM_WAIT);
        await I.click(xpath);
        costCenter = await I.grabAttributeFrom(I.getElement(iSpoObject.COST_CENTER_INPUT_FIELD), "value");
        logger.info(`Enter Cost Center: ${costCenter}`);
        return costCenter;
    },
    async selectReceiptCreationAtHeaderLevel() {
        await I.waitForElement(I.getElement(iSpoObject.RECEIPT_CREATION_HEADER_LEVEL_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iSpoObject.RECEIPT_CREATION_HEADER_LEVEL_BUTTON));
        logger.info("Selected Receipt Creation at Header Level");
    },
    async selectDefaultReceiptCreation() {
        await I.waitForElement(I.getElement(iSpoObject.RECEIPT_HEADER_LEVEL_DEFAULT_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iSpoObject.RECEIPT_HEADER_LEVEL_DEFAULT_RADIO_BUTTON));
        logger.info("Selected Default Receipt Creation");
    },
    async clickOnAddLineItemButton() {
        await I.waitForVisible(I.getElement(iSpoObject.ADD_LINE_ITEM_BUTTON));
        await I.click(I.getElement(iSpoObject.ADD_LINE_ITEM_BUTTON));
        logger.info("Clicked on Add Line Item Button");
    },
    async enterItemName(itemName) {
        await I.waitForVisible(I.getElement(iSpoObject.ITEM_NAME_INPUT));
        await I.fillField(I.getElement(iSpoObject.ITEM_NAME_INPUT), itemName);
        logger.info(`Entered item name: ${itemName}`);
    },
    async selectItemOption(itemName) {
        await I.waitForVisible(I.getElement(iSpoObject.FIRST_ITEMNAME_OPTION));
        await I.click(I.getElement(iSpoObject.FIRST_ITEMNAME_OPTION));
        logger.info(`Selected first item option: ${itemName}`);
    },
    async clickOnCostBookingLink(itemName) {
        let costBookingLink = `(//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3])`;
        await I.waitForVisible(costBookingLink);
        await I.click(costBookingLink);
        logger.info("Clicked on Cost booking Link");
    },
    async fillGlAccount(glAccount) {
        await I.waitForVisible(I.getElement(iSpoObject.GLACCOUNT));
        await I.fillField(I.getElement(iSpoObject.GLACCOUNT), glAccount);
        let glAccountSuggXpath = `//div[contains(text(),'${glAccount}')]`;
        await I.waitForVisible(glAccountSuggXpath, prop.DEFAULT_MEDIUM_WAIT);
        await I.click(glAccountSuggXpath);
        glAccount = await I.grabAttributeFrom(I.getElement(iSpoObject.GLACCOUNT), "value");
        logger.info(`Selected GlAccount: ${glAccount}`);
        return glAccount;
    },
    async clickOnCostBookingSaveButton() {
        await I.waitForVisible(I.getElement(iSpoObject.COSTBOOKING_SAVE_BUUTON));
        await I.click(I.getElement(iSpoObject.COSTBOOKING_SAVE_BUUTON));
        await I.waitForVisible(I.getElement(iSpoObject.poDescriptionTextbox));
        logger.info("Clicked on Save Button");
    },
    async clickOnRemoveAllTaxesButton() {
        await I.waitForVisible(I.getElement(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
        await I.click(I.getElement(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
        logger.info("Clicked on Remove All Taxes Button");
    },
    async clickOnSubmitPOButton() {
        await I.waitForVisible(I.getElement(iSpoObject.SUBMIT_PO_BUTTON));
        await I.click(I.getElement(iSpoObject.SUBMIT_PO_BUTTON));
        logger.info("Clicked on Submit PO Button");
    },
    async clickOnConfirmButton() {
        await I.waitForVisible(I.getElement(iSpoObject.CONFIRM_BUTTON));
        await I.click(I.getElement(iSpoObject.CONFIRM_BUTTON));
        logger.info("Clicked on Confirm button");
    },
    async selectOrganizationUnitOption(option) {
        let optionXpath = `//div[contains(text(),'${option}')]`;
        await I.waitForVisible(optionXpath);
        await I.click(optionXpath);
        logger.info(`Selected option --> ${option}`);
    },
    async selectDeliverToOption(option) {
        let optionXpath = `//span[contains(text(),'${option}')]`;
        await I.waitForVisible(optionXpath);
        await I.click(optionXpath);
        logger.info(`Selected Deliver To --> ${option}`);
    },
    async selectTaxInclusive() {
        await I.waitForElement(I.getElement(iSpoObject.SPO_TAX_INCLUSIVE));
        let selected = await commonKeywordImpl.isSelectedByXpath(I.getElement(iSpoObject.SPO_TAX_INCLUSIVE));
        if(!selected) {
            await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iSpoObject.SPO_TAX_INCLUSIVE));
            logger.info("Selected Tax Inclusive");
        }
        else {
            logger.info("Tax Inclusive is already selected");
        }
    },
    async clickRemoveTaxesConfirmButton() {
        let flag = await commonKeywordImpl.waitForElementVisible(I.getElement(iSpoObject.REMOVE_TAXES_CONFIRM_BUTTON), 90);
        if(flag) {
            await I.click(I.getElement(iSpoObject.REMOVE_TAXES_CONFIRM_BUTTON));
            logger.info("Clicked on Remove taxes confirm button");
        }
        else {
            logger.info("Remove taxes confirm button not displayed");
        }
    },
    async fillTermsAndConditions(termsAndConditions) {
        await I.waitForVisible(I.getElement(iSpoObject.TERMS_AND_CONDITIONS_TEXTBOX));
        await I.fillField(I.getElement(iSpoObject.TERMS_AND_CONDITIONS_TEXTBOX), termsAndConditions);
        logger.info(`Entered terms and conditions --> ${termsAndConditions}`);
    },
    async fillNotes(notes) {
        await I.waitForVisible(I.getElement(iSpoObject.NOTES_TEXTBOX));
        await I.fillField(I.getElement(iSpoObject.NOTES_TEXTBOX), notes);
        logger.info(`Entered notes --> ${notes}`);
    },
    async fetchRequiredBy() {
        await I.waitForVisible(I.getElement(iSpoObject.REQUIRED_BY));
        let requiredBy = await I.grabAttributeFrom(I.getElement(iSpoObject.REQUIRED_BY), "value");
        logger.info(`Selected Required By -->${requiredBy}`);
        return requiredBy;
    },
    async createSpoFlow(spo) {
        await poListingImpl.navigateToPoListing();

        await this.clickOnCreatePOButton();

        await this.clickOnStandardPOButton();

        spo = await this.fillBasicDetails(spo);

        spo = await this.fillBillingInformation(spo);

        spo = await this.fillSupplierDetails(spo);

        spo = await this.fillBuyerAndOtherInformation(spo);

        spo = await this.fillShippingDetails(spo);

        spo = await this.fillCostAllocation(spo);

        spo = await this.fillControlSettings(spo);

        spo = await this.fillLineItems(spo);

        spo = await this.fillTaxes(spo);

        spo = await this.fillAdditionalDetails(spo);

        await this.submitPo();

        await poListingImpl.navigateToPoListing();

        await commonKeywordImpl.searchDocOnListing(spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));

        let poNumber = await commonKeywordImpl.getDocNumber();

        if(!poNumber.toString() === spo.poNumber) {
            logger.info(`PO is not submitted. PO number fetched after submission --> ${poNumber}`);
            throw new Error(`PO is not submitted. PO number fetched after submission --> ${poNumber}`);
        }

        return spo;
    },
    async fillBasicDetails(spo) {
        logger.info(`**************Filling Basic Details**************`);
        await this.fillPONumber(spo.poNumber);
        await this.fillPODescription(spo.poDescription);
        await this.selectPurchaseType(spo.purchaseType);
        return spo;
    },
    async fillBillingInformation(spo) {
        logger.info(`**************Filling Billing Information**************`);
        await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_BILLING_INFORMATION_SECTION"));
        await this.clickOnBuyingUnitLink();
        await this.fillCompany(spo.company);
        await this.fillBusinessUnit(spo.businessUnit);
        await this.fillLocation(spo.location);
        await this.clickOnOuModalDoneButton();
        spo.setBillToAddress(this.fetchBillToAddress());
        return spo;
    },
    async fillSupplierDetails(spo) {
        logger.info(`**************Filling Supplier Details**************`);
        await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_SUPPLIER_DETAILS_SECTION"));
        await this.fillSupplierName(spo.supplierName);
        await this.selectSupplierName(spo.supplierName);
        await this.fillSupplierAddress(spo.supplierAddress);
        await this.selectSupplierAddress(spo.supplierAddress)
        await this.clickOnPaymentTermDropdown();
        await this.selectPaymentTerm(spo.paymentTerm);
        await this.clickOnDeliveryTermDropdown();
        await this.selectDeliveryTerm(spo.deliveryTerm);
        await this.fillCurrency(spo.currency);
        await this.selectCurrency(spo.currency);
        return spo
    },
    async fillBuyerAndOtherInformation(spo) {
        logger.info(`**************Filling Buyer and Other Information**************`);
        await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_BUYER_AND_OTHER_INFORMATION_SECTION"));
        let buyer = await this.fillBuyer(spo.buyer);
        spo.setBuyer(buyer);
        return spo
    },
    async fillShippingDetails(spo) {
        logger.info(`**************Filling Shipping Details**************`);
        await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_SHIPPING_DETAILS_SECTION"));
        let deliverTo = await this.selectDeliverTo(spo.deliverTo);
        spo.setDeliverTo(deliverTo);
        // await this.selectRequiredByDate();
        let requiredBy = await this.fetchRequiredBy();
        spo.setRequiredBy(requiredBy);
        return spo;
    },
    async fillCostAllocation(spo) {
        logger.info(`**************Filling Cost Allocation**************`);
        await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_COST_ALLOCATION_SECTION"));
        await this.clickOnAssignCostNOButton();
        await this.clickOnBookCostToSingle_MultipleCostCenter();
        let costCenter = await this.enterCostCenter(spo.costCenter);
        spo.setCostCenter(costCenter);
        return spo;
    },
    async fillControlSettings(spo) {
        logger.info(`**************Filling Control Settings**************`);
        await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_CONTROL_SETTINGS_SECTION"));
        if (spo.receiptRuleAtHeaderLevel) {
            await this.selectReceiptCreationAtHeaderLevel();
            if (spo.receiptCreationDefault) {
                await this.selectDefaultReceiptCreation();
            }
        }
        return spo;
    },
    async fillLineItems(spo) {
        logger.info(`**************Filling Line Items**************`);
        if(spo.taxInclusive) {
            await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_TAXES_SECTION_SECTION"));
            await this.selectTaxInclusive();
            await this.clickRemoveTaxesConfirmButton();
        }

        for(let i = 0; i < spo.items.length; i++) {
            await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
            await this.clickOnAddLineItemButton();
            await this.enterItemName(spo.items[i].itemName);
            await this.selectItemOption(spo.items[i].itemName);
            await this.clickOnCostBookingLink(spo.items[i].itemName);
            let glAccount = await this.fillGlAccount(spo.glAccount);
            // spo.setGlAccount(glAccount);
            await this.clickOnCostBookingSaveButton();
        }

        return spo;
    },
    async fillTaxes(spo) {
        logger.info(`**************Filling Taxes**************`);
        await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_TAXES_SECTION_SECTION"));
        await this.clickOnRemoveAllTaxesButton();
        return spo;
    },
    async fillAdditionalDetails(spo) {
        logger.info(`**************Filling Additional Details**************`);
        await this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_ADDITIONAL_DETAILS_SECTION"));
        await this.fillTermsAndConditions(spo.termsAndConditions);
        await this.fillNotes(spo.notes);
        return spo;
    },
    async submitPo() {
        logger.info(`**************Submitting SPO**************`);
        await this.clickOnSubmitPOButton();
        await this.clickOnConfirmButton();
        await I.waitForVisible(I.getElement(iSpoObject.spinner));
        await I.waitForInvisible(I.getElement(iSpoObject.spinner), prop.DEFAULT_HIGH_WAIT);
        logger.info("Waited for loader to go off after submitting spo");
    },
    async createAndReleaseSpoFlow(spo) {
        spo = await this.createSpoFlow(spo);
        await this.navigateToApprovalListing();
        //  click on spo tab
        await approvalImpl.approveDoc(spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        await poListingImpl.navigateToPoListing();
        await commonKeywordImpl.searchDocOnListing(spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        let status = await poListingImpl.getPoStatus();
        let flag = status.includes(lmtVar.getLabel("RELEASED_STATUS"));
        if(!flag) {
            logger.info(`Failed to release spo because status is ${status} on po listing after approving`);
            throw new Error(`Failed to release spo because status is ${status} on po listing after approving`);
        }
        else {
            logger.info("Spo is released successfully");
        }
        return spo;
    },
    async clickOnSaveAsDraftButton() {
        let saveAsDraftButtonXpath = `//button[contains(@aria-label,'${lmtVar.getLabel("SAVE_AS_DRAFT")}')]`;
        logger.info(`Save as Draft button xpath --> ${saveAsDraftButtonXpath}`);
        await I.waitForVisible(saveAsDraftButtonXpath);
        await I.click(saveAsDraftButtonXpath);
        logger.info("Clicked on Save as Draft button");
    },
    async getItemNameOnSpoView(index) {
        let itemNameXpath = `(//eproc-line-items-view//span[contains(@class,'text-body-link')])[${index}]`;
        await I.waitForVisible(itemNameXpath);
        let itemName = await I.grabTextFrom(itemNameXpath);
        logger.info(`Retrieved item name --> ${itemName}`);
        return itemName;
    },
    async clickOnSpoViewActionMenuOption(option) {
        let optionXpath = `//div[contains(text(),'${option}')]`;
        await I.scrollIntoView(optionXpath);
        I.wait(prop.DEFAULT_WAIT);
        await I.waitForVisible(optionXpath);
        await I.click(optionXpath);
        logger.info(`Clicked on option --> ${option}`);
    },
    async fillViewSpoCancelPopupComments(comments) {
        await I.waitForVisible(I.getElement(iSpoObject.CANCEL_SPO_POPUP_COMMENTS_TEXTAREA));
        await I.click(I.getElement(iSpoObject.CANCEL_SPO_POPUP_COMMENTS_TEXTAREA));
        await I.clearField(I.getElement(iSpoObject.CANCEL_SPO_POPUP_COMMENTS_TEXTAREA));
        await I.fillField(I.getElement(iSpoObject.CANCEL_SPO_POPUP_COMMENTS_TEXTAREA), comments);
        logger.info(`Entered comments --> ${comments}`);
    },
    async clickOnViewSpoPopupCancelButton() {
        await I.waitForVisible(I.getElement(iSpoObject.CANCEL_SPO_POPUP_CANCEL_BUTTON));
        await I.click(I.getElement(iSpoObject.CANCEL_SPO_POPUP_CANCEL_BUTTON));
        logger.info("Clicked on Cancel button");
    },
    async fillAmendPoComments(comments) {
        await I.scrollIntoView(I.getElement(iSpoObject.AMEND_PO_COMMENTS_TEXTAREA));
        await I.wait(prop.DEFAULT_WAIT);
        await I.waitForVisible(I.getElement(iSpoObject.AMEND_PO_COMMENTS_TEXTAREA));
        await I.click(I.getElement(iSpoObject.AMEND_PO_COMMENTS_TEXTAREA));
        await I.clearField(I.getElement(iSpoObject.AMEND_PO_COMMENTS_TEXTAREA));
        await I.fillField(I.getElement(iSpoObject.AMEND_PO_COMMENTS_TEXTAREA), comments);
        logger.info(`Entered po amend comments --> ${comments}`);
    },
    async clickOnShippingDetailsLink(itemName) {
        let shippingDetailsLinkXpath = `(//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[1])`;
        await I.waitForVisible(shippingDetailsLinkXpath);
        await I.click(shippingDetailsLinkXpath);
        logger.info("Clicked on Shipping Details Link");
    },
    async fillLineLevelAddress(address) {
        address = await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iSpoObject.LINE_LEVEL_ADDRESS_TEXTBOX), address, I.getElement(iSpoObject.LINE_LEVEL_ADDRESS_OPTION));
        logger.info(`Selected delivery address --> ${address}`);
        return address;
    },
    async getViewSpoLineLevelAddress() {
        await I.waitForVisible(I.getElement(iSpoObject.VIEW_SPO_LINE_LEVEL_ADDRESS));
        let address = await I.grabTextFrom(I.getElement(iSpoObject.VIEW_SPO_LINE_LEVEL_ADDRESS));
        logger.info(`Retrieved address --> ${address}`);
        return address;
    },
    async getSpoViewPaymentTermValue() {
        let paymentTermXpath = `//eproc-supplier-information-view//div[contains(text(),'${lmtVar.getLabel("PAYMENT_TERMS_LABEL")}')]/../following-sibling::div`;
        logger.info(`paymentTermXpath --> ${paymentTermXpath}`);
        await I.waitForVisible(paymentTermXpath);
        let paymentTerm = await (await I.grabTextFrom(paymentTermXpath, "value")).toString().trim();
        logger.info("Retrieved payment term :" + paymentTerm);
        return paymentTerm;
    },

}