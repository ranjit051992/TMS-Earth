const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const dbKeys = require("../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const loginImpl = require("./LoginImpl");
const prop=require("../../../Framework/PropertiesConfigurator");
const commonUtils = require("../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');


Given("I am logged in eProc", function () {
    loginImpl.login();
});