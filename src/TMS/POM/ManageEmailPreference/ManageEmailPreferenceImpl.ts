const { I } = inject();
import { Common } from "../../Common/Common";
import { ManageEmailPreferenceObj } from "./ManageEmailPreferenceObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { Login_TMSObj } from "../login/Login_TMSObj";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";
import { DataIntegrity } from "dd-dataintegrity/src/DataIntegrity";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";

var status;
var status1;


export class ManageEmailPreferenceImpl
 {	
	checked : any;
    static async manage(a,b)
    {
        if (a.toString == true)
	{
		z.click(ManageEmailPreferenceObj.NewReqAtBuyerDeskNo);
	}
	else
	{
		z.click(ManageEmailPreferenceObj.NewReqAtBuyerDeskYes);
    }
    z.wait(5);
	z.click(ManageEmailPreferenceObj.SaveBtn);
	}
	
	static async ChangeWindow()
	{	
		
		// String winHandleBefore = driver.getWindowHandle();
		// for(String winHandle : driver.getWindowHandles())
		{
			//driver.switchTo().window(winHandle);
		}	
	}

	static async NavigateToTMS(){
        await z.click(await TMSLmt.getElement(Login_TMSObj.MENUSOPTIONS));
        await z.moveCursorTo(await TMSLmt.getElement(Login_TMSObj.DD_HOME));
        await z.scrollIntoView(await TMSLmt.getElement(Login_TMSObj.TMS_PRODUCT));
        await z.click(await TMSLmt.getElement(Login_TMSObj.TMS_PRODUCT));
		await z.click(await TMSLmt.getElement(Login_TMSObj.TMS_TMSSubmenu));
		//await z.click("//a[@href='https://tenants-qcvw.zycus.net/tms/']");
        await z.switchToNextTab();
		// I.wait(5);
	}

	static async ChangeSetting()
	{	
		await z.switchToNextTab();
		await z.resizeWindow("maximize");
		// await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.UMPTab));
		await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
		await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
		await z.waitForClickable(await TMSLmt.getElement(ManageEmailPreferenceObj.eProcSettings));
		await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.eProcSettings));
		// I.wait(4);
		await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
		await z.waitForClickable(await TMSLmt.getElement(ManageEmailPreferenceObj.Set1));

		/**
 			* @type {string | boolean}
 		*/
		if ((await TMSLmt.getElement(ManageEmailPreferenceObj.Set1)as any).checked == true)
		{
			await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.Set1));
			status="true";
			// I.wait(8);
		}
		else
		{
			await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.Set1));
			status="false";
			// I.wait(8);
			//I.click(ManageEmailPreferenceObj.UserSaveBtn);
		}
		DataIntegrity.actualDatamap("Status of the email preference",status);

		if((await TMSLmt.getElement(ManageEmailPreferenceObj.Set2)as any).checked ==true)
		{
			// I.click(ManageEmailPreferenceObj.Set2);
			await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.Set2));
			status1="true";
		}
		else 
		{ 
			await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.Set2));
			status1="false";
		}
		await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.UserSaveBtn));
	}

	static async verificationResult()
	{
		await z.waitForClickable(await TMSLmt.getElement(ManageEmailPreferenceObj.eInvoiceSettings));
		await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.eInvoiceSettings));
        await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.eProcSettings));

		//if ((await TMSLmt.getElement(ManageEmailPreferenceObj.Set1) as any).checked == true)
		//{
		//	console.log("Failed");
		//}
		//else
		//{
		//	console.log("Passed");
		//}

		
		let eprocsetting1 = await z.grabValueFrom(await TMSLmt.getElement(ManageEmailPreferenceObj.Set1));
                // console.log(UpdatedRoleDesc);
                //await z.assertEqual(UpdateRoleDes,UpdatedRoleDesc);
                DataIntegrity.expectedDatamap("Status of the email preference Expected",eprocsetting1);
                z.assertEqual(DataIntegrity.actualData().get("Status of the email preference"), DataIntegrity.expectedData().get("Status of the email preference Expected"));
		 //I.assertEqual((ManageEmailPreferenceObj.Set1),status);
	}
 }

  
       

 
// module.exports = new MEP();
// module.exports.MEP=MEP; // for inheritance