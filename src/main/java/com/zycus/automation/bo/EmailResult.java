/**
 * 
 */
package com.zycus.automation.bo;

import java.util.Map;

/**
 * @author ankita.sawant
 *
 */
public class EmailResult
{
	private boolean				result	= false;
	private String				message	= null;
	private Map<String, String>	map		= null;

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public Map<String, String> getMap()
	{
		return map;
	}

	public void setMap(Map<String, String> map)
	{
		this.map = map;
	}

}
