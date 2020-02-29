const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const iSpoObject = require("./SpoObject");
const objectCreation = require("../../../dataCreation/ObjectCreation")
const prop = global.confi_prop;
const spoImpl = require("./SpoImpl");
const catalogItem = require("../../../dataCreation/bo/CatalogItem");
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");
const poListingImpl = require("../PoListing/PoListingImpl");

Given("I am on PO listing page", async function () {
   await poListingImpl.navigateToPoListing();
});

Given("I Create Standard po with {string} {string} item", async function (noOfItems, itemType) {
   this.spo = await objectCreation.getObjectOfStandardPO(noOfItems, itemType);
   this.spo = await spoImpl.createSpoFlow(this.spo);
});

Given( "I Create {int} Standard po with {string} {string} item", async function (noOfPOs, noOfItems, itemType) {
   this.POArray = await spoImpl.createMultiplePOs(noOfPOs, noOfItems, itemType);
   logger.info("Required number of POs created")
});

When("I click on Create PO button", async function() {
   await spoImpl.clickOnCreatePOButton();
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
   spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_BASIC_DETAILS_SECTION"));
   spoImpl.selectPurchaseType(this.spo.purchaseType);
});

When("I add Required by date", async function() {
   spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_SHIPPING_DETAILS_SECTION"));
   let requiredBy = await spoImpl.fetchRequiredBy()
   this.spo.setRequiredBy(requiredBy);
});

When("I search catalog item with {string}", async function(itemName) {
   spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
   spoImpl.clickOnAddLineItemButton();
   spoImpl.enterItemName(this.spo.items[0].itemName);
   spoImpl.selectItemOption(this.spo.items[0].itemName);
});

When("I add costing and accounting details for that item", async function() {
   spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
   spoImpl.clickOnCostBookingLink(this.spo.itemName);
   let glAccount = await spoImpl.fillGlAccount(this.spo.glAccount);
   this.spo.setGlAccount(glAccount);
   spoImpl.clickOnCostBookingSaveButton();
});

When("I add 1 free text item with details", async function() {
   spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
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
   await I.amOnPage(prop.poListingUrl)
   await commonKeywordImpl.searchDocOnListing(this.spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

When("I click on option icon", async function() {
   await commonKeywordImpl.clickOnActionMenuIcon();
});

When("I click on Recall option", async function() {
   await commonKeywordImpl.clickOnActionMenuOption(lmtVar.getLabel("RECALL_ACTION_MENU_OPTION"));
});

When("I enter recall comments", async function() {
   await poListingImpl.fillRecallApprovalRequestComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
});

When("I click on Recall button", async function() {
   await poListingImpl.clickOnRecallButton();
});

When("I click on recalled success message Done button", async function() {
   await poListingImpl.clickOnRecalledSuccessDoneButton();
});

Then("PO status should be draft", async function() {
   let status = await poListingImpl.getPoStatus();
   I.assertEqual(status.toString(), lmtVar.getLabel("DRAFT_STATUS"));
});

Then("I should be able to view the SPO with multiple items", async function() {

});

Then("I should be able to download attachments", async function() {

});

Then("PO status should be draft", async function() {
   let status = await poListingImpl.getPoStatus();
   I.assertEqual(status.toString(), lmtVar.getLabel("DRAFT_STATUS"));
});

Given("I have created and released a PO", async function() {
   this.spo = await objectCreation.getObjectOfStandardPO(1, "Catalog");
   this.spo.poNumber = "blue sanity -/1728";
   this.spo = await spoImpl.createAndReleaseSpoFlow(this.spo);
});

When("I click on Close PO action against the PO", async function() {
   await commonKeywordImpl.clickOnActionMenuOption(lmtVar.getLabel("CLOSE_ACTION_MENU_OPTION"));
});

When("I enter close PO comments", async function() {
   await poListingImpl.fillClosePoComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
});

When("I click on Close PO button on the confirmation Popup", async function() {
   await poListingImpl.clickOnClosePoButton();
});

When("I click on closed po success message Done button", async function() {
   await poListingImpl.clickOnClosedPoSuccessDoneButton();
});

Then("I should be able to see the PO in closed status", async function() {
   let status = await poListingImpl.getPoStatus();
   I.assertEqual(status.toString(), lmtVar.getLabel("CLOSED_STATUS"));
});

When("I Save PO as draft", async function() {
   await spoImpl.clickOnSaveAsDraftButton();
});

When("I edit the drafted PO", async function() {
   await poListingImpl.clickOnEditAction();
});

When("I add 1 catalog item", async function() {
   // this.spo.items.push();     add data from db
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
   await spoImpl.clickOnAddLineItemButton();
   await spoImpl.enterItemName(spo.items[1].itemName);
   await spoImpl.selectItemOption(spo.items[1].itemName);
   await spoImpl.clickOnCostBookingLink(spo.items[1].itemName);

   let glAccount = await await spoImpl.fillGlAccount(spo.glAccount);
   spo.setGlAccount(glAccount);
   await spoImpl.clickOnCostBookingSaveButton();
});

Then("PO should be saved", async function() {
   await poListingImpl.navigateToPoListing();
   let docNumber = await commonKeywordImpl.getDocNumber();
   I.assertEqual(docNumber.toString(), this.spo.poNumber);
});

Then("Item should be added", async function() {
   await commonKeywordImpl.viewDocByDocNumber(this.spo.poNumber);
   await I.seeElement(I.getElement(iSpoObject.PO_VIEW_BASIC_DETAILS_SECTION));
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_VIEW_LINE_ITEMS_SECTION"));
   let itemName = await spoImpl.getItemNameOnSpoView(2);
   I.assertEqual(itemName.toString(), this.spo.items[1].itemName);
});

Given( "I have {int} POs In Approval status", async function() {
   await spoImpl.checkMultiplePOStatus();
});
