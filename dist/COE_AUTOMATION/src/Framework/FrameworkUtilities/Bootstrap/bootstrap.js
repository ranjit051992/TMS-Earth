"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const FailureAnalyzer_1 = require("../FailureAnalyzer/FailureAnalyzer");
const EventListenerFA_1 = require("../FailureAnalyzer/EventListenerFA");
const logger_1 = require("../Logger/logger");
const config_1 = require("../config");
const InfraDetails_1 = require("./InfraDetails");
const eventListeners_1 = require("../../CustomHelper/eventListeners");
// import { MultipleDatasetConfig } from "./MultipleDatasetConfig";
async function bootstrap() {
    eventListeners_1.eventListener.init();
}
exports.bootstrap = bootstrap;
async function bootstrapAll() {
    logger_1.logger.info("inside bootstrapAll");
    //Failure Analyzer
    EventListenerFA_1.eventListener();
    await FailureAnalyzer_1.FailureAnalyzer.createJsonFile();
    //Fetch Infra Details
    await InfraDetails_1.InfraDetails.clearFile();
    logger_1.logger.info("inside bootstrapAll");
    let now = new Date();
    now = new Date(now.toLocaleString('en-US', { timeZone: 'Asia/Kolkata' }));
    config_1.prop.executionStartTime = `${String(now.getFullYear())}-${String(now.getMonth() + 1)}-${String(now.getDate())} ${String(now.getHours())}:${String(now.getMinutes())}:${String(now.getSeconds())}`;
    console.log("Execution start time " + config_1.prop.executionStartTime);
    //  await MultipleDatasetConfig.getDataSetnumberFromDB();
}
exports.bootstrapAll = bootstrapAll;
async function teardown() {
}
exports.teardown = teardown;
async function teardownAll() {
    // await MultipleDatasetConfig.resetSetnumberInDB(); 
}
exports.teardownAll = teardownAll;
