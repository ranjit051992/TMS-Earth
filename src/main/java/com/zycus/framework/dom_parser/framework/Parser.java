package com.zycus.framework.dom_parser.framework;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.w3c.dom.Node;
import org.w3c.tidy.Tidy;

public class Parser
{
	static Logger			logger		= Logger.getLogger(Parser.class);
	static ReadExcelFile	readExcel	= null;
	static WriteExcel		writeExcel;

	static
	{
		readExcel = new ReadExcelFile();
		writeExcel = new WriteExcel();

	}

	public Map<String, String> parseHtmlContent(String fileName, String htmlContent) throws Exception
	{
		Map<String, String> elementsMap = null;
		try
		{
			elementsMap = readExcel.loadElements(fileName);
			Map<String, String> map = parseHtml(elementsMap, htmlContent);
			writeExcel.updateStatus(fileName, map);
		}
		catch (IllegalArgumentException e)
		{
			logger.error(e);
			throw e;
		}
		catch (XPathExpressionException e)
		{
			logger.error(e);
			throw e;
		}
		catch (IOException e)
		{
			logger.error(e);
			throw e;
		}
		catch (IllegalAccessException e)
		{
			logger.error(e);
			throw e;
		}
		catch (Exception e)
		{
			logger.error(e);
			throw e;
		}
		return elementsMap;
	}

	public Map<String, By> readExcelFile(String fileName) throws IOException
	{
		return readExcel.readExcelFile(fileName);
	}

	public Map<String, UI_Elements> readExcelFileForObject(String fileName) throws IOException
	{
		return readExcel.readExcelFileForObject(fileName);
	}

	public Map<String, String> updateStatusOfElementNotFoundOnSamePage(String fileName, String htmlContent) throws Exception
	{
		try
		{
			Map<String, String> elementsMap = readExcel.loadElements(fileName);
			Map<String, String> map = parseHtml(elementsMap, htmlContent);
			writeExcel.updateStatusOfElementNotFoundOnSamePage(fileName, map);
			return elementsMap;
		}
		catch (Exception e)
		{
			logger.error(e);
			throw e;
		}
	}

	public void writeExcelThroughHtmlFile(String fileName, Class className, String excelFile) throws Exception
	{
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		String htmlContent = IOUtils.toString(fileInputStream);
		generateExcelFiles(className, htmlContent, excelFile);
	}

	public By getBy(Map<String, By> map, String key) throws IOException
	{
		return readExcel.getBy(map, key);
	}

	public void generateExcelFiles(Class className, String htmlContent, String fileName) throws Exception
	{

		Map<String, String> data = parseHtmlForGeneratingExcel(className, htmlContent);
		writeExcel.generateKeyValuePairs(fileName, data);
	}

