package com.zycus.automation.exception;

public class LoginLogoutException extends Exception
{

	private static final long serialVersionUID = -8796649689665011854L;

	public LoginLogoutException()
	{
		super();
	}

	public LoginLogoutException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public LoginLogoutException(String message)
	{
		super(message);
	}

	public LoginLogoutException(Throwable cause)
	{
		super(cause);
	}

}
