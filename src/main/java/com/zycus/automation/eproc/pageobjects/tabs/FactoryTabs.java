package com.zycus.automation.eproc.pageobjects.tabs;

import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.ITabCheckoutItemSummaryImpl;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabRequisitionSummary.ITabCheckoutReqSummaryImpl;
import com.zycus.automation.eproc.pageobjects.tabs.freeTextFrom_ItemDetails_Tab.ITabsItemDetailsTabImpl;
import com.zycus.automation.exception.FactoryMethodException;

@SuppressWarnings("unchecked")
public abstract class FactoryTabs
{
	public static <T> T getInstanceOfITabCheckoutItemSummary() throws FactoryMethodException
	{
		try
		{
			return (T) ITabCheckoutItemSummaryImpl.class.newInstance();
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

	public static <T> T getInstanceOfITabCheckoutReqSummary() throws FactoryMethodException
	{
		try
		{
			return (T) ITabCheckoutReqSummaryImpl.class.newInstance();
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

	public static <T> T getInstanceOfITabsItemDetailsTab() throws FactoryMethodException
	{
		try
		{
			return (T) ITabsItemDetailsTabImpl.class.newInstance();
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

	private static com.zycus.automation.eproc.pageobjects.tabs.poSummary.ITabPOSummaryImpl iTabPOSummaryImpl = null;

	public static <T> T getInstanceOfTabPOSummary()
	{
		if (iTabPOSummaryImpl == null)
		{
			iTabPOSummaryImpl = new com.zycus.automation.eproc.pageobjects.tabs.poSummary.ITabPOSummaryImpl();
		}
		return (T) iTabPOSummaryImpl;
	}

}
