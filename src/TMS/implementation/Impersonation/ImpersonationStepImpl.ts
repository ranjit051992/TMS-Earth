const { I } = inject();

import { ImpersonationObj } from "../../POM/Impersonation/ImpersonationObj";
import { ImpersonationImpl } from "../../POM/Impersonation/ImpersonationImpl";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

//let varDesc=Common.getRandomNumber(8);

When("Navigate to Impersonation Page", async function () {
	await z.click(await TMSLmt.getElement(ImpersonationObj.ImpersonationTab));
});

Then("Impersonation page should be accessible", async function () {
    await ImpersonationImpl.VerifyUserOnAcceptImpersonationPage();
});
    
When("I Select Allow impersonate from user profile", async function () {
    await ImpersonationImpl.NavigatetoMyProfileImpersonatePage();
});

When("I select allow company admin to impersonate me", async function () {
    await ImpersonationImpl.GiveImpersonateAccessToCA();
});

When("I accept the impersonate request", async function () {
    await ImpersonationImpl.AcceptImpersonateRequestAsCA();
});

Then("I should be login as Impersonate User", async function () {
    await ImpersonationImpl.VerifyImpersonate_As_UserLogin();
});

Then("Remove impersonate request", async function() {
    await ImpersonationImpl.revokeimpersonaterequest();
});