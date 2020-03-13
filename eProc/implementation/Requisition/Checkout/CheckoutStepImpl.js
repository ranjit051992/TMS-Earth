const { I } = inject();
const logger= require("./../../../../Framework/FrameworkUtilities//Logger/logger");
const objectCreation = require("../../../dataCreation/ObjectCreation");
const checkoutImp = require("../Checkout/CheckoutImpl");
const iCheckoutObject = require("../Checkout/CheckoutObject");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const reqListing = require("../../Requisition/RequisitionListing/RequisitionListingImpl");
const prop = global.confi_prop;
const viewReqImpl = require("../ViewRequisition/ViewRequisitionImpl");
const faker = require("faker");
const iApprovalObject = require("../../Approval/ApprovalObject");
const coaImp = require("../../Coa/CoaImpl");
const iViewReq = require("../../Requisition/ViewRequisition/ViewRequisitionObject");

When("I create requisition with {int} {string} item", async function(noOfItems, itemType) {
    this.reqBO= await objectCreation.getObjectOfRequisition(noOfItems, itemType);
    this.reqBO = await checkoutImp.createRequisitionFlow(this.reqBO);
});

When("I edit Cost Allocation section at header level", async function(){
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_COST_ALLOCATION_SECTION"));
});

When("I update cost center {string}", async function(costCenter){
    await checkoutImp.clickOnSingleMultipleCostCenterRadioButton();
    this.costCenter = await checkoutImp.fillCostCenter(I.getData(costCenter));

});

Given("I navigate to Line level Cost Booking Details", async function(){
   await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
   await checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);
});

Then("I should be see the updated cost center on line level Cost Booking section", async function(){
    let verifyCostCenter = false;
    let fetchedCostCenter = await I.grabTextFrom(global.uiElements.get(iCheckoutObject.FETCHED_COST_CENTER));
    logger.info("Updated Cost Center is "+fetchedCostCenter);
    if(fetchedCostCenter.toString() === this.costCenter.toString())
    {
        verifyCostCenter = true;
    }
    I.assertEqual(true, verifyCostCenter);
});

When("I update project {string}", async function(project){
    await checkoutImp.clickOnAssignCostProjectYesButton();
    this.project= await checkoutImp.fillProject(global.testData.get(project));
    logger.info("I update project ---> "+this.project);
});

Then("I should be see the updated project on line level Cost Booking section", async function(){
    let verifyProject = false;
    let fetchedProject = await I.grabTextFrom(global.uiElements.get(iCheckoutObject.FETCHED_PROJECT));
    logger.info("Updated Project is "+fetchedProject);
    logger.info("this.project "+this.project)
    if(fetchedProject.toString() === this.project.toString())
    {
        verifyProject = true;
    }
    I.assertEqual(verifyProject,true);
});

When("I add Purchase Type", async function(){
    commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
    await checkoutImp.selectPurchaseType(this.reqBO.purchaseType);
    
});

When("I add a On Behalf of user", async function(){
    await checkoutImp.fillOnBehalfOf(this.reqBO.onBehalfOf);
});

When("I add Required By Date", async function(){
    await checkoutImp.selectRequiredByDate();
});

Then("I should see on header level Cost Booking section cost center should be populated", async function(){
    let verifyCostCenter = false;
    commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_COST_ALLOCATION_SECTION"));
     this.fetchedCostCenter = await I.grabAttributeFrom(I.getElement(iCheckoutObject.COST_CENTER), "value");
     logger.info("Header Level Cost Center---> "+this.fetchedCostCenter);
    if(this.fetchedCostCenter.toString() !== null)
    {
        verifyCostCenter = true;
    }
    I.assertEqual(verifyCostCenter,true);

});

Then("I should see on line level Cost Booking Details section cost center should be populated", async function(){
    let verifyLineLevelCC = false;
    let lineCostCenter = await I.grabTextFrom(I.getElement(iCheckoutObject.FETCHED_COST_CENTER));
    logger.info("Line Level Level Cost Center---> "+lineCostCenter);
    if(lineCostCenter.toString() === this.fetchedCostCenter.toString())
    {
        verifyLineLevelCC = true;
    }
    I.assertEqual(verifyLineLevelCC,true);

});

Then("I should see on header level, Shipping Details section Default Shipping Address field should be auto populated", async function(){
    let verifyHeaderAddress = false;
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));
    this.defaultAddress = await checkoutImp.getDefaultShippingAddress();
    if(this.defaultAddress.toString()!== null)
    {
        verifyHeaderAddress = true;
    }
    I.assertEqual(verifyHeaderAddress,true);
});

Then("I navigate to Line level Shipping Details and Asset Tagging section", async function(){
    commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    checkoutImp.clickOnShippingDetailsAndAssetTagging(this.addedCartItems);
});

