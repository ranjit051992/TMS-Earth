package com.zycus.framework.framework_version_2_4.framework_exception;

/**
 * 
 * @author aryasindhu.sahu
 *
 */
public class TestCaseException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4829207533564393715L;

	public TestCaseException()
	{
		super();
	}

	/**
	 * @param message
	 * @param throwable
	 */
	public TestCaseException(String message, Throwable throwable)
	{
		super(message, throwable);
	}

	/**
	 * @param message
	 */
	public TestCaseException(String message)
	{
		super(message);
	}

	/**
	 * @param throwable
	 */
	public TestCaseException(Throwable throwable)
	{
		super(throwable);
	}

}
