Feature: Checkout


@Non-COA @L1 @priyankaNCoa @costCenter
  Scenario: To verify that user is able to add Cost center information to the requisition.
  Given I am logged in eProc
  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I edit Cost Allocation section at header level
  And I update cost center "COST_CENTER[1]"
  And I navigate to Line level Cost Booking Details
  Then I should be see the updated cost center on line level Cost Booking section

@Non-COA @L1  @project @priyankaNCoa
    Scenario: To verify that user is able to add Project information to the requisition.
    Given I am logged in eProc
    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I edit Cost Allocation section at header level
    And I update project "PROJECT"
    And I navigate to Line level Cost Booking Details
    Then I should be see the updated project on line level Cost Booking section

@Non-COA @L1  @priyankaNCoa
    Scenario: To verify that System auto populates user's Cost center when a user is creating a requisition.
    Given I am logged in eProc
    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    Then I should see on header level Cost Booking section cost center should be populated
    And I navigate to Line level Cost Booking Details
    And I should see on line level Cost Booking Details section cost center should be populated

@Non-COA @L1  @priyankaNCoa @default
    Scenario: To verify that system auto populates user's default Delivery & Bill to address 
    Given I am logged in eProc
    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout

    Then I should see on header level, Shipping Details section Default Shipping Address field should be auto populated
    And I navigate to Line level Shipping Details and Asset Tagging section
    And I should see on line level, in Shipping Details and Asset Tagging section Address field should be auto populated



@Non-COA @L1 @Snehal @onetime

    Scenario: To verify that user is able to create any custom / One time delivery address while Check out and save it for future use
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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
    And I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I select Ship to Another Address in  Shipping Details section at header level
    And I should be able to see the saved address on creating a new requisition



@Non-COA @L1 @contract @priyankaNCoa
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


# @Non-COA @L1 @autoPO @Setting @priyankaNCoa
#     Scenario: To verify that PR is directly flipped into PO after regular approval is complete.
#     Given I am logged in eProc

#     # When I enable the 'Automatically generate orders' for PO setting
#     When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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



# @Non-COA @L1 @setting
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


# @COA @L1
#   Scenario: COA>>To verify that user is be able to raise a request using Punchout
#   Given I am logged in eProc
#   And I navigate to Punchout with name

#   When I add punchout item to cart 
#   And I checkout
#   And I submit requisition with data filled in all mandatory fields

#   Then I should see the added punchout item with all the details on requisition view page


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





# @COA @L1 @coaAutoPo
#     Scenario: COA>>To verify that PR is directly flipped into PO after regular approval is complete.
#     Given I am logged in eProc

#     # When I enable the 'Automatically generate orders' for PO setting
#     When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout

    Then I should see on header level, Shipping Details section Default Shipping Address field should be auto populated
    And I navigate to Line level Shipping Details and Asset Tagging section
    And I should see on line level, in Shipping Details and Asset Tagging section Address field should be auto populated



@COA @L1 @Snehal @custom
    Scenario: COA>>To verify that user is able to create any custom / One time delivery address while Check out and save it for future use
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
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
    And I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I select Ship to Another Address in  Shipping Details section at header level
    And I should be able to see the saved address on creating a new requisition



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
    And I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart 
    And I checkout

    When I add data in Cost Booking Details section at line level
  
    Then I should be able to Save the line level COA form 
