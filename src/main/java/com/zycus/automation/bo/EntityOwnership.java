/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class EntityOwnership
{
	private String	currentOwner			= null;
	private String	newOwner				= null;
	private boolean	requisitionEntity		= false;
	private String	statusOfEntity			= null;
	private String	searchEntity			= null;
	private String	searchEntityIn			= null;
	private String	selectEntityNextAction	= null;
	private String	changeOwnerNextAction	= null;

	public String getCurrentOwner()
	{
		return currentOwner;
	}

	public void setCurrentOwner(String currentOwner)
	{
		this.currentOwner = currentOwner;
	}

	public String getNewOwner()
	{
		return newOwner;
	}

	public void setNewOwner(String newOwner)
	{
		this.newOwner = newOwner;
	}

	public boolean isRequisitionEntity()
	{
		return requisitionEntity;
	}

	public void setRequisitionEntity(boolean requisitionEntity)
	{
		this.requisitionEntity = requisitionEntity;
	}

	public String getStatusOfEntity()
	{
		return statusOfEntity;
	}

	public void setStatusOfEntity(String statusOfEnrity)
	{
		this.statusOfEntity = statusOfEnrity;
	}

	public String getSearchEntity()
	{
		return searchEntity;
	}

	public void setSearchEntity(String searchEntity)
	{
		this.searchEntity = searchEntity;
	}

	public String getSearchEntityIn()
	{
		return searchEntityIn;
	}

	public void setSearchEntityIn(String searchEntityIn)
	{
		this.searchEntityIn = searchEntityIn;
	}

	public String getSelectEntityNextAction()
	{
		return selectEntityNextAction;
	}

	public void setSelectEntityNextAction(String selectEntityNextAction)
	{
		this.selectEntityNextAction = selectEntityNextAction;
	}

	public String getChangeOwnerNextAction()
	{
		return changeOwnerNextAction;
	}

	public void setChangeOwnerNextAction(String changeOwnerNextAction)
	{
		this.changeOwnerNextAction = changeOwnerNextAction;
	}

}
