const ncp = require('ncp').ncp
const { readdirSync } = require('fs')
//const { tearDownAll } = require('./dist/Framework/FrameworkUtilities/Bootstrap/teardownAll.js')
const outputPath = './output/'


const getDirectories = (source) =>
  readdirSync(source, { withFileTypes: true })
    .filter(dirent => dirent.isDirectory())
    .map(dirent => dirent.name)

const allFodlers = getDirectories(outputPath)

module.exports = async function() {
  for (const folder of allFodlers) {
    ncp.limit = 16;
    ncp(`${outputPath}${folder}`, outputPath, (error) => {
      if (error) {
        return console.error(error);
      }
    })
  }
  //await tearDownAll.teardownAllMethod()
}

