Feature: AmendSpo

@Non-COA @L1 @87noncoa
  Scenario: To verify that user is able to amend an existing PO to add more item

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Amend PO
  And I add 1 catalog item "ITEM_NAME_FOR_SEARCHING[1]"
  And I add amend PO comments
  And I submit the amendment
  And I search for the created po
  And I view the amended PO

  Then Item should be added "ITEM_NAME_FOR_SEARCHING[1]" at index 2


@Non-COA @L1 @89noncoa
  Scenario: To verify that user is able to change the delivery address on PO amend

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Amend PO
  And I scroll to Line Item section
  And I click on Shipping Details link for item "ITEM_NAME_FOR_SEARCHING"
  And I change the delivery address at line level to "SPO_SHIP_TO_ADDRESS[1]"
  And I save the delivery address
  And I add amend PO comments
  And I submit the amendment
  And I search for the created po
  And I view the amended PO
  And I scroll to Line Item section
  And I click on Shipping Details link for item "ITEM_NAME_FOR_SEARCHING"

  Then "SPO_SHIP_TO_ADDRESS[1]" delivery address should be displayed


@Non-COA @L1 @91noncoa
  Scenario: To verify that user is able to change the payment terms on PO amend

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Amend PO
  And I scroll to Supplier Details section
  And I change the payment term at line level to "PAYMENT_TERMS[1]"
  And I add amend PO comments
  And I submit the amendment
  And I search for the created po
  And I view the amended PO
  And I scroll to Supplier Details section

  Then "PAYMENT_TERMS[1]" payment term should be displayed


@Non-COA @L1 @88noncoa
  Scenario: To verify that user is able to amend an existing PO to add more item via requisition

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I have created a requisition with that PO linked and with 1 "ITEM_NAME_FOR_SEARCHING[1]"
  And I navigate to req listing
  And I search for the created req on req listing
  And I fetch the req number on req listing
  And I fetch the req status on req listing
  
  When I approve the requisition
  And I navigate to Buyer Desk
  And I search for the created req on buyer listing
  And I click on option icon
  And I click on Convert to PO option for req created with linked PO
  And I add amend PO comments
  And I submit the PO 
  And I search for the converted PO by req number
  And I view the PO
  Then Item should be added "ITEM_NAME_FOR_SEARCHING[1]" at index 2


@Non-COA @L1 @102noncoa
  Scenario: To verify that the PO Line item numbering when linking a new PR to an Amended PO should be unique (per item) with respect to all the versions of a PO existing in the system

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I have created a requisition with that PO linked and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING[1]"

  When I search for the converted PO by req number
  And I view the PO

  Then I should be able to see the new item with unique line item number


# //**********************COA**********************//


@COA @L1 @118coa
  Scenario: COA _ To verify that user is able to amend an existing PO to add more item

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Amend PO
  And I add 1 catalog item "ITEM_NAME_FOR_SEARCHING[1]"
  And I add amend PO comments
  And I submit the amendment
  And I search for the created po
  And I view the amended PO

  Then Item should be added "ITEM_NAME_FOR_SEARCHING[1]" at index 2


@COA @L1 @120coa
  Scenario: COA _ To verify that user is able to change the delivery address on PO amend

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Amend PO
  And I scroll to Line Item section
  And I click on Shipping Details link for item "ITEM_NAME_FOR_SEARCHING"
  And I change the delivery address at line level to "SPO_SHIP_TO_ADDRESS[1]"
  And I save the delivery address
  And I add amend PO comments
  And I submit the amendment
  And I search for the created po
  And I view the amended PO
  And I scroll to Line Item section
  And I click on Shipping Details link for item "ITEM_NAME_FOR_SEARCHING"

  Then "SPO_SHIP_TO_ADDRESS[1]" delivery address should be displayed


@COA @L1 @122coa
  Scenario: COA _ To verify that user is able to change the payment terms on PO amend

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Amend PO
  And I scroll to Supplier Details section
  And I change the payment term at line level to "PAYMENT_TERMS[1]"
  And I add amend PO comments
  And I submit the amendment
  And I search for the created po
  And I view the amended PO
  And I scroll to Supplier Details section

  Then "PAYMENT_TERMS[1]" payment term should be displayed


@COA @L1 @119coa
  Scenario: COA _ To verify that user is able to amend an existing PO to add more item via requisition

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I have created a requisition with that PO linked and with 1 "ITEM_NAME_FOR_SEARCHING[1]"
  And I navigate to req listing
  And I search for the created req on req listing
  And I fetch the req number on req listing
  And I fetch the req status on req listing
  
  When I approve the requisition
  When I navigate to Buyer Desk
  And I search for the created req on buyer listing
  And I click on option icon
  And I click on Convert to PO option for req created with linked PO
  And I add amend PO comments
  And I submit the PO 
  And I search for the converted PO by req number
  And I view the PO
  Then Item should be added "ITEM_NAME_FOR_SEARCHING[1]" at index 2


@COA @L1 @133coa
  Scenario: COA _ To verify that the PO Line item numbering when linking a new PR to an Amended PO should be unique (per item) with respect to all the versions of a PO existing in the system

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I have created a requisition with that PO linked and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING[1]"

  When I search for the converted PO by req number
  And I view the PO

  Then I should be able to see the new item with unique line item number


@Non-COA @L1 @Snehal @reqPo
  Scenario: To verify the behavior of requisition who has PO attached to them
  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I have created a requisition with that PO linked and with 1 "ITEM_NAME_FOR_SEARCHING[1]"
  And I approve the requisition
  And I navigate to Buyer Desk
  And I edit the requisition on buyers desk listing
  And I select the item and Convert req to PO

  Then I should be able to see PO Amendment page of the PO which is added

@COA @L1 @CoaPo
  Scenario: COA>>To verify the behavior of requisition who has PO attached to them
  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I have created a requisition with that PO linked and with 1 "ITEM_NAME_FOR_SEARCHING[1]"
  And I approve the requisition
  And I navigate to Buyer Desk
  And I edit the requisition on buyers desk
  And I select the item and Convert req to PO
  Then I should be able to see PO Amendment page of the PO which is added