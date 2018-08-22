package com.zycus.automation.eproc.pageobjects.pages;

import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.IPageFreeTextFormImpl;
import com.zycus.automation.eproc.pageobjects.pages.approval.IPageAllRequestsApprovalImpl;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisitionImpl;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStoreImpl;
import com.zycus.automation.eproc.pageobjects.pages.po.IPagePOImpl;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOutImpl;
import com.zycus.automation.eproc.pageobjects.pages.requisitionForking.IPageRequisitionForkingImpl;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListingImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings.IPageBuyersDeskSettingsImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.costbookingsettings.IPageCostBookingSettingsImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.IPageCustomizeSettingsImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.IPageMasterDataSettingsImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings.IPageProjectsSettingsImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.purchaseordersettings.IPagePurchaseOrderSettingsImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings.IPageRequisitionSettingsImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.usermanagement.IPageUserManagementImpl;
import com.zycus.automation.eproc.pageobjects.pages.settings.usersettings.IPageUserSettingsImpl;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.IPageStandardPOImpl;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.iConsole.pageObjects.pages.apiConsole.IPageApiConsoleImpl;

@SuppressWarnings("unchecked")
public abstract class FactoryPage
{
	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIPageOnlineStore() throws FactoryMethodException
	{
		try
		{
			return (T) IPageOnlineStoreImpl.class.newInstance();
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
	public static <T> T getInstanceOfIPageSearchListing() throws FactoryMethodException
	{
		try
		{
			return (T) IPageSearchListingImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageAllRequestsApproval() throws FactoryMethodException
	{
		try
		{
			return (T) IPageAllRequestsApprovalImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageBuyersDeskSettings() throws FactoryMethodException
	{
		try
		{
			return (T) IPageBuyersDeskSettingsImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageCustomizeSettings() throws FactoryMethodException
	{
		try
		{
			return (T) IPageCustomizeSettingsImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageFreeTextForm() throws FactoryMethodException
	{
		try
		{
			return (T) IPageFreeTextFormImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageMasterDataSettings() throws FactoryMethodException
	{
		try
		{
			return (T) IPageMasterDataSettingsImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageMyRequisition() throws FactoryMethodException
	{
		try
		{
			return (T) IPageMyRequisitionImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPagePurchaseOrderSetting() throws FactoryMethodException
	{
		try
		{
			return (T) IPagePurchaseOrderSettingsImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageRequisitionCheckOut() throws FactoryMethodException
	{
		try
		{
			return (T) IPageRequisitionCheckOutImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageRequisitionForking() throws FactoryMethodException
	{
		try
		{
			return (T) IPageRequisitionForkingImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageRequisitionSettings() throws FactoryMethodException
	{
		try
		{
			return (T) IPageRequisitionSettingsImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageUserManagement() throws FactoryMethodException
	{
		try
		{
			return (T) IPageUserManagementImpl.class.newInstance();
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

	public static <T> T getInstanceOfIPageUserSettings() throws FactoryMethodException
	{
		try
		{
			return (T) IPageUserSettingsImpl.class.newInstance();
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

	public static <T> T getInstanceOf(Class className) throws FactoryMethodException
	{
		try
		{
			return (T) className.newInstance();

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

	private static IPagePOImpl iPagePOImpl = null;

	public static <T> T getInstanceOfPagePO()
	{
		if (iPagePOImpl == null)
		{
			iPagePOImpl = new IPagePOImpl();
		}
		return (T) iPagePOImpl;
	}

	private static IPageStandardPOImpl iPageStandardPOImpl = null;

	public static <T> T getInstanceOfStandardPO()
	{
		if (iPageStandardPOImpl == null)
		{
			iPageStandardPOImpl = new IPageStandardPOImpl();
		}
		return (T) iPageStandardPOImpl;
	}

	private static IPageCostBookingSettingsImpl iPageCostBookingSettingsImpl = null;

	public static <T> T getInstanceOfCostBookingSettings()
	{
		if (iPageCostBookingSettingsImpl == null)
		{
			iPageCostBookingSettingsImpl = new IPageCostBookingSettingsImpl();
		}
		return (T) iPageCostBookingSettingsImpl;
	}

	private static IPageProjectsSettingsImpl iPageProjectsSettingsImpl = null;

	public static <T> T getInstanceOfProjectsSettings()
	{
		if (iPageProjectsSettingsImpl == null)
		{
			iPageProjectsSettingsImpl = new IPageProjectsSettingsImpl();
		}
		return (T) iPageProjectsSettingsImpl;
	}

	public static <T> T getInstanceOfIPageApiConsole() throws FactoryMethodException
	{
		try
		{
			return (T) IPageApiConsoleImpl.class.newInstance();
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
}
