Feature: Checkout


@Non-COA @L1 
  Scenario: To verify that user is able to add Cost center information to the requisition.
  Given I am logged in eProc
  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I edit Cost Allocation section at header level
  And I update cost center "COST_CENTER"
  And I navigate to Line level Cost Booking Details
  Then I should be see the updated cost center on line level Cost Booking section

@Non-COA @L1  
    Scenario: To verify that user is able to add Project information to the requisition.
    Given I am logged in eProc
    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I edit Cost Allocation section at header level
    And I update project "PROJECT"
    And I navigate to Line level Cost Booking Details
    Then I should be see the updated project on line level Cost Booking section

@Non-COA @L1  
    Scenario: To verify that System auto populates user's Cost center when a user is creating a requisition.
    Given I am logged in eProc
    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    Then I should see on header level Cost Booking section cost center should be populated
    And I navigate to Line level Cost Booking Details
    And I should see on line level Cost Booking Details section cost center should be populated

@Non-COA @L1  
    Scenario: To verify that system auto populates user's default Delivery & Bill to address 
    Given I am logged in eProc
    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    Then I should see on header level, Shipping Details section Default Shipping Address field should be auto populated
    And I navigate to Line level Shipping Details and Asset Tagging section
    And I should see on line level, in Shipping Details and Asset Tagging section Address field should be auto populated

@Non-COA @L1  
    Scenario:  To verify that user is able to view approval Status
    Given I am logged in eProc
    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I save it
    And I submit requisition
    Then I should be able see the status of requisition on the Listing page

@Non-COA @L1  
  Scenario: To verify requisition in draft and actions on it
  Given I am logged in eProc
  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I save it
  And I save requisition in Draft state
  Then I should be able to view the actions for the draft requisition on Listing page
  And I should be able to Edit and submit the Draft requisition
  And I should be able to delete the requisition

@Non-COA @L1 
    Scenario: To verify that user is able to add attachments to the requisition.
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I add an attachment "ATTACHMENT_PATH"
    
    Then I should be able to see the attachment which is added

@Non-COA @L1   
    Scenario: To verify that user is able to create any custom / One time delivery address while Check out and save it for future use
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I select Ship to Another Address in  Shipping Details section at header level
    And I Create New address
    And I check the Save checkbox
    And I create the address
    And I add data in Cost Booking Details section at line level
    And I save it 
    And I submit requisition

    Then I should be able to see new Deliver address as the Ship to Another Address on view requisition 
    And I navigate to OnlineStore
    And I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I select Ship to Another Address in  Shipping Details section at header level
    And I should be able to see the saved address on creating a new requisition

@Non-COA @L1   
  Scenario: To verify that the 'Select Purchase Order' field
  Given I am logged in eProc

  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I link Purchase Order "blue sanity" in the Select Purchase Order field

  Then I should be see that the field name is updated to Select Purchase Order

@Non-COA @L1   
  Scenario: To verify that user is able to create requisition with assigned buyer as buyer group
  Given I am logged in eProc

  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I select "BUYER_GROUP" at line level in Buyer section
  And I save it
  And I submit requisition

  Then I should be able to view requisition with buyer as the buyer group which was assigned

@Non-COA @L1  
  Scenario: To verify that user is able to create requisition with assigned buyer as buyer
  Given I am logged in eProc

  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I select buyer "BUYER_NAME" at line level in Buyer section
  And I save it
  And I submit requisition

  Then I should be able to view requisition with buyer which was assigned
  
# @Non-COA @L1
#   Scenario: To verify that user is be able to raise a request using Punchout
#   Given I am logged in eProc
#   And I navigate to Punchout with name

#   When I add punchout item to cart 
#   And I checkout
#   And I submit requisition with data filled in all mandatory fields

#   Then I should see the added punchout item with all the details on requisition view page



# @Non-COA @L1
#   Scenario: To verify user is able to create a requisition for a free-text item or service
#   Given I am logged in eProc

#   When I Create Request
#   And I Add guided item/service
#   And I Sourcing status
#   And I add qty and price
#   And I add items to cart
#   And I checkout
#   And I add data in Purchase Type and Required By field
#   And I add GL account at line level
#   And I submit requisition

#   Then I should be able to view requisition created with free text item


# @Non-COA @L1
#   Scenario: To verify that user is able to tag a free-text item to a contract 
#   Given I am logged in eProc

#   When I Navigate to Guided Page
#   And I add short description
#   And I add qty and price
#   And I add Sourcing status
#   And I save it
#   And I select supplier from the Suggested Supplier dropdown.
#   And I add contract for the item
#   And I add item to cart
#   And I checkout

