const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const dbKeys = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const iOnlineStore = require("./OnlineStoreObject");
const onlineStoreImpl = require("./OnlineStoreImpl");
const cartImpl = require("../Cart/CartImpl");
const prop=global.confi_prop;
const commonUtils = require("../../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require("faker");
const reqObj = require("../../../dataCreation/bo/Requisition");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const objCreation= require("../../../dataCreation/ObjectCreation");
const iGuided = require("../GuidedProcurement/GuidedProcurementObject");
const commonComponent = require("../../../commonKeywords/CommonComponent");
let map = new Map();


When("I search for {string} {string} items", async function (noOfItem, itemType) {

    await cartImpl.clearCart();
    let itemArray = new Array();
    if((itemType.indexOf('[')) > 0 && noOfItem==="1")
    {
        let item = await I.getData(itemType);
        await onlineStoreImpl.searchItem(item);
        itemArray.push(item);
    }
    else
    {
        for (let i = 0; i < noOfItem; i++) {
        
            let item = await I.getData(itemType+"["+i+"]");
            await onlineStoreImpl.searchItem(item);
            itemArray.push(item);
        }
    }
   
    this.addedItems = itemArray;

});


When("I add {string} {string} items to cart", async function (noOfItem, itemType) {

    //onlineStoreImpl.addItemsToCart(noOfItem,itemType);
    this.reqBO = await objCreation.getObjectOfRequisition(noOfItem, itemType);
    await cartImpl.clearCart();
    await I.wait(prop.DEFAULT_WAIT);
    let itemArray = new Array();

    if((itemType.indexOf('[')) > 0 && noOfItem==="1")
    {
        let item = await I.getData(itemType);
        await onlineStoreImpl.searchItem(item);
        itemArray.push(item);
    }
    else
    {
        for (let i = 0; i < noOfItem; i++) 
        {
            let item = await I.getData(itemType+"["+i+"]");
            await onlineStoreImpl.addItemToCart(item, faker.random.number(20));
            itemArray.push(item);

        }
    }
    this.addedCartItems = itemArray;


});

Then("I should see all the matching items for {string} on Listing", async function (itemType) {

    let isPresent = true;
    
    for (let i = 0; i < this.addedItems.length; i++) 
    {
        let flag = await onlineStoreImpl.checkSearchItemReqults(this.addedItems[i]);
        if (flag === false) 
        {
            isPresent = false;
        }
    }

    I.assertEqual(isPresent, true);

});



When("I search and add {string} {string} items as Favourite", async function (noOfItem, itemType) {
    let favoriteItemMap = new Map();

    if(itemType.indexOf('[') > 0 && noOfItem==="1")
    {
        let item = await I.getData(itemType);
        await onlineStoreImpl.searchItem(item);
        itemArray.push(item);
    }
    else
    {
        for (let i = 0; i < noOfItem; i++) 
        {
            let item = await I.getData(itemType+"["+i+"]");
            await onlineStoreImpl.searchItem(item);
            let totalFavoritesMarked = await onlineStoreImpl.clickOnFavoritesIcon(item);
            favoriteItemMap.set(item,totalFavoritesMarked);
        }

        
    }
    this.addedFavoriteItems = favoriteItemMap;


});

When("I remove items from favorites", async function () {


    
    let isPresent = await onlineStoreImpl.checkItemsInFavorites();
    if(isPresent)
    {
        await onlineStoreImpl.clickOnFavoritesViewAllButton();
        await onlineStoreImpl.selectAllFavoriteItems();
        await onlineStoreImpl.clickOnMenuIcon();
        await onlineStoreImpl.SelectOnMenuOption(lmtVar.getLabel("REMOVE_FAVORITES"));
        await onlineStoreImpl.clickOnOnlineStoreLink();
        await onlineStoreImpl.waitForOnlineStoreToLoad();
    }
});

Then("I should see all the added Items to favorite can be viewed from 'My Favorites' tab", async function (noOfItem, itemType) {

    let favoriteItems = this.addedFavoriteItems.keys();
    let flag = true;
    await onlineStoreImpl.clickOnOnlineStoreLink();
    await onlineStoreImpl.waitForOnlineStoreToLoad();
    await onlineStoreImpl.clickOnFavoritesTab();
    await onlineStoreImpl.clickOnFavoritesViewAllButton();
    for (let item of favoriteItems) 
    {
        let val = await onlineStoreImpl.verifyFavoriteItems(item,this.addedFavoriteItems.get(item));
        if(val === false)
        {
            flag = false;
        }

    }

    I.assertEqual(flag,true);

});

Given("I select multiple catalog items", async function() {

    this.comparedItemDetails = await onlineStoreImpl.selectMultipleItems();
    await I.wait(10);
    
});

Given("I click on compare items", async function() {

    let flag = await onlineStoreImpl.checkIfCompareButtonPresent();
    if(flag)
    {
        await onlineStoreImpl.clickOnCompareButton();
    }
});

Then("I should see the selected items compared against multiple parameters name, price, currency, UOM, Supplier", async function() {

    let itemDetails = await onlineStoreImpl.fetchComparedItemDetails();
    let isEqual = await onlineStoreImpl.verifyComparedItems(this.comparedItemDetails,itemDetails);
    I.assertEqual(isEqual,true);
});



Given("I navigate to Shopping Basket Page",async function()
{
    await onlineStoreImpl.clickOnBasketsTab();
    await onlineStoreImpl.clickOnBasketViewAllButton();
    this.originalBaskets = await onlineStoreImpl.fetchBasketNames();
});


When("I click on basket name sorting option",async function()
{
    await onlineStoreImpl.clickOnSortIcon();
    this.sortOrder = await onlineStoreImpl.getCurrentSortOrder();
    this.sortedBaskets = await onlineStoreImpl.fetchBasketNames();
});

Then("I should see all baskets sorted from basket name",async function()
{
    let isSorted = await onlineStoreImpl.verifySortedBaskets(this.sortOrder,this.originalBaskets,this.sortedBaskets);
    I.assertEqual(isSorted,true);
});

Given("I navigate to OnlineStore",async function()
{
   // await onlineStoreImpl.clickOnOnlineStoreLink();
   await I.amOnPage(prop.DDS_OnlineStore_Url);
   await onlineStoreImpl.waitForOnlineStoreToLoad();
  
});

When("I Navigate to Guided Page",async function()
{
    await onlineStoreImpl.clickOnCreateRequestButton();
    await commonComponent.waitForElementVisible(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
    
});