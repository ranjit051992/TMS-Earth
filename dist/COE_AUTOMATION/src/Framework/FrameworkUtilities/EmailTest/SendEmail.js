"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const nodemailer = require("nodemailer");
class SendEmail {
    static async sendEmailWithImgAsBody(textBody, subject, to, attachmentPath) {
        const transport = await nodemailer.createTransport({
            host: `automail-mu.zycus.local`,
            port: 25,
            tls: {
                rejectUnauthorized: false,
            },
        });
        let mailOptions = {
            from: 'gocd@zycus.net',
            to: [to],
            subject: subject,
            text: textBody,
            html: 'Embedded image: <img src="cid:unique@kreata.ee"/>',
            attachments: [{
                    path: attachmentPath,
                    cid: 'unique@kreata.ee' //same cid value as in the html img src
                }]
        };
        await transport.sendMail(mailOptions, function (err, info) {
            if (err) {
                console.log(err);
            }
            else {
                console.log("email sent");
                console.log(info);
            }
        });
    }
    static async sendEmail(textBody, subject, to) {
        const transport = await nodemailer.createTransport({
            host: `automail-mu.zycus.local`,
            port: 25,
            tls: {
                rejectUnauthorized: false,
            },
        });
        let mailOptions = {
            from: 'gocd@zycus.net',
            to: [to],
            subject: subject,
            text: textBody,
        };
        await transport.sendMail(mailOptions, function (err, info) {
            if (err) {
                console.log(err);
            }
            else {
                console.log("email sent");
                console.log(info);
            }
        });
    }
    static async sendEmailWitAttachment(textBody, subject, to, attachmentPath) {
        const transport = await nodemailer.createTransport({
            host: `automail-mu.zycus.local`,
            port: 25,
            tls: {
                rejectUnauthorized: false,
            },
        });
        let mailOptions = {
            from: 'gocd@zycus.net',
            to: [to],
            subject: subject,
            text: textBody,
            attachments: [
                { path: attachmentPath },
            ]
        };
        await transport.sendMail(mailOptions, function (err, info) {
            if (err) {
                console.log(err);
            }
            else {
                console.log("email sent");
                console.log(info);
            }
        });
    }
    static async replyToEmail(messageId, fromArray, toArray, subject, textBody) {
        console.log("inside reply to email method");
        const transport = await nodemailer.createTransport({
            host: `automail-mu.zycus.local`,
            port: 25,
            tls: {
                rejectUnauthorized: false,
            },
        });
        let mailOptions = {
            from: fromArray,
            to: toArray,
            subject: subject,
            text: textBody,
            inReplyTo: messageId,
            references: messageId,
            headers: {
                replyTo: toArray,
                'In-Reply-To': messageId,
                references: messageId
            },
        };
        await transport.sendMail(mailOptions, function (err, info) {
            if (err) {
                console.log(err);
            }
            else {
                console.log("email sent");
                console.log(info);
            }
        });
    }
}
exports.SendEmail = SendEmail;
