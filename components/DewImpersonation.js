/* eslint-disable linebreak-style */
"use strict";
const { I, DewRadioButton, DatePicker,TextAreaWithPlaceholder } = inject();
let varDesc="AutoDescription"+generateRandomNumber();

/**
 * Home links class
 */
class DewImpersonation {
  
/**
 * navigate to allow Impersonation
 */
  navigateToAllowImpersonation() {
    I.seeElement(`//dew-dropdown[contains(@class,'profile')]`);
    I.click(`//dew-dropdown[contains(@class,'profile')]`);
    I.click(`//div[contains(@class,'dropdown-item') and text()[normalize-space()='Allow Impersonation']]`);
    I.seeElement(`//h1[@title='Manage your Impersonation Authorizations']`);
  }
  /**
   * Impersonation function
   * @param {*} radioBtnLabel
   */
  

  async authorizeImpersonation(radioBtnLabel) {
    this.navigateToAllowImpersonation();
    I.click(`//a[contains(@class,'nav-link')]/*[text()[normalize-space()='Authorize Impersonation']]`);
    I.seeElement(`//a[contains(@class,'nav-link active')]/*[text()[normalize-space()='Authorize Impersonation']]`);
    DewRadioButton.selectRadioButton(radioBtnLabel);
    I.wait(2);
    DatePicker.selectInNextMonth(`//div[contains(@class,'pickerDiv')]/input[@aria-label='date']`);
    I.fillField("//textarea[@formcontrolname='description']",varDesc);
    //TextAreaWithPlaceholder.enterText("Enter description","AutoDescription"+generateRandomNumber());
    //textarea[@formcontrolname='description']
    I.click(`//button[@aria-label='Save']`);
   
  }
}

module.exports = new DewImpersonation();
module.exports.DewImpersonation = DewImpersonation;

function generateRandomNumber() {
    return Math.floor(Math.random() * 9000);
  } 
