package com.zycus.automation.eproc.pageobjects.modals;

import com.zycus.automation.eproc.pageobjects.modals.PurchaseOrderSummaryDelivery.IModalPOSummaryDeliveryImpl;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsamountfilter.IModalAllRequestsAmountFilterImpl;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsapprovalactions.IModalAllRequestsApprovalActionsImpl;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsdocumenttypefilter.IModalAllRequestsDocumentTypeFilterImpl;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsreceivedonfilter.IModalAllRequestsApprovalReceivedOnFilterImpl;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsstatusapprovalfilter.IModalAllRequestsStatusApprovalFilterImpl;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentapprove.IModalAllRequestsApprovalDocumentApproveImpl;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentdelegate.IModalAllRequestsApprovalDocumentDelegateImpl;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentreject.IModalAllRequestsApprovalDocumentRejectImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutChangeMultiple.IModelChangeMultipleImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryAttachment.IModelItemSummaryAttachmentImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon.IModelItemSummaryCommonImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.IModelItemSummaryCostBookingImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryDelivery.IModelItemSummaryDeliveryImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryMiscellaneous.IModelItemSummaryMiscellaneousImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummary.IModelRequisitionSummaryImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling.IModelRequisitionSummaryBillingImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCommon.IModelRequisitionSummaryCommonImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking.IModelRequisitionSummaryCostBookingImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryDelivery.IModelRequisitionSummaryDeliveryImpl;
import com.zycus.automation.eproc.pageobjects.modals.forkingCommentsForSupplier.IModelCommentsForSupplierImpl;
import com.zycus.automation.eproc.pageobjects.modals.forkingReasonForOredering.IModelReasonForOrderingImpl;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_Actions.IModalActionsBtnImpl;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ItemDetails.IModalItemDetailsImpl;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_ReadyToCheckout.IModalFreeTextReadyToCheckOutImpl;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory.IModalSelectCategoryImpl;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SuggestNewSupplier.IModalSuggestNewSupplierImpl;
import com.zycus.automation.eproc.pageobjects.modals.myRequisition_Actions_CancelRequisition.IModalCancelRequisitionImpl;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions.IModalMyRequisitionActionsImpl;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionamountfilter.IModalMyRequisitionAmountFilterImpl;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionstatusfilters.IModalMyRequisitionStatusFiltersImpl;
import com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking.IModalPOSummaryCostBookingImpl;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.IModalRequisitionFilterImpl;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.IModalShoppingCartImpl;
import com.zycus.automation.exception.FactoryMethodException;

public abstract class FactoryModal
{

	private static IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = null;

