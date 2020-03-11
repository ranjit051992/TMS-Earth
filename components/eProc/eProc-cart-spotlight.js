/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * EProcCartIcon class
 */
class EProcCartIcon {
  /**
   * To navigate to view details of items in Cart
   */
  viewItemsInCart() {
    I.click("div", "eproc-cart-spotlight");
  }
  /**
   * To get count of items present in cart
   * @return {int} count - number of items present in cart
   */
  getCountOfItemsInCart() {
    let count = 0;
    within("eproc-cart-spotlight", async () => {
      count = await I.grabTextFrom("//dew-icon/span");
    });
    return count;
  }
  /**
   * To get sum total of amount of items present in cart
   * @return {String} amountWithCurrency - sum of amount of items in cart
   */
  getTotalAmountOfCartItems() {
    let amountWithCurrency = 0;
    within("eproc-cart-spotlight", async () => {
      amountWithCurrency = await I.grabTextFrom("//div/div[2]");
    });
    return amountWithCurrency;
  }
}

module.exports = new EProcCartIcon();
module.exports.EProcCartIcon = EProcCartIcon; // for inheritance
