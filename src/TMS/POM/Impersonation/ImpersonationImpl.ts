import { Common } from "../../Common/Common";
import { ImpersonationObj } from "./ImpersonationObj";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { z } from "actionbot-wrapper/z";

let varDesc=Common.getRandomNumber(8);


const { I } = inject();
export class ImpersonationImpl {
    static async VerifyUserOnAcceptImpersonationPage(){
        //await z.seeTitleEquals("Company Admin Impersonate User Request Page");
        //await z.see("User Management > Impersonate User Requests");
        //await z.see("Impersonate User Closing Date");
        await z.seeTitleEquals(await TMSLmt.getData("Impersonate_page"));
        await z.see(await TMSLmt.getData("Impersonate_page_user"));
        await z.see(await TMSLmt.getData("Impersonate_page_date"));
        }  
        static async NavigatetoMyProfileImpersonatePage(){
        //await z.waitForVisible(await TMSLmt.getElement(ImpersonationObj.DewDropMyProfile),120);
        //await z.seeElement(await TMSLmt.getElement(ImpersonationObj.DewDropMyProfile));   
        await z.click( await TMSLmt.getElement(ImpersonationObj.DewDropMyProfile));
        //await z.waitForVisible(await TMSLmt.getElement(ImpersonationObj.DewDropProfile_Impersonation),120);
        await z.click(await TMSLmt.getElement(ImpersonationObj.DewDropProfile_Impersonation));
        //await z.waitForVisible(await TMSLmt.getElement(ImpersonationObj.Title_Impersonation_DD_page),120);
        await z.seeElement(await TMSLmt.getElement(ImpersonationObj.Title_Impersonation_DD_page));  
        }
    
        static async GiveImpersonateAccessToCA(){
        await z.click(await TMSLmt.getElement(ImpersonationObj.AuthorizeTab));
        await z.seeElement(await TMSLmt.getElement(ImpersonationObj.AuthorizeTab_active));
        await z.click(ImpersonationObj.Radio_button_CA);
        await Common.selectInNextMonth(await TMSLmt.getElement(ImpersonationObj.DatePicker_Impersonation_date),11);
        await z.fillField(await TMSLmt.getElement(ImpersonationObj.Text_Impersonation),varDesc);
        await z.click(await TMSLmt.getElement(ImpersonationObj.Save_btn));
        await z.waitForVisible(await TMSLmt.getElement(ImpersonationObj.Success_alert),120);
        await z.click(await TMSLmt.getElement(ImpersonationObj.Done_btn));
        await z.click(await TMSLmt.getElement(ImpersonationObj.Cancel_btn));
        }
    
        static async AcceptImpersonateRequestAsCA(){
       
       /*     let flag=true;
        do{
            let a= await I.grabNumberOfVisibleElements("Auto Description-3063");
            logger.info("Count "+a)
    
            if(a == 0)
            {
                logger.info ("If loop")
                I.wait(5);
                I.click("//*[@class='next']");
            }
            else 
            flag=false;
        }while(flag);
        
        logger.info("clicked on next button");
        Common.clicked(`//td[text()='Auto Description-3063']/following-sibling::td/a[text()='Accept Request']`);
        Common.clicked(ImpersonationObj.Accept_btn);
        Common.clicked(ImpersonationObj.Ok_btn);
        */
        await z.fillField(await TMSLmt.getElement(ImpersonationObj.Email_Search),await TMSLmt.getData("Impersonate_user_Email"));
        await z.click(await TMSLmt.getElement(ImpersonationObj.Search_btn));
        await z.click(`//td[text()='${varDesc}']/following-sibling::td/a[text()='Accept Request']`);
        await z.click(await TMSLmt.getElement(ImpersonationObj.Accept_btn));
        await z.click(await TMSLmt.getElement(ImpersonationObj.Ok_btn));
        }
    
        static async VerifyImpersonate_As_UserLogin(){
            //await z.waitForVisible(await TMSLmt.getElement(ImpersonationObj.DewDropMyProfile),120);
            //await z.seeElement(await TMSLmt.getElement(ImpersonationObj.DewDropMyProfile));   
            await z.click(await TMSLmt.getElement(ImpersonationObj.DewDropMyProfile));
            //await z.waitForVisible(await TMSLmt.getElement(ImpersonationObj.DewDropMyProfile_ManageProfile),120);
            await z.click(await TMSLmt.getElement(ImpersonationObj.DewDropMyProfile_ManageProfile));
            await z.see(await TMSLmt.getData("Impersonate_user_Email"));
            await z.click(await TMSLmt.getElement(ImpersonationObj.Cancel_btn));
        }
        static async revokeimpersonaterequest(){
            
            await this.NavigatetoMyProfileImpersonatePage();
            await z.click(await TMSLmt.getElement(ImpersonationObj.ViewImpersonationRequestsTab));
            await z.click(await TMSLmt.getElement(ImpersonationObj.Revoke_btn_First));
        }


}