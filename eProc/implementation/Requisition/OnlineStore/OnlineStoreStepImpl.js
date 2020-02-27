const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const dbKeys = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const iOnlineStore = require("./OnlineStoreObject");
const onlineStoreImpl = require("./OnlineStoreImpl");
const cartImpl = require("../Cart/CartImpl");

const prop=require("../../../../Framework/PropertiesConfigurator");
const commonUtils = require("../../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');

let map = new Map();


When("I search for {string} {string} items", function (noOfItem,itemType) {

    cartImpl.clearCart();

    for(let i=0; i<noOfItem;i++)
    {
        let item = commonUtils.splitData(i,itemType);
        onlineStoreImpl.searchItem(item);
    }

});

When("I add {string} {string} items to cart", function(noOfItem,itemType) {

    onlineStoreImpl.addItemsToCart(noOfItem,itemType);

});