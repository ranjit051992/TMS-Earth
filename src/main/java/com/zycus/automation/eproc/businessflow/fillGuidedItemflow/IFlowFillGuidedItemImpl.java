package com.zycus.automation.eproc.businessflow.fillGuidedItemflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.GuidedItemSuggestSupplier;
import com.zycus.automation.bo.ModalGuidedItemSelectCategory;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.blanketorderforfreetextitem.ModalBlanketOrdersForFreeTextItem;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ReadyToCheckout.ModalFreeTextReadyToCheckOut;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory.ModalSelectCategory;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.IPageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.PageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.popups.FreeTextSelectCategoryEForm.PopUpSelectCategoryEForm;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.eInvoice.automation.services.CommonServices;

/**
 * @author himanshu.singh
 */
public class IFlowFillGuidedItemImpl implements IFlowFillGuidedItem, IConstants
{
	Logger logger = Logger.getLogger(IFlowFillGuidedItemImpl.class);

	@Override
	public GuidedItem fillGuidedItem(WebDriver driver, String testCaseName, GuidedItem guidedItem) throws Exception
	{
		try
		{
			// short desc
			if (guidedItem.getShortDescription() != null)
			{
				String shortDesc = PageFreeTextForm.fillShortDescription(driver, testCaseName, guidedItem.getShortDescription());
				guidedItem.setShortDescription(shortDesc);
			}

			// item type
			if (guidedItem.getItemType() != null)
			{
				if (guidedItem.getItemType().equalsIgnoreCase(IConstantsData.Goods))
				{
					PageFreeTextForm.clickItemType(driver, testCaseName, guidedItem.getItemType());
				}

				else if (guidedItem.getItemType().equalsIgnoreCase(IConstantsData.Services))
				{
					PageFreeTextForm.clickItemType(driver, testCaseName, guidedItem.getItemType());
				}
			}

			ActionBot.waitForPageLoad(driver);
			// to click on cancel button
			if (ModalSelectCategory.isCancelButtonPresent(driver, testCaseName))
			{
				ModalSelectCategory.toClickCancelBtn(driver, testCaseName);
			}

			// long desc
			if (guidedItem.getLongDescription() != null)
			{
				String longDesc = PageFreeTextForm.fillLongDescription(driver, testCaseName, guidedItem.getLongDescription());
				guidedItem.setLongDescription(longDesc);
			}

			// SELECT CATEGORY /eFORM
			ModalGuidedItemSelectCategory categorySelectedForEform = new ModalGuidedItemSelectCategory();

			if (guidedItem.isEditCategory())
			{
				if (guidedItem.getCategory() != null)
				{
					categorySelectedForEform = fillSelectcategory(driver, testCaseName, guidedItem.getCategory());
					guidedItem.setCategory(categorySelectedForEform);
				}
				else
				{
					categorySelectedForEform = fillSelectcategory(driver, testCaseName, null);
					guidedItem.setCategory(categorySelectedForEform);
				}
			}
			else
			{
				logger.info("Category is kept blank");
			}

			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultSleep();
			// long desc
			//			if (guidedItem.getLongDescription() != null)
			//			{
			//				String longDesc = PageFreeTextForm.fillLongDescription(driver, testCaseName, guidedItem.getLongDescription());
			//				guidedItem.setLongDescription(longDesc);
			//			}

			// sourcing status
			if (guidedItem.getSourcingStatus() != null)
			{
				if (guidedItem.getSourcingStatus().equalsIgnoreCase(IConstantsData.Quoted_by_supplier))
				{
					PageFreeTextForm.clickSourcingStatus(driver, testCaseName, guidedItem.getSourcingStatus());
				}

				else if (guidedItem.getSourcingStatus().equalsIgnoreCase(IConstantsData.Estimated_price))
				{
					PageFreeTextForm.clickSourcingStatus(driver, testCaseName, guidedItem.getSourcingStatus());
				}

				else if (guidedItem.getSourcingStatus().equalsIgnoreCase(IConstantsData.Need_a_Quote))
				{
					PageFreeTextForm.clickSourcingStatus(driver, testCaseName, guidedItem.getSourcingStatus());
				}

			}

			// recived by
			if (guidedItem.getReceiveBy() != null)
			{
				if (guidedItem.getReceiveBy().equalsIgnoreCase(IConstantsData.Amount))
				{
					PageFreeTextForm.clickReceive_BillBy(driver, testCaseName, guidedItem.getReceiveBy());
				}

				else if (guidedItem.getReceiveBy().equalsIgnoreCase(IConstantsData.Quantity))
				{
					PageFreeTextForm.clickReceive_BillBy(driver, testCaseName, guidedItem.getReceiveBy());
				}

				else if (guidedItem.getReceiveBy().equalsIgnoreCase(IConstantsData.No_Receipt))
				{
					PageFreeTextForm.clickReceive_BillBy(driver, testCaseName, guidedItem.getReceiveBy());
				}
			}

			// part no
			if (guidedItem.getPartNumber() != null)
			{
				String partNo = PageFreeTextForm.fillPartNumber(driver, testCaseName, guidedItem.getPartNumber());
				guidedItem.setPartNumber(partNo);
			}

			// uom
			if (!guidedItem.getReceiveBy().equalsIgnoreCase(IConstantsData.Amount))
			{
				if (guidedItem.getUom() != null)
				{
					String UOM = PageFreeTextForm.fillUOM(driver, testCaseName, guidedItem.getUom());
					guidedItem.setUom(UOM);
				}
				else
				{
					String UOM = PageFreeTextForm.fillUOM(driver, testCaseName, null);
					guidedItem.setUom(UOM);
				}
			}

			// quantity
			if (guidedItem.getQuantity() != 0)
			{
				float qty = 0;
				if (guidedItem.getUom().equalsIgnoreCase("EA") || guidedItem.getUom().equalsIgnoreCase("EACH"))
				{
					qty = PageFreeTextForm.fillQuantity(driver, testCaseName, (guidedItem.getQuantity().intValue()));
				}
				else
				{
					qty = PageFreeTextForm.fillQuantity(driver, testCaseName, guidedItem.getQuantity());
				}
				guidedItem.setQuantity(qty);
			}

			// price
			if (!guidedItem.getReceiveBy().equalsIgnoreCase(IConstantsData.Amount))
			{
				if (guidedItem.getPrice() != 0)
				{
					float getPrice = PageFreeTextForm.fillPrice(driver, testCaseName, guidedItem.getPrice());
					guidedItem.setPrice(getPrice);
				}
			}

			if (guidedItem.getCurrency() != null)
			{
				String curr = PageFreeTextForm.fillCurrency(driver, testCaseName, guidedItem.getCurrency());
				guidedItem.setCurrency(curr);
			}

			// zero price item
			if (guidedItem.isZeroPriceItem() == true)
			{
				PageFreeTextForm.clickOnZeroPriceItem(driver, testCaseName);
			}

			ActionBot.scroll(driver, "400");
			// to select supplier
			if (guidedItem.getSupplierType() != null)
			{
				if (guidedItem.getSupplierType().equalsIgnoreCase(IConstantsData.SUGGEST_NEW_SUPPLIER)
					|| guidedItem.getSupplierType().equalsIgnoreCase(IConstantsData.SUGGEST_EXISTING_SUPPLIER))
				{
					/** Case 1 : fill suggested supplier modal **/
					PageFreeTextForm.clickOnSuggestSupplierRadioButton(driver, testCaseName);
					ActionBot.scroll(driver, "350");
					// PageFreeTextForm.clickOnAddNewOrExistingSupplierLink(driver,
					// testCaseName);
					if (guidedItem.getGuidedItemSuggestSupplier() != null)
					{
						guidedItem
							.setGuidedItemSuggestSupplier(fillSuggestedSupplier(driver, testCaseName, guidedItem.getGuidedItemSuggestSupplier(), guidedItem.getSupplierType()));
					}
				}
				else if (guidedItem.getSupplierType().equalsIgnoreCase(IConstantsData.EXISTING_SUPPLIER))
				{
					/** Case 2 : Select existing supplier **/
					// fill all the info of suppliers when radio btn "Place order
					// with
					// an existing order" is selected
					// supplier name
					PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);

					if (guidedItem.getSupplierNameInSuppInfo() != null)
					{
						String nameOfSupplier = PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, guidedItem.getSupplierNameInSuppInfo());
						guidedItem.setSupplierNameInSuppInfo(nameOfSupplier);
					}

					// supplier address
					String addInSuppInfo = PageFreeTextForm.filladdressInSuppInfo(driver, testCaseName, null);
					guidedItem.setAddressInSuppInfo(addInSuppInfo);

					// contract no
					if (guidedItem.getContractNoInSuppInfo() != null)
					{
						String contractInSuppInfo = PageFreeTextForm.fillcontractNoInSuppInfo(driver, testCaseName, guidedItem.getContractNoInSuppInfo());

						guidedItem.setContractNoInSuppInfo(contractInSuppInfo);
					}
				}
			}

