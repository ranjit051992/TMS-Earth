/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const DynamicLocator = require("dd-cc-zycus-automation/components/element")
const FooterObject = require("./DD_FooterObject")

/**
 * Home Links class
 */
class FooterLinkImpl {
  /**
   * Constructor
   */
  constructor() {
    this.dewHomeLinkSpecs = require("../QuickLinks/dewLinkSpecsFile");
  }
  /**
   * Click Home Direct Link
   * @param {*} link
   */
   async clickHomeDirectLink(link) {
    await I.seeElement(await DynamicLocator.getDynamicLocator(FooterObject.HomeDirectLink,"<<link>>",link))
    await CommonKeyword.clickElement(await DynamicLocator.getDynamicLocator(FooterObject.HomeDirectLink,"<<link>>",link));
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
   async clickHomeCircleLink(link) {
    await I.seeElement(await DynamicLocator.getDynamicLocator(FooterObject.CircleLink,"<<link>>",link))
    await CommonKeyword.clickElement(await DynamicLocator.getDynamicLocator(FooterObject.CircleLink,"<<link>>",link));
    I.waitToProcess();
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

module.exports = new FooterLinkImpl();
module.exports.FooterLinkImpl = FooterLinkImpl;
