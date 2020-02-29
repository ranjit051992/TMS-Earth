const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iOnlineStore = require("./OnlineStoreObject");
const prop = global.confi_prop;
module.exports={

    /** 
     * fill search item name in search field
     * 
     * @param itemName
     * 
    */
    async fillSearchItem(itemName)
    {
        I.scrollIntoView(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX));
        I.waitForVisible(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX));
        I.fillField(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX),itemName);
        logger.info(`Entered item name : ${itemName}`);
        
    },

    /** 
     * clicks on search icon
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnSearchIcon()
   {
       I.waitForVisible(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
       I.pressKey('Enter');
       logger.info(`clicked on Search icon`);
       
   },

   /** 
     * fill quantity in for specific item 
     * 
     * @param itemName, quantity
     * 
    */
   async fillItemQuantity(itemName,quantity)
   {
       I.waitForVisible("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//input[@aria-label='Quantity']",prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//input[@aria-label='Quantity']",prop.DEFAULT_MEDIUM_WAIT);
       I.clearField("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//input[@aria-label='Quantity']");
       I.fillField("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//input[@aria-label='Quantity']",quantity);
       logger.info(`Entered item quantity : ${quantity}`);
   },

   /** 
     * clicks on add to cart button present against specific item
     * 
     * @param itemName
     * @returns   
     * 
    */
   async clickOnAddToCartButton(itemName)
   {
       I.waitForVisible("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//button[contains(@class,'btn primary')]",prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//button[contains(@class,'btn primary')]",prop.DEFAULT_MEDIUM_WAIT);
       I.click("//span[contains(text(),'"+itemName+"')]//ancestor::dew-card//button[contains(@class,'btn primary')]");
       logger.info(`clicked on add to cart button`); 
   },

   /** 
     * clicks on cart icon
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnCartIcon()
   {
       I.waitForVisible(global.uiElements.get(iOnlineStore.CART_ICON),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable(global.uiElements.get(iOnlineStore.CART_ICON),prop.DEFAULT_MEDIUM_WAIT);
       I.click(global.uiElements.get(iOnlineStore.CART_ICON));
       logger.info(`clicked on Cart icon`); 
   },

   /** 
     * fill search item name in search field & hit search icon
     * 
     * @param itemName
     * @returns   
     * 
    */
   async searchItem(itemName)
   {
       await this.fillSearchItem(itemName);
       await this.clickOnSearchIcon();
       await I.waitForVisible("//span[contains(text(),'"+itemName+"')]",prop.DEFAULT_MEDIUM_WAIT);
       await I.seeElement("//span[contains(text(),'"+itemName+"')]");
       logger.info("Item is searched.");
   },

   /** 
     * search item, fill quantity & add it to cart
     * 
     * @param itemName , quantity
     * @returns   
     * 
    */
   async addItemToCart(itemName,quantity)
   {
        this.searchItem(itemName);
        this.fillItemQuantity(itemName,quantity);
        this.clickOnAddToCartButton(itemName);
        I.waitForVisible(global.uiElements.get(iOnlineStore.ADD_TO_CART_SUCCESS_MSG),prop.DEFAULT_MEDIUM_WAIT);
        logger.info("Add to cart success msg is displayed. Item "+itemName+" is added to cart.");
   },

   /** 
     * click on Online Store link present at the top
     * 
     * @param
     * @returns   
     * 
    */
   async clickOnOnlineStoreLink()
   {
       I.scrollIntoView(global.uiElements.get(iOnlineStore.ONLINE_STORE_LINK));
       I.waitForVisible(global.uiElements.get(iOnlineStore.ONLINE_STORE_LINK),prop.DEFAULT_MEDIUM_WAIT);
       I.click(global.uiElements.get(iOnlineStore.ONLINE_STORE_LINK));
   },

   /** 
     * Wait for loading spinner to go off & item search textbox to be visible
     * 
     * @param
     * @returns   
     * 
    */
   async waitForOnlineStoreToLoad()
   {
       I.waitForInvisible(global.uiElements.get(iOnlineStore.SPINNER),prop.DEFAULT_MEDIUM_WAIT);
       I.waitForVisible(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
       logger.info("Online Store page is loaded.");
   },

    /** 
     * Check whether search result display items as per searched item name
     * 
     * @param itemName
     * @returns   
     * 
    */
   async checkSearchItemReqults(itemName)
   {
       let searchResultXpath = `//eproc-product-list//span[contains(text(),'${itemName}')]`;
       let searchedItems = await I.grabNumberOfVisibleElements(searchResultXpath);
       let isGreater = false;
       if(searchedItems>0)
       {
           isGreater = true;
       }

       return isGreater;
   },

   async checkItemsInFavorites()
   {
       let isPresent = true;
        let noOfElements = await I.grabNumberOfVisibleElements(global.uiElements.get(iOnlineStore.NO_FAV_PRODUCT_DATA_MSG));
        if(noOfElements>0)
        {
            isPresent = false
            await logger.info("No data present for favorite items.");
        }
        else
        {
            await logger.info("Data is present for favorite items.");
        }

        return isPresent;
   },

   /** 
     * Checks whether items are present under favorites tab, if found any then clicks on view all button
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnFavoritesViewAllButton()
   {
        await I.waitForVisible(global.uiElements.get(iOnlineStore.VIEW_ALL_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(global.uiElements.get(iOnlineStore.VIEW_ALL_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
        await I.click(global.uiElements.get(iOnlineStore.VIEW_ALL_BUTTON));
        await I.waitForVisible(global.uiElements.get(iOnlineStore.ITEM_CHECKBOX),prop.DEFAULT_MEDIUM_WAIT);
        await logger.info("Clicked on view all button present in favorites section.");
   },

   async selectAllFavoriteItems()
   {
        let noOfElements = await I.grabNumberOfVisibleElements(global.uiElements.get(iOnlineStore.ITEM_CHECKBOX));
        for(let i=1;i<=noOfElements;i++)
        {
            let xpath = await "("+global.uiElements.get(iOnlineStore.ITEM_CHECKBOX)+")["+i+"]";
            await I.click(xpath);
        }
   },
   async clickOnMenuIcon()
   {
        let noOfElements = await I.grabNumberOfVisibleElements(global.uiElements.get(iOnlineStore.MULTISELECT_MENU_ICON));
        if(noOfElements>0)
        {
            await I.scrollIntoView(global.uiElements.get(iOnlineStore.MULTISELECT_MENU_ICON));
            await I.waitForVisible(global.uiElements.get(iOnlineStore.MULTISELECT_MENU_ICON),prop.DEFAULT_MEDIUM_WAIT);
            await I.waitForClickable(global.uiElements.get(iOnlineStore.MULTISELECT_MENU_ICON),prop.DEFAULT_MEDIUM_WAIT);
            await I.click(global.uiElements.get(iOnlineStore.MULTISELECT_MENU_ICON));
        }
   },

   async SelectOnMenuOption(option)
   {
        let noOfElements = await I.grabNumberOfVisibleElements(global.uiElements.get(iOnlineStore.MULTISELECT_MENU_OPTION));
        for(let i=1;i<=noOfElements;i++)
        {
            let optionXpath = await "("+global.uiElements.get(iOnlineStore.MULTISELECT_MENU_OPTION)+")["+i+"]";
            let text = await I.grabTextFrom(optionXpath);
            console.log("Actual Option : "+text+" Expected "+option);
            
            if(text === option)
            {
                await I.waitForClickable(optionXpath);
                await I.click(optionXpath);
                break;
            }
        }
   },

   async clickOnFavoritesIcon(itemName)
   {
        // pause();
        let favoriteIconXpath = "//span[text()='"+itemName+"']"+global.uiElements.get(iOnlineStore.FAVORITE_ICON);
       
       let totalIcons = await I.grabNumberOfVisibleElements(favoriteIconXpath);
       logger.info("total fav icon "+totalIcons);

       let totalMarked = 0;
       for(let i=1;i<=totalIcons;i++)
       {
           let xpath = "("+favoriteIconXpath+")["+i+"]";
           logger.info(" fav icon xpath "+xpath);

           let attr = await I.grabAttributeFrom(xpath,"class");
           
           logger.info("Attribute classname "+attr);
        //    if(attr.includes('fill'))
        //    {
                await I.waitForVisible(xpath,prop.DEFAULT_MEDIUM_WAIT);
                await I.waitForClickable(xpath,prop.DEFAULT_MEDIUM_WAIT);
                await I.click(xpath);     
                logger.info("Clicked on fav icon");
                await totalMarked++;    
           //}
           
       }

       await logger.info("Total items marked favorite are : "+totalMarked);
       return totalMarked;
   },

   async addItemsToFavorites(itemName)
   {
        let totalItemsMarked = await this.clickOnFavoritesIcon(itemName);
   },

   async verifyFavoriteItems(itemName,totalFav)
   {
       let noOfElements = await I.grabNumberOfVisibleElements("//span[text()='"+itemName+"']");
       let isEqual = false;
       if(noOfElements===totalFav)
       {
           isEqual = true;
           await logger.info("Favorites item validated successfully. Expected Favorites : "+totalFav+" Actual Favorites : "+noOfElements);
       }

       return isEqual;
   },

   async selectMultipleItems()
   {
       let itemCheckboxXpath = await global.uiElements.get(iOnlineStore.ITEM_CHECKBOX);
       let noOfElements = await I.grabNumberOfVisibleElements(itemCheckboxXpath);
       let itemDetailsArray = new Array();
       let j = 1;
       for(let i =1;i<=noOfElements;i++)
       {

           let itemXpath = await global.uiElements.get(iOnlineStore.ITEM_NAME);
           let supplierNameXpath = await  global.uiElements.get(iOnlineStore.SUPPLIER_NAME);
           let uomXpath = await global.uiElements.get(iOnlineStore.UOM);
           let unitPriceXpath = await global.uiElements.get(iOnlineStore.UNIT_PRICE);
           let userCurrencyXpath = await global.uiElements.get(iOnlineStore.USER_CURRENCY);
           let checkboxXpath = "("+global.uiElements.get(iOnlineStore.ITEM_CHECKBOX)+")["+i+"]";
           if(j<4)
           {
                if(true)
                {
                    await I.waitForVisible("("+itemXpath+")["+i+"]",prop.DEFAULT_MEDIUM_WAIT);
                    let item = await I.grabTextFrom("("+itemXpath+")["+i+"]");

                    await I.waitForVisible("("+supplierNameXpath+")["+i+"]",prop.DEFAULT_MEDIUM_WAIT);
                    let supplierName = await I.grabTextFrom("("+supplierNameXpath+")["+i+"]");

                    await I.waitForVisible("("+unitPriceXpath+")["+i+"]",prop.DEFAULT_MEDIUM_WAIT);
                    let unitPrice = await I.grabTextFrom("("+unitPriceXpath+")["+i+"]");

                   // await I.waitForVisible("("+userCurrencyXpath+")["+i+"]",prop.DEFAULT_MEDIUM_WAIT);
                    let userCurrency = await I.grabTextFrom("("+userCurrencyXpath+")["+i+"]");

                    await I.waitForVisible("("+uomXpath+")["+i+"]",prop.DEFAULT_MEDIUM_WAIT);
                    let uom = await I.grabTextFrom("("+uomXpath+")["+i+"]");

                    let finalPriceAfterDiscount;
                    if(userCurrency.length>0)
                    {
                        finalPriceAfterDiscount = unitPrice+" / "+uom+" "+userCurrency+" / "+uom;
                        unitPrice = unitPrice+" "+userCurrency;
                    
                    }
                    else
                    {
                        finalPriceAfterDiscount = unitPrice+" / "+uom;
                    }

                    await I.waitForClickable(checkboxXpath,prop.DEFAULT_MEDIUM_WAIT);
                    await I.click(checkboxXpath);

                    let details = new Array();

                    details.push(item.trim());
                    details.push(unitPrice.trim());
                    details.push(finalPriceAfterDiscount.trim());
                    details.push(supplierName.toUpperCase().trim());

                    itemDetailsArray.push(details);
                }
                
                j++;

            }
            else
            {
                break;
            }

       }

       return itemDetailsArray;
   },

   async clickOnCompareButton()
   {
       await I.waitForVisible(global.uiElements.get(iOnlineStore.COMPARE_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
       await I.waitForClickable(global.uiElements.get(iOnlineStore.COMPARE_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
       await I.click(global.uiElements.get(iOnlineStore.COMPARE_BUTTON));
       await I.waitForVisible(global.uiElements.get(iOnlineStore.COMPARE_GRID));
       logger.info("Clicked on Compare button.");

   },

   async checkIfCompareButtonPresent()
   {
      let noOfElements =  await I.grabNumberOfVisibleElements(global.uiElements.get(iOnlineStore.COMPARE_BUTTON));
      let isPresent = false;
      if(noOfElements>0)
      {
          isPresent = true;
          logger.info("Compare button is present.");
      }
      else
      {
        logger.info("Compare button is not present.");
      }

      return isPresent;
   },

   async getItemName(index)
   {
        let xpath = "("+global.uiElements.get(iOnlineStore.COMPARE_ITEM_NAME)+")["+index+"]";
        let name = await I.grabTextFrom(xpath);
        return name.trim();
   },

   async getUnitPrice(index)
   {
        let xpath = "("+global.uiElements.get(iOnlineStore.COMPARE_UNIT_PRICE)+")["+index+"]";
        let price = await I.grabTextFrom(xpath);
        price = price.replace('\n',' ').trim();
        return price;
   },

   async getFinalPriceAfterDiscount(index)
   {
        let xpath = "("+global.uiElements.get(iOnlineStore.FINAL_PRICE_AFTER_DISCOUNT)+")["+index+"]";
        let finalPrice = await I.grabTextFrom(xpath);
        finalPrice = finalPrice.replace('\n',' ').trim();
        return finalPrice;
   },

   async getSupplier(index)
   {
        let xpath = "("+global.uiElements.get(iOnlineStore.SUPPLIER)+")["+index+"]";
        let supplier = await I.grabTextFrom(xpath);
        return supplier.trim();
   },

   async fetchComparedItemDetails()
   {
      // pause();
        let comparedItemsDetails = new Array();
        await I.waitForVisible(global.uiElements.get(iOnlineStore.COMPARE_COLUMN),prop.DEFAULT_MEDIUM_WAIT);
        let noOfElements = await I.grabNumberOfVisibleElements(global.uiElements.get(iOnlineStore.COMPARE_COLUMN));
        while(noOfElements>0)
        {
            let itemDetails = new Array();

            let item = await this.getItemName(noOfElements);
            itemDetails.push(item);

            let unitPrice = await this.getUnitPrice(noOfElements);
            itemDetails.push(unitPrice);

            let finalPriceAfterDiscount = await this.getFinalPriceAfterDiscount(noOfElements);
            itemDetails.push(finalPriceAfterDiscount);
            
            let supplier = await this.getSupplier(noOfElements);
            itemDetails.push(supplier);

            comparedItemsDetails.push(itemDetails);
            
            noOfElements--;
        }

        return comparedItemsDetails;
   },

   async verifyComparedItems(expectedDetails,actualDetails)
   {
        let flagArray = new Array();
        let isEqual = true;
        for(let expectedDetail of expectedDetails)
        {
            let flag = 0;
            for(let actualDetail of actualDetails)
            {              
                if(JSON.stringify(expectedDetail)===JSON.stringify(actualDetail))
                {
                    flag = 1;
                    logger.info("Equal");
                }
                
            }    

            if(flag ===1)
            {
                flagArray.push("true");

            }
            else
            {
                flagArray.push("false");

            }
        
        }

        logger.info("flagArray : "+flagArray);

        if(flagArray.includes("false"))
        {
            isEqual = false;
        }
        return isEqual;
   },

    /** 
     * Checks whether baskets are present under baskets tab, if found any then clicks on view all button
     * 
     * @param 
     * @returns   
     * 
    */
   async clickOnBasketViewAllButton()
   {
        await I.waitForVisible(global.uiElements.get(iOnlineStore.BASKET_VIEW_ALL_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(global.uiElements.get(iOnlineStore.BASKET_VIEW_ALL_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
        await I.click(global.uiElements.get(iOnlineStore.BASKET_VIEW_ALL_BUTTON));
        await I.waitForVisible(global.uiElements.get(iOnlineStore.BASKET_NAME),prop.DEFAULT_MEDIUM_WAIT);
        logger.info("Clicked on view all button present in baskets section.");
   },

   /** 
     * Checks whether baskets are present under baskets tab, if found any then clicks on view all button
     * 
     * @param 
     * @returns   
     * 
    */
   async fetchBasketNames()
   {
        await I.waitForVisible(global.uiElements.get(iOnlineStore.BASKET_NAME),prop.DEFAULT_MEDIUM_WAIT);
        let basketNames = await I.grabTextFrom(global.uiElements.get(iOnlineStore.BASKET_NAME));
        logger.info("Total baskets present are : "+basketNames);
        return basketNames;
   },

   async getCurrentSortOrder()
   {
        await I.waitForVisible(global.uiElements.get(iOnlineStore.BASKET_SORT_ORDER_LABEL),prop.DEFAULT_MEDIUM_WAIT);
        let currentOrder = await I.grabTextFrom(global.uiElements.get(iOnlineStore.BASKET_SORT_ORDER_LABEL));
        logger.info("Current basket sort order is : "+currentOrder);
        return currentOrder;
   },

   async clickOnSortIcon()
   {
        await I.waitForVisible(global.uiElements.get(iOnlineStore.BASKET_SORT_ICON),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(global.uiElements.get(iOnlineStore.BASKET_SORT_ICON),prop.DEFAULT_MEDIUM_WAIT);
        await I.click(global.uiElements.get(iOnlineStore.BASKET_SORT_ICON));
        await I.waitForVisible(global.uiElements.get(iOnlineStore.BASKET_NAME),prop.DEFAULT_MEDIUM_WAIT);
        logger.info("Clicked on sort icon.");
   },

   /** 
     * Checks whether baskets are present under baskets tab, if found any then clicks on view all button
     * 
     * @param 
     * @returns   
     * 
    */
   async verifySortedBaskets(sortOder,originalBaskets,sortedBaskets)
   {
       let isSorted = false;
       if(sortOder=="Sort by A-Z")
       {
           originalBaskets.sort();
           logger.info("A-Z : expected sort : "+originalBaskets+" Actual sort : "+sortedBaskets);
           if(JSON.stringify(originalBaskets)===JSON.stringify(sortedBaskets))
           {
               isSorted = true;
           }
       }
       else
       {
            originalBaskets.sort();
            originalBaskets.reverse()
            logger.info("Z-A : expected sort : "+originalBaskets+" Actual sort : "+sortedBaskets);

            if(JSON.stringify(originalBaskets)===JSON.stringify(sortedBaskets))
            {
                isSorted = true;
            }
       }
       logger.info("Baskets sorted in '"+sortOder+"' : "+isSorted);
       return isSorted;
   },
}