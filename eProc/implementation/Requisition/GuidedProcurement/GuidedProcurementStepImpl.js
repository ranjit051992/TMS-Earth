const {I} = inject();
const iGuided = require("../GuidedProcurement/GuidedProcurementObject");
const guidedImpl = require("../GuidedProcurement/GuidedProcurementImpl");
const objectCreation = require("../../../dataCreation/ObjectCreation");
const cartImpl = require("./../Cart/CartImpl");
const prop = global.confi_prop;
const logger = require("./../../../../Framework/FrameworkUtilities/Logger/logger");

Given("I add short description",async function(){

    this.guidedItem = objectCreation.getObjectOfGuidedItem(0);
    await guidedImpl.CreateGuidedItem(this.guidedItem);
});

Given("I add qty and price",async function(){

});

Given("I add Sourcing status",async function(){

});

Given("I save it",async function(){

});

When("I add {int} free text item {string} to cart", async function(noOfItem, itemType){
    this.reqBO = await objectCreation.getObjectOfRequisition(noOfItem, itemType);
    this.guidedItemBO = this.reqBO.items[0];
    logger.info("Guided item "+this.guidedItemBO);
    await cartImpl.clearCart();
    await I.wait(prop.DEFAULT_WAIT);
   // let itemArray = new Array();
    this.guidedItemBO =  await guidedImpl.CreateGuidedItem(this.guidedItemBO);

});