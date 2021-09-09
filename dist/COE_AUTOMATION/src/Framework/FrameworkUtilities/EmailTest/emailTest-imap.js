"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const Startup_1 = require("../Startup/Startup");
const console_1 = __importDefault(require("console"));
var htmlParser = require("html-to-text");
var Imap = require('imap');
var MailParser = require("mailparser").MailParser;
var { Base64Decode } = require('base64-stream');
const fs = require("fs");
let emailBody;
let from;
let to;
let subject;
let cc;
var writeStream;
class EmailTest_NewImpl {
    static async buildAttachmentArray(attachments) {
        let attachmentNames = new Array();
        let attachmentSize = new Array();
        if (attachments !== null) {
            for (let attachment of attachments) {
                attachmentNames.push(attachment.params.name);
                attachmentSize.push(attachment.size);
            }
            Startup_1.Startup.email_Test.set("attachmentNames", attachmentNames);
            Startup_1.Startup.email_Test.set("attachmentSize", attachmentSize);
        }
        else {
            console_1.default.log("attachments array is null for this message.");
        }
    }
    static buildAttMessageFunction(msg, attachment) {
        var filename = attachment.params.name;
        var encoding = attachment.encoding;
        msg.on('body', async function (stream, info) {
            writeStream = fs.createWriteStream("./tempDownload/" + filename);
            writeStream.on('finish', function () {
                console_1.default.log('Done writing to file %s', filename);
            });
            //Create a write stream so that we can stream the attachment to file;
            console_1.default.log('Streaming this attachment to file', filename, info);
            //so we decode during streaming using 
            if (encoding.toUpperCase() === 'BASE64') {
                //the stream is base64 encoded, so here the stream is decode on the fly and piped to the write stream (file)
                stream.pipe(new Base64Decode()).pipe(writeStream);
                console_1.default.log('Finished attachment %s', filename);
            }
            else {
                //here we have none or some other decoding streamed directly to the file which renders it useless probably
                stream.pipe(writeStream);
            }
            msg.once('end', async function () {
                writeStream.end();
            });
        });
    }
    static async openInbox(Inbox, imap, cb) {
        await imap.openBox(Inbox, true, cb);
    }
    static readEmail(email, password, parameter, value, InboxValue, delay) {
        return new Promise(async (resolve, reject) => {
            let imap = new Imap({
                user: email,
                password: password,
                host: 'outlook.office365.com',
                port: 993,
                tls: true,
                connTimeout: 120000
            });
            imap.connect();
            imap.once('ready', async function () {
                EmailTest_NewImpl.openInbox(InboxValue, imap, async function (err, box) {
                    if (err) {
                        // return ("Error occured while opening mailbox \n" + err)
                        reject("error while opening mailbox ");
                    }
                    else {
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
                        console_1.default.log(searchCondition);
                        await EmailTest_NewImpl.delay(delay).then(async function () {
                            imap.search(searchCondition, async function (err, results) {
                                if (results.length > 1) {
                                    imap.end();
                                    reject("Unique email not found, please put unique condition");
                                }
                                else if (!results || results.length == 0) {
                                    console_1.default.log("No unseen email available");
                                    imap.end();
                                    reject("No records found");
                                }
                                else if (results.length === 1) {
                                    console_1.default.log("in else " + results.length);
                                    let f;
                                    f = imap.fetch(results, { bodies: ['HEADER', 'TEXT'], struct: true });
                                    f.on('message', async function (msg, seqno) {
                                        console_1.default.log("Processing msg #" + seqno);
                                        var prefix = '(#' + seqno + ') ';
                                        var parser = new MailParser();
                                        parser.on('data', async (data) => {
                                            console_1.default.log(seqno);
                                            // console.log(data);
                                            await EmailTest_NewImpl.fetchmailBody(data).then(async function (email) {
                                                // console.log("body    ", Startup.email_Test.get("emailBody"))
                                                await EmailTest_NewImpl.getLinksFromBody(Startup_1.Startup.email_Test.get("emailBody")).then(async function () {
                                                    await EmailTest_NewImpl.fetchListFromBody();
                                                });
                                            });
                                        });
                                        parser.on('headers', (headers) => {
                                            subject = (headers.get('subject'));
                                            Startup_1.Startup.email_Test.set("subject", subject);
                                            to = (headers.get('to').value);
                                            let toArray = new Array();
                                            for (let recepients of to) {
                                                toArray.push(recepients);
                                            }
                                            ;
                                            Startup_1.Startup.email_Test.set("to", toArray);
                                            from = (headers.get('from').value);
                                            let fromArray = new Array();
                                            for (let f1 of from) {
                                                fromArray.push(f1);
                                            }
                                            ;
                                            Startup_1.Startup.email_Test.set("from", fromArray);
                                            f.once('attributes', async function (attrs) {
                                                console_1.default.log(attrs.struct);
                                                console_1.default.log(attrs.struct.length);
                                                let attachments = [];
                                            });
                                        });
                                        msg.on("body", async function (stream) {
                                            stream.once("data", async function (chunk) {
                                                parser.write(chunk.toString("utf8"));
                                            });
                                        });
                                        //For Attachment
                                        msg.once('attributes', async function (attrs) {
                                            let attachments = [];
                                            for (var i = 1, len = attrs.struct.length, r; i < len; i++) {
                                                if (attrs.struct[i][0].disposition !== null) {
                                                    attachments.push(attrs.struct[i][0]);
                                                }
                                            }
                                            if (attachments.length > 0) {
                                                for (let attachment of attachments) {
                                                    var f = imap.fetch(attrs.uid, {
                                                        bodies: [attachment.partID],
                                                        struct: true
                                                    });
                                                    await EmailTest_NewImpl.buildAttMessageFunction(msg, attachment);
                                                }
                                                await EmailTest_NewImpl.buildAttachmentArray(attachments);
                                            }
                                            resolve(Startup_1.Startup.email_Test);
                                        });
                                        msg.once("end", async function () {
                                            parser.end();
                                        });
                                    });
                                    f.once('end', async function () {
                                        console_1.default.log('Done fetching all messages!');
                                        imap.end();
                                    });
                                }
                            });
                        });
                    }
                });
            });
        });
    }
    static async verifyDetails(verificationKey, verificationData) {
        console_1.default.log("verify ==============================" + verificationKey);
        //    verification block
        switch (verificationKey) {
            case "BODY":
                console_1.default.log("body verification    " + emailBody.includes(verificationData));
                return Startup_1.Startup.email_Test.get("emailBody").includes(verificationData);
                break;
            case "SUBJECT":
                console_1.default.log("subject verification    " + subject.includes(verificationData));
                return Startup_1.Startup.email_Test.get("subject").includes(verificationData);
                break;
            case "TO":
                console_1.default.log("to verification    " + Startup_1.Startup.email_Test.get("to").some(c => (c.name).includes(verificationData)));
                return Startup_1.Startup.email_Test.get("to").some(c => (c.name).includes(verificationData));
                break;
            case "FROM":
                console_1.default.log("from verification    " + Startup_1.Startup.email_Test.get("from").some(c => (c.name).includes(verificationData)));
                return Startup_1.Startup.email_Test.get("from").some(c => (c.name).includes(verificationData));
                break;
            case "CC":
                console_1.default.log("from verification    " + Startup_1.Startup.email_Test.get("cc").some(c => (c.name).includes(verificationData)));
                return Startup_1.Startup.email_Test.get("cc").some(c => (c.name).includes(verificationData));
                break;
        }
    }
    static verifyDetailsArray(verificationKey, verificationData) {
        console_1.default.log("verify ==============================" + verificationKey);
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
    static async delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
    static async fetchmailBody(data) {
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
            resolve(Startup_1.Startup.email_Test.set("emailBody", emailBody));
        });
    }
    static async getLinksFromBody(emailBody) {
        return new Promise(async (resolve, reject) => {
            console_1.default.log("in  get links from mail body");
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
    static async fetchListFromBody() {
        console_1.default.log("in fetch list of to from from forwarded");
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
}
exports.EmailTest_NewImpl = EmailTest_NewImpl;
