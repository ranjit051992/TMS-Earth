/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * EProcCartItems class
 */
class EProcCartItems {
  /**
   * To get sum total of amount of items present in cart
   * @return {String} amountWithCurrency - sum of amount of items in cart
   */
  getTotalAmountOfCartItems() {
    let amountWithCurrency = 0;
    within("eproc-cart-items", () => {
      within("eproc-cart-spotlight", async () => {
        amountWithCurrency = await I.grabTextFrom("//div/h5");
      });
    });
    return amountWithCurrency;
  }
}

module.exports = new EProcCartItems();
module.exports.EProcCartItems = EProcCartItems; // for inheritance
