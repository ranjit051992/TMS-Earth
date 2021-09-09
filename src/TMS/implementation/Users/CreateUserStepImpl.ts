const { I } = inject();
//const assert = require("assert");
import { Common } from "../../Common/Common";
import { CreateUserObj } from "../../POM/Users/CreateUserObj";
import { CreateUserImpl } from "../../POM/Users/CreateUserImpl";
//import { assert } from "../../../../node_modules/";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";
import { lchown } from "fs";
//Copy User User email
var Email = Common.getRandomNumber(8) + "@gmail.com";

Given("User on Create User Page", async function () {
    await CreateUserImpl.NavigateToUserAddPage();
});
When("I Fill all the data and Create User 1", async function () {
    await CreateUserImpl.EnterBasicDetailsUser();
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
});

When("I Fill all the data for role page check on Create User 1", async function () {
    await CreateUserImpl.EnterBasicDetailsUserwithminimumdata();
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
});

When("I Fill all the data for scope page check on Create User 1", async function () {
    await CreateUserImpl.EnterBasicDetailsUserwithminimumdata();
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
});

When("I Fill all the data and Create User 2", async function () {
    await CreateUserImpl.selectProduct();
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
});

When("I Fill all the data and Create User 3", async function () {
    await CreateUserImpl.selectRoles();
});

When("I Fill all the data and Create User 4", async function () {
    await CreateUserImpl.selectscope();
});

When("I Fill all the data and Create User 5", async function () {
    await CreateUserImpl.selectUserPreference();
});


When("Define User", async function () {
    await CreateUserImpl.defineUser();
});


Then("Popup should be seen", async function () {
    await CreateUserImpl.popupSuccessUser();
});

Then("Verify Update user details1", async function () {
    await CreateUserImpl.VerifyUpdateuserdetails1();
});

Then("Verify Update user details2", async function () {
    await CreateUserImpl.VerifyUpdateuserdetails2();
});

Then("Verify Update user details3", async function () {
    await CreateUserImpl.VerifyUpdateuserdetails3();
});

Then("Verify Update user details4", async function () {
    await CreateUserImpl.VerifyUpdateuserdetails4();
});

Then("Verify Update user details5", async function () {
    await CreateUserImpl.VerifyUpdateuserdetails5();
});

Then("User is shown on User Listing Page", async function () {
    await CreateUserImpl.Usersearcheble();
});

Then("Verify Data intrgration of Create User 1", async function () {
    await CreateUserImpl.UserCreateBasicDetailsDI1();
});

Then("Verify Data intrgration of Create User 2", async function () {
    await CreateUserImpl.UserCreateBasicDetailsDI2();
});

Then("Verify Data intrgration of Create User 3", async function () {
    await CreateUserImpl.UserCreateBasicDetailsDI3();
});

Then("Verify Data intrgration of Create User 4", async function () {
    await CreateUserImpl.UserCreateBasicDetailsDI4();
});

Then("Verify Data intrgration of Create User 5", async function () {
    await CreateUserImpl.UserCreateBasicDetailsDI5();
});


Then("Mark User Inactive", async function () {
    await CreateUserImpl.markUserInactive();
});

When("I deactivate User", async function () {
    await CreateUserImpl.deactivateuser();
});

When("Deactivate User with user mgm activity", async function () {
    await CreateUserImpl.deactivateuserusermgmact();
});

Then("User should get deactivate", async function () {
    await CreateUserImpl.deactivateusercheck();
    
});

When("I activate User", async function () {
    await CreateUserImpl.activateuser();
    
});

When("Activate User with user mgm activity", async function () {
    await CreateUserImpl.Activateuserusermgmact();
    
});

Then("User should get activate", async function () {
    await CreateUserImpl.activateusercheck();
    
});

Then("Activation Email should get trigger to User", async function () {
    await CreateUserImpl.activateusermailcheck();
    
});

When("Reset User Password", async function () {
    await CreateUserImpl.resetPassword();
});

When("Reset UserPassword with user mgm activity", async function () {
    await CreateUserImpl.UserMgmActresetPassword();
});

Then("Verify User Password", async function () {
    await CreateUserImpl.resetPasswordcheck();
    
});

When("I Edited the Email Address", async function () {
    await CreateUserImpl.emailEdit();
    
});

Then("Verify the Edited Email address", async function () {
    await CreateUserImpl.emailEditVerify();
    
});

When("I click on CopyUser", async function () {
    await CreateUserImpl.NavigateCopyUser();
});

