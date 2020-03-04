require("./Framework/PropertiesConfigurator");


const prop=global.confi_prop;
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
      default_low_wait: prop.DEFAULT_LOW_WAIT,
      default_medium_wait: prop.DEFAULT_MEDIUM_WAIT,
      default_high_wait: prop.DEFAULT_HIGH_WAIT,
      smartWait: 5000,
      timeouts: {
        "script": 10000,
        "page load": 10000
      }
    }, 
    "ChaiWrapper" : 
    {
      "require": "codeceptjs-chai"
    },
    MyHelper: 
    {
       require: "./Framework/CustomHelper/myHelper.js",
    },

  },
  bootstrap: "./bootstrap.js",
  include: {
    I: prop.stepFilePath,
  },
  multiple: {
    sanity: {
       //grep:"",
          chunks: 1
        },
    Regression:{
      // grep:"@Regression",
          chunks: 2
    }
      },
  gherkin: {
    features: "./eInvoice/features/Invoice/**.feature",
    steps: "./eInvoice/implementation/**/**.js"
}, 
  name: prop.projectName,
  plugins: {
    retryFailedStep: {
      enabled: true
    },
    screenshotOnFail: {
      enabled: true
    },
    wdio:{
      enabled:true,
      services:["selenium-standalone"]
  }
  }
};