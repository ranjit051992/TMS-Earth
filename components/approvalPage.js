const { I } = inject()

class ApprovalPage{

    selectHeaderTab(tabName){
        I.waitForVisible("//a[dew-default-tab-head[contains(text(),'"+tabName+"')] and contains(@class,'paginated-nav-link')]");
        I.click("//a[dew-default-tab-head[contains(text(),'"+tabName+"')] and contains(@class,'paginated-nav-link')]");
        I.seeElement('//a[dew-default-tab-head[text()[normalize-space()="'+tabName +'"]] and contains(@class,"active")]');
    }

    async verifyPageSubListing(){
        //pause()
        let pin = await I.grabTextFrom("//dew-default-tab-head");        
        console.log(pin.length);
        pin.forEach(async tabName=> {
            
            
            //I.click('//a[dew-default-tab-head[contains(text(),"'+tabName+'")] and contains(@class,"paginated-nav-link")]');
            I.click('//a[dew-default-tab-head[text()[normalize-space()="'+tabName +'"]] and contains(@class,"paginated-nav-link")]');
            I.wait(10);
            let num =  await I.grabNumberOfVisibleElements('dew-listing');
            console.log(num);

            if(num > 0){
                //I.seeElement('//a[dew-default-tab-head[contains(text(),"'+tabName+'")] and contains(@class,"active")]');
                I.seeElement('//a[dew-default-tab-head[text()[normalize-space()="'+tabName +'"]] and contains(@class,"active")]');
                console.log("Data is Present");
                I.waitForElement('dew-listing', 30);
            }
            else{
                console.log("data is not present")
            }
            
        })
    }
}
module.exports = new ApprovalPage()
module.exports.ApprovalPage = ApprovalPage // for inheritance