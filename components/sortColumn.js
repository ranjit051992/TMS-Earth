/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();

/**
 * Sort column class
 */
class SortColumn {
  /**
   * filter column in ascending order in iSource
   * @param {*} columnname
   */
  async filterByAscending(columnname) {
    I.click("//span[contains(text(),'" + columnname + "')]/following-sibling::dew-icon | //span[contains(text(),'" + columnname + "')]/following-sibling::img");
    let numOfElements = await I.grabNumberOfVisibleElements("//span[contains(text(),'" + columnname + "')]/following-sibling::img[contains(@alt,'ascending')]");
    console.log(numOfElements);

    while (numOfElements <= 0) {
      I.click("//span[contains(text(),'" + columnname + "')]/following-sibling::img | //span[contains(text(),'" + columnname + "')]/following-sibling::dew-icon");
      numOfElements = await I.grabNumberOfVisibleElements("//span[contains(text(),'" + columnname + "')]/following-sibling::img[contains(@alt,'ascending')]");
      console.log(numOfElements);
    }

    I.seeElement("//span[contains(text(),'" + columnname + "')]/following-sibling::img[contains(@alt,'ascending')]");
    // span[contains(text(),'Title')]/following-sibling::dew-icon
  }
  /**
   * filter column in descending order in iSource
   * @param {*} columnname
   */
  async filterByDescending(columnname) {
    I.click("//span[contains(text(),'" + columnname + "')]/following-sibling::dew-icon | //span[contains(text(),'" + columnname + "')]/following-sibling::img ");
    let numOfElements = await I.grabNumberOfVisibleElements("//span[contains(text(),'" + columnname + "')]/following-sibling::img[contains(@alt,'descending')]");
    console.log(numOfElements);

    while (numOfElements <= 0) {
      I.click("//span[contains(text(),'" + columnname + "')]/following-sibling::img | //span[contains(text(),'" + columnname + "')]/following-sibling::dew-icon");
      numOfElements = I.grabNumberOfVisibleElements("//span[contains(text(),'" + columnname + "')]/following-sibling::img[contains(@alt,'descending')]");
      console.log(numOfElements);
    }
    I.seeElement("//span[contains(text(),'" + columnname + "')]/following-sibling::img[contains(@alt,'descending')]");
  }
}
module.exports = new SortColumn();
module.exports.SortColumn = SortColumn; // for inheritance
