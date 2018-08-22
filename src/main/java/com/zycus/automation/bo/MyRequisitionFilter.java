/**
 * 
 */
package com.zycus.automation.bo;

import java.util.Date;
import java.util.List;

/**
 * @author ankita.sawant
 *
 */
public class MyRequisitionFilter
{
	private boolean			draftFilter;
	private boolean			readyForApprovalFilter;
	private boolean			inApprovalFilter;
	private boolean			withBuyerFilter;
	private boolean			returnedForAmendmentFilter;
	private boolean			scheduledFilter;
	private boolean			completeReleasedFilter;
	private boolean			partiallyOrderedFilter;
	private boolean			notReceivedFilter;
	private boolean			partiallyReceivedFilter;
	private boolean			fullyReceivedFilter;
	private boolean			rejectedFilter;
	private boolean			closedFilter;
	private boolean			cancelledFilter;
	private boolean			returnedWithQuote;
	private boolean			sentForQuote;
	private boolean			transferredToMe	= false;
	private Date			fromDate;
	private Date			toDate;
	private Double			fromAmountRange;
	private Double			toAmountRange;
	private List<String>	currencyOfAmount;
	private boolean			result;
	private List<String>	statusOfFilter;

	public boolean isTransferredToMe()
	{
		return transferredToMe;
	}

	public void setTransferredToMe(boolean transferredToMe)
	{
		this.transferredToMe = transferredToMe;
	}

	public boolean isDraftFilter()
	{
		return draftFilter;
	}

	public void setDraftFilter(boolean draftFilter)
	{
		this.draftFilter = draftFilter;
	}

	public boolean isReadyForApprovalFilter()
	{
		return readyForApprovalFilter;
	}

	public void setReadyForApprovalFilter(boolean readyForApprovalFilter)
	{
		this.readyForApprovalFilter = readyForApprovalFilter;
	}

	public boolean isInApprovalFilter()
	{
		return inApprovalFilter;
	}

	public void setInApprovalFilter(boolean inApprovalFilter)
	{
		this.inApprovalFilter = inApprovalFilter;
	}

	public boolean isWithBuyerFilter()
	{
		return withBuyerFilter;
	}

	public void setWithBuyerFilter(boolean withBuyerFilter)
	{
		this.withBuyerFilter = withBuyerFilter;
	}

	public boolean isReturnedForAmendmentFilter()
	{
		return returnedForAmendmentFilter;
	}

	public void setReturnedForAmendmentFilter(boolean returnedForAmendmentFilter)
	{
		this.returnedForAmendmentFilter = returnedForAmendmentFilter;
	}

	public boolean isScheduledFilter()
	{
		return scheduledFilter;
	}

	public void setScheduledFilter(boolean scheduledFilter)
	{
		this.scheduledFilter = scheduledFilter;
	}

	public boolean isCompleteReleasedFilter()
	{
		return completeReleasedFilter;
	}

	public void setCompleteReleasedFilter(boolean completeReleasedFilter)
	{
		this.completeReleasedFilter = completeReleasedFilter;
	}

	public boolean isPartiallyOrderedFilter()
	{
		return partiallyOrderedFilter;
	}

	public void setPartiallyOrderedFilter(boolean partiallyOrderedFilter)
	{
		this.partiallyOrderedFilter = partiallyOrderedFilter;
	}

	public boolean isNotReceivedFilter()
	{
		return notReceivedFilter;
	}

	public void setNotReceivedFilter(boolean notReceivedFilter)
	{
		this.notReceivedFilter = notReceivedFilter;
	}

	public boolean isPartiallyReceivedFilter()
	{
		return partiallyReceivedFilter;
	}

	public void setPartiallyReceivedFilter(boolean partiallyReceivedFilter)
	{
		this.partiallyReceivedFilter = partiallyReceivedFilter;
	}

	public boolean isFullyReceivedFilter()
	{
		return fullyReceivedFilter;
	}

	public void setFullyReceivedFilter(boolean fullyReceivedFilter)
	{
		this.fullyReceivedFilter = fullyReceivedFilter;
	}

	public boolean isRejectedFilter()
	{
		return rejectedFilter;
	}

	public void setRejectedFilter(boolean rejectedFilter)
	{
		this.rejectedFilter = rejectedFilter;
	}

	public boolean isClosedFilter()
	{
		return closedFilter;
	}

	public void setClosedFilter(boolean closedFilter)
	{
		this.closedFilter = closedFilter;
	}

	public boolean isCancelledFilter()
	{
		return cancelledFilter;
	}

	public void setCancelledFilter(boolean cancelledFilter)
	{
		this.cancelledFilter = cancelledFilter;
	}

	public boolean isReturnedWithQuote()
	{
		return returnedWithQuote;
	}

	public void setReturnedWithQuote(boolean returnedWithQuote)
	{
		this.returnedWithQuote = returnedWithQuote;
	}

	public boolean isSentForQuote()
	{
		return sentForQuote;
	}

	public void setSentForQuote(boolean sentForQuote)
	{
		this.sentForQuote = sentForQuote;
	}

	public Date getFromDate()
	{
		return fromDate;
	}

	public void setFromDate(Date fromDate)
	{
		this.fromDate = fromDate;
	}

	public Date getToDate()
	{
		return toDate;
	}

	public void setToDate(Date toDate)
	{
		this.toDate = toDate;
	}

	public Double getFromAmountRange()
	{
		return fromAmountRange;
	}

	public void setFromAmountRange(Double fromAmountRange)
	{
		this.fromAmountRange = fromAmountRange;
	}

	public Double getToAmountRange()
	{
		return toAmountRange;
	}

	public void setToAmountRange(Double toAmountRange)
	{
		this.toAmountRange = toAmountRange;
	}

	public List<String> getCurrencyOfAmount()
	{
		return currencyOfAmount;
	}

	public void setCurrencyOfAmount(List<String> currencyOfAmount)
	{
		this.currencyOfAmount = currencyOfAmount;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public List<String> getStatusOfFilter()
	{
		return statusOfFilter;
	}

	public void setStatusOfFilter(List<String> statusOfFilter)
	{
		this.statusOfFilter = statusOfFilter;
	}

	@Override
	public String toString()
	{
		return "MyRequisitionFilter [draftFilter=" + draftFilter + ", readyForApprovalFilter=" + readyForApprovalFilter + ", inApprovalFilter=" + inApprovalFilter
			+ ", withBuyerFilter=" + withBuyerFilter + ", returnedForAmendmentFilter=" + returnedForAmendmentFilter + ", scheduledFilter=" + scheduledFilter
			+ ", completeReleasedFilter=" + completeReleasedFilter + ", partiallyOrderedFilter=" + partiallyOrderedFilter + ", notReceivedFilter=" + notReceivedFilter
			+ ", partiallyReceivedFilter=" + partiallyReceivedFilter + ", fullyReceivedFilter=" + fullyReceivedFilter + ", rejectedFilter=" + rejectedFilter + ", closedFilter="
			+ closedFilter + ", cancelledFilter=" + cancelledFilter + ", returnedWithQuote=" + returnedWithQuote + ", sentForQuote=" + sentForQuote + ", fromDate=" + fromDate
			+ ", toDate=" + toDate + ", fromAmountRange=" + fromAmountRange + ", toAmountRange=" + toAmountRange + ", currencyOfAmount=" + currencyOfAmount + "]";
	}

}
