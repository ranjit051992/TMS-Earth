const {I}=inject();
const loginAction = require("./loginAction");
// const commonLandingPage = require("./../CommonLandingPage/commonLandingAction");
 
 class loginFlow {
    enterUserName() {
        I.fillField(global.uiElements.get(loginAction.EMAIL_ADDRESS_TEXTBOX), global.confi_prop.username);
    }
     enterPassword() {
        I.fillField(global.uiElements.get(loginAction.PASSWORD_TEXTBOX), global.confi_prop.password);
    } 
    clickOnLogin (){
        I.click(global.uiElements.get(loginAction.LOGIN_BUTTON));
    }
}

module.exports = new loginFlow;
