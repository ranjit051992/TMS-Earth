const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iCart = require("./CartObject");
const cartImpl = require("./CartImpl");
const onlinestoreImpl = require("../OnlineStore/OnlineStoreImpl");
const prop=global.confi_prop;
const commonUtils = require("../../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');

Given("I checkout", function () {

    onlinestoreImpl.clickOnCartIcon();
    I.waitForVisible(global.uiElements.get(iCart.CART_ITEM_TABLE));
    cartImpl.clickOnCheckoutButton();
});


Then("I should see {string} {string} items in Cart", async function(noOfItem,itemType){
    let isPresent = true;

    onlinestoreImpl.clickOnCartIcon();
    I.waitForVisible(global.uiElements.get(iCart.CART_ITEM_TABLE));
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