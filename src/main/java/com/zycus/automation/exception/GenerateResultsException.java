package com.zycus.automation.exception;

/**
 * 
 * @author puneet.sharma
 *
 */
public class GenerateResultsException extends Exception
{

	private static final long serialVersionUID = 4929207833564393715L;

	public GenerateResultsException()
	{
		super();
	}

	/**
	 * @param message
	 * @param throwable
	 */
	public GenerateResultsException(String message, Throwable throwable)
	{
		super(message, throwable);
	}

	/**
	 * @param message
	 */
	public GenerateResultsException(String message)
	{
		super(message);
	}

	/**
	 * @param throwable
	 */
	public GenerateResultsException(Throwable throwable)
	{
		super(throwable);
	}
}
