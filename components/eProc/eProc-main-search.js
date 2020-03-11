/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I, DewButton } = inject();

/**
 * EProcMainSearch class
 */
class EProcMainSearch {
  /**
   * To search for a catalog item
   * @param {String} item - name of item to search
   */
  searchItem(item) {
    searchItemAndWaitForSuggestion(item);
    I.pressKey("Enter");
  }
  /**
   * To search and select an item as per categories
   * @param {String} item - name of item to search
   * @param {String} category - name of category to search an item in
   */
  searchAndSelectItem(item, category = "Catalog Items") {
    searchItemAndWaitForSuggestion(item);
    within(".search-menu", () => {
      I.click("//strong[text()='" + category + "']");
    });
  }
  /**
   * To create request after unsuccesfull search
   * @param {String} item - name of item to search
   */
  createRequest(item) {
    searchItemAndWaitForSuggestion(item);
    within(".search-menu", () => {
      DewButton.click("Create Request");
    });
  }
  /**
   * To create non-catalog item/service
   */
  createRequestForNonCatalogItem() {
    I.click("//eproc-main-search/div[span[text()='Order Non-Catalog Item/Service']]/span[text()='Create Request']");
  }
}

module.exports = new EProcMainSearch();
module.exports.EProcMainSearch = EProcMainSearch; // for inheritance
/**
 * To enter item and wait for suggestion
 * @param {String} item
 */
function searchItemAndWaitForSuggestion(item) {
  I.fillField("//eproc-main-search//input[@aria-label='Search And Select']", item);
  I.wait(5);
  I.seeElement(".search-menu");
}
