package com.zycus.framework.dom_parser.framework;

import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;

public class ParserMain
{
	static Logger logger = Logger.getLogger(ParserMain.class);

	public static void main(String[] args)
	{
		try
		{
			Parser parser = new Parser();
			String fileName = "htmls/checkOut.html";
			String excelFile = "UI_Elements/CheckOutPage.xls";
			parser.writeExcelThroughHtmlFile(fileName, RequisitionUtil_UI_Elements.class, excelFile);
		}
		catch (XPathExpressionException e)
		{
			logger.error("Exception =>", e);
		}
		catch (IllegalArgumentException e)
		{
			logger.error("Exception =>", e);
		}
		catch (IOException e)
		{
			logger.error("Exception =>", e);
		}
		catch (IllegalAccessException e)
		{
			logger.error("Exception =>", e);
		}
		catch (Exception e)
		{
			logger.error("Exception =>", e);
		}
	}
}
