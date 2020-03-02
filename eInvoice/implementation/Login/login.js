const loginPage = require("../../pages/Login/loginPage");

Given('I logged in to the application', function () {
    loginPage.login('poorva.qa2@zycus.com', 'Pass@123');
});