Feature: CreateBPO

@Non-COA @L1 @Pooja @BPO
   Scenario: To verify that user is able to create a blanket PO with attachments in Zycus P2P

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I add attachment "ATTACHMENT_PATH"
   And I submit the BPO

   Then I should be able to view the BPO with the attachments


 @Non-COA @L1 @Pooja
    Scenario: To verify that user is able to choose a start date and an End Date

    Given I am logged in eProc
    And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I submit the BPO

    Then I should be able to view the BPO with Validity To and From dates selected


 @Non-COA @L1 @Pooja
    Scenario: To verify that user is able to choose a spend limit

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I update the spend limit
   And I submit the BPO

    Then I should be able to view the BPO with Order Value entered


#  @Non-COA @L1 @Pooja
#    Scenario: To verify that user is able to tag a free text item to a particular Blanket PO

#    Given I am logged in eProc
#    And I am on PO listing page 


#    When I click on Create Blanket PO button
#    And I create a BPO with 1 "SEARCH_GUIDED_ITEM" item

#    Then I should be able to view the BPO with free text item added at index 1

 
@COA @L1 
   Scenario: COA _ To verify that user is able to create a blanket PO with attachments in Zycus P2P

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I add attachment "ATTACHMENT_PATH"
   And I submit the BPO

   Then I should be able to view the BPO with the attachments 


@COA @L1 
   Scenario: COA _ To verify that user is able to choose a start date and an End Date

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I submit the BPO

   Then I should be able to view the BPO with Validity To and From dates selected

  
@COA @L1 
   Scenario: COA _ To verify that user is able to choose a spend limit

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I update the spend limit
   And I submit the BPO

   Then I should be able to view the BPO with Order Value entered

#  @COA @L1
#    Scenario: COA _ To verify that user is able to tag a free text item to a particular Blanket PO

#    Given I am logged in eProc
#    And I am on PO listing page 


#    When I click on Create Blanket PO button
#    And I create a BPO with 1 "SEARCH_GUIDED_ITEM" item

#    Then I should be able to view the BPO with free text item added at index 1