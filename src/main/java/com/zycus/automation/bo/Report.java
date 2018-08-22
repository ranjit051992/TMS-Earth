/**
 * 
 */
package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankita.sawant
 *
 */
public class Report
{
	private String			reportName						= null;
	private String			folderName						= null;
	private String			reportType						= null;
	private boolean			isShowAllGroups					= false;
	private boolean			isShowTopLevelGroups			= false;
	private boolean			isSelectReoprtColumns			= false;
	private List<String>	reportColumns					= new ArrayList<String>();
	private boolean			isSummarizeReoprtBySum			= false;
	private boolean			isSummarizeReoprtByAverage		= false;
	private boolean			isSummarizeReoprtByMaximumValue	= false;
	private boolean			isSummarizeReoprtByMinimumValue	= false;
	private String			durationFilterOn				= null;
	private String			durationFilterPeriod			= null;
	private CustomDate		startDate						= new CustomDate();
	private CustomDate		endDate							= new CustomDate();
	private boolean			isMatchAllConditions			= false;
	private boolean			isMatchAnyConditions			= false;
	private String			chartType						= null;
	private String			nextAction						= null;

	public String getReportName()
	{
		return reportName;
	}

	public void setReportName(String reportName)
	{
		this.reportName = reportName;
	}

	public String getFolderName()
	{
		return folderName;
	}

	public void setFolderName(String folderName)
	{
		this.folderName = folderName;
	}

	public String getReportType()
	{
		return reportType;
	}

	public void setReportType(String reportType)
	{
		this.reportType = reportType;
	}

	public boolean isShowAllGroups()
	{
		return isShowAllGroups;
	}

	public void setShowAllGroups(boolean isShowAllGroups)
	{
		this.isShowAllGroups = isShowAllGroups;
	}

	public boolean isShowTopLevelGroups()
	{
		return isShowTopLevelGroups;
	}

	public void setShowTopLevelGroups(boolean isShowTopLevelGroups)
	{
		this.isShowTopLevelGroups = isShowTopLevelGroups;
	}

	public boolean isSelectReoprtColumns()
	{
		return isSelectReoprtColumns;
	}

	public void setSelectReoprtColumns(boolean isSelectReoprtColumns)
	{
		this.isSelectReoprtColumns = isSelectReoprtColumns;
	}

	public List<String> getReportColumns()
	{
		return reportColumns;
	}

	public void setReportColumns(List<String> reportColumns)
	{
		this.reportColumns = reportColumns;
	}

	public boolean isSummarizeReoprtBySum()
	{
		return isSummarizeReoprtBySum;
	}

	public void setSummarizeReoprtBySum(boolean isSummarizeReoprtBySum)
	{
		this.isSummarizeReoprtBySum = isSummarizeReoprtBySum;
	}

	public boolean isSummarizeReoprtByAverage()
	{
		return isSummarizeReoprtByAverage;
	}

	public void setSummarizeReoprtByAverage(boolean isSummarizeReoprtByAverage)
	{
		this.isSummarizeReoprtByAverage = isSummarizeReoprtByAverage;
	}

	public boolean isSummarizeReoprtByMaximumValue()
	{
		return isSummarizeReoprtByMaximumValue;
	}

	public void setSummarizeReoprtByMaximumValue(boolean isSummarizeReoprtByMaximumValue)
	{
		this.isSummarizeReoprtByMaximumValue = isSummarizeReoprtByMaximumValue;
	}

	public boolean isSummarizeReoprtByMinimumValue()
	{
		return isSummarizeReoprtByMinimumValue;
	}

	public void setSummarizeReoprtByMinimumValue(boolean isSummarizeReoprtByMinimumValue)
	{
		this.isSummarizeReoprtByMinimumValue = isSummarizeReoprtByMinimumValue;
	}

	public String getDurationFilterOn()
	{
		return durationFilterOn;
	}

	public void setDurationFilterOn(String durationFilterOn)
	{
		this.durationFilterOn = durationFilterOn;
	}

	public String getDurationFilterPeriod()
	{
		return durationFilterPeriod;
	}

	public void setDurationFilterPeriod(String durationFilterPeriod)
	{
		this.durationFilterPeriod = durationFilterPeriod;
	}

	public CustomDate getStartDate()
	{
		return startDate;
	}

	public void setStartDate(CustomDate startDate)
	{
		this.startDate = startDate;
	}

	public CustomDate getEndDate()
	{
		return endDate;
	}

	public void setEndDate(CustomDate endDate)
	{
		this.endDate = endDate;
	}

	public boolean isMatchAllConditions()
	{
		return isMatchAllConditions;
	}

	public void setMatchAllConditions(boolean isMatchAllConditions)
	{
		this.isMatchAllConditions = isMatchAllConditions;
	}

	public boolean isMatchAnyConditions()
	{
		return isMatchAnyConditions;
	}

	public void setMatchAnyConditions(boolean isMatchAnyConditions)
	{
		this.isMatchAnyConditions = isMatchAnyConditions;
	}

	public String getChartType()
	{
		return chartType;
	}

	public void setChartType(String chartType)
	{
		this.chartType = chartType;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

}
