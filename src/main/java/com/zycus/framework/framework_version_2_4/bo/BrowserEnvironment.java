package com.zycus.framework.framework_version_2_4.bo;

import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;

/**
 * 
 * @author aryasindhu.sahu
 *
 */

public class BrowserEnvironment
{

	private int		environmentType	= FrameworkConstants.ENVIRONMENT_GRID;
	private String	browser			= FrameworkConstants.BROWSER_IE;
	private String	version			= "";

	public BrowserEnvironment()
	{
	}

	public int getEnvironmentType()
	{
		return environmentType;
	}

	public void setEnvironmentType(int environmentType)
	{
		this.environmentType = environmentType;
	}

	public String getBrowser()
	{
		return browser;
	}

	public void setBrowser(String browser)
	{
		this.browser = browser;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	@Override
	public String toString()
	{
		return "BrowserEnvironment [environmentType=" + (environmentType == FrameworkConstants.ENVIRONMENT_GRID ? "Grid" : "Local") + ", browser=" + browser + ", version="
			+ version + "]";
	}

}