#   Then I should contract linked to free text item on viewing the item



@Non-COA @L1 @copy
    Scenario: To verify that user is able to copy any requisition and modify it to create a new requisition.
    Given I am logged in eProc

    When I create requisition with "1" "ITEM_NAME_FOR_SEARCHING" item
    And I copy that requisition
    And I modify the field quantity
    And I add Tax Details at line level
    And I submit requisition

    Then I should be able to see submitted requisition with updated details

# @Non-COA @L1
#     Scenario: To verify that user is able to create free text line item and items from Hosted Catalog in a single PR.
#     Given I am logged in eProc

#     When I add a free text item to cart
#     And I add 2 catalog items to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to view the requisition with free text item and the catalog items.

# @tag23
#     Scenario: To verify that user is able to see the approval hierarchy after raising a requisition
#     Given I am logged in eProc

#     When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
#     And I checkout
#     And I enter Requisition Name
#     And I add Purchase Type
#     And I add Settlement Via
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to view the workflow Approval hierarchy

# @Non-COA @L1
#     Scenario: To verify that user should be able to buy items on behalf of other individuals. 
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add a On Behalf of user
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to view the workflow with On Behalf user as the requestor and On behalf user workflow should be applied

# @Non-COA @L1
#     Scenario: To verify that user is able to create requisition for multiple items with multiple cost center for each item
#     Given I am logged in eProc

#     When I add 2 catalog items to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add Costing split at header level by Percentage into 2 splits (50, 50)
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to view the requisition with multiple items
#     And I should see split cost center added to each item at header level 
#     And I should be able to see split cost center added to each item at line level




# @Non-COA @L1
#     Scenario: To verify that PR is directly flipped into PO after regular approval is complete.
#     Given I am logged in eProc

#     When I enable the 'Automatically generate orders' for PO setting
#     And I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition
#     And I approve the requisition

#     Then I should see that PR is directly flipped to PO.

# @Non-COA @L1
#     Scenario: To verify a setting called ‘Required by date should be auto calculated as per lead time defined in the catalog’ is present under Customize setting for Requisition
#     Given I am logged in eProc

#     When I navigate to Setup > Customize > Requisition

#     Then I should be able to see Required by date should be auto calculated as per lead time defined in the catalog setting in this page


# @Non-COA @L1
#     Scenario: To verify that user is able to change the default Delivery & Bill to address in the requisition.
#     Given I am logged in eProc

#     When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I select Ship to Another Address in  Shipping Details section at header level
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to see Deliver address as the Ship to Another Address on view requisition 


# @Non-COA @L1
#     Scenario: To verify that user is able to add taxes at line item level in a requisition for catalog item
#     Given I am logged in eProc

#     When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I add Tax Details at line level
#     And I save it
#     And I submit requisition

#     Then I should be able see the taxes added on view requisition

# @Non-COA @L1
#   Scenario: To verify that user is able to add taxes at line item level in a requisition for punchout item
#   Given I am logged in eProc
#   And I navigate to Punchout page

#   When I add a punchout item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level 
#   And I add Tax Details at line level
#   And I save it
#   And I submit requisition

#   Then I should be able see the taxes added on view requisition

# @Non-COA @L1
#   Scenario: To verify that user is able to add taxes at line item level in a requisition for free-text item 
#   Given I am logged in eProc

#   When I add a free text item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level 
#   And I add Tax Details at line level
#   And I save it
#   And I submit requisition

#   Then I should be able see the taxes added on view requisition

# @Non-COA @L1
#   Scenario: To verify that user is able to add taxes at line item level in a requisition for catalog,punchout & free-text item
#   Given I am logged in eProc
#   And I navigate to punchout site

#   When I add a punchout item to cart
#   And I add a free text item to cart
#   And I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level for all items
#   And I add Tax Details at line level
#   And I save it
#   And I submit requisition

#   Then I should be able see the taxes added on view requisition

# @Non-COA @L1
#   Scenario: To verify that buyer is allowed to modify the requisition before sending it for approval in case of Buyer Review
#   Given I am logged in eProc

#   When I navigate to Setup> Customize> Workflow
#   And I enable 'Allow buyer to modify requisition before approval:' setting
#   And I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition
#   And I navigate to Buyers Desk
#   And I edit requisition on Buyers Desk

#   Then I should be allowed to make changes to the requisition (edit the qty)
#   And I should be able to send the requisition for approval

# @Non-COA @L1
#   Scenario: To verify that buyer is not allowed to modify the requisition in case of Return for Amendment.
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition
#   And I approve the requisition
#   And I navigate to Buyers Desk
#   And I return the requisition on Buyers Desk
#   And I allow requestor to resubmit the requisition
#   And I view the requisition on Buyer Desk

