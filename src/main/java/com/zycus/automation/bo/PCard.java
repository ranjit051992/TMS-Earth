/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class PCard
{
	private String		pCardType				= null;
	private String		pCardNo					= null;
	private String		issuingBank				= null;
	private String		parentAccNo				= null;
	private boolean		issuedToUser			= false;
	private boolean		issuedToSupplier		= false;
	private String		issuedTo				= null;
	private String		nameOnCard				= null;
	private CustomDate	expiryDate				= null;
	private String		securityKey				= null;
	private String		billingCurrency			= null;
	private CustomDate	lastBilledOnDate		= null;
	private String		statementFrequency		= null;
	private int			creditDays;
	private String		allowedOUs;
	private boolean		matchSupplierInvoice	= false;
	private int			spendPerTransaction;
	private int			spendPerDay;
	private int			spendPerCycle;
	private int			transactionsPerDay;
	private int			transactionsPerCycle;
	private String		nextAction				= null;
	private boolean		result					= false;

	public String getpCardType()
	{
		return pCardType;
	}

	public void setpCardType(String pCardType)
	{
		this.pCardType = pCardType;
	}

	public String getpCardNo()
	{
		return pCardNo;
	}

	public void setpCardNo(String pCardNo)
	{
		this.pCardNo = pCardNo;
	}

	public String getIssuingBank()
	{
		return issuingBank;
	}

	public void setIssuingBank(String issuingBank)
	{
		this.issuingBank = issuingBank;
	}

	public String getParentAccNo()
	{
		return parentAccNo;
	}

	public void setParentAccNo(String parentAccNo)
	{
		this.parentAccNo = parentAccNo;
	}

	public boolean isIssuedToUser()
	{
		return issuedToUser;
	}

	public void setIssuedToUser(boolean issuedToUser)
	{
		this.issuedToUser = issuedToUser;
	}

	public boolean isIssuedToSupplier()
	{
		return issuedToSupplier;
	}

	public void setIssuedToSupplier(boolean issuedToSupplier)
	{
		this.issuedToSupplier = issuedToSupplier;
	}

	public String getIssuedTo()
	{
		return issuedTo;
	}

	public void setIssuedTo(String issuedTo)
	{
		this.issuedTo = issuedTo;
	}

	public String getNameOnCard()
	{
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard)
	{
		this.nameOnCard = nameOnCard;
	}

	public CustomDate getExpiryDate()
	{
		return expiryDate;
	}

	public void setExpiryDate(CustomDate expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	public String getSecurityKey()
	{
		return securityKey;
	}

	public void setSecurityKey(String securityKey)
	{
		this.securityKey = securityKey;
	}

	public String getBillingCurrency()
	{
		return billingCurrency;
	}

	public void setBillingCurrency(String billingCurrency)
	{
		this.billingCurrency = billingCurrency;
	}

	public CustomDate getLastBilledOnDate()
	{
		return lastBilledOnDate;
	}

	public void setLastBilledOnDate(CustomDate lastBilledOnDate)
	{
		this.lastBilledOnDate = lastBilledOnDate;
	}

	public String getStatementFrequency()
	{
		return statementFrequency;
	}

	public void setStatementFrequency(String statementFrequency)
	{
		this.statementFrequency = statementFrequency;
	}

	public int getCreditDays()
	{
		return creditDays;
	}

	public void setCreditDays(int creditDays)
	{
		this.creditDays = creditDays;
	}

	public String getAllowedOUs()
	{
		return allowedOUs;
	}

	public void setAllowedOUs(String allowedOUs)
	{
		this.allowedOUs = allowedOUs;
	}

	public boolean isMatchSupplierInvoice()
	{
		return matchSupplierInvoice;
	}

	public void setMatchSupplierInvoice(boolean matchSupplierInvoice)
	{
		this.matchSupplierInvoice = matchSupplierInvoice;
	}

	public int getSpendPerTransaction()
	{
		return spendPerTransaction;
	}

	public void setSpendPerTransaction(int spendPerTransaction)
	{
		this.spendPerTransaction = spendPerTransaction;
	}

	public int getSpendPerDay()
	{
		return spendPerDay;
	}

	public void setSpendPerDay(int spendPerDay)
	{
		this.spendPerDay = spendPerDay;
	}

	public int getSpendPerCycle()
	{
		return spendPerCycle;
	}

	public void setSpendPerCycle(int spendPerCycle)
	{
		this.spendPerCycle = spendPerCycle;
	}

	public int getTransactionsPerDay()
	{
		return transactionsPerDay;
	}

	public void setTransactionsPerDay(int transactionsPerDay)
	{
		this.transactionsPerDay = transactionsPerDay;
	}

	public int getTransactionsPerCycle()
	{
		return transactionsPerCycle;
	}

	public void setTransactionsPerCycle(int transactionsPerCycle)
	{
		this.transactionsPerCycle = transactionsPerCycle;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

}
