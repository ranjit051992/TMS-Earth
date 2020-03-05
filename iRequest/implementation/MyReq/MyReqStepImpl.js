const { I } = inject();
const MyReqImpl = require("./MyReqimpl");
//Submit_NoneType

Given("I create a requestdefinition with none requesttype", function () {
    MyReqImpl.CreateReqNavNone();
});
Then("I create a request with that particular requestdefinition", function () {
    MyReqImpl.CreateReqBasicDetails();

});
Then("I should be able to submit the request with none requesttype", function () {
    MyReqImpl.ReqSubmit();

});

//SaveAsDraft_NoneType

Given("I create a requestdefinition with none as end point", function () {
    MyReqImpl.CreateReqNavNone();
});
Then("I create a request with requestdefinition with none requesttype", function () {
    MyReqImpl.CreateReqBasicDetails();

});
Then("I save the request as SaveAsDraft with none requesttype", function () {
    MyReqImpl.ReqSaveAsDraft();

});

//ReqUrgentSabmit
Given("I create a requestdefinition", function () {
    MyReqImpl.CreateReqNavNone();
});
Then("I create a request making uregent requirement marked", function () {
    MyReqImpl.CreateReqBasicDetails();
    MyReqImpl.ReqUrgentReqmnt();

});
Then("I should be able to create a request", function () {
    MyReqImpl.ReqSubmit();

});
//ReqUrgntSaveAsDraft
Given("I create a RD with none as end type", function () {
    MyReqImpl.CreateReqNavNone();
});
Then("I create a request making uregent requirement  as marked", function () {
    MyReqImpl.CreateReqBasicDetails();
    MyReqImpl.ReqUrgentReqmnt();

});
Then("I can able to create a request with urgent requirement getting added", function () {
    MyReqImpl.ReqSaveAsDraft();

});

//Sourcing Request
Given("I create a RD with sourcing requesttype", function () {
    MyReqImpl.CreateReqNaviSource();
});
Then("I create a request with the sourcing particular requestdefinition", function () {
    MyReqImpl.CreateReqBasicDetails();
    MyReqImpl.iSourceFF();

});
Then("I can able to create a request with urgent requirement getting added", function () {
    MyReqImpl.ReqSaveAsDraft();

});
