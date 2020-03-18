Feature: Spo

  # Background:
  #   Given I am logged in eProc

  # @spotag
  # Scenario: Create Standard PO

  # Given I am on PO listing page
    
  # And I Create Standard po with 1 "Catalog" item
  
  # And i search po by descr/iption 


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


@Non-COA @L1 @90noncoa
  Scenario: To verify that user is able to recall a PO after it is submitted

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
  And I submit the PO
  And I am on PO listing page
  And I search for the created po
  And I click on option icon
  And I click on Recall option
  And I enter recall comments
  And I click on Recall button
  And I click on recalled success message Done button
  And I am on PO listing page
  And I search for the created po

  Then PO status should be draft


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


@Non-COA @L1 @92noncoa
  Scenario: To verify that user is able to close a SPO

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Close PO action against the PO
  And I enter close PO comments
  And I click on Close PO button on the confirmation Popup
  And I click on closed po success message Done button
  And I am on PO listing page
  And I search for the created po

  Then I should be able to see the PO in closed status


@Non-COA @L1 @94noncoa
  Scenario: To verify that user is able to cancel a SPO 

  Given I am logged in eProc
  And I have created and released a PO

  When I view the PO
  And I click on Cancel PO action within Actions tab
  And I fill Cancel comments
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the PO in Cancelled status


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


@Non-COA @L1 @108noncoa
  Scenario: To verify remind approver action for SPO

  Given I am logged in eProc 
  And I have submitted a SPO with a catalog item
  And the PO is in In Approval status

  When I click on Remind approver action against the PO

  Then I should be able to send reminder to the approver


@Non-COA @L1 @93noncoa
  Scenario: To verify that user is able to close a Req_PO

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"

  When I am on PO listing page
  And I search for the converted PO
  And I click on option icon
  And I click on Close PO action against the PO
  And I enter close PO comments
  And I click on Close PO button on the confirmation Popup
  And I click on closed po success message Done button
  And I am on PO listing page
  And I search for the converted PO

  Then I should be able to see the PO in closed status


@Non-COA @L1 @95noncoa
  Scenario: To verify that user is able to cancel a Req_PO

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"

  When I am on PO listing page
  And I search for the converted PO
  And I view the PO
  And I click on Cancel PO action within Actions tab
  And I fill Cancel comments
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the converted PO in Cancelled status


@Non-COA @L1 @109noncoa
  Scenario: To verify remind approver for req to PO

  Given I am logged in eProc 
  And I have created a req to PO with PO in In Approval status

  When I click on Remind approver action against the PO

  Then I should be able to send reminder to the approver


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
  And I have created a req to po with 1 "ITEM_NAME_FOR_SEARCHING" and 1 free text item and header level attachment "ATTACHMENT_PATH"

  When I view the PO

  Then Req items should be added
  And Attachment should be added


# @Non-COA @L1
#   Scenario: To verify that user is able to cancel a BPO

#   Given I am logged in eProc
#   And I have created and released a BPO

#   When I view the BPO created 
#   And I click on Cancel PO action within Actions tab
#   And I click on Cancel PO button on the confirmation Popup

#   Then I should be able to see the BPO in Cancelled status

 
# @Non-COA @L1
#   Scenario: To verify that user is able to create a blanket PO with attachments in Zycus P2P

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create Blanket PO button
#   And I select supplier details
#   And I add Required by date
#   And I search catalog item with "search_term" 
#   And I add costing and accounting details for that item
#   And I add 1 free text item with details
#   And I add 1 attachment at header level
#   And I Define Buying Scope
#   And I enter current date in Validity To date
#   And I enter current date in Validity From date
#   And I submit the PO 

#   Then I should be able to view the BPO with multiple items and attachments 


# @Non-COA @L1
#   Scenario: To verify that user is able to choose a start date and an End Date

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create Blanket PO button
#   And I select supplier details
#   And I add Required by date
#   And I search catalog item with "search_term" 
#   And I add costing and accounting details for that item
#   And I Define Buying Scope
#   And I enter current date in Validity To date
#   And I enter 3 days ahead of current date in Validity From date
#   And I submit the BPO 

