/**
 * 
 */
package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankita.sawant
 *
 */
public class SystemTenantConfiguration
{
	private String			tenantName		= null;
	private String			customLang		= null;
	private List<String>	standardNames	= new ArrayList<String>();
	private List<String>	customizedNames	= new ArrayList<String>();
	private String			nextAction		= null;

	public String getTenantName()
	{
		return tenantName;
	}

	public void setTenantName(String tenantName)
	{
		this.tenantName = tenantName;
	}

	public String getCustomLang()
	{
		return customLang;
	}

	public void setCustomLang(String customLang)
	{
		this.customLang = customLang;
	}

	public List<String> getStandardNames()
	{
		return standardNames;
	}

	public void setStandardNames(List<String> standardNames)
	{
		this.standardNames = standardNames;
	}

	public List<String> getCustomizedNames()
	{
		return customizedNames;
	}

	public void setCustomizedNames(List<String> customizedNames)
	{
		this.customizedNames = customizedNames;
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
