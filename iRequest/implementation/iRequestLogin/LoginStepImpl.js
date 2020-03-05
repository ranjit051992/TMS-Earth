const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const dbKeys = require("../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const loginImpl = require("./LoginImpl");
const prop=global.confi_prop;
const commonUtils = require("../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');


Given("logged in on iRequest Page", function () {
    loginImpl.login();
});