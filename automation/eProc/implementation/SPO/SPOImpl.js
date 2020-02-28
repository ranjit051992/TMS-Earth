const { I } = inject();
const iSPOobject = require("./iSPOobjectobjects");
const logger = require("./..//..//..//Framework/FrameworkUtilities/Logger/logger");

async function clickonTab(tabList, tabName)
{
    let tabListName = await I.grabTextFrom(iSPOobject.TAB_NAME_LIST);

    console.log(tabListName);
}

function clickOnCostAllocationTab()
{
    I.seeElement(iSPOobject.COST_ALLOCATION_TAB);
    I.click(iSPOobject.COST_ALLOCATION_TAB);
    logger.info("Clicked on Cost Allocation Tab");
}

function clickOnAssignCostNOButton()
{
    I.seeElement(iSPOobject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON);
    I.click(iSPOobject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON);
    logger.info("Clicked on Assign cost Project No Button");
}

function clickOnBookCostToSingle_MultipleCostCenter()
{
    I.seeElement(iSPOobject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON);
    I.click(iSPOobject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON);
    logger.info("Clicked on Book Cost To Single/Multiple Cost center");
}

function enterCostCenter(costCenter)
{
    I.seeElement(iSPOobject.COST_CENTER_INPUT_FIELD);
    I.fillField(iSPOobject.COST_CENTER_INPUT_FIELD, costCenter);
    const xpath = `//div[contains(text(),'${costCenter}')]`;
    I.waitForVisible(xpath, 5);
    I.click(xpath);
    logger.info(`Enter Cost Center: ${costCenter}`);
}

function clickOnAddLineItemButton()
{
    I.seeElement(iSPOobject.ADD_LINE_ITEM_BUTTON);
    I.click(iSPOobject.ADD_LINE_ITEM_BUTTON);
    logger.info("Clicked on Add Line Item Button");
}
function enterItemName(itemName)
{
    I.seeElement(iSPOobject.ITEM_NAME_INPUT);
    I.fillField(iSPOobject.ITEM_NAME_INPUT, itemName);
    logger.info(`Entered item name: ${itemName}`);
}

function selectItemOption(itemName)
{
    I.seeElement(iSPOobject.FIRST_ITEMNAME_OPTION);
    I.click(iSPOobject.FIRST_ITEMNAME_OPTION);
    logger.info(`Selected first item option: ${itemName}`);
}

function clickOnCostBookingLink(itemName)
{
    let costBookingLink = `(//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3])`;
    I.seeElement(costBookingLink);
    I.click(costBookingLink);
    logger.info("Clicked on Cost booking Link");
}

function fillGlAccount(glAccount)
{
    I.seeElement(iSPOobject.GLACCOUNT);
    I.fillField(iSPOobject.GLACCOUNT, glAccount);
    let glAccountSuggXpath = `//div[contains(text(),'${glAccount}')]`;
    I.waitForVisible(glAccountSuggXpath, 5);
    I.click(glAccountSuggXpath);
    logger.info(`Selected GlAccount: ${glAccount}`);
}

function clickOnCostBookingSaveButton()
{
    I.seeElement(iSPOobject.COSTBOOKING_SAVE_BUUTON);
    I.click(iSPOobject.COSTBOOKING_SAVE_BUUTON);
    logger.info("Clicked on Save Button");
}

function clickOnRemoveAllTaxesButton()
{
    I.seeElement(iSPOobject.REMOVE_ALL_TAXES_BUTTON);
    I.click(iSPOobject.REMOVE_ALL_TAXES_BUTTON);
    logger.info("Clicked on Remove All Taxes Button");
}

function clickOnSubmitPOButton()
{
    I.seeElement(iSPOobject.SUBMIT_PO_BUTTON);
    I.click(iSPOobject.SUBMIT_PO_BUTTON);
    logger.info("CLicked on Submit PO Button");
}

function fillNonCoaAtHeaderLevel(spoBO)
{
    if(spoBO.getReqAssignedCost()!=null)
    {
        if(spoBO.getReqAssignedCost() === 'Yes')
        {

        }
        else
        {
            clickOnAssignCostNOButton();
        }
    }

    if(spoBO.isReqBookCostToSingleCostCenter())
    {
        clickOnBookCostToSingle_MultipleCostCenter();
        enterCostCenter(spoBO.getCostCenter());
    }
}

