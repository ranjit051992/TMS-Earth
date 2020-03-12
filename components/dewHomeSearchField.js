/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();

/**
 * Home Links class
 */
class DewHomeSearchField {
  /**
   * Search Field Home
   * @param {*} link
   */
  searchFieldHome(link) {
    I.wait(5);
    I.fillField(`//input[@id='input-text-area'][@type='MST_Search']`, link);
    I.seeElement(`//div[@class='result-bucket-search']//div/span[contains(text(),'${link}')]`);
    I.click(`//div[@class='result-bucket-search']//div/span[contains(text(),'${link}')]`);
  }

  searchFieldHome(link) {
    I.wait(5);
    I.fillField(`//input[@id='input-text-area'][@type='MST_Search']`, link);
    I.seeElement(`//div[@class='result-bucket-search']//div/span[contains(text(),'${link}')]`);
    I.click(`//div[@class='result-bucket-search']//div/span[contains(text(),'${link}')]`);
  }
  /**
   * Verify frequently accessed home search results
   * @param {*} link
   */
  verifyFrequentlyAccessedHomeSearchResults(link) {
    this.search_field_Home(link);
    I.click(`//div[contains(@class,'dew-container')]//span[contains(@class,'navbar-brand')]`); // Switch back to Home
    I.waitToProcess();
    if (I.seeElement(`//div[text()='FREQUENTLY ACCESSED']/ancestor::div//span[contains(text(),'${link}')]`)) {
      console.log(link + " is present in FREQUENTLY ACCESSED list");
    }
  }
  /**
   * Verify Supplier Search One View Page
   * @param {*} link
   */

   
  verifySupplierSearchOneView(link) {
    this.search_field_Home(link);
    I.waitToProcess();
    if (I.seeInCurrentUrl("oneView")) {
      console.log("Navigated to " + link + " :oneView");
    } else {
      console.log("Not Navigated to " + link + " :oneView");
    }
  }
}

module.exports = new DewHomeSearchField();
module.exports.DewHomeSearchField = DewHomeSearchField;
