const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const dbKeys = require("../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const loginImpl = require("./LoginImpl");
const prop=global.confi_prop;
const commonUtils = require("../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');


Given("I am logged in eProc", async function () {
    if(!prop.LOGIN_WITH_PASSWORD_MANAGER) {
        loginImpl.login();
    }
    else {
        await loginImpl.loginWithPasswordManager();
    }
});