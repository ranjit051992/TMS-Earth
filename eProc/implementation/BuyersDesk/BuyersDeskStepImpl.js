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
const onlineStore = require("../Requisition/OnlineStore/OnlineStoreObject");

When("I navigate to Buyer Desk", async function() {
  await buyersDeskImpl.navigateToBuyerListing();
});

When ("I create {string} requisition with {string} {string}", async function(noOfReq,noOfItems,itemType){
  let reqNumberArray = new Array();
  for(let i =0;i<noOfReq;i++)
            {
              let reqBo= await objectCreation.getObjectOfRequisition(noOfItems, itemType);
              logger.info('requisition: '+reqBo);
              this.reqBO = await checkoutImpl.createRequisitionFlow(reqBo);
              let reqNumber = await checkoutImpl.fetchCreatedRequisitionNumber();
              requisition.reqNumber = await checkoutImpl.fetchCreatedRequisitionNumber();
              requisition.reqName = await checkoutImpl.fetchCreatedRequisitionName();
              reqNumberArray[i] = reqNumber;
              await buyersDeskImpl.navigateToOnlineStore();
            }
     logger.info('Requisitions number created are : '+reqNumberArray);
     requisition.reqNumbers = reqNumberArray;
});

When("I Approve {string} Requisitions",async function(noOfReq){
  await buyersDeskImpl.navigateToAllRequests();
     for(let i =0;i<noOfReq;i++)
     {
      await approvalImpl.approveDoc(requisition.reqNumbers[i], lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
      let status = await approvalImpl.checkPOApprovalStatus(requisition.reqNumbers[i], lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
      logger.info(`Status of requisition captured is ${status}`);
     }
});

// When("I navigate to Buyers Desk {string} {string} {string}", async function(noOfItems, itemType, noOfReq) {
//   let reqNumberArray = new Array();
//   for(let i =0;i<noOfReq;i++)
//             {
//               let reqBo= objectCreation.getObjectOfRequisition(noOfItems, itemType);
//               this.reqBO = await checkoutImpl.createRequisitionFlow(reqBo);
//               let reqNumber = await checkoutImpl.fetchCreatedRequisitionNumber();
//               reqNumberArray[i] = reqNumber;
//               I.amOnPage(prop.DDS_OnlineStore_Url);
//               I.waitForVisible(I.getElement(onlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
//             }
//      logger.info('Requisitions number created are : '+reqNumberArray);
//      requisition.reqNumbers = reqNumberArray;
     
//      I.amOnPage(prop.DDS_AllRequests_Url);
//      for(let i =0;i<noOfReq;i++)
//      {
//       await approvalImpl.approveDoc(requisition.reqNumbers[i], lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
//      }
//      I.amOnPage(prop.DDS_BuyersDesk_Url);

//  });

//  When("I navigate to Buyer Desk {string} {string}", async function(noOfItems, itemType) {
//     let reqBo= objectCreation.getObjectOfRequisition(noOfItems, itemType);
//     this.reqBO = await checkoutImpl.createRequisitionFlow(reqBo);
//     requisition.reqNumber = await checkoutImpl.fetchCreatedRequisitionNumber();
//     logger.info('Requisition number created is : '+requisition.reqNumber);
//     requisition.reqName = await checkoutImpl.fetchCreatedRequisitionName();
//     logger.info('Requisiton Name is : '+reqBo.reqName);
//     I.amOnPage(prop.DDS_AllRequests_Url);
//     await approvalImpl.approveDoc(requisition.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
//     I.amOnPage(prop.DDS_BuyersDesk_Url); 

//  });

 When("I filter with Requisition number field", async function() {
   logger.info("Requsition number to be searched is "+requisition.reqNumber);
  await buyersDeskImpl.SearchRequisitionNumber(requisition.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));


 });

 When("I filter with requisition name field", async function() {
  logger.info("Requsition name to be searched is "+requisition.reqName);
  await buyersDeskImpl.SearchRequisitionNumber(requisition.reqName, lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION"));
});

 When("I select {string} requisition with same currency, supplier, delivery address from listing page", async function(noOfreq) {
 
  for(let i=0;i<noOfreq;i++){
    await buyersDeskImpl.SearchRequisitionNumber(requisition.reqNumbers[i], lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    await buyersDeskImpl.selectRequisitionCheckbox();
  }
   
 });

 When("I filter any buyer {string}", async function(buyerName) {
    logger.info("Buyer to be searched is "+I.getData(buyerName));
    await buyersDeskImpl.SearchBuyer(buyerName, lmtVar.getLabel("SEARCH_BY_BUYER"));
     
  });

  When("I convert it to PO from listing", async function(){
    await buyersDeskImpl.convertToPO();
  });


When("I navigate to Upcoming Requisition", async function(){
  await buyersDeskImpl.navigateToUpcomingRequisition();
});

When("I filter with Requestor field", async function(){
  requisition.requestor = (global.users.get("USERNAME"));
  logger.info("Requester to be searched is "+ requisition.requestor);
  await buyersDeskImpl.SearchRequester(requisition.requestor);
});


 Then("I should be see the data on the page on the basis on Requisition number field", async function() {
  
  let searchedReqNo = await buyersDeskImpl.fetchSearchedRequisitionNumber();
  I.assertEqual(searchedReqNo.toString(), requisition.reqNumber);

});

Then("I should be see the data on the page on the basis on requisition name field", async function() {
  
  let searchedReqName = await buyersDeskImpl.fetchSearchedRequisitionName();
  I.assertEqual(searchedReqName.toString(), requisition.reqName);

});

When ("I filter with Purchase Amount {string} and {string}" , async function(maxValue,minValue){
   buyersDeskImpl.clickPurchaseAmountFilter();
   buyersDeskImpl.fillPurchaseAmount(maxValue,minValue);

});



When ("I filter with {string} status", async function(status){
  logger.info("Status to be searched"+status);
  buyersDeskImpl.clickonStatusFilterButton();
  buyersDeskImpl.filterStatus(requisition.status);

});


Then ("I should be see the data on the page with the filtered amount", async function(){
   let fetchPurchaseAmount = await buyersDeskImpl.fetchPurchaseAmount();
   logger.info('Searched Puchase amount '+fetchPurchaseAmount);
   let flag = true;
   if (fetchPurchaseAmount>minValue && fetchPurchaseAmount<maxValue)
   {
    logger.info("Purchase Amount is "+fetchPurchaseAmount+" and is in the given range");
    flag = true;
   }
    else
    {
      logger.info("Purchase Amount out of range");
      flag = false;
    }

    I.assertEqual(flag,true);

}); 
  Then("I should be see the data on the page with the filtered status", async function(){
    let fetchedStatus = await buyersDeskImpl.fetchStatus();
    logger.info('Searched Status '+fStatus);
    I.assertEqual(fetchedStatus.toString(),requisition.status.toString());  

});

Then("I should be see the data on the page with the filtered buyer", async function() {
  let searchedBuyer = await buyersDeskImpl.fetchSearchedBuyer();
  logger.info('Searched Buyer is '+searchedBuyer);
  logger.info('Requisition Buyer is '+requisition.buyer);
  I.assertEqual(searchedBuyer.toString(), requisition.buyer.toString());
   
});

Then("I should be able to create a PO with multiple requisition merged into one",async function(){
  let spo = buyersDeskImpl.verifyPage();
  logger.info('PO created is '+spo);
  
});

Then("I should be see the data on the page on the basis on Requestor field",async function(){
  let searchedRequestor = await buyersDeskImpl.fetchSearchedRequestor();
  let actualRequestor = (global.users.get("USERNAME"));
  actualRequestor = actualRequestor.substring(0,actualRequestor.indexOf("@"));
  logger.info('Searched Requestor is '+searchedRequestor);
  logger.info('Actual Requestor is '+actualRequestor);
  I.assertEqual(searchedRequestor.toString(), actualRequestor.toString());
})

When("I approve requisition", async function(){
  await approvalImpl.navigateToApprovalListing();
  await approvalImpl.approveDoc(requisition.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
  await buyersDeskImpl.navigateToBuyerListing();

});

When("I edit the requisition", async function(){
  logger.info("Requistion to be edited is "+ requisition.reqNumber);
  await buyersDeskImpl.SearchRequisitionNumber(requisition.reqName, lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION"));
  await buyersDeskImpl.EditRequisition(requisition.reqNumber);


});

Then ("I should be able to view the requisition in edit mode" , async function(){
   let flagedit = await buyersDeskImpl.validateReqinEditMode();
   I.assertEqual(flagedit,true);
});

When("I return the requisition on Buyers Desk", async function(){

  logger.info("Requistion to be edited is "+ requisition.reqNumber);
  await buyersDeskImpl.SearchRequisitionNumber(requisition.reqName, lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION"));
  await buyersDeskImpl.EditRequisition(requisition.reqNumber);
  await buyersDeskImpl.clickOnReturnButton();
  await buyersDeskImpl.fillReturnReqComments("Return Requistion Comments Added");
  await buyersDeskImpl.fillRequiredBy(requisition.requiredBy);
  await buyersDeskImpl.clickOnReturnButton();
});

When ("I allow requestor to resubmit the requisition", async function(){
   logger.info("Allowing the requestor to resubmit the requition"); 

})
