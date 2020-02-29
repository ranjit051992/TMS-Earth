const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const dbKeys = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const iOnlineStore = require("./OnlineStoreObject");
const onlineStoreImpl = require("./OnlineStoreImpl");
const cartImpl = require("../Cart/CartImpl");

const prop = global.confi_prop;
const commonUtils = require("../../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');

let map = new Map();


When("I search for {string} {string} items", async function (noOfItem, itemType) {

    await cartImpl.clearCart();
    let itemArray = new Array();
    for (let i = 0; i < noOfItem; i++) {
        let item = await commonUtils.splitData(i, itemType);
        await onlineStoreImpl.searchItem(item);
        itemArray.push(item);

    }
    this.addedItems = itemArray;

});


When("I add {string} {string} items to cart", async function (noOfItem, itemType) {

    //onlineStoreImpl.addItemsToCart(noOfItem,itemType);
    await cartImpl.clearCart();
    let itemArray = new Array();

    for (let i = 0; i < noOfItem; i++) {
        let item = commonUtils.splitData(i, itemType);
        onlineStoreImpl.addItemToCart(item, faker.random.number(20));
        itemArray.push(item);

    }
    this.addedCartItems = itemArray;


});

Then("I should see all the matching items for {string} on Listing", async function (itemType) {

    let isPresent = true;
    for (let i = 0; i < this.addedItems.length; i++) {
        let flag = await onlineStoreImpl.checkSearchItemReqults(this.addedItems[i]);
        if (flag === false) {
            isPresent = false;
        }
    }

    I.assertEqual(isPresent, true);

});



When("I search and add {string} {string} items as Favourite", async function (noOfItem, itemType) {
    let favoriteItemMap = new Map();
    for (let i = 0; i < noOfItem; i++) 
    {
        let item = commonUtils.splitData(i, itemType);
        await onlineStoreImpl.searchItem(item);
        let totalFavoritesMarked = await onlineStoreImpl.clickOnFavoritesIcon(item);
        I.wait(10);
        favoriteItemMap.set(item,totalFavoritesMarked);

    }
    this.addedFavoriteItems = favoriteItemMap;


});

When("I remove items from favorites", async function () {

    await I.waitForVisible("//dew-default-tab-head[contains(text(),'')]",prop.DEFAULT_MEDIUM_WAIT);
    await I.waitForClickable("//dew-default-tab-head[contains(text(),'Favorites & Previously Used')]",prop.DEFAULT_MEDIUM_WAIT);
    await I.click("//dew-default-tab-head[contains(text(),'Favorites & Previously Used')]");
    await I.wait(2);
    let isPresent = await onlineStoreImpl.checkItemsInFavorites();
    if(isPresent)
    {
        await onlineStoreImpl.clickOnFavoritesViewAllButton();
        await onlineStoreImpl.selectAllFavoriteItems();
        await onlineStoreImpl.clickOnMenuIcon();
        await onlineStoreImpl.SelectOnMenuOption("Remove - Favorites");
        await onlineStoreImpl.clickOnOnlineStoreLink();
        await onlineStoreImpl.waitForOnlineStoreToLoad();
    }
});


Then("I should see all the added Items to favorite can be viewed from 'My Favorites' tab", async function (noOfItem, itemType) {

    let favoriteItems = this.addedFavoriteItems.keys();
    let flag = true;
    await onlineStoreImpl.clickOnOnlineStoreLink();
    await onlineStoreImpl.waitForOnlineStoreToLoad();
    await I.waitForVisible("//dew-default-tab-head[contains(text(),'Favorites & Previously Used')]",prop.DEFAULT_MEDIUM_WAIT);
    await I.click("//dew-default-tab-head[contains(text(),'Favorites & Previously Used')]");
    await onlineStoreImpl.clickOnFavoritesViewAllButton();
    for (let item of favoriteItems) 
    {
        let val = onlineStoreImpl.verifyFavoriteItems(item,this.addedFavoriteItems.get(item));
        if(val === false)
        {
            flag = false;
        }

    }

    I.assertEqual(flag,true);

});

Then("I should see all the added Items to favorite can be viewed from 'My Favorites' tab", async function (noOfItem, itemType) {

    let favoriteItems = this.addedFavoriteItems.keys();
    let flag = true;
    await onlineStoreImpl.clickOnOnlineStoreLink();
    await onlineStoreImpl.waitForOnlineStoreToLoad();
    await I.waitForVisible("//dew-default-tab-head[contains(text(),'Favorites & Previously Used')]",prop.DEFAULT_MEDIUM_WAIT);
    await I.click("//dew-default-tab-head[contains(text(),'Favorites & Previously Used')]");
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
    await I.waitForVisible("//dew-default-tab-head[contains(text(),'Basket')]",prop.DEFAULT_MEDIUM_WAIT);
    await I.click("//dew-default-tab-head[contains(text(),'Basket')]");
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