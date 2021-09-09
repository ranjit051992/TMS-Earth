const { I } = inject();
import { Common } from "../../Common/Common";
import { CompanyImpl } from "../../POM/Company/CompanyImpl";
import { CompanyObj } from "../../POM/Company/CompanyObj";
import {prop} from "../../../Framework/FrameworkUtilities/config";
import { z } from "actionbot-wrapper/z";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";


Given ("User on Create Company Page", async function() {
    await CompanyImpl.NavigateToCompanyCreatePage();
});

When ("I Fill Basic Information", async function() {
    await CompanyImpl.fillBasicInfo();    
});

When ("I Fill Component Selection & Product Allocation", async function() {
    await CompanyImpl.ProductComponentSelection();    
});

When ("Update I Fill UpdateComponent Selection & Product Allocation", async function() {
    await CompanyImpl.UpdateProductComponentupdateSelection();    
});

When ("I Fill Company Admin Details", async function() {
    await CompanyImpl.fillCompanyAdminDetails();    
});
When ("I Fill Preferences", async function() {
    await CompanyImpl.fillPerferences();    
});
When ("Define Company", async function() {
    await CompanyImpl.defineCompany();
});
Then ("Company Creation Success Popup should be seen", async function() {
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
    await CompanyImpl.VerifyCompanyCreationPopup();
});
Then ("Company is shown on Company Listing Page", async function() {
    await CompanyImpl.searchCompany();
});
When ("I activate Company",async function(){
    await CompanyImpl.activateCompany();
});
Then ("Company should get activate", async function() {
    await CompanyImpl.verifyCompanyActive();
});
When ("I deactivate Company",async function(){
    await CompanyImpl.deactivateCompany();
});
Then ("Company should get deactivate", async function() {
    await CompanyImpl.verifyCompanyDeActive();
});

Given ("Go to the Edit Company Summary Page", async function() {
    await CompanyImpl.NavigatetoEditPage();
});

When("Update Company Basic Details", async function(){
    await CompanyImpl.updateCompanyBasicDetails();
});

When("Update Company",async function(){
    await z.click(CompanyObj.COMPANY_UPDATE_COMPANY);
});

Then("Company Popup should be seen",async function(){
    await CompanyImpl.VerifyCompanyUpdatePopup();
});