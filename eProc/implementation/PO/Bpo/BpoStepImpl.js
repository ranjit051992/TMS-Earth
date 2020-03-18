const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const iSpoObject = require("../Spo/SpoObject");
const objectCreation = require("../../../dataCreation/ObjectCreation")
const prop = global.confi_prop;
const spoImpl = require("../Spo/SpoImpl");
const catalogItem = require("../../../dataCreation/bo/CatalogItem");
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");
const poListingImpl = require("../PoListing/PoListingImpl");
const poListingObject = require("../PoListing/PoListingObject");
const coaImpl = require("../../Coa/CoaImpl");
const iBpoObject = require("./BpoObject");
const bpoImpl =require("./BpoImpl");
const checkoutImp = require("../../Requisition/Checkout/CheckoutImpl");
const approveImpl = require("../../Approval/ApprovalImpl")

Given("I am on PO listing page", async function () {
    await poListingImpl.navigateToPoListing();
 });
 
Given("I Create Blanket po with {int} {string} item", async function (noOfItems, itemType) {
    this.bpo = await objectCreation.getObjectOfBlanketPO(noOfItems, itemType);
    this.bpo = await bpoImpl.createBpoFlow(this.bpo);
  await I.wait(30);
 });

 Given("I approve the BPO", async function(){
      await bpo
 });

 When("I click on Create Blanket PO button", async function(){
      await spoImpl.clickOnCreatePOButton();
      await bpoImpl.clickOnBlanketPOButton();
 });

 When("I add all required details in BPO with {int} {string} item", async function(noOfItems, itemType){
     this.bpo = await objectCreation.getObjectOfBlanketPO(noOfItems, itemType);
      this.bpo = await bpoImpl.addAllRequiredDetails(this.bpo);
 });

 When("I update the spend limit", async function(){
   this.orderValue = await bpoImpl.updateOrderValue(this.bpo);
 });

 When("I add attachment {string}", async function(filePath){

     await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("BPO_ADD_ATTACHMENT_SECTION"));
     filePath = I.getData(filePath);
     logger.info("File path is : "+filePath);
     await bpoImpl.addAttachment(filePath);
     this.attachment = filePath;
 });

 When("I submit the BPO", async function(){
        await bpoImpl.submitPo();
 });

 Then("I should be able to view the BPO with Order Value entered", async function(){
    let orderValueView = await bpoImpl.getOrderValue();
      I.assertEqual(this.orderValue, orderValueView);
});

//  Then("I should be able to see the BPO in Cancelled status", async function(){

//  });

 Then("I should be able to view the BPO with the attachments", async function(){
    await spoImpl.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("BPO_ADD_ATTACHMENT_SECTION"));
    let status = await checkoutImp.checkAddedAttachment(this.attachment);
    I.assertEqual(status, true);
 });

 Then("I should be able to view the BPO with Validity To and From dates selected", async function(){
    let fromDateView = await I.grabTextFrom(I.getElement(iBpoObject.FROM_DATE_VIEW));
    let toDateView = await I.grabTextFrom(I.getElement(iBpoObject.TO_DATE_VIEW));
    I.assertEqual(fromDateView, this.bpo.fromDate);
    I.assertEqual(toDateView, this.bpo.toDate);
 });
When("I add attachment at header level", async function(){
      await bpoImpl.addAttachment(this.bpo.attachmentPath);
 });

Then("I should be able to see the BPO in Cancelled status", async function(){

 });

Given( "I have BPO with In Approval status", async function() {
   await I.amOnPage(prop.poListingUrl);
   await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
   await commonKeywordImpl.searchDocOnListing(this.bpo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
   let status = await poListingImpl.getPoStatus();
   logger.info(`Retrived status is --> ${status}`);
   I.assertEqual(status.toString(), lmtVar.getLabel("IN_APPROVAL_STATUS"));
   this.bpo.buyer = global.displayName;
   logger.info(`this.bpo.buyer --> ${this.bpo.buyer} || global.displayName --> ${global.displayName}`);
});

Given( "I Create {int} Blanket POs with {int} {string} item", async function (noOfPOs, noOfItems, itemType) {
   this.bpoArray = await bpoImpl.createMultipleBPOs(noOfPOs, noOfItems, itemType);
   logger.info("Required number of BPOs created");
});



 Given("I search bpo and navigate to release order tab", async function(){
   await commonKeywordImpl.searchDocOnListing(this.bpo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
   await poListingImpl.clickOnPoNumber(this.bpo.poNumber);
   await bpoImpl.clickOnReleaseOrderTab();
   
 });

 Then("I should be able to see BPO Release Order page on convert to PO", async function(){
   
   await bpoImpl.clickOnPoNumberLinkOnReleaseOrderTab(this.bpo.poNumber);
   let isPresent = await bpoImpl.checkReqNumberOnReleaseOrders(this.reqBO.reqNumber);
   I.assertEqual(isPresent, true);
 });
