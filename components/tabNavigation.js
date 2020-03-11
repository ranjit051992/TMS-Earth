/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Tab Navigation class
 */
class TabNavigation {
  /**
   * To select tab
   * @param {String} tabName Name of the section
   */
  selectTab(tabName) {
    I.click(`"//dew-tabset//a[text()[normalize-space()='" + ${tabName} + "']]|
      (//div[@id='stickytabs-errpanel-position'])[1]//a[contains(.,'" + ${tabName} + "')]"`);
    I.seeElement(`"//dew-tabset//a[text()[normalize-space()='" + ${tabName} + "'] and contains(@class,'active')]"`);
  }
}

module.exports = new TabNavigation();
module.exports.TabNavigation = TabNavigation; // for inheritance
