const error = require('codeceptjs').output.error;
const recorder = require('codeceptjs').recorder;
const event = require('codeceptjs').event;
const Jiralogger = require("../Jiralogging/Jiralogging")
let currentTest;
let currentHook;
let errorOccured = false;
let JiraloggingFlag = process.env.JiraloggingFlag || global.confi_prop.JiraloggingFlag;

async function init() {

  event.dispatcher.on(event.test.started, async function () {
    console.log('--- I am before test --');

  })

  event.dispatcher.on(event.test.after, async function () {
    console.log('--- I am after test --');

  })

  event.dispatcher.on(event.test.failed, async function (test, e) {
    errorOccured = true;
    console.log('--- I am failed test --' + errorOccured);
  })

  event.dispatcher.on(event.test.finished, async function (test, err) {
    // currentTest = null
    console.log('--- I am finished test --' + errorOccured +"  ==  "+ JiraloggingFlag);
    // console.log("==================================================")
    if(errorOccured & JiraloggingFlag){
      // console.log("Cucumber step that failed "+test.title);
      // console.log("Cucumber feature name along wth the tag"+test.parent.title)
      // console.log("Error  "+test.err);
      // console.log("previous Step "+test.err.stack);
      await Jiralogger.logJira(test.title, test.parent.title, test.err.stack);
    }
  })

  event.dispatcher.on(event.suite.after, (suite) => {
    console.log("----- After suite-------")
  });
}

module.exports = { init }