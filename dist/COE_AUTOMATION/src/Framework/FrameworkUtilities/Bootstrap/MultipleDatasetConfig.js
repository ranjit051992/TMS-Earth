// import parser from "mssql-connection-string";
// import { logger } from "../Logger/logger";
// import { prop } from "../config";
// const tableName="DataSetConfiguration";
// const mysql = require('mysql');
// export class MultipleDatasetConfig {
//     static async   getDataSetnumberFromDB(){
//         if(process.env.SETNUMBET){
//             prop.setNumber= process.env.SETNUMBER;
//           }
//           else{
//         const connectionString = "Data Source=tcp:"+prop.DBhost+",3306;Initial Catalog="+prop.DBdatabase+";User Id="+prop.DBuser+";Password="+prop.DBpassword+";";
//         logger.info("connectionString  : " + connectionString)
//         const connectionObj = parser(connectionString);
//         const connection = mysql.createConnection(connectionObj);
//         const query=`select ${process.env.SETUP} from ${tableName}`;
//         console.log(query)
//         await connection.query(query, async function (error,rows,fields ) {
//            if(!!error){
//              logger.info("Error in the query1");
//              logger.info(error)
//              connection.destroy();
//            }else{
//              logger.info("Success");
//                 for (let [key, value ]  of Object.entries(rows[0])) {
//                     logger.info(key);
//                     logger.info(value as string);
//                     let a:any=value
//                     prop.setNumber= (a>prop.maxSetNumber || a==prop.maxSetNumber ? prop.setNumber :++a).toString();
//             }
//              connection.destroy();
//             }})}
//     }
//     static async resetSetnumberInDB(){
//         const connectionString = "Data Source=tcp:"+prop.DBhost+",3306;Initial Catalog="+prop.DBdatabase+";User Id="+prop.DBuser+";Password="+prop.DBpassword+";";
//         logger.info("connectionString  : " + connectionString)
//         const connectionObj = parser(connectionString);
//         const connection = mysql.createConnection(connectionObj);
//         const query=`UPDATE ${tableName} SET ${process.env.SETUP}=${prop.setNumber}`;
//         console.log(query)
//         await connection.query(query, async function (error) {
//            if(!!error){
//              logger.info("Error in the query1");
//              logger.info(error)
//              connection.destroy();
//            }else{
//              logger.info("Success");
//              connection.destroy();
//             }});
//         }
// }
