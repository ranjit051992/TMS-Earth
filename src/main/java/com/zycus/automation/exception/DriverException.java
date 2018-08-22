package com.zycus.automation.exception;

public class DriverException extends Exception
{

	private static final long serialVersionUID = 1444431465890745656L;

	public DriverException()
	{
		super();
	}

	public DriverException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public DriverException(String message)
	{
		super(message);
	}

	public DriverException(Throwable cause)
	{
		super(cause);
	}

}
