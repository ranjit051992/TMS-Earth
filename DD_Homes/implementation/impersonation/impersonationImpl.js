const { I } = inject()
const ApprovalPage = require("../../../node_modules/dd-cc-zycus-automation/components/approvalPage")
const CommonKeyword = require("../../../node_modules/dd-cc-zycus-automation/components/commonKeyword")



class ImpersonationImpl{
    async verifySuccessAlert(){
        await I.waitForVisible("//div[contains(@class,'alert-panel')]/img[@alt='icon-success']",120);
        let numOfElements = await I.grabNumberOfVisibleElements("//div[contains(@class,'alert-panel')]/img[@alt='icon-success']");
        if(numOfElements>=1){
            CommonKeyword.click("//div[contains(@class,'alert-panel')]//button[@aria-label='Done']");
        }
        else{
            console.log("Fail : Success popup alert is not present");
        }
        console.log("Impersonation created");
    }

    async createAndRevoke(){
        ApprovalPage.selectHeaderTab("View Impersonation Requests");
        CommonKeyword.click("(//span[@title='Revoke & Create New'])[1]");
        I.waitForVisible("//label[text()='Allow Company admin to impersonate me']",120);
        I.seeElement("//label[text()='Allow Company admin to impersonate me']",120);
        ApprovalPage.selectHeaderTab("View Impersonation Requests");
        I.waitForVisible("(//span[@title='Revoked'])[1]",120);
        I.seeElement("(//span[@title='Revoked'])[1]");
        console.log("create and revoke done");

    }

    async clickRevoke(){
        ApprovalPage.selectHeaderTab("View Impersonation Requests");
        CommonKeyword.click("(//span[@title='Revoke'])[1]");
        console.log("Click on revoked")
    }
    async verifyRevoke(){
        ApprovalPage.selectHeaderTab("View Impersonation Requests");
        I.waitForVisible("(//span[@title='Revoked'])[1]",120);
        I.seeElement("(//span[@title='Revoked'])[1]");
        console.log("Request revoked");
    }

    /* async enterDescription(){

    } */

}
module.exports = new ImpersonationImpl()
module.exports.ImpersonationImpl = ImpersonationImpl