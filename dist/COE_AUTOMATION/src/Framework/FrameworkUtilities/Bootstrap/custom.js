"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const PropertiesConfigurator_1 = require("../../PropertiesConfigurator/PropertiesConfigurator");
const logger_1 = require("../Logger/logger");
const prop = require("../../../../../../dist/Framework/FrameworkUtilities/config").prop;
const InfraDetails_1 = require("./InfraDetails");
const eventListeners_1 = require("../../CustomHelper/eventListeners");
const FailureAnalyzer_1 = require("../FailureAnalyzer/FailureAnalyzer");
const FAEventListener_1 = require("../FailureAnalyzer/FAEventListener");
class coeBootstrap {
    static async boot_COE() {
        eventListeners_1.eventListener.init();
        FAEventListener_1.eventListener();
    }
    static async bootAll_COE() {
        await PropertiesConfigurator_1.parseJson();
        logger_1.logger.info("inside bootstrapAll");
        //Failure Analyzer
        // eventListenerFA();
        await FailureAnalyzer_1.FailureAnalyzer.createJsonFile();
        //Fetch Infra Details
        await InfraDetails_1.InfraDetails.clearFile();
        logger_1.logger.info("inside bootstrapAll");
        let now = new Date();
        now = new Date(now.toLocaleString('en-US', { timeZone: 'Asia/Kolkata' }));
        prop.executionStartTime = `${String(now.getFullYear())}-${String(now.getMonth() + 1)}-${String(now.getDate())} ${String(now.getHours())}:${String(now.getMinutes())}:${String(now.getSeconds())}`;
        console.log("Execution start time " + prop.executionStartTime);
    }
    static async tear_COE() {
    }
}
exports.coeBootstrap = coeBootstrap;
