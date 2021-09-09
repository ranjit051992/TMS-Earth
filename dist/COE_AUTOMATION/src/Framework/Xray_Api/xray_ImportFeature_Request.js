"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var request = require('request');
var fs = require('fs');
class xray_ImportCucumberApiRequest {
    static async generateAuthToken() {
        let token;
        return new Promise((resolve, reject) => {
            var options = {
                'method': 'POST',
                'url': 'https://xray.cloud.xpand-it.com/api/v1/authenticate',
                'headers': {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ "client_id": "79279168D5CB4D7284FA990D13227F8A", "client_secret": "b45f7efeb7639fcc1a38c88e7040e22fcfae4c14f9a4b02123a500803dc7aaac" })
            };
            request(options, async function (error, response) {
                if (error)
                    reject(error);
                else {
                    token = response.body;
                    resolve(token);
                }
            });
        });
    }
}
exports.xray_ImportCucumberApiRequest = xray_ImportCucumberApiRequest;
