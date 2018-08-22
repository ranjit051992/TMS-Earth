package com.zycus.automation.eproc.pageobjects.factory;

import com.zycus.automation.exception.FactoryMethodException;

public class FactoryPage
{
	@SuppressWarnings("unchecked")
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
}
