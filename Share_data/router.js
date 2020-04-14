const Router = require('koa-router');
const stepsData = {};
const router = new Router();
router.post('/get_step_data', async (ctx) => {
 const {step} = ctx.request.body
 ctx.status = 200;
 ctx.body = stepsData[step]
 return ctx;
});
router.post('/set_step_data', async (ctx) => {
 stepsData[ctx.request.body._name] = ctx.request.body._data;
 ctx.body = {data: 'ok'}
 return ctx;
});
module.exports = router;