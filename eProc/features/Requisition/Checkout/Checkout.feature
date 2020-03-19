Feature: Checkout


@Non-COA @L1 @priyanka @costCenter
  Scenario: To verify that user is able to add Cost center information to the requisition.
  Given I am logged in eProc
  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I edit Cost Allocation section at header level
  And I update cost center "COST_CENTER[1]"
  And I navigate to Line level Cost Booking Details
  Then I should be see the updated cost center on line level Cost Booking section

@Non-COA @L1  @project @priyanka
    Scenario: To verify that user is able to add Project information to the requisition.
    Given I am logged in eProc
    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I edit Cost Allocation section at header level
    And I update project "PROJECT"
    And I navigate to Line level Cost Booking Details
    Then I should be see the updated project on line level Cost Booking section

@Non-COA @L1  @priyanka
    Scenario: To verify that System auto populates user's Cost center when a user is creating a requisition.
    Given I am logged in eProc
    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    Then I should see on header level Cost Booking section cost center should be populated
    And I navigate to Line level Cost Booking Details
    And I should see on line level Cost Booking Details section cost center should be populated

@Non-COA @L1  @priyanka @default
    Scenario: To verify that system auto populates user's default Delivery & Bill to address 
    Given I am logged in eProc
    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout

    Then I should see on header level, Shipping Details section Default Shipping Address field should be auto populated
    And I navigate to Line level Shipping Details and Asset Tagging section
    And I should see on line level, in Shipping Details and Asset Tagging section Address field should be auto populated

@Non-COA @L1  @approval @priyanka
    Scenario:  To verify that user is able to view approval Status
    Given I am logged in eProc
    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I submit requisition
    Then I should be able see the status of requisition on the Listing page

@Non-COA @L1 @draft @priyanka
  Scenario: To verify requisition in draft and actions on it
  Given I am logged in eProc
 
  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I save requisition in Draft state
  Then I should be able to view the actions for the draft requisition on Listing page
  And I should be able to Edit and submit the Draft requisition
  And I should be able to delete the requisition

@Non-COA @L1 @attach @Snehal

    Scenario: To verify that user is able to add attachments to the requisition.
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add an attachment "ATTACHMENT_PATH"
    And I add Required By Date
    And I add data in Cost Booking Details section at line level
    And I submit requisition

    Then I should be able to see the attachment which is added

@Non-COA @L1 @Snehal @onetime

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
    #And I save it 
    And I submit requisition

    Then I should be able to see new Deliver address as the Ship to Another Address on view requisition 
    And I navigate to OnlineStore
    And I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I select Ship to Another Address in  Shipping Details section at header level
    And I should be able to see the saved address on creating a new requisition



@Non-COA @L1  @buyer @Snehal

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

@Non-COA @L1 @Snehal

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
  

@Non-COA @L1 @adhocn @Snehal
  Scenario: To verify that user is able to add approver in requisition workflow if activity is assigned to him/her
  Given I am logged in eProc

  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level 
  # And I save it
  And I check Mark for adding approvers checkbox in workflow section
  And I click on Next button
  And I should be add adhoc approver "WORKFLOW_APPROVER" after "REQUIRE_APPROVAL_AFTER_REQUESTER" on Ready for Approval page
  And I submit requisition

  Then I should be able to view the requisition with adhoc approver added in the workflow

@Non-COA @L1 @SEARCH_ITEM_STOCK @Snehal
  Scenario: To verify that user is able to raise a request with stock items
  Given I am logged in eProc

  When I add "1" "SEARCH_ITEM_STOCK" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  # And I save it
  And I submit requisition

  Then I should be able to view requisition with stock item

# @Non-COA @L1
#   Scenario: To verify that user is be able to raise a request using Punchout
#   Given I am logged in eProc
#   And I navigate to Punchout with name

#   When I add punchout item to cart 
#   And I checkout
#   And I submit requisition with data filled in all mandatory fields

#   Then I should see the added punchout item with all the details on requisition view page



@Non-COA @L1 @free @Snehal
  Scenario: To verify user is able to create a requisition for a free-text item or service
  Given I am logged in eProc

  When I Navigate to Guided Page
  And I Add guided item service
  And I select category
  And I add Sourcing status
  And I add qty and price
  And I save guided item details
  And I select supplier from the Suggested Supplier dropdown
  And I add items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I submit requisition

  Then I should be able to view requisition created with free text item


