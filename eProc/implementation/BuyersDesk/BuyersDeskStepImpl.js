const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const iBuyersDeskObject = require("./BuyersDeskObject");
const objectCreation = require("../../dataCreation/ObjectCreation")
const requisition = require("../../dataCreation/bo/Requisition")
const prop = global.confi_prop;
const buyersDeskImpl = require("./BuyersDeskImpl");
const approvalImpl = require("./../Approval/ApprovalImpl")
const checkoutImpl = require("./../Requisition/Checkout/CheckoutImpl");
const cartImpl = require("./../Requisition/Cart/CartImpl");
const onlineStoreImpl = require("./../Requisition/Cart/CartImpl");

When("I navigate to Buyers Desk", async function() {
  

 });

 When("I navigate to Buyer Desk {string} {string}", async function(noOfItems, itemType) {
    let reqBo= objectCreation.getObjectOfRequisition(noOfItems, itemType);
    this.reqBO = await checkoutImpl.createRequisitionFlow(reqBo);
    requisition.reqNumber = await checkoutImpl.fetchCreatedRequisitionNumber();
    logger.info('Requisition number created is : '+requisition.reqNumber);
    requisition.reqName = await checkoutImpl.fetchCreatedRequisitionName();
    logger.info('Requisiton Name is : '+reqBo.reqName);
    I.amOnPage(prop.DDS_AllRequests_Url);
    await approvalImpl.approveDoc(requisition.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    I.amOnPage(prop.DDS_BuyersDesk_Url)   

 });

 When("I filter with Requisition number field", async function() {
   logger.info("Requsition number to be searched is "+requisition.reqNumber);
  await buyersDeskImpl.SearchRequisitionNumber(requisition.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));


 });

 When("I filter with requisition name field", async function() {
  logger.info("Requsition name to be searched is "+requisition.reqName);
  await buyersDeskImpl.SearchRequisitionNumber(requisition.reqName, lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION"));
});

 When("I select multiple requisition with same currency, supplier, delivery address from listing page", async function() {
 
   
 });

 Then("I should be see the data on the page on the basis on Requisition number field", async function() {
  
  let searchedReqNo = await buyersDeskImpl.fetchSearchedRequisitionNumber();
  I.assertEqual(searchedReqNo.toString(), requisition.reqNumber);

});

Then("I should be see the data on the page on the basis on requisition name field", async function() {
  
  let searchedReqName = await buyersDeskImpl.fetchSearchedRequisitionName();
  I.assertEqual(searchedReqName.toString(), requisition.reqName);

})