When("I enter the details", async function () {
    await CreateUserImpl.CopyUserFillDetails();
});

When("I click on submit button", async function () {
    await z.click(await TMSLmt.getElement(CreateUserObj.SubmitBtn));
    await z.click(await TMSLmt.getElement(CreateUserObj.DefineBtn));
});

Then("New User should be created", async function () {
    await CreateUserImpl.CopyUserConfirm();
    
});

//Edit Users 
Given("Go to the Edit User Summary Page", async function () {
    await CreateUserImpl.EditUserPageSummary(Email);
});
When("UpdateUser Basic Details1", async function () {
    await CreateUserImpl.UpdateUserBasicDetails1();
});

When("UpdateUser Basic Details of user", async function () {
    await CreateUserImpl.UpdateUserMgmactdetail();
});

When("UpdateUser Basic Details2", async function () {
    await CreateUserImpl.UpdateUserBasicDetails2();
});

When("UpdateUser Basic Details3", async function () {
    await CreateUserImpl.UpdateUserBasicDetails3();
});

When("UpdateUser Basic Details4", async function () {
    await CreateUserImpl.UpdateUserBasicDetails4();
});

When("UpdateUser Basic Details5", async function () {
    await Wait.waitForDefaultTimeout(prop.DEFAULT_MEDIUM_WAIT);
    await CreateUserImpl.UpdateUserBasicDetails5();
});

When("Update User", async function () {
    await CreateUserImpl.updateUser();
});
//Popup is used


//For Audits
Then("deactivated record should be visible in audit", async function () {
	await z.see(await TMSLmt.getData("EmailActivateDeactivate"));
});

Then("Activated record should be visible in audit", async function () {
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
	await z.see(await TMSLmt.getData("EmailActivateDeactivate"));
});

Then("I should see records of user updated in audit", async function () {
	await z.see(await TMSLmt.getData("Display_name_updated"));
});

Then("ResetUserPassword record should be visible in audit",async function ()  {
	await z.see(await TMSLmt.getData("EmailActivateDeactivate"));
});
//L2
When("User able to fill data on page 1", async function () {
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_displayName), await TMSLmt.getData("Value_displayName"));
});
Then("Data should be seen on page 1", async function () {
    await CreateUserImpl.DatacheckPage1();
});

When("User able to fill Master Data", async function () {
    await CreateUserImpl.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_level1_Locator), await TMSLmt.getData("Org_level1_Value"));
    await CreateUserImpl.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_level2_Locator), await TMSLmt.getData("Org_level2_Value"));
});

Then("Master data should be seen on page 1", async function () {
    await CreateUserImpl.MasterDatacheckPage1();
});

When("Try to Navigate to Page 2", async function () {
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
});
Then("Proper Error should be seen on page 1", async function () {
    await z.see(await TMSLmt.getData("Mandatory_text1"));
});
Then("All product should be seen", async function () {
    await CreateUserImpl.CompanyAllProductSeen();
});

Then("Product Should get assign and unassigned", async function () {
    await CreateUserImpl.selectProduct();
    await CreateUserImpl.checkAssignedProduct();
    
});

Then("User lands on step 3 page role page", async function () {
    //await z.seeTitleEquals("Create New User - Step 3");
    //await z.see("Assign Roles");
    await z.seeTitleEquals(await TMSLmt.getData("User_Step3_page"));
    await z.see(await TMSLmt.getData("Role_assign_page"));
});

Then("Role should be seen for all product", async function () {
    await CreateUserImpl.RoleList();
    
});

Then("Role should be assigned or unassigned", async function () {
    await CreateUserImpl.RoleAssignedcheck();
});

Then("Error should be shown Multiple same scope type is assigned", async function () {
    await CreateUserImpl.MulitpleScopeAssignedError();
    
});

Then("Assign Multiple Scope to Users", async function () {
    await CreateUserImpl.ScopeAssignCheck();
    
});

Then("Search on User Listing Page by Full Name", async function () {
    await CreateUserImpl.Searchuserwithfullname();
    
});

Then("Verify user search result", async function () {
    await CreateUserImpl.Verifyuserwithfullname();
    
});

Then("Search on User Listing Page by CaseSensetive Full Name", async function () {
    await CreateUserImpl.Searchuserwithcasesensativename();
    
});

Then("Search on User Listing Page by Partial Full Name", async function () {
    await CreateUserImpl.Searchuserwithpartailname();
    
});
