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

@Non-COA @L1 @buyermodify
  Scenario: To verify that buyer is not allowed to modify the requisition in case of Return for Amendment.
  Given I am logged in eProc

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I submit requisition
  And I get requisition number
  And I approve the requisition
  And I navigate to Buyer Desk
  And I edit and return the requisition on Buyers Desk
  And I allow requestor to resubmit the requisition
  And I search the requisition on Buyer Desk

  Then I should not be allowed to edit the requisition


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

@Non-COA @L1 @bpo
  Scenario: To verify the behavior of requisition with free text item and who has BPO attached to them
  Given I am logged in eProc
  And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item and approve it
  And I navigate to OnlineStore
  When I add 1 free text item
  And I add BPO to the free text item
  And I add free text item to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level 
  And I submit requisition
  And I get requisition number
  And I approve the requisition
  And I navigate to Buyer Desk
  And I edit the requisition on buyers desk listing
  And I select the item and Convert req to PO
  And I select po and submit po for processing on suggested po page
  And I search bpo and navigate to release order tab
  Then I should be able to see BPO Release Order page on convert to PO



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

@COA @L1
  Scenario: COA>>To verify that buyer is not allowed to modify the requisition in case of Return for Amendment.
  Given I am logged in eProc

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I submit requisition
  And I get requisition number
  And I approve the requisition
  And I navigate to Buyer Desk
  And I edit and return the requisition on Buyers Desk
  And I allow requestor to resubmit the requisition
  And I search the requisition on Buyer Desk

  Then I should not be allowed to edit the requisition



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

@COA @L1
  Scenario: COA>>To verify the behavior of requisition with free text item and who has BPO attached to them
    Given I am logged in eProc
    And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item and approve it
  And I navigate to OnlineStore
  When I add 1 free text item
  And I add BPO to the free text item
  And I add free text item to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level 
  And I submit requisition
  And I get requisition number
  And I approve the requisition
  And I navigate to Buyer Desk
  And I edit the requisition on buyers desk listing
  And I select the item and Convert req to PO
  And I select po and submit po for processing on suggested po page
  And I search bpo and navigate to release order tab
  Then I should be able to see BPO Release Order page on convert to PO


# @COA @L1 @setting
#     Scenario: To verify that if cost booking details are loading in COA form at header level for requisition.
#     Given I am logged into eproc
#     And setting for "Enable Flexible Chart Of Accounts (COA) split at header Level" is set to Yes
#     And I am on checkout page with a catalog item 

#     When I add items at line level
#     And I add Cost booking details at header level 
#     And I Save the COA form

#     Then I should be able to Save the header level COA form 

@COA @L1 @linelevelCOA @priyankaCOA
    Scenario: To verify that if cost booking details are loading in COA form at Line item level in requisition.
    Given I am logged in eProc
    And I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart 
    And I checkout

    When I add data in Cost Booking Details section at line level
  
    Then I should be able to Save the line level COA form 
