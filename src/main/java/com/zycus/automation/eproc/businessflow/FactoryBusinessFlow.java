/**
 * 
 */
package com.zycus.automation.eproc.businessflow;

import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.IFlowAllRequestsApprovalImpl;
import com.zycus.automation.eproc.businessflow.fillGuidedItemflow.IFlowFillGuidedItemImpl;
import com.zycus.automation.eproc.businessflow.requisitionsettingsflow.IFlowRequisitionSettingsImpl;
import com.zycus.automation.eproc.businessflow.usermanagementflow.IFlowUserManagementImpl;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author puneet.sharma
 *
 */
public class FactoryBusinessFlow
{

	@SuppressWarnings("unchecked")
	public static <T> T getInstanceOfIFlowAllRequestsApproval() throws FactoryMethodException
	{
		try
		{
			return (T) IFlowAllRequestsApprovalImpl.class.newInstance();
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
	public static <T> T getInstanceOfIFlowRequisitionSettings() throws FactoryMethodException
	{
		try
		{
			return (T) IFlowRequisitionSettingsImpl.class.newInstance();
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
	public static <T> T getInstanceOfIFlowUserManagement() throws FactoryMethodException
	{
		try
		{
			return (T) IFlowUserManagementImpl.class.newInstance();
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
	public static <T> T getInstanceOfIFlowFillGuidedItem() throws FactoryMethodException
	{
		try
		{
			return (T) IFlowFillGuidedItemImpl.class.newInstance();
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
