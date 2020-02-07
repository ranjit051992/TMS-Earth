const Helper = codecept_helper;
const event = require('codeceptjs').event;

class MyHelper extends Helper {


_beforeSuite (suite) 
{

    console.log("Helper : Before suite :"+suite);
}

_afterSuite  (suite) 
{

    console.log("Helper : After suite"+suite);
}

_before (test) 
{

    console.log("Helper : Before "+test);
}

_after  (test) 
{

    console.log("Helper : After "+test);
}

_failed  (step, err) 
{

    console.log("Helper : Failed "+step+"error : "+err);
}

_passed  (step) 
{

    console.log("Helper : Passed ");
}

_beforeStep (step) 
{

    console.log("Helper : Before Step"+step);
}

_afterStep  (step) 
{

    console.log("Helper : After Step"+step);
}

_init  () 
{

    console.log("Helper : Init");
}

_finishTest  (test) 
{

    console.log("Helper : finishTest"+test);
}
}

module.exports = MyHelper;
