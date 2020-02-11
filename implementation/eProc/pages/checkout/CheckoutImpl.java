package eProc.pages.checkout;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import eProc.bo.CatalogItemBO;
import eProc.bo.ItemsBO;
import eProc.bo.RequisitionBO;
import eProc.pages.addItem.AddItem;
import eProc.pages.cart.CartImpl;
import eProc.pages.onlineStore.OnlineStoreImpl;
import eProc.pages.requisitionListing.IRequisitionListing;
import eProc.productUtilities.CommonUtilities;
import eProc.productUtilities.constants.Constants;
import framework.action.ActionBot;
import framework.utilities.GetData;
import framework.utilities.GlobalVariable;
import framework.utilities.driverFactory.DriverSelector;
import framework.utilities.screenshot.Screenshot;
import framework.utilities.webElementWrapper.WebElementWrapper;
import org.apache.commons.lang.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.DriverFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CheckoutImpl implements ICheckout{

    public static Logger logger = Logger.getLogger(CheckoutImpl.class);

        private HashSet<Character> vowels;

        @Step("Vowels in English language are <vowelString>.")
        public void setLanguageVowels(String vowelString) {
        vowels = new HashSet<>();
        for (char ch : vowelString.toCharArray()) {
            vowels.add(ch);
        }
    }

        @Step("The word <word> has <expectedCount> vowels.")
        public void verifyVowelsCountInWord(String word, int expectedCount) {
        int actualCount = countVowels(word);
        assertEquals(expectedCount, actualCount);
    }

        @Step("Almost all words have vowels <wordsTable>")
        public void verifyVowelsCountInMultipleWords(Table wordsTable) {
        for (TableRow row : wordsTable.getTableRows()) {
            String word = row.getCell("Word");
            int expectedCount = Integer.parseInt(row.getCell("Vowel Count"));
            int actualCount = countVowels(word);

            assertEquals(expectedCount, actualCount);
        }
    }

        private int countVowels(String word) {
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (vowels.contains(ch)) {
                count++;
            }
        }
        return count;
    }


        @Step("This is a step <id>")
        public void implementation1(Object arg0) {

    }


    public static void clickOnBasicDetailsLink(WebDriver driver, String testCaseName) throws Exception
    {
       ActionBot.clickOnTab(driver, ICheckout.CHECKOUT_PAGE_TAB_LIST, ICheckout.BASIC_DETAILS_TAB);
       logger.info("Clicked on Basic Details tab on online store page");
    }

    public static String enterRequisitionName(WebDriver driver, String requisitionName) throws Exception
    {
        ActionBot.click(driver, ICheckout.REQUISITION_NAME);
        ActionBot.clear(driver,  ICheckout.REQUISITION_NAME);
        ActionBot.sendKeys(driver,  ICheckout.REQUISITION_NAME, requisitionName);

        requisitionName = ActionBot.getTextWithinElement(driver,  ICheckout.REQUISITION_NAME);
        logger.info("Entered requisition name --> " + requisitionName);
        return requisitionName;
    }

    public static void clickOnBuyingUnitEditButton(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.BUYING_UNIT);
        logger.info("Clicked on Buying unit Edit icon");
    }

    public static void fillCBLFormField(WebDriver driver, String inputFieldElementPath, String suggestionElementPath, String value) throws Exception
    {
        String textfieldXpath = WebElementWrapper.getXpath(inputFieldElementPath);
        String suggestedValueXpath = "//div[contains(text(),'" + value + "')]";
        ActionBot.fillAutoCompleteItem(driver, MDC.get("TestCaseName").toString(), textfieldXpath, suggestedValueXpath, value);
    }

    public static String enterCompanyName(WebDriver driver, String companyName) throws Exception
    {
        fillCBLFormField(driver, ICheckout.COMPANY_NAME, ICheckout.COMPANY_FIRST_OPTION, companyName);

        companyName = ActionBot.getTextWithinElement(driver, ICheckout.COMPANY_NAME);
        logger.info("Entered company name --> " + companyName);
        return companyName;
    }

    public static String enterBusinessUnit(WebDriver driver, String businessUnit) throws Exception
    {
        fillCBLFormField(driver, ICheckout.BUSINESS_UNIT, ICheckout.BUSINESS_FIRST_OPTION, businessUnit);

        businessUnit = ActionBot.getTextWithinElement(driver, ICheckout.BUSINESS_UNIT);
        logger.info("Entered business unit --> " + businessUnit);
        return businessUnit;
    }

    public static String enterLocation(WebDriver driver, String location) throws Exception
    {
        fillCBLFormField(driver, ICheckout.LOCATION, ICheckout.LOCATION_FIRST_OPTION, location);

        location = ActionBot.getTextWithinElement(driver, ICheckout.LOCATION);
        logger.info("Entered location --> " + location);
        return location;
    }

    public static String enterCurrency(WebDriver driver, String currency) throws Exception
    {
        fillCBLFormField(driver, ICheckout.CURRENCY, ICheckout.CURRENCY_FIRST_OPTION, currency);

        currency = ActionBot.getTextWithinElement(driver, ICheckout.CURRENCY);
        logger.info("Entered currency --> " + currency);
        return currency;
    }

    public static void clickOnSaveButtonOnBuyingUnitPopUp(WebDriver driver) throws Exception
    {

        ActionBot.click(driver, ICheckout.BUYING_UNIT_DONE_BUTTON);
        logger.info("Clicked on Save button on Buying unit pop up");
    }

    public static String enterOnBehalfOf(WebDriver driver, String onBehalfOf,String testCaseName) throws Exception
    {
        try
        {
            ActionBot.click(driver, ICheckout.ON_BEHALF_OF);
            ActionBot.clear(driver, ICheckout.ON_BEHALF_OF);
            ActionBot.sendKeys(driver, ICheckout.ON_BEHALF_OF, onBehalfOf);

            ActionBot.click(driver, ICheckout.FIRST_ONBEHALF_VALUE);

            Screenshot.captureScreenshot(driver,testCaseName,"Entered on behalf of");
        }
        catch (Exception e)
        {
            ActionBot.click(driver, ICheckout.ON_BEHALF_OF);
            ActionBot.clear(driver, ICheckout.ON_BEHALF_OF);
            ActionBot.sendKeys(driver, ICheckout.ON_BEHALF_OF, onBehalfOf);

            ActionBot.click(driver, ICheckout.FIRST_ONBEHALF_VALUE);

            Screenshot.captureScreenshot(driver,testCaseName,"Entered on behalf of");
        }
        onBehalfOf = ActionBot.getTextWithinElement(driver, ICheckout.ON_BEHALF_OF);
        logger.info("Entered on behalf of --> " + onBehalfOf);
        return onBehalfOf;
    }

    public static void selectUrgentRequirementYesButton(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.RADIO_URGENT_YES_BUTTON);
        logger.info("Selected yes button for urgent requirement");
    }

    public static void selectUrgentRequirementNoButton(WebDriver driver) throws Exception
    {
         ActionBot.click(driver, ICheckout.RADIO_URGENT_NO_BUTTON);
        logger.info("Selected no button for urgent requirement");
    }

    public static String enterReasonForOrdering(WebDriver driver, String reasonForOrdering) throws Exception
    {
        ActionBot.click(driver, ICheckout.REASON_FOR_ORDERING_TEXTBOX);
        ActionBot.clear(driver, ICheckout.REASON_FOR_ORDERING_TEXTBOX);
        ActionBot.sendKeys(driver, ICheckout.REASON_FOR_ORDERING_TEXTBOX, reasonForOrdering);

        reasonForOrdering = ActionBot.getTextWithinElement(driver, ICheckout.REASON_FOR_ORDERING_TEXTBOX);
        logger.info("Entered reason for ordering --> " + reasonForOrdering);
        return reasonForOrdering;
    }

    public static String enterCommentForSupplier(WebDriver driver, String commentForSupplier) throws Exception
    {
        ActionBot.click(driver, ICheckout.COMMENT_FOR_SUPPLIER_TEXTBOX);
        ActionBot.clear(driver, ICheckout.COMMENT_FOR_SUPPLIER_TEXTBOX);
        ActionBot.sendKeys(driver, ICheckout.COMMENT_FOR_SUPPLIER_TEXTBOX, commentForSupplier);

        commentForSupplier = ActionBot.getTextWithinElement(driver, ICheckout.COMMENT_FOR_SUPPLIER_TEXTBOX);
        logger.info("Entered comment for supplier --> " + commentForSupplier);
        return commentForSupplier;
    }

    public static void clickOnAdditionalDetailsLink(WebDriver driver) throws Exception
    {
        // ActionBot.click(driver, "FlowOR/Requisition/Additional Details/link_
        // additional details");
        ActionBot.clickOnTab(driver, ICheckout.CHECKOUT_PAGE_TAB_LIST, ICheckout.ADDITIONAL_DETAILS_TAB);
        logger.info("Clicked on Additional Details tab");
    }

    public static String selectPurchaseType(WebDriver driver, String purchaseType) throws Exception
    {
        ActionBot.click(driver, ICheckout.PURCHASE_TYPE);

        String purchaseTypeXpath = "//a[@class='dropdown-item text-capitalize p-0' and contains(text(),'" + purchaseType + "')]";

        ActionBot.waitUntilVisibleByXpath(driver,purchaseTypeXpath);
        ActionBot.clickByXpath(driver, purchaseTypeXpath);

        logger.info("Selected purchase type --> " + purchaseType);
        return purchaseType;
    }

    public static String selectSettlementViaInvoice(WebDriver driver) throws Exception
    {

        ActionBot.click(driver, ICheckout.SELECT_SETTLEMENT_VIA);
        ActionBot.click(driver, ICheckout.SETTLEMENT_VIA_INVOICE);
        String settlementVia = ActionBot.getText(driver, ICheckout.SELECT_SETTLEMENT_VIA);
        return settlementVia;
    }

    public static void selectSettlementViaUserPCard(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.SELECT_SETTLEMENT_VIA);
        ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_MEDIUM_WAIT);
        ActionBot.click(driver, ICheckout.SETTLEMENT_VIA_USER_PCARD);
        logger.info("Selected settlement via user p-card");
    }

    public static String selectPCard(WebDriver driver, String pCard) throws Exception
    {
        ActionBot.click(driver, ICheckout.INPUT_USER_P_CARD);
        ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_WAIT);
        String pcardOptionXpath = "//*[contains(text(),'" + pCard + "')]";
        ActionBot.clickByXpath(driver, pcardOptionXpath);

        // P-Card dropdown issue. Selecting first P-Card from populated
        // dropwdown.;
        pCard = ActionBot.getTextWithinElement(driver, ICheckout.INPUT_USER_P_CARD).trim();
        logger.info("Selected user p-card");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Selected user Pcard");
        return pCard;
    }

    public static void clickOnRespectivePurchaseYesButton(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.RADIO_PURCHASE_YES);
        logger.info("Selected yes button for respective purchase");
    }

    public static void clickOnNoButtonForSendPoToSupplier(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.RADIO_SEND_PO_TO_SUPPLIE_NO_BUTTON);
        logger.info("Clicked on No button for Send PO to Supplier");
    }

    public static void selectPurchaseOrder(WebDriver driver, String purchaseOrder) throws Exception
    {
        ActionBot.click(driver, ICheckout.SELECT_PURCHASE_ORDER);
        ActionBot.clear(driver, ICheckout.SELECT_PURCHASE_ORDER);
        ActionBot.sendKeys(driver, ICheckout.SELECT_PURCHASE_ORDER, purchaseOrder);

        ActionBot.click(driver, ICheckout.FIRST_PO_NUMBER);

        ActionBot.click(driver, ICheckout.PO_BUTTON_CONTINUE);

        logger.info("Selected purchase order --> " + purchaseOrder);

    }

    public static void addAttachmentFile(WebDriver driver, String filePath) throws Exception
    {
        if (ActionBot.isElementPresent(driver, ICheckout.INPUT_ADD_ATTACHMENT_FILE))
        {
            String xpath = WebElementWrapper.getXpath(ICheckout.INPUT_ADD_ATTACHMENT_FILE);
            WebElement element = ActionBot.findElementByXpath(driver, xpath);
            JavascriptExecutor jsexec = (JavascriptExecutor) driver;
            jsexec.executeScript("arguments[0].setAttribute('type','file');", element);
            //WebUI.scrollToElement(driver, findTestObject(driver, "FlowOR/Requisition/Add attachment/input_Add Attachment File"), GlobalVariable.DEFAULT_WAIT);
            element.sendKeys(filePath);
            Screenshot.captureScreenshot(driver,MDC.get("TestCaseName").toString() ,"File Attached");
            logger.info("Attached file");
        }
    }

    public static void clickOnShippingDetailsTab(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.SHIIPPING_DETAILS_TAB);
        logger.info("Clicked on Shipping Details tab");
    }

    public static String getDefaultShippingAddress(WebDriver driver) throws Exception
    {
        String defaultAddress = ActionBot.getText(driver, ICheckout.DEFAULT_SHIPPING_LABEL);
        logger.info("Default shipping address --> " + defaultAddress);
        return defaultAddress;
    }

    public static String selectOtherAddressOption(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.SHIP_ANOTHER_ADDRESS);

        ActionBot.click(driver, ICheckout.FIRST_SELECTED_ADDRESS);

        String address =  ActionBot.getText(driver,ICheckout.FIRST_SELECTED_ADDRESS);

        logger.info("Other address option selected --> " + address);
        return address;
    }

    public static String enterDeliverTo(WebDriver driver, String deliverTo) throws Exception
    {
        String elementXpath = "//div[@activeclass='bg-light-gray']";

        String deliverToXpath = WebElementWrapper.getXpath(ICheckout.DELIVER_TO);
        ActionBot.fillAutoCompleteItem(driver, MDC.get("TestCaseName").toString(), deliverToXpath, elementXpath, deliverTo);
        deliverTo = ActionBot.getTextWithinElement(driver, ICheckout.DELIVER_TO);
        logger.info("Deliver to selected --> " + deliverTo);
        return deliverTo;
    }

    public static String selectRequiredByDate(WebDriver driver) throws Exception
    {
        // ActionBot.scrollDownToElement(driver,'FlowOR/Requisition/Shipping
        // Details/text_Default Shipping Address");
        ActionBot.click(driver, ICheckout.REQUIRED_BY_DATE);

        ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

        String day = CommonUtilities.getTodayDay();

        String dayXpath = "//div[text()='" + day + "']/..";
        List<WebElement> dayElements = ActionBot.findElements(driver, dayXpath);
        for (int i = 0; i < dayElements.size(); i++)
        {
            dayXpath = "(//div[text()='" + day + "']/..)[" + (i + 1) + "]";
            boolean hasAttribute = false;
            try
            {
                hasAttribute =  ActionBot.verifyElementHasAttribute(driver,dayXpath,"disabled",GlobalVariable.DEFAULT_HIGH_WAIT);

            }
            catch (Exception e)
            {
                hasAttribute = false;
            }
            if (!hasAttribute)
            {
                try
                {
                    ActionBot.clickByXpath(driver, dayXpath);
                }
                catch (Exception e)
                {
                    ActionBot.clickByXpath(driver, dayXpath);
                }
                break;
            }

            if (i == (dayElements.size() - 1))
            {
                throw new Exception("Day not found in the calendar pop up");
            }
        }

        String requiredByDate = ActionBot.getTextWithinElement(driver, ICheckout.REQUIRED_BY_DATE);
        logger.info("Selected Required By date - " + requiredByDate);
        return requiredByDate;
    }

    public static void clickOnLineItemDetailsTab(WebDriver driver) throws Exception
    {
        //ActionBot.click(driver, "FlowOR/Requisition/Line Item Details/link_line item details");
        ActionBot.clickOnTab(driver, "Check_Out_Page/TabList", Constants.LINE_ITEMS_DETAILS_TAB);
        ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
        logger.info("Clicked on Line Item Details tab");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on Line Item Details tab");
    }

    public static void clickOnCostBookingDetailsLink(WebDriver driver, String itemName) throws Exception
    {
        String CostBookingDetails = "(//span[contains(text(),'" + itemName + "')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3])";
        // TestObject testObject = new TestObject();
        // testObject.addProperty("xpath", ConditionType.EQUALS,
        // CostBookingDetails);

        WebElement element = ActionBot.findElementByXpath(driver, CostBookingDetails);
        ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
        ActionBot.clickByXpath(driver, CostBookingDetails);
        logger.info("Clicked on Cost Booking Details link");
    }

    public static void clickOnBuyerTab(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.BUYERS_TAB);
        logger.info("Clicked on Buyers Tab");
    }

    public static void selectBuyerDropdownOption(WebDriver driver) throws Exception
    {
        // click on Buyer dropdown button;
        ActionBot.click(driver, ICheckout.BUYER_DROP_DOWN);
        Thread.sleep(2000);

        // wait for dropdown options;

        // select Buyer option from the drop down;
        // TestObject testObject = findObject("Check_Out_Page/Line Item Details
        // Tab/Shipping Asset Tagging/Buyers Tab/BuyerDropDownOptions");
        String valueOfXpath = WebElementWrapper.getXpath(ICheckout.BUYER_DROP_DOWN_OPTIONS);
        List<WebElement> options = driver.findElements(By.xpath(valueOfXpath));
        for (WebElement option : options)
        {
            String optionText = option.getText().trim();
            if (optionText.equalsIgnoreCase("Buyer"))
            {
                option.click();
                break;
            }
        }
        logger.info("Selected Buyer option from the Buyer dropdown button");
    }

    public static String enterBuyerInTextbox(WebDriver driver, String assignedBuyer) throws Exception
    {
        String elementXpath = "//p[@activeclass='bg-secondary']//span[@class='text-capitalize']";

        String buyerTextboxXpath = WebElementWrapper.getXpath(ICheckout.INPUT_BUYER_TEXTBOX);
        ActionBot.fillAutoCompleteItem(driver, MDC.get("TestCaseName").toString(), buyerTextboxXpath, elementXpath, assignedBuyer);
        logger.info("Entered assigned buyer --> " + assignedBuyer);

        return assignedBuyer;
    }

    public static void clickOnCostBookingTab(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.COST_BOOKING_TAB);
        logger.info("Clicked on CostBooking Tab");
    }

    public static void clickOnImDoneButton(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.I_AM_DONE_BUTTON);
        logger.info("Clicked on Im Done button");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on Im Done button");
    }

    public static void clickOnContinueButton(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.CONTINUE_BUTTON);
        logger.info("Clicked on Continue button");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on Continue button");
    }

