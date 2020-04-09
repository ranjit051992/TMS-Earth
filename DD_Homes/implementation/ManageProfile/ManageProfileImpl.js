/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const ManageProfileObject = require("./ManageProfileObject")
const Element = require("dd-cc-zycus-automation/components/element")

/** 
 * Profile related class
 */
class ManageProfile {
 /**
   * To navigate to manage Profile
   */

   async navigateToManageProfile() {
     I.wait(5);
    I.seeElement(ManageProfileObject.Profile);
    await CommonKeyword.clickElement(ManageProfileObject.Profile);
    await CommonKeyword.clickElement(ManageProfileObject.ClickDropdownProfile);
    await I.seeElement(ManageProfileObject.UserProfile);
    I.click(ManageProfileObject.UserDetails);
  }
  /**
   * To upload profile picture
   */
  async uploadProfilePicture() {
    await CommonKeyword.clickElement(ManageProfileObject.UploadPicture);
    I.see(ManageProfileObject.VerifyUploadImage);
    within(".modal-content", async () => {
      await I.attachFile(ManageProfileObject.UploadInput,"./Resources/branch300.jpg");
      await CommonKeyword.clickElement(ManageProfileObject.SetProfilePhoto);
    });
    await I.dontSeeElement(ManageProfileObject.ModalContent)
  }

  /**
   * To verify if profile picture is updated
   */

  async verifyUploadedProfilePicture(){
    await I.seeElement(ManageProfileObject.VerifyUploadedPicture);
  }
  /**
   * To reset profile picture
   */
  async resetProfilePicture() {

    let locator = ManageProfileObject.ResetProfilePicture;
    await I.scrollIntoView(locator,{ behavior: "smooth", block: "center", inline: "center" });
    await I.waitForVisible(locator, "10")
    await I.seeElement(locator)
    I.click(locator)
    I.seeElement(ManageProfileObject.VerifyResetPicture);
  }
  /**
   * To change password
   */
  async changePassword() {
    this.navigateToManageProfile();
    await CommonKeyword.clickElement(ManageProfileObject.ChangePassword);

    await CommonKeyword.enterText(ManageProfileObject.CurrentPassowrdLabel, "YoDeHaCoPoBiBaIoAiWiYeQe8&7");
    await CommonKeyword.enterText(ManageProfileObject.NewPassowrdLabel, "YoDeHaCoPoBiBaIoAiWiYeQe8&71");
    await CommonKeyword.enterText(ManageProfileObject.ConfirmNewPassowrdLabel, "YoDeHaCoPoBiBaIoAiWiYeQe8&71");
    await CommonKeyword.clickElement(ManageProfileObject.PasswordSaveBtn);    
  }

/**
   * To verify if password is updated
   */
  async verifyIfPasswordUpdated(){
    await I.see(ManageProfileObject.PasswordUpdatedLabel);
  }

  /**
   * To change pin
   */
  async changePin() {
    await CommonKeyword.clickElement(ManageProfileObject.ChangePin);
    console.log("Qw"+generateRandomNumber())
    let pin= "Qw"+generateRandomNumber();
    await CommonKeyword.enterText(ManageProfileObject.NewPinLabel, pin);
    await CommonKeyword.enterText(ManageProfileObject.ConfirmPinLabel, pin);
    await CommonKeyword.clickElement(ManageProfileObject.PasswordSaveBtn);
  }


/**
   * To verify if pin is updated
   */
  verifyIfPinUpdated(){
    I.see(ManageProfileObject.PinUpdatedLabel);
  }
}

module.exports = new ManageProfile();
module.exports.ManageProfile = ManageProfile; // for inheritance
/**
 * To navigate to manage profile
 */
function navigateToManageProfile() {
  I.seeElement(ManageProfileObject.Profile);
  CommonKeyword.clickElement(ManageProfileObject.Profile);
  CommonKeyword.clickElement(ManageProfileObject.ClickDropdownProfile);
  I.seeElement(ManageProfileObject.UserProfile);
  I.click(ManageProfileObject.UserDetails);
}

function generateRandomNumber() {
  return Math.floor(1000+ Math.random() * 9000);
}

