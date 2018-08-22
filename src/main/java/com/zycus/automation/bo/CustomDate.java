/**
 * 
 */
package com.zycus.automation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ankita.sawant
 *
 */
@Entity
@Table(name = "CustomDate")
public class CustomDate
{
	@Id
	@GeneratedValue
	private int		id;
	private int		day;
	private int		month;
	private int		year;
	private String	date;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getDay()
	{
		return day;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	@Override
	public String toString()
	{
		return "CustomDate [day=" + day + ", month=" + month + ", year=" + year + ", date=" + date + "]";
	}

}
