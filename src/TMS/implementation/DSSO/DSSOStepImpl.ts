const { I } = inject();
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
import { DSSOImpl } from "../../POM/DSSO/DSSOImpl";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";

Given ("User hits IDP DSSO Login ADFS Link", async function() {
     await z.amOnPage(await TMSLmt.getData("ADFSDSSOURL"));
     await z.resizeWindow("maximize");
});

Given ("User hits SP DSSO Login Okta Link", async function() {
     await z.amOnPage(await TMSLmt.getData("OktaDSSOURL"));
     await z.resizeWindow("maximize");
});

Given ("User hits DSSO Octa Irequest link", async function() {
     await z.amOnPage(await TMSLmt.getData("OktaIrequestDSSOURL"));
     await z.resizeWindow("maximize");
});

Given ("User hits DSSO ADFS Irequest link", async function() {
     await z.amOnPage(await TMSLmt.getData("ADFSIrequestDSSOURL"));
     await z.resizeWindow("maximize");
});

Given ("User hits PurelyIDP link", async function() {
     await z.amOnPage(await TMSLmt.getData("ADFSPurelyIDPDSSOURL"));
     await z.resizeWindow("maximize");
});

Given ("User hits ADFS1iRequestLoginSuccess DSSO Link", async function() {
     await z.amOnPage(await TMSLmt.getData("ADFS1iRequestLoginSuccess"));
     await z.resizeWindow("maximize");
});

Then ("User Redirect to ADFS Login Page", async function() {
     await z.see("Zycus ADFS");
     await z.seeInCurrentUrl("adfs.zycus.com");
});

Then ("Login thorugh ADFS creds {string}", async function(ADFSUserType: string) {
    await DSSOImpl.DSSOADFSlogin(ADFSUserType);
});

Then ("User Redirect to okta Login Page", async function() {
    await z.see("Okta");
    await z.seeInCurrentUrl("zycus.oktapreview.com");
});

Then ("Login thorugh Octa creds {string}", async function(OctaUserType: string) {
    await DSSOImpl.DSSOOctalogin(OctaUserType);
});

When("Login thorugh ADFS {string},{string} creds", async function(Email,Password) {
    await DSSOImpl.LoginThroughADFS(Email,Password);
});

When("Login thorugh okta {string},{string} creds", async function(Email,Password) {
    await DSSOImpl.LoginThroughOkta(Email,Password);
});

Then ("Dewdrop Login Successful", async function() {
     await z.seeInCurrentUrl(await TMSLmt.getData("DDSOUrlInitial"));
     await z.seeElement("dew-navbar");
});



When("Concurrent okta login {string},{string},{string} creds", async function(Email,Password,URL) {
    await DSSOImpl.LoginThroughOkta(Email,Password);
    let flag=true;
    do{
        let Count= await z.grabNumberOfVisibleElements("//span[@class='message']");
        logger.info("Printing ......."+Count);
          if(Count == 0)
          { 
            await z.clearCookie('SAAS_COMMON_BASE_TOKEN_ID');
            await z.amOnPage((URL = await TMSLmt.getData("OktaDSSOURL")));
            await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
          }
          else 
          flag=false;
    }while(flag);
}); 

Then ("zAuth Error Page shown User {string} not Found", async function(Email) {
    await z.see("User not found with loginId "+(Email = await TMSLmt.getData("DSSOOctaUser2_email")));
    //await z.see("User not found with loginId "+Email);
    await z.see("Error Code: NR-TMS-C-AUTH018");
});

Then ("User should be able to view concurrent login page", async function() {
    await z.see("Concurrent Login Locations");
    await z.see("You are already logged in from maximum permissible locations shown below. Please logout from the locations you do not require to proceed into the application.");
    await z.see("Source IP");
    await z.see("Logout");
});

Then ("User able to login after clicking on logout link", async function() {
    await z.click("//span[text()='Logout']");
    
});

Then ("zAuth Error Page shown User {string} inactive", async function(Email) {
    await z.see("User with email address "+(Email = await TMSLmt.getData("DSSOOctaUser3_email"))+" is not active");
    await z.see("Error Code: NR-TMS-C-AUTH005");
});

Then ("zAuth ADFS Error Page shown User {string} not Found", async function(Email) {
    await z.see("User not found with loginId "+(Email = await TMSLmt.getData("DSSOADFSUser2_email")));
    //await z.see("User not found with loginId "+Email);
    await z.see("Error Code: NR-TMS-C-AUTH018");
});

Then ("zAuth ADFS Error Page shown User {string} inactive", async function(Email) {
    await z.see("User with email address "+(Email = await TMSLmt.getData("DSSOADFSUser3_email"))+" is not active");
    await z.see("Error Code: NR-TMS-C-AUTH005");
});

Then ("zAuth Error Page shown User {string} Exceed Concurrent", async function(Email) {
    await z.see("Cannot login as you are already logged in from maximum permitted locations. "+(Email = await TMSLmt.getData("DSSOOctaUser4_email")));
    await z.see("Error Code: NR-TMS-C-AUTH014");
});

Then ("SetupBridge Common Error Page", async function() {
    await z.see("User is Inactive in TMS or User is not present in TMS. Please contact Zycus for assistance.");
});

Then ("Verify zAuth Logout Page", async function() {
    await z.see("Successfully Logged Out of Zycus Portal");
    await z.see("Kindly close the window and reopen it, in order to login to Zycus Portal");
});

Then ("Verify SetupBridge Logout Page", async function() {
    await z.see("Successfully logout out of TMS. Please close the browser");
});