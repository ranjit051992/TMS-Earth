require("source-map-support").install();

const path =require('path');
const startup = require("./dist/Framework/FrameworkUtilities/Startup/Startup").Startup;
const prop = require("./dist/Framework/FrameworkUtilities/config").prop;
const PropertiesConfigurator = require("./dist/Framework/PropertiesConfigurator/PropertiesConfigurator");
//const addTimeStampToReport = require('./add_timestamp_report');
const coeStartup = require("./dist/COE_AUTOMATION/src/Framework/FrameworkUtilities/Startup/Startup").Startup;
const addTimeStampToReport = require('./src/COE_AUTOMATION/add_timestamp_report');
const customChunks = require('./src/COE_AUTOMATION/customChunk');
require("./dist/COE_AUTOMATION/src/Framework/FrameworkUtilities/FailureAnalyzer/EventListenerFA").eventListener();
prop.enableInfraDetailsScript=true;

addTimeStampToReport();
PropertiesConfigurator.parseJson();

startup.lang = 'en'
require("failureanalyzer/EventListenerFA").eventListener();
prop.dir=__dirname;

exports.config = {
  tests: "./*_test.js",
  output: "./output",
  helpers: {
    WebDriver: {
      url: prop.url,
      browser: prop.browser,
      host: prop.host,
      port: prop.port,
      restart: prop.restart,
      windowSize: prop.windowSize,
      waitForTimeout: 90000,
      smartWait: 5000,
      timeouts: {
        "script": 10000,
        "page load": 10000
      },
      default_low_wait: prop.DEFAULT_LOW_WAIT,
      default_medium_wait: prop.DEFAULT_MEDIUM_WAIT,
      default_high_wait: prop.DEFAULT_HIGH_WAIT,
      desiredCapabilities: {
        pageLoadStrategy: 'none',
        'selenoid:options': {
          sessionTimeout: "120s",
          enableVNC: false,
          enableVideo: false
        },
        chromeOptions: {
          args: ["--disable-gpu", "--no-sandbox", "--ignore-certificate-errors"],
        }
      }
    },
    REST: {timeout:30000},
    ChaiWrapper:
    {
      require: "codeceptjs-chai"
    },
    MyHelper:
    {
      require: "./dist/Framework/CustomHelper/myHelper.js",
    },
    REST: {timeout:30000},
    CoeHelper:
    { 
    require: "./dist/COE_AUTOMATION/src/Framework/CustomHelper/CoeHelper.js",
    },
    REST: {timeout:30000},
  },
  bootstrapAll: "./dist/Framework/FrameworkUtilities/Bootstrap/bootstrap.js",
  bootstrap: "./dist/Framework/FrameworkUtilities/Bootstrap/bootstrap.js",
  teardown: "./dist/Framework/FrameworkUtilities/Bootstrap/bootstrap.js",
  //teardownAll: "./get_all_reports.js",
  teardownAll: "./src/COE_AUTOMATION/get_all_reports.js",
  include: {
    I: prop.stepFilePath,
  },
  multiple: {
    parallel: {
      // Splits tests into 2 chunks
      chunks: 1
    }
  },
  gherkin: {
    features: "./src/TMS/features/**/*.feature",
    steps: "./dist/TMS/implementation/**/*.js"
  },

  name: prop.projectName,
  plugins: {
    retryFailedStep: {
      enabled: true
    },
    screenshotOnFail: {
      enabled: true
    },
/*     wdio: {
      enabled: true,
      services: ["selenium-standalone"]
    }, */
    allure: {
      enabled: true
    },
    autoDelay: {
      enabled: true,
      delayBefore: 500,
      delayAfter: 500,
      methods: ["click", "fillField", "checkOption"]
    },
    require: ["ts-node/register"]
  }
};