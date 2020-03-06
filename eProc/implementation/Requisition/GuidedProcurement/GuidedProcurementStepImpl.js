const iGuided = require("../GuidedProcurement/GuidedProcurementObject");
const guidedImpl = require("../GuidedProcurement/GuidedProcurementImpl");
const objectCreation = require("../../../dataCreation/ObjectCreation");


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