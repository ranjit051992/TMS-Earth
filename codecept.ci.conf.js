const parsing = require("./Framework/PropertiesConfigurator");
const addTimeStampToReport = require('./add_timestamp_report');
addTimeStampToReport();
parsing();
const prop = global.confi_prop;
console.log(prop)
global.lang = 'en';
exports.config = {
  tests: "./*_test.js",
  output: "./output",
  helpers: {
    WebDriver: {
      url: prop.url,
      browser: prop.browser,
      host: prop.host,
      // port: prop.port,
      restart: prop.restart,
      windowSize: prop.windowSize,
      waitForTimeout: 30000,
      default_low_wait: prop.DEFAULT_LOW_WAIT,
      default_medium_wait: prop.DEFAULT_MEDIUM_WAIT,
      default_high_wait: prop.DEFAULT_HIGH_WAIT,
      desiredCapabilities: {
        pageLoadStrategy: 'none',
        'selenoid:options': {
          enableVNC: true,
          enableVideo: false
        }
      }


    },
    ChaiWrapper:
    {
      require: "codeceptjs-chai"
    },
    // ChaiWrapper:
    // {
    //   require: "codeceptjs-chai"
    // },
    MyHelper:
    {
      require: "./Framework/CustomHelper/myHelper.js",
    },
  },
  bootstrap: "./bootstrap.js",
  bootstrapAll : "./bootstrap.js",
  teardownAll: "./get_all_reports.js",
  include: {
    I: prop.stepFilePath,
  },
  multiple: {
    parallel: {
      // Splits tests into 2 chunks
      chunks: 5
    }
  },
  gherkin: {
    features: "./DD_Homes/features/**/*.feature",
    steps: "./DD_Homes/implementation/**/*.js"
  },
  name: prop.projectName,
  plugins: {
    retryFailedStep: {
      enabled: true
    },
    screenshotOnFail: {
      enabled: true
    },
    wdio: {
      enabled: true,
      // services: ["selenium-standalone"]
    },
    allure: {
      enabled: true
    },
    autoDelay: {
      enabled: true,
      delayBefore: 500,
      delayAfter: 500,
      methods: ["click", "fillField", "checkOption"]
    }
  }
};