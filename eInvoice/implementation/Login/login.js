const loginPage = require("../../pages/Login/loginPage");

Given('I logged in to the application', function () {
    loginPage.login('auto.zcs2@zycus.com', 'eProc@123');
});