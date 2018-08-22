/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class FileAttachment
{
	private String	fileName		= null;
	private String	fileSize		= null;
	private String	fileStatus		= null;
	private String	fileVisibility	= null;

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileSize()
	{
		return fileSize;
	}

	public void setFileSize(String fileSize)
	{
		this.fileSize = fileSize;
	}

	public String getFileStatus()
	{
		return fileStatus;
	}

	public void setFileStatus(String fileStatus)
	{
		this.fileStatus = fileStatus;
	}

	public String getFileVisibility()
	{
		return fileVisibility;
	}

	public void setFileVisibility(String fileVisibility)
	{
		this.fileVisibility = fileVisibility;
	}

}
