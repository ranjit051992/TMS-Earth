/* eslint-disable linebreak-style */
"use strict";
const DewRadioButton = require("dd-cc-zycus-automation/components/dewRadioButton")
const DatePicker = require("dd-cc-zycus-automation/components/datePicker")
const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
let varDesc="AutoDescription"+generateRandomNumber();

/**
 * Home links class
 */
class DewImpersonation {
  
/**
 * navigate to allow Impersonation
 */
  navigateToAllowImpersonation() {
    I.wait(10);
    I.waitForVisible(`//dew-dropdown[contains(@class,'profile')]`,20);
    I.seeElement(`//dew-dropdown[contains(@class,'profile')]`);   
    CommonKeyword.clickElement(`//dew-dropdown[contains(@class,'profile')]`);
    I.waitForVisible(`//div[contains(@class,'dropdown-item') and text()[normalize-space()='Allow Impersonation']]`,20);
    CommonKeyword.clickElement(`//div[contains(@class,'dropdown-item') and text()[normalize-space()='Allow Impersonation']]`);
    I.waitForVisible(`//h1[@title='Manage your Impersonation Authorizations']`,20);
    I.seeElement(`//h1[@title='Manage your Impersonation Authorizations']`);
  }
  /**
   * Impersonation function
   * @param {*} radioBtnLabel
   */
  

  async authorizeImpersonation(radioBtnLabel) {
    this.navigateToAllowImpersonation();
    CommonKeyword.clickElement(`//a[contains(@class,'nav-link')]/*[text()[normalize-space()='Authorize Impersonation']]`);
    I.seeElement(`//a[contains(@class,'nav-link active')]/*[text()[normalize-space()='Authorize Impersonation']]`);
    DewRadioButton.selectRadioButton(radioBtnLabel);
    I.wait(2);
    DatePicker.selectInNextMonth(`//div[contains(@class,'pickerDiv')]/input[@aria-label='date']`);
    I.fillField("//textarea[@formcontrolname='description']",varDesc);
    //TextAreaWithPlaceholder.enterText("Enter description","AutoDescription"+generateRandomNumber());
    //textarea[@formcontrolname='description']
    CommonKeyword.clickElement(`//button[@aria-label='Save']`);
   
  }
}

module.exports = new DewImpersonation();
module.exports.DewImpersonation = DewImpersonation;

function generateRandomNumber() {
    return Math.floor(Math.random() * 9000);
  } 
