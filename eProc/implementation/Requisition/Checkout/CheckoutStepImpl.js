const { I } = inject();
const logger= require("./../../../../Framework/FrameworkUtilities//Logger/logger");
const objectCreation = require("../../../dataCreation/ObjectCreation");
const checkoutImp = require("../Checkout/CheckoutImpl");
const iCheckoutObject = require("../Checkout/CheckoutObject");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const reqListing = require("../../Requisition/RequisitionListing/RequisitionListingImpl");
const prop = global.confi_prop;

When("I create requisition with {string} {string} item", async function(noOfItems, itemType) {
    let reqBo= await objectCreation.getObjectOfRequisition(noOfItems, itemType);
    this.reqBO = await checkoutImp.createRequisitionFlow(reqBo);
});

When("I edit Cost Allocation section at header level", async function(){
    commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_COST_ALLOCATION_SECTION"));
});

When("I update cost center {string}", async function(costCenter){
    this.costCenter = await checkoutImp.fillCostCenter(global.testData.get(costCenter));

});

Given("I navigate to Line level Cost Booking Details", async function(){
    commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);
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
    checkoutImp.clickOnAssignCostProjectYesButton();
    this.project= await checkoutImp.fillProject(global.testData.get(project));
    logger.info("this.project "+this.project)

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
    commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));
    this.defaultAddress = await checkoutImp.getDefaultShippingAddress();
    if(this.defaultAddress.toString()!== null)
    {
        verifyHeaderAddress = true;
    }
    I.assertEqual(verifyHeaderAddress,true);
});

Then("I navigate to Line level Shipping Details and Asset Tagging section", async function(){
    commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    checkoutImp.clickOnShippingDetailsAndAssetTagging();
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
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    await checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);
    await checkoutImp.fillGLAccount(this.reqBO.glAccount);
});

When("I save it", async function(){
    await checkoutImp.clickOnCostBookingSaveButton();
    await commonComponent.waitForLoadingSymbolNotDisplayed();
    await I.wait(prop.DEFAULT_MEDIUM_WAIT);
});

When("I save requisition in Draft state", async function(){
   await checkoutImp.clickOnSaveAsDraftButton();
   await commonComponent.waitForLoadingSymbolNotDisplayed();
   await I.wait(prop.DEFAULT_MEDIUM_WAIT);
   await reqListing.isRequisitionListingPageDisplayed() ;
});

When("I add Settlement Via", async function(){
    await checkoutImp.selectSettlementVia(this.reqBO.settlementVia);
});

When("I enter Requisition Name", async function(){
    this.reqName = await checkoutImp.enterRequisitionName(this.reqBO.reqName);

});

When("I submit requisition", async function(){
    await checkoutImp.submitRequisition();
    await commonComponent.waitForLoadingSymbolNotDisplayed();
});
