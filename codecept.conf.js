


const LOGIN_URL = 'http://login-rp.zycus.com/';
const REST_API_URL = "https://dewdrops-rp.zycus.com";
const BROWSER ='chrome';

exports.config = {
 
  tests: './*_test.js',
  output: './output',
  helpers: {
    WebDriver: {
      url: LOGIN_URL,
      browser: BROWSER,
      host: '127.0.0.1',
      port: 4444,
      restart: false,
      windowSize: 'maximize',
      waitForTimeout: 30000,
    }, 
    "ChaiWrapper" : 
    {
      "require": "codeceptjs-chai"
    }
  },

  include: {
    I: './steps_file',
    ...require('./automation/Framework/Include')
  },

  gherkin: {
    features: './automation/eproc/features/**/**/**.feature',
    steps: './automation/eproc/implementation/**/**/**.js'
  },  

  name: 'BDD_UI_Automation',
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