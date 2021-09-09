"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const codeceptjs_1 = require("codeceptjs");
const FailureAnalyzer_1 = require("./FailureAnalyzer");
async function eventListener() {
    // static async init() {
    // event.dispatcher.on(event.all.before, async function () {
    //     console.log("------listener before all------");
    //     GlobalVars.failureAnalyzer = true;
    //     await FailureAnalyzer.createJsonFile();
    // });
    // event.dispatcher.on(event.all.after, async function () {
    //     console.log("------listener after all------");
    //     await FailureAnalyzer.writeToDb();
    // });
    codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.before, async function (test) {
        // process.env.GO_PIPELINE_NAME = "AutoHealTest";
        // process.env.GO_PIPELINE_COUNTER = "61";
        if (process.env.GO_PIPELINE_NAME) {
            console.log("------listener before test------");
            await FailureAnalyzer_1.FailureAnalyzer.testBefore(test);
        }
    });
    codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.failed, function (test, error) {
        if (process.env.GO_PIPELINE_NAME) {
            console.log("------listener failed test------");
            FailureAnalyzer_1.FailureAnalyzer.testFailed(test, error);
            codeceptjs_1.recorder.add("test recorder started", async () => {
                console.log("------listener failed test recorder started------");
                await FailureAnalyzer_1.FailureAnalyzer.setBrowserConsolePageSourceIssueType(test, error);
                console.log("------listener failed test recorder ended------");
            });
        }
    });
    codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.after, async function (test) {
        if (process.env.GO_PIPELINE_NAME) {
            console.log("------listener after test------");
            await FailureAnalyzer_1.FailureAnalyzer.testAfter(test);
        }
    });
    // }
}
exports.eventListener = eventListener;
