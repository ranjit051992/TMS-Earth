


const LOGIN_URL = 'http://login-rp.zycus.com/';
const REST_API_URL = "https://dewdrops-rp.zycus.com";
const BROWSER ='chrome';
const prop=require('./Framework/PropertiesConfigurator');
global.confi_prop=prop;
exports.config = {
 
  tests: './*_test.js',
  output: './output',
  helpers: {
    WebDriver: {
      url: prop.url,
      browser: prop.browser,
      host: prop.host,
      port: prop.port.number,
      restart: prop.restart,
      windowSize: prop.windowSize,
      waitForTimeout: 30000,
      default_low_wait: prop.DEFAULT_LOW_WAIT,
      default_medium_wait: prop.DEFAULT_MEDIUM_WAIT,
      default_high_wait: prop.DEFAULT_HIGH_WAIT,
    }, 
    "ChaiWrapper" : 
    {
      "require": "codeceptjs-chai"
    }
  },

  include: {
    I: prop.stepFilePath,
    ...require('./Framework/Include')
  },

  gherkin: {
    features: ['./automation/eproc/features/**/**.feature',
    './automation/eproc/features/**/**/**.feature'
  ],
    steps: ['./automation/eproc/implementation/**/**.js',
    './automation/eproc/implementation/**/**/**.js'],
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
      services:['selenium-standalone']
  }
  }
}