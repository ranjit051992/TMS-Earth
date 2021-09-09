"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const logger_1 = require("../../../Framework/FrameworkUtilities/Logger/logger");
const mysql = require('mysql');
const prop = require("../../../../../../dist/Framework/FrameworkUtilities/config").prop;
const parser = require('mssql-connection-string');
const InfraDetails_1 = require("../../../Framework/FrameworkUtilities/Bootstrap/InfraDetails");
class tearDownAll {
    static async teardownAllMethod() {
        logger_1.logger.info("inside tearDownAll");
        if (await InfraDetails_1.InfraDetails.checkIfFileHasContent() > 1) {
            let runId = `${process.env.PRODUCT}_${process.env.SETUP}_${prop.executionStartTime}`;
            console.log("run id " + runId);
            const connectionString = "Data Source=tcp:192.168.5.221,3306;Initial Catalog=katalon_isource;User Id=iSource;Password=isource@123;";
            logger_1.logger.info("connectionString  : " + connectionString);
            const connectionObj = parser(connectionString);
            const connection = mysql.createConnection(connectionObj);
            const query = `INSERT INTO InfraDetails(ExecutionID,Product,Pipeline_Triggered,Env,Execution_Start_DateTime,Execution_End_DateTime,GGR_IP)
         VALUES('${runId}','${process.env.PRODUCT}','${process.env.GO_PIPELINE_NAME}','${process.env.SETUP}','${prop.executionStartTime}','${await InfraDetails_1.InfraDetails.getDateTime()}','${await InfraDetails_1.InfraDetails.getHost()}');`;
            console.log(query);
            connection.query(query, async function (error) {
                if (!!error) {
                    logger_1.logger.info("Error in the query1");
                    logger_1.logger.info(error);
                    connection.destroy();
                }
                else {
                    logger_1.logger.info("Success");
                    var counter = 0;
                    let array = await InfraDetails_1.InfraDetails.readFile();
                    for (let i = 0; i <= (array.length) - 2; i++) {
                        console.log("array lenght " + array.length);
                        let value = array[i].split(",");
                        console.log(value[1]);
                        const query2 = `INSERT INTO ExecutionMachineDetails(RUN_ID,SelenoidIP,Execution_Start_DateTime,Execution_End_DateTime)
               VALUES('${runId}','${value[0]}','${value[1]}','${value[2]}');`;
                        console.log(query2);
                        connection.query(query2, function (error) {
                            if (error) {
                                logger_1.logger.info("Error in the query2");
                                logger_1.logger.info(error);
                                // break;
                                connection.destroy();
                            }
                            else {
                                logger_1.logger.info("Success");
                                counter = counter + 1;
                                if (counter > array.length - 2) {
                                    console.log("inside else of query2 and before connecxtion.destroy");
                                    connection.destroy();
                                    // break;
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
exports.tearDownAll = tearDownAll;
