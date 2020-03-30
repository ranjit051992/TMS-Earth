const { I } = inject()
const ApprovalPage = require("../../implementation/MyApproval/MyApprovalImpl")
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const ImpersonationObject = require("./ImpersonationObject")


class ImpersonationImpl{
    async verifySuccessAlert(){
        await I.waitForVisible(ImpersonationObject.SuccessAlert,20);
        let numOfElements = await I.grabNumberOfVisibleElements(ImpersonationObject.SuccessAlert);
        if(numOfElements>=1){
            CommonKeyword.clickElement(ImpersonationObject.SuccessDoneBtn);
            console.log("Impersonation created");
        }
        else{
            console.log("Fail : Success popup alert is not present");
        }
        
    }

    async createAndRevoke(){
        ApprovalPage.selectHeaderTab(ImpersonationObject.ImpersonationHeaderTab);
        CommonKeyword.clickElement(ImpersonationObject.RevokeAndCreateBtn);
        I.waitForVisible(ImpersonationObject.CompanyAdminImpersonate,20);
        I.seeElement(ImpersonationObject.CompanyAdminImpersonate,20);
        //ApprovalPage.selectHeaderTab(ImpersonationObject.ImpersonationHeaderTab);
        //I.waitForVisible(ImpersonationObject.RevokedStatus,20);
        //I.seeElement(ImpersonationObject.RevokedStatus);
        //console.log("create and revoke done");

    }

    async clickRevoke(){
        ApprovalPage.selectHeaderTab(ImpersonationObject.ImpersonationHeaderTab);
        I.waitForVisible(ImpersonationObject.RevokeBtn,15)
        CommonKeyword.clickElement(ImpersonationObject.RevokeBtn);
        console.log("Click on revoked")
    }
    async verifyRevoke(){
        ApprovalPage.selectHeaderTab(ImpersonationObject.ImpersonationHeaderTab);
        I.waitForVisible(ImpersonationObject.RevokedStatus,20);
        I.seeElement(ImpersonationObject.RevokedStatus);
        console.log("Request revoked");
    }

    /* async enterDescription(){

    } */

}
module.exports = new ImpersonationImpl()
module.exports.ImpersonationImpl = ImpersonationImpl