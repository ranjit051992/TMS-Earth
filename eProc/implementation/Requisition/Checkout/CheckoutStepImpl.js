const { I } = inject();
const logger= require("./../../../../Framework/FrameworkUtilities//Logger/logger");
const objectCreation = require("../../../dataCreation/ObjectCreation");
const checkoutImp = require("../Checkout/CheckoutImpl");
const iCheckoutObject = require("../Checkout/CheckoutObject");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const faker = require("faker");
const onlineStoreImpl = require("../OnlineStore/OnlineStoreImpl");


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

Given("I add Purchase Type", async function(){
    commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
    await checkoutImp.selectPurchaseType(this.reqBO.purchaseType);
    let noOfEle = await I.grabNumberOfVisibleElements(I.getElement(iCheckoutObject.PURCHASE_TYPE_CONFIRM_POPUP))
    if(noOfEle>0)
    {
        checkoutImp.clickOnPurchaseTypeYesButton();
    }
});

When("I add a On Behalf of user", async function(){
    checkoutImp.fillOnBehalfOf(this.reqBO.onBehalfOf);
});

When("I add Required By Date", async function(){

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

Given("I add an attachment {string}", async function(filePath){

    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
    filePath = I.getData(filePath);
    logger.info("File path is : "+filePath);
    await checkoutImp.addAttachments(filePath);
    this.attachment = filePath;
});

Then("I should be able to see the attachment which is added", async function(){

    let isPresent  = await checkoutImp.checkAddedAttachment(this.attachment);
     I.assertEqual(isPresent,true);
 });

Given("I link Purchase Order {string} in the Select Purchase Order field", async function(po){
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
    await checkoutImp.selectPurchaseOrder(po);
    await checkoutImp.clickOnSelectedPOContinueButton();
    this.purchaseOrder = po;
});


Then("I should be see that the field name is updated to Select Purchase Order", async function(){

   let selectedPO = await checkoutImp.getSelectedPurchaseOrder();
   let isSelected = false;
    if(selectedPO===this.purchaseOrder.toString())
    {
        isSelected = true;
    }

    I.assertEqual(isSelected,true);
});


Given("I select {string} at line level in Buyer section", async function(buyerGroup) {

    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
    await checkoutImp.selectBuyerGroupOption();
    let group = I.getData(buyerGroup);
    await checkoutImp.fillBuyerInTextBox(group);
    this.buyerGroup = group;
});

Given("I select buyer {string} at line level in Buyer section", async function(buyer){

    await checkoutImp.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
    let value = I.getData(buyer);
    await checkoutImp.fillBuyerInTextBox(value);
    this.buyerName = value.substring(0,value.indexOf('@'));
});

When("I add data in Cost Booking Details section at line level", async function(){
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    await checkoutImp.clickOnCostBookingLink(this.reqBO.itemName);
    await checkoutImp.fillGLAccount(this.reqBO.glAccount);
});

When("I save it", async function(){
    await checkoutImp.clickOnCostBookingSaveButton();
    await commonComponent.waitForLoadingSymbolNotDisplayed();
});

When("I submit requisition", async function(){
    await checkoutImp.submitRequisition();
    await commonComponent.waitForLoadingSymbolNotDisplayed();
});

Then("I should be able to view requisition with buyer as the buyer group which was assigned", async function(){

    //search & view req

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


 Then("I should be able to view requisition with buyer which was assigned", async function(){

    //search & view req
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


Then("I should be able to see new Deliver address as the Ship to Another Address on view requisition", async function(){

    //search & view req
    await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));
    let actualAddress = this.customAddress.toString();
    let address = await checkoutImp.getShipToAnotherAddress();
    let isEqual = false;
    if(address.toString()===actualAddress.toString())
    {
        isEqual = true;
    }

     
    this.isAddressSaved = isEqual;
    
    //I.assertEqual(isEqual,true);
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
