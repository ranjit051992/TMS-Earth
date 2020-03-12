/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
/**
 * Home Links class
 */
class DewQuickLinks {
  /**
   * Constructor
   */
  constructor() {
    this.dewQuickLinkSpecs = require("./dewLinkSpecsFile");
  }
  /**
   * Navigate to Quick link
   */
   async navigateQuickLink() {
    I.click(`//dew-dropdown-trigger//div[contains(text(),'Quick Links')]`);
    I.waitForVisible(`//div[contains(@class,'dropdown-menu show')]`);
    console.log("Navigated to quick links");
  }


  async verifyQuickLinkPage(link){

    if (I.seeInCurrentUrl(this.dewQuickLinkSpecs.dd_quick_link[link])) {
      console.log("Navigated to " + link + " successfully");
    } else {
      console.log("Not Navigated to " + link + " successfully");
    }
  }




  /**
   * Click Quick Link
   * @param {*} link
   */
  async clickQuickLink(link) {

    I.click(`//div[contains(@class,'dropdown-menu show')]//a[contains(@class,'dropdown-item')][contains(text(),'${link}')]`);
    console.log(this.dewQuickLinkSpecs.dd_quick_link[link]);
  }
  /**
   * Customize Quick Links
   * @param  {...any} linkList
   */
  async customizeQuickLinks(...linkList) {
    
    I.click(`//span[text()='Customize']//ancestor::div[@class='modal-content']//span[text()='Reset All']`); // Reset All
     linkList.forEach((link) => {
      I.click(`//dew-checkbox//label[normalize-space(text())='${link}']`);
    });
    I.click(`//span[text()='Customize']//ancestor::div[@class='modal-content']//span[text()='Apply']`);
    I.waitForInvisible(`//div[@class='modal-content']//span[text()='Customize']`, 10);
  }

  /**
   * Click on Customize 
   */
  async navigateToQuickLinks(options) {
    
    I.click(`//div[contains(@class,'dropdown-menu show')]//span[text()='${options}']`);
    I.seeElement(`//div[@class='modal-content']//span[text()='${options}']`);
    
  }
  /**
   * Verify Quick Links in Dropdown
   * @param  {...any} linkList
   */
  async verifyQuickLinksInDropdown(...linkList) {
    this.navigateQuickLink();
    linkList.forEach((link) => {
      if (I.seeElement(`//div[contains(@class,'dropdown-menu show')]//a[contains(@class,'dropdown-item')][contains(text(),'${link}')]`)) {
        console.log(link + " present in Quick links dropdown");
      }
    });
  }
  /**
   * Verify Admin links in different Tabs
   * @param {*} link
   */
  verifyAdminLinksInDifferentTabs(link) {
    this.navigate_quick_link();
    I.click(`//div[contains(@class,'dropdown-menu show')]//a[contains(@class,'dropdown-item')][contains(text(),'${link}')]`);
    I.switchToNextTab();
    console.log(this.dewQuickLinkSpecs.dd_quick_link[link]);
    if (I.seeInCurrentUrl(this.dewQuickLinkSpecs.dd_quick_link[link])) {
      console.log("Navigated to " + link + " successfully");
    } else {
      console.log("Not Navigated to " + link + " successfully");
    }
  }
}

module.exports = new DewQuickLinks();
module.exports.DewQuickLinks = DewQuickLinks;

