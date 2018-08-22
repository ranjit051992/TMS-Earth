/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class OtherNotificationSetting
{
	private boolean	onBuyersDesk		= false;
	private boolean	onPOReleased		= false;
	private String	buyersDeskSubject	= null;
	private String	buyersDeskBody		= null;
	private String	poReleasedSubject	= null;
	private String	poReleasedBody		= null;
	private String	nextAction			= null;

	public boolean isOnBuyersDesk()
	{
		return onBuyersDesk;
	}

	public void setOnBuyersDesk(boolean onBuyersDesk)
	{
		this.onBuyersDesk = onBuyersDesk;
	}

	public boolean isOnPOReleased()
	{
		return onPOReleased;
	}

	public void setOnPOReleased(boolean onPOReleased)
	{
		this.onPOReleased = onPOReleased;
	}

	public String getBuyersDeskSubject()
	{
		return buyersDeskSubject;
	}

	public void setBuyersDeskSubject(String buyersDeskSubject)
	{
		this.buyersDeskSubject = buyersDeskSubject;
	}

	public String getBuyersDeskBody()
	{
		return buyersDeskBody;
	}

	public void setBuyersDeskBody(String buyersDeskBody)
	{
		this.buyersDeskBody = buyersDeskBody;
	}

	public String getPoReleasedSubject()
	{
		return poReleasedSubject;
	}

	public void setPoReleasedSubject(String poReleasedSubject)
	{
		this.poReleasedSubject = poReleasedSubject;
	}

	public String getPoReleasedBody()
	{
		return poReleasedBody;
	}

	public void setPoReleasedBody(String poReleasedBody)
	{
		this.poReleasedBody = poReleasedBody;
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