#   Then I should be able to view the BPO with Validity To and From dates selected

  
# @Non-COA @L1
#   Scenario: To verify that user is able to choose a spend limit

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create Blanket PO button
#   And I select supplier details
#   And I add Required by date
#   And I search catalog item with "search_term" 
#   And I add costing and accounting details for that item
#   And I uncheck Auto update checkbox for Order Value field
#   And I add Order Value "10*item_price"
#   And I Define Buying Scope
#   And I enter current date in Validity To date
#   And I enter current date in Validity From date
#   And I submit the BPO 

#   Then I should be able to view the BPO with Order Value entered


# @Non-COA @L1
#   Scenario: To verify that user is able to create PO releases against Blanket PO

#   Given I am logged in eProc
#   And I have created a Blanket PO with a catalog item

#   When I click on Create Release action against the BPO created
#   And I fill the accounting details against the item
#   And I submit the Release
#   And I view the release created

#   Then I should be able to view the details filled in Release (Supplier, item name, item price, GL Account)


# @Non-COA @L1
#   Scenario: To verify that user is able to view all the released orders generated against a  BPO on a new tab called "Release Orders"

#   Given I am logged in eProc
#   And I have created a Blanket PO with a catalog item
#   And I have created a release against the BPO.

#   When I view the BPO
#   And I navigate to Release orders tab 

#   Then the Release created against the BPO should be listed there


# @Non-COA @L1
#   Scenario: To verify that user is able to tag a free text item to a particular Blanket PO

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create Blanket PO button
#   And I select supplier details
#   And I add Required by date
#   And I add 1 free text item with details
#   And I add 1 attachment at header level
#   And I Define Buying Scope
#   And I enter current date in Validity To date
#   And I enter current date in Validity From date
#   And I submit the PO 

#   Then I should be able to view the BPO with free text item added ot it


# @Non-COA @L1
#   Scenario: Taxes and Freight and other charges to get apportioned to the line items when setting is set to Yes

#   Given I am logged into CMD
#   And I am on Master data_Customize

#   When I set the setting for Freight Apportionment to Yes
#   And I set the setting for Tax Apportionment to Yes
#   And I navigate to eproc
#   And I navigate to PO listing page
#   And I navigate to PO create page
#   And I search a catalog item with "search_term"
#   And I add it to line item
#   And I add Taxes at header level
#   And I add Freight at header level
#   And I go to cost booking at line level 
#   And I check the total cost booking amount assigned

#   Then I should get apportioned amount assigned for total cost booking amount


# @Non-COA @L1
#   Scenario: Taxes and Freight and other charges to get apportioned to the line items when setting is set to NO

#   Given I am logged into CMD
#   And I am on Master data_Customize

#   When I set the setting for Freight Apportionment to NO
#   And I set the setting for Tax Apportionment to NO
#   And I navigate to eproc
#   And I navigate to PO listing page
#   And I navigate to PO create page
#   And I search a catalog item with "search_term"
#   And I add it to line item
#   And I add Taxes at header level
#   And I add Freight at header level
#   And I go to cost booking at line level 
#   And I check the total costing amount assigned

#   Then I should not get apportioned amount assigned for total cost booking amount


# @Non-COA @L1
#   Scenario: To verify the create invoice action within SPO

#   Given I am logged in eProc 
#   And I have submitted a SPO with a catalog item
#   And I approved the PO to release it.

#   When I navigate to PO listing
#   And I Create an Invoice for all items in the PO created
#   And I navigate to eInvoice approval listing
#   And I approve the einvoice
#   And I navigate to eproc PO listing
#   And I check the status of the PO on PO listing

#   Then I should see the status of the PO to Fully invoiced

 
# @Non-COA @L1
#   Scenario: To verify the cancel action on invoice within SPO

#   Given I am logged in eProc 
#   And I have submitted a SPO with a catalog item
#   And approved the PO to release it.

