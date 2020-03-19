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

#    Then I should be able to view released order against the BPO