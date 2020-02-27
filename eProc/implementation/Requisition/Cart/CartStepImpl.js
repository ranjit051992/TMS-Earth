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