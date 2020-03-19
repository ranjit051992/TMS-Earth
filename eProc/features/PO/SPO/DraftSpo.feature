Feature: DraftSpo

@Non-COA @L1 @106noncoa
  Scenario: To verify that user is able to add item for the PO in draft state

  Given I am logged in eProc
  And I am on PO listing page 

  When I click on Create PO button
  And I click on Create SPO button
  And I fill PO number
  And I fill Order Description
  And I add Purchase type
  And I select supplier details
  And I select Buyer
  And I add Required by date
  And I search catalog item with "search_term"
  And I add costing and accounting details for that item
  And I Save PO as draft
  And I am on PO listing page
  And I search for the created po
  And I edit the drafted PO
  And I add 1 catalog item "ITEM_NAME_FOR_SEARCHING[1]"
  And I submit the PO 
  And I search for the created po
  And I view the PO

  Then Item should be added "ITEM_NAME_FOR_SEARCHING[1]" at index 2


@Non-COA @L1 @107noncoa
  Scenario: To verify that user is able to add item for the PO in draft state

  Given I am logged in eProc 
  And I have created a requisition with 1 "ITEM_NAME_FOR_SEARCHING" and not converted it to PO

  When I navigate to Buyer Desk
  And I search for the created req on buyer listing
  And I check if req status is in Pending Order status on buyer listing
  And I click on option icon
  And I click on Convert to PO option
  And I click on Purchase Order details checkbox
  And I click on Save PO as draft button
  And I search for the converted PO by req number
  And I edit the drafted PO

  Then Item should be added "ITEM_NAME_FOR_SEARCHING" at index 1 in edit mode


//**********************COA**********************//


@COA @L1 @137coa
  Scenario: COA _ To verify that user is able to add item for the PO in draft state

  Given I am logged in eProc
  And I am on PO listing page 

  When I click on Create PO button
  And I click on Create SPO button
  And I fetch PO number
  And I fill Order Description
  And I add Purchase type
  And I select supplier details
  And I select Buyer
  And I add Required by date
  And I search catalog item with "search_term"
  And I add costing and accounting details for that item
  And I Save PO as draft
  And I am on PO listing page
  And I search for the created po
  And I edit the drafted PO
  And I add 1 catalog item "ITEM_NAME_FOR_SEARCHING[1]"
  And I submit the PO 
  And I search for the created po
  And I view the PO

  Then Item should be added "ITEM_NAME_FOR_SEARCHING[1]" at index 2


@COA @L1 @138coa
  Scenario: COA _ To verify that user is able to add item for the PO in draft state

  Given I am logged in eProc 
  And I have created a requisition with 1 "ITEM_NAME_FOR_SEARCHING" and not converted it to PO

  When I navigate to Buyer Desk
  And I search for the created req on buyer listing
  And I check if req status is in Pending Order status on buyer listing
  And I click on option icon
  And I click on Convert to PO option
  And I click on Purchase Order details checkbox
  And I click on Save PO as draft button
  And I search for the converted PO by req number
  And I edit the drafted PO

  Then Item should be added "ITEM_NAME_FOR_SEARCHING" at index 1 in edit mode