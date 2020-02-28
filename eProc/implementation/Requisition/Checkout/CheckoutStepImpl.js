const { I } = inject();
const logger= require("./../../../../Framework/FrameworkUtilities//Logger/logger");
const objectCreation = require("../../../dataCreation/ObjectCreation");
const checkoutImp = require("../Checkout/CheckoutImpl");
const iCheckoutObject = require("../Checkout/CheckoutObject");
const iConstants = require("../../../constants/iConstants");
const commonComponent = require("../../../commonKeywords/CommonComponent");


When("I create requisition with {string} {string} item", async function(noOfItems, itemType) {
    let reqBo= await objectCreation.getObjectOfRequisition(noOfItems, itemType);
    this.reqBO = await checkoutImp.createRequisitionFlow(reqBo);
});

When("I edit Cost Allocation section at header level", async function(){
    commonComponent.scrollToSection(iConstants.CHECKOUT_COST_ALLOCATION_SECTION);
});

When("I update cost center {string}", async function(costCenter){
    this.costCenter = checkoutImp.fillCostCenter(global.testData.get(costCenter));

});

Given("I navigate to Line level Cost Booking Details", async function(){
    commonComponent.scrollToSection(iConstants.CHECKOUT_ITEM_DETAILS_SECTION);
    checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);
});

Then("I should be see the updated cost center on line level Cost Booking section", async function(){
    let verifyCostCenter = fasle;
    let fetchedCostCenter = await I.grabTextFrom(global.uiElements.get(iCheckoutObject.FETCHED_COST_CENTER));
    logger.info("Updated Cost Center is "+fetchedCostCenter);
    if(fetchedCostCenter === this.costCenter)
    {
        verifyCostCenter = true;
    }
    I.assertEqual(true, verifyCostCenter);
});

When("I update project {string}", async function(project){
    checkoutImp.clickOnAssignCostProjectYesButton();
    let value = await checkoutImp.fillProject(global.testData.get(project));
    this.project = value.trim();
    logger.info("this.project "+this.project)

});

Then("I should be see the updated project on line level Cost Booking section", async function(){
    let verifyProject = false;
    let fetchedProject = await I.grabTextFrom(global.uiElements.get(iCheckoutObject.FETCHED_PROJECT));
    logger.info("Updated Project is "+fetchedProject);
    logger.info("this.project "+this.project)
    if(fetchedProject.toString.trim() === this.project)
    {
        verifyProject = true;
    }
    I.assertEqual(verifyProject,true);
});

Given("I add Purchase Type", async function(){
    commonComponent.scrollToSection(iConstants.CHECKOUT_ADDITIONAL_DETAILS_SECTION);
    checkoutImp.selectPurchaseType(this.reqBO.purchaseType);
    if(I.seeElement(iCheckoutObject.PURCHASE_TYPE_CONFIRM_POPUP))
    {
        checkoutImp.clickOnPurchaseTypeYesButton();
    }
});

When("I add a On Behalf of user", async function(){
    checkoutImp.fillOnBehalfOf(this.reqBO.onBehalfOf);
});

When("I add Required By Date", async function(){

});



