const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iOnlineStore = require("./OnlineStoreObject");
const prop = global.confi_prop;
module.exports={

    /** 
     * fill search item name in search field
     * 
     * @param itemName
     * 
    */
    async fillSearchItem(itemName)
    {
        I.waitForVisible(I.getElement(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(I.getElement(iOnlineStore.SEARCH_TEXTBOX));
        I.fillField(I.getElement(iOnlineStore.SEARCH_TEXTBOX),itemName);
        logger.info(`Entered item name : ${itemName}`);
        
    },

    /** 
     * clicks on search icon
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnSearchIcon()
   {
       I.waitForVisible(I.getElement(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable(I.getElement(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
       I.pressKey('Enter');
       logger.info(`clicked on Search icon`);
       
   },

   /** 
     * fill quantity in for specific item 
     * 
     * @param itemName, quantity
     * 
    */
   async fillItemQuantity(itemName,quantity)
   {
       I.waitForVisible("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//input[@aria-label='Quantity']",prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//input[@aria-label='Quantity']",prop.DEFAULT_MEDIUM_WAIT);
       I.clearField("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//input[@aria-label='Quantity']");
       I.fillField("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//input[@aria-label='Quantity']",quantity);
       logger.info(`Entered item quantity : ${quantity}`);
   },

   /** 
     * clicks on add to cart button present against specific item
     * 
     * @param itemName
     * @returns   
     * 
    */
   async clickOnAddToCartButton(itemName)
   {
       I.waitForVisible("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//button[contains(@class,'btn primary')]",prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//button[contains(@class,'btn primary')]",prop.DEFAULT_MEDIUM_WAIT);
       I.click("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//button[contains(@class,'btn primary')]");
       logger.info(`clicked on add to cart button`); 
   },

   /** 
     * clicks on cart icon
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnCartIcon()
   {
       I.waitForVisible(I.getElement(iOnlineStore.CART_ICON),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable(I.getElement(iOnlineStore.CART_ICON),prop.DEFAULT_MEDIUM_WAIT);
       I.click(I.getElement(iOnlineStore.CART_ICON));
       logger.info(`clicked on Cart icon`); 
   },

   /** 
     * fill search item name in search field & hit search icon
     * 
     * @param itemName
     * @returns   
     * 
    */
   async searchItem(itemName)
   {
       this.fillSearchItem(itemName);
       this.clickOnSearchIcon();
       I.waitForVisible("//span[contains(text(),'"+itemName+"')]",prop.DEFAULT_MEDIUM_WAIT);
       I.seeElement("//span[contains(text(),'"+itemName+"')]");
       logger.info("Item is searched.");
   },

   /** 
     * search item, fill quantity & add it to cart
     * 
     * @param itemName , quantity
     * @returns   
     * 
    */
   async addItemToCart(itemName,quantity)
   {
        this.searchItem(itemName);
        this.fillItemQuantity(itemName,quantity);
        this.clickOnAddToCartButton(itemName);
        I.waitForVisible(I.getElement(iOnlineStore.ADD_TO_CART_SUCCESS_MSG),prop.DEFAULT_MEDIUM_WAIT);
        logger.info("Add to cart success msg is displayed. Item "+itemName+" is added to cart.");
   },

   /** 
     * click on Online Store link present at the top
     * 
     * @param
     * @returns   
     * 
    */
   async clickOnOnlineStoreLink()
   {
       I.waitForVisible(I.getElement(iOnlineStore.ONLINE_STORE_LINK),prop.DEFAULT_MEDIUM_WAIT);
       I.click(I.getElement(iOnlineStore.ONLINE_STORE_LINK));
   },

   /** 
     * Wait for loading spinner to go off & item search textbox to be visible
     * 
     * @param
     * @returns   
     * 
    */
   async waitForOnlineStoreToLoad()
   {
       I.waitForInvisible(I.getElement(iOnlineStore.SPINNER),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForVisible(I.getElement(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
       logger.info("Online Store page is loaded.");
   },

    /** 
     * add number of items to cart of specified type
     * 
     * @param number of items , itemType (DB item name key)
     * @returns   
     * 
    */
   async addItemsToCart(noOfItem,itemType)
   {
       
   }

   

}