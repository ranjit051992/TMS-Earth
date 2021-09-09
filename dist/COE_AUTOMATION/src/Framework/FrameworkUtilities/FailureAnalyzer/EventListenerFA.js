"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const codeceptjs_1 = require("codeceptjs");
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
        // console.log("------listener before test------");
        // await FailureAnalyzer.testBefore(test);
    });
    codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.failed, function (test, error) {
        // console.log("------listener failed test------");
        // FailureAnalyzer.testFailed(test, error);
        // recorder.add("test recorder started", async () => {
        //     console.log("------listener failed test recorder started------");
        //     await FailureAnalyzer.setBrowserConsolePageSourceIssueType(test, error);
        //     console.log("------listener failed test recorder ended------");
        // });
    });
    codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.after, async function (test) {
        // console.log("------listener after test------");
        // await FailureAnalyzer.testAfter(test);
    });
    // }
}
exports.eventListener = eventListener;
