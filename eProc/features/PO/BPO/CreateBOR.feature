Feature: CreateBOR

 @Non-COA @L1 @Pooja
   Scenario: To verify that user is able to create PO releases against Blanket PO

   Given I am logged in eProc
   And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item and approve it

   When I create Release of the BPO

   Then I should be able to view the proper details in Release Order


 @Non-COA @L1 @Pooja
   Scenario: To verify that user is able to view all the released orders generated against a  BPO on a new tab called "Release Orders"

   Given I am logged in eProc
   And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item and approve it

   When I create Release of the BPO

   Then I should be able to view released order against the BPO


 @COA @L1
   Scenario: COA _ To verify that user is able to create PO releases against Blanket PO

   Given I am logged in eProc
   And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item and approve it

   When I create Release of the BPO

   Then I should be able to view the proper details in Release Order

#  @COA @L1 @BPO
#    Scenario: COA _ To verify that user is able to view all the released orders generated against a  BPO on a new tab called "Release Orders"
   
#    Given I am logged in eProc
#    And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item and approve it

#    When I create Release of the BPO

#    Then the Release created against the BPO should be listed there


@COA @L1 @Snehal
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


  @Non-COA @L1 @bpo @Snehal
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
#    Then I should be able to view released order against the BPO
