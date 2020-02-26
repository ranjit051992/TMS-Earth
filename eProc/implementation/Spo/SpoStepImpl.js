const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./iSpoObject");
const objectCreation = require("../../dataCreation/ObjectCreation")
const prop=require("../../../Framework/PropertiesConfigurator");
const spoImpl = require("./SPOImpl");
const items = require("../../bo/ItemsBo");
const catalogItem = require("../../bo/CatalogItem");


Given("i am on purchase order listing Page",() => {
    I.amOnPage(prop.poListingUrl)
   I.waitForInvisible(global.uiElements.get(iSpoObject.spinner),prop.DEFAULT_MEDIUM_WAIT);
   // const req = objectCreation.getObjectOfRequisition(2,"Catalog");
   // console.log("ReqName : "+req.reqName);
   // logger.info("ReqName : "+req.reqName);

});

Given(/^I Create Standard po with "(.*?)" "(.*?)" item$/, async function(noOfItems,itemType){

   
   const spo = objectCreation.getObjectOfStandardPO(noOfItems,itemType);
   logger.info("poNumber  : "+spo.poNumber)
   spoImpl.clickOnCreatePOButton();
   
   spoImpl.clickOnStandardPOButton();
   I.waitForInvisible(global.uiElements.get(iSpoObject.spinner),prop.DEFAULT_MEDIUM_WAIT);
   I.waitForVisible(global.uiElements.get(iSpoObject.poNumberTextbox),prop.DEFAULT_MEDIUM_WAIT);
   //spoImpl.fillPONumber(spo.poNumber);
   let poNumber = await spoImpl.fetchPONumber();
   // spo.setPoNumber(poNumber);
   //spoImpl.fillPODescription(spo.getPoDescription());
   spoImpl.fillPODescription(spo.poDescription);
   
   spoImpl.clickOnPurchaseTypeDropdown();
   spoImpl.selectPurchaseType(spo.purchaseType);

   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Supplier Details");
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
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"MST_Buyerandotherinformation");
   spoImpl.fillBuyer(spo.buyer);
   spoImpl.selectBuyer(spo.buyer);
   
   
    //click on cost Allocation tab
   spoImpl.clickOnCostAllocationTab();
   spoImpl.clickOnAssignCostNOButton();
   spoImpl.clickOnBookCostToSingle_MultipleCostCenter();
   spoImpl.enterCostCenter(spo.costCenter);
  // fillNonCoaAtHeaderLevel(spo);
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Line Items")
   // let item =items;
   // item = spo.items;
   // let catalogItemsSet = item.catalogItemSet;
   // let catalog = catalogItem;
   // for(catalog of catalogItemsSet)
   // {
   //  //catalogItem = catalog;
   //  spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Line Items")
   //  spoImpl.clickOnAddLineItemButton();
   //  spoImpl.enterItemName(catalog.itemName);
   //  spoImpl.selectItemOption( catalog.itemName);
   //  spoImpl.clickOnCostBookingLink( catalog.itemName);
   //  spoImpl.fillGlAccount(spo.glAccount);
   //  spoImpl.clickOnCostBookingSaveButton();

   // }
   spoImpl.clickOnAddLineItemButton();
spoImpl.enterItemName(spo.itemName);
spoImpl.selectItemOption(spo.itemName);
spoImpl.clickOnCostBookingLink(spo.itemName);
   
   spoImpl.fillGlAccount(spo.glAccount);
   spoImpl.clickOnCostBookingSaveButton();
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Taxes");
   spoImpl.clickOnRemoveAllTaxesButton();
   spoImpl.clickOnSubmitPOButton();
   spoImpl.clickOnConfirmButton();
   I.waitForInvisible(global.uiElements.get(iSpoObject.spinner),prop.DEFAULT_HIGH_WAIT);

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

Given("i search po by description",()=> {

    // logger.info("PO description is : "+ I.pod);
    
    
})