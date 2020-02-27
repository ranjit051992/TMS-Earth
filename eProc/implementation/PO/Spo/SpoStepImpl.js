const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./SpoObject");
const objectCreation = require("../../../dataCreation/ObjectCreation")
const prop = require("../../../../Framework/PropertiesConfigurator");
const spoImpl = require("./SpoImpl");
const catalogItem = require("../../../bo/CatalogItem");
const iConstants = require("../../../constants/iConstants");
// const spo = require("../../bo/Spo");


Given("i am on purchase order listing Page", () => {
   I.amOnPage(prop.poListingUrl)
   I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_MEDIUM_WAIT);
});

Given(/^I Create Standard po with "(.*?)" "(.*?)" item$/, async (noOfItems, itemType) => {


   const spo = objectCreation.getObjectOfStandardPO(noOfItems, itemType);
   //const spo = require("../../bo/Spo");
   logger.info("poNumber  : " + spo.poNumber)
   spoImpl.clickOnCreatePOButton();

   spoImpl.clickOnStandardPOButton();
   I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_MEDIUM_WAIT);
   I.waitForVisible(global.uiElements.get(iSpoObject.poNumberTextbox), prop.DEFAULT_MEDIUM_WAIT);

   logger.info(`**************Filling Basic Details**************`);
   //spoImpl.fillPONumber(spo.poNumber);
   let poNumber = await spoImpl.fetchPONumber();
   // spo.setPoNumber(poNumber);
   //spoImpl.fillPODescription(spo.getPoDescription());
   spoImpl.fillPODescription(spo.poDescription);
   spoImpl.clickOnPurchaseTypeDropdown();
   spoImpl.selectPurchaseType(spo.purchaseType);


   logger.info(`**************Filling Billing Information**************`);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_BILLING_INFORMATION_SECTION);
   spoImpl.clickOnBuyingUnitLink();
   await spoImpl.fillCompany(spo.company);
   await spoImpl.fillBusinessUnit(spo.businessUnit);
   await spoImpl.fillLocation(spo.location);
   spoImpl.clickOnOuModalDoneButton();
   spoImpl.fetchBillToAddress();

   logger.info(`**************Filling Supplier Details**************`);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_SUPPLIER_DETAILS_SECTION);
   spoImpl.fillSupplierName(spo.supplierName);
   spoImpl.selectSupplierName(spo.supplierName);
   spoImpl.fillSupplierAddress(spo.supplierAddress);
   // spoImpl.selectSupplierAddress(spo.getSupplierAddress());
   spoImpl.selectSupplierAddress(spo.supplierAddress)
   spoImpl.clickOnPaymentTermDropdown();
   spoImpl.selectPaymentTerm(spo.paymentTerm);
   spoImpl.clickOnDeliveryTermDropdown();
   spoImpl.selectDeliveryTerm(spo.deliveryTerm);
   spoImpl.fillCurrency(spo.currency);
   spoImpl.selectCurrency(spo.currency);

   logger.info(`**************Filling Buyer and Other Information**************`);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_BUYER_AND_OTHER_INFORMATION_SECTION);
   spoImpl.fillBuyer(spo.buyer);
   spoImpl.selectBuyer(spo.buyer);

   logger.info(`**************Filling Shipping Details**************`);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_SHIPPING_DETAILS_SECTION);
   spoImpl.selectDeliverTo(spo.deliverTo);
   // await spoImpl.selectRequiredByDate();

   logger.info(`**************Filling Cost Allocation**************`);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_COST_ALLOCATION_SECTION);
   //click on cost Allocation tab
   spoImpl.clickOnCostAllocationTab();
   spoImpl.clickOnAssignCostNOButton();
   spoImpl.clickOnBookCostToSingle_MultipleCostCenter();
   spoImpl.enterCostCenter(spo.costCenter);
   // fillNonCoaAtHeaderLevel(spo);

   logger.info(`**************Filling Control Settings**************`);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_CONTROL_SETTINGS_SECTION);
   if (spo.receiptRuleAtHeaderLevel) {
      spoImpl.selectReceiptCreationAtHeaderLevel();
      if (spo.receiptCreationDefault) {
         spoImpl.selectDefaultReceiptCreation();
      }
   }


   logger.info(`**************Filling Line Items**************`);
   if(spo.taxInclusive) {
      spoImpl.selectTaxInclusive();
      spoImpl.clickRemoveTaxesConfirmButton();
   }
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_LINE_ITEMS_SECTION);
   spoImpl.clickOnAddLineItemButton();
   //    let item = spo.items;
   //    let catalogItemsSet = item.catalogItemSet;
   //    catalogItemsSet.forEach(function(value)
   //    {
   //     catalogItem = value;
   //     spoImpl.enterItemName(catalogItem.itemName);
   //     spoImpl.selectItemOption( catalogItem.itemName);
   //     spoImpl.clickOnCostBookingLink( catalogItem.itemName);


   //   });
   spoImpl.enterItemName(spo.itemName);
   spoImpl.selectItemOption(spo.itemName);
   spoImpl.clickOnCostBookingLink(spo.itemName);

   spoImpl.fillGlAccount(spo.glAccount);
   spoImpl.clickOnCostBookingSaveButton();

   logger.info(`**************Filling Taxes**************`);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_TAXES_SECTION_SECTION);
   spoImpl.clickOnRemoveAllTaxesButton();

   logger.info(`**************Filling Taxes**************`);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_ADDITIONAL_DETAILS_SECTION);


   spoImpl.clickOnSubmitPOButton();
   spoImpl.clickOnConfirmButton();
   I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_HIGH_WAIT);

   //    spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Supplier Details");
   //    spoImpl.fillSupplierName(spo.getSupplierName());
   //    spoImpl.selectSupplierName(spo.getSupplierName());
   //    spoImpl.fillSupplierAddress(spo.getSupplierAddress());
   //    // spoImpl.selectSupplierAddress(spo.getSupplierAddress());
   //    spoImpl.selectSupplierAddress(spo.supplierAddress)
   //    spoImpl.clickOnPaymentTermDropdown();
   //    spoImpl.selectPaymentTerm(spo.getPaymentTerm());
   //    spoImpl.clickOnDeliveryTermDropdown();
   //    spoImpl.selectDeliveryTerm(spo.getDeliveryTerm());
   //    spoImpl.fillCurrency(spo.getCurrency());
   //    spoImpl.selectCurrency(spo.getCurrency());
   //    spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"MST_Buyerandotherinformation");
   //    spoImpl.fillBuyer(spo.getBuyer());
   //    spoImpl.selectBuyer(spo.getBuyer());


   //     //click on cost Allocation tab
   //    spoImpl.clickOnCostAllocationTab();
   //    spoImpl.clickOnAssignCostNOButton();
   //    spoImpl.clickOnBookCostToSingle_MultipleCostCenter();
   //    spoImpl.enterCostCenter(spo.getCostCenter());
   //   // fillNonCoaAtHeaderLevel(spo);
   //    spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Line Items")
   //    spoImpl.clickOnAddLineItemButton()
   //    spoImpl.enterItemName(spo.getItemName());
   //    spoImpl.selectItemOption(spo.getItemName());
   //    spoImpl.clickOnCostBookingLink(spo.getItemName());
   //    spoImpl.fillGlAccount(spo.getGlAccount());
   //    spoImpl.clickOnCostBookingSaveButton();
   //    spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Taxes");
   //    spoImpl.clickOnRemoveAllTaxesButton();
   //    spoImpl.clickOnSubmitPOButton();
   //    spoImpl.clickOnConfirmButton();
   // //     I.waitForInvisible(global.uiElements.get(iSpoObject.spinner),prop.DEFAULT_HIGH_WAIT);



});

Given("i search po by description", () => {

   // logger.info("PO description is : "+ I.pod);

});

