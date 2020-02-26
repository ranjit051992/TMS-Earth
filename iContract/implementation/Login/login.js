const {I} = inject();
const commonLandingPage = require("../../POM/CommonLandingPage/commonLandingAction");
const login = require("../../POM/Login/loginFlow");
const lmt = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger")
const readResponse = require("../../../Framework/FrameworkUtilities/i18nUtil/readResponse")
// const a = require("../../eProc/Login")


When("user is logged in to the application", function ()  {
    I.amOnPage(global.confi_prop.url);
    login.enterUserName();
    login.enterPassword();
    login.clickOnLogin();    
    I.see(lmt.getLabel("Display_Header"));
})

Then("User is landed on common landing page", function(){
    //getLocale() API 
    // global.lang = I.grabAttributeFrom("//html", "lang")
    // console.log("language of the application"+global.lang);
    // console.log(lmt.getLabel("Display_Header"));

    I.see(lmt.getLabel("Display_Header"));
})

Then("User fetches the laguage of the user", function (){
    readResponse.getDetails();
    readResponse.getlangJson();
})