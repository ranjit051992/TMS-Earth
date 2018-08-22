package com.zycus.automation.utilities.utilitieshelpers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeFunctions
{
	final static String DATE_TIME_FORMATTER = "dd/MM/yyyy HH:mm:ss";

	public static void main1()
	{
		final String dateStart = "13/01/2012 23:59:58";
		final String dateStop = "14/01/2012 00:01:48";
		final DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		final DateTime dt1 = format.parseDateTime(dateStart);
		final DateTime dt2 = format.parseDateTime(dateStop);

		final Period period = new Period(dt1, dt2);
		/*
		 * System.out.print(period.getDays() + " days, ");
		 * System.out.print(period.getHours() + " hours, ");
		 * System.out.print(period.getMinutes() + " minutes, ");
		 * System.out.print(period.getSeconds() + " seconds.");
		 */

		System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
		System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
		System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
		System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Date date = new Date();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH-mm");
		String fileName = dateFormat1.format(date);
		System.out.println(fileName);
	}

	public void getTimeDifference()
	{

	}

	public static String getStartTime()
	{
		Date date = new Date();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat(DATE_TIME_FORMATTER);
		return dateFormat1.format(date);
	}
}
