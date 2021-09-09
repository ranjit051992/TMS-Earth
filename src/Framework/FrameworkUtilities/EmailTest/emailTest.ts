
import { Startup } from "../Startup/Startup";
import console from "console";
var htmlParser = require("html-to-text");
var simpleParser = require('mailparser').simpleParser;
var Imap = require('imap');
var MailParser = require("mailparser").MailParser;
var inspect = require('util').inspect;
let emailBody: any;
let from: any;
let to: any;
let subject: any;
let cc: any;

export class EmailTest {
    static async openInbox(Inbox: any, imap: any, cb: any) {
        await imap.openBox(Inbox, true, cb);
    }

    static async readEmail(email: string, password: string, parameter: string[], value: string[], InboxValue: string, delay: number) {
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
                await EmailTest.openInbox(InboxValue, imap, async function (err: any, box: any) {
                    if (err) {
                        // return ("Error occured while opening mailbox \n" + err)
                        reject("error while opening mailbox ")
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

                        console.log(searchCondition)
                        await EmailTest.delay(delay).then(async function () {

                            imap.search(searchCondition, async function (err: any, results: any) {
                                if (results.length > 1) {
                                    imap.end();
                                    reject("Unique email not found, please put unique condition")
                                }
                                else if (!results || results.length == 0) {
                                    console.log("No unseen email available");
                                    imap.end();
                                    reject("No records found")
                                }
                                else if (results.length === 1) {
                                    console.log("in else " + results.length)
                                    let f: any;
                                    f = imap.fetch(results, { bodies: ['HEADER', 'TEXT'] });

                                    f.on('message', async function (msg: any, seqno: any) {

                                        console.log("Processing msg #" + seqno);

                                        var parser = new MailParser();
                                        parser.on('data', async (data: any) => {
                                            console.log(seqno);
                                            await EmailTest.fetchmailBody(data).then(async function (email) {
                                                console.log("body    ", Startup.email_Test.get("emailBody"))
                                                await EmailTest.getLinksFromBody(Startup.email_Test.get("emailBody")).then(async function () {
                                                    await EmailTest.fetchListFromBody();
                                                    resolve(Startup.email_Test)
                                                })
                                            })
                                        });
                                        parser.on('headers', (headers: any) => {

                                            subject = (headers.get('subject'));
                                            Startup.email_Test.set("subject", subject)

                                            to = (headers.get('to').value);
                                            let toArray: any = new Array();
                                            for (let recepients of to) {
                                                toArray.push(recepients)
                                            };
                                            Startup.email_Test.set("to", toArray)

                                            from = (headers.get('from').value);
                                            let fromArray: any = new Array();
                                            for (let f1 of from) {
                                                fromArray.push(f1)
                                            };
                                            Startup.email_Test.set("from", fromArray)

                                            // console.log(Startup.email_Test.get("subject"))
                                            // console.log(Startup.email_Test.get("to"))
                                            // console.log(Startup.email_Test.get("from"))
                                        });

                                        msg.on("body", async function (stream: any) {
                                            stream.once("data", async function (chunk: any) {
                                                parser.write(chunk.toString("utf8"));
                                            });

                                        });
                                        msg.once("end", async function () {
                                            parser.end();
                                        });
                                    });
                                    f.once('end', async function () {

                                        console.log('Done fetching all messages!');
                                        imap.end();
                                    });
                                }
                            })
                        })
                    }

                })
            });
        })
    }

    static async verifyDetails(verificationKey: string, verificationData: any) {
        console.log("verify ==============================" + verificationKey)
        //    verification block
        switch (verificationKey) {
            case "BODY":
                console.log("body verification    " + emailBody.includes(verificationData))
                return (Startup.email_Test.get("emailBody") as string).includes(verificationData)
                break;
            case "SUBJECT":
                console.log("subject verification    " + subject.includes(verificationData))
                return (Startup.email_Test.get("subject") as string).includes(verificationData)
                break;
            case "TO":
                console.log("to verification    " + Startup.email_Test.get("to").some(c => (c.name).includes(verificationData)))
                return Startup.email_Test.get("to").some(c => (c.name).includes(verificationData))
                break;
            case "FROM":
                console.log("from verification    " + Startup.email_Test.get("from").some(c => (c.name).includes(verificationData)))
                return Startup.email_Test.get("from").some(c => (c.name).includes(verificationData))
                break;
            case "CC":
                console.log("from verification    " + Startup.email_Test.get("cc").some(c => (c.name).includes(verificationData)))
                return Startup.email_Test.get("cc").some(c => (c.name).includes(verificationData))
                break;
        }
    }

    static verifyDetailsArray(verificationKey: string, verificationData: any[]) {
        console.log("verify ==============================" + verificationKey)
        return new Promise((resolve, reject) => {
            let flag: boolean = true;
            switch (verificationKey) {
                case "TO":
                    if (verificationData.length === Startup.email_Test.get("to").length) {
                        verificationData.forEach(async (vD) => {
                            if (!(Startup.email_Test.get("to").some(c => (c.name).includes(vD)))) {
                                flag = false;
                            }
                        })
                        resolve(flag);
                    }
                    else {
                        reject("The list does not match in count with the actual list");
                    }
                    break;
                case "FROM":

                    if (verificationData.length === Startup.email_Test.get("from").length) {
                        verificationData.forEach(async (vD) => {
                            if (!(Startup.email_Test.get("from").some(c => (c.name).includes(vD)))) {
                                flag = false;
                            }
                        })
                        resolve(flag);
                    }
                    else {
                        reject("The list does not match in count with the actual list");
                    }
                    break;

                case "CC":
                    if (verificationData.length === Startup.email_Test.get("cc").length) {
                        verificationData.forEach(async (vD) => {
                            if (!(Startup.email_Test.get("cc").some(c => (c.name).includes(vD)))) {
                                flag = false;
                            }
                        })
                        resolve(flag);
                    }
                    else {
                        reject("The list does not match in count with the actual list");
                    }
                    break;
            }
        })
    }

    static async delay(ms: number) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
    static async fetchmailBody(data: any) {
        return new Promise(async function (resolve, reject) {
            console.log("in fetchEmailBody")
            if (data.html) {
                emailBody = data.html;
                emailBody = htmlParser.fromString(emailBody);
                emailBody = emailBody.replace(/(\n)/gm, "")
            }
            else {
                emailBody = data.textAsHtml;
                emailBody = htmlParser.fromString(emailBody);
                emailBody = emailBody.replace(/(\n)/gm, "")
            }


            resolve(Startup.email_Test.set("emailBody", emailBody))
        })
    }

    static async getLinksFromBody(emailBody: any) {
        return new Promise(async (resolve, reject) => {
            console.log("in  get links from mail body")
            let linkPattern: any = /(https?:\/\/+)([A-Z a-z \d]*[\- \. \# \/ \- \_ \? \= \! \@ \$ \% \& \* \( \) \+ \:]?[A-Z a-z \d]*)*/gm;
            let linkArray: any = new Array();
            if (!(emailBody.match(linkPattern) === null)) {
                for (let l of emailBody.match(linkPattern)) {
                    if (!(l.includes("gif") || l.includes("png"))) {
                        linkArray.push(l)
                        Startup.email_Test.set("links", linkArray)
                    }
                }
                resolve(linkArray)
            }
            else {
                resolve("No Links")
            }
        });
    }

    static async fetchListFromBody() {
        console.log("in fetch list of to from from forwarded")

        if ((Startup.email_Test.get("subject").includes("Fw:")) || (Startup.email_Test.get("subject").includes("fW:")) || (Startup.email_Test.get("subject").includes("fw:")) || (Startup.email_Test.get("subject").includes("FW:"))) {
            let fromPattern: any = /(?<=From:)\s([A-Z a-z \d]*[\.\-\_\@\,\<\>\;]?[A-Z a-z \d]*)*/gm;
            let toPattern: any = /(?<=To:)\s([A-Z a-z \d]*[\.\-\_\@\,\<\>\;]?[A-Z a-z \d]*)*/gm;
            let ccPattern: any = /(?<=Cc:)\s([A-Z a-z \d]*[\.\-\_\@\,\<\>\;]?[A-Z a-z \d]*)*/gm;

            from = emailBody.match(fromPattern)
            to = emailBody.match(toPattern)
            cc = emailBody.match(ccPattern)

            let toArray: any = new Array();
            if (to !== null) {
                let toJson: any;
                for (let recepients of to) {
                    if (recepients.includes("<")) {
                        toJson = {
                            "address": ((recepients.split("<")[1]).split(">"))[0],
                            "name": (recepients.split("<")[0])
                        }
                    } else {
                        toJson = {
                            "address": recepients.split("Subject")[0],
                            "name": recepients.split("Subject")[0],
                        }
                    }
                    toArray.push(toJson)
                    Startup.email_Test.set("to", toArray)

                };
            }
            let fromArray: any = new Array();
            if (from !== null) {
                let fromJson: any
                for (let f1 of from) {
                    if (f1.includes("<")) {
                        fromJson = {
                            "address": ((f1.split("<")[1]).split(">"))[0],
                            "name": (f1.split("<")[0])
                        }
                    } else {
                        fromJson = {
                            "address": f1.split("Sent")[0],
                            "name": f1.split("Sent")[0],
                        }
                    }
                    fromArray.push(fromJson)
                    Startup.email_Test.set("from", fromArray)
                };
            }
            if (cc !== null) {
                let ccArray: any = new Array();
                let ccJson: any;
                for (let c1 of cc) {
                    if (c1.includes("<")) {
                        ccJson = {
                            "address": ((c1.split("<")[1]).split(">"))[0],
                            "name": (c1.split("<")[0])
                        }
                    } else {
                        ccJson = {
                            "address": c1,
                            "name": c1
                        }
                    }
                    ccArray.push(ccJson)
                    Startup.email_Test.set("cc", ccArray)
                };
            }
        }
    }

}