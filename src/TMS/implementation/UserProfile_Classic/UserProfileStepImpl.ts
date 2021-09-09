const { I } = inject();
import { Common } from "../../Common/Common";
//import { UserProfileImpl } from "./UserProfileImpl";
import { UserProfileObj } from "../../POM/UserProfile_Classic/UserProfileObj";
import { z } from "actionbot-wrapper/z";
import { UserProfileImpl } from "../../POM/UserProfile_Classic/UserProfileImpl";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
let searchWindow;

Given ("Navigate to User Profile Page", async function() {  
    await UserProfileImpl.NavigateToUserProfilePage();
});

Then ("User Lands on User Profile Page", async function() {
   await UserProfileImpl.UserCheckProfilePage();
});

When ("Update Profile file", async function() {
   await UserProfileImpl.UploadProfilepic();
});

When ("Update User Details On profile", async function() {
   await UserProfileImpl.UpdateUserProfile();
});

Then("User Profile data Should be saved", async function() {
   //await z.seeTitleEquals("List of Users");
   await z.seeTitleEquals(await TMSLmt.getData("List_of_Users"));
});