/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
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
    I.click("//dew-dropdown[contains(@class,'profile')]");
    I.click("//div[contains(@class,'dropdown-item') and text()[normalize-space()='Manage Profile']]");
    I.seeElement("//user-profile");
    I.click("User Details");
  }
  /**
   * To upload profile picture
   */
  uploadProfilePicture() {
    I.click("//button[@aria-label='Upload']");
    I.see("Upload Image");
    within(".modal-content", () => {
      I.attachFile("//div[@class='upload-btn-wrapper']/input","./Resources/branch300.jpg");
      I.click("//button[@aria-label='Set Profile Photo']");
    });
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
    I.click("//button[@aria-label='Reset Profile Picture']");
    I.seeElement("//button[@aria-label='Reset Profile Picture' and @disabled]");
  }
  /**
   * To change password
   */
  changePassword() {
    this.navigateToManageProfile();
    I.click("//button[@aria-label='Change Password']");

    I.fillField("//input[@formcontrolname='currentPassword']", "YoDeHaCoPoBiBaIoAiWiYeQe8&7");
    I.fillField("//input[@formcontrolname='newPassword']", "YoDeHaCoPoBiBaIoAiWiYeQe8&71");
    I.fillField("//input[@formcontrolname='confirmPassword']", "YoDeHaCoPoBiBaIoAiWiYeQe8&71");
    I.click("//dew-modal-footer//button[@aria-label='Save' and not(@disabled)]");
    
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
    I.click("//button[@aria-label='Change Pin']");
    console.log("Qw"+generateRandomNumber())
    let pin= "Qw"+generateRandomNumber();
    I.fillField("//input[@formcontrolname='newMobilePin']", pin);
    I.fillField("//input[@formcontrolname='confirmMobilePin']", pin);
    I.click("//dew-modal-footer//button[@aria-label='Save' and not(@disabled)]");
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
  I.click("//dew-dropdown[contains(@class,'profile')]");
  I.click("//div[contains(@class,'dropdown-item') and text()[normalize-space()='Manage Profile']]");
  I.seeElement("//user-profile");
  I.click("User Details");
}

function generateRandomNumber() {
  return Math.floor(Math.random() * 9000);
}

