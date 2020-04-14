const {SHARE_DATA_PORT = 9091} = process.env;

const Koa = require('koa2');

const bodyParser = require('koa-bodyparser');
const cors = require('@koa/cors');

const router = require('./router');

const app = new Koa();

app
  .use(cors())
  .use(bodyParser())
  .use(router.routes());

app.listen(+SHARE_DATA_PORT);
