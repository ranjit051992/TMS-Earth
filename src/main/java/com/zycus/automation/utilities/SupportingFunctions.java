package com.zycus.automation.utilities;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class SupportingFunctions
{

	public static String getDate()
	{
		new Date();
		return null;
	}

	public static String removeUnderScore(String param)
	{

		int i = 0;

		if (param.contains(","))
		{
			String[] paramArray = StringUtils.split(param, ",");
			while (i < paramArray.length)
			{
				if (i == 0)
				{
					param = paramArray[i++];
				}
				param += paramArray[i++];

			}
		}
		return param;

	}
}
