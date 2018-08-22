package com.zycus.automation.exception;

public class PageloadNotCompletedInSpecifiedTimeException extends Exception
{
	private static final long serialVersionUID = -9217036074131067370L;

	public PageloadNotCompletedInSpecifiedTimeException()
	{
		super();
	}

	public PageloadNotCompletedInSpecifiedTimeException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public PageloadNotCompletedInSpecifiedTimeException(String message)
	{
		super(message);
	}

	public PageloadNotCompletedInSpecifiedTimeException(Throwable cause)
	{
		super(cause);
	}

}
