const parser = require('mssql-connection-string');
import { Helper } from  "codeceptjs";
import { Startup } from "../FrameworkUtilities/Startup/Startup";
import {prop} from "../FrameworkUtilities/config"
const { I } = inject();
import {generate} from "randomstring";
import { logger } from "../FrameworkUtilities/Logger/logger";
const argv = require('minimist')(process.argv.slice(2))
const path = require('path')
const fs=require("fs")
const filePath=path.join(prop.dir, 'machineDetails.txt')
  let sessionTimeBidning: Map<string,string[]> = new Map()
class MyHelper extends Helper {



  // before/after hooks
  /**
   * @protected
   */
  /*_before() {
    // remove if not used
  }*/

  /**
   * @protected
   */
  /*
  _after() {
    // remove if not used
  }*/
 
  
  
  
  // async writeToFile(string){
  //     let buffer = new Buffer(`${string}\n`);
  
  //     fs.open(filePath, 'a+', function(err, fd) {
  //     if (err) {
  //         throw 'error opening file: ' + err;
  //     }
  
  //     fs.write(fd,buffer, 0, buffer.length, null, function(err) {
  //         if (err) throw 'error writing file: ' + err;
  //         fs.close(fd, function() {
  //             console.log('file written');
  //         })
  //     });
  // });
  //   }
  // async getHost(){
  //     
  //     const {config} = argv.c
  //     ? require(path.resolve(process.cwd(), argv.c))
  //     : require(path.resolve(process.cwd(), './codecept.ci.conf.js'))
  //    const {helpers, gherkin, multiple, ...restConfig} = config
  //   //  const port=helpers.WebDriver.port;
  //   
  //     return helpers.WebDriver.host;
  //   }
  //   
  //   async getSessionID(){
  //     var sessions = this.helpers['WebDriver'].browser; 
  //     return sessions.sessionId ;
  //   }
  //   async getSelenoidMachineIP(){
  //     const ggrIP =await this.getHost();
  //     const helper = this.helpers['REST'];
  //     console.log("ggr ip "+ggrIP)
  //     let res=await helper.sendGetRequest(`http://${ggrIP}:${prop.port}/host/${await this.getSessionID()}`);
  //     console.log(`Response from status api\n${JSON.stringify(res.data)}`);
  //   
  //     let selenoidIpAdress= res.data["Name"]
  //     return selenoidIpAdress;
  //   }
  //   
  
  //   async getDateTime(){
  //     let now = new Date();
  //     now = new Date(now.toLocaleString('en-US',{timeZone:'Asia/Kolkata'}));
  //     let DateTime=`${String(now.getFullYear())}-${String(now.getMonth()+1)}-${String(now.getDate())} ${String(now.getHours())}:${String(now.getMinutes())}:${String(now.getSeconds())}`
  //   
  //   return DateTime;
  
  //   }
  async _before()
       {
  //     let ip=await this.getSelenoidMachineIP();
  //     if(!(sessionTimeBidning.has(ip)))
  //      {
  //        sessionTimeBidning.set(ip,[await this.getDateTime()]);
  //      } 
}
     
    
    async _after() {
  //     let ip=await this.getSelenoidMachineIP();
  //     if(sessionTimeBidning.has(ip)){
  //     let startTime=((sessionTimeBidning.get(ip)) as string[])[0];
  //     if( startTime!=="undefined")
  //     {
  //       let values=new Array();
  //       values.push(startTime,await this.getDateTime());
  //       sessionTimeBidning.set(ip,values);
  //     }
    
  // }
      
    }
  async _afterSuite() 
    {
  //     let map=sessionTimeBidning;
  //     for (let [key, value] of map) {
  //         console.log("key "+key)
  //       console.log("value "+ value);
  //       await this.writeToFile(`${key},${value[0]},${value[1]}`)
  //   }
    }


}

module.exports = MyHelper;