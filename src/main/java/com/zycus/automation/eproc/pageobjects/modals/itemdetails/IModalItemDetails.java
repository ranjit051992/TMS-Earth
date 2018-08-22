/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.itemdetails;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalItemDetails
{
	String		xpath1_on_item_details_popup					= ".//*[@id='item_detail_popup_";
	String		xpath2_item_title_on_item_details_popup			= "']//span[contains(@class,'itemTitle')]";
	String		xpath2_item_desc								= "']//*[contains(@class,'itemDes')]/*[contains(@class,'val')]";
	String		xpath2_item_manufacturer						= "']//div[contains(@class,'manfCname')]/span[contains(@class,'val')]";
	String		xpath2_item_category							= "']//*[contains(@class,'category')]";
	String		xpath2_item_spscCode							= "']//*[contains(@class,'spscCode')]";
	String		xpath2_item_supplierName						= "']//div[.//*[contains(text(),'Supplier:')]]/span[contains(@class,'val')]";
	String		xpath2_item_supplierContact						= "']//div[.//*[contains(text(),'Supplier Contact:')]]/span[contains(@class,'val')]";
	String		xpath2_item_delivery_lead_time					= "']//*[contains(@class,'leadTime')]";
	String		xpath2_item_contractNo							= "']//*[contains(@class,'dev_contractNo')]";
	String		xpath2_item_detailsTab							= "']//li[contains(@cls,'dev_itemDesc1')]/a";
	String		xpath2_item_specificationTab					= "']//li[contains(@cls,'dev_parametricData')]/a";
	String		xpath2_item_attachmentsTab						= "']//li[contains(@cls,'dev_attachments')]/a";
	String		xpath1_specification_key						= ".//*[contains(@class,'dev_parametricData')]/*[contains(@class,'props')]/div[";
	String		xpath2_specification_key						= "]/*[contains(@class,'lbl')]";
	String		xpath1_specification_value						= ".//*[contains(@class,'dev_parametricData')]/*[contains(@class,'props')]/div[";
	String		xpath2_specification_value						= "]/*[contains(@class,'val')]";
	UI_Elements	LABEL_SPECIFICATION_NAME_ITEM_DETAILS_POP_UP	= UIFactory.getElements("LABEL_SPECIFICATION_NAME_ITEM_DETAILS_POP_UP");

	UI_Elements	LIST_SPECIFICATION_KEYS_ITEM_DETAILS_POP_UP		= UIFactory.getElements("LIST_SPECIFICATION_KEYS_ITEM_DETAILS_POP_UP");

	UI_Elements	LIST_ATTACHMENTS_ITEM_DETAILS_POP_UP			= UIFactory.getElements("LIST_ATTACHMENTS_ITEM_DETAILS_POP_UP");

	public String getItemTitle(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemDesc(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemManufacturer(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemCategory(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemSpscCode(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemSupplierName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemSupplierContact(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemDeliveryLeadTime(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemContractNo(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getItemSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemSpecificationKey(WebDriver driver, String testCaseName, int divIndex) throws ActionBotException;

	public String getItemSpecificationValue(WebDriver driver, String testCaseName, int divIndex) throws ActionBotException;

	public List<WebElement> getAttachments(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getAttachmentsNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemDetailsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isItemSpecificationsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public boolean isItemAttachmentsTabPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnSpecificationTab(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnAttachmentTab(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public int getSizeOfSpecifications(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseItemDetailsMdoal(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;
}