	/**
	 * 
	 * <b>created On : </b>19-Aug-2014 : 4:59:40 pm<br>
	 * <font size="2" color="black"><b>author : </b> puneet.sharma<br>
	 * </font> <font size="2" color="black"><b>method Name : </b>
	 * getInstanceOfIHomePageMainTab<br>
	 * </font> <font size="2" color="red"><b>method Description : </b> </font>
	 * <br>
	 * <font size="2" color="black"><b>return Type : </b>T </font><br>
	 * @return </font><br>
	 * @throws FactoryMethodException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIHomePageMainTab() throws FactoryMethodException
	{
		try
		{
			return (T) IModalRequisitionFilterImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModaIModalPOSummaryDelivery() throws FactoryMethodException
	{
		try
		{
			return (T) IModalPOSummaryDeliveryImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	/*
	 * @SuppressWarnings("unchecked") public static <T> T
	 * getInstanceOfIModalAllRequestsAmountFilter() throws
	 * FactoryMethodException { try { return (T)
	 * IModalAllRequestsAmountFilterImpl.class.newInstance(); } catch
	 * (InstantiationException e) { throw new
	 * FactoryMethodException(e.toString(), e); } catch (IllegalAccessException
	 * e) { throw new FactoryMethodException(e.toString(), e); } }
	 */

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalActionsBtn() throws FactoryMethodException
	{
		try
		{
			return (T) IModalActionsBtnImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalAllRequestsAmountFilter() throws FactoryMethodException
	{
		try
		{
			return (T) IModalAllRequestsAmountFilterImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalAllRequestsApprovalDocumentApprove() throws FactoryMethodException
	{
		try
		{
			return (T) IModalAllRequestsApprovalDocumentApproveImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalAllRequestsApprovalDocumentDelegate() throws FactoryMethodException
	{
		try
		{
			return (T) IModalAllRequestsApprovalDocumentDelegateImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalAllRequestsApprovalDocumentReject() throws FactoryMethodException
	{
		try
		{
			return (T) IModalAllRequestsApprovalDocumentRejectImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalAllRequestsApprovalReceivedOnFilter() throws FactoryMethodException
	{
		try
		{
			return (T) IModalAllRequestsApprovalReceivedOnFilterImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalAllRequestsDocumentTypeFilter() throws FactoryMethodException
	{
		try
		{
			return (T) IModalAllRequestsDocumentTypeFilterImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalAllRequestsStatusApprovalFilter() throws FactoryMethodException
	{
		try
		{
			return (T) IModalAllRequestsStatusApprovalFilterImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalCancelRequisition() throws FactoryMethodException
	{
		try
		{
			return (T) IModalCancelRequisitionImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalFreeTextReadyToCheckOut() throws FactoryMethodException
	{
		try
		{
			return (T) IModalFreeTextReadyToCheckOutImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalItemDetails() throws FactoryMethodException
	{
		try
		{
			return (T) IModalItemDetailsImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalMyRequisitionActions() throws FactoryMethodException
	{
		try
		{
			return (T) IModalMyRequisitionActionsImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalMyRequisitionAmountFilter() throws FactoryMethodException
	{
		try
		{
			return (T) IModalMyRequisitionAmountFilterImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalMyRequisitionStatusFilters() throws FactoryMethodException
	{
		try
		{
			return (T) IModalMyRequisitionStatusFiltersImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalSelectCategory() throws FactoryMethodException
	{
		try
		{
			return (T) IModalSelectCategoryImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	/**
	 * 
	 * <b>created On : </b>19-Aug-2014 : 5:48:52 pm<br>
	 * <font size="2" color="black"><b>author : </b> puneet.sharma<br>
	 * </font> <font size="2" color="black"><b>method Name : </b>
	 * getInstanceOfIModalShoppingCart<br>
	 * </font> <font size="2" color="red"><b>method Description : </b> </font>
	 * <br>
	 * <font size="2" color="black"><b>return Type : </b>T </font><br>
	 * @return </font><br>
	 * @throws FactoryMethodException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalShoppingCart() throws FactoryMethodException
	{
		try
		{
			return (T) IModalShoppingCartImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModalSuggestNewSupplier() throws FactoryMethodException
	{
		try
		{
			return (T) IModalSuggestNewSupplierImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelAllRequestsApprovalActions() throws FactoryMethodException
	{
		try
		{
			return (T) IModalAllRequestsApprovalActionsImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelChangeMultiple() throws FactoryMethodException
	{
		try
		{
			return (T) IModelChangeMultipleImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelCommentsForSupplier() throws FactoryMethodException
	{
		try
		{
			return (T) IModelCommentsForSupplierImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelItemSummaryAttachment() throws FactoryMethodException
	{
		try
		{
			return (T) IModelItemSummaryAttachmentImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelItemSummaryCommon() throws FactoryMethodException
	{
		try
		{
			return (T) IModelItemSummaryCommonImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelItemSummaryCostBooking() throws FactoryMethodException
	{
		try
		{
			return (T) IModelItemSummaryCostBookingImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelItemSummaryMiscellaneous() throws FactoryMethodException
	{
		try
		{
			return (T) IModelItemSummaryMiscellaneousImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelItemSummaryDelivery() throws FactoryMethodException
	{
		try
		{
			return (T) IModelItemSummaryDeliveryImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelReasonForOrdering() throws FactoryMethodException
	{
		try
		{
			return (T) IModelReasonForOrderingImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelRequisitionSummary() throws FactoryMethodException
	{
		try
		{
			return (T) IModelRequisitionSummaryImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelRequisitionSummaryBilling() throws FactoryMethodException
	{
		try
		{
			return (T) IModelRequisitionSummaryBillingImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelRequisitionSummaryCommon() throws FactoryMethodException
	{
		try
		{
			return (T) IModelRequisitionSummaryCommonImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelRequisitionSummaryCostBooking() throws FactoryMethodException
	{
		try
		{
			return (T) IModelRequisitionSummaryCostBookingImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIModelRequisitionSummaryDelivery() throws FactoryMethodException
	{
		try
		{
			return (T) IModelRequisitionSummaryDeliveryImpl.class.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new FactoryMethodException(e.toString(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfStandardPO()
	{
		if (iModalPOSummaryCostBookingImpl == null)
		{
			iModalPOSummaryCostBookingImpl = new IModalPOSummaryCostBookingImpl();
		}
		return (T) iModalPOSummaryCostBookingImpl;
	}

}
