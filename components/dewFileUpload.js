/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Dew File Upload class
 */
class DewFileUpload {
  /**
   * To upload file
   * @param {*} fullFileName Full name of the file with extension
   */
  uploadFile(fullFileName) {
    I.fillField("//dew-file-upload/div/input", filePath);
    I.wait(10);
    I.seeElement("//dew-col/div/div[2]/p/span[@title='" + fullFileName + "']");
  }
}

module.exports = new DewFileUpload();
module.exports.DewFileUpload = DewFileUpload; // for inheritance
