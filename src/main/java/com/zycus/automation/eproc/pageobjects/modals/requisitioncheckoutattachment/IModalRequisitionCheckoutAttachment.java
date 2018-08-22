/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.requisitioncheckoutattachment;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalRequisitionCheckoutAttachment
{
	static UI_Elements	INPUT_SELECT_ATTACHMENT_ON_CHECKOUT_PAGE	= UIFactory.getElements("INPUT_SELECT_ATTACHMENT_ON_CHECKOUT_PAGE");

	static UI_Elements	BUTTON_DONE_ATTACHMENT_ON_CHECKOUT_PAGE		= UIFactory.getElements("BUTTON_DONE_ATTACHMENT_ON_CHECKOUT_PAGE");
	static UI_Elements	LABEL_ATTACHMENT_NAME_ON_CHECKOUT_PAGE		= UIFactory.getElements("LABEL_ATTACHMENT_NAME_ON_CHECKOUT_PAGE");
	static UI_Elements	LABEL_ATTACHMENT_STATUS_ON_CHECKOUT_PAGE	= UIFactory.getElements("LABEL_ATTACHMENT_STATUS_ON_CHECKOUT_PAGE");
	static UI_Elements	LABEL_ATTACHMENT_SIZE_ON_CHECKOUT_PAGE		= UIFactory.getElements("LABEL_ATTACHMENT_SIZE_ON_CHECKOUT_PAGE");

}
