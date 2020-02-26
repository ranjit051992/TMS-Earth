const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./SpoObject");
const prop = require("../../../../Framework/PropertiesConfigurator");
const iConstants = require("../../../constants/iConstants");

module.exports = {
    clickOnCreatePOButton() {
        I.click(global.uiElements.get(iSpoObject.createPOButton));

    },
    async clickOnStandardPOButton() {
        I.click(global.uiElements.get(iSpoObject.standardPOButton));
        await I.waitForVisible(global.uiElements.get(iSpoObject.poNumberTextbox), prop.DEFAULT_MEDIUM_WAIT);
        I.saveScreenshot("CreateSpo.png");
        logger.info("Clicked on create standard po button.");
    },
    fillPONumber(poNumber) {
        I.fillField(global.uiElements.get(iSpoObject.poNumberTextbox), poNumber);
        logger.info("Filled po number :" + poNumber);
    },
    async  fetchPONumber() {
        let poNumber = await I.grabTextFrom(global.uiElements.get(iSpoObject.poNumberTextbox));
        logger.info("Filled po number :" + poNumber[0]);
        return poNumber[0];
    },
    fillPODescription(poDescription) {
        I.fillField(global.uiElements.get(iSpoObject.poDescriptionTextbox), poDescription);
        logger.info("Filled po description :" + poDescription);
    },
    clickOnPurchaseTypeDropdown() {
        I.click(global.uiElements.get(iSpoObject.purchaseTypeDropdown));
    },
    selectPurchaseType(purchaseType) {
        I.click("//a[contains(text(),'" + purchaseType + "')]");
        logger.info("Selected purchase type :" + purchaseType);
    },
    clickOnBuyingUnitLink() {
        I.click(global.uiElements.get(iSpoObject.BUYING_UNIT_LINK));
        logger.info("Clicked on Buying Unit link");
    },
    async fillCompany(company) {
        I.click(global.uiElements.get(iSpoObject.COMPANY_TEXTBOX));
        I.clearField(global.uiElements.get(iSpoObject.COMPANY_TEXTBOX));
        I.fillField(global.uiElements.get(iSpoObject.COMPANY_TEXTBOX), company);
        this.selectOrganizationUnitOption(company);
        company = await I.grabAttributeFrom(global.uiElements.get(iSpoObject.COMPANY_TEXTBOX), "value");
        logger.info(`Selected company --> ${company}`);
        return company;
    },
    async fillBusinessUnit(businessUnit) {
        I.click(global.uiElements.get(iSpoObject.BUSINESS_UNIT_TEXTBOX));
        I.clearField(global.uiElements.get(iSpoObject.BUSINESS_UNIT_TEXTBOX));
        I.fillField(global.uiElements.get(iSpoObject.BUSINESS_UNIT_TEXTBOX), businessUnit);
        this.selectOrganizationUnitOption(businessUnit);
        businessUnit = await I.grabAttributeFrom(global.uiElements.get(iSpoObject.BUSINESS_UNIT_TEXTBOX), "value");
        logger.info(`Selected business unit --> ${businessUnit}`);
        return businessUnit;
    },
    async fillLocation(location) {
        I.click(global.uiElements.get(iSpoObject.LOCATION_TEXTBOX));
        I.clearField(global.uiElements.get(iSpoObject.LOCATION_TEXTBOX));
        I.fillField(global.uiElements.get(iSpoObject.LOCATION_TEXTBOX), location);
        this.selectOrganizationUnitOption(location);
        location = await I.grabAttributeFrom(global.uiElements.get(iSpoObject.LOCATION_TEXTBOX), "value");
        logger.info(`Selected location --> ${location}`);
        return location;
    },
    async clickOnOuModalDoneButton() {
        I.click(global.uiElements.get(iSpoObject.OU_MODAL_DONE_BUTTON));
        await I.waitForInvisible(global.uiElements.get(iSpoObject.OU_MODAL_DONE_BUTTON));
        logger.info(`Clicked on OU modal Done button`);
    },
    async fetchBillToAddress() {
        let billToAddress = await I.grabTextFrom(global.uiElements.get(iSpoObject.BILL_TO_ADDRESS_VALUE));
        logger.info(`Clicked on OU modal Done button`);
        return billToAddress;
    },
    fillSupplierName(supplierName) {
        I.fillField(global.uiElements.get(iSpoObject.supplierNameTextbox), supplierName);
    },
    selectSupplierName(supplierName) {
        I.click("//p[@title='" + supplierName + "']");
        logger.info("Selected supplier name :" + supplierName);
    },
    fillSupplierAddress(address) {
        I.fillField(global.uiElements.get(iSpoObject.supplierAddressTextbox), address);
    },
    selectSupplierAddress(address) {
        I.click("//p[contains(text(),'" + address + "')]");
        logger.info("Selected supplier address :" + address);
    },
    clickOnPaymentTermDropdown() {
        I.click(global.uiElements.get(iSpoObject.paymentTermDropdown));
    },
    selectPaymentTerm(paymentTerm) {
        I.click("//div[contains(@title,'" + paymentTerm + "')]");
        logger.info("Selected payment term :" + paymentTerm);
    },
    clickOnDeliveryTermDropdown() {
        I.click(global.uiElements.get(iSpoObject.deliveryTermDropdown));
    },
    selectDeliveryTerm(deliveryTerm) {
        I.click("//div[contains(@title,'" + deliveryTerm + "')]");
        logger.info("Selected delivery term :" + deliveryTerm);
    },
    fillCurrency(currency) {
        I.fillField(global.uiElements.get(iSpoObject.currencyTextbox), currency);
    },
    selectCurrency(currency) {
        I.click("//span[contains(text(),'" + currency + "')]");
        logger.info("Selected currency :" + currency);
    },
    async fillBuyer(buyer) {
        I.fillField(global.uiElements.get(iSpoObject.buyerTextbox), buyer);
        this.selectBuyer(buyer);
        buyer = await I.grabAttributeFrom(global.uiElements.get(iSpoObject.buyerTextbox), "value");
        return buyer;
    },
    selectBuyer(buyer) {
        I.click("//span[contains(text(),'" + buyer + "')]");
        logger.info("Selected buyer :" + buyer);
    },
    async selectDeliverTo(deliverTo) {
        I.click(global.uiElements.get(iSpoObject.DELIVER_TO_TEXTBOX));
        I.clearField(global.uiElements.get(iSpoObject.DELIVER_TO_TEXTBOX));
        I.fillField(global.uiElements.get(iSpoObject.DELIVER_TO_TEXTBOX), deliverTo);
        this.selectDeliverToOption(deliverTo);
        deliverTo = await I.grabAttributeFrom(global.uiElements.get(iSpoObject.DELIVER_TO_TEXTBOX), "value");
        logger.info(`Selected deliverTo -->${deliverTo}`);
        return deliverTo;
    },
    async selectRequiredByDate() {
        logger.info("Selecting date");
        let day = new Date().getDate();
        let dayXpath = `//div[text()='${day}']/..`;
        I.click(global.uiElements.get(iSpoObject.REQUIRED_BY));
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
    async  clickonTab(tabList, tabName) {
        I.scrollIntoView("//dew-section//div[contains(text(),'" + tabName + "')]");
        I.wait(prop.DEFAULT_WAIT);
        logger.info(`Scrolled to section --> ${tabName}`);
    },
    clickOnCostAllocationTab() {
        I.seeElement(global.uiElements.get(iSpoObject.COST_ALLOCATION_TAB));
        I.click(global.uiElements.get(iSpoObject.COST_ALLOCATION_TAB));
        logger.info("Clicked on Cost Allocation Tab");
    },
    clickOnAssignCostNOButton() {
        I.seeElement(global.uiElements.get(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
        I.click(global.uiElements.get(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
        logger.info("Clicked on Assign cost Project No Button");
    },
    clickOnBookCostToSingle_MultipleCostCenter() {
        I.seeElement(global.uiElements.get(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
        I.click(global.uiElements.get(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
        logger.info("Clicked on Book Cost To Single/Multiple Cost center");
    },
    async enterCostCenter(costCenter) {
        I.seeElement(global.uiElements.get(iSpoObject.COST_CENTER_INPUT_FIELD));
        I.fillField(global.uiElements.get(iSpoObject.COST_CENTER_INPUT_FIELD), costCenter);
        const xpath = `//div[contains(text(),'${costCenter}')]`;
        I.waitForVisible(xpath, prop.DEFAULT_MEDIUM_WAIT);
        I.click(xpath);
        costCenter = await I.grabAttributeFrom(global.uiElements.get(iSpoObject.COST_CENTER_INPUT_FIELD), "value");
        logger.info(`Enter Cost Center: ${costCenter}`);
        return costCenter;
    },
    async selectReceiptCreationAtHeaderLevel() {
        await I.executeScript(function() {
            document.getElementById("customControlValidation2").click();
        });
        logger.info(`Selected Receipt Creation at Header Level`);
    },
    async selectDefaultReceiptCreation() {
        await I.executeScript(function() {
            document.getElementById("customRadioInline1").click();
        });
        logger.info(`Selected Default Receipt Creation`);
    },
    clickOnAddLineItemButton() {
        I.seeElement(global.uiElements.get(iSpoObject.ADD_LINE_ITEM_BUTTON));
        I.click(global.uiElements.get(iSpoObject.ADD_LINE_ITEM_BUTTON));
        logger.info("Clicked on Add Line Item Button");
    },
    enterItemName(itemName) {
        I.seeElement(global.uiElements.get(iSpoObject.ITEM_NAME_INPUT));
        I.fillField(global.uiElements.get(iSpoObject.ITEM_NAME_INPUT), itemName);
        logger.info(`Entered item name: ${itemName}`);
    },
    selectItemOption(itemName) {
        I.seeElement(global.uiElements.get(iSpoObject.FIRST_ITEMNAME_OPTION));
        I.click(global.uiElements.get(iSpoObject.FIRST_ITEMNAME_OPTION));
        logger.info(`Selected first item option: ${itemName}`);
    },
    clickOnCostBookingLink(itemName) {
        let costBookingLink = `(//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3])`;
        I.seeElement(costBookingLink);
        I.click(costBookingLink);
        logger.info("Clicked on Cost booking Link");
    },
    async fillGlAccount(glAccount) {
        I.seeElement(global.uiElements.get(iSpoObject.GLACCOUNT));
        I.fillField(global.uiElements.get(iSpoObject.GLACCOUNT), glAccount);
        let glAccountSuggXpath = `//div[contains(text(),'${glAccount}')]`;
        I.waitForVisible(glAccountSuggXpath, prop.DEFAULT_MEDIUM_WAIT);
        I.click(glAccountSuggXpath);
        glAccount = await I.grabAttributeFrom(global.uiElements.get(iSpoObject.GLACCOUNT), "value");
        logger.info(`Selected GlAccount: ${glAccount}`);
        return glAccount;
    },
    clickOnCostBookingSaveButton() {
        I.seeElement(global.uiElements.get(iSpoObject.COSTBOOKING_SAVE_BUUTON));
        I.click(global.uiElements.get(iSpoObject.COSTBOOKING_SAVE_BUUTON));
        logger.info("Clicked on Save Button");
    },
    clickOnRemoveAllTaxesButton() {
        I.seeElement(global.uiElements.get(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
        I.click(global.uiElements.get(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
        logger.info("Clicked on Remove All Taxes Button");
    },
    clickOnSubmitPOButton() {
        I.seeElement(global.uiElements.get(iSpoObject.SUBMIT_PO_BUTTON));
        I.click(global.uiElements.get(iSpoObject.SUBMIT_PO_BUTTON));
        logger.info("Clicked on Submit PO Button");
    },
    clickOnConfirmButton() {
        I.seeElement(global.uiElements.get(iSpoObject.CONFIRM_BUTTON));
        I.click(global.uiElements.get(iSpoObject.CONFIRM_BUTTON));
        logger.info("Clicked on Confirm button");
    },
    selectOrganizationUnitOption(option) {
        let optionXpath = `//div[contains(text(),'${option}')]`;
        I.seeElement(optionXpath);
        I.click(optionXpath);
        logger.info(`Selected option --> ${option}`);
    },
    selectDeliverToOption(option) {
        let optionXpath = `//span[contains(text(),'${option}')]`;
        I.seeElement(optionXpath);
        I.click(optionXpath);
        logger.info(`Selected Deliver To --> ${option}`);
    },
    async selectTaxInclusive() {
        await I.executeScript(function() {
            document.getElementById("inclusive1").click();
        });
        logger.info(`Selected Tax Inclusive`);
    },
    clickRemoveTaxesConfirmButton() {
        I.click(global.uiElements.get(iSpoObject.REMOVE_TAXES_CONFIRM_BUTTON));
        logger.info(`Clicked on Remove Taxes Confirm button`);
    },
    fillTermsAndConditions(termsAndConditions) {
        I.fillField(global.uiElements.get(iSpoObject.TERMS_AND_CONDITIONS_TEXTBOX), termsAndConditions);
        logger.info(`Entered terms and conditions --> ${termsAndConditions}`);
    },
    fillNotes(notes) {
        I.fillField(global.uiElements.get(iSpoObject.NOTES_TEXTBOX), notes);
        logger.info(`Entered notes --> ${notes}`);
    },
    async fetchRequiredBy() {
        let requiredBy = await I.grabAttributeFrom(global.uiElements.get(iSpoObject.REQUIRED_BY), "value");
        logger.info(`Selected Required By -->${requiredBy}`);
        return requiredBy;
    },
    async createSpoFlow(spo) {

        this.clickOnCreatePOButton();

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

        return spo;
    },
    async fillBasicDetails(spo) {
        logger.info(`**************Filling Basic Details**************`);
        this.fillPONumber(spo.poNumber);
        this.fillPODescription(spo.poDescription);
        this.clickOnPurchaseTypeDropdown();
        this.selectPurchaseType(spo.purchaseType);
        return spo;
    },
    async fillBillingInformation(spo) {
        logger.info(`**************Filling Billing Information**************`);
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_BILLING_INFORMATION_SECTION);
        this.clickOnBuyingUnitLink();
        await this.fillCompany(spo.company);
        await this.fillBusinessUnit(spo.businessUnit);
        await this.fillLocation(spo.location);
        await this.clickOnOuModalDoneButton();
        spo.setBillToAddress(this.fetchBillToAddress());
        return spo;
    },
    async fillSupplierDetails(spo) {
        logger.info(`**************Filling Supplier Details**************`);
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_SUPPLIER_DETAILS_SECTION);
        this.fillSupplierName(spo.supplierName);
        this.selectSupplierName(spo.supplierName);
        this.fillSupplierAddress(spo.supplierAddress);
        this.selectSupplierAddress(spo.supplierAddress)
        this.clickOnPaymentTermDropdown();
        this.selectPaymentTerm(spo.paymentTerm);
        this.clickOnDeliveryTermDropdown();
        this.selectDeliveryTerm(spo.deliveryTerm);
        this.fillCurrency(spo.currency);
        this.selectCurrency(spo.currency);
        return spo
    },
    async fillBuyerAndOtherInformation(spo) {
        logger.info(`**************Filling Buyer and Other Information**************`);
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_BUYER_AND_OTHER_INFORMATION_SECTION);
        let buyer = await this.fillBuyer(spo.buyer);
        spo.setBuyer(buyer);
        return spo
    },
    async fillShippingDetails(spo) {
        logger.info(`**************Filling Shipping Details**************`);
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_SHIPPING_DETAILS_SECTION);
        let deliverTo = await this.selectDeliverTo(spo.deliverTo);
        spo.setDeliverTo(deliverTo);
        // await this.selectRequiredByDate();
        let requiredBy = this.fetchRequiredBy();
        spo.setRequiredBy(requiredBy);
        return spo;
    },
    async fillCostAllocation(spo) {
        logger.info(`**************Filling Cost Allocation**************`);
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_COST_ALLOCATION_SECTION);
        this.clickOnAssignCostNOButton();
        this.clickOnBookCostToSingle_MultipleCostCenter();
        let costCenter = await this.enterCostCenter(spo.costCenter);
        spo.setCostCenter(costCenter);
        return spo;
    },
    async fillControlSettings(spo) {
        logger.info(`**************Filling Control Settings**************`);
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_CONTROL_SETTINGS_SECTION);
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
            await this.selectTaxInclusive();
            this.clickRemoveTaxesConfirmButton();
        }
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_LINE_ITEMS_SECTION);
        this.clickOnAddLineItemButton();
        this.enterItemName(spo.itemName);
        this.selectItemOption(spo.itemName);
        this.clickOnCostBookingLink(spo.itemName);

        let glAccount = await this.fillGlAccount(spo.glAccount);
        spo.setGlAccount(glAccount);
        this.clickOnCostBookingSaveButton();
        return spo;
    },
    async fillTaxes(spo) {
        logger.info(`**************Filling Taxes**************`);
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_TAXES_SECTION_SECTION);
        this.clickOnRemoveAllTaxesButton();
        return spo;
    },
    async fillAdditionalDetails(spo) {
        logger.info(`**************Filling Additional Details**************`);
        this.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_ADDITIONAL_DETAILS_SECTION);
        this.fillTermsAndConditions(spo.termsAndConditions);
        this.fillNotes(spo.notes);
        return spo;
    },
    async submitPo() {
        logger.info(`**************Submitting SPO**************`);
        this.clickOnSubmitPOButton();
        this.clickOnConfirmButton();
        await I.waitForVisible(global.uiElements.get(iSpoObject.spinner));
        await I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_HIGH_WAIT);
        logger.info("Waited for loader to go off after submitting spo");
    },

}