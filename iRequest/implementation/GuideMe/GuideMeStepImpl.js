const { I } = inject();
const GuideMeImpl = require("./GuideMeImpl");


Given("I am on MyRequest Listing Page", function () {
    GuideMeImpl.MyReqNav();
});
Then("I access GuideMe", function () {
    GuideMeImpl.AccessGuideMe();

});
Then("I select any Request Type option", function () {
    GuideMeImpl.ProcessGuideMe();

});
Then("I should able to Map through GuideMe", function () {
    GuideMeImpl.MapGuideMe;

});


