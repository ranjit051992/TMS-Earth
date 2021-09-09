const { I } = inject();
import { z } from "actionbot-wrapper/z";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

export class  DSSOImpl  {

    static async LoginThroughADFS(Email,Password){

    await z.click("//input[@id='userNameInput']")
    await z.fillField("//input[@id='userNameInput']", Email)
    await z.click("//input[@id='passwordInput']")
    await z.fillField("//input[@id='passwordInput']", Password)
    await z.click("//span[@id='submitButton']")

    }
    static async LoginThroughOkta(Email,Password){

        await z.click("//input[@id='okta-signin-username']")
        await z.fillField("//input[@id='okta-signin-username']", (Email = await TMSLmt.getData("DSSOOctaUser4_email")))
        await z.click("//input[@id='okta-signin-password']")
        await z.fillField("//input[@id='okta-signin-password']", (Password = await TMSLmt.getData("DSSOOctaUser4_pass")))
        await z.click("//input[@id='okta-signin-submit']")
    }

    static async DSSOADFSlogin(ADFSUserType: string){

        let username: string = "";
        let password: string = "";
        logger.info("UserRole is ---> "+ADFSUserType)
        if(ADFSUserType === "ADFSUser")
        {
            username = (await TMSLmt.getData("DSSOADFSUser1_email")) as string;
            password = (await TMSLmt.getData("DSSOADFSUser1_pass")) as string;
        }
        else if(ADFSUserType === "ADFSUserNotPresent")
        {   
            username = (await TMSLmt.getData("DSSOADFSUser2_email")) as string;
            password = (await TMSLmt.getData("DSSOADFSUser2_pass")) as string;
        }
        else if(ADFSUserType === "ADFSUserinactive")
        {
            username = (await TMSLmt.getData("DSSOADFSUser3_email")) as string;
            password = (await TMSLmt.getData("DSSOADFSUser3_pass")) as string;
        }
        else
        {
            username = (await TMSLmt.getData("DSSOADFSUser4_email")) as string;
            password = (await TMSLmt.getData("DSSOADFSUser4_pass")) as string;
        }

        await z.click("//input[@id='userNameInput']")
        await z.fillField("//input[@id='userNameInput']", username);
        logger.info(`Entered email address --> ${username}`);
        await z.click("//input[@id='passwordInput']")
        await z.fillField("//input[@id='passwordInput']", password);
        logger.info(`Entered password --> ${password}`);
        await z.click("//span[@id='submitButton']")
    }

    static async DSSOOctalogin(OctaUserType: string){

        let username1: string = "";
        let password1: string = "";
        logger.info("UserRole is ---> "+OctaUserType)
        if(OctaUserType === "OctaUser")
        {
            username1 = (await TMSLmt.getData("DSSOOctaUser1_email")) as string;
            password1 = (await TMSLmt.getData("DSSOADFSUser1_pass")) as string;
        }
        else if(OctaUserType === "OktaUserNotPresent")
        {   
            username1 = (await TMSLmt.getData("DSSOOctaUser2_email")) as string;
            password1 = (await TMSLmt.getData("DSSOOctaUser2_pass")) as string;
        }
        else if(OctaUserType === "OktaUserinactive")
        {
            username1 = (await TMSLmt.getData("DSSOOctaUser3_email")) as string;
            password1 = (await TMSLmt.getData("DSSOOctaUser3_pass")) as string;
        }
        else if(OctaUserType === "OktaUserConcurrent")
        {
            username1 = (await TMSLmt.getData("DSSOOctaUser4_email")) as string;
            password1 = (await TMSLmt.getData("DSSOOctaUser4_pass")) as string;
        }
        else
        {
            username1 = (await TMSLmt.getData("DSSOOctaUser5_email")) as string;
            password1 = (await TMSLmt.getData("DSSOOctaUser5_pass")) as string;
        }
        await z.click("//input[@id='okta-signin-username']")
        await z.fillField("//input[@id='okta-signin-username']", username1);
        logger.info(`Entered email address --> ${username1}`);
        await z.click("//input[@id='okta-signin-password']")
        await z.fillField("//input[@id='okta-signin-password']", password1);
        logger.info(`Entered password --> ${password1}`);
        await z.click("//input[@id='okta-signin-submit']")
    }
}