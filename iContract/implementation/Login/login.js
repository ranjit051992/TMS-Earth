const {I} = inject();
const commonLandingPage = require("../../POM/CommonLandingPage/commonLandingAction");
const login = require("../../POM/Login/loginFlow");
const lmt = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger")
// const a = require("../../eProc/Login")


When("user is logged in to the application", () => {
    I.amOnPage(global.confi_prop.url);
    login.enterUserName();
    login.enterPassword();
    login.clickOnLogin();    
})

Then("User is landed on common landing page", ()=>{
    //getLocale() API 
    // global.lang = I.grabAttributeFrom("//html", "lang")
    // console.log("language of the application"+global.lang);
    // console.log(lmt.getLabel("Display_Header"));

    I.see(lmt.getLabel("Display_Header"));
})