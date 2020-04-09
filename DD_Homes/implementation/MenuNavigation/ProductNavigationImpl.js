const { I } = inject();
const DewNavBar = require("dd-cc-zycus-automation/components/dewNavBar");
const visibleelement = require("dd-cc-zycus-automation/components/element");
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword");


class HomeProductNavigation {

    async productNavigation () {

       // let result = await CommonKeyword.clickElement("//div[@class='menu-btn mr-3']/span");
        //console.log(result);
        I.wait(3);
        let product = await I.grabAttributeFrom("//li[contains(@class,'menu-item')]", 'title');
         console.log(product);

         for (let index = 0; index < product.length; index++) {
             var element = product[index];
             console.log(element);
             if (index>4 & index<14) 
              {
                var menu = product[index]
                var xpath = "//li[@title='"+menu+"']";
                console.log(xpath);
                  CommonKeyword.clickElement(xpath)
               
               let subproduct = await I.grabAttributeFrom("//ul[2]//li[contains(@class,'menu-item')]", 'title');

               console.log(subproduct);

               for (let index = 0; index < subproduct.length; index++) {
                
                   try {    
                        var submenu = subproduct[index];
                        console.log(submenu);

                        var newmenu = subproduct[index]
                        var xpathnew = "//ul[2]//li[@title='"+newmenu+"']";
                        if(submenu.includes(`Buyer's Desk`)){
                          // var  buyer = "//ul[2]//li[contains(@title,'Buyer')]"
                          // let value = await visibleelement.checkIfElementPresent(buyer+"//i");
                          // CommonKeyword.clickElement(buyer);
                          break;
                        }else{
                        console.log(xpathnew);
                        
                         
                        }
                          // I.seeInCurrentUrl('/'+ newmenu);
                          I.wait(3);
                         let value = await visibleelement.checkIfElementPresent(xpathnew+"//i");
                         console.log(value+"---------------------------------------->");
                         if(value===true){

                          CommonKeyword.clickElement(xpathnew);
                          let thirdlvl = await I.grabAttributeFrom("//ul[3]//li[contains(@class,'menu-item')]", 'title');

                          console.log(thirdlvl);

               for (let indexT = 0; indexT < thirdlvl.length; indexT++) {

                var thirdlvlmenu = thirdlvl[indexT];
                        console.log(thirdlvlmenu);

                        var thrd = thirdlvl[indexT]
                        var xpaththrd = "//ul[3]//li[@title='"+thrd+"']";
                        CommonKeyword.clickElement(xpaththrd);
                        let tabthdlvl = await I.grabNumberOfOpenTabs();
                          console.log(tabthdlvl);
                        if(tabthdlvl>1){
                          I.switchToNextTab();
                          I.closeCurrentTab();
                          CommonKeyword.clickElement(`//i[contains(@class,'icon icon-close')]`);
                        }
                        I.click("//dew-navbar//span[contains(@class,'menu-link')]");
                        I.wait(3);
                          CommonKeyword.clickElement(xpath);
                          CommonKeyword.clickElement(xpathnew);
                          let subproductT = await I.grabAttributeFrom("//ul[2]//li[contains(@class,'menu-item')]", 'title');
                          subproduct =subproductT;
                          let productT = await I.grabAttributeFrom("//li[contains(@class,'menu-item')]", 'title');
                          product=productT;
               }

                         }
                         else{
                          CommonKeyword.clickElement(xpathnew);
                          
                          I.wait(3);
                          let tabs = await I.grabNumberOfOpenTabs();
                          console.log(tabs);
                         
                         if(tabs>1){
                           I.switchToNextTab();
                           I.closeCurrentTab();
                           CommonKeyword.clickElement(`//i[contains(@class,'icon icon-close')]`);
                         }
                          
                          I.click("//dew-navbar//span[contains(@class,'menu-link')]");
                          I.wait(3);
                          CommonKeyword.clickElement(xpath)
               }
              }
              
              catch (error) {
                console.log('That did not go well.')
                throw error
              }
           
            


               let productN = await I.grabAttributeFrom("//li[contains(@class,'menu-item')]", 'title');
               console.log(productN);
               product=productN;
               console.log(productN);
               
                
          }
               
        }
        

    }

}
}
module.exports = new HomeProductNavigation();
// exports.homeProductnavigation = homeProductnavigation;