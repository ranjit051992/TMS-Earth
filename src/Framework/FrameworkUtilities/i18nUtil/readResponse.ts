// var Request = require("request");
// const logger = require("../Logger/logger")
// // import { logger } from "../Logger/logger";
// // import "request";

// class readResponse{

//     getDetails(){
//         process.env['NODE_TLS_REJECT_UNAUTHORIZED'] = 0;
//         Request.get("https://dewdrops-qcvw.zycus.net/icontract/api/a/dd/users/getDetails", (error, response, body) =>{
//         if(error){
//             logger.info(error);
//             return console.log(error);
            
//         }
//         // logger.info(JSON.parse(body));
//         console.log("response of get details API     "+response.statusCode);
//         console.log("Response body of the getDetails API     "+ body + "\n" + JSON.parse(body));

//         })
//     }

//     getlangJson(){
//         process.env['NODE_TLS_REJECT_UNAUTHORIZED'] = 0 ;Number;
//         Request.get("https://dewdrops-qcvw.zycus.net/icontract/lmt/translations/iContract/en_US.json", (error, response, body) =>{
//         if(error){
//             logger.info(error);
//             return console.log(error);
            
//         }
//         // logger.info(JSON.parse(body));
//         console.log("response of get details API     "+response.statusCode);
//         console.log("Response body of the getDetails API     "+ body + "\n" + JSON.parse(body));

//         })
//     }

// }

// module.exports = new readResponse;