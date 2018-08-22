package com.zycus.automation.utilities.reports.excel;

public interface ExcelConstants
{
	final static int	NAME			= 0;
	final static int	DESCRIPTION		= NAME + 1;
	final static int	RESULT			= DESCRIPTION + 1;
	final static int	MODULE			= RESULT + 1;
	final static int	NODE_ADDRESS	= MODULE + 1;
	final static int	BROWSER			= NODE_ADDRESS + 1;
	final static int	VERSION			= BROWSER + 1;
	final static int	TESTCASE_STATUS	= VERSION + 1;
	final static int	START_TIME		= TESTCASE_STATUS + 1;
	final static int	END_TIME		= START_TIME + 1;
	final static int	EXECUTION_TIME	= END_TIME + 1;
}
