const {spawn, exec} = require('child_process');
const {resolve} = require('path');
const {platform} = require('os')
let pid = null;

function startShareDataService() {
  const dataServer = spawn(
    'node',
    [resolve(__dirname, './indexStartShareData.js')],
    {
      detached: true,
      stdio: 'ignore'
    }
  );
  // detach
  dataServer.unref();
  pid = dataServer.pid;
}
function stopShareDataService() {
  // console.log("PID for the process     "+pid)
  // console.log("platform     "+platform())
  if(platform() === 'win32') {
    // console.log("Inside if ")
    exec(`taskkill \/PID ${pid} \/f`)
  } else {
    exec(`kill ${pid}`)
  }
 }

 module.exports = {
  startShareDataService,
  stopShareDataService
 };