#   When I navigate to PO listing
#   And I create an Invoice for all items in the PO created 
#   And I navigate to eInvoice approval listing
#   And I approve it
#   And I navigate to eproc PO listing
#   And I view that PO 
#   And I navigate to Invoice subtab
#   And I click on "Void Invoice" action against the invoice created
#   And I check the status of the invoice displayed

#   Then I should be able to see the status of invoice as Cancelled


# @Non-COA @L1
#   Scenario: To verify the close action on invoice within SPO

#   Given I am logged in eProc 
#   And I have submitted a SPO with a catalog item
#   And approved the PO to release it.

#   When I navigate to PO listing
#   And I create an Invoice for all items in the PO created 
#   And I navigate to eInvoice approval listing
#   And I approve that invoice
#   And I navigate to eproc PO listing
#   And I view that PO 
#   And I navigate to Invoice subtab
#   And I click on "Close" action against the invoice created
#   And I check the status of the invoice displayed

#   Then I should be able to see the status of invoice as Closed


# @Non-COA @L1
#   Scenario: To verify the create invoice action within Req_PO

#   Given I am logged in eProc 
#   And I have created a Req_PO with a catalog item
#   And approved that PO to release it.

#   When I navigate to My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And I Create an Invoice for all items in the PO created
#   And I navigate to eInvoice approval listing
#   And I approve the einvoice
#   And I navigate to eproc My Purchase Orders listing
#   And I check the status of that PO

#   Then I should be able to see the status of PO as Fully invoiced

 
# @Non-COA @L1
#   Scenario: To verify the cancel action on invoice within Req_PO

#   Given I am logged in eProc 
#   And I have created a Req_PO with a catalog item
#   And approved that PO to release it.

#   When I navigate to My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And I Create an Invoice for all items in the PO created
#   And I navigate to eInvoice approval listing
#   And I approve the einvoice
#   And I navigate to eproc My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And I click on "Void Invoice" action against the invoice created
#   And I check the status of the invoice displayed

#   Then I should be able to see the status of invoice as Cancelled


# @Non-COA @L1
#   Scenario: To verify the close action on invoice within Req_PO

#   Given I am logged in eProc 
#   And I have created a Req_PO with a catalog item
#   And approved that PO to release it.

#   When I navigate to My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And ICreate an Invoice for all items in the PO created
#   And I navigate to eInvoice approval listing
#   And I approve the einvoice
#   And I navigate to eproc My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And I click on "Close" action against the invoice created
#   And I check the status of the invoice displayed

#   Then I should be able to see the status of invoice as Closed


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


@COA @L1 @121coa
  Scenario: COA _ To verify that user is able to recall a PO after it is submitted

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
  And I submit the PO
  And I am on PO listing page
  And I search for the created po
  And I click on option icon
  And I click on Recall option
  And I enter recall comments
  And I click on Recall button
  And I click on recalled success message Done button
  And I am on PO listing page
  And I search for the created po

  Then PO status should be draft


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


@COA @L1 @123coa
  Scenario: COA _ To verify that user is able to close a SPO

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Close PO action against the PO
  And I enter close PO comments
  And I click on Close PO button on the confirmation Popup
  And I click on closed po success message Done button
  And I am on PO listing page
  And I search for the created po

  Then I should be able to see the PO in closed status


@COA @L1 @124coa
  Scenario: COA _ To verify that user is able to close a Req_PO

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"

  When I am on PO listing page
  And I search for the converted PO
  And I click on option icon
  And I click on Close PO action against the PO
  And I enter close PO comments
  And I click on Close PO button on the confirmation Popup
  And I click on closed po success message Done button
  And I am on PO listing page
  And I search for the converted PO

  Then I should be able to see the PO in closed status


@COA @L1 @125coa
  Scenario: COA _ To verify that user is able to cancel a SPO 

  Given I am logged in eProc
  And I have created and released a PO

  When I view the PO
  And I click on Cancel PO action within Actions tab
  And I fill Cancel comments
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the PO in Cancelled status


