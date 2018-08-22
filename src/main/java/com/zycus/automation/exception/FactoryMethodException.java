package com.zycus.automation.exception;

public class FactoryMethodException extends Exception
{
	private static final long serialVersionUID = -239202181502396691L;

	public FactoryMethodException()
	{
		super();

	}

	public FactoryMethodException(String message, Throwable cause)
	{
		super(message, cause);

	}

	public FactoryMethodException(String message)
	{
		super(message);

	}

	public FactoryMethodException(Throwable cause)
	{
		super(cause);

	}
}
