/**
 * 
 */
package com.zycus.automation.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amitkumar.dash
 *
 */
public class PoStatusFilter
{
	private boolean			draftFilter;
	private boolean			inprogress;
	private boolean			released;
	private boolean			returned;
	private boolean			rejected;
	private boolean			closed;
	private boolean			canceled;
	private boolean			expired;
	private boolean			schdule;
	private boolean			payments;
	private boolean			notPaid					= false;
	private boolean			partiallyPaid			= false;
	private boolean			fullyPaid				= false;
	private boolean			paymentNotApplicable	= false;
	private boolean			notSentToSupplier		= false;
	private List<String>	status					= new ArrayList<String>();

	public boolean isNotPaid()
	{
		return notPaid;
	}

	public void setNotPaid(boolean notPaid)
	{
		this.notPaid = notPaid;
	}

	public boolean isPartiallyPaid()
	{
		return partiallyPaid;
	}

	public void setPartiallyPaid(boolean partiallyPaid)
	{
		this.partiallyPaid = partiallyPaid;
	}

	public boolean isFullyPaid()
	{
		return fullyPaid;
	}

	public void setFullyPaid(boolean fullyPaid)
	{
		this.fullyPaid = fullyPaid;
	}

	public boolean isPaymentNotApplicable()
	{
		return paymentNotApplicable;
	}

	public void setPaymentNotApplicable(boolean paymentNotApplicable)
	{
		this.paymentNotApplicable = paymentNotApplicable;
	}

	public List<String> getStatus()
	{
		return status;
	}

	public void setStatus(List<String> status)
	{
		this.status = status;
	}

	public boolean isNotSentToSupplier()
	{
		return notSentToSupplier;
	}

	public void setNotSentToSupplier(boolean notSentToSupplier)
	{
		this.notSentToSupplier = notSentToSupplier;
	}

	public boolean isInprogress()
	{
		return inprogress;
	}

	public void setInprogress(boolean inprogress)
	{
		this.inprogress = inprogress;
	}

	public boolean isReleased()
	{
		return released;
	}

	public void setReleased(boolean released)
	{
		this.released = released;
	}

	public boolean isReturned()
	{
		return returned;
	}

	public void setReturned(boolean returned)
	{
		this.returned = returned;
	}

	public boolean isRejected()
	{
		return rejected;
	}

	public void setRejected(boolean rejected)
	{
		this.rejected = rejected;
	}

	public boolean isClosed()
	{
		return closed;
	}

	public void setClosed(boolean closed)
	{
		this.closed = closed;
	}

	public boolean isCanceled()
	{
		return canceled;
	}

	public void setCanceled(boolean canceled)
	{
		this.canceled = canceled;
	}

	public boolean isExpired()
	{
		return expired;
	}

	public void setExpired(boolean expired)
	{
		this.expired = expired;
	}

	public boolean isSchdule()
	{
		return schdule;
	}

	public void setSchdule(boolean schdule)
	{
		this.schdule = schdule;
	}

	public boolean isPayments()
	{
		return payments;
	}

	public void setPayments(boolean payments)
	{
		this.payments = payments;
	}

	public boolean isDraftFilter()
	{
		return draftFilter;
	}

	public void setDraftFilter(boolean draftFilter)
	{
		this.draftFilter = draftFilter;
	}
}
