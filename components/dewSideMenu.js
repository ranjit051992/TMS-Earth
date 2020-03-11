"use strict";
const { I } = inject();

/**
 * Side Menu Navigation
 */
class ProductNavigator {
  /**
   * This function is used to navigate to a particular product's page
   * @param {string} product
   * @param  {...string} tab
   */
  navigate(product, ...tab) {
    // Click Product link
    I.click("//dew-side-menu//ul[1]/li[contains(@class,'menu-item') and @title='" + product + "']");
    // Verify if the next level menu is opened, if applicable
    for (let index = 0; index < tab.length; index++) {
      I.click("//dew-side-menu//ul[" +(index+2)+"]/li[contains(@class,'menu-item') and @title='" + tab[index] + "']");
    }
  }

  /**
   * To navigate to a particular module in ZSN
   * @param {*} testName
   * @param {*} product
   * @param {*} tab
   * @param {*} subTab
   */
  navigateZSN(testName, product, tab, subTab) {
    session(testName, () => {
      // Click Product link
      I.moveCursorTo("//*[@id='zsp-submenus-id']//a//span[text()='" + product + "']");
      I.click("//*[@id='zsp-submenus-id']//a//span[text()='" + product + "']");
      I.moveCursorTo("//*[@id='zsp-submenus-id']//ul/li[span[text()='" + product + "']]/following-sibling::li//span[text()='" + tab + "']");
      I.click("//*[@id='zsp-submenus-id']//ul/li[span[text()='" + product + "']]/following-sibling::li//span[text()='" + tab + "']");
      I.moveCursorTo("//*[@id='zsp-submenus-id']//ul/li[span[text()='" + product + "']]/following-sibling::li/a[span/span[text()='" + tab + "']]/following-sibling::ul//span[text()='" + subTab + "']");
      I.click("//*[@id='zsp-submenus-id']//ul/li[span[text()='" + product + "']]/following-sibling::li/a[span/span[text()='" + tab + "']]/following-sibling::ul//span[text()='" + subTab + "']");
    });
  }


  /**
   * This function is used to check if specified module is present in SideBar Menu
   * @param {string} product
   */
  async checkIfModulePresent(product) {
    // Click Product link
    I.seeElement("//dew-side-menu//ul[1]/li[contains(@class,'menu-item') and @title='" + product + "']");
  }


  
  /**
   * This function is used to check if page is navigate to specified product
   * @param {string} product
   */
  async checkIfNavigatedToSpecifiedProduct(product) {
    // Click Product link
    await I.seeInCurrentUrl(product);
  }


  /**
   * This function is module is opened in new tab
   * @param {string} product
   */
  async checkIfModuleOpenedInNewtab(product) {
      await I.seeInCurrentUrl(product);
  }


}
module.exports = new ProductNavigator();
module.exports.ProductNavigator = ProductNavigator; // for inheritance
