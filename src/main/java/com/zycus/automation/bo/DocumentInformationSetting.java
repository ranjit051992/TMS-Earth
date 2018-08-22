/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class DocumentInformationSetting
{
	private boolean	requisitionInfo		= false;
	private boolean	poInfo				= false;
	private String	reqDetailsTemplate	= null;
	private String	reqItemRowTemplate	= null;
	private String	poDetailsTemplate	= null;
	private String	poItemRowTemplate	= null;
	private String	nextAction			= null;

	public boolean isRequisitionInfo()
	{
		return requisitionInfo;
	}

	public void setRequisitionInfo(boolean requisitionInfo)
	{
		this.requisitionInfo = requisitionInfo;
	}

	public boolean isPoInfo()
	{
		return poInfo;
	}

	public void setPoInfo(boolean poInfo)
	{
		this.poInfo = poInfo;
	}

	public String getReqDetailsTemplate()
	{
		return reqDetailsTemplate;
	}

	public void setReqDetailsTemplate(String reqDetailsTemplate)
	{
		this.reqDetailsTemplate = reqDetailsTemplate;
	}

	public String getReqItemRowTemplate()
	{
		return reqItemRowTemplate;
	}

	public void setReqItemRowTemplate(String reqItemRowTemplate)
	{
		this.reqItemRowTemplate = reqItemRowTemplate;
	}

	public String getPoDetailsTemplate()
	{
		return poDetailsTemplate;
	}

	public void setPoDetailsTemplate(String poDetailsTemplate)
	{
		this.poDetailsTemplate = poDetailsTemplate;
	}

	public String getPoItemRowTemplate()
	{
		return poItemRowTemplate;
	}

	public void setPoItemRowTemplate(String poItemRowTemplate)
	{
		this.poItemRowTemplate = poItemRowTemplate;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

}