/*    public static void waitForSearchFieldOnRequisitionListingPage(WebDriver driver) throws Exception
    {
        WebUI.waitForElementPresent(driver, findTestObject(driver, "FlowOR/Search Requisition/input _search requisition"), GlobalVariable.DEFAULT_HIGH_WAIT);
        WebUI.waitForElementVisible(driver, findTestObject(driver, "FlowOR/Search Requisition/input _search requisition"), GlobalVariable.DEFAULT_HIGH_WAIT);
    }*/

    public static void clickOnSaveAsDraftButton(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.SAVE_AS_DRAFT);
        logger.info("Clicked on Save as Draft button");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on Save as Draft button");
    }

   public static void clickOnCancelButton(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.CANCEL_BUTTON);
        logger.info("Clicked on Cancel button");

        // if confirm pop up exists, click on Yes button;
        boolean flag = false;
        flag = ActionBot.waitForElementVisible(driver,RECEIPT_CONFIRM_BUTTON);
        flag =  ActionBot.verifyElementVisible(driver,RECEIPT_CONFIRM_BUTTON);

        if (flag)
        {
            ActionBot.click(driver, "Receipt_Page/ConfirmButton");
            logger.info("Clicked on Yes, keep all items button");
        }
        else
        {
            logger.info("Confirmation pop up not present");
        }
    }

    public static boolean waitForLoadingSymbolToGoOff(WebDriver driver, String testCaseName) throws Exception
    {
        boolean flag = false;
        flag = ActionBot.waitForLoadingSymbolNotDisplayed(driver, testCaseName, ICheckout.LOADING_SPINNER, GlobalVariable.CONDITIONAL_WAIT);
        logger.info("Waited for loading symbol to go off");
        Screenshot.captureScreenshot(driver, testCaseName, "Waited for loading symbol to go off");
        return flag;
    }

    public static void clickOnCancelButtonOnConfirmationPopup(WebDriver driver, String testcaseName) throws Exception
    {
        try
        {
            ActionBot.click(driver, ICheckout.SUBMIT_REQUISITION_POPUP_CANCEL_BUTTON);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static String fetchTotalAmount(WebDriver driver, String testcaseName) throws Exception
    {
        String totalAmount = null;
        try

        {
            totalAmount = ActionBot.getText(driver, ICheckout.ITEM_TOTAL_AMOUNT);

        }
        catch (Exception e)
        {
            logger.info("Exception while fetching total amount at line level...!");
            throw e;
        }

        return totalAmount;
    }

    public static boolean verifySubmitReqConfirmationPopup(WebDriver driver, String testcaseName, String reqName, int itemCount, String totalAmount) throws Exception
    {
        boolean status = true;
        try
        {

            if (ActionBot.isElementPresent(driver, ICheckout.SUBMIT_REQ_POPUP))
            {
                Screenshot.captureScreenshot(driver, testcaseName, "Submit_Req_ConfirmationPopup");
                String confirmationMsg = ActionBot.getText(driver, ICheckout.SUBMIT_REQUISITION_MESSAGE);

                if (confirmationMsg.equals(CommonUtilities.getSubmitReqConfirmationMsg(reqName, totalAmount, itemCount)))
                {
                    logger.info("Confirmation message is displayed correctly after clicking 'I am Done' button." + "\n Message is : " + confirmationMsg);

                }
                else
                {
                    status = false;
                    logger.info("Confirmation message is not displayed correctly after clicking 'I am Done' button." + "\n Message is : " + confirmationMsg);
                }
                if (ActionBot.isElementPresent(driver, ICheckout.SUBMIT_REQUISITION_POPUP_CONTINUE_BUTTON))
                {
                    logger.info("'Continue' button is present on popup.");
                }
                else
                {
                    status = false;
                    logger.info("'Continue' button is not present on popup.");
                }

                if (ActionBot.isElementPresent(driver, ICheckout.SUBMIT_REQUISITION_POPUP_CANCEL_BUTTON))
                {
                    logger.info("'Cancel' button is present on popup.");
                }
                else
                {
                    status = false;

                    logger.info("'Cancel' button is not present on popup.");
                }

            }
            else
            {
                Screenshot.captureScreenshot(driver, testcaseName, "Submit_Req_ConfirmationPopup_Not_Present");
                status = false;
                logger.info("Confirmation message is not displayed after clicking 'I am Done' button.");
            }
        }
        catch (Exception e)
        {
            logger.info("Exception occured while verifying submit req confirmation popup...!");
            throw e;
        }

        return status;
    }

    public static boolean verifyNeedAQuoteConfirmationPopup(WebDriver driver, String testcaseName) throws Exception
    {
        boolean status = true;
        try
        {

            if (ActionBot.isElementPresent(driver, "FlowOR/Requisition/NeedAQuoteItem_SubmitReq/NeedAQuote_ConfirmationPopup"))
            {
                Screenshot.captureScreenshot(driver, testcaseName, "NeedAQuote_ConfirmationPopup");
                String confirmationMsg = ActionBot.getText(driver, "FlowOR/Requisition/NeedAQuoteItem_SubmitReq/ConfirmatioMessage");
                if (confirmationMsg.equals(Constants.REQ_NEED_A_QUOTE_CONFIRMATION_MSG))
                {
                    logger.info("Confirmation message is displayed correctly for 'Need A Quote' items after clicking 'I am Done' button." + "\n Message is : " + confirmationMsg);

                }
                else
                {
                    status = false;
                    logger.info("Confirmation message is not displayed correctly for 'Need A Quote' items after clicking 'I am Done' button." + "\n Message is : " + confirmationMsg);
                }
                if (ActionBot.isElementPresent(driver, "FlowOR/Requisition/NeedAQuoteItem_SubmitReq/SendForApprovalButton"))
                {
                    logger.info("'Yes, send for approval' button is present on popup.");
                }
                else
                {
                    status = false;
                    logger.info("'Yes, send for approval' button is not present on popup.");
                }

                if (ActionBot.isElementPresent(driver, "FlowOR/Requisition/NeedAQuoteItem_SubmitReq/ReturnBackToMeButton"))
                {
                    logger.info("'No, return it back to me' button is present on popup.");
                }
                else
                {
                    status = false;

                    logger.info("'No, return it back to me' button is not present on popup.");
                }
            }
            else
            {
                Screenshot.captureScreenshot(driver, testcaseName, "NeedAQuote_ConfirmationPopup_Not_Present");
                status = false;
                logger.info("Confirmation message is not displayed for 'Need A Quote' items after clicking 'I am Done' button.");
            }
        }
        catch (Exception e)
        {
            logger.info("Exception occured while verifying confirmation popup for 'Need A Quote' items...!");
            throw e;
        }

        return status;
    }

    public static void clickOnCommentsTab(WebDriver driver, String testCaseName) throws Exception
    {
        ActionBot.click(driver, "FlowOR/Requisition/Line Item Details/ShippingDetailsCommentsTab");
        logger.info("Clicked on Comments tab");
        Screenshot.captureScreenshot(driver, testCaseName, "Clicked on Comments tab");
    }

    public static void moveFocusOnBasicDetailsTab(WebDriver driver, String testCaseName) throws Exception
    {
        WebElement basicDetaisTabElement = ActionBot.findElement(driver, "FlowOR/Requisition/Basic Details/link_Basic details");
        ActionBot.moveToElement(driver, basicDetaisTabElement);
        logger.info("Moved focus on Basic Details Tab");
        Screenshot.captureScreenshot(driver, testCaseName, "Moved focus on Basic Details Tab");
    }

    public static void clearRequiredBy(WebDriver driver, String testCaseName) throws Exception
    {
        ActionBot.click(driver, "FlowOR/Requisition/Shipping Details/RequiredByFieldCrossIcon");
        logger.info("Cleared Required By field");
        Screenshot.captureScreenshot(driver, testCaseName, "Cleared Required By field");
    }

    public static void selectSettlementViaDisbursement(WebDriver driver) throws Exception
    {
        ActionBot.click(driver, ICheckout.SELECT_SETTLEMENT_VIA);

        ActionBot.click(driver, ICheckout.SETTLEMENT_VIA_DISBURSMENT);

        logger.info("Selected settlement via Disbursement");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Selected settlement via Disbursement");
    }

    public static void clickOnSendForApprovalButton(WebDriver driver, String testcaseName) throws Exception
    {
        try
        {
            ActionBot.click(driver, "FlowOR/Requisition/NeedAQuoteItem_SubmitReq/SendForApprovalButton");
            ActionBot.defaultSleep(driver, 10);
            Screenshot.captureScreenshot(driver, testcaseName, "After_Clicking_YesSendForApproval");
        }
        catch (Exception e)
        {
            logger.info("Exception occured while clicking on 'Yes, send for approval' button present on confirmation popup displayed for 'Need A Quote' items...!");
            throw e;
        }
    }

    public static void clickOnReturnBackToMeButton(WebDriver driver, String testcaseName) throws Exception
    {
        try
        {
            ActionBot.click(driver, "FlowOR/Requisition/NeedAQuoteItem_SubmitReq/ReturnBackToMeButton");
            ActionBot.defaultSleep(driver, 10);
            Screenshot.captureScreenshot(driver, testcaseName, "After_Clicking_ReturnBackToMe");
        }
        catch (Exception e)
        {
            logger.info("Exception occured while clicking on 'No, return it back to me' button present on confirmation popup displayed for 'Need A Quote' items...!");
            throw e;
        }
    }

    public static void closeNeedAQuotePopup(WebDriver driver, String testcaseName) throws Exception
    {
        try
        {
            ActionBot.click(driver, "FlowOR/Requisition/NeedAQuoteItem_SubmitReq/CloseButton");
            ActionBot.defaultSleep(driver, 10);
            Screenshot.captureScreenshot(driver, testcaseName, "After_Closing_NeedAQuotePopup");
        }
        catch (Exception e)
        {
            throw e;
        }

    }

    public static void clickOnShippingDetailsAndAssetTagging(WebDriver driver, String itemName) throws Exception
    {
        try
        {
            String assetTaggingXpath = WebElementWrapper.getXpath("FlowOR/Requisition/Shipping Details/LineLevelShippingDetailslink");
            ActionBot.clickByXpath(driver, assetTaggingXpath);
            ActionBot.waitUntilVisible(driver, "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ShippingAndAssetTaggingPage");
            logger.info("Clicked on Shipping details and Asset Tagging");

        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static void clickOnAddAssetTagLink(WebDriver driver) throws Exception
    {
        try
        {
            ActionBot.waitUntilVisible(driver, "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AddAssetTagLink");
            ActionBot.click(driver, "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AddAssetTagLink");
            logger.info("Clicked on Add Asset Tag Link");
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static int countNumberOfAssetLines(WebDriver driver, String testcase) throws Exception
    {
        int countNumberOfAssetLines = 0;
        try
        {
            String xpath = WebElementWrapper.getXpath("FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/TotalAssetTagRows");
            List<WebElement> totalNoOfRows = driver.findElements(By.xpath(xpath));
            countNumberOfAssetLines = totalNoOfRows.size();
            logger.info("Total Number of Asset Tag Lines is " + countNumberOfAssetLines);

            return countNumberOfAssetLines;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static String enterAssetNumber(WebDriver driver, String testcase) throws Exception
    {
        String number = null;
        int count = 0;
        try
        {
            count = countNumberOfAssetLines(driver, testcase);
            String xpath = WebElementWrapper.getXpath("FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/AssetNumber");

            for (int i = 1; i <= count; i++)
            {
                // String fieldXpath = "(
                // //input[@formcontrolname='assetNumber'])"+'['+i+']';
                String fieldXpath = xpath + "[" + i + "]";
                WebElement element = driver.findElement(By.xpath(fieldXpath));
                element.click();
                element.clear();
                element.sendKeys(CommonUtilities.uniqueAssetNumber());

                number = element.getAttribute("value");
                logger.info("Enter Asset Number is: " + number);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return number;
    }

    public static String enterManufacturerNumber(WebDriver driver, String testcase) throws Exception
    {
        String manufactureNumber = null;
        int count = 0;
        try
        {
            count = countNumberOfAssetLines(driver, testcase);
            String xpath = WebElementWrapper.getXpath("FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ManufacturerSerialNumber");

            for (int i = 1; i <= count; i++)
            {
                String fieldXpath = xpath + "[" + i + "]";
                WebElement element = driver.findElement(By.xpath(fieldXpath));
                element.click();
                element.clear();
                element.sendKeys(CommonUtilities.manufacturerNumber());

                manufactureNumber = element.getAttribute("value");
                logger.info("Enter Manufacture Number is: " + manufactureNumber);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return manufactureNumber;
    }

    public static String enterNotes(WebDriver driver, String testcase) throws Exception
    {
        String notes = null;
        int count = 0;
        try
        {
            count = countNumberOfAssetLines(driver, testcase);
            String xpath = WebElementWrapper.getXpath("FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/Notes");

            for (int i = 1; i <= count; i++)
            {
                String fieldXpath = xpath + "[" + i + "]";
                WebElement element = driver.findElement(By.xpath(fieldXpath));
                element.click();
                element.clear();
                element.sendKeys(GetData.getValueFromSpecificIndex("ASSET_NOTES", 0));

                notes = element.getAttribute("value");
                logger.info("Enter Notes are: " + notes);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return notes;
    }

    public static void clickOnAddAssetTagButton(WebDriver driver) throws Exception
    {
        try
        {
            ActionBot.waitUntilVisible(driver, "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ButtonAdd");
            ActionBot.click(driver, "FlowOR/Requisition/Line Item Details/ShippingDetailsAndAssestTagging/ButtonAdd");
            logger.info("Clicked on Add Asset tag button");
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static void clickOnYesSendForApproval(WebDriver driver, String testcase) throws Exception
    {
        try
        {
            ActionBot.click(driver, "FlowOR/Requisition/Yes,Button_Send_To_Buyer");
            logger.info("Clicked on Yes, Send for Approval button");
            Screenshot.captureScreenshot(driver, testcase, "Clicked on Yes, Send for Approval button");
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static void clickOnNoReturnToMeButton(WebDriver driver, String testcase) throws Exception
    {
        try
        {
            ActionBot.click(driver, "FlowOR/Requisition/Return_BackToRequester_Button");
            logger.info("Clicked on No Return To Me button");
            Screenshot.captureScreenshot(driver, testcase, "Clicked on No Return To Me button");
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static boolean isConfirmApprovalPopUpDispalyed(WebDriver driver, String testcase) throws Exception
    {
        boolean flag = false;
        try
        {
            if (ActionBot.isElementPresent(driver,ICheckout.SEND_TO_BUYER_CONFIRM_POPUP))
            {
                flag = true;
                logger.info("Confirm Approval PopUp displayed");
                Screenshot.captureScreenshot(driver, testcase, "Confirm Approval PopUp Displayed");
            }
            else
            {
                logger.info("Confirm Approval PopUp is not displayed");
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return flag;
    }

    public static Map<String, List<String>> fetchAssetTagDetails(WebDriver driver, String testcase) throws Exception
    {
        Map<String, List<String>> assetTagDetails = new LinkedHashMap<String, List<String>>();

        String assetNumberXpath = WebElementWrapper.getXpath(ICheckout.FETCH_ASSET_NUMBER);

        List<WebElement> assetNoElement = ActionBot.findElements(driver, assetNumberXpath);

        int i = 1;
        int j = 1;

        for (WebElement element : assetNoElement)
        {
            List<String> data = new ArrayList<String>();

            String assetNumber = element.getAttribute("value");

            String manfNumberXpath = "(" + assetNumberXpath + ")" + "[" + i + "]" + "//following::input[@formcontrolname='manufacturerSerialNumber']" + "[" + j + "]";
            WebElement manfElement = driver.findElement(By.xpath(manfNumberXpath));
            if (manfElement.getAttribute("value") != null && manfElement.getAttribute("value") != "")
            {
                data.add(manfElement.getAttribute("value"));
            }

            String notesXpath = "(" + assetNumberXpath + ")" + "[" + i + "] " + "//following::input[@formcontrolname='notes']" + "[" + j + "]";
            WebElement notesElement = driver.findElement(By.xpath(notesXpath));
            if (notesElement.getAttribute("value") != null && notesElement.getAttribute("value") != "")
            {
                data.add(notesElement.getAttribute("value"));
            }

            if (element.getAttribute("value") != null && element.getAttribute("value") != "")
            {
                assetTagDetails.put(assetNumber, data);
            }

            i++;
        }

        return assetTagDetails;
    }

    public static void clickOnCostBookingDetailsLink(WebDriver driver, String itemName, int index) throws Exception
    {
        String CostBookingDetails = "(//span[contains(text(),'" + itemName + "')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3])";
        // TestObject testObject = new TestObject();
        // testObject.addProperty("xpath", ConditionType.EQUALS,
        // CostBookingDetails);
        WebElement element = ActionBot.findElementByXpath(driver, CostBookingDetails);
        ActionBot.clickByXpath(driver, CostBookingDetails);
        logger.info("Clicked on Cost Booking Details link");
    }


    public static String enterAssetCode(WebDriver driver, String assetCode) throws Exception
    {
        String suggestionPath = WebElementWrapper.getXpath("FlowOR/Requisition/Line Item Details/cost booking details/AssetCodeSuggestionDrpDwn");

        String assetCodeTextboxXpath = WebElementWrapper.getXpath("FlowOR/Requisition/Line Item Details/cost booking details/AssetCodeInput");
        ActionBot.fillAutoCompleteItem(driver, MDC.get("TestCaseName").toString(), assetCodeTextboxXpath, suggestionPath, assetCode);
        logger.info("Entered Asset Code --> " + assetCode);

        return assetCode;
    }

    public static void clickOnPurchaseTypeYesButton(WebDriver driver, String testcase) throws Exception
    {
        ActionBot.click(driver, "FlowOR/Requisition/Additional Details/PurchaseTypeConfirmYesButton");
        logger.info("Clicked on Purchase Type Yes Button");
        Screenshot.captureScreenshot(driver, testcase, "Clicked on Purchase Type Yes Button");
    }

    public static void clickOnReasonForOrderingLink(WebDriver driver, String testcase) throws Exception
    {
        ActionBot.clickUsingJavaScript(driver, "FlowOR/Requisition/Basic Details/ReasonForOrderingLink");
        // ActionBot.click(driver, "FlowOR/Requisition/Basic
        // Details/ReasonForOrderingLink");
        logger.info("Clicked on Reason For Ordering link.");
        Screenshot.captureScreenshot(driver, testcase, "Clicked on Reason For Ordering link");
    }

    public static void clickOnCommentsForSupplierLink(WebDriver driver, String testcase) throws Exception
    {
        ActionBot.clickUsingJavaScript(driver, "FlowOR/Requisition/Basic Details/CommentsForSupplierLink");
        logger.info("Clicked on Comments For Supplier link.");
        Screenshot.captureScreenshot(driver, testcase, "Clicked on Comments For Supplier link");
    }

    @Step("Click on Cost Allotation Tab in browser <driver> for TestCase <testcase>")
    public static void clickOnCostAllocation(WebDriver driver, String testcase) throws Exception
    {
        try
        {
            ActionBot.clickOnTab(driver, TAB_LIST, Constants.COST_ALLOCATION);
            logger.info("Clicked on Cost Allocation Tab");
            Screenshot.captureScreenshot(driver, testcase, "Clicked on Cost Allocation Tab");
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    @Step("Click on Buyer Drop Down in browser <driver> for TestCase <testcase>")
    public static void clickOnBuyerDropdown(WebDriver driver, String testcaseName)throws Exception
    {
        ActionBot.click(driver, BUYER_DROPDOWN);
        logger.info("Clicked on Buyer dropdown.");
    }

    @Step("Select Buyer Group option in browser <driver> for TestCase <testcase>")
    public static void selectBuyerGroupOption(WebDriver driver, String testcaseName)throws Exception
    {
        ActionBot.click(driver, GROUP_DROPDOWN_OPTION);
        logger.info("Selected on Buyer Group option.");
    }

    @Step("Click on Shipping Details And Asset Tagging Tab in browser <driver> for TestCase <testcase>")
    public static void clickOnShippingDetailsAndAssetTaggingTab(WebDriver driver, String testCaseName) throws Exception {
        ActionBot.click(driver, SHIPPING_DETAILS_AND_ASSET_TAGGING);
        logger.info("Clicked on Shipping Details and Asset Tagging tab");
        Screenshot.captureScreenshot(driver, testCaseName, "Clicked on Shipping Details and Asset Tagging tab");
    }

     @Step("Create Requisition for Requsition <requisitionBO> in browser <driver> and TestCase <testCaseName>")
    public static RequisitionBO createRequisition(String driverKey, String reqKey, String testCaseName) throws Exception
    {
        boolean flag = false;
        WebDriver driver = null;
        RequisitionBO req = null;
        try
        {
            driver = DriverSelector.getDriverFromDataStore(driverKey);
            req = (RequisitionBO)DataStoreFactory.getSuiteDataStore().get(reqKey);

            AddItem.addItemToCart(driverKey,reqKey,testCaseName);
            OnlineStoreImpl.clickOnCartButtonOnOnlineStorePage(driverKey, testCaseName);
            CartImpl.clickOnCheckoutButton(driver, testCaseName);
            clickOnBasicDetailsLink(driver, testCaseName);

            if (req.getReqName() != null)
            {
                String requisitionName = enterRequisitionName(driver, req.getReqName());
                req.setReqName(requisitionName);
            }

            if (req.getOnBehalfOf() != null)
            {
                String onBehalfOf = enterOnBehalfOf(driver, req.getOnBehalfOf(),testCaseName);
                req.setOnBehalfOf(onBehalfOf);
            }

            // Fill Buying unit or edit item at header level;
            // fill company name;
            // Edit at header level;
            if (req.isBuyingUnit())
            {
                clickOnBuyingUnitEditButton(driver);
                if (req.getReqCompany() != null)
                {

                    String companyName = enterCompanyName(driver, req.getReqCompany());
                    req.setReqCompany(companyName);
                }

                if (req.getReqbBusinessUnit() != null)
                {
                    String businessUnit = enterBusinessUnit(driver, req.getReqbBusinessUnit());
                    req.setReqbBusinessUnit(businessUnit);
                }
                // fill location;
                if (req.getReqLocation() != null)
                {
                    String location = enterLocation(driver, req.getReqLocation());
                    req.setReqLocation(location);
                }
                // fill currency;
                if (req.getReqCurrency() != null)
                {

                    String currency = enterCurrency(driver, req.getReqCurrency());
                    Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "CBL");
                    req.setReqCurrency(currency);
                }
                // click on save;
                clickOnSaveButtonOnBuyingUnitPopUp(driver);
                ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

            }

            if (req.isUrgentRequirement())
            {

                selectUrgentRequirementYesButton(driver);
            }
            else
            {

                selectUrgentRequirementNoButton(driver);
            }

            // Fill reason for ordering;
            if (req.getReasonForOrdering() != null)
            {
                clickOnReasonForOrderingLink(driver, MDC.get("TestCaseName").toString());
                String reasonForOrdering = enterReasonForOrdering(driver, req.getReasonForOrdering());
                req.setReasonForOrdering(reasonForOrdering);
            }

            // Select settlement via Invoice or Pcard;
            if (req.isSelectViaInvoice())
            {
                req.setSettlementvia(selectSettlementViaInvoice(driver));
            }

            if (req.isSelectViaDisburesement())
            {
                selectSettlementViaDisbursement(driver);
                ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
            }

            if (req.isSelectViaUserPCard())
            {
                // Select settlement via User P-card;
                selectSettlementViaUserPCard(driver);

                ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

                if (req.getPcard() != null)
                {
                    String pcard = selectPCard(driver, req.getPcard());
                    req.setPcard(pcard);
                    ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
                }

                if (req.isRetrospectivePurchase())
                {

                    clickOnRespectivePurchaseYesButton(driver);

                    clickOnNoButtonForSendPoToSupplier(driver);

                    ActionBot.waitUntilVisible(driver,SELECT_PURCHASE_ORDER);
                    if (req.getSelectPurchaseOrder() != null)
                    {

                        selectPurchaseOrder(driver, req.getSelectPurchaseOrder());
                    }
                }

                // Add Attachments;
                if (req.getAttachmentFile() != null)
                {

                    ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

                    addAttachmentFile(driver, req.getAttachmentFile());
                    ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
                }

                // Fill shipping details;
                if (req.isReqDefaultAddressOption())
                {

                    clickOnShippingDetailsTab(driver);
                    ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

                    String defaultAddress = getDefaultShippingAddress(driver);
                    req.setReqDefaultDeliveryAddress(defaultAddress);
                }

                if (req.isReqOtherAddressesOption())
                {

                    String address = selectOtherAddressOption(driver);
                    req.setReqOtherAddresses(address);
                }

                if (req.getReqDeliverTo() != null)
                {
				/*String xpath = WebElementWrapper.getXpath("FlowOR/Requisition/ShippingDetails/select _ deliver to");
				ActionBot.scrollToElementByXpath(driver, xpath);
				String deliverTo = enterDeliverTo(driver, req.getReqDeliverTo());
				req.setReqDeliverTo(deliverTo);*/
                }

                // Select required date;
                String requiredByDate = selectRequiredByDate(driver);
                req.setRequiredBy(requiredByDate);
                ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

                if (!GlobalVariable.isCOA)
                {
                    clickOnCostAllocation(driver, MDC.get("TestCaseName").toString());
                   // CoaImpl.fillNonCoaAtHeaderLevel(driver, req, MDC.get("TestCaseName").toString());
                }

                clickOnLineItemDetailsTab(driver);

                ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

                List<String> itemNames = new ArrayList<String>();
                if ((req.getCatalogItemList() != null) && (req.getCatalogItemList().size() > 0))
                {
                    for (CatalogItemBO catalogItemBO : req.getCatalogItemList())
                    {
                        itemNames.add(catalogItemBO.getItemName());
                    }
                }
                /*if ((req.getGuidedItemList() != null) && (req.getGuidedItemList().size() > 0))
                {
                    for (GuidedItemBO guidedItemBO : req.getGuidedItemList())
                    {
                        itemNames.add(guidedItemBO.getGuidedItemItemName());
                    }
                }
                if ((req.getVirtualItemList() != null) && (req.getVirtualItemList().size() > 0))
                {
                    for (VirtualItemBO virtualItemBO : req.getVirtualItemList())
                    {
                        itemNames.add(virtualItemBO.getSearchItem());
                    }
                }
                if ((req.getNonStockItemList() != null) && (req.getNonStockItemList().size() > 0))
                {
                    for (NonStockItemBO nonStockItemBO : req.getNonStockItemList())
                    {
                        itemNames.add(nonStockItemBO.getSearchItem());
                    }
                }

                if ((req.getStockItemList() != null) && (req.getStockItemList().size() > 0))
                {
                    for (StockItemBO stockItem : req.getStockItemList())
                    {
                        itemNames.add(stockItem.getStockItemName());
                    }
                }*/

                for (int i = 0; i < itemNames.size(); i++)
                {
                    clickOnLineItemDetailsTab(driver);

                    clickOnCostBookingDetailsLink(driver, itemNames.get(i));

                    ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

                    if (req.getAssignedBuyer() != null)
                    {

                        clickOnBuyerTab(driver);

                        selectBuyerDropdownOption(driver);

                        enterBuyerInTextbox(driver, req.getAssignedBuyer());
                    }
                    else if (req.getAssignedBuyerGroup() != null)
                    {
                        clickOnBuyerTab(driver);

                        clickOnBuyerDropdown(driver, MDC.get("TestCaseName").toString());

                        selectBuyerGroupOption(driver, MDC.get("TestCaseName").toString());

                        enterBuyerInTextbox(driver, req.getAssignedBuyerGroup());

                    }

                    if (req.isAssetTagging())
                    {
                        clickOnShippingDetailsAndAssetTaggingTab(driver, MDC.get("TestCaseName").toString());
                        clickOnAddAssetTagLink(driver);
                        enterAssetNumber(driver, "enter asset number");
                        enterManufacturerNumber(driver, "enter manufacturer number");
                        enterNotes(driver, "enter notes");

                        req.setAssetTagDetails(fetchAssetTagDetails(driver, MDC.get("TestCaseName").toString()));

                        clickOnAddAssetTagButton(driver);
                    }

                    ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

                    clickOnCostBookingTab(driver);

                    if (!GlobalVariable.isCOA)
                    {
                        if (req.getReqGlAccount() != null)
                        {
                            //CoaImpl.selectGLAccount(driver, req.getReqGlAccount(), MDC.get("TestCaseName").toString());
                        }
                    }

                    if (req.getCostBookingItemAssetCode() != null)
                    {
                        enterAssetCode(driver, req.getCostBookingItemAssetCode());
                    }

                    ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

                    // Filling COA form if set true;
                    if (GlobalVariable.isCOA)
                    {
                       // CoaImpl.fillCoaForm(req.getCoaDataType(), req.getNoOfCoaSplit(), req.getSplitBy(), driver);
                    }
                    else
                    {
                        if (req.isReqSplitCostAtLineItemLevel())
                        {
                          //  CoaImpl.fillNonCoaAtLineItemLevel(driver, req, MDC.get("TestCaseName").toString());
                        }

                       // CoaImpl.clickOnSaveButton(driver, MDC.get("TestCaseName").toString());
                    }
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    flag = waitForLoadingSymbolToGoOff(driver, MDC.get("TestCaseName").toString());
                    if (flag)
                    {
                        logger.info("COA form saving loader went off");
                        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "COA form saving loader went off");
                    }
                    else
                    {
                        logger.info("COA form saving loader did not go off");
                        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "COA form saving loader did not go off");
                        throw new Exception("COA form saving loader did not go off");
                    }

                }

                if (req.getReqNextAction().equalsIgnoreCase(Constants.SUBMIT))
                {

                    clickOnImDoneButton(driver);

                    clickOnContinueButton(driver);

                    if (isConfirmApprovalPopUpDispalyed(driver, MDC.get("TestCaseName").toString()))
                    {
                        if (req.getSendToApproval().equalsIgnoreCase(Constants.YES_SEND_FOR_APPROVAL))
                        {
                            clickOnYesSendForApproval(driver, "Send to Approval");
                        }
                        else if (req.getReturnToMe().equalsIgnoreCase(Constants.NO_RETURN_TO_ME))
                        {
                            clickOnNoReturnToMeButton(driver, "Return to Me");
                        }
                    }

                    isRequisitionSubmitted(driver, MDC.get("TestCaseName").toString());
                }
                else if (req.getReqNextAction().equalsIgnoreCase(Constants.SAVE_AS_DRAFT))
                {
                    clickOnSaveAsDraftButton(driver);
                    flag =ActionBot.waitForElementVisible(driver,IRequisitionListing.SEARCHBOX_REQ_LISTING);
                    if (flag)
                    {
                        logger.info("Requisition page is displayed");
                        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Requisition page is displayed");
                    }
                    else
                    {
                        logger.info("Requisition page is not displayed");
                        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Requisition page is not displayed");
                    }
                }
                else if (req.getReqNextAction().equalsIgnoreCase(Constants.CANCEL))
                {
                    clickOnCancelButton(driver);
                    OnlineStoreImpl.waitForOnlineStorePageToLoad(driver);
                }
                else if (req.getReqNextAction().equalsIgnoreCase(Constants.NONE))
                {
                    // ActionBot.defaultSleep(driver,
                    // GlobalVariable.DEFAULT_LOW_WAIT);
                }
            }

        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            DataStoreFactory.getSuiteDataStore().put("WebDriver", driver);
        }
        return req;
    }

    public static boolean isRequisitionSubmitted(WebDriver driver, String testcase) throws Exception
    {
        boolean flag = waitForLoadingSymbolToGoOff(driver, testcase);
        if (flag)
        {
            logger.info("Create req loader went off");
            Screenshot.captureScreenshot(driver, testcase, "Create req loader went off");
            if (ActionBot.waitForElementVisible(driver, IRequisitionListing.SEARCHBOX_REQ_LISTING))
            {
                flag = true;
                Screenshot.captureScreenshot(driver, testcase, "Requisition Created Successfully");
            }
            else if (ActionBot.isElementPresent(driver,BASIC_DETAILS))
            {
                Screenshot.captureScreenshot(driver, testcase, "Requisition not Created");
                flag = false;
                logger.info("Requisition did not submit. Chekcout page is still displayed.");
                throw new Exception("Requisition did not submit. Chekcout page is still displayed.");
            }
        }
        else
        {
            logger.info("Create req loader did not go off");
            Screenshot.captureScreenshot(driver, testcase, "Create req loader did not go off");
            throw new Exception("Create req Loader did not go off");
        }

        return flag;

    }

    @Step("Update <objectName> set <setOfKey> to <setOfValues> ")
    public RequisitionBO updateObject(String objectName, String key, String value) throws Exception {
        RequisitionBO req;
        Map<String, String> updatedMap = ListofKey(key, value);
        DataStore store = DataStoreFactory.getSuiteDataStore();
        req = (RequisitionBO) store.get(objectName);
        for (String fieldName : updatedMap.keySet()) {
            System.out.println(req.getClass() + "      " + req.getClass().getDeclaredField(fieldName).getType().getSimpleName());
            if (req.getClass().getDeclaredField(fieldName).getType().getSimpleName().equals("List"))
            {

            }
           else if (req.getClass().getDeclaredField(fieldName).getType().getSimpleName().equals("int"))
            {

                FieldUtils.writeField(req, fieldName, Integer.parseInt(updatedMap.get(fieldName)), true);
            }
           else {
                FieldUtils.writeField(req, fieldName, updatedMap.get(fieldName), true);
            }

        }
        store.put(objectName, req);
        return req;
    }
    public static Map<String, String> ListofKey(String keys, String values) throws Exception {
        Map<String, String> dataList = new HashMap<String, String>();
        StringTokenizer keyStr = new StringTokenizer(keys, "||");
        StringTokenizer valueStr = new StringTokenizer(values, "||");
        while (keyStr.hasMoreTokens()) {
            String Key = keyStr.nextToken();
            String value = valueStr.nextToken();
            dataList.put(Key, value);
        }
        return dataList;
    }


    }