Then("I should see on line level, in Shipping Details and Asset Tagging section Address field should be auto populated", async function(){
    let verifyLineAddress = false;
    let lineLevelAddress = await checkoutImp.fetchedLineLevelAddress();
    if(this.defaultAddress.includes(lineLevelAddress.toString()))
    {
        verifyLineAddress = true;
    }
    I.assertEqual(verifyLineAddress,true);
});

When("I add data in Cost Booking Details section at line level", async function(){
    for(let i=0; i< this.reqBO.items.length; i++)
    {
        await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));  
        await checkoutImp.clickOnCostBookingLink(this.reqBO.items[i].itemName);
        await coaImp.fillCoaDetails();
    }
    
});

/**
 * Click on COA Save button
 */
When("I save it", async function(){
    await checkoutImp.clickOnCostBookingSaveButton();
    await commonComponent.waitForLoadingSymbolNotDisplayed();
    await I.wait(prop.DEFAULT_MEDIUM_WAIT);
});

When("I save requisition in Draft state", async function(){
   await checkoutImp.saveRequisitionAsDraft();
   await reqListing.isRequisitionListingPageDisplayed() ;
});

When("I add Settlement Via", async function(){
    await checkoutImp.selectSettlementVia(this.reqBO.settlementVia);
});

When("I enter Requisition Name", async function(){
    this.reqBO.reqName = await checkoutImp.enterRequisitionName(this.reqBO.reqName);

});

When("I submit requisition", async function(){
    await I.wait(prop.DEFAULT_MEDIUM_WAIT);
    await checkoutImp.submitRequisition();
    await commonComponent.waitForLoadingSymbolNotDisplayed();
});

Given("I add an attachment {string}", async function(filePath){

    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
    filePath = I.getData(filePath);
    logger.info("File path is : "+filePath);
    await checkoutImp.addAttachments(filePath);
    this.attachment = filePath;
});


Given("I link Purchase Order {string} in the Select Purchase Order field", async function(po){
    //let poNumber = this.spo.poNumber;
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
    await checkoutImp.selectPurchaseOrder(po);
    await checkoutImp.clickOnSelectedPOContinueButton();
    this.purchaseOrder = await checkoutImp.getSelectedPurchaseOrder();;
});


Then("I should be see that the field name is updated to Select Purchase Order", async function(){

   let selectedPO = await checkoutImp.getSelectedPurchaseOrder();
   let isSelected = false;
    if(selectedPO.toString()===this.purchaseOrder.toString())
    {
        isSelected = true;
    }

    I.assertEqual(isSelected,true);
});


Given("I select {string} at line level in Buyer section", async function(buyerGroup) {

    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    await checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);
    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
    await checkoutImp.selectBuyerGroupOption();
    let group = I.getData(buyerGroup);
    await checkoutImp.fillBuyerInTextBox(group);
    await checkoutImp.getBuyer();
    this.buyerGroup = group;
});

Given("I select buyer {string} at line level in Buyer section", async function(buyer){

    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    await checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);
    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
    let value = I.getData(buyer);
    await checkoutImp.fillBuyerInTextBox(value);
    this.buyerName = await checkoutImp.getBuyer();
});


When("I select Ship to Another Address in  Shipping Details section at header level", async function(){
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));
    await checkoutImp.clickOnShipToAnotherAddressButton();
});

When("I Create New address", async function(){
    this.reqBO.customAddressName = "Automation_Address"+faker.random.alphaNumeric(10);
    this.reqBO.customAddressStreet1 = "Automation_Street1"+faker.random.alphaNumeric(10);
    this.reqBO.customAddressStreet2 = "Automation_Street2"+faker.random.alphaNumeric(10);
    this.reqBO.customAddressCountry = I.getData("COUNTRY");
    this.reqBO.customAddressCity   = "Automation_City"+faker.random.alphaNumeric(10);
    await checkoutImp.createNewShippingAddress(this.reqBO);
});

When("I check the Save checkbox", async function(){
    await checkoutImp.clickOnSaveCheckbox();
});

When("I create the address", async function(){
    this.customAddress = await (await checkoutImp.clickOnCreateAddress()).toString();
});




 Then("I should be able to see the saved address on creating a new requisition", async function(){
    let addressName = this.customAddress.toString();
    addressName = addressName.substring(0,addressName.indexOf(','));
    await checkoutImp.fillShipToAnotherAddress(addressName);
    await checkoutImp.selectExistingShipToAnotherAddress();
    let address = await checkoutImp.getCustomShippingAddress();
    let isEqual = false;
    if(address===this.customAddress)
    {
        isEqual = true;
    }

    I.assertEqual((isEqual && this.isAddressSaved),true);

 });

When("I modify the field quantity", async function(){
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    let quantity = faker.random.number(20);
    this.updateQuantity =  await checkoutImp.enterItemLevelQuantity(this.reqBO.itemName, quantity);
    logger.info("Modified quantity is---> "+this.updateQuantity);
});

