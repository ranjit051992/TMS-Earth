Feature: Spo

# @Non-COA @L1
#   Scenario: To verify that user is able to cancel a BPO

#   Given I am logged in eProc
#   And I have created and released a BPO

#   When I view the BPO created 
#   And I click on Cancel PO action within Actions tab
#   And I click on Cancel PO button on the confirmation Popup

#   Then I should be able to see the BPO in Cancelled status

 
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


# @COA @L1
#   Scenario: COA _ To verify that user is able to cancel a BPO

#   Given I am logged in eProc
#   And I have created and released a BPO

#   When I view the BPO created 
#   And I click on Cancel PO action within Actions tab
#   And I click on Cancel PO button on the confirmation Popup

#   Then I should be able to see the BPO in Cancelled status

 
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