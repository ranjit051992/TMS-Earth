"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const recorder = require("codeceptjs").recorder;
const request = require("request");
const codeceptjs_1 = require("codeceptjs");
const console_1 = __importDefault(require("console"));
const Jiralogging_1 = require("../Jiralogging/Jiralogging");
const xray_ImportFeature_Request_1 = require("../Xray_Api/xray_ImportFeature_Request");
const jsesc = require("jsesc");
const moment = require("moment");
let errorOccured = false;
const JiraloggingFlag = (process.env.JiraloggingFlag == "true");
const TestExecutionFlag = (process.env.TestExecutionFlag == "true");
let info = "";
let tests = "";
let json;
const promises = [];
const promisesfirst = [];
const config = {
    debug: false,
    jira_url: "https://localhost:8080",
    jira_user: "root",
    jira_password: "root",
    test_revison: "001",
    testEnvironments: "[\"browser:chrome\", \"linux\"]",
};
class eventListener {
    static async init() {
        // event.dispatcher.on(event.all.before, async function(suite) {
        //   console.log("--- I COE all before ---");
        //   if (process.env.storyNo) {
        //     console.log("updating the linking");
        //     Jiralogger.updateissue(process.env.storyNo);
        //   }
        // });
        codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.started, async function () {
            console_1.default.log("--- I COE before test --");
        });
        codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.after, async function (test) {
            console_1.default.log("--- I COE after test --", test.tags[0]);
            let status;
            let comment;
            let defect;
            if (test.state == "passed") {
                status = "PASSED";
                comment = "Successful execution";
                promises.push(new Promise(async (resolve, reject) => {
                    if (tests.length < 1) {
                        if (process.env.testPlanKey) {
                            info = "{ \"info\" : { \"summary\" :\"Sample summary\", \"startDate\" : \"" + moment().format() + "\", \"finishDate\" :\"" + moment().format() + "\",\"revision\": \"" + config.test_revison + "\",\"description\" : \"Results of test execution \", \"testPlanKey\" : \"" + process.env.testPlanKey + "\"},";
                        }
                        else {
                            info = "{ \"info\" : { \"summary\" :\"Sample summary\", \"startDate\" : \"" + moment().format() + "\", \"finishDate\" :\"" + moment().format() + "\",\"revision\": \"" + config.test_revison + "\",\"description\" : \"Results of test execution \" " + "},";
                        }
                        tests = "\"tests\" : [";
                        tests = tests + "" + "{\"testKey\":\"" + (test.tags[1].split("@")[1]).split("_")[1] + "\",\"status\":\"" + status + "\",\"comment\" : \"" + comment + "\" }";
                        resolve(tests);
                    }
                    else {
                        tests = tests + "" + ",{\"testKey\":\"" + (test.tags[1].split("@")[1]).split("_")[1] + "\",\"status\":\"" + status + "\",\"comment\" : \"" + comment + "\" }";
                        resolve(tests);
                    }
                }));
            }
            else {
                status = "FAILED";
                promises.push(new Promise(async (resolve, reject) => {
                    await Jiralogging_1.Jiralogger.logJira(test.title, test.parent.title, test.err.stack, JiraloggingFlag).then(async function (json) {
                        comment = jsesc(test.err.toString().replace(/\"/g, "")
                            .replace(/\'/g, "")
                            .replace(/\é/g, "e")
                            .replace(/\è/g, "e")
                            .replace(/\ê/g, "e")
                            .replace(/\à/g, "a")
                            .replace(/\ù/g, "u")
                            .replace(/\x1B/g, "")
                            .replace(/\[\d*[m]/g, ""));
                        console_1.default.log(comment);
                        if (json) {
                            defect = "[\"" + json["key"] + "\"]";
                        }
                        else {
                            defect = "[]";
                        }
                        if (tests.length < 1) {
                            if (process.env.testPlanKey) {
                                info = "{ \"info\" : { \"summary\" :\"Sample summary\", \"startDate\" : \"" + moment().format() + "\", \"finishDate\" :\"" + moment().format() + "\",\"revision\": \"" + config.test_revison + "\",\"description\" : \"Results of test execution \", \"testPlanKey\" : \"" + process.env.testPlanKey + "\"},";
                            }
                            else {
                                info = "{ \"info\" : { \"summary\" :\"Sample summary\", \"startDate\" : \"" + moment().format() + "\", \"finishDate\" :\"" + moment().format() + "\",\"revision\": \"" + config.test_revison + "\",\"description\" : \"Results of test execution \" " + "},";
                            }
                            tests = "\"tests\" : [";
                            tests = tests + "" + "{\"testKey\":\"" + (test.tags[1].split("@")[1]).split("_")[1] + "\",\"status\":\"" + status + "\",\"comment\" : \"" + comment + "\",\"defects\" : " + defect + " }";
                            resolve(tests);
                        }
                        else {
                            tests = tests + "" + ",{\"testKey\":\"" + (test.tags[1].split("@")[1]).split("_")[1] + "\",\"status\":\"" + status + "\",\"comment\" : \"" + comment + "\",\"defects\" : " + defect + " }";
                            resolve(tests);
                        }
                    });
                }));
            }
        });
        codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.before, async function (test, err) {
            global.scenarioName = test.title;
            global.moduleName = test.parent.title;
        });
        codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.failed, async function (test, e) {
            errorOccured = true;
            console_1.default.log("--- I COE failed test --" + errorOccured);
        });
        codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.test.finished, async function (test, err) {
            console_1.default.log("--- I COE finished test --" + errorOccured + "  ==  " + JiraloggingFlag);
            /* promisesfirst.push(new Promise(async (resolve, reject) => {
                 if (errorOccured && JiraloggingFlag) {
                   json = await Jiralogger.logJira(test.title, test.parent.title, test.err.stack)
                   console.log("Jira bug ID ", json)
                   resolve(json)
                 }
               })) */
        });
        codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.all.after, async function (suite) {
            console_1.default.log("--- I COE all after --- ");
            if (TestExecutionFlag) {
                console_1.default.log("Logging a test execution ticket in jira");
                Promise.all(promises).then(async (testcases) => {
                    console_1.default.log("SEND TO XRAY=>" + info + tests + "]}");
                    if (config.debug)
                        console_1.default.log("SEND TO XRAY=>" + info + tests + "]}");
                    recorder.add("Sending new result to xray", async function () {
                        return new Promise(async (doneFn, errFn) => {
                            await xray_ImportFeature_Request_1.xray_ImportCucumberApiRequest.generateAuthToken().then(async function (authToken) {
                                const finalToken = "Bearer " + authToken.replace(/(\")/gm, "");
                                const options = {
                                    "method": "POST",
                                    "url": "https://xray.cloud.xpand-it.com/api/v1/import/execution",
                                    "headers": {
                                        "Content-Type": "application/json",
                                        "Authorization": finalToken,
                                    },
                                    "body": info + tests + "]}",
                                };
                                request(options, async function (error, response) {
                                    if (error)
                                        doneFn(error);
                                    else {
                                        console_1.default.log(response.body);
                                        await Jiralogging_1.Jiralogger.updateIssueLink((JSON.parse(response.body))["key"]).then(async function (linkStatus) {
                                            console_1.default.log("After update call");
                                            doneFn(response.body);
                                        });
                                    }
                                });
                            });
                        });
                    });
                });
            }
        });
        codeceptjs_1.event.dispatcher.on(codeceptjs_1.event.suite.after, (suite) => {
            console_1.default.log("----- After suite-------");
        });
    }
}
exports.eventListener = eventListener;
