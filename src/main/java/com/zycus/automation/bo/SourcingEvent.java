/**
 * 
 */
package com.zycus.automation.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ankita.sawant
 *
 */
@Entity
@Table(name = "SourcingEvent")
public class SourcingEvent
{
	@Id
	@GeneratedValue
	private int					id;
	private String				flowId;
	private String				eventType								= null;
	private String				eventName								= null;
	private String				eventOwner								= null;
	private String				eventDesc								= null;
	private boolean				attachItemLevelGForm					= false;
	private String				nextAction								= null;
	@OneToMany(cascade = CascadeType.ALL)
	private List<GuidedItem>	guidedItems								= null;
	private String				nextActionAfterCreatingSourcingEvent	= null;

	public String getNextActionAfterCreatingSourcingEvent()
	{
		return nextActionAfterCreatingSourcingEvent;
	}

	public void setNextActionAfterCreatingSourcingEvent(String nextActionAfterCreatingSourcingEvent)
	{
		this.nextActionAfterCreatingSourcingEvent = nextActionAfterCreatingSourcingEvent;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFlowId()
	{
		return flowId;
	}

	public void setFlowId(String flowId)
	{
		this.flowId = flowId;
	}

	public List<GuidedItem> getGuidedItems()
	{
		return guidedItems;
	}

	public void setGuidedItems(List<GuidedItem> guidedItems)
	{
		this.guidedItems = guidedItems;
	}

	public String getEventType()
	{
		return eventType;
	}

	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}

	public String getEventName()
	{
		return eventName;
	}

	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}

	public String getEventOwner()
	{
		return eventOwner;
	}

	public void setEventOwner(String eventOwner)
	{
		this.eventOwner = eventOwner;
	}

	public String getEventDesc()
	{
		return eventDesc;
	}

	public void setEventDesc(String eventDesc)
	{
		this.eventDesc = eventDesc;
	}

	public boolean isAttachItemLevelGForm()
	{
		return attachItemLevelGForm;
	}

	public void setAttachItemLevelGForm(boolean attachItemLevelGForm)
	{
		this.attachItemLevelGForm = attachItemLevelGForm;
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