@COA @L1 @126coa
  Scenario: COA _ To verify that user is able to cancel a Req_PO

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"

  When I am on PO listing page
  And I search for the converted PO
  And I view the PO
  And I click on Cancel PO action within Actions tab
  And I fill Cancel comments
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the converted PO in Cancelled status


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


@COA @L1 @139coa
  Scenario: COA _ To verify remind approver action for SPO

  Given I am logged in eProc 
  And I have submitted a SPO with a catalog item
  And the PO is in In Approval status

  When I click on Remind approver action against the PO

  Then I should be able to send reminder to the approver


@COA @L1 @140coa
  Scenario: COA _ To verify remind approver for req to PO

  Given I am logged in eProc 
  And I have created a req to PO with PO in In Approval status

  When I click on Remind approver action against the PO

  Then I should be able to send reminder to the approver


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


# @COA @L1      
# Scenario: COA _ To verify that user is able to create a SPO with single & multiple line items and with attachments in Zycus eproc

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create SPO button
#   And I select supplier details
#   And I add Purchase type 
#   And I add Required by date
#   And I search catalog item with "search_term"
#   And I add costing and accounting details for that item
#   And I add 1 free text item with details
#   And I add attachment at header level
#   And I submit the PO 

#   Then I should be able to view the SPO with multiple items and attachments


# @COA @L1
#   Scenario: COA _ To verify that user is able to create a Req_PO with single and multiple line items and with attachments in Zycus eproc

#   Given I am logged in eProc 
#   And I have submitted a requisition with two catalog items and header level attachments

#   When I convert the requisition to PO
#   And I navigate to PO listing
#   And I view the PO

#   Then I should be able to see all the added items and attachments


# @COA @L1
#   Scenario: COA _ To verify that user is able to cancel a BPO

#   Given I am logged in eProc
#   And I have created and released a BPO

#   When I view the BPO created 
#   And I click on Cancel PO action within Actions tab
#   And I click on Cancel PO button on the confirmation Popup

#   Then I should be able to see the BPO in Cancelled status

 
# @COA @L1
#   Scenario: COA _ To verify that user is able to create a blanket PO with attachments in Zycus P2P

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create Blanket PO button
#   And I select supplier details
#   And I add Required by date
#   And I search catalog item with "search_term" 
#   And I add costing and accounting details for that item
#   And I add 1 free text item with details
#   And I add 1 attachment at header level
#   And I Define Buying Scope
#   And I enter current date in Validity To date
#   And I enter current date in Validity From date
#   And I submit the PO 

#   Then I should be able to view the BPO with multiple items and attachments 


# @COA @L1
#   Scenario: COA _ To verify that user is able to choose a start date and an End Date

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create Blanket PO button
#   And I select supplier details
#   And I add Required by date
#   And I search catalog item with "search_term" 
#   And I add costing and accounting details for that item
#   And I Define Buying Scope
#   And I enter current date in Validity To date
#   And I enter 3 days ahead of current date in Validity From date
#   And I submit the BPO 

#   Then I should be able to view the BPO with Validity To and From dates selected

  
# @COA @L1
#   Scenario: COA _ To verify that user is able to choose a spend limit

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create Blanket PO button
#   And I select supplier details
#   And I add Required by date
#   And I search catalog item with "search_term" 
#   And I add costing and accounting details for that item
#   And I uncheck Auto update checkbox for Order Value field
#   And I add Order Value "10*item_price"
#   And I Define Buying Scope
#   And I enter current date in Validity To date
#   And I enter current date in Validity From date
#   And I submit the BPO 

#   Then I should be able to view the BPO with Order Value entered


# @COA @L1
#   Scenario: COA _ To verify that user is able to create PO releases against Blanket PO

#   Given I am logged in eProc
#   And I have created a Blanket PO with a catalog item

#   When I click on Create Release action against the BPO created
#   And I fill the accounting details against the item
#   And I submit the Release
#   And I view the release created

#   Then I should be able to view the details filled in Release (Supplier, item name, item price, GL Account)


