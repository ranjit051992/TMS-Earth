Feature: CreateSpo

@Non-COA @L2 @85noncoa
Scenario: To verify that user is able to create a SPO with single & multiple line items and with attachments in Zycus eproc

  Given I am logged in eProc
  And I have created a PO with 1 "ITEM_NAME_FOR_SEARCHING" and 1 free text item and header level attachment

  When I view the PO

  Then Item should be added "ITEM_NAME_FOR_SEARCHING" at index 1
  And Free text item should be added at index 2
  And Attachment should be added


@Non-COA @L1 @86noncoa
  Scenario: To verify that user is able to create a Req_PO with single and multiple line items and with attachments in Zycus eproc

  Given I am logged in eProc 
  And I have created a req to po with 2 "ITEM_NAME_FOR_SEARCHING" and 1 free text item and header level attachment "ATTACHMENT_PATH"

  When I view the PO

  Then Req items should be added
  And Attachment should be added


//**********************COA**********************//


@COA @L1 @116coa  
Scenario: COA _ To verify that user is able to create a SPO with single & multiple line items and with attachments in Zycus eproc

  Given I am logged in eProc
  And I have created a PO with 1 "ITEM_NAME_FOR_SEARCHING" and 1 free text item and header level attachment

  When I view the PO

  Then Item should be added "ITEM_NAME_FOR_SEARCHING" at index 1
  And Free text item should be added at index 2
  And Attachment should be added


@COA @L1 @117coa
  Scenario: COA _ To verify that user is able to create a Req_PO with single and multiple line items and with attachments in Zycus eproc

  Given I am logged in eProc 
  And I have created a req to po with 1 "ITEM_NAME_FOR_SEARCHING" and 1 free text item and header level attachment "ATTACHMENT_PATH"

  When I view the PO

  Then Req items should be added
  And Attachment should be added