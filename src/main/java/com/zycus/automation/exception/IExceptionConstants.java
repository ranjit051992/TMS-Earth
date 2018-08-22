package com.zycus.automation.exception;

public interface IExceptionConstants
{
	final static String	ENTER										= "\n";
	final static String	LOGIN_EXCPECTION_MESSAGE					= ENTER + "EXCPETION IN LOGIN";
	final static String	LOGOUT_EXCPECTION_MESSAGE					= ENTER + "EXCPETION IN LOGOUT";
	final static String	LOGIN_EXCEPTION_USER_ALREADY_IN_USE			= ENTER + "USER ALREADY IN USE";
	final static String	LOGOUT_EXCEPTION_USER_IS_NOT_IN_USE			= ENTER + "USER IS NOT IN USE";
	final static String	DRIVER_EXCEPTION_FAILED_TO_CREATE_DRIVER	= ENTER + "FAILED TO CREATE DRIVER";
	final static String	DRIVER_EXCEPTION_FAILED_TO_CLOSE_DRIVER		= ENTER + "FAILED TO CLOSE DRIVER";
	final static String	LOGOUT_EXCEPTION							= ENTER + "LOGOUT EXCEPTION";
	final static String	DRIVER_EXCEPTION_DRIVER_ABSENT				= ENTER + "DRIVER IS NULL";
}
