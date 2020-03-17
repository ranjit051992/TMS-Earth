const { I ,CommonKeyword} = inject();
const DewNavBar = require("dd-cc-zycus-automation/components/dewNavBar");

class HomeProductNavigation {

    async productNavigation () {

       // let result = await I.click("//div[@class='menu-btn mr-3']/span");
        //console.log(result);
        I.wait(5);
        let product = await I.grabAttributeFrom("//li[contains(@class,'menu-item')]", 'title');
         console.log(product);

         for (let index = 0; index < product.length; index++) {
             var element = product[index];
             console.log(element);
             if (index>2) 
              {
                var menu = product[index]
                var xpath = "//li[@title='"+menu+"']";
                console.log(xpath);
                  I.click(xpath)
               
               let subproduct = await I.grabAttributeFrom("//ul[2]//li[contains(@class,'menu-item')]", 'title');

               console.log(subproduct);

               for (let index = 0; index < subproduct.length; index++) {
                   try {    
                        var submenu = subproduct[index];
                        console.log(submenu);

                        var newmenu = subproduct[index]
                        var xpathnew = "//li[@title='"+newmenu+"']";
                        
                        console.log(xpathnew);
                        
                          I.click(xpathnew);
                          
                          I.wait(5);

                          // I.seeInCurrentUrl('/'+ newmenu);
                          I.wait(5);

                          let url = await I.grabCurrentUrl();
                          console.log(`Current URL is [${url}]`);
                         var n = url.includes("dewdrops");
                         console.log(n)
                         if(n==false){
                           I.closeCurrentTab
                         }
                          
                          DewNavBar.clickHamburger();
                          I.wait(3);
                          I.click(xpath)
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