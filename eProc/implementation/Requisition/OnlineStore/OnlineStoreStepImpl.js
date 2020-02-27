const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const dbKeys = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const iOnlineStore = require("./OnlineStoreObject");
const onlineStoreImpl = require("./OnlineStoreImpl");
const cartImpl = require("../Cart/CartImpl");

const prop=global.confi_prop;
const commonUtils = require("../../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');

let map = new Map();


When("I search for {string} {string} items", async function (noOfItem,itemType) {

    cartImpl.clearCart();

    for(let i=0; i<noOfItem;i++)
    {
        let item = commonUtils.splitData(i,itemType);
        onlineStoreImpl.searchItem(item);
    }

});

When("I add {string} {string} items to cart", async function(noOfItem,itemType) {

   //onlineStoreImpl.addItemsToCart(noOfItem,itemType);
   cartImpl.clearCart();
       for(let i=0; i<noOfItem;i++)
       {
           let item = commonUtils.splitData(i,itemType);
           onlineStoreImpl.addItemToCart(item,faker.random.number(20));
        }

});