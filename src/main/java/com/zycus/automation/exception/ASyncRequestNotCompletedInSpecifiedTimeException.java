/**
 * 
 */
package com.zycus.automation.exception;

/**
 * @author ankita.sawant
 *
 */
public class ASyncRequestNotCompletedInSpecifiedTimeException extends Exception
{
	private static final long serialVersionUID = -7704797957011813229L;

	public ASyncRequestNotCompletedInSpecifiedTimeException()
	{
		super();
	}

	public ASyncRequestNotCompletedInSpecifiedTimeException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ASyncRequestNotCompletedInSpecifiedTimeException(String message)
	{
		super(message);
	}

	public ASyncRequestNotCompletedInSpecifiedTimeException(Throwable cause)
	{
		super(cause);
	}

}
