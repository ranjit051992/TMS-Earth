"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const argv = require('minimist')(process.argv.slice(2));
const path = require('path');
const prop = require("../../../../../../dist/Framework/FrameworkUtilities/config").prop;
const fs = require('fs');
const filePath = path.join(prop.dir, 'machineDetails.txt');
const logger_1 = require("../../../Framework/FrameworkUtilities/Logger/logger");
class InfraDetails {
    static async checkIfFileHasContent() {
        console.log("filepath in checkIfFileHasContent " + filePath);
        var stats = fs.statSync(filePath);
        var fileSizeInBytes = stats["size"];
        return fileSizeInBytes;
    }
    static async readFile() {
        let array = new Array();
        console.log("filepath in read filemethod " + filePath);
        fs.readFileSync(filePath, 'utf-8').split(/\r?\n/).forEach(function (line) {
            array.push(line);
        });
        return array;
    }
    static async clearFile() {
        try {
            if (fs.existsSync(filePath)) {
                console.log(filePath + " file exesit ");
                fs.truncate(filePath, 0, function () { console.log('File cleared.'); });
            }
            else {
                fs.closeSync(fs.openSync(filePath, 'w'));
            }
        }
        catch (error) {
            logger_1.logger.info(error);
        }
    }
    static async getDateTime() {
        let now = new Date();
        now = new Date(now.toLocaleString('en-US', { timeZone: 'Asia/Kolkata' }));
        let DateTime = `${String(now.getFullYear())}-${String(now.getMonth() + 1)}-${String(now.getDate())} ${String(now.getHours())}:${String(now.getMinutes())}:${String(now.getSeconds())}`;
        return DateTime;
    }
    static async getHost() {
        const { config } = argv.c
            ? require(path.resolve(process.cwd(), argv.c))
            : require(path.resolve(process.cwd(), './codecept.ci.conf.js'));
        const { helpers, gherkin, multiple, ...restConfig } = config;
        return helpers.WebDriver.host;
    }
}
exports.InfraDetails = InfraDetails;
