/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();

/**
 * Home Links class
 */
class DewHomeLinks {
  /**
   * Constructor
   */
  constructor() {
    this.dewHomeLinkSpecs = require("./dewHomeLinkSpecsFile");
  }
  /**
   * Click Home Direct Link
   * @param {*} link
   */
   clickHomeDirectLink(link) {
    I.seeElement(`//span[contains(text(),'${link}')]`)
    I.click(`//span[contains(text(),'${link}')]`);
  }

  /**
   * Verify if user is navigated to page
   * @param {*} link
   */

   verifyIfNavigatedToHomeLinkPage(link){
   
    console.log(this.dewHomeLinkSpecs.dd_direct_link[link]);
    if (I.seeInCurrentUrl(this.dewHomeLinkSpecs.dd_direct_link[link])) {
      console.log("Navigated to " + link + " successfully");
    } else {
      console.log("Not Navigated to " + link + " successfully");
    }
  }
  /**
   * Click Home Circle Links
   * @param {*} link
   */
   clickHomeCircleLink(link) {
    I.seeElement(`//div[contains(@class,'circle')]/div[contains(text(),'${link}')]`)
    I.click(`//div[contains(@class,'circle')]/div[contains(text(),'${link}')]`);
  }

  /**
   * Verify if user is navigated to page
   * @param {*} link
   */

   verifyIfNavigatedToCircleLinkPage(link){
    console.log(this.dewHomeLinkSpecs.dd_circle_link[link]);
    if (I.seeInCurrentUrl(this.dewHomeLinkSpecs.dd_circle_link[link])) {
      console.log("Navigated to " + link + " successfully");
    } else {
      console.log("Not Navigated to " + link + " successfully");
    }
  }
}

module.exports = new DewHomeLinks();
module.exports.DewHomeLinks = DewHomeLinks;
