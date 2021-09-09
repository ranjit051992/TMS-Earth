"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Startup_1 = require("../Startup/Startup");
var moment = require('moment-timezone');
const imaps = require('imap-simple');
const simpleParser = require('mailparser').simpleParser;
const _ = require('lodash');
var htmlParser = require("html-to-text");
const fs = require("fs");
let emailBody;
let from;
let to;
let subject;
let cc;
class EmailTest_NewImpl {
    /**
     * Get file size on disk
     * @param filePath Provide file path with file name
     */
    static getFileSize(filePath) {
        return new Promise((resolve, reject) => {
            let stats = fs.statSync(filePath);
            let { size } = stats;
            let i = Math.floor(Math.log(size) / Math.log(1024));
            let num = +(size / Math.pow(1024, i)).toFixed(2);
            resolve(num * 1 + ' ' + ['B', 'KB', 'MB', 'GB', 'TB'][i]);
        });
    }
    static delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
    /**
     * This function forms search condition array
     * @param parameter search key like 'FROM' OR 'SUBJECT' or can pass both
     * @param value value for above key like actual value for 'FROM'
     */
    static formSearchcondition(parameter, value) {
        return new Promise((resolve, reject) => {
            let searchCondition = new Array();
            for (let i = 0; i < parameter.length; i++) {
                switch (parameter[i]) {
                    case 'SUBJECT':
                        searchCondition.push(new Array("SUBJECT", value[i]));
                        break;
                    case 'FROM':
                        searchCondition.push(new Array("FROM", value[i]));
                        break;
                    case 'TO':
                        searchCondition.push(new Array("TO", value[i]));
                        break;
                    case 'SINCE':
                        searchCondition.push(new Array("SINCE", value[i]));
                        break;
                    case 'ON':
                        searchCondition.push(new Array("ON", value[i]));
                        break;
                }
            }
            console.log(searchCondition);
            resolve(searchCondition);
        });
    }
    /**
     * This is internal method which takes whole mail as a input parameter
     * retrieves headers like to,from,cc,subject and sets in emailTest maps
     * which can be used later for validation purpose.
     * @param message whole mail
     */
    static formHeaders(message) {
        return new Promise((resolve, reject) => {
            Startup_1.Startup.email_Test.set("subject", message.subject);
            to = message.to.value; //message.to.value.name will give name instead of emial address
            //message.to.value.address will give  emial address
            let toArray = new Array();
            for (let recepients of to) {
                toArray.push(recepients);
            }
            ;
            Startup_1.Startup.email_Test.set("to", toArray);
            from = message.from.value;
            let fromArray = new Array();
            for (let f1 of from) {
                fromArray.push(f1);
            }
            ;
            Startup_1.Startup.email_Test.set("from", fromArray);
            if (message.cc) {
                let ccArray = new Array();
                for (let cc of ccArray) {
                    fromArray.push(cc);
                }
                ;
                Startup_1.Startup.email_Test.set("cc", ccArray);
            }
            resolve(Startup_1.Startup.email_Test);
        });
    }
    /**
     * This is internal method for attachment, takes mail as a input parameter,
     * checks if there are any attachments present, if yes forms attachment.
     * @param message whole email
     */
    static formAttachment(message) {
        return new Promise((resolve, reject) => {
            if (message.attachments.length > 0) {
                let attachmentNames = [];
                message.attachments.forEach(function (attachment) {
                    if (attachment.contentDisposition != null) {
                        attachmentNames.push(attachment.filename);
                        EmailTest_NewImpl.writeAttachmentcontentToFile(attachment, attachment.filename);
                    }
                });
                Startup_1.Startup.email_Test.set("attachmentNames", attachmentNames);
            }
            resolve(Startup_1.Startup.email_Test);
        });
    }
    /**
     * Internal method, used to write attachment on disk
     * @param attachment attachment part
     * @param filename name of the attachment
     */
    static writeAttachmentcontentToFile(attachment, filename) {
        return new Promise((resolve, reject) => {
            var buf = Buffer.from(attachment.content, attachment.headers.get("content-transfer-encoding"));
            var writeStream;
            writeStream = fs.createWriteStream("./tempDownload/" + filename);
            console.log('created file %s', filename);
            writeStream.on('finish', function () {
                console.log('Done writing to file %s', filename);
                writeStream.end();
            });
            console.log('Streaming this attachment to file', filename);
            fs.writeFile("./tempDownload/" + filename, buf, function (err) {
                if (err) {
                    console.log("Error while writing to file.", filename);
                    reject(err);
                }
                else {
                    resolve("Done writing to file");
                }
            });
        });
    }
    /**
     * This is user method used to read email, it searches email in Outlook Inbox
     *  according to given search criteria And retreives every part of the email
     *
     * @param email email address
     * @param password email pass
     * @param parameter serach parameter in array form like['FROM','SUBJECT']
     * @param value Actual values to above search criteria in array form
     * @param InboxValue name of the Inbox
     * @param delay delay
     */
    static readEmail(email, password, parameter, value, InboxValue, delay) {
        return new Promise((resolve, reject) => {
            console.log(moment().tz("Asia/kolkata").format());
            var config = {
                imap: {
                    user: email,
                    password: password,
                    host: 'outlook.office365.com',
                    port: 993,
                    tls: true,
                    authTimeout: 120000,
                    tlsOptions: { rejectUnauthorized: false }
                }
            };
            let connectionObj;
            EmailTest_NewImpl.delay(delay).then(() => {
                imaps.connect(config).then((connection, error) => {
                    connectionObj = connection;
                    return connection.openBox(InboxValue).
                        then((result) => {
                        var fetchOptions = {
                            bodies: ['HEADER', 'TEXT', ''], struct: true,
                        };
                        EmailTest_NewImpl.formSearchcondition(parameter, value).then((searchCondition) => {
                            return connectionObj.search(searchCondition, fetchOptions);
                        }).then((messages) => {
                            if (messages.length > 0) {
                                var all = _.find(messages[0].parts, { "which": "" });
                                var id = messages[0].attributes.uid;
                                Startup_1.Startup.email_Test.set("MessageUID", id);
                                Startup_1.Startup.email_Test.set("flags", messages[0].attributes.flags);
                                var idHeader = "Imap-Id: " + id + "\r\n";
                                simpleParser(idHeader + all.body).then(mail => {
                                    // access to the whole mail object
                                    EmailTest_NewImpl.formHeaders(mail);
                                    EmailTest_NewImpl.formAttachment(mail);
                                    EmailTest_NewImpl.fetchmailBody(mail).then((emailBody) => {
                                        EmailTest_NewImpl.getLinksFromBody(emailBody).then((linkArray) => {
                                            EmailTest_NewImpl.fetchListFromBody();
                                            connectionObj.end();
                                            console.log(moment().tz("Asia/kolkata").format());
                                            resolve(Startup_1.Startup.email_Test);
                                        });
                                    });
                                }).catch(err => {
                                    connectionObj.end();
                                    return reject(err);
                                });
                            }
                            else {
                                connectionObj.end();
                                console.log(moment().tz("Asia/kolkata").format());
                                return reject("no mail found for given search criteria.");
                            }
                        }).catch(err => {
                            connectionObj.end();
                            console.log(moment().tz("Asia/kolkata").format());
                            return reject(err);
                        });
                    });
                }).catch(error => {
                    console.log(error);
                    console.log(moment().tz("Asia/kolkata").format());
                    return reject();
                });
            });
        });
    }
    static fetchmailBody(data) {
        return new Promise(async function (resolve, reject) {
            //    console.log(data)
            if (data.html) {
                emailBody = data.html;
                emailBody = htmlParser.fromString(emailBody);
                emailBody = emailBody.replace(/(\n)/gm, "");
            }
            else {
                emailBody = data.textAsHtml;
                emailBody = htmlParser.fromString(emailBody);
                emailBody = emailBody.replace(/(\n)/gm, "");
            }
            Startup_1.Startup.email_Test.set("emailBody", emailBody);
            resolve(emailBody);
        });
    }
    static getLinksFromBody(emailBody) {
        return new Promise(async (resolve, reject) => {
            console.log("in  get links from mail body");
            let linkPattern = /(https?:\/\/+)([A-Z a-z \d]*[\- \. \# \/ \- \_ \? \= \! \@ \$ \% \& \* \( \) \+ \:]?[A-Z a-z \d]*)*/gm;
            let linkArray = new Array();
            if (!(emailBody.match(linkPattern) === null)) {
                for (let l of emailBody.match(linkPattern)) {
                    if (!(l.includes("gif") || l.includes("png"))) {
                        linkArray.push(l);
                        Startup_1.Startup.email_Test.set("links", linkArray);
                    }
                }
                resolve(linkArray);
            }
            else {
                resolve("No Links");
            }
        });
    }
    static verifyDetailsArray(verificationKey, verificationData) {
        console.log("verify ==============================" + verificationKey);
        return new Promise((resolve, reject) => {
            let flag = true;
            switch (verificationKey) {
                case "TO":
                    if (verificationData.length === Startup_1.Startup.email_Test.get("to").length) {
                        verificationData.forEach(async (vD) => {
                            if (!(Startup_1.Startup.email_Test.get("to").some(c => (c.name).includes(vD)))) {
                                flag = false;
                            }
                        });
                        resolve(flag);
                    }
                    else {
                        reject("The list does not match in count with the actual list");
                    }
                    break;
                case "FROM":
                    if (verificationData.length === Startup_1.Startup.email_Test.get("from").length) {
                        verificationData.forEach(async (vD) => {
                            if (!(Startup_1.Startup.email_Test.get("from").some(c => (c.name).includes(vD)))) {
                                flag = false;
                            }
                        });
                        resolve(flag);
                    }
                    else {
                        reject("The list does not match in count with the actual list");
                    }
                    break;
                case "CC":
                    if (verificationData.length === Startup_1.Startup.email_Test.get("cc").length) {
                        verificationData.forEach(async (vD) => {
                            if (!(Startup_1.Startup.email_Test.get("cc").some(c => (c.name).includes(vD)))) {
                                flag = false;
                            }
                        });
                        resolve(flag);
                    }
                    else {
                        reject("The list does not match in count with the actual list");
                    }
                    break;
            }
        });
    }
    static fetchListFromBody() {
        console.log("in fetch list of to from  forwarded");
        if ((Startup_1.Startup.email_Test.get("subject").includes("Fw:")) || (Startup_1.Startup.email_Test.get("subject").includes("fW:")) || (Startup_1.Startup.email_Test.get("subject").includes("fw:")) || (Startup_1.Startup.email_Test.get("subject").includes("FW:"))) {
            let fromPattern = /(?<=From:)\s([A-Z a-z \d]*[\.\-\_\@\,\<\>\;]?[A-Z a-z \d]*)*/gm;
            let toPattern = /(?<=To:)\s([A-Z a-z \d]*[\.\-\_\@\,\<\>\;]?[A-Z a-z \d]*)*/gm;
            let ccPattern = /(?<=Cc:)\s([A-Z a-z \d]*[\.\-\_\@\,\<\>\;]?[A-Z a-z \d]*)*/gm;
            from = emailBody.match(fromPattern);
            to = emailBody.match(toPattern);
            cc = emailBody.match(ccPattern);
            let toArray = new Array();
            if (to !== null) {
                let toJson;
                for (let recepients of to) {
                    if (recepients.includes("<")) {
                        toJson = {
                            "address": ((recepients.split("<")[1]).split(">"))[0],
                            "name": (recepients.split("<")[0])
                        };
                    }
                    else {
                        toJson = {
                            "address": recepients.split("Subject")[0],
                            "name": recepients.split("Subject")[0],
                        };
                    }
                    toArray.push(toJson);
                    Startup_1.Startup.email_Test.set("to", toArray);
                }
                ;
            }
            let fromArray = new Array();
            if (from !== null) {
                let fromJson;
                for (let f1 of from) {
                    if (f1.includes("<")) {
                        fromJson = {
                            "address": ((f1.split("<")[1]).split(">"))[0],
                            "name": (f1.split("<")[0])
                        };
                    }
                    else {
                        fromJson = {
                            "address": f1.split("Sent")[0],
                            "name": f1.split("Sent")[0],
                        };
                    }
                    fromArray.push(fromJson);
                    Startup_1.Startup.email_Test.set("from", fromArray);
                }
                ;
            }
            if (cc !== null) {
                let ccArray = new Array();
                let ccJson;
                for (let c1 of cc) {
                    if (c1.includes("<")) {
                        ccJson = {
                            "address": ((c1.split("<")[1]).split(">"))[0],
                            "name": (c1.split("<")[0])
                        };
                    }
                    else {
                        ccJson = {
                            "address": c1,
                            "name": c1
                        };
                    }
                    ccArray.push(ccJson);
                    Startup_1.Startup.email_Test.set("cc", ccArray);
                }
                ;
            }
        }
    }
    static async verifyDetails(verificationKey, verificationData) {
        console.log("verify ==============================" + verificationKey);
        //    verification block
        switch (verificationKey) {
            case "BODY":
                console.log("body verification    " + Startup_1.Startup.email_Test.get("emailBody").includes(verificationData));
                return Startup_1.Startup.email_Test.get("emailBody").includes(verificationData);
                break;
            case "SUBJECT":
                console.log("subject verification    " + Startup_1.Startup.email_Test.get("subject").includes(verificationData));
                return Startup_1.Startup.email_Test.get("subject").includes(verificationData);
                break;
            case "TO":
                console.log("to verification    " + Startup_1.Startup.email_Test.get("to").some(c => (c.name).includes(verificationData)));
                return Startup_1.Startup.email_Test.get("to").some(c => (c.name).includes(verificationData));
                break;
            case "FROM":
                console.log("from verification    " + Startup_1.Startup.email_Test.get("from").some(c => (c.name).includes(verificationData)));
                return Startup_1.Startup.email_Test.get("from").some(c => (c.name).includes(verificationData));
                break;
            case "CC":
                console.log("from verification    " + Startup_1.Startup.email_Test.get("cc").some(c => (c.name).includes(verificationData)));
                return Startup_1.Startup.email_Test.get("cc").some(c => (c.name).includes(verificationData));
                break;
        }
    }
}
exports.EmailTest_NewImpl = EmailTest_NewImpl;