@Non-COA @L1 @contract @priyanka
  Scenario: To verify that user is able to tag a free-text item to a contract 
  Given I am logged in eProc

  When I Navigate to Guided Page
  And I Add guided item service
  And I select category
  And I add short description
  And I add qty and price
  And I add Sourcing status
  And I save guided item details
  And I select supplier from the Suggested Supplier dropdown
  And I add contract for the item
  And I add items to cart
  And I checkout

  Then I should see contract linked to free text item on viewing the item



@Non-COA @L1 @copy @priyanka
    Scenario: To verify that user is able to copy any requisition and modify it to create a new requisition.
    Given I am logged in eProc

    When I create requisition with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I copy that requisition
    And I fetch Requisition Name
    And I modify the field quantity
    And I add Tax Details at line level
    And I save it
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

@Non-COA @L1 @hierarchy @Snehal
    Scenario: To verify that user is able to see the approval hierarchy after raising a requisition
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able to view the workflow Approval hierarchy

@Non-COA @L1 @behalf @Snehal
    Scenario: To verify that user should be able to buy items on behalf of other individuals. 
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add a On Behalf of user
    And I add Purchase Type    
    And I add Settlement Via
    And I add deliver to user
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able to view the workflow with On Behalf user as the requestor and On behalf user workflow should be applied

@Non-COA @L1 @multipleCostCenter @priyanka
    Scenario: To verify that user is able to create requisition for multiple items with multiple cost center for each item
    Given I am logged in eProc

    When I add "2" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add Costing split at header level by Percentage into 2 splits
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able to view the requisition with multiple items
    And I should see split cost center added to each item at header level 
    And I should be able to see split cost center added to each item at line level



# @Non-COA @L1 @autoPO @Setting @priyanka
#     Scenario: To verify that PR is directly flipped into PO after regular approval is complete.
#     Given I am logged in eProc

#     # When I enable the 'Automatically generate orders' for PO setting
#     When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
#     And I checkout
#     And I enter Requisition Name
#     And I add Purchase Type
#     And I add Settlement Via
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition
#     And I approve the requisition

#     Then I should see that PR is directly flipped to PO

# @Non-COA @L1 @setting
#     Scenario: To verify a setting called ‘Required by date should be auto calculated as per lead time defined in the catalog’ is present under Customize setting for Requisition
#     Given I am logged in eProc

#     When I navigate to Setup > Customize > Requisition

#     Then I should be able to see Required by date should be auto calculated as per lead time defined in the catalog setting in this page



@Non-COA @L1 @addr @Snehal
    Scenario: To verify that user is able to change the default Delivery & Bill to address in the requisition.
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I select Ship to Another Address in  Shipping Details section at header level
    And I select any existing address as shipping address
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able to see Deliver address as the Ship to Another Address on view requisition 


@Non-COA @L1 @taxes @priyanka
    Scenario: To verify that user is able to add taxes at line item level in a requisition for catalog item
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I add Tax Details at line level
    And I save it
    And I submit requisition

    Then I should be able see the taxes added on view requisition

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

@Non-COA @L1 @freeTextItem @priyanka
  Scenario: To verify that user is able to add taxes at line item level in a requisition for free-text item 
  Given I am logged in eProc

  When I add 1 free text item "SEARCH_GUIDED_ITEM" to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level 
  And I add Tax Details at line level
  And I save it
  And I submit requisition

  Then I should be able see the taxes added on view requisition

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
#   Scenario: To verify that user is able to raise a request with non stock items
#   Given I am logged in eProc

#   When I add a non stock item to cart
#   And I checkout
#   And I add Purchase Type
#   And I add Required By Date
#   And I add data in Cost Booking Details section at line level
#   And I submit requisition

#   Then I should be able to view requisition with non stock item



@Non-COA @L1 @priyanka @deliverySplit
  Scenario: To verify that user is able to create requisition with conditions of delivery address
  Given I am logged in eProc

  When I add a catalog item "ITEM_NAME_FOR_SEARCHING" with quantity 2 to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add Delivery split at line level into 2 splits
  And I change the address for split 2
  And I save it
  And I add data in Cost Booking Details section at line level 
  And I submit requisition

  Then I should be able to view the requisition with the delivery split
  And I should see that the address is updated for split 2



