const recorder = require("codeceptjs").recorder;
const request = require("request");
import { event } from "codeceptjs";
import console from "console";
import { Jiralogger } from "../Jiralogging/Jiralogging";
const jsesc = require("jsesc");
const moment = require("moment");
let errorOccured = false;
const JiraloggingFlag = (process.env.JiraloggingFlag == "true");
const TestExecutionFlag = (process.env.TestExecutionFlag == "true");
let info = "";
let tests = "";
let json: any;
const promises: any = [];
const promisesfirst: any = [];
const config = {
  debug: false,
  jira_url: "https://localhost:8080",
  jira_user: "root",
  jira_password: "root",
  test_revison: "001",
  testEnvironments: "[\"browser:chrome\", \"linux\"]",
};
export class eventListener {
  static async init() {
    // event.dispatcher.on(event.all.before, async function(suite) {
    //   console.log("--- I am all before ---");
    //   if (process.env.storyNo) {
    //     console.log("updating the linking");
    //     Jiralogger.updateissue(process.env.storyNo);
    //   }
    // });
    event.dispatcher.on(event.test.started, async function() {
      console.log("--- I am before test --");
    });

    event.dispatcher.on(event.test.after, async function(test) {
      console.log("--- I am after test --", test.tags[0]);
      let status: any;
      let comment: any;
      let defect: any;
      if (test.state == "passed") {
        status = "PASSED";
        comment = "Successful execution";
        promises.push(new Promise(async (resolve, reject) => {
          if (tests.length < 1) {
            if (process.env.testPlanKey) {
              info = "{ \"info\" : { \"summary\" :\"Sample summary\", \"startDate\" : \"" + moment().format() + "\", \"finishDate\" :\"" + moment().format() + "\",\"revision\": \"" + config.test_revison + "\",\"description\" : \"Results of test execution \", \"testPlanKey\" : \"" + process.env.testPlanKey + "\"},";
            } else {
              info = "{ \"info\" : { \"summary\" :\"Sample summary\", \"startDate\" : \"" + moment().format() + "\", \"finishDate\" :\"" + moment().format() + "\",\"revision\": \"" + config.test_revison + "\",\"description\" : \"Results of test execution \" " + "},";
            }

            tests = "\"tests\" : [";
            tests = tests + "" + "{\"testKey\":\"" + (test.tags[1].split("@")[1]).split("_")[1] + "\",\"status\":\"" + status + "\",\"comment\" : \"" + comment + "\" }";
            resolve(tests);
          } else {
            tests = tests + "" + ",{\"testKey\":\"" + (test.tags[1].split("@")[1]).split("_")[1] + "\",\"status\":\"" + status + "\",\"comment\" : \"" + comment + "\" }";
            resolve(tests);
          }
        }));
      } else {
        status = "FAILED";
        promises.push(new Promise(async (resolve, reject) => {
          await Jiralogger.logJira(test.title, test.parent.title, test.err.stack, JiraloggingFlag).then(async function(json: any) {
            comment = jsesc(test.err.toString().replace(/\"/g, "")
              .replace(/\'/g, "")
              .replace(/\é/g, "e")
              .replace(/\è/g, "e")
              .replace(/\ê/g, "e")
              .replace(/\à/g, "a")
              .replace(/\ù/g, "u")
              .replace(/\x1B/g, "")
              .replace(/\[\d*[m]/g, ""));
            console.log(comment);
            if (json) {
              defect = "[\"" + json["key"] + "\"]";
            } else {
              defect = "[]";
            }
            if (tests.length < 1) {
              if (process.env.testPlanKey) {
                info = "{ \"info\" : { \"summary\" :\"Sample summary\", \"startDate\" : \"" + moment().format() + "\", \"finishDate\" :\"" + moment().format() + "\",\"revision\": \"" + config.test_revison + "\",\"description\" : \"Results of test execution \", \"testPlanKey\" : \"" + process.env.testPlanKey + "\"},";
              } else {
                info = "{ \"info\" : { \"summary\" :\"Sample summary\", \"startDate\" : \"" + moment().format() + "\", \"finishDate\" :\"" + moment().format() + "\",\"revision\": \"" + config.test_revison + "\",\"description\" : \"Results of test execution \" " + "},";
              }

              tests = "\"tests\" : [";
              tests = tests + "" + "{\"testKey\":\"" + (test.tags[1].split("@")[1]).split("_")[1] + "\",\"status\":\"" + status + "\",\"comment\" : \"" + comment + "\",\"defects\" : " + defect + " }";
              resolve(tests);
            } else {
              tests = tests + "" + ",{\"testKey\":\"" + (test.tags[1].split("@")[1]).split("_")[1] + "\",\"status\":\"" + status + "\",\"comment\" : \"" + comment + "\",\"defects\" : " + defect + " }";
              resolve(tests);
            }
          });
        }));
      }
    });

    event.dispatcher.on(event.test.failed, async function(test, e) {
      errorOccured = true;
      console.log("--- I am failed test --" + errorOccured);
    });

    event.dispatcher.on(event.test.finished, async function(test, err) {
      console.log("--- I am finished test --" + errorOccured + "  ==  " + JiraloggingFlag);
      /* promisesfirst.push(new Promise(async (resolve, reject) => {
           if (errorOccured && JiraloggingFlag) {
             json = await Jiralogger.logJira(test.title, test.parent.title, test.err.stack)
             console.log("Jira bug ID ", json)
             resolve(json)
           }
         })) */
    });

    event.dispatcher.on(event.all.after, async function(suite) {
      console.log("--- I am all after --- ");
      // if (TestExecutionFlag) {
      //   console.log("Logging a test execution ticket in jira");
      //   Promise.all(promises).then(async (testcases: any) => {
      //     console.log("SEND TO XRAY=>" + info + tests + "]}");
      //     if (config.debug) console.log("SEND TO XRAY=>" + info + tests + "]}");
      //     recorder.add("Sending new result to xray", async function() {
      //       return new Promise(async (doneFn, errFn) => {
      //         await xray_ImportCucumberApiRequest.generateAuthToken().then(async function(authToken) {
      //           const finalToken: string = "Bearer " + authToken.replace(/(\")/gm, "");

      //           const options = {
      //             "method": "POST",
      //             "url": "https://xray.cloud.xpand-it.com/api/v1/import/execution",
      //             "headers": {
      //               "Content-Type": "application/json",
      //               "Authorization": finalToken,
      //             },
      //             "body": info + tests + "]}",

      //           };
      //           request(options, async function(error: any, response: any) {
      //             if (error) doneFn(error);
      //             else {
      //               console.log(response.body);
      //               await Jiralogger.updateIssueLink((JSON.parse(response.body))["key"]).then(async function(linkStatus) {
      //                 console.log("After update call");
      //                 doneFn(response.body);
      //               });
      //             }
      //           });
      //         });
      //       });
      //     });
      //   });
      // }
    });
    event.dispatcher.on(event.suite.after, (suite) => {
      console.log("----- After suite-------");
    });
  }
}
