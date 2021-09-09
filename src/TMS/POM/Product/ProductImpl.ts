const { I } = inject();
import { Common } from "../../Common/Common";
import { ProductObj } from "./ProductObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";
import { AuditTrailObj } from "../AuditTrail/AuditTrailObj";


var ProdName = getRandomforProd(3)+ "_Prodname";
// var ProdName = "fow_auto";
var ActGroup = getRandomforProd(3)+ "ActGrp";
var ActGroup1 = getRandomforProd(3)+ "ActGrpEdit";
var ActName = getRandomforProd(3) + "_act";
// let a = require ("faker");
// console.log(faker.random.number(500))

export class ProductImpl
{   
    static async fillProdInfo()
    {  
        await z.fillField(await TMSLmt.getElement(ProductObj.ProdName),ProdName);
        await z.fillField(await TMSLmt.getElement(ProductObj.WhiteListedBrowser), await TMSLmt.getData("WhiteListedBrowserVal"));
        await z.fillField(await TMSLmt.getElement(ProductObj.UnsupportedBrowser), await TMSLmt.getData("UnsupportedBrowserVal"));
        await z.fillField(await TMSLmt.getElement(ProductObj.BlackListedBrowser), await TMSLmt.getData("BlackListedBrowserVal"));
  
        await z.selectOption(await TMSLmt.getElement(ProductObj.DefaultBehaviourDD),"WHITE_LISTED"); 
        await z.fillField(await TMSLmt.getElement(ProductObj.UnsupportedBrowser), await TMSLmt.getData("UnsupportedBrowserVal"));
        await z.fillField(await TMSLmt.getElement(ProductObj.SupportedBrowserTemp), await TMSLmt.getData("SupportedBrowserVal"));
    }

    static async addActivityGroup()
    {
        await z.click(await TMSLmt.getElement(ProductObj.AddNewActGroup));
        await z.fillField(await TMSLmt.getElement(ProductObj.AGName),ActGroup);
        await z.click(await TMSLmt.getElement(ProductObj.PopUpSave));
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        await z.click(await TMSLmt.getElement(ProductObj.PopUpClose));
        await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
        await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
    }

    static async addforproductActivityGroup()
    {
        await z.click(await TMSLmt.getElement(ProductObj.AddNewActGroup));
        await z.fillField(await TMSLmt.getElement(ProductObj.AGName),ActGroup);
        await z.click(await TMSLmt.getElement(ProductObj.PopUpSave));
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        await z.click(await TMSLmt.getElement(ProductObj.PopUpClose));
       // await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
        //await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
    }

    static async addActivity()
    {
        await z.click(await TMSLmt.getElement(ProductObj.AddNewActivities));
        await z.fillField(await TMSLmt.getElement(ProductObj.ActName),ActName);
        await z.fillField(await TMSLmt.getElement(ProductObj.ActURL),ProductObj.ActURLVal);
        await z.waitForClickable(await TMSLmt.getElement(ProductObj.SaveActBtn));
        await z.click(await TMSLmt.getElement(ProductObj.SaveActBtn));
        await z.click(await TMSLmt.getElement(ProductObj.PopUpCancel_Act));
    }

    static async verifyProdAdded(comp)
    {       
        await z.click(await TMSLmt.getElement(ProductObj.Company));
        await z.fillField(await TMSLmt.getElement(ProductObj.CompSearch),comp);
        await z.click(await TMSLmt.getElement(ProductObj.GoBtn));
        await z.click(await TMSLmt.getElement(ProductObj.EditComp));
        await z.click(await TMSLmt.getElement(ProductObj.EditProdAllocation)); 
    }

    static async EditProduct()
    {   
        //await z.wait(10);
     
        //for(let i= 1;i<=99; i++)
        //try {
                //await z.see(ProdName);
                await z.see(await TMSLmt.getData("ProductNameEdit"));
                //await z.click(`//td[text()='${ProdName}']/following-sibling::td/label`);
                await z.click(`//td[text()='0Ru_auto']/following-sibling::td/label`);
                // I.click(ProductObj.EditProdInfo);
                await z.click(await TMSLmt.getElement(ProductObj.EditProdInfo));
                // Common.fillfields(ProductObj.BlackListedBrowser,"Chrome");
                await z.fillField(await TMSLmt.getElement(ProductObj.BlackListedBrowser),"Chrome");
                // I.click(ProductObj.UpdateNSaveBtn);
                // I.click(ProductObj.DoneBtn);
                await z.click(await TMSLmt.getElement(ProductObj.UpdateNSaveBtn));
                await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
                await z.refreshPage();
            
        //} catch (Exception) {
        //        await (await TMSLmt.getElement(ProductObj.NextPage));
        //}
        /*{ 
            //if(I.See(ProdName))
            if(!ProdName)
            {   
                //I.click(ProductObj.NextPage);
               I.wait(3);
                I.click(`//td[text()='${ProdName}']/following-sibling::td/label`);
                I.click(ProductObj.EditProdInfo);
                Common.fillfields(ProductObj.BlackListedBrowser,"Chrome");
                I.click(ProductObj.UpdateNSaveBtn);
                I.click(ProductObj.DoneBtn);
                I.refreshPage();
                console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
            else 
            {   
                I.click(ProductObj.NextPage);
            }
            
        }*/
        
    }

    static async doneEditing()
    {
        await z.click(await TMSLmt.getElement(ProductObj.UpdateNSaveBtn));
        await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
	    // I.click(ProductObj.UpdateNSaveBtn);
	    // I.wait(5);
	    // I.click(ProductObj.DoneBtn);
        // I.wait(5);
    }

    static async VerifyChangesReflected()
    {
        //z.wait(10);
        z.refreshPage();
        for(let i= 1;i<=99; i++)
        { 
            if(z.see(ProdName))
            {
                ///z.wait(3);
                z.click(`//td[text()='${ProdName}']/following-sibling::td/label`);
                z.see("Chrome");
                //(ProductObj.ToCheck).includes("Chrome");
                break;
            }
            else
            {   
                z.click(ProductObj.NextPage);
            }
            
        }
    }
  
    static async Productcreatedname()
    {  
        await z.see(ProdName);
    }

    static async UpdateProductcreatedname()
    {  
        await z.see(await TMSLmt.getData("ProductNameEdit"));
    }

    static async ActivityGroupcreatedname()
    {  
        await z.see(ActGroup);
    }

    static async ActivityGroupupdatename()
    {  
        await z.see(ActGroup1);
    }

    static async ActivityGroupupdatenameenter()
    {  
        await z.fillField(AuditTrailObj.AuditTrail_ActGrpnameeditlocator,ActGroup1);
    }


}



// module.exports = new ProdInfo();
// module.exports.ProdInfo=ProdInfo; // for inheritance

function getRandomforProd(length:number) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
       result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result+"_auto";
 }