// When("I add Taxes", async function(){
//     this.reqBO = await checkoutImp.fillTaxDetailsAtLineLevel(this.reqBO);
//     await checkoutImp.clickOnCostBookingSaveButton();
//     await commonComponent.waitForLoadingSymbolNotDisplayed();
// });

When("I add Tax Details at line level", async function(){
    this.reqBO = await checkoutImp.fillTaxDetailsAtLineLevel(this.reqBO);
});

Given( "I Create {int} requisitions with {int} {string} item", async function (noOfReqs, noOfItems, itemType) {
    this.reqArray = await checkoutImp.createMultipleReqs(noOfReqs, noOfItems, itemType);
    logger.info("Required number of POs created"+ this.reqArray.length);
    logger.info("req number 0"+ this.reqArray[0].reqNumber);
    logger.info("req number 1"+ this.reqArray[1].reqNumber);
    logger.info("req number 2"+ this.reqArray[2].reqNumber);
 });

Given( "I have {int} Requisitions In Approval status", async function() {
    I.amOnPage(prop.DDS_Requisition_Listing);
    I.waitForVisible(I.getElement(iApprovalObject.SEARCH_FIELD));
    I.waitForClickable(I.getElement(iApprovalObject.SEARCH_FIELD));
    logger.info("req length ***"+ this.reqArray.length);
    logger.info("req number 0 ***"+ this.reqArray[0].reqNumber);
    logger.info("req number 1 ***"+ this.reqArray[1].reqNumber);
    logger.info("req number 2 *** "+ this.reqArray[2].reqNumber);
    await checkoutImp.checkMultipleReqStatus(this.reqArray);
 });

When( "I fetch Requisition Name", async function() {
    this.reqBO.reqName = await I.grabAttributeFrom(I.getElement(iCheckoutObject.REQUISITION_NAME), "value");
    logger.info("Fetched Requisition Name is "+this.reqBO.reqName);
});

 When("I check Mark for adding approvers checkbox in workflow section", async function(){
    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_WORKFLOW_SECTION"));
    await checkoutImp.selectMarkApproverCheckbox();

});

When("I click on Next button", async function(){
    await checkoutImp.createRFAReq();
});

When("I should be add adhoc approver {string} after {string} on Ready for Approval page", async function(approver,approvalAfter){
    approver = I.getData(approver);
    approvalAfter = lmtVar.getLabel(approvalAfter);
    await checkoutImp.addAdhocApprover(approver,approvalAfter);
    this.adhocApprover = approver;
});


When("I select any existing address as shipping address", async function()
{
    await I.click(I.getElement(iCheckoutObject.SHIP_TO_ANOTHER_ADDRESS_TEXTBOX));
    await checkoutImp.selectExistingShipToAnotherAddress();
    this.anotherAddress = await checkoutImp.getCustomShippingAddress();

});


When("I add Costing split at header level by Percentage into {int} splits", async function(noOfSplit){
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_COST_ALLOCATION_SECTION"));
    let costCenterArray = new Array();
    let index = 1;
    for(let i=1; i<=noOfSplit; i++)
    {
        let costcenter = await checkoutImp.fillMultipleCostCenter(I.getData("COST_CENTER["+i+"]"), index);
        costCenterArray.push(costcenter);
        let percentage = 100/noOfSplit;
       // await checkoutImp.enterPercentage(percentage);
        await checkoutImp.fillMultiplePercentage(percentage, index);
        if(index<noOfSplit)
        {
            await checkoutImp.clickOnCoaAddMoreButton();
        }
        index++;
    }
    this.costCenter = costCenterArray;
 });

Given("I have created a requisition and converted it to PO with {int} {string}", async function(noOfItems, itemType) {
    this.reqBO = await objectCreation.getObjectOfRequisition(noOfItems, itemType);
    this.reqBO = await checkoutImp.createReqToPoFlow(this.reqBO);
});


When("I add deliver to user", async function(){
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));
    await checkoutImp.fillDeliverTo(this.reqBO.deliverTo);
});

When("I add Delivery split at line level into {int} splits", async function(noOfSplit){
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    await checkoutImp.clickOnShippingDetailsAndAssetTagging(this.addedItem);
    await checkoutImp.clickOnShipItemsToMultiplePersonLocationRadioButton();
    let index = 1;
    for(let i=1; i<= noOfSplit; i++)
    {
        let quantity = this.addedQuantity/noOfSplit;
        await checkoutImp.enterSplitQuantityAmount(quantity, index);

        if(index<noOfSplit)
        {
            await checkoutImp.clickOnAddAnotherAddressButton();
        }
        index++;
    }
    this.noOfSplit = noOfSplit;
});

When("I change the address for split {int}", async function(forSplit){
    //SHIP_TO_ADDRESS_NAME
});

