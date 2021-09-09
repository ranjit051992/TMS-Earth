const { I } = inject();
import { Common } from "../../Common/Common";
import { z } from "actionbot-wrapper/z";
import { Login_TMSObj } from "../../POM/login/Login_TMSObj";
//import prop = global.confi_prop;
import { logger} from "../../../Framework/FrameworkUtilities/Logger/logger";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { prop } from "../../../Framework/FrameworkUtilities/config";
import {​​​​​​​​ ProductNavigator }​​​​​​​​  from"dd-cc-zycus-automation/dist/components/dewSideMenu";

import { LoginImpl } from "../../POM/login/LoginImpl";
import { CreateUserObj } from "../../POM/Users/CreateUserObj";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import { CreateRoleImpl } from "../../POM/Role/CreateRoleImpl";
import { CreateRoleObj } from "../../POM/Role/CreateRoleObj";

Given("I logged in TMS with user role {string}", async function (userRole: string) {
        await LoginImpl.login(userRole);    
});

Given("I logged in TMS for Specific user role {string}", async function (SpecuserRole: string) {
        await LoginImpl.Specificlogin(SpecuserRole);    
});

Given("I logged in SSO TMS with OTP enabled User", async function () {
        await LoginImpl.loginwithOTPenablessouser();
});

Given("I logged in DSSO TMS with OTP enabled User", async function () {
        await LoginImpl.loginwithOTPenabledssouser();
});

Given("Verify the OTP of the user", async function () {
        await LoginImpl.VerifyloginwithOTPenableuser();
});

Given("Check by entering invalid OTP", async function () {
        await LoginImpl.VerifyloginwithInvalidOTP();
});

Given("Check with Resend OTP option", async function () {
        await LoginImpl.VerifyloginwithResendOTP();
});

Given ("Navigate to Company Listing",async function(){
        await LoginImpl.NavigateToCompanyListing();
});
Given ("Navigate to TMS Page {string} {string}",async function(menu1: string,menu2: string){
        console.log(menu1+"    ========>   "+menu2)
        await ProductNavigator.navigate(menu1,menu2);
        await z.switchToNextTab();
});

Given ("Navigate to User Listing {string} {string}",async function(menu1: string,menu2: string){
        console.log(menu1+"    ========>   "+menu2)
        await ProductNavigator.navigate(menu1,menu2);
        await z.switchToNextTab();
        await z.waitForVisible(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
});

Given ("Check Access of User Management Activity",async function(){
        await z.dontSee(await TMSLmt.getData("Preference"));
        await z.dontSee(await TMSLmt.getData("Reports"));
        await z.dontSee(await TMSLmt.getData("RoleManagement"));
        await z.dontSee(await TMSLmt.getData("AuditTrail"));
        await z.dontSee(await TMSLmt.getData("MasterData"));
        await z.dontSee(await TMSLmt.getData("Workflow"));
        await z.see(await TMSLmt.getData("UserGroups"));
        await z.see(await TMSLmt.getData("UserManagement"));
        await z.dontSee(await TMSLmt.getData("ImpersonateUserRequests"));
        await z.waitForVisible(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
});

Given ("Check Access of User and Role Activity",async function(){
        await z.dontSee(await TMSLmt.getData("Preference"));
        await z.dontSee(await TMSLmt.getData("Reports"));
        await z.see(await TMSLmt.getData("RoleManagement"));
        await z.dontSee(await TMSLmt.getData("AuditTrail"));
        await z.dontSee(await TMSLmt.getData("MasterData"));
        await z.dontSee(await TMSLmt.getData("Workflow"));
        await z.see(await TMSLmt.getData("UserGroups"));
        await z.see(await TMSLmt.getData("UserManagement"));
        await z.dontSee(await TMSLmt.getData("ImpersonateUserRequests"));
        await z.waitForVisible(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
        await CreateRoleImpl.NavigateTo(await TMSLmt.getElement(CreateRoleObj.RoleManagementTab));
        await z.see(await TMSLmt.getData("Add_new_role"));
});

Given ("Adding TMS in quick link",async function(){
        await LoginImpl.addingquicklink();
});

Given ("Check TMS added in quick link",async function(){
        await LoginImpl.checkingquicklinkadded();
});

Given ("Remove TMS from quick link",async function(){
        await LoginImpl.removingquicklinkadded();
});

Given ("Dewdrop Logout", async function() {
        await LoginImpl.DewdropsLogout();
});
Given ("User Logout From Classic TMS",async function(){
        await LoginImpl.ClassicLogout();
});   

//Given ("Navigate to User Listing",async function(){
  //      await LoginImpl.NavigateToUserListing();

 /* Then("User should view OTP Page", async function(){
        let username = await TMSLmt.getData("OTP_SSO_USER")as string
        console.log(username+" -=-=-==->   ")
    let user: string = await z.grabTextFrom(await TMSLmt.getElement(Authentication_Obj.Verify_Username));
    
    await z.assertEqual(username,user);
    });
    
    Then("DSSO User should view OTP Page", async function(){
        let username = await TMSLmt.getData("OTP_DSSO_USER")as string
        console.log(username+" -=-=-==->   ")
    let user: string = await z.grabTextFrom(await TMSLmt.getElement(Authentication_Obj.Verify_Username));
    
    await z.assertEqual(username,user);
    });
    
    When("User entered incorrect OTP", async function(){
    
        await z.fillField(await TMSLmt.getElement(Authentication_Obj.OTP_Field),'5241582');
    
        await z.click(await TMSLmt.getElement(Authentication_Obj.Submit));
    
    });
    
    Then("User should get warning message", async function(){
    
       let warning: string = await z.grabTextFrom(await TMSLmt.getElement(Authentication_Obj.Warrning));
       console.log("warning message    "+warning);
        await z.seeElement(await TMSLmt.getElement(Authentication_Obj.Warrning));
    });
    
    Given("an OTP is already sent", async function(){
    
        let otpsent: string = await z.grabTextFrom(await TMSLmt.getElement(Authentication_Obj.OTP_SentMSG));
        console.log("OTP sent message    "+otpsent);
        await z.seeElement(await TMSLmt.getElement(Authentication_Obj.OTP_SentMSG));
    
    });
    
    Given("1 min has not elapsed", async function(){
        let timer: string = await z.grabTextFrom(await TMSLmt.getElement(Authentication_Obj.Timer));
        console.log("timer countdown sent message    "+timer);
        await z.seeElement(await TMSLmt.getElement(Authentication_Obj.Timer));
    
    });
    
    Then("the Resend OTP button should be disabled", async function(){
        //await EmailTest_NewImpl_DD_Home.readEmail(prop.Username, prop.Password, ['SUBJECT'], [Startup.testData.get("EmailSubjectSharedReport")as string], "Inbox", 60000);
       // await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_MEDIUM_WAIT);
        //console.log("------>>  "+await EmailTest_NewImpl_DD_Home.readEmail(prop.Username, prop.Password, ['SUBJECT'], [Startup.testData.get("EmailSubjectSharedReport")as string], "Inbox", 60000))
        await z.seeElement(await TMSLmt.getElement(Authentication_Obj.Disable_Resend_Button));
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        let timer: string = await z.grabTextFrom(await TMSLmt.getElement(Authentication_Obj.Timer));
        console.log("timer countdown sent message    "+timer);
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        await z.dontSee(await TMSLmt.getElement(Authentication_Obj.Disable_Resend_Button));
        
    }) */