@Non-COA @L1 @closeReq @priyanka
  Scenario: To verify that user is  able to close requisition
  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I close PO

  When I navigate to Requisition Listing page
  And I close the requisition from actions

  Then I should be able to see the status of the requisition changed to Closed

# @Non-COA @L1 @Snehal
#   Scenario: To verify the behavior of requisition who has PO attached to them
#   Given I am logged in eProc
#   And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
#   When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
#   And I checkout
#   And I enter Requisition Name
#   And I add Purchase Type
#   And I add Required By Date
#   And I Select Purchase Order
#   And I add data in Cost Booking Details section at line level 
#   And I submit requisition
#   And I approve requisition
#   And I navigate to Buyer Desk
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



@COA @L1 @coaFree @Snehal
  Scenario: COA>>To verify user is able to create a requisition for a free-text item or service
  Given I am logged in eProc

  When I Navigate to Guided Page
  And I Add guided item service
  And I select category
  And I add Sourcing status
  And I add qty and price
  And I save guided item details
  And I select supplier from the Suggested Supplier dropdown
  And I add items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I submit requisition

  Then I should be able to view requisition created with free text item


@COA @L1 @contractCOA @priyankaCOA
  Scenario: COA>>To verify that user is able to tag a free-text item to a contract 
  Given I am logged in eProc

  When I Navigate to Guided Page
  And I Add guided item service
  And I select category
  And I add short description
  And I add qty and price
  And I add Sourcing status
  And I save guided item details
  And I select supplier from the Suggested Supplier dropdown
  And I add contract for the item
  And I add items to cart
  And I checkout

  Then I should see contract linked to free text item on viewing the item



@COA @L1 @Snehal
 Scenario: COA>>To verify that user is able to add attachments to the requisition.
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add an attachment "ATTACHMENT_PATH"
    And I add Required By Date
    And I add data in Cost Booking Details section at line level
    And I submit requisition

    Then I should be able to see the attachment which is added

@COA @L1 @coaCopy @priyankaCOA
    Scenario: COA>>To verify that user is able to copy any requisition and modify it to create a new requisition.
    Given I am logged in eProc

    When I create requisition with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I copy that requisition
    And I modify the field quantity
    And I add Tax Details at line level
    And I save it
    And I submit requisition

    Then I should be able to see submitted requisition with updated details

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

# @COA @L1 @hierarchyCoa
#     Scenario: COA>>To verify that user is able to see the approval hierarchy after raising a requisition
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

@COA @L1 @Snehal @behalfCoa
    Scenario: COA>>To verify that user should be able to buy items on behalf of other individuals. 
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add a On Behalf of user
    And I add Purchase Type    
    And I add Settlement Via
    And I add deliver to user
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able to view the workflow with On Behalf user as the requestor and On behalf user workflow should be applied



# @COA @L1 @coaAutoPo
#     Scenario: COA>>To verify that PR is directly flipped into PO after regular approval is complete.
#     Given I am logged in eProc

#     # When I enable the 'Automatically generate orders' for PO setting
#     When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
#     And I checkout
#     And I enter Requisition Name
#     And I add Purchase Type
#     And I add Settlement Via
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level 
#     And I submit requisition
#     And I approve the requisition

#     Then I should see that PR is directly flipped to PO

# @COA @L1 @setting
#     Scenario: COA>>To verify a setting called ‘Required by date should be auto calculated as per lead time defined in the catalog’ is present under Customize setting for Requisition
#     Given I am logged in eProc

#     When I navigate to Setup > Customize > Requisition

#     Then I should be able to see Required by date should be auto calculated as per lead time defined in the catalog setting in this page


@COA @L1 @coaAddr  @priyankaCOA
    Scenario: COA>>To verify that system auto populates user's default Delivery & Bill to address 
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout

    Then I should see on header level, Shipping Details section Default Shipping Address field should be auto populated
    And I navigate to Line level Shipping Details and Asset Tagging section
    And I should see on line level, in Shipping Details and Asset Tagging section Address field should be auto populated


@COA @L1 @Snehal
    Scenario: COA>>To verify that user is able to change the default Delivery & Bill to address in the requisition.
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I select Ship to Another Address in  Shipping Details section at header level
    And I select any existing address as shipping address
    And I add data in Cost Booking Details section at line level 
    #And I save it
    And I submit requisition

    Then I should be able to see Deliver address as the Ship to Another Address on view requisition 

