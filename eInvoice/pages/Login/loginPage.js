// const I = actor();
const {I} = inject();
const iLogin = require("./Ilogin");
module.exports = {
    login(userName, password) {
        I.amOnPage('/home/#/auth');
        I.fillField(global.uiElements.get(iLogin.email), userName);
        I.fillField(global.uiElements.get(iLogin.password), password);
        I.click(global.uiElements.get(iLogin.loginButton));
    }
}