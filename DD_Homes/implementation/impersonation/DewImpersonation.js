/* eslint-disable linebreak-style */
"use strict";
const DewRadioButton = require("dd-cc-zycus-automation/components/dewRadioButton")
const DatePicker = require("dd-cc-zycus-automation/components/datePicker")
const ImpersonationObject = require("./ImpersonationObject")
const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
let varDesc;

/**
 * Home links class
 */
class DewImpersonation {
  
/**
 * navigate to allow Impersonation
 */
  navigateToAllowImpersonation() {
    I.wait(10);
    I.scrollIntoView(ImpersonationObject.ProfileIcon);
    I.waitForVisible(ImpersonationObject.ProfileIcon,20);
    I.seeElement(ImpersonationObject.ProfileIcon);   
    CommonKeyword.clickElement(ImpersonationObject.ProfileIcon);
    I.waitForVisible(ImpersonationObject.AllowImpersonationProfileOption,20);
    CommonKeyword.clickElement(ImpersonationObject.AllowImpersonationProfileOption);
    I.waitForVisible(ImpersonationObject.ImpersonationPagetitle,20);
    I.seeElement(ImpersonationObject.ImpersonationPagetitle);
  }
  /**
   * Impersonation function
   * @param {*} radioBtnLabel
   */
  

  async authorizeImpersonation(radioBtnLabel) {
    varDesc="Auto Description-"+generateRandomNumber();
    this.navigateToAllowImpersonation();
    CommonKeyword.clickElement(ImpersonationObject.AuthorizeImpersonationTab);
    I.seeElement(ImpersonationObject.AuthorizeTabVerification);
    DewRadioButton.selectRadioButton(radioBtnLabel);
    I.wait(2);
    DatePicker.selectInNextMonth(ImpersonationObject.AuthorizeDate);
    I.fillField(ImpersonationObject.AuthorizeDescription,varDesc);
    //TextAreaWithPlaceholder.enterText("Enter description","AutoDescription"+generateRandomNumber());
    //textarea[@formcontrolname='description']
    CommonKeyword.clickElement(ImpersonationObject.AuthorizeSave);
   
  }

  async createImpersonation(radioBtnLabel){
    varDesc="Auto Description"+generateRandomNumber();
    //CommonKeyword.clickElement(ImpersonationObject.AuthorizeImpersonationTab);
    I.seeElement(ImpersonationObject.AuthorizeTabVerification);
    DewRadioButton.selectRadioButton(radioBtnLabel);
    I.wait(2);
    DatePicker.selectInNextMonth(ImpersonationObject.AuthorizeDate);
    I.fillField(ImpersonationObject.AuthorizeDescription,varDesc);
    //TextAreaWithPlaceholder.enterText("Enter description","AutoDescription"+generateRandomNumber());
    //textarea[@formcontrolname='description']
    CommonKeyword.clickElement(ImpersonationObject.AuthorizeSave);
  }
}

module.exports = new DewImpersonation();
module.exports.DewImpersonation = DewImpersonation;

function generateRandomNumber() {
    return Math.floor(Math.random() * 9000);
  } 
