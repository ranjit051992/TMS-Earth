const {I} = inject();
const prop = global.confi_prop;
const reqListingImpl = require("../RequisitionListing/RequisitionListingImpl");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const viewReqImpl = require("./ViewRequisitionImpl");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iViewReq = require("./ViewRequisitionObject");
const checkoutImp = require("../Checkout/CheckoutImpl");


Then("I should be able to see submitted requisition with updated details", async function(){
    let isReqUpdated = false;
    let verifyQuantity = false;
    let verifyTaxes = false;

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    this.fetchQuantity = await viewReqImpl.fetchQuantity(this.reqBO.itemName);
    
    if(this.fetchQuantity.toString().trim().includes(this.updateQuantity.toString().trim()))
    {
        verifyQuantity = true;
        logger.info("Verified updated Quantity-->"+verifyQuantity);
    }
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
   
    let taxValueArray = new Array();
    taxValueArray = await viewReqImpl.fetchTaxesDetails(this.reqBO.items[0].itemName);
    logger.info("Tax Deatils Array--->>"+taxValueArray);
    
    if(taxValueArray.toString().includes(this.reqBO.taxType.toString()) && taxValueArray.includes(this.reqBO.taxName.toString()))
    {
        verifyTaxes = true;
        logger.info("Verified updated Taxes-->"+verifyTaxes);
    }
    isReqUpdated = (verifyQuantity && verifyTaxes);
    I.assertEqual(isReqUpdated, true);
});

Then("I should be able see the taxes added on view requisition", async function(){
    let verifyTaxes = false;
    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
   
    let taxValueArray = new Array();
    taxValueArray = await viewReqImpl.fetchTaxesDetails(this.reqBO.items[0].itemName);
    logger.info("Tax Deatils Array--->>"+taxValueArray);
    
    if(taxValueArray.toString().includes(this.reqBO.taxType.toString()) && taxValueArray.includes(this.reqBO.taxName.toString()))
    {
        verifyTaxes = true;
        logger.info("Verified updated Taxes-->"+verifyTaxes);
    }
    I.assertEqual(verifyTaxes, true);
});


Then("I should be able to see Deliver address as the Ship to Another Address on view requisition", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));
    let actualAddress = this.anotherAddress.toString();
    let address = await viewReqImpl.getShipToAnotherAddress();
    let isEqual = await commonComponent.isElementVisible(I.getElement(iViewReq.REQ_SHIP_TO_ANOTHER_ADDRESS_LABEL));
    if(address.toString()===actualAddress.toString() && isEqual) 
    {
        isEqual = true;
    }
    else
    {
        isEqual = false;
    }
    
    I.assertEqual(isEqual,true);
 });


 Then("I should be able to view requisition with stock item", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    let isPresent = await viewReqImpl.checkLineItems(this.addedCartItems);
    I.assertEqual(isPresent,true);

});


Then("I should be able to view the requisition with adhoc approver added in the workflow", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    let workflowNodes = await checkoutImp.fetchWorkflowNodes();
    let isPresent = false;
    for(let node of workflowNodes)
    {
        if(node.includes(lmtVar.getLabel("ADHOC_APPROVER")))
        {
            // if(node.includes(this.adhocApprover.toString()))
            // {
                isPresent = true;
            //}
        }
    }

    logger.info("Adhoc approver present : "+isPresent);

    I.assertEqual(isPresent,true);
});



