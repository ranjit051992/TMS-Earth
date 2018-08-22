/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class InviteSupplier
{
	private boolean	inviteAllSuppliers		= false;
	private boolean	inviteSelectedSuppliers	= false;
	private String	supplierName			= null;
	private String	invitationTemplateMsg	= null;
	private String	nextAction				= null;
	private boolean	result					= false;

	public boolean isInviteAllSuppliers()
	{
		return inviteAllSuppliers;
	}

	public void setInviteAllSuppliers(boolean inviteAllSuppliers)
	{
		this.inviteAllSuppliers = inviteAllSuppliers;
	}

	public boolean isInviteSelectedSuppliers()
	{
		return inviteSelectedSuppliers;
	}

	public void setInviteSelectedSuppliers(boolean inviteSelectedSuppliers)
	{
		this.inviteSelectedSuppliers = inviteSelectedSuppliers;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName)
	{
		this.supplierName = supplierName;
	}

	public String getInvitationTemplateMsg()
	{
		return invitationTemplateMsg;
	}

	public void setInvitationTemplateMsg(String invitationTemplateMsg)
	{
		this.invitationTemplateMsg = invitationTemplateMsg;
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