# @COA @L1
#   Scenario: COA _ To verify that user is able to view all the released orders generated against a  BPO on a new tab called "Release Orders"

#   Given I am logged in eProc
#   And I have created a Blanket PO with a catalog item
#   And I have created a release against the BPO.

#   When I view the BPO
#   And I navigate to Release orders tab 

#   Then the Release created against the BPO should be listed there


# @COA @L1
#   Scenario: COA _ To verify that user is able to tag a free text item to a particular Blanket PO

#   Given I am logged in eProc
#   And I am on PO listing page 


#   When I click on Create Blanket PO button
#   And I select supplier details
#   And I add Required by date
#   And I add 1 free text item with details
#   And I add 1 attachment at header level
#   And I Define Buying Scope
#   And I enter current date in Validity To date
#   And I enter current date in Validity From date
#   And I submit the PO 

#   Then I should be able to view the BPO with free text item added ot it


# @COA @L1
#   Scenario: COA _ Taxes and Freight and other charges to get apportioned to the line items when setting is set to Yes

#   Given I am logged into CMD
#   And I am on Master data_Customize

#   When I set the setting for Freight Apportionment to Yes
#   And I set the setting for Tax Apportionment to Yes
#   And I navigate to eproc
#   And I navigate to PO listing page
#   And I navigate to PO create page
#   And I search a catalog item with "search_term"
#   And I add it to line item
#   And I add Taxes at header level
#   And I add Freight at header level
#   And I go to cost booking at line level 
#   And I check the total cost booking amount assigned

#   Then I should get apportioned amount assigned for total cost booking amount


# @COA @L1
#   Scenario: COA _ Taxes and Freight and other charges to get apportioned to the line items when setting is set to NO

#   Given I am logged into CMD
#   And I am on Master data_Customize

#   When I set the setting for Freight Apportionment to NO
#   And I set the setting for Tax Apportionment to NO
#   And I navigate to eproc
#   And I navigate to PO listing page
#   And I navigate to PO create page
#   And I search a catalog item with "search_term"
#   And I add it to line item
#   And I add Taxes at header level
#   And I add Freight at header level
#   And I go to cost booking at line level 
#   And I check the total costing amount assigned

#   Then I should not get apportioned amount assigned for total cost booking amount


# @COA @L1
#   Scenario: COA _ To verify the create invoice action within SPO

#   Given I am logged in eProc 
#   And I have submitted a SPO with a catalog item
#   And I approved the PO to release it.

#   When I navigate to PO listing
#   And I Create an Invoice for all items in the PO created
#   And I navigate to eInvoice approval listing
#   And I approve the einvoice
#   And I navigate to eproc PO listing
#   And I check the status of the PO on PO listing

#   Then I should see the status of the PO to Fully invoiced

 
# @COA @L1
#   Scenario: COA _ To verify the cancel action on invoice within SPO

#   Given I am logged in eProc 
#   And I have submitted a SPO with a catalog item
#   And approved the PO to release it.

#   When I navigate to PO listing
#   And I create an Invoice for all items in the PO created 
#   And I navigate to eInvoice approval listing
#   And I approve it
#   And I navigate to eproc PO listing
#   And I view that PO 
#   And I navigate to Invoice subtab
#   And I click on "Void Invoice" action against the invoice created
#   And I check the status of the invoice displayed

#   Then I should be able to see the status of invoice as Cancelled


# @COA @L1
#   Scenario: COA _ To verify the close action on invoice within SPO

#   Given I am logged in eProc 
#   And I have submitted a SPO with a catalog item
#   And approved the PO to release it.

#   When I navigate to PO listing
#   And I create an Invoice for all items in the PO created 
#   And I navigate to eInvoice approval listing
#   And I approve that invoice
#   And I navigate to eproc PO listing
#   And I view that PO 
#   And I navigate to Invoice subtab
#   And I click on "Close" action against the invoice created
#   And I check the status of the invoice displayed

#   Then I should be able to see the status of invoice as Closed


# @COA @L1
#   Scenario: COA _ To verify the create invoice action within Req_PO

