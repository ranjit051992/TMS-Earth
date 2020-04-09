module.exports = {
    WelcomeMessage:"//span[contains(@class,'welcome-message')]",
    Profile:"//dew-dropdown[contains(@class,'profile')]",
    ClickDropdownProfile:"//div[contains(@class,'dropdown-item') and text()[normalize-space()='Manage Profile']]",
    UserProfile:"//user-profile",
    UserDetails:"User Details",
    ModalContent:".modal-content",
    UploadPicture:"//button[@aria-label='Upload']",
    VerifyUploadImage:"Upload Image",
    UploadInput:"//div[@class='upload-btn-wrapper']/input",
    SetProfilePhoto:"//button[@aria-label='Set Profile Photo']",
    VerifyUploadedPicture:"//img[@class='media-object' and contains(@src,'base64')]",
    ResetProfilePicture:"//button[@aria-label='Reset Profile Picture']",
    VerifyResetPicture:"//button[@aria-label='Reset Profile Picture' and @disabled]",

    ChangePassword:"//button[@aria-label='Change Password']",
    CurrentPassowrdLabel:"Current Password",
    NewPassowrdLabel:"New Password",
    ConfirmNewPassowrdLabel:"Confirm New Password]",
    PasswordSaveBtn:"//dew-modal-footer//button[@aria-label='Save' and not(@disabled)]",
    PasswordUpdatedLabel:"Password Updated",

    ChangePin:"//button[@aria-label='Change Pin']",
    NewPinLabel:"New Pin",
    ConfirmPinLabel:"Confirm Pin",
    PinUpdatedLabel:"Pin Updated"


  
}