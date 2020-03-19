Feature: CreatePR

@Non-COA @L1 @copy @priyankaNCoa
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

@Non-COA @L1 @multipleCostCenter @priyankaNCoa
    Scenario: To verify that user is able to create requisition for multiple items with multiple cost center for each item
    Given I am logged in eProc

    When I add 2 "ITEM_NAME_FOR_SEARCHING" items to cart
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

@Non-COA @L1 @taxes @priyankaNCoa
    Scenario: To verify that user is able to add taxes at line item level in a requisition for catalog item
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

@Non-COA @L1 @freeTextItem @priyankaNCoa
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

@Non-COA @L1 @multiItemTaxes @priyankaNCoa
  Scenario: To verify that user is able to add taxes at line item level in a requisition for catalog,punchout & free-text item
  Given I am logged in eProc
  # And I navigate to punchout site

  # When I add a punchout item to cart
  
  When I add taxes to requition for 1 "ITEM_NAME_FOR_SEARCHING" and 1 free text item
 
  Then I should be able see the taxes added for multiple items on view requisition


@Non-COA @L1 @priyankaNCoa @deliverySplit
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

@COA @L1 @coaTaxes @priyankaCOA
    Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for catalog item
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

@COA @L1 @coaMultiItemTaxes @priyankaCOA
  Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for catalog,punchout & free-text item
  Given I am logged in eProc
  # And I navigate to punchout site

  # When I add a punchout item to cart
  # And I add a free text item to cart
  # And I add a catalog item to cart
  And I add taxes to requition for 1 "ITEM_NAME_FOR_SEARCHING" and 1 free text item
 
  Then I should be able see the taxes added for multiple items on view requisition

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


@Non-COA @L1 @attach @Snehal

    Scenario: To verify that user is able to add attachments to the requisition.
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add an attachment "ATTACHMENT_PATH"
    And I add Required By Date
    And I add data in Cost Booking Details section at line level
    And I submit requisition

    Then I should be able to see the attachment which is added

@Non-COA @L1  @buyer @Snehal

  Scenario: To verify that user is able to create requisition with assigned buyer as buyer group
  Given I am logged in eProc

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

  When I add 1 "SEARCH_ITEM_STOCK" items to cart
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


@Non-COA @L1 @hierarchy @Snehal
    Scenario: To verify that user is able to see the approval hierarchy after raising a requisition
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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


@Non-COA @L1 @addr @Snehal
    Scenario: To verify that user is able to change the default Delivery & Bill to address in the requisition.
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

@Non-COA @L1 @nonstock
  Scenario: To verify that user is able to raise a request with non stock items
  Given I am logged in eProc

  When I add 1 "SEARCH_ITEM_NONSTOCK" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Settlement Via
  And I add Purchase Type
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I submit requisition

  Then I should be able to view requisition with non stock item


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

@COA @L1 @Snehal
 Scenario: COA>>To verify that user is able to add attachments to the requisition.
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add an attachment "ATTACHMENT_PATH"
    And I add Required By Date
    And I add data in Cost Booking Details section at line level
    And I submit requisition

    Then I should be able to see the attachment which is added



@COA @L1 @multipleItems
    Scenario: COA>>To verify that user is able to create free text line item and items from Hosted Catalog in a single PR.
    Given I am logged in eProc

    When I create requisition with 2 "ITEM_NAME_FOR_SEARCHING" and 1 free text item
    And I view Requisition

    Then I should be able to view the requisition with free text item and the catalog items

@COA @L1 @hierarchyCoa
    Scenario: COA>>To verify that user is able to see the approval hierarchy after raising a requisition
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able to view the workflow Approval hierarchy

@COA @L1 @Snehal @behalfCoa
    Scenario: COA>>To verify that user should be able to buy items on behalf of other individuals. 
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

@COA @L1 @Snehal
    Scenario: COA>>To verify that user is able to change the default Delivery & Bill to address in the requisition.
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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


@COA @L1 @Snehal @stockItem
  Scenario: COA>>To verify that user is able to raise a request with stock items
  Given I am logged in eProc

  When I add 1 "SEARCH_ITEM_STOCK" items to cart
  And I checkout
  And I add Purchase Type
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I submit requisition

  Then I should be able to view requisition with stock item

@COA @L1
  Scenario: COA>>To verify that user is able to raise a request with non stock items
  Given I am logged in eProc

  When I add 1 "SEARCH_ITEM_NONSTOCK" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Settlement Via
  And I add Purchase Type
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I submit requisition

  Then I should be able to view requisition with non stock item



@COA @L1  @Snehal 

  Scenario: To verify that user is able to create requisition with assigned buyer as buyer group
  Given I am logged in eProc

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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


@COA @L1 @Snehal
  Scenario: COA>>To verify that user is able to add approver in requisition workflow if activity if assigned to him/her
  Given I am logged in eProc

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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