Then("I should be able to see new Deliver address as the Ship to Another Address on view requisition", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));
    let actualAddress = this.customAddress.toString();
    let address = await viewReqImpl.getShipToAnotherAddress();
    let isEqual = false;
    if(address.toString()===actualAddress.toString()) 
    {
        isEqual = true;
    }
    
    this.isAddressSaved = isEqual;
    
    //I.assertEqual(isEqual,true);
 });


 Then("I should be able to view requisition with buyer which was assigned", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    await checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);     
    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
    let buyer = await checkoutImp.getBuyer();

    let isEqual = false;
    if(buyer===this.buyerName)
    {
        isEqual = true;
    }
     I.assertEqual(isEqual,true);
 });


 Then("I should be able to view requisition with buyer as the buyer group which was assigned", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    await checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);     
    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
    let group = await checkoutImp.getBuyer();

    let isEqual = false;
    if(group===this.buyerGroup)
    {
        isEqual = true;
    }
     I.assertEqual(isEqual,true);
 });


 Then("I should be able to see the attachment which is added", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
    let isPresent  = await checkoutImp.checkAddedAttachment(this.attachment);
    I.saveScreenshot("Upload Attachment.png");
     I.assertEqual(isPresent,true);
 });

 Then("I should be able to view requisition created with free text item", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    let isPresent = await viewReqImpl.checkLineItems(this.guidedItem.itemName);
    I.assertEqual(isPresent,true);
 });

 Then("I should be able to view the requisition with multiple items", async function(){
     await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
     await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
     let isPresent = await viewReqImpl.checkLineItems(this.addedCartItems);
     I.assertEqual(isPresent,true);

 });

 Then("I should see split cost center added to each item at header level", async function(){
     let isHeaderLevelCostCenter = false;
     await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_COST_ALLOCATION_SECTION"));
     let fetchCostCenter = await viewReqImpl.fetchCostCenter();
     if(fetchCostCenter.toString() === this.costCenter.toString())
     {
        isHeaderLevelCostCenter = true;
        logger.info("Verified Cost Center at Header Level");
     }
     I.assertEqual(isHeaderLevelCostCenter,true);
 });

 Then("I should be able to see split cost center added to each item at line level", async function(){
     let isSplitLineLevelCostCenter = false;
    // isSplitLineLevelCostCenter = await viewReqImpl.verifySplitCostCenterAddedForItems(this.addedCartItems);

    for(let item of this.addedCartItems)
    {
        await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
        await I.click("//span[contains(text(),'"+item+"')]//following::a[2]");
        let costCenter = await viewReqImpl.fetchCostCenter();
        logger.info("fetchCostCenter "+costCenter)
        logger.info("this.costCenter "+this.costCenter)

        if(costCenter.toString() === this.costCenter.toString())
        {
            isSplitLineLevelCostCenter = true;
            logger.info("Verified Cost Center for item at line Level");
        }
        await viewReqImpl.clickOnBackArrow();

    }

     I.assertEqual(isSplitLineLevelCostCenter, true);
 });

 Then("I should be able to view the workflow Approval hierarchy", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));

    let isPresent = await viewReqImpl.verifyWorkflowApprovalHierarchy();
   
    I.assertEqual(isPresent,true);
});


Then("I should be able to view the workflow with On Behalf user as the requestor and On behalf user workflow should be applied", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));

    let isPresent = await viewReqImpl.verifyWorkflowRequester(this.reqBO.onBehalfOf);
   
    I.assertEqual(isPresent,true);
});


Then("I should be able to view the requisition with the delivery split", async function(){
    let isDeliverySplit = false;

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    await viewReqImpl.clickOnShippingDetailsAndAssetTagging(this.reqBO.items[0].itemName);
    let deliverySplit = await viewReqImpl.getNoOfDeliverySplit();

    if(this.noOfSplit === deliverySplit)
    {
        isDeliverySplit = true;
        logger.info("Requisition is created with delivery split")
    }
    I.assertEqual(isDeliverySplit, true);
});

Then("I should see that the address is updated for split {int}", async function(splitNo){
    let isAdrressUpdated = false;

    let address = await viewReqImpl.getLineLevelDeliveryAddress(splitNo);

    if(address.toString() === this.changedAddress.toString())
    {
        isAdrressUpdated = true;
        logger.info("Delivery Address is updated");
    }
    I.assertEqual(isAdrressUpdated, true);
});

Then("I get requisition number", async function(){

    await reqListingImpl.navigateToRequisitionListing();
    let reqNumber = await reqListingImpl.getRequisitionNumber(this.reqBO.reqName);
    this.reqBO.reqNumber = reqNumber;
});

Then("I should be able to view requisition with non stock item", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    let isPresent = await viewReqImpl.checkLineItems(this.reqBO.items[0].itemName);
    I.assertEqual(isPresent,true);
 });

 Then("I view Requisition", async function(){

    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
   
 });


 Then("I should be able to view the requisition with free text item and the catalog items", async function(){

    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    let items = new Array();
    for(let i =0;i<this.reqBO.items.length;i++)
    {
        items.push(this.reqBO.items[i].itemName);
    }
    let isPresent = await viewReqImpl.checkLineItems(items);
    I.assertEqual(isPresent,true);
 });

Then("I should be able see the taxes added for multiple items on view requisition", async function(){
    let verifyTaxes = false;
    let taxValueArray = new Array();
    await reqListingImpl.searchAndViewReqByName(this.reqBO.reqName);
    for(let i=0; i<this.reqBO.items.length; i++)
    {
        await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
        taxValueArray = await viewReqImpl.fetchTaxesDetails(this.reqBO.items[i].itemName);
        if(taxValueArray.toString().includes(this.reqBO.taxType.toString()) && taxValueArray.includes(this.reqBO.taxName.toString()))
        {
            verifyTaxes = true;
            logger.info("Verified updated Taxes-->"+verifyTaxes);
        }
        await viewReqImpl.clickOnBackArrow();
    }
    I.assertEqual(verifyTaxes, true);
});