"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const fs = require('fs');
const unzipper = require('unzipper');
const AdmZip = require('adm-zip');
const zipFolder = require('zip-a-folder');
class ZipUnZip {
    /**
     * Unzips the given zip folder and extract it to the desired destination path
     * @param {source} string  zip folder path e.g ./tempDownload//addresses.zip
     * @param {destination} string  path where you want to keep the extracted files e.g ./DataFiles/NewUnzipFolder
     */
    static async unzipDirectory(source, destination) {
        await fs.createReadStream(source).pipe(unzipper.Extract({ path: destination }));
        console.log("File is unzipped");
    }
    /**
     * Zips the given file or folder to the given zip folder path
     * @param {zipFolderPath} string path where you want to keep the zip folder
     * @param {fileToadd} string file or folder path to zip
     */
    static async zipDirectory(zipFolderPath, fileToadd) {
        let file = new AdmZip();
        if (fs.lstatSync(fileToadd).isDirectory()) {
            await zipFolder.zipFolder(fileToadd, zipFolderPath, async (err) => {
                if (err) {
                    console.log('Something went wrong!', err);
                }
            });
        }
        else {
            file.addLocalFile(fileToadd);
            file.writeZip(`${zipFolderPath}`);
        }
        console.log("Zip folder create " + zipFolderPath);
    }
}
exports.ZipUnZip = ZipUnZip;
