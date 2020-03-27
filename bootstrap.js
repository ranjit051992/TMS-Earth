const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const lmtVar = require("./Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("./Framework/FrameworkUtilities/Logger/logger");
const prop = global.confi_prop;
const fs = require('fs');
const path = require('path');


module.exports = {

        bootstrap: async function () {
                global.testData = await databaseOperations.getTestData();
                global.uiElements = await databaseOperations.getUiElementXpath();
                global.users = await databaseOperations.getUser();
                // if(process.env.GRID) {
                //         global.users = await databaseOperations.getAndUpdateUser();
                // }
                // else {
                //          logger.info(`Using local credentials --> ${prop.USERNAME} / ${prop.PASSWORD}`);
                //         let testDataMap = new Map();
                //          testDataMap.set("USERNAME", prop.USERNAME);
                //          testDataMap.set("PASSWORD", prop.PASSWORD);
                //          global.users = testDataMap;
                // }
                //  global.lmt = await databaseOperations.getLMTDetails();
                //  global.allkeys = await databaseOperations.getLMTKeys();
                //  logger.info(" for this Chunk USERNAME  : " + global.users.get("USERNAME"));
        },
        teardown: async function () {

                // I.click("//dew-dropdown[contains(@class,'profile')]")
                // I.click("Logout")
                // I.wait(2)
                // if(prop.runOnGrid) {
                // await databaseOperations.updateUSER(global.users.get("USERNAME"),"true");
                // }
        },
        bootstrapAll: async function () {

                const outputDir = path.resolve(__dirname, "./output/environment.properties")
                const setup = "Setup=" + process.env.SETUP;
                const product = "Product=" + process.env.PRODUCT;
                const Tenant = "Tenant=" + process.env.TENANT;
                fs.writeFile(outputDir, setup + "\n" + product + "\n" + Tenant, function (err) {
                        if (err) throw err;
                        console.log('Environment Properties File Created');
                });
        },
        teardownAll: async function () {
                console.log("inside tearDownAll ");
        }
}