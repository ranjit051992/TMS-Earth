const {SHARE_DATA_PORT = 9091} = process.env;
const request = require('sync-request');

function tryParseJson(item) {
  try {
    return JSON.parse(item)
  } catch(error) {
    return item
  }
}

const getStepData = (step) => {
  const response = request('POST', `http://0.0.0.0:${SHARE_DATA_PORT}/get_step_data`, {
    json: {step}
  })
  return tryParseJson(response.getBody().toString('utf8'))
};

const setStepData = (_name, _data) => {
  const response = request('POST', `http://0.0.0.0:${SHARE_DATA_PORT}/set_step_data`, {
    json: {_name, _data}
  })
  return tryParseJson(response.getBody().toString('utf8'))
};

module.exports = {
  getStepData,
  setStepData
};
