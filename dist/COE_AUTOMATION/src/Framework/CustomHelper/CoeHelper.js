"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const codeceptjs_1 = require("codeceptjs");
const logger_1 = require("../FrameworkUtilities/Logger/logger");
const prop = require("../../../../../dist/Framework/FrameworkUtilities/config").prop;
const path = require('path');
const fs = require("fs");
const argv = require('minimist')(process.argv.slice(2));
const filePath = path.join(prop.dir, 'machineDetails.txt');
let sessionTimeBidning = new Map();
class CoeHelper extends codeceptjs_1.Helper {
    async writeToFile(string) {
        let buffer = new Buffer(`${string}\n`);
        fs.open(filePath, 'a+', function (err, fd) {
            if (err) {
                throw 'error opening file: ' + err;
            }
            fs.write(fd, buffer, 0, buffer.length, null, function (err) {
                if (err)
                    throw 'error writing file: ' + err;
                fs.close(fd, function () {
                    console.log('file written');
                });
            });
        });
    }
    async getHost() {
        const { config } = argv.c
            ? require(path.resolve(process.cwd(), argv.c))
            : require(path.resolve(process.cwd(), './codecept.ci.conf.js'));
        const { helpers, gherkin, multiple, ...restConfig } = config;
        //  const port=helpers.WebDriver.port;
        return helpers.WebDriver.host;
    }
    async getSessionID() {
        var sessions = this.helpers['WebDriver'].browser;
        console.log("Session id :" + sessions.sessionId);
        return sessions.sessionId;
    }
    async getSelenoidMachineIP() {
        const ggrIP = await this.getHost();
        const helper = this.helpers['REST'];
        console.log("ggr ip " + ggrIP);
        console.log(`http://${ggrIP}:${prop.port}/host/${await this.getSessionID()}`);
        let res = await helper.sendGetRequest(`http://${ggrIP}:${prop.port}/host/${await this.getSessionID()}`);
        console.log(`Response from status api\n${JSON.stringify(res.data)}`);
        let selenoidIpAdress = res.data["Name"];
        return selenoidIpAdress;
    }
    async getDateTime() {
        let now = new Date();
        now = new Date(now.toLocaleString('en-US', { timeZone: 'Asia/Kolkata' }));
        let DateTime = `${String(now.getFullYear())}-${String(now.getMonth() + 1)}-${String(now.getDate())} ${String(now.getHours())}:${String(now.getMinutes())}:${String(now.getSeconds())}`;
        return DateTime;
    }
    async _beforeSuite() {
    }
    async _before() {
        logger_1.logger.info("------COE Before hook------");
        if (prop.enableInfraDetailsScript === true) {
            let ip = await this.getSelenoidMachineIP();
            if (!(sessionTimeBidning.has(ip))) {
                sessionTimeBidning.set(ip, [await this.getDateTime()]);
            }
        }
    }
    async _after() {
        logger_1.logger.info("------COE After hook------");
        if (prop.enableInfraDetailsScript === true) {
            let ip = await this.getSelenoidMachineIP();
            if (sessionTimeBidning.has(ip)) {
                let startTime = (sessionTimeBidning.get(ip))[0];
                if (startTime !== "undefined") {
                    let values = new Array();
                    values.push(startTime, await this.getDateTime());
                    sessionTimeBidning.set(ip, values);
                }
            }
        }
    }
    async _afterSuite() {
        logger_1.logger.info("------COE After Suite hook------");
        if (prop.enableInfraDetailsScript === true) {
            let map = sessionTimeBidning;
            for (let [key, value] of map) {
                console.log("key " + key);
                console.log("value " + value);
                if (value[0] && value[1] !== "undefined") {
                    await this.writeToFile(`${key},${value[0]},${value[1]}`);
                }
            }
        }
    }
    async triggerDragAndDrop(selectorDrag, selectorDrop) {
        const helper = await this.helpers.WebDriver;
        return await helper.executeScript(function (selectorDrag, selectorDrop) {
            // function for triggering mouse events
            var fireMouseEvent = function (type, elem, centerX, centerY) {
                var evt = document.createEvent('MouseEvents');
                evt.initMouseEvent(type, true, true, window, 1, 1, 1, centerX, centerY, false, false, false, false, 0, elem);
                elem.dispatchEvent(evt);
            };
            // fetch target elements
            var elemDrag = document.evaluate(selectorDrag, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
            var elemDrop = document.evaluate(selectorDrop, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
            if (!elemDrag || !elemDrop)
                return false;
            // calculate positions
            var pos = elemDrag.getBoundingClientRect();
            var center1X = Math.floor((pos.left + pos.right) / 2);
            var center1Y = Math.floor((pos.top + pos.bottom) / 2);
            pos = elemDrop.getBoundingClientRect();
            var center2X = Math.floor((pos.left + pos.right) / 2);
            var center2Y = Math.floor((pos.top + pos.bottom) / 2);
            // mouse over dragged element and mousedown
            fireMouseEvent('mousemove', elemDrag, center1X, center1Y);
            fireMouseEvent('mouseenter', elemDrag, center1X, center1Y);
            fireMouseEvent('mouseover', elemDrag, center1X, center1Y);
            fireMouseEvent('mousedown', elemDrag, center1X, center1Y);
            // start dragging process over to drop target
            fireMouseEvent('dragstart', elemDrag, center1X, center1Y);
            fireMouseEvent('drag', elemDrag, center1X, center1Y);
            fireMouseEvent('mousemove', elemDrag, center1X, center1Y);
            fireMouseEvent('drag', elemDrag, center2X, center2Y);
            fireMouseEvent('mousemove', elemDrop, center2X, center2Y);
            // trigger dragging process on top of drop target
            fireMouseEvent('mouseenter', elemDrop, center2X, center2Y);
            fireMouseEvent('dragenter', elemDrop, center2X, center2Y);
            fireMouseEvent('mouseover', elemDrop, center2X, center2Y);
            fireMouseEvent('dragover', elemDrop, center2X, center2Y);
            // release dragged element on top of drop target
            fireMouseEvent('drop', elemDrop, center2X, center2Y);
            fireMouseEvent('dragend', elemDrag, center2X, center2Y);
            fireMouseEvent('mouseup', elemDrag, center2X, center2Y);
            return true;
        }, selectorDrag, selectorDrop);
    }
}
module.exports = CoeHelper;
