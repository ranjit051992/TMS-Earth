/**
 * 
 */
package com.zycus.automation.exception;

/**
 * @author ankita.sawant
 *
 */
public class DatabaseException extends Exception
{
	private static final long serialVersionUID = 9052780345482903538L;

	/**
	 * @param message
	 */
	public DatabaseException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public DatabaseException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DatabaseException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
