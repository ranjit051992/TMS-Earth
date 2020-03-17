
const { I } = inject();
const iGuided = require("../GuidedProcurement/GuidedProcurementObject");
const guidedImpl = require("../GuidedProcurement/GuidedProcurementImpl");
const objectCreation = require("../../../dataCreation/ObjectCreation");
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");
const onlinestoreImpl = require("../OnlineStore/OnlineStoreImpl");
const cartImpl = require("../Cart/CartImpl");
const iCart = require("../Cart/CartObject");
const checkoutObj = require("../Checkout/CheckoutObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const checkoutImp = require("../Checkout/CheckoutImpl");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;


Given("I Add guided item service",async function(){

    this.reqBO = await objectCreation.getObjectOfRequisition(1,"SEARCH_GUIDED_ITEM");
    //await guidedImpl.CreateGuidedItem(this.guidedItem);
    this.guidedItem = this.reqBO.items[0];
    await guidedImpl.fillItemServiceName(this.guidedItem.itemName);
    await guidedImpl.clickOnAddItemServiceButton();
    await I.waitForVisible(I.getElement(iGuided.ITEM_SERVICE_NAME_TEXTBOX));
});

Given("I add qty and price",async function(){

    await guidedImpl.fillQuantity(this.guidedItem.quantity.toString());
    await guidedImpl.fillPrice(this.guidedItem.price.toString());
});

Given("I add Sourcing status",async function(){

    let sourcingStatus = await this.guidedItem.sourcingStatus;
    await guidedImpl.selectSourcingStatus(sourcingStatus.toString());

});

Given("I save guided item details",async function(){
    await guidedImpl.clickOnDoneButton();
    await guidedImpl.clickOnEformDoneButton();
    await commonKeywordImpl.waitForElementVisible(I.getElement(iGuided.SUPPLIER_TEXTBOX));
});

Given("I add items to cart",async function(){

    await guidedImpl.addItemToCart();
});

Given("I select supplier from the Suggested Supplier dropdown",async function(){
    this.guidedItem = await guidedImpl.selectSupplier(this.guidedItem);
});


Given("I should see supplier gets added into Requester suggested supplier",async function(){

    //let selectedSupplier = await guidedImpl.getSelectedSupplier();
    await onlinestoreImpl.clickOnCartIcon();
    await I.waitForVisible(I.getElement(iCart.CART_ITEM_TABLE));
    await cartImpl.clickOnCheckoutButton();
    await I.waitForVisible(I.getElement(checkoutObj.REQUISITION_NAME));
    await commonKeywordImpl.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
    let selectedSupplierOnCheckout = await guidedImpl.getSelectedSupplier();
    await checkoutImp.clickOnSupplierEditIcon();

    let actualAddress = await guidedImpl.getSupplierAddress();
    let actualContact = await guidedImpl.getSupplierContactName();
    let actualEmail = await guidedImpl.getSupplierEmail();

    let isSelected = false;
    if(actualAddress===this.guidedItem.supplierAddress.toString() && actualContact === this.guidedItem.supplierContact && actualEmail === this.guidedItem.supplierEmail)
    {
        isSelected = true;

    }

    I.assertEqual(isSelected,true);
});


When("I add {int} free text item {string} to cart", async function(noOfItem, itemType){
    this.reqBO = await objectCreation.getObjectOfRequisition(noOfItem, itemType);
    this.guidedItemBO = this.reqBO.items[0];
    logger.info("Guided item "+this.guidedItemBO);
    await cartImpl.clearCart();
    await I.wait(prop.DEFAULT_WAIT);
    this.guidedItemBO =  await guidedImpl.CreateGuidedItem(this.guidedItemBO);

});


Given("I select category",async function(){
    await guidedImpl.fillCategory(this.guidedItem.category);
    await guidedImpl.selectCategoryEform(this.guidedItem.eform);
});

When("I add short description", async function(){
    await guidedImpl.clickOnDescriptionLink();
    await guidedImpl.fillDescription(this.guidedItem.description);
});

When("I add contract for the item", async function(){
    await guidedImpl.clickOnSupplierEditIcon();
    this.contractID =  await guidedImpl.fillSupplierContractID(this.guidedItem.supplierContractId);
    await guidedImpl.clickOnSupplierModalDoneButton();
});