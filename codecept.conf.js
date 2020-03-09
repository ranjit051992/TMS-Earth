const parsing= require("./Framework/PropertiesConfigurator");
parsing("eProc");
const prop = global.confi_prop;
global.lang = 'en';
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
      waitForTimeout: 30000,
      smartWait: 5000,
      timeouts: {
        "script": 10000,
        "page load": 10000
      },
      default_low_wait: prop.DEFAULT_LOW_WAIT,
      default_medium_wait: prop.DEFAULT_MEDIUM_WAIT,
      default_high_wait: prop.DEFAULT_HIGH_WAIT,
    },
   ChaiWrapper:
    {
      require: "codeceptjs-chai"
    },
    MyHelper:
    {
      require: "./Framework/CustomHelper/myHelper.js",
    },
  },
  bootstrap: "./bootstrap.js",
  teardown: "./bootstrap.js",
  include: {
    I: prop.stepFilePath,
  },
   multiple: {
        sanityCases: {
          // Splits tests into 2 chunks
          chunks: 5
        }
      
      },
    gherkin: {
     //features: './iRequest/features/**/**.feature',
      features: "./eProc/features/**/**/*.feature",
      steps: "./eProc/implementation/**/**/*.js"
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
      services: ["selenium-standalone"]
    },
    allure: {
      enabled: true
    }
  }
};