#   Then I should not be allowed to edit the requisition


# @Non-COA @L1
#   Scenario: To verify that user is able to raise a request with stock items
#   Given I am logged in eProc

#   When I add a stock item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition

#   Then I should be able to view requisition with stock item

# @Non-COA @L1
#   Scenario: To verify that user is able to raise a request with non stock items
#   Given I am logged in eProc

#   When I add a non stock item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition

#   Then I should be able to view requisition with non stock item


# @Non-COA @L1
#   Scenario: To verify that user is able to create requisition with conditions of delivery address
#   Given I am logged in eProc

#   When I add a catalog item with qty 2 to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add Delivery split at line level into 2 splits
#   And I change the address for one split
#   And I add data in Cost Booking Details section at line level 
#   And I submit requisition

#   Then I should be able to view the requisition with the delivery split
#   And I should see that the address is updated

# @Non-COA @L1
#   Scenario: To verify that user is able to add approver in requisition workflow if activity if assigned to him/her
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level 
#   And I check Mark for adding approvers checkbox in workflow section
#   And I click on Next button
#   And I should be add adhoc approver on Ready for Approval page
#   And I submit requisition

#   Then I should be able to view the requisition with adhoc approver added in the workflow

# @Non-COA @L1
#   Scenario: To verify that user is  able to close requisition
#   Given I am logged in eProc

#   When I navigate to Requisition Listing page
#   And I filter for any Released requisition
#   And I close the requisition from actions

#   Then I should be able to see the status of the requisition changed to Closed.

# @Non-COA @L1
#   Scenario: To verify the behavior of requisition who has PO attached to them
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I Select Purchase Order
#   And I add data in Cost Booking Details section at line level 
#   And I submit requisition
#   And I approve requisition
#   And I navigate to Buyers Desk
#   And I edit the requisition on Buyers Desk
#   And I select the item and Convert req to PO

#   Then I should be able to see PO Amendment page of the PO which is added

# @Non-COA @L1
#   Scenario: To verify the behavior of requisition with free text item and who has BPO attached to them
#   Given I am logged in eProc

#   When I add a free text item
#   And I add BPO to the free text item
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level 
#   And I submit requisition
#   And I approve requisition
#   And I navigate to Buyers Desk
#   And I edit the requisition on Buyers Desk
#   And I select the item and Convert req to PO

#   Then I should be able to see BPO Release Order page on convert to PO.



# @COA @L1
#   Scenario: COA>>To verify that user is be able to raise a request using Punchout
#   Given I am logged in eProc
#   And I navigate to Punchout with name

#   When I add punchout item to cart 
#   And I checkout
#   And I submit requisition with data filled in all mandatory fields

#   Then I should see the added punchout item with all the details on requisition view page



# @COA @L1
#   Scenario: COA>>To verify user is able to create a requisition for a free-text item or service
#   Given I am logged in eProc

#   When I Create Request
#   And I Add guided item/service
#   And I Sourcing status
#   And I add qty and price
#   And I add items to cart
#   And I checkout
#   And I add data in Purchase Type and Required By field
#   And I add GL account at line level
#   And I submit requisition

#   Then I should be able to view requisition created with free text item


# @COA @L1
#   Scenario: COA>>To verify that user is able to tag a free-text item to a contract 
#   Given I am logged in eProc

#   When I Navigate to Guided Page
#   And I add short description
#   And I add qty and price
#   And I add Sourcing status
#   And I save it
#   And I select supplier from the Suggested Supplier dropdown.
#   And I add contract for the item
#   And I add item to cart
#   And I checkout

#   Then I should contract linked to free text item on viewing the item


# @COA @L1
#   Scenario: COA>>To verify that user is able to add Cost center information to the requisition.
#   Given I am logged in eProc

#   When I add an item to cart 
#   And I checkout
#   And I edit Cost Allocation section at header level
#   And I update cost center
#   And I Save it

#   Then I should be able to see updated cost center in Cost Allocation section 

# @COA @L1
#     Scenario: COA>>To verify that user is able to add Project information to the requisition.
#     Given I am logged in eProc

#     When I add an item to cart 
#     And I checkout
#     And I edit Cost Allocation section at header level
#     And I update project
#     And I Save it

#     Then I should be able to see updated project in Cost Allocation section 

# @COA @L1
#     Scenario: COA>>To verify that user is able to add attachments to the requisition.
#     Given I am logged in eProc

#     When I add an item to cart 
#     And I checkout
#     And I add an attachment

#     Then I should be able to see the attachment which is added

