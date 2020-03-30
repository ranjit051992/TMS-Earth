module.exports = {
    ProfileIcon: "//dew-dropdown[contains(@class,'profile')]",
    AllowImpersonationProfileOption: "//div[contains(@class,'dropdown-item') and text()[normalize-space()='Allow Impersonation']]",
    ImpersonationPagetitle:"//h1[@title='Manage your Impersonation Authorizations']",
    AuthorizeImpersonationTab:"//a[contains(@class,'nav-link')]/*[text()[normalize-space()='Authorize Impersonation']]",
    AuthorizeTabVerification:"//a[contains(@class,'nav-link active')]/*[text()[normalize-space()='Authorize Impersonation']]",
    AuthorizeDate:"//div[contains(@class,'pickerDiv')]/input[@aria-label='date']",
    AuthorizeDescription:"//textarea[@formcontrolname='description']",
    AuthorizeSave:"//button[@aria-label='Save']",

    SuccessAlert:"//div[contains(@class,'alert-panel')]/img[@alt='icon-success']",
    SuccessDoneBtn:"//div[contains(@class,'alert-panel')]//button[@aria-label='Done']",

    ImpersonationHeaderTab:"View Impersonation Requests",
    RevokeAndCreateBtn:"(//span[@title='Revoke & Create New'])[1]",
    CompanyAdminImpersonate:"//label[text()='Allow Company admin to impersonate me']",
    RevokeBtn:"(//span[@title='Revoke'])[1]",

    RevokedStatus:"(//span[@title='Revoked'])[1]",
    VerifyUserAtAuthorizationTab:"//a[dew-default-tab-head[text()[normalize-space()='Authorize Impersonation']] and contains(@class,'active')]"



    
  
}