			ScreenShot.screenshot(driver, testCaseName, "After filling form");
			// to attach BPO
			if (guidedItem.getBPONo() != null)
			{
				ActionBot.scroll(driver, "400");
				PageFreeTextForm.clickOnShowAllContractOrBPOButton(driver, testCaseName);
				if (!guidedItem.getBPONo().equalsIgnoreCase(IConstantsData.ANY))
				{
					ModalBlanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, guidedItem.getBPONo());
				}
				ActionBot.defaultSleep();
				ModalBlanketOrdersForFreeTextItem.selectFirstBPO(driver, testCaseName);
				// ActionBot.defaultSleep();
				ModalBlanketOrdersForFreeTextItem.clickOnSelectBPOButton(driver, testCaseName);
			}
			if (guidedItem.isRequirementDetails())
			{
				if (guidedItem.getRequisitionAppliesTo_RequirementDetail() != null)
				{

					PageFreeTextForm.clickOnRequisitionAppliesTo_RequirementDetail(driver, testCaseName, guidedItem.getRequisitionAppliesTo_RequirementDetail());

				}

				if (guidedItem.getResponse_RequirementDetail() != null)
				{

					PageFreeTextForm.clickOnResponse_RequirementDetail(driver, testCaseName, guidedItem.getResponse_RequirementDetail());

				}
				if (guidedItem.getPoSentToSupplier_RequirementDetail() != null)
				{

					PageFreeTextForm.clickOnPOSentToSupplier_RequirementDetail(driver, testCaseName, guidedItem.getPoSentToSupplier_RequirementDetail());

				}
				if (guidedItem.getQuoteObtained_RequirementDetail() != null)
				{

					PageFreeTextForm.clickOnQuoteObtain_RequirementDetail(driver, testCaseName, guidedItem.getQuoteObtained_RequirementDetail());

				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return guidedItem;
	}

	/**
	 * <b>Author: himanshu.singh </b> <b><br>
	 * <font color="blue">Method :</b> To fill the Suggested Supplier Modal <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testcaseName
	 *        </font><b><br>
	 * @param suggestSupp
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	@Override
	public GuidedItemSuggestSupplier fillSuggestedSupplier(WebDriver driver, String testCaseName, GuidedItemSuggestSupplier suggestSupp, String supplierType)
		throws ActionBotException
	{
		ActionBot.scroll(driver, "400");
		if (supplierType.equalsIgnoreCase(IConstantsData.SUGGEST_EXISTING_SUPPLIER))
		{
			// suggest existing supplier
			if (suggestSupp.getExistingSupplierName() != null)
			{
				PageFreeTextForm.clickOnSelectExistingSupplierLink(driver, testCaseName);
				// suggest existing supplier
				suggestSupp.setExistingSupplierName(PageFreeTextForm.fillExistingSuggestSupplierName(driver, testCaseName, suggestSupp.getExistingSupplierName()));
				// supplier address
				suggestSupp.setSupplierAddress(PageFreeTextForm.selectExistingSuggestSupplierAddress(driver, testCaseName));
				// contract no
				suggestSupp.setContractNo(PageFreeTextForm.fillExistingSuggestSupplierContractNo(driver, testCaseName, suggestSupp.getContractNo()));

				if (suggestSupp.getNextAction().equalsIgnoreCase(IConstantsData.ADD_SUGGEST_SUPPLIER))
				{
					PageFreeTextForm.clickOnAddExistingSuggestSupplierButton(driver, testCaseName);
				}
				else
				{
					PageFreeTextForm.clickOnResetExistingSuggestSupplierButton(driver, testCaseName);
				}
			}
		}
		else
		{
			PageFreeTextForm.clickOnAddNewSupplierLink(driver, testCaseName);
			// suggest new supplier
			if (suggestSupp.getSuggestNewSupplierName() != null)
			{
				suggestSupp.setSuggestNewSupplierName(PageFreeTextForm.fillSuggestNewSupplierName(driver, testCaseName, suggestSupp.getSuggestNewSupplierName()));
			}

			// supplier address
			if (suggestSupp.getSupplierAddress() != null)
			{
				suggestSupp.setSupplierAddress(PageFreeTextForm.selectSuggestNewSupplierAddress(driver, testCaseName, suggestSupp.getSupplierAddress()));
			}

			// contract no
			if (suggestSupp.getContractNo() != null)
			{
				suggestSupp.setContractNo(PageFreeTextForm.fillSuggestNewSupplierContractNo(driver, testCaseName, suggestSupp.getContractNo()));
			}

			// supplier contact
			if (suggestSupp.getSupplierContact() != null)
			{
				suggestSupp.setSupplierContact(PageFreeTextForm.fillSuggestNewSupplierContact(driver, testCaseName, suggestSupp.getSupplierContact()));
			}

			// email id
			if (suggestSupp.getEmailId() != null)
			{
				suggestSupp.setEmailId(PageFreeTextForm.fillSuggestNewSupplierEmailId(driver, testCaseName, suggestSupp.getEmailId()));
			}

			// phone
			if (suggestSupp.getPhone() != 0)
			{
				suggestSupp.setPhone(PageFreeTextForm.fillSuggestNewSupplierPhone(driver, testCaseName, suggestSupp.getPhone()));
			}

			// other details
			if (suggestSupp.getOtherDetails() != null)
			{
				suggestSupp.setOtherDetails(PageFreeTextForm.fillSuggestNewSupplierOtherDetails(driver, testCaseName, suggestSupp.getOtherDetails()));
			}

			if (suggestSupp.getNextAction().equalsIgnoreCase(IConstantsData.ADD_SUGGEST_SUPPLIER))
			{
				PageFreeTextForm.clickOnAddSuggestNewSupplierButton(driver, testCaseName);
			}
			else
			{
				PageFreeTextForm.clickOnResetSuggestNewSupplierButton(driver, testCaseName);
			}
		}

		if (suggestSupp.isVerifyAddedSupplier())
		{
			if (suggestSupp.getSuggestNewSupplierName() != null)
			{
				suggestSupp.setResult(PageFreeTextForm.getSuggestedSupplierNameOfFirstRow(driver, testCaseName).equalsIgnoreCase(suggestSupp.getSuggestNewSupplierName()));
			}
			else
			{
				suggestSupp.setResult(PageFreeTextForm.getSuggestedSupplierNameOfFirstRow(driver, testCaseName).equalsIgnoreCase(suggestSupp.getExistingSupplierName()));
			}
		}

		return suggestSupp;
	}

	/**
	 * <b>Author: himanshu.singh </b> <b><br>
	 * <font color="blue">Method :</b> To select the Category for eForm <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testcaseName
	 *        </font><b><br>
	 * @param selectCategory
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public ModalGuidedItemSelectCategory fillSelectcategory(WebDriver driver, String testCaseName, ModalGuidedItemSelectCategory selectCategory) throws ActionBotException
	{
		ModalGuidedItemSelectCategory itemSelectCategory = new ModalGuidedItemSelectCategory();
		String category = null;
		ActionBot.waitTillPopUpIsPresent(driver, IPageFreeTextForm.PRODUCT_CATEGORY_LOADER);
		if (selectCategory != null)
		{
			PageFreeTextForm.clickOnSelectCategory(driver, testCaseName);
			category = ModalSelectCategory.fillSelectCategory(driver, testCaseName, selectCategory.getCategory());
			ActionBot.waitForPageLoad(driver);
			// select eForm
			if (ModalSelectCategory.isSelectEformIsPresent(driver, testCaseName))
			{
				if (selectCategory.getCategoryEFormName() != null)
					ModalSelectCategory.selectCategoryEform(driver, testCaseName, selectCategory.getCategoryEFormName());
				else
					ModalSelectCategory.clickOnSelectEform(driver, testCaseName);
				// click on continue btn
				PopUpSelectCategoryEForm.toClickContinueBtn(driver, testCaseName);
			}
			else
			{
				ModalSelectCategory.toClickSelectThisCategoryLink(driver, testCaseName);
				// click on continue btn
				PopUpSelectCategoryEForm.toClickContinueBtn(driver, testCaseName);
			}
		}
		else
		{
			if (PageFreeTextForm.getSelectedProductCategory(driver, testCaseName) == null)
			{
				ActionBot.defaultSleep();
				if (PageFreeTextForm.getSizeOfSelectedProductCategory(driver, testCaseName) == 0)
				{
					PageFreeTextForm.clickOnSelectCategory(driver, testCaseName);
					category = ModalSelectCategory.fillSelectCategory(driver, testCaseName, null);
					// select eForm
					if (ModalSelectCategory.isSelectEformIsPresent(driver, testCaseName))
					{
						ModalSelectCategory.clickOnSelectEform(driver, testCaseName);
						// click on continue btn
						PopUpSelectCategoryEForm.toClickContinueBtn(driver, testCaseName);
					}
					else
					{
						ModalSelectCategory.toClickSelectThisCategoryLink(driver, testCaseName);
						// click on continue btn
						PopUpSelectCategoryEForm.toClickContinueBtn(driver, testCaseName);
					}
				}
				else
				{
					category = PageFreeTextForm.getSelectedProductCategory(driver, testCaseName);
				}

			}
		}
		itemSelectCategory.setCategory(category);
		return itemSelectCategory;
	}

	/**
	 * <b>Author: himanshu.singh </b> <b><br>
	 * <font color="blue">Method :</b> To fill the guided item and add to cart
	 * or check out <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testcaseName
	 *        </font><b><br>
	 * @param suggestSupp
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 * @throws Exception
	 */

	@Override
	public GuidedItem fillGuidedItemNAddToCart(WebDriver driver, String testcaseName, GuidedItem guidedItem) throws Exception
	{
		logger.info("\n ### Adding guided item " + guidedItem.getShortDescription() + " to cart");
		// fill guided item page
		guidedItem = fillGuidedItem(driver, testcaseName, guidedItem);

		// check the activity and perform accordingly
		PageFreeTextForm.clickOnAddToCartButton(driver, testcaseName);

		if (guidedItem.getActivity().equalsIgnoreCase(IConstantsData.Checkout))
		{
			ModalFreeTextReadyToCheckOut.toClickCheckoutBtn(driver, testcaseName);
		}
		else if (guidedItem.getActivity().equalsIgnoreCase(IConstantsData.ViewItem))
		{
			// ActionBot.defaultSleep();
			ModalFreeTextReadyToCheckOut.toClickViewItemsInCartLink(driver, testcaseName);
		}
		else if (guidedItem.getActivity().equalsIgnoreCase(IConstantsData.AddAnotherItem))
		{
			ModalFreeTextReadyToCheckOut.toClickAddAnotherItemBtn(driver, testcaseName);
		}
		else
		{
			logger.info("Wrong activity is specified");
		}

		return guidedItem;
	}

	@Override
	public void addGuidedItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (PageSearchListing.isGuideMeExpandPresent(driver))
		{
			PageSearchListing.clickOnGuideMeExpand(driver, testCaseName);
			PageSearchListing.clickOnButtonGuidedProcurement(driver, testCaseName);
		}
		else
		{
			PageSearchListing.clickOnButtonGuidedProcurementForNoRecords(driver, testCaseName);
		}
	}

	@Override
	public boolean fillExtraFields(WebDriver driver, String testCaseName, GuidedItem guidedItem)
	{
		boolean status = false;
		try
		{
			PageFreeTextForm.clickShowMoreExtraFields(driver, testCaseName);
			ActionBot.defaultLowSleep();

			ActionBot.sendKeys(driver, IPageFreeTextForm.MANUFACTURER_NAME, CommonServices.getTestData(IConstantsData.Item_Manufacturer_Name));
			ActionBot.sendKeys(driver, IPageFreeTextForm.MANUFACTURER_URL, CommonServices.getTestData(IConstantsData.Item_Manufacturer_URL));
			ActionBot.sendKeys(driver, IPageFreeTextForm.IMAGE_URL, CommonServices.getTestData(IConstantsData.ITEM_IMAGE_URL));
			ActionBot.sendKeys(driver, IPageFreeTextForm.SUPP_URL, CommonServices.getTestData(IConstantsData.Item_Product_URL));
			ActionBot.sendKeys(driver, IPageFreeTextForm.MANUFACTURER_ID, CommonServices.getTestData(IConstantsData.Item_Manufacturer_Part_Id));
			ActionBot.sendKeys(driver, IPageFreeTextForm.SPECIFICATION_NAME, CommonServices.getTestData(IConstantsData.Item_Specification_Name));
			ActionBot.sendKeys(driver, IPageFreeTextForm.SPECIFICATION_KEY, CommonServices.getTestData(IConstantsData.Item_Specification_Key));
			ActionBot.sendKeys(driver, IPageFreeTextForm.SPECIFICATION_VALUE, CommonServices.getTestData(IConstantsData.Item_Specification_Value));

			List<WebElement> errorList = ActionBot.findElements(driver, By.xpath(".//*[contains(@id,'-error')]"));
			if (errorList.size() == 0)
				status = true;
		}
		catch (ActionBotException e)
		{
		}
		catch (Exception e)
		{
		}
		return status;
	}

	@Override
	public boolean fillExtraFieldsWithScriptedInput(WebDriver driver, String testCaseName, GuidedItem guidedItem)
	{
		boolean status = false;
		try
		{
			if (!ActionBot.isElementDisplayed(driver, IPageFreeTextForm.MANUFACTURER_NAME))
				PageFreeTextForm.clickShowMoreExtraFields(driver, testCaseName);
			ActionBot.defaultLowSleep();

			ActionBot.sendKeys(driver, IPageFreeTextForm.MANUFACTURER_NAME, CommonServices.getTestData(IConstantsData.Script_char_item_name));
			ActionBot.sendKeys(driver, IPageFreeTextForm.MANUFACTURER_URL, CommonServices.getTestData(IConstantsData.Item_Manufacturer_URL));
			ActionBot.sendKeys(driver, IPageFreeTextForm.IMAGE_URL, CommonServices.getTestData(IConstantsData.ITEM_IMAGE_URL));
			ActionBot.sendKeys(driver, IPageFreeTextForm.SUPP_URL, CommonServices.getTestData(IConstantsData.Item_Product_URL));
			ActionBot.sendKeys(driver, IPageFreeTextForm.MANUFACTURER_ID, CommonServices.getTestData(IConstantsData.Item_Manufacturer_Part_Id));
			ActionBot.sendKeys(driver, IPageFreeTextForm.SPECIFICATION_NAME, CommonServices.getTestData(IConstantsData.Script_char_item_name));
			ActionBot.sendKeys(driver, IPageFreeTextForm.SPECIFICATION_KEY, CommonServices.getTestData(IConstantsData.Item_Specification_Key));
			ActionBot.sendKeys(driver, IPageFreeTextForm.SPECIFICATION_VALUE, CommonServices.getTestData(IConstantsData.Script_char_item_name));

			List<WebElement> errorList = ActionBot.findElements(driver, By.xpath(".//*[contains(@id,'-error')]"));
			if (errorList.size() == 0)
				status = true;
			if (ActionBot.isElementEnabled(driver, IPageFreeTextForm.MANUFACTURER_NAME))
				status = true;
		}
		catch (ActionBotException e)
		{
		}
		catch (Exception e)
		{
		}
		return status;
	}

}