# @COA @L1
#     Scenario: COA>>To verify that user is able to copy any requisition and modify it to create a new requisition.
#     Given I am logged in eProc

#     When I create a requisition with catalog items
#     And I copy that requisition
#     And I modify the fields(qty, add taxes) requisition
#     And I submit it

#     Then I should be able to see submitted requisition with updated details

# @COA @L1
#     Scenario: COA>>To verify that user is able to create free text line item and items from Hosted Catalog in a single PR.
#     Given I am logged in eProc

#     When I add a free text item to cart
#     And I add 2 catalog items to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to view the requisition with free text item and the catalog items.

# @COA @L1
#     Scenario: COA>>To verify that user is able to see the approval hierarchy after raising a requisition
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to view the workflow Approval hierarchy

# @COA @L1
#     Scenario: COA>>To verify that user should be able to buy items on behalf of other individuals. 
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add a On Behalf user
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to view the workflow with On Behalf user as the requestor and On behalf user workflow should be applied

# @COA @L1
#     Scenario: COA>>To verify that user is able to create requisition for multiple items with multiple cost center for each item
#     Given I am logged in eProc

#     When I add 2 catalog items to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add Costing split at header level by Percentage into 2 splits (50, 50)
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to view the requisition with multiple items
#     And I should see split cost center added to each item at header level 
#     And I should be able to see split cost center added to each item at line level




# @COA @L1
#     Scenario: COA>>To verify that PR is directly flipped into PO after regular approval is complete.
#     Given I am logged in eProc

#     When I enable the 'Automatically generate orders' for PO setting
#     And I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition
#     And I approve the requisition

#     Then I should see that PR is directly flipped to PO.

# @COA @L1
#     Scenario: COA>>To verify a setting called ‘Required by date should be auto calculated as per lead time defined in the catalog’ is present under Customize setting for Requisition
#     Given I am logged in eProc

#     When I navigate to Setup > Customize > Requisition

#     Then I should be able to see Required by date should be auto calculated as per lead time defined in the catalog setting in this page

# @COA @L1
#     Scenario: COA>>To verify that System auto populates user's Cost center when a user is creating a requisition or PO.
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout

#     Then I should see on header level Cost Booking section cost center should be populated
#     And I should see on line level Cost Booking Details section cost center should be populated

# @COA @L1
#     Scenario: COA>>To verify that system auto populates user's default Delivery & Bill to address 
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout

#     Then I should see on header level in the Shipping Details section Default Shipping Address field should be auto populated
#     And I should see on line level in the Shipping Details and Asset Tagging section Address field should be auto populated

# @COA @L1
#     Scenario: COA>>To verify that user is able to change the default Delivery & Bill to address in the requisition.
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I select Ship to Another Address in  Shipping Details section at header level
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to see Deliver address as the Ship to Another Address on view requisition 

# @COA @L1
#     Scenario: COA>> To verify that user is able to view approval Status
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able see the status of requisition on the Listing page

# @COA @L1
#     Scenario: COA>>To verify that user is able to create any custom / One time delivery address while Check out and save it for future use
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I select Ship to Another Address in  Shipping Details section at header level
#     And I Create New address
#     And I check the Save checkbox
#     And I create the address
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition

#     Then I should be able to see new Deliver address as the Ship to Another Address on view requisition 
#     And I should be able to see the saved address on creating a new requisition

# @COA @L1
#     Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for catalog item
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I add Tax Details at line level
#     And I save it
#     And I submit requisition

#     Then I should be able see the taxes added on view requisition

# @COA @L1
#   Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for punchout item
#   Given I am logged in eProc
#   And I navigate to Punchout page

#   When I add a punchout item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level 
#   And I add Tax Details at line level
#   And I save it
#   And I submit requisition

#   Then I should be able see the taxes added on view requisition

# @COA @L1
#   Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for free-text item 
#   Given I am logged in eProc

#   When I add a free text item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level 
#   And I add Tax Details at line level
#   And I save it
#   And I submit requisition

#   Then I should be able see the taxes added on view requisition

# @COA @L1
#   Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for catalog,punchout & free-text item
#   Given I am logged in eProc
#   And I navigate to punchout site

#   When I add a punchout item to cart
#   And I add a free text item to cart
#   And I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level for all items
#   And I add Tax Details at line level
#   And I save it
#   And I submit requisition

#   Then I should be able see the taxes added on view requisition

# @COA @L1
#   Scenario: COA>>To verify that buyer is allowed to modify the requisition before sending it for approval in case of Buyer Review
#   Given I am logged in eProc

