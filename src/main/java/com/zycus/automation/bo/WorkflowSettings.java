package com.zycus.automation.bo;

public class WorkflowSettings
{
	private String	replacingApproverHavingHigherApprovalLimitThanNewApprover;
	private String	replacingApproverWithDifferentDesignation;
	private String	replacingApproverHavingHigherDesignationThanNewApprover;
	private String	replacingAprroverWithNonOverlappingScope;
	private boolean	allowNewTagsInWorkflow;
	private boolean	autoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin;
	private boolean	preventRecursiveDelegation;

	public String getReplacingApproverHavingHigherApprovalLimitThanNewApprover()
	{
		return replacingApproverHavingHigherApprovalLimitThanNewApprover;
	}

	public void setReplacingApproverHavingHigherApprovalLimitThanNewApprover(String replacingApproverHavingHigherApprovalLimitThanNewApprover)
	{
		this.replacingApproverHavingHigherApprovalLimitThanNewApprover = replacingApproverHavingHigherApprovalLimitThanNewApprover;
	}

	public String getReplacingApproverWithDifferentDesignation()
	{
		return replacingApproverWithDifferentDesignation;
	}

	public void setReplacingApproverWithDifferentDesignation(String replacingApproverWithDifferentDesignation)
	{
		this.replacingApproverWithDifferentDesignation = replacingApproverWithDifferentDesignation;
	}

	public String getReplacingApproverHavingHigherDesignationThanNewApprover()
	{
		return replacingApproverHavingHigherDesignationThanNewApprover;
	}

	public void setReplacingApproverHavingHigherDesignationThanNewApprover(String replacingApproverHavingHigherDesignationThanNewApprover)
	{
		this.replacingApproverHavingHigherDesignationThanNewApprover = replacingApproverHavingHigherDesignationThanNewApprover;
	}

	public String getReplacingAprroverWithNonOverlappingScope()
	{
		return replacingAprroverWithNonOverlappingScope;
	}

	public void setReplacingAprroverWithNonOverlappingScope(String replacingAprroverWithNonOverlappingScope)
	{
		this.replacingAprroverWithNonOverlappingScope = replacingAprroverWithNonOverlappingScope;
	}

	public boolean isAllowNewTagsInWorkflow()
	{
		return allowNewTagsInWorkflow;
	}

	public void setAllowNewTagsInWorkflow(boolean allowNewTagsInWorkflow)
	{
		this.allowNewTagsInWorkflow = allowNewTagsInWorkflow;
	}

	public boolean isAutoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin()
	{
		return autoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin;
	}

	public void setAutoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin(boolean autoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin)
	{
		this.autoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin = autoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin;
	}

	public boolean isPreventRecursiveDelegation()
	{
		return preventRecursiveDelegation;
	}

	public void setPreventRecursiveDelegation(boolean preventRecursiveDelegation)
	{
		this.preventRecursiveDelegation = preventRecursiveDelegation;
	}

	@Override
	public String toString()
	{
		return "WorkflowSettings [replacingApproverHavingHigherApprovalLimitThanNewApprover=" + replacingApproverHavingHigherApprovalLimitThanNewApprover
			+ ", replacingApproverWithDifferentDesignation=" + replacingApproverWithDifferentDesignation + ", replacingApproverHavingHigherDesignationThanNewApprover="
			+ replacingApproverHavingHigherDesignationThanNewApprover + ", replacingAprroverWithNonOverlappingScope=" + replacingAprroverWithNonOverlappingScope
			+ ", allowNewTagsInWorkflow=" + allowNewTagsInWorkflow + ", autoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin="
			+ autoApproveDocumentWhenApprovalIsRoutedToWorkflowAdmin + ", preventRecursiveDelegation=" + preventRecursiveDelegation + "]";
	}

}
