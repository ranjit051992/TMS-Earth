/* eslint-disable quotes */
'use strict';
const { I , CommonKeyword } = inject();

/**
 * Side Menu Navigation
 */
class DewNavBar {
  /**
   * This function is used to click hamburger icon
   */
  clickHamburger() {
    I.waitForElement("dew-navbar", 30);
    CommonKeyword.click("//dew-navbar//span[contains(@class,'menu-link')]")
  }
  
}

module.exports = new DewNavBar();
module.exports.DewNavBar = DewNavBar; // for inheritance
