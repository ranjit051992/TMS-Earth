const { I } = inject();

import { Common } from "../../Common/Common";
import { SecurityObj } from "../../POM/Settings/SecurityObj";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { DisplayObj } from "../../POM/Settings/DisplayObj";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";

Given ("Navigate to Security Policy Page", async function() {  
    await z.click(await TMSLmt.getElement(SecurityObj.PreferenceTab));
    //await z.see("You are here: Company Preferences > Security Policy");
    await z.see(await TMSLmt.getData("Security_Policy_page"));
});

When ("Changes Security Policy",async function(){
    await z.selectOption(await TMSLmt.getElement(SecurityObj.No_password_hisory_Locator),await TMSLmt.getData("No_password_hisory_Value"));
    await z.selectOption(await TMSLmt.getElement(SecurityObj.View_no_login_Locator),await TMSLmt.getData("View_no_login_Value")); 
});

When ("Check Access of Preferences Activity",async function(){
    await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
    await z.dontSee(await TMSLmt.getData("Reports"));
    await z.dontSee(await TMSLmt.getData("RoleManagement"));
    await z.dontSee(await TMSLmt.getData("AuditTrail"));
    await z.dontSee(await TMSLmt.getData("MasterData"));
    await z.dontSee(await TMSLmt.getData("Workflow"));
    await z.dontSee(await TMSLmt.getData("UserGroups"));
    await z.dontSee(await TMSLmt.getData("UserManagement"));
    await z.dontSee(await TMSLmt.getData("ImpersonateUserRequests"));
    await z.see(await TMSLmt.getData("Preference"));
    await z.see(await TMSLmt.getData("Security_Policy_page"));
    await z.click(await TMSLmt.getElement(DisplayObj.DisplaySettingsTab));
    await z.see(await TMSLmt.getData("Company_Preferences_Display"));
});

When ("Change OTP flag from Yes to No",async function(){
    await z.selectOption(await TMSLmt.getElement(SecurityObj.OTPLoginFlag),await TMSLmt.getData("OTPFlagYesToNo"));
    await z.fillField(await TMSLmt.getElement(SecurityObj.policyChangeDescription_Locator),SecurityObj.policyChangeDescription_Value);
    await z.click(await TMSLmt.getElement(SecurityObj.Save_btn));
    //await z.see("Security Policy has been updated");
    await z.see(await TMSLmt.getData("Security_Policy_updated"));
});

When ("Change OTP flag from No to Yes",async function(){
    await z.selectOption(await TMSLmt.getElement(SecurityObj.OTPLoginFlag),await TMSLmt.getData("OTPFlagNoToYes"));
    await z.click("//span[text()='Ok']");
    await z.fillField(await TMSLmt.getElement(SecurityObj.policyChangeDescription_Locator),SecurityObj.policyChangeDescription_Value);
    await z.click(await TMSLmt.getElement(SecurityObj.Save_btn));
    //await z.see("Security Policy has been updated");
    await z.see(await TMSLmt.getData("Security_Policy_updated"));
});


Then ("Security Policy should get updated", async function() {
    await z.fillField(await TMSLmt.getElement(SecurityObj.policyChangeDescription_Locator),SecurityObj.policyChangeDescription_Value);
    await z.click(await TMSLmt.getElement(SecurityObj.Save_btn));
    //await z.see("Security Policy has been updated");
    await z.see(await TMSLmt.getData("Security_Policy_updated"));
});

Then ("Security Policy Save", async function() {
    await z.click(await TMSLmt.getElement(SecurityObj.Save_btn));
    //await z.see("Mandatory");
    await z.see(await TMSLmt.getData("Mandatory_text"));
    });

    When ("Verify all the drop down values on Security Policy",async function(){
        //var cars = await TMSLmt.getData("PasswordHistoryList");
        var cars = SecurityObj.PasswordHistoryList;
        for (let i = 0; i < cars.length; i++) {
            z.selectOption(SecurityObj.passwordRepetitionLimit,cars[i]);
            //await z.selectOption(await TMSLmt.getElement(SecurityObj.passwordRepetitionLimit),cars[i]);
        }
    
        //var cars1 = await TMSLmt.getData("NameValuesYesNo");
        var cars1 = SecurityObj.NameValuesYesNo;
        for (let i = 0; i < cars1.length; i++) {
            await z.selectOption(`//*[@name="${cars1[i]}"]`,"Yes");
            await z.selectOption(`//*[@name="${cars1[i]}"]`,"No");
        }
    
        
    });
    
    Then ("Security Policy Values should get changed", async function() {
        var passwordRepetitionLimit_value = await z.grabValueFrom(SecurityObj.passwordRepetitionLimit);
        var cars = await TMSLmt.getData("PasswordHistoryList");
        var Compare_passwordRepetitionLimit = cars[cars.length - 1];
        await z.assertEqual(passwordRepetitionLimit_value.toString(),Compare_passwordRepetitionLimit);
    
        //var cars1 = await z.grabValueFrom("NameValuesYesNo");
        var cars1 = SecurityObj.NameValuesYesNo;
        for (let i = 0; i < cars1.length; i++) {
            var values = await z.grabTextFrom(`//*[@name="${cars1[i]}"]//option[@selected='selected']`);
            //logger.info("printing ...."+values)
            await z.assertEqual(values.toString(),"No");
        }
    
    });