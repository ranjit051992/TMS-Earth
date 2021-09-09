const { I } = inject();
import { Common } from "../../Common/Common";
import {  UserGroupObj } from "./UserGroupObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import {prop} from "../../../Framework/FrameworkUtilities/config";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";

var UGName1 = getRandomforUG(4) + "_ugautomation"
var UGName = getRandomforUG(4) + "_automation"
let desc = getRandomforUG(3) + "UpdatedDescription";

export class UserGroupImpl{

    static async EnterReqData(){
        await z.fillField(await TMSLmt.getElement(UserGroupObj.UGName), UGName);
        await z.fillField(await TMSLmt.getElement(UserGroupObj.UGDesc),await TMSLmt.getData("Created_By_UGdesc"));
        await z.fillField(await TMSLmt.getElement(UserGroupObj.SearchByName),await TMSLmt.getData("Created_By_UG_name"));
        // Common.fillfields(UserGroupObj.UGName,UGName);
        // Common.fillfields(UserGroupObj.UGDesc,"CreatedByBDDAutomation");
        // Common.fillfields(UserGroupObj.SearchByName,"ad");
        await z.pressKey("Enter");
        await z.click(await TMSLmt.getElement(UserGroupObj.SelectUser));
    }   
    static async SeeUGCreated(){
        await z.see(UGName);
    }

    static async ChangeUGdesc(){
        await z.fillField(await TMSLmt.getElement(UserGroupObj.UGName), UGName1);
        await z.fillField(await TMSLmt.getElement(UserGroupObj.SearchByName),await TMSLmt.getData("Created_By_UG_name1"));
        await z.pressKey("Enter");
        await z.click(await TMSLmt.getElement(UserGroupObj.SelectUser));
        await z.fillField(await TMSLmt.getElement(UserGroupObj.UGDesc), desc);
    }   
    
    static async UGUpdated(){
        await z.refreshPage();
        var updatedDesc = await z.grabTextFrom(`//td[text()='${UGName}']/following-sibling::td[1]`);
        await z.assertEqual(desc,updatedDesc);
    }

    static async AuditUGUpdated(){
        await z.see(UGName1);
        //await z.see("User Group Updated");
        await z.see(await TMSLmt.getData("Updated_UG_name"));
        //await z.click(await TMSLmt.getElement(UserGroupObj.UGDescUpdateAuditLink));
        
    }

    static async UGCreation(){
        var v= '//td[text()="'+ UGName +'"]';
        var ActValue= await z.grabTextFrom(v);
        await console.log(ActValue);
        await this.VerifyUGCreated(ActValue,UGName);
    }
    static async VerifyUGCreated(a,b)
    {
        if(a==b)
        {
            console.log("UserGroup is successfully created");
        }
        else
        {
            console.log("UserGroup Created Failed");
        }
    }
}
function getRandomforUG(length:number) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
       result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result+"_auto";
 }

// module.exports = new verify();
// module.exports.verify=verify; // for inheritance