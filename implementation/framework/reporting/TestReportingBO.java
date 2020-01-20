package framework.reporting;

public class TestReportingBO
{

	private String	testcaseType;
	private String	testCaseName;
	private String	testcaseDescription;
	private String	module;
	private String	jiraId;
	private String	userStory;
	private String	mappedWith;
	private String	author;
	private String	executionDate;
	private String	executionResult;
	private String	failCount;
	private String	dateAdded;
	private String	comments;
	private String	errorMessage	= "";

	/**
	 *
	 * @return the testcaseType;
	 */
	public String getTestcaseType()
	{
		return testcaseType;
	}

	/**
	 *
	 * @return the testCaseName;
	 */
	public String getTestCaseName()
	{
		return testCaseName;
	}

	/**
	 *
	 * @return the testcaseDescription;
	 */
	public String getTestcaseDescription()
	{
		return testcaseDescription;
	}

	/**
	 *
	 * @return the module;
	 */
	public String getModule()
	{
		return module;
	}

	/**
	 *
	 * @return the jiraId;
	 */
	public String getJiraId()
	{
		return jiraId;
	}

	/**
	 *
	 * @return the userStory;
	 */
	public String getUserStory()
	{
		return userStory;
	}

	/**
	 *
	 * @return the mappedWith;
	 */
	public String getMappedWith()
	{
		return mappedWith;
	}

	/**
	 *
	 * @return the author;
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 *
	 * @return the executionDate;
	 */
	public String getExecutionDate()
	{
		return executionDate;
	}

	/**
	 *
	 * @return the executionResult;
	 */
	public String getExecutionResult()
	{
		return executionResult;
	}

	/**
	 *
	 * @return the failCount;
	 */
	public String getFailCount()
	{
		return failCount;
	}

	/**
	 *
	 * @return the dateAdded;
	 */
	public String getDateAdded()
	{
		return dateAdded;
	}

	/**
	 *
	 * @return the comments;
	 */
	public String getComments()
	{
		return comments;
	}

	/**
	 *
	 * @param *TestcaseType the testcaseType to set;
	 */
	public void setTestcaseType(String testcaseType)
	{
		this.testcaseType = testcaseType;
	}

	/**
	 *
	 * @param *TestCaseName the testCaseName to set;
	 */
	public void setTestCaseName(String testCaseName)
	{
		this.testCaseName = testCaseName;
	}

	/**
	 *
	 * @param *TestcaseDescription the testcaseDescription to set;
	 */
	public void setTestcaseDescription(String testcaseDescription)
	{
		this.testcaseDescription = testcaseDescription;
	}

	/**
	 *
	 * @param module the module to set;
	 */
	public void setModule(String module)
	{
		this.module = module;
	}

	/**
	 *
	 * @param jiraId the jiraId to set;
	 */
	public void setJiraId(String jiraId)
	{
		this.jiraId = jiraId;
	}

	/**
	 *
	 * @param userStory the userStory to set;
	 */
	public void setUserStory(String userStory)
	{
		this.userStory = userStory;
	}

	/**
	 *
	 * @param mappedWith the mappedWith to set;
	 */
	public void setMappedWith(String mappedWith)
	{
		this.mappedWith = mappedWith;
	}

	/**
	 *
	 * @param author the author to set;
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 *
	 * @param executionDate the executionDate to set;
	 */
	public void setExecutionDate(String executionDate)
	{
		this.executionDate = executionDate;
	}

	/**
	 *
	 * @param executionResult the executionResult to set;
	 */
	public void setExecutionResult(String executionResult)
	{
		this.executionResult = executionResult;
	}

	/**
	 *
	 * @param failCount the failCount to set;
	 */
	public void setFailCount(String failCount)
	{
		this.failCount = failCount;
	}

	/**
	 *
	 * @param dateAdded the dateAdded to set;
	 */
	public void setDateAdded(String dateAdded)
	{
		this.dateAdded = dateAdded;
	}

	/**
	 *
	 * @param comments the comments to set;
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public String getMessage()
	{
		return errorMessage;
	}

	public void setMessage(String message)
	{
		this.errorMessage = message;
	}
}
