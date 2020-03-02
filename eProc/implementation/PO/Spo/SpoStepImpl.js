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
const poListingObject = require("../PoListing/PoListingObject");
const commonKeywordObject = require("../../../commonKeywords/CommonComponentObject");
const approvalObject = require("../../Approval/ApprovalObject");

Given("I am on PO listing page", async function () {
   await poListingImpl.navigateToPoListing();
});

Given("I Create Standard po with {int} {string} item", async function (noOfItems, itemType) {
   this.spo = await objectCreation.getObjectOfStandardPO(noOfItems, itemType);
   //this.spo.poNumber = "Automation_Spo_1583163241883";
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
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
   await spoImpl.clickOnAddLineItemButton();
   await spoImpl.enterItemName(this.spo.items[0].itemName);
   await spoImpl.selectItemOption(this.spo.items[0].itemName);
});

When("I add costing and accounting details for that item", async function() {
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
   await spoImpl.clickOnCostBookingLink(this.spo.items[0].itemName);
   let glAccount = await spoImpl.fillGlAccount(this.spo.glAccount);
   this.spo.setGlAccount(glAccount);
   await spoImpl.clickOnCostBookingSaveButton();
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_TAXES_SECTION_SECTION"));
   await spoImpl.selectTaxInclusive();
   await spoImpl.clickRemoveTaxesConfirmButton();
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
   await poListingImpl.navigateToPoListing();
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
   // this.spo.poNumber = "Automation_spo_287139784";
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
   await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
});

When("I edit the drafted PO", async function() {
   await poListingImpl.clickOnEditAction();
});

When("I add 1 catalog item {string}", async function(itemName1) {
   this.spo.items[1] = objectCreation.getArrayOfItems(1, "Catalog");
   this.spo.items[1].itemName = await I.getData(itemName1);
   logger.info(`Retrieved item from db --> ${this.spo.items[1].itemName}`);
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
   await spoImpl.clickOnAddLineItemButton();
   await spoImpl.enterItemName(this.spo.items[1].itemName);
   await spoImpl.selectItemOption(this.spo.items[1].itemName);
   await spoImpl.clickOnCostBookingLink(this.spo.items[1].itemName);

   let glAccount = await I.getData("GL_ACCOUNT");
   await spoImpl.fillGlAccount(glAccount);
   await spoImpl.clickOnCostBookingSaveButton();
});

Then("Item should be added {string} at index {int}", async function(itemName1, index) {
   let itemNameFromDb = I.getData(itemName1);
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_VIEW_LINE_ITEMS_SECTION"));
   let itemName = await spoImpl.getItemNameOnSpoView(index);
   I.assertEqual(itemName.toString(), itemNameFromDb.toString());
});

Given("I have submitted a SPO with a catalog item", async function() {
   this.spo = await objectCreation.getObjectOfStandardPO(1, "Catalog");
   this.spo = await spoImpl.createSpoFlow(this.spo);
});

Given("the PO is in In Approval status", async function() {
   await poListingImpl.navigateToPoListing();
   await commonKeywordImpl.searchDocOnListing(this.spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
   let status = await poListingImpl.getPoStatus();
   let flag = status.toString() === lmtVar.getLabel("IN_APPROVAL_STATUS");
   if(!flag) {
      logger.info(`PO status is not ${lmtVar.getLabel("IN_APPROVAL_STATUS")}. Current status is ${status}`);
      throw new Error(`PO status is not ${lmtVar.getLabel("IN_APPROVAL_STATUS")}. Current status is ${status}`);
   }
   else {
      logger.info(`PO status is ${lmtVar.getLabel("SEARCH_BY_DOC_NUMBER")}`);
   }
});

When("I click on Remind approver action against the PO", async function() {
   await poListingImpl.clickOnRemindApproverAction();
});

Then("I should be able to send reminder to the approver", async function() {
   await poListingImpl.clickOnSuccessPopupDoneButton();
});

When("I view the PO", async function() {
   await poListingImpl.clickOnPoNumber();
});

When("I click on Cancel PO action within Actions tab", async function() {
   await commonKeywordImpl.clickOnActionMenuIcon();
   await spoImpl.clickOnSpoViewActionMenuOption(lmtVar.getLabel("CANCEL"));
});

When("I fill Cancel comments", async function() {
   await spoImpl.fillViewSpoCancelPopupComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
});

When("I click on Cancel PO button on the confirmation Popup", async function() {
   await spoImpl.clickOnViewSpoPopupCancelButton();
});

Given( "I have {int} POs In Approval status", async function() {
   await spoImpl.checkMultiplePOStatus();
});

Then("I should be able to see the PO in Cancelled status", async function() {
   await poListingImpl.clickOnSuccessPopupDoneButton();
   await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
   await commonKeywordImpl.searchDocOnListing(this.spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
   let status = await poListingImpl.getPoStatus();
   let flag = status.toString() === lmtVar.getLabel("CANCELLED_STATUS");
   if(!flag) {
      logger.info(`PO status is not ${lmtVar.getLabel("CANCELLED_STATUS")}. Current status is --> ${status}`);
      throw new Error(`PO status is not ${lmtVar.getLabel("CANCELLED_STATUS")}. Current status is --> ${status}`);
   }
   else {
      logger.info("PO is Cancelled successfully");
   }
});

When("I click on Amend PO", async function() {
   await commonKeywordImpl.clickOnActionMenuOption(lmtVar.getLabel("AMEND_PO"));
});

When("I add amend PO comments", async function() {
   await spoImpl.fillAmendPoComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
});

When("I submit the amendment", async function() {
   await spoImpl.submitPo();
   await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
});

When("I view the amended PO", async function() {
   await poListingImpl.clickOnPoNumber();
});

When("I scroll to Line Item section", async function() {
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
});

When("I click on Shipping Details link for item {string}", async function(itemName1) {
   let itemName = await I.getData(itemName1);
   await spoImpl.clickOnShippingDetailsLink(itemName);
});

When("I change the delivery address at line level to {string}", async function(address1) {
   let address = await I.getData(address1);
   await spoImpl.fillLineLevelAddress(address);
});

When("I save the delivery address", async function() {
   await spoImpl.clickOnCostBookingSaveButton();
   await I.seeElement(I.getElement(iSpoObject.poDescriptionTextbox));
});

Then("{string} delivery address should be displayed", async function(address1) {
   let addressFromDb = await I.getData(address1);
   let address = await spoImpl.getViewSpoLineLevelAddress();
   let flag = address.toString().includes(addressFromDb.toString());
   I.assertEqual(true, flag);
});

When("I change the payment term at line level to {string}", async function(paymentTerm1) {
   let paymentTerm = await I.getData(paymentTerm1);
   await spoImpl.clickOnPaymentTermDropdown();
   await spoImpl.selectPaymentTerm(paymentTerm);
});

When("I scroll to Supplier Details section", async function() {
   await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_SUPPLIER_DETAILS_SECTION"));
});

Then("{string} payment term should be displayed", async function(paymentTerm1) {
   let paymentTermFromDb = await I.getData(paymentTerm1);
   let paymentTerm = await spoImpl.getSpoViewPaymentTermValue();
   I.assertEqual(paymentTerm.toString(), paymentTermFromDb.toString());
});

Given( "I have PO with In Approval status", async function() {
   await I.waitForVisible(I.getElement(poListingObject.SEARCH_TEXTBOX));
   await commonKeywordImpl.searchDocOnListing(this.spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
   let status = await poListingImpl.getPoStatus();
   I.assertEqual(status.toString(), lmtVar.getLabel("IN_APPROVAL_STATUS"));
});