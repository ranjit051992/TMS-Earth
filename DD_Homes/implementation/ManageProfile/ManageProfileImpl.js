/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")

/** 
 * Profile related class
 */
class ManageProfile {
 /**
   * To navigate to manage Profile
   */

   navigateToManageProfile() {
     I.wait(5);
    I.seeElement("//dew-dropdown[contains(@class,'profile')]");
    CommonKeyword.clickElement("//dew-dropdown[contains(@class,'profile')]");
    CommonKeyword.clickElement("//div[contains(@class,'dropdown-item') and text()[normalize-space()='Manage Profile']]");
    I.seeElement("//user-profile");
    I.click("User Details");
  }
  /**
   * To upload profile picture
   */
  uploadProfilePicture() {
    CommonKeyword.clickElement("//button[@aria-label='Upload']");
    I.see("Upload Image");
    within(".modal-content", () => {
      I.attachFile("//div[@class='upload-btn-wrapper']/input","./Resources/branch300.jpg");
      CommonKeyword.clickElement("//button[@aria-label='Set Profile Photo']");
    });
    I.dontSeeElement(".modal-content")
  }

  /**
   * To verify if profile picture is updated
   */

  verifyUploadedProfilePicture(){
    I.seeElement("//img[@class='media-object' and contains(@src,'base64')]");
  }
  /**
   * To reset profile picture
   */
  resetProfilePicture() {

    let locator = "//button[@aria-label='Reset Profile Picture']";
    I.scrollIntoView(locator,{ behavior: "smooth", block: "center", inline: "center" });
    I.waitForVisible(locator, "10")
    I.seeElement(locator)
    I.click(locator)
    I.seeElement("//button[@aria-label='Reset Profile Picture' and @disabled]");
  }
  /**
   * To change password
   */
  changePassword() {
    this.navigateToManageProfile();
    CommonKeyword.clickElement("//button[@aria-label='Change Password']");

    CommonKeyword.enterText("Current Password", "YoDeHaCoPoBiBaIoAiWiYeQe8&7");
    CommonKeyword.enterText("New Password", "YoDeHaCoPoBiBaIoAiWiYeQe8&71");
    CommonKeyword.enterText("Confirm New Password]", "YoDeHaCoPoBiBaIoAiWiYeQe8&71");
    CommonKeyword.clickElement("//dew-modal-footer//button[@aria-label='Save' and not(@disabled)]");
    
  }

/**
   * To verify if password is updated
   */
  verifyIfPasswordUpdated(){
    I.see("Password Updated");
  }

  /**
   * To change pin
   */
  changePin() {
    CommonKeyword.clickElement("//button[@aria-label='Change Pin']");
    console.log("Qw"+generateRandomNumber())
    let pin= "Qw"+generateRandomNumber();
    CommonKeyword.enterText("New Pin", pin);
    CommonKeyword.enterText("Confirm Pin", pin);
    CommonKeyword.clickElement("//dew-modal-footer//button[@aria-label='Save' and not(@disabled)]");
  }


/**
   * To verify if pin is updated
   */
  verifyIfPinUpdated(){
    I.see("Pin Updated");
  }
}

module.exports = new ManageProfile();
module.exports.ManageProfile = ManageProfile; // for inheritance
/**
 * To navigate to manage profile
 */
function navigateToManageProfile() {
  I.seeElement("//dew-dropdown[contains(@class,'profile')]");
  CommonKeyword.clickElement("//dew-dropdown[contains(@class,'profile')]");
  CommonKeyword.clickElement("//div[contains(@class,'dropdown-item') and text()[normalize-space()='Manage Profile']]");
  I.seeElement("//user-profile");
  I.click("User Details");
}

function generateRandomNumber() {
  return Math.floor(1000+ Math.random() * 9000);
}

