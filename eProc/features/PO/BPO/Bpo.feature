Feature: Bpo

@Non-COA @L1 @BPO
  Scenario: To verify that user is able to cancel a BPO

  Given I am logged in eproc
  And I am on PO listing page
  And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item

  # When I view the BPO created 
  
  When I click on Cancel PO action within Actions tab
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the BPO in Cancelled status


# @Non-COA @L1
#   Scenario: To verify that user is able to create a blanket PO with attachments in Zycus P2P

#   Given I am logged in eproc
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

#   Given I am logged in eproc
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

#   Given I am logged in eproc
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

#   Given I am logged in eproc
#   And I have created a Blanket PO with a catalog item

#   When I click on Create Release action against the BPO created
#   And I fill the accounting details against the item
#   And I submit the Release
#   And I view the release created

#   Then I should be able to view the details filled in Release (Supplier, item name, item price, GL Account)


# @Non-COA @L1
#   Scenario: To verify that user is able to view all the released orders generated against a  BPO on a new tab called "Release Orders"

#   Given I am logged in eproc
#   And I have created a Blanket PO with a catalog item
#   And I have created a release against the BPO.

#   When I view the BPO
#   And I navigate to Release orders tab 

#   Then the Release created against the BPO should be listed there


# @Non-COA @L1
#   Scenario: To verify that user is able to tag a free text item to a particular Blanket PO

#   Given I am logged in eproc
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

#   Then I should be able to view the BPO with free text item added to it


# @COA @L1
#   Scenario: COA _ To verify that user is able to cancel a BPO

#   Given I am logged in eproc
#   And I have created and released a BPO

#   When I view the BPO created 
#   And I click on Cancel PO action within Actions tab
#   And I click on Cancel PO button on the confirmation Popup

#   Then I should be able to see the BPO in Cancelled status

 
# @COA @L1
#   Scenario: COA _ To verify that user is able to create a blanket PO with attachments in Zycus P2P

#   Given I am logged in eproc
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

#   Given I am logged in eproc
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

#   Given I am logged in eproc
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

#   Given I am logged in eproc
#   And I have created a Blanket PO with a catalog item

#   When I click on Create Release action against the BPO created
#   And I fill the accounting details against the item
#   And I submit the Release
#   And I view the release created

#   Then I should be able to view the details filled in Release (Supplier, item name, item price, GL Account)


# @COA @L1
#   Scenario: COA _ To verify that user is able to view all the released orders generated against a  BPO on a new tab called "Release Orders"

#   Given I am logged in eproc
#   And I have created a Blanket PO with a catalog item
#   And I have created a release against the BPO.

#   When I view the BPO
#   And I navigate to Release orders tab 

#   Then the Release created against the BPO should be listed there


# @COA @L1
#   Scenario: COA _ To verify that user is able to tag a free text item to a particular Blanket PO

#   Given I am logged in eproc
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