#   Given I am logged in eProc 
#   And I have created a Req_PO with a catalog item
#   And approved that PO to release it.

#   When I navigate to My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And I Create an Invoice for all items in the PO created
#   And I navigate to eInvoice approval listing
#   And I approve the einvoice
#   And I navigate to eproc My Purchase Orders listing
#   And I check the status of that PO

#   Then I should be able to see the status of PO as Fully invoiced

 
# @COA @L1
#   Scenario: COA _ To verify the cancel action on invoice within Req_PO

#   Given I am logged in eProc 
#   And I have created a Req_PO with a catalog item
#   And approved that PO to release it.

#   When I navigate to My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And I Create an Invoice for all items in the PO created
#   And I navigate to eInvoice approval listing
#   And I approve the einvoice
#   And I navigate to eproc My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And I click on "Void Invoice" action against the invoice created
#   And I check the status of the invoice displayed

#   Then I should be able to see the status of invoice as Cancelled


# @COA @L1
#   Scenario: COA _ To verify the close action on invoice within Req_PO

#   Given I am logged in eProc 
#   And I have created a Req_PO with a catalog item
#   And approved that PO to release it.

#   When I navigate to My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And ICreate an Invoice for all items in the PO created
#   And I navigate to eInvoice approval listing
#   And I approve the einvoice
#   And I navigate to eproc My Purchase Orders listing
#   And I view that PO
#   And I navigate to Invoice subtab
#   And I click on "Close" action against the invoice created
#   And I check the status of the invoice displayed

#   Then I should be able to see the status of invoice as Closed


# @COA @L1
#   Scenario: To verify that if cost booking details are loading in COA form at header level for SPO

#   Given I am logged into eproc
#   And setting for 'Enable Flexible Chart Of Accounts (COA) split at header Level' is set to Yes
#   And I am on PO edit page with a catalog item 

#   When I add items at line level 
#   And I add Cost booking details at header level 
#   And I Save the COA form

#   Then I should be able to Save the header level COA form 


# @COA @L1
#   Scenario: To verify that user is able to submit a SPO with header level COA details

#   Given I am logged into eproc
#   And setting for "Enable Flexible Chart Of Accounts (COA) split at header Level" is set to Yes
#   And I am on PO edit page with a catalog item 

#   When I add items at line level
#   And I add Cost booking details at header level 
#   And I Save the COA form
#   And I add supplier details
#   And I add purchase type 
#   And I add Buyer name
#   And I add  taxes
#   And I Submit the PO

#   Then I should be able to see the status of PO as In approval on PO listing

# @COA @L1
#   Scenario: To verify that user is able to submit a Req_PO with header level COA details

#   Given I am logged into eproc
#   And setting for "Enable Flexible Chart Of Accounts (COA) split at header Level" is set to Yes
#   And I have submitted a requisition with COA form details filled.
#   And I have approved the requisition

#   When I navigate to Buyer desk listing
#   And I edit that requisition
#   And I convert it to PO
#   And I navigate to PO listing
#   And I check the status of that PO in PO listing


#   Then I should be able to see the status of PO as In approval on PO listing


# @COA @L1
#   Scenario: To verify that if cost booking details are loading in COA form at Line item level in PO

#   Given I am logged into eproc
#   And I am on PO edit page with a catalog item 

#   When I add items at line level
#   And I add Cost booking details at line level 
#   And I Save the COA form

#   Then I should be able to Save the line level COA form 


# @COA @L1
#   Scenario: To verify that user is able to submit PO  with line item level COA details

#   Given I am logged into eproc
#   And I am on PO edit page with a catalog item 

#   When I add items at line level
#   And I add Cost booking details at line level 
#   And I Save the COA form
#   And I add supplier details
#   And I add purchase type 
#   And I add Buyer name
#   And I add  taxes
#   And I Submit the PO

#   Then I should be able to see the status of PO as In approval on PO listing

  
# @tag7
#   Scenario: Create Standard PO

#   Given i am on purchase order listing Page