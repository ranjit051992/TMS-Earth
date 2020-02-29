const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iCart = require("./CartObject");
const iOnlineStore = require("../OnlineStore/OnlineStoreObject");
const onlineStore = require("../OnlineStore/OnlineStoreImpl");
const prop = global.confi_prop;
const iConstant = require("../../../constants/iConstants");

module.exports = {

     /** 
     * clicks on checkout button
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnCheckoutButton()
   {
       I.waitForVisible(global.uiElements.get(iCart.CHECKOUT_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable(global.uiElements.get(iCart.CHECKOUT_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
       I.click(global.uiElements.get(iCart.CHECKOUT_BUTTON));
       logger.info(`clicked on Checkout button`); 
   },

   /** 
     * clicks on checkout button
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnDeleteAllItemsButton()
   {
       I.waitForVisible(global.uiElements.get(iCart.DELETE_ALL_ITEMS_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable(global.uiElements.get(iCart.DELETE_ALL_ITEMS_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
       I.click(global.uiElements.get(iCart.DELETE_ALL_ITEMS_BUTTON));
   },

   /** 
     * clicks on 'Yes' button on confirmation popup
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnConfirmPopupYesButton()
   {
       I.waitForVisible(global.uiElements.get(iCart.CONFIRM_POPUP_YES_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable(global.uiElements.get(iCart.CONFIRM_POPUP_YES_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
       I.click(global.uiElements.get(iCart.CONFIRM_POPUP_YES_BUTTON));
   },
    
    /** 
     * Delete all cart items
     * 
     * @param 
     * @returns   
     * 
    */
   async deleteAllItemsFromCart()
   {
       this.clickOnDeleteAllItemsButton();
       this.clickOnConfirmPopupYesButton();
       I.waitForVisible(global.uiElements.get(iCart.ITEM_DELETE_SUCCESS_MSG),prop.DEFAULT_HIGH_WAIT);
       I.see(iConstant.EMPTY_CART_MSG);
       logger.info("Cart is cleared.");
   },

   /** 
     * Check for 'NA' to be disappeared & presence of item in cart.
     * If item is present then navigate to cart page & clear cart and navigate back to online store page
     * 
     * @param 
     * @returns   
     * 
    */
   async clearCart()
   {
        I.waitForInvisible("//eproc-cart-spotlight//span[contains(text(),'"+iConstant.NA+"')]",prop.DEFAULT_MEDIUM_WAIT);
        let noOfElements = await I.grabNumberOfVisibleElements(global.uiElements.get(iOnlineStore.CART_ITEM_ICON));
        logger.info("Cart Item count : "+noOfElements);
        if(noOfElements>0)
        {
            onlineStore.clickOnCartIcon();
            this.deleteAllItemsFromCart();
            onlineStore.clickOnOnlineStoreLink();
            onlineStore.waitForOnlineStoreToLoad();
            logger.info("Cart is cleared. Navigated to online store page.");
        }
        else
        {
            logger.info("Cart is already empty.");
        }
        
   },

   async checkItemsInCart(itemName)
   {
       let number = await I.grabNumberOfVisibleElements("//div[@class='table-body']//span[contains(text(),'"+itemName+"')]");
       let isPresent = false;
       if(number>0)
       {
           isPresent = true;
       }

       return isPresent;
   }
}