const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./SpoObject");
const objectCreation = require("../../../dataCreation/ObjectCreation")
const prop = require("../../../../Framework/PropertiesConfigurator");
const spoImpl = require("./SpoImpl");
const catalogItem = require("../../../bo/CatalogItem");
const iConstants = require("../../../constants/iConstants");
const commonKeywordImpl = require("../../../commonComponent/CommonComponent");
const poListingImpl = require("../PoListing/PoListingImpl");

Given("I am on PO listing page", async function () {
   I.amOnPage(prop.poListingUrl)
   await I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_MEDIUM_WAIT);
});

Given("I Create Standard po with {string} {string} item", async function (noOfItems, itemType) {
   this.spo = await objectCreation.getObjectOfStandardPO(noOfItems, itemType);
   this.spo = await spoImpl.createSpoFlow(this.spo);
});

When("I click on Create PO button", async function() {
   spoImpl.clickOnCreatePOButton();
});

When("I click on Create SPO button", async function() {
   this.spo = await objectCreation.getObjectOfStandardPO(1, "Catalog");
   await spoImpl.clickOnStandardPOButton();
});

When("I fetch PO number", async function() {
   let poNumber = await spoImpl.fetchPONumber();
   this.spo.setPoNumber(poNumber);
});

When("I fill Order Description", async function() {
   await spoImpl.fillPODescription(this.spo.poDescription);
});

When("I select supplier details", async function() {
   await spoImpl.fillSupplierDetails(spo);
});

When("I select Buyer", async function() {
   let buyer = spoImpl.fillBuyer(this.spo.buyer);
   this.spo.setBuyer(buyer);
});

When("I add Purchase type", async function() {
   await spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_BASIC_DETAILS_SECTION);
   await spoImpl.selectPurchaseType(this.spo.purchaseType);
});

When("I add Required by date", async function() {
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_SHIPPING_DETAILS_SECTION);
   let requiredBy = await spoImpl.fetchRequiredBy()
   this.spo.setRequiredBy(requiredBy);
});

When("I search catalog item with {string}", async function(itemName) {
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_LINE_ITEMS_SECTION);
   spoImpl.clickOnAddLineItemButton();
   spoImpl.enterItemName(this.spo.items[0].itemName);
   spoImpl.selectItemOption(this.spo.items[0].itemName);
});

When("I add costing and accounting details for that item", async function() {
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_LINE_ITEMS_SECTION);
   spoImpl.clickOnCostBookingLink(this.spo.items[0].itemName);
   let glAccount = await spoImpl.fillGlAccount(this.spo.glAccount);
   this.spo.setGlAccount(glAccount);
   spoImpl.clickOnCostBookingSaveButton();
});

When("I add 1 free text item with details", async function() {
   spoImpl.clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST), iConstants.SPO_LINE_ITEMS_SECTION);
   spoImpl.clickOnAddLineItemButton();
   spoImpl.enterItemName(this.spo.items[0].itemName);
   spoImpl.selectItemOption(this.spo.items[0].itemName);
});

When("I add attachment at header level", async function() {
   //need to write code to add attachment
});

When("I submit the PO", async function() {
   await spoImpl.submitPo();
});

When("I search for the created po", async function() {
   
});

When("I click on option icon", async function() {
   await commonKeywordImpl.clickOnActionMenuIcon();
});

When("I click on Recall option", async function() {
   await commonKeywordImpl.clickOnActionMenuOption(iConstants.RECALL_ACTION_MENU_OPTION);
});

When("I enter recall comments", async function() {
   await poListingImpl.fillRecallApprovalRequestComments(iConstants.AUTO_GENERATED_COMMENT);
});

When("I click on Recall button", async function() {
   await poListingImpl.clickOnRecallButton();
});

When("I click on recalled success message Done button", async function() {
   await poListingImpl.clickOnRecalledSuccessDoneButton();
});

Then("PO status should be draft", async function() {
   
});

Then("I should be able to view the SPO with multiple items", async function() {

});

Then("I should be able to download attachments", async function() {

});