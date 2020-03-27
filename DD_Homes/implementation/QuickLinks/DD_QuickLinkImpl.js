/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
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
    I.wait(5);
    let dropdownLink = `//dew-dropdown-trigger//div[contains(text(),'Quick Links')]`;
    I.scrollPageToTop();
    I.seeElement(dropdownLink);
    I.click(dropdownLink);
    // CommonKeyword.clickElement();
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
    CommonKeyword.clickElement(`//div[contains(@class,'dropdown-menu show')]//a[contains(@class,'dropdown-item')][contains(text(),'${link}')]`);
    console.log(this.dewQuickLinkSpecs.dd_quick_link[link]);
  }

/**
  * Click on Options
  * @param {options} options 
  */
  async clickQuickLinkDropdownOption(options) {  
    I.wait(2)
    I.seeElement(`//div[contains(@class,'dropdown-menu show')]//span[text()='${options}']`);
    CommonKeyword.clickElement(`//div[contains(@class,'dropdown-menu show')]//span[text()='${options}']`);
    I.seeElement(`//div[@class='modal-content']//span[text()='${options}']`);  
  }
  /**
   * Customize Quick Links
   * @param  {...any} linkList
   */
  async customizeQuickLinks(product,...linkList) {
    console.log(linkList)
    CommonKeyword.clickElement(`//span[text()='Customize']//ancestor::div[@class='modal-content']//span[text()='Reset All']`); // Reset All
     linkList.forEach((link) => {
       let linkWithoutWhiteSpace= link.split(/\s/).join('');
       console.log(linkWithoutWhiteSpace)
       I.clearField(`//input[@placeholder='Search']`)
       CommonKeyword.enterTextUsingPlaceHolder("Search",linkWithoutWhiteSpace)
       I.waitForVisible(`//div[span[text()='${product}']]/following-sibling::dew-row//label[text()[normalize-space()='${link}']]`,10)
      CommonKeyword.clickElement(`//div[span[text()='${product}']]/following-sibling::dew-row//label[text()[normalize-space()='${link}']]`);
    });
    CommonKeyword.clickElement(`//span[text()='Customize']//ancestor::div[@class='modal-content']//span[text()='Apply']`);
    I.waitForInvisible(`//div[@class='modal-content']//span[text()='Customize']`, 10);
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

