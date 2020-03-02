const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iCart = require("./CartObject");
const cartImpl = require("./CartImpl");
const onlinestoreImpl = require("../OnlineStore/OnlineStoreImpl");
const prop=global.confi_prop;
const commonUtils = require("../../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');
const reqObj = require("../../../dataCreation/bo/Requisition");
const objCreation= require("../../../dataCreation/ObjectCreation");
const checkoutObj = require("../../Requisition/Checkout/CheckoutObject");

Given("I checkout", async function () {

    await onlinestoreImpl.clickOnCartIcon();
    await I.waitForVisible(I.getElement(iCart.CART_ITEM_TABLE));
    await cartImpl.clickOnCheckoutButton();
    await I.waitForVisible(I.getElement(checkoutObj.REQUISITION_NAME));
    this.reqBO = await objCreation.getObjectOfRequisition("1", "Catalog");
});


Then("I should see {string} {string} items in Cart", async function(noOfItem,itemType){
    let isPresent = true;

    await onlinestoreImpl.clickOnCartIcon();
    await I.waitForVisible(I.getElement(iCart.CART_ITEM_TABLE));
    for (let i = 0; i < this.addedCartItems.length; i++) 
    {
       let flag = await cartImpl.checkItemsInCart(this.addedCartItems[i]);
       if(flag ===false)
       {
           isPresent = false;
       }
    }
    
    I.assertEqual(isPresent,true);

});