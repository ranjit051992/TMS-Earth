/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.poattachment;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalPOAttachment
{
	static UI_Elements	INPUT_PO_ATTACHMENT					= UIFactory.getElements("INPUT_PO_ATTACHMENT");
	static UI_Elements	LABEL_PO_ATTACHMENT_NAME			= UIFactory.getElements("LABEL_PO_ATTACHMENT_NAME");
	static UI_Elements	LABEL_PO_ATTACHMENT_STATUS			= UIFactory.getElements("LABEL_PO_ATTACHMENT_STATUS");
	static UI_Elements	LABEL_PO_ATTACHMENT_SIZE			= UIFactory.getElements("LABEL_PO_ATTACHMENT_SIZE");
	static UI_Elements	BUTTON_DONE_PO_ATTACHMENT			= UIFactory.getElements("BUTTON_DONE_PO_ATTACHMENT");
	static UI_Elements	LINK_DOWNLOAD_PO_ATTACHMENT			= UIFactory.getElements("LINK_DOWNLOAD_PO_ATTACHMENT");
	static UI_Elements	SELECT_VISIBILITY_OF_PO_ATTACHMENT	= UIFactory.getElements("SELECT_VISIBILITY_OF_PO_ATTACHMENT");

}
