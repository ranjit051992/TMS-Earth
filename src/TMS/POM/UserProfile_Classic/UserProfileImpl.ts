const { I } = inject();

import { UserProfileObj } from "./UserProfileObj";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
let searchWindow;

export class UserProfileImpl {
    static async NavigateToUserProfilePage() {
        searchWindow = await z.grabCurrentWindowHandle();
        await z.click("//span[@class='h-settings icon-Settings']");
        await z.click("//a[@class='h-topBand-menu-lnk']");   
    } 
    static async UserCheckProfilePage() {
        await z.switchToNextTab();
        //await z.seeTitleEquals("User Profile");
       // await z.see("User Profile of"); 
        await z.seeTitleEquals(await TMSLmt.getData("User_Profile_Title"));
        await z.see(await TMSLmt.getData("User_Profile_Text"));
   } 
   static async UploadProfilepic() {
    await z.click(await TMSLmt.getElement(UserProfileObj.UploadBtn));
    //await z.switchToNewWindow();
    await z.attachFile("importFile",'uploadProfilePic1.png');
    await z.click(await TMSLmt.getElement(UserProfileObj.Done_btn));  
    }
    static async UpdateUserProfile() {
        await z.fillField(await TMSLmt.getElement(UserProfileObj.Telephone),await TMSLmt.getData("Txt_tele"));
        await z.fillField(await TMSLmt.getElement(UserProfileObj.AltTelephone),await TMSLmt.getData("Txt_AltTele"));
        await z.fillField(await TMSLmt.getElement(UserProfileObj.Extn),await TMSLmt.getData("Txt_tele"));
        await z.selectOption(await TMSLmt.getElement(UserProfileObj.Locator_defaultDateFormat),await TMSLmt.getData("Value_defaultDateFormat"));
        await z.selectOption(await TMSLmt.getElement(UserProfileObj.Locator_timeFormat),await TMSLmt.getData("Value_timeFormat"));
        //await z.selectOption(await TMSLmt.getElement(UserProfileObj.Locator_defaultLocale),await TMSLmt.getData("Value_defaultLocale"));
        await z.click(await TMSLmt.getElement(UserProfileObj.SaveAndCloseBtn));
        await z.switchToWindow(searchWindow);   
        }        
}