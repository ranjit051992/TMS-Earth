const { I } = inject();
import { Common } from "../../Common/Common";
import { Login_TMSObj } from "./Login_TMSObj";
//import prop = global.confi_prop;
import { logger} from "../../../Framework/FrameworkUtilities/Logger/logger";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { prop } from "../../../Framework/FrameworkUtilities/config";
import { z } from "actionbot-wrapper/z";
import { CreateUserObj } from "../Users/CreateUserObj";
import { CommonKeyword } from "dd-cc-zycus-automation/dist/components/commonKeyword";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import { Startup } from "../../../Framework/FrameworkUtilities/Startup/Startup";
import { EmailTest_NewImpl_TMS } from "../../../Framework/FrameworkUtilities/EmailTest/emailTest_Enhanced_NewImplementation_TMS";

export class LoginImpl {
    static async login(userRole:string)
    {
        logger.info(await TMSLmt.getData("URL"));      
        await z.amOnPage(await TMSLmt.getData("URL"));
        logger.info("Navigated to log-in page");
        let username: string = "";
        let password: string = "";
        logger.info("UserRole is ---> "+userRole)
        if(userRole === "CA")
        {
            username = (await TMSLmt.getData("CA_EmailAddress")) as string;
            password = (await TMSLmt.getData("CA_Password")) as string;
        }
        else if(userRole === "ZA")
        {   
            username = (await TMSLmt.getData("ZA_EmailAddress")) as string;
            password = (await TMSLmt.getData("ZA_Password")) as string;
        }
        else
        {
            username = (await TMSLmt.getData("LA_EmailAddress")) as string;
            password = (await TMSLmt.getData("LA_Password")) as string;
        }
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.EMAILADDRESS_TEXTBOX), username);
        logger.info(`Entered email address --> ${username}`);
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.PASSWORD_TEXTBOX), password);
        logger.info(`Entered password --> ${password}`);
        await z.waitForClickable(await TMSLmt.getElement(Login_TMSObj.LOGIN_BUTTON));
        await z.click(await TMSLmt.getElement(Login_TMSObj.LOGIN_BUTTON));
        logger.info("Clicked on Login button");
        await this.waitForLoadingSymbolNotDisplayed();  
        logger.info("Logged in Successfully");

    }

    static async Specificlogin(SpecuserRole:string)
    {
        logger.info(await TMSLmt.getData("URL"));      
        await z.amOnPage(await TMSLmt.getData("URL"));
        logger.info("Navigated to log-in page");
        let username: string = "";
        let password: string = "";
        logger.info("UserRole is ---> "+SpecuserRole)
        if(SpecuserRole === "UserManagement")
        {
            username = (await TMSLmt.getData("UserManagement_EmailAddress")) as string;
            password = (await TMSLmt.getData("UserManagement_Password")) as string;
        }
        else if(SpecuserRole === "RoleManagement")
        {   
            username = (await TMSLmt.getData("RoleManagement_EmailAddress")) as string;
            password = (await TMSLmt.getData("RoleManagement_Password")) as string;
        }
        else if(SpecuserRole === "AuditManagement")
        {
            username = (await TMSLmt.getData("AuditManagement_EmailAddress")) as string;
            password = (await TMSLmt.getData("AuditManagement_Password")) as string;
        }
        else if(SpecuserRole === "Preferences")
        {
            username = (await TMSLmt.getData("Preferences_EmailAddress")) as string;
            password = (await TMSLmt.getData("Preferences_Password")) as string;
        }
        else if(SpecuserRole === "Reports")
        {
            username = (await TMSLmt.getData("Reports_EmailAddress")) as string;
            password = (await TMSLmt.getData("Reports_Password")) as string;
        }
        else if(SpecuserRole === "MasterData")
        {
            username = (await TMSLmt.getData("MasterData_EmailAddress")) as string;
            password = (await TMSLmt.getData("MasterData_Password")) as string;
        }
        else if(SpecuserRole === "Workflow")
        {
            username = (await TMSLmt.getData("Workflow_EmailAddress")) as string;
            password = (await TMSLmt.getData("Workflow_Password")) as string;
        }
        else if(SpecuserRole === "UserandRole")
        {
            username = (await TMSLmt.getData("UserandRole_EmailAddress")) as string;
            password = (await TMSLmt.getData("UserandRole_Password")) as string;
        }
        else
        {
            username = (await TMSLmt.getData("test_EmailAddress")) as string;
            password = (await TMSLmt.getData("test_Password")) as string;
        }

        await z.fillField(await TMSLmt.getElement(Login_TMSObj.EMAILADDRESS_TEXTBOX), username);
        logger.info(`Entered email address --> ${username}`);
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.PASSWORD_TEXTBOX), password);
        logger.info(`Entered password --> ${password}`);
        await z.waitForClickable(await TMSLmt.getElement(Login_TMSObj.LOGIN_BUTTON));
        await z.click(await TMSLmt.getElement(Login_TMSObj.LOGIN_BUTTON));
        logger.info("Clicked on Login button");
        await this.waitForLoadingSymbolNotDisplayed();  
        logger.info("Logged in Successfully");

    }

    static async loginwithOTPenablessouser() {
        // await z.amOnPage(await TMSLmt.getData("URL") as string);
        // z.refreshPage();
        await z.amOnPage(await TMSLmt.getData("URL"));
        let otpusername = (await TMSLmt.getData("OTP_SSOEmailAddress")) as string;
        await z.click(await TMSLmt.getElement(Login_TMSObj.EMAILADDRESS_TEXTBOX));
        let otppasword = (await TMSLmt.getData("OTP_SSOPassword")) as string;
        console.log(otpusername + "0-0-0---   " + otppasword);
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.EMAILADDRESS_TEXTBOX), otpusername);

        await z.fillField(await TMSLmt.getElement(Login_TMSObj.PASSWORD_TEXTBOX), otppasword);

        await z.click(await TMSLmt.getElement(Login_TMSObj.LOGIN_BUTTON));

    }

    static async loginwithOTPenabledssouser() {
        await z.amOnPage(await TMSLmt.getData("URL") as string);
        let otpusername = (await TMSLmt.getData("OTP_DSSOEmailAddress")) as string;
        await z.click(await TMSLmt.getElement(Login_TMSObj.EMAILADDRESS_TEXTBOX));
        let otppasword = (await TMSLmt.getData("OTP_DSSOPassword")) as string;
        console.log(otpusername + "0-0-0---   " + otppasword);
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.EMAILADDRESS_TEXTBOX), otpusername);
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.PASSWORD_TEXTBOX), otppasword);
        await z.click(await TMSLmt.getElement(Login_TMSObj.LOGIN_BUTTON));

    }

    static async VerifyloginwithOTPenableuser() {
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.OTP_Field), "waiting");

        await EmailTest_NewImpl_TMS.readEmail(prop.email_address, prop.user_password, ['SUBJECT'], ['OTP to login into Zycus Suite'], "Inbox", 1000);
        //await EmailTest_NewImpl_DD_Home.readEmail(prop.Username, prop.Password, ['SUBJECT'], [Startup.testData.get("EmailSubjectSharedReport")as string], "Inbox", 60000);
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.OTP_Field), "waiting001")
        console.log("------>> "+await EmailTest_NewImpl_TMS.readEmail(prop.email_address, prop.user_password, ['SUBJECT'], ['OTP to login into Zycus Suite'], "Inbox", 1000))
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.OTP_Field), "waiting002")
        console.log("------>> " + (Startup.email_Test.get("emailBody") as string));
        let body = Startup.email_Test.get("emailBody") as string;
        let ret = body.search("OTP:");
        let dat1 = body.indexOf("OTP:");
        console.log("585852------->>" + dat1);
        let OTP = body.substring(dat1 + 5, dat1 + 11);
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.OTP_Field), "waiting002")
        console.log("******* >>> " + OTP);
        //await z.click(await TMSLmt.getElement(Authentication_Obj.OTP_Field));
        console.log("Element is clicked *** >> " );
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.OTP_Field), OTP as string);
        console.log("Element filled *** >> " );
        await z.click(await TMSLmt.getElement(Login_TMSObj.LOGIN_BUTTON));
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        //await z.seeElement(await TMSLmt.getElement(Authentication_Obj.Welcome_Message));

    }

    static async VerifyloginwithInvalidOTP()
    {
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.OTP_Field),'524158');
        await z.click(await TMSLmt.getElement(Login_TMSObj.LOGIN_BUTTON));
        await z.see(await TMSLmt.getData("WarningMsg"));
    }

    static async VerifyloginwithResendOTP()
    {
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.OTP_Field),'5241582');
        await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
        await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
        await z.click(await TMSLmt.getElement(Login_TMSObj.RESENDOTP_BUTTON));
        // let otpsent: string = await z.grabTextFrom(await lmt.getElement(Authentication_Obj.OTP_SentMSG));
        // console.log("OTP sent message    "+otpsent);
        // await z.seeElement(await lmt.getElement(Authentication_Obj.OTP_SentMSG));
    }

    static async NavigateToCompanyListing()
    {
        //await z.click(await TMSLmt.getElement(Login_TMSObj.MENUSOPTIONS));
        await CommonKeyword.clickElement(await TMSLmt.getElement(Login_TMSObj.MENUSOPTIONS));
        await z.moveCursorTo(await TMSLmt.getElement(Login_TMSObj.DD_HOME));
        await z.scrollIntoView(await TMSLmt.getElement(Login_TMSObj.TMS_PRODUCT));
        await z.click(await TMSLmt.getElement(Login_TMSObj.TMS_PRODUCT));
        //await z.click("//a[@href='https://tenants-qcvw.zycus.net/tms/']");
        await z.click(await TMSLmt.getElement(Login_TMSObj.TMS_TMSSubmenu));
        //await z.click("//*[@id="app-root-container"]/div[1]/div/dew-side-menu/div[2]/ul[2]/a[1]/li/span");
        await z.switchToNextTab();
        //await z.seeTitleEquals("Company Listings");
        await z.seeTitleEquals(await TMSLmt.getData("Company_Listing_Page"));
        await z.waitForVisible(".//*[@title='Edit Company Information']");
    }
    static async NavigateToUserListing()
    {
        // await z.click(await TMSLmt.getElement(Login_TMSObj.MENUSOPTIONS));
        // await z.moveCursorTo(await TMSLmt.getElement(Login_TMSObj.DD_HOME));
        // await z.scrollIntoView(await TMSLmt.getElement(Login_TMSObj.TMS_PRODUCT));
        // await z.click(await TMSLmt.getElement(Login_TMSObj.TMS_PRODUCT));
        // //await z.click("//a[@href='https://tenants-qcvw.zycus.net/tms/']");
        // //await z.click(await TMSLmt.getElement(Login_TMSObj.TMS_TMSSubmenu));
        // await ProductNavigator.navigate(productval,Module);
        // await z.switchToNextTab();
        // await z.seeTitleEquals("List of Users");
        // await z.waitForVisible(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
    }
    static async DewdropsLogout()
    {
        await z.scrollIntoView(await TMSLmt.getElement(Login_TMSObj.USER_ICON));
        await this.clickOnUserIcon();
        await this.clickOnLogoutButton();
        await z.waitForVisible(await TMSLmt.getElement(Login_TMSObj.LOGOUT_CONFIRMATION_POPUP));
        await this.clickOnLogoutConfirmationYesButton();
        await this.waitForLoadingSymbolNotDisplayed();
    }
    static async ClassicLogout()
    {
        await z.click(await TMSLmt.getElement(Login_TMSObj.TMS_LOGOUT));
    }
    static async clickOnUserIcon()
    {
        await z.click(await TMSLmt.getElement(Login_TMSObj.USER_ICON));
        logger.info("Clicked on user icon");
    }
    static async clickOnLogoutConfirmationYesButton()
    {
        await z.click(await TMSLmt.getElement(Login_TMSObj.LOGOUT_CONFIRMATION_YES_BUTTON));
        logger.info("Clicked on log out Yes button");
    }
    static async clickOnLogoutButton()
    {
        await z.click(await TMSLmt.getElement(Login_TMSObj.LOGOUT_BUTTON))
        logger.info("Clicked on log out button");
    }
    static async waitForLoadingSymbolNotDisplayed() {
        await z.waitForInvisible(await TMSLmt.getElement(Login_TMSObj.LOADING_SPINNER), prop.CONDITIONAL_WAIT);
        logger.info("Waited for Loading Symbol to go off");
    }
    static async addingquicklink()
    {
        await z.click(await TMSLmt.getElement(Login_TMSObj.Quick_Link_button));
        await z.click(await TMSLmt.getElement(Login_TMSObj.Customize_button));
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.Search_Field),await TMSLmt.getData("SearchforProductQlink"));
        await z.click(await TMSLmt.getElement(Login_TMSObj.Clickon_TMS_button));
        await z.click(await TMSLmt.getElement(Login_TMSObj.Clickon_Apply_button));
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);        
    }
    static async checkingquicklinkadded()
    {
        await z.click(await TMSLmt.getElement(Login_TMSObj.Quick_Link_button));
        await z.click(await TMSLmt.getElement(Login_TMSObj.Quick_TMS_Menu));
        await z.switchToNextTab();
        await z.waitForVisible(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
        await z.switchToPreviousTab();
    }
    static async removingquicklinkadded()
    {
        await z.click(await TMSLmt.getElement(Login_TMSObj.Quick_Link_button));
        await z.click(await TMSLmt.getElement(Login_TMSObj.Customize_button));
        await z.fillField(await TMSLmt.getElement(Login_TMSObj.Search_Field),await TMSLmt.getData("SearchforProductQlink"));
        await z.click(await TMSLmt.getElement(Login_TMSObj.Clickon_TMS_button));
        await z.click(await TMSLmt.getElement(Login_TMSObj.Clickon_Apply_button));
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        await z.click(await TMSLmt.getElement(Login_TMSObj.Quick_Link_button));
        await z.dontSee(await TMSLmt.getData("SearchforProductQlink"));
    }

}