#   When I navigate to Setup> Customize> Workflow
#   And I enable 'Allow buyer to modify requisition before approval:' setting
#   And I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition
#   And I navigate to Buyers Desk
#   And I edit requisition on Buyers Desk

#   Then I should be allowed to make changes to the requisition (edit the qty)
#   And I should be able to send the requisition for approval

# @COA @L1
#   Scenario: COA>>To verify that buyer is not allowed to modify the requisition in case of Return for Amendment.
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition
#   And I approve the requisition
#   And I navigate to Buyers Desk
#   And I return the requisition on Buyers Desk
#   And I allow requestor to resubmit the requisition
#   And I view the requisition on Buyer Desk

#   Then I should not be allowed to edit the requisition

# @COA @L1
#   Scenario: COA>>To verify that the 'Select Purchase Order' field
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I link Purchase Order in the Select Purchase Order field

#   Then I should be see that the field name is updated to Select Purchase Order.

# @COA @L1
#   Scenario: COA>>To verify that user is able to raise a request with stock items
#   Given I am logged in eProc

#   When I add a stock item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition

#   Then I should be able to view requisition with stock item

# @COA @L1
#   Scenario: COA>>To verify that user is able to raise a request with non stock items
#   Given I am logged in eProc

#   When I add a non stock item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition

#   Then I should be able to view requisition with non stock item

# @COA @L1
#   Scenario: COA>>To verify requisition in draft and actions on it
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I save requisition in Draft state

#   Then I should be able to view the actions for the draft requisition on Listing page
#   And I should be able to Edit the requisition
#   And I should be able to delete the requisition

# @COA @L1
#   Scenario: COA>>To verify that user is able to create requisition with assigned buyer as buyer group or single buyer
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I select Buyer Group at line level in Buyer section
#   And I add data in Cost Booking Details section at line level
#   And I save it
#   And I submit requisition

#   Then I should be able to view requisition with buyer as the buyer group which was assigned

# @COA @L1
#   Scenario: COA>>To verify that user is able to create requisition with conditions of delivery address
#   Given I am logged in eProc

#   When I add a catalog item with qty 2 to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add Delivery split at line level into 2 splits
#   And I change the address for one split
#   And I add data in Cost Booking Details section at line level 
#   And I submit requisition

#   Then I should be able to view the requisition with the delivery split
#   And I should see that the address is updated

# @COA @L1
#   Scenario: COA>>To verify that user is able to add approver in requisition workflow if activity if assigned to him/her
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level 
#   And I check Mark for adding approvers checkbox in workflow section
#   And I click on Next button
#   And I should be add adhoc approver on Ready for Approval page
#   And I submit requisition

#   Then I should be able to view the requisition with adhoc approver added in the workflow

# @COA @L1
#   Scenario: COA>>To verify that user is  able to close requisition
#   Given I am logged in eProc

#   When I navigate to Requisition Listing page
#   And I filter for any Released requisition
#   And I close the requisition from actions

#   Then I should be able to see the status of the requisition changed to Closed.

# @COA @L1
#   Scenario: COA>>To verify the behavior of requisition who has PO attached to them
#   Given I am logged in eProc

#   When I add a catalog item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I Select Purchase Order
#   And I add data in Cost Booking Details section at line level 
#   And I submit requisition
#   And I approve requisition
#   And I navigate to Buyers Desk
#   And I edit the requisition on Buyers Desk
#   And I select the item and Convert req to PO

#   Then I should be able to see PO Amendment page of the PO which is added

# @COA @L1
#   Scenario: COA>>To verify the behavior of requisition with free text item and who has BPO attached to them
#   Given I am logged in eProc

#   When I add a free text item
#   And I add BPO to the free text item
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level 
#   And I submit requisition
#   And I approve requisition
#   And I navigate to Buyers Desk
#   And I edit the requisition on Buyers Desk
#   And I select the item and Convert req to PO

#   Then I should be able to see BPO Release Order page on convert to PO.




# @COA @L1
#     Scenario: To verify that if cost booking details are loading in COA form at header level for requisition.
#     Given I am logged into eproc
#     And setting for "Enable Flexible Chart Of Accounts (COA) split at header Level" is set to Yes
#     And I am on checkout page with a catalog item 

#     When I add items at line level
#     And I add Cost booking details at header level 
#     And I Save the COA form

#     Then I should be able to Save the header level COA form 

# @COA @L1
#     Scenario: To verify that if cost booking details are loading in COA form at Line item level in requisition.
#     Given I am logged into eproc
#     And I am on checkout page with a catalog item 

#     When I add items at line level
#     And I add Cost booking details at line level 
#     And I Save the COA form

#     Then I should be able to Save the line level COA form 
