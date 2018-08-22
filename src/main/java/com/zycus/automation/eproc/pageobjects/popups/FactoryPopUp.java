/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups;

import com.zycus.automation.eproc.pageobjects.popups.continueshopping.IPopUpContinueShoppingImpl;
import com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation.IPopUpEmptyCartConfirmationImpl;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author puneet.sharma
 *
 */
public class FactoryPopUp
{

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIPopUpEmptyCartConfirmation() throws FactoryMethodException
	{
		try
		{
			return (T) IPopUpEmptyCartConfirmationImpl.class.newInstance();
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
	public static <T> T getInstanceOfIPopUpContinueShopping() throws FactoryMethodException
	{
		try
		{
			return (T) IPopUpContinueShoppingImpl.class.newInstance();
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