@COA @L1 @coaApproval  @priyankaCOA
    Scenario: COA>> To verify that user is able to view approval Status
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able see the status of requisition on the Listing page

@COA @L1 @Snehal @custom
    Scenario: COA>>To verify that user is able to create any custom / One time delivery address while Check out and save it for future use
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
    # And I save it 
    And I submit requisition

    Then I should be able to see new Deliver address as the Ship to Another Address on view requisition 
    And I navigate to OnlineStore
    And I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I select Ship to Another Address in  Shipping Details section at header level
    And I should be able to see the saved address on creating a new requisition

@COA @L1 @coaTaxes @priyankaCOA
    Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for catalog item
    Given I am logged in eProc

    When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I add Tax Details at line level
    And I save it
    And I submit requisition

    Then I should be able see the taxes added on view requisition

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

@COA @L1 @coafreeTextItem @priyankaCOA
  Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for free-text item 
  Given I am logged in eProc

  When I add 1 free text item "SEARCH_GUIDED_ITEM" to cart
  And I checkout
  And I add Purchase Type
  And I add Required By Date
  And I add data in Cost Booking Details section at line level 
  And I add Tax Details at line level
  And I save it
  And I submit requisition

  Then I should be able see the taxes added on view requisition

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

# @COA @L1 @setting
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



@COA @L1 @Snehal @stockItem
  Scenario: COA>>To verify that user is able to raise a request with stock items
  Given I am logged in eProc

  When I add "1" "SEARCH_ITEM_STOCK" items to cart
  And I checkout
  And I add Purchase Type
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I submit requisition

  Then I should be able to view requisition with stock item

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

@COA @L1 @coaDraft @priyankaCOA
  Scenario: COA>>To verify requisition in draft and actions on it
    Given I am logged in eProc
  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I save requisition in Draft state
  Then I should be able to view the actions for the draft requisition on Listing page
  And I should be able to Edit and submit the Draft requisition
  And I should be able to delete the requisition

@COA @L1  @Snehal 

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

@COA @L1  @Snehal @buyerCoa

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

@COA @L1 @priyankaCOA @coaDeliverySplit
  Scenario: COA>>To verify that user is able to create requisition with conditions of delivery address
  Given I am logged in eProc

  When I add a catalog item "ITEM_NAME_FOR_SEARCHING" with quantity 2 to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add Delivery split at line level into 2 splits
  And I change the address for split 2
  And I save it
  And I add data in Cost Booking Details section at line level 
  And I submit requisition

  Then I should be able to view the requisition with the delivery split
  And I should see that the address is updated for split 2

@COA @L1 @Snehal
  Scenario: COA>>To verify that user is able to add approver in requisition workflow if activity if assigned to him/her
  Given I am logged in eProc

  When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level 
  # And I save it
  And I check Mark for adding approvers checkbox in workflow section
  And I click on Next button
  And I should be add adhoc approver "WORKFLOW_APPROVER" after "REQUIRE_APPROVAL_AFTER_REQUESTER" on Ready for Approval page
  And I submit requisition

  Then I should be able to view the requisition with adhoc approver added in the workflow

@COA @L1 @closeReqCOA @priyankaCOA
  Scenario: COA>>To verify that user is  able to close requisition
  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I close PO

  When I navigate to Requisition Listing page
  And I close the requisition from actions

  Then I should be able to see the status of the requisition changed to Closed

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




# @COA @L1 @setting
#     Scenario: To verify that if cost booking details are loading in COA form at header level for requisition.
#     Given I am logged into eproc
#     And setting for "Enable Flexible Chart Of Accounts (COA) split at header Level" is set to Yes
#     And I am on checkout page with a catalog item 

#     When I add items at line level
#     And I add Cost booking details at header level 
#     And I Save the COA form

#     Then I should be able to Save the header level COA form 

@COA @L1 @linelevelCOA
    Scenario: To verify that if cost booking details are loading in COA form at Line item level in requisition.
    Given I am logged in eProc
    And I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart 
    And I checkout

    When I add data in Cost Booking Details section at line level
  
    Then I should be able to Save the line level COA form 