	public Map<String, String> parseHtml(Map<String, String> map, String htmlContent) throws Exception
	{

		Map<String, String> elementsOnPage;
		try
		{
			elementsOnPage = new HashMap<String, String>();

			/* Map<String, String> map = byElements; */
			Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();

			// for xpath used JTidy
			Tidy tidy = new Tidy();
			tidy.setInputEncoding("UTF-8");
			tidy.setQuiet(true);// to hide warnings
			tidy.setOutputEncoding("UTF-8");
			tidy.setWraplen(Integer.MAX_VALUE);
			tidy.setPrintBodyOnly(true);
			tidy.setXHTML(true);
			tidy.setXmlOut(true);
			tidy.setSmartIndent(true);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(htmlContent.getBytes("UTF-8"));
			org.w3c.dom.Document document = tidy.parseDOM(inputStream, System.out);
			XPath xpath = XPathFactory.newInstance().newXPath();
			Document doc = Jsoup.parse(htmlContent);
			while (entries.hasNext())
			{
				Map.Entry<String, String> entry = entries.next();

				int index = entry.getValue().indexOf(':');
				if (entry.getValue().contains("By.id"))
				{
					Element link = doc.getElementById(entry.getValue().substring(index + 1).trim());
					if (link == null)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.selector"))
				{
					Elements link = doc.select(entry.getValue().substring(index + 1).trim());
					if (link.size() == 0)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.className"))
				{
					Elements link = doc.getElementsByClass(entry.getValue().substring(index + 1));
					if (link.size() == 0)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.xpath"))
				{

					xpath = XPathFactory.newInstance().newXPath();
					XPathExpression expr = xpath.compile(entry.getValue().substring(index + 1).trim());
					Node node = (Node) expr.evaluate(document, XPathConstants.NODE);
					if (node == null)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.linkText"))
				{
					Boolean flag = doc.text().contains(entry.getValue().substring(index + 1).trim());
					if (flag)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.name"))
				{
					Elements links = doc.getElementsByAttributeValue("name", entry.getValue().substring(index + 1));
					if (links.size() == 0)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}

			}
		}
		catch (Exception e)
		{
			logger.error(e);
			throw e;
		}
		return elementsOnPage;

	}

	public Map<String, String> parseHtmlForGeneratingExcel(Class className, String content) throws Exception
	{
		Map<String, String> elementsOnPage = null;
		try
		{
			elementsOnPage = new HashMap<String, String>();

			Map<String, String> byElements = new HashMap<String, String>();
			Field[] interfaceFields = className.getFields();
			for (Field f : interfaceFields)
			{
				if (f.getType().equals(By.class))
				{
					byElements.put(f.getName().toString(), f.get(null).toString());
				}
			}

			Map<String, String> map = byElements;
			Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();

			// for xpath used JTidy
			Tidy tidy = new Tidy();
			tidy.setInputEncoding("UTF-8");
			tidy.setQuiet(true);// to hide warnings
			tidy.setOutputEncoding("UTF-8");
			tidy.setWraplen(Integer.MAX_VALUE);
			tidy.setPrintBodyOnly(true);
			tidy.setXHTML(true);
			tidy.setXmlOut(true);
			tidy.setSmartIndent(true);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes("UTF-8"));
			org.w3c.dom.Document document = tidy.parseDOM(inputStream, System.out);

			XPath xpath = XPathFactory.newInstance().newXPath();
			Document doc = Jsoup.parse(content);
			while (entries.hasNext())
			{
				Map.Entry<String, String> entry = entries.next();
				int index = entry.getValue().indexOf(':');
				if (entry.getValue().contains("By.id"))
				{
					Element link = doc.getElementById(entry.getValue().substring(index + 1).trim());
					if (link != null)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.selector"))
				{
					Elements link = doc.select(entry.getValue().substring(index + 1).trim());
					if (link.size() != 0)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.className"))
				{
					Elements link = doc.getElementsByClass(entry.getValue().substring(index + 1));
					if (link.size() != 0)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.xpath"))
				{

					xpath = XPathFactory.newInstance().newXPath();
					XPathExpression expr = xpath.compile(entry.getValue().substring(index + 1).trim());
					Node node = (Node) expr.evaluate(document, XPathConstants.NODE);
					if (node != null)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.linkText"))
				{
					Boolean flag = doc.text().contains(entry.getValue().substring(index + 1).trim());
					if (!flag)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}
				else if (entry.getValue().contains("By.name"))
				{
					Elements links = doc.getElementsByAttributeValue("name", entry.getValue().substring(index + 1));
					if (links.size() != 0)
					{
						elementsOnPage.put(entry.getKey(), entry.getValue());
					}
				}

			}

		}
		catch (Exception e)
		{
			logger.error(e);
			throw e;
		}
		return elementsOnPage;
	}

	// ***************************************************************************************************************************//

	public boolean parseHtmlContent(UI_Elements ui_Elements, String htmlContent) throws Exception
	{
		boolean flag = false;
		try
		{
			Map<String, String> map = parseHtml(ui_Elements, htmlContent);
			if (map.size() == 0)
			{
				flag = true;
			}
			writeExcel.updateStatus(ui_Elements.getFileName(), map);
		}
		catch (IllegalArgumentException e)
		{
			logger.error(e);
			throw e;
		}
		catch (XPathExpressionException e)
		{
			logger.error(e);
			throw e;
		}
		catch (IOException e)
		{
			logger.error(e);
			throw e;
		}
		catch (IllegalAccessException e)
		{
			logger.error(e);
			throw e;
		}
		catch (Exception e)
		{
			logger.error(e);
			throw e;
		}
		return flag;
	}

	public Map<String, String> parseHtml(UI_Elements ui_Elements, String htmlContent) throws Exception
	{

		Map<String, String> elementsOnPage;
		try
		{
			elementsOnPage = new HashMap<String, String>();

			/* Map<String, String> map = byElements; */

			// for xpath used JTidy
			Tidy tidy = new Tidy();
			tidy.setInputEncoding("UTF-8");
			tidy.setQuiet(true);// to hide warnings
			tidy.setOutputEncoding("UTF-8");
			tidy.setWraplen(Integer.MAX_VALUE);
			tidy.setPrintBodyOnly(true);
			tidy.setXHTML(true);
			tidy.setXmlOut(true);
			tidy.setSmartIndent(true);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(htmlContent.getBytes("UTF-8"));
			org.w3c.dom.Document document = tidy.parseDOM(inputStream, System.out);
			XPath xpath = XPathFactory.newInstance().newXPath();
			Document doc = Jsoup.parse(htmlContent);

			int index = ui_Elements.getBy().toString().indexOf(':');
			if (ui_Elements.getBy().toString().contains("By.id"))
			{
				Element link = doc.getElementById(ui_Elements.getBy().toString().substring(index + 1).trim());
				if (link == null)
				{
					elementsOnPage.put(ui_Elements.getKey(), ui_Elements.getBy().toString());
				}
			}
			else if (ui_Elements.getBy().toString().contains("By.selector"))
			{
				Elements link = doc.select(ui_Elements.getBy().toString().substring(index + 1).trim());
				if (link.size() == 0)
				{
					elementsOnPage.put(ui_Elements.getKey(), ui_Elements.getBy().toString());
				}
			}
			else if (ui_Elements.getBy().toString().contains("By.className"))
			{
				Elements link = doc.getElementsByClass(ui_Elements.getBy().toString().substring(index + 1));
				if (link.size() == 0)
				{
					elementsOnPage.put(ui_Elements.getKey(), ui_Elements.getBy().toString());
				}
			}
			else if (ui_Elements.getBy().toString().contains("By.xpath"))
			{

				xpath = XPathFactory.newInstance().newXPath();
				XPathExpression expr = xpath.compile(ui_Elements.getBy().toString().substring(index + 1).trim());
				Node node = (Node) expr.evaluate(document, XPathConstants.NODE);
				if (node == null)
				{
					elementsOnPage.put(ui_Elements.getKey(), ui_Elements.getBy().toString());
				}
			}
			else if (ui_Elements.getBy().toString().contains("By.linkText"))
			{
				Boolean flag = doc.text().contains(ui_Elements.getBy().toString().substring(index + 1).trim());
				if (flag)
				{
					elementsOnPage.put(ui_Elements.getKey(), ui_Elements.getBy().toString());
				}
			}
			else if (ui_Elements.getBy().toString().contains("By.name"))
			{
				Elements links = doc.getElementsByAttributeValue("name", ui_Elements.getBy().toString().substring(index + 1));
				if (links.size() == 0)
				{
					elementsOnPage.put(ui_Elements.getKey(), ui_Elements.getBy().toString());
				}
			}
		}
		catch (Exception e)
		{
			logger.error(e);
			throw e;
		}
		return elementsOnPage;

	}
}
