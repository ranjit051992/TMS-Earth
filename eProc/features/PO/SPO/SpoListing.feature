Feature: SpoListing

@Non-COA @L1 @90noncoa
  Scenario: To verify that user is able to recall a PO after it is submitted

  Given I am logged in eProc
  And I am on PO listing page

  When I click on Create PO button
  And I click on Create SPO button
  And I fetch PO number
  And I fill Order Description
  And I add Purchase type
  And I select supplier details
  And I select Buyer
  And I add Required by date
  And I search catalog item with "search_term"
  And I add costing and accounting details for that item
  And I submit the PO
  And I am on PO listing page
  And I search for the created po
  And I click on option icon
  And I click on Recall option
  And I enter recall comments
  And I click on Recall button
  And I click on recalled success message Done button
  And I am on PO listing page
  And I search for the created po

  Then PO status should be draft


@Non-COA @L1 @92noncoa
  Scenario: To verify that user is able to close a SPO

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Close PO action against the PO
  And I enter close PO comments
  And I click on Close PO button on the confirmation Popup
  And I click on closed po success message Done button
  And I am on PO listing page
  And I search for the created po

  Then I should be able to see the PO in closed status


@Non-COA @L1 @94noncoa
  Scenario: To verify that user is able to cancel a SPO 

  Given I am logged in eProc
  And I have created and released a PO

  When I view the PO
  And I click on Cancel PO action within Actions tab
  And I fill Cancel comments
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the PO in Cancelled status


@Non-COA @L1 @108noncoa
  Scenario: To verify remind approver action for SPO

  Given I am logged in eProc 
  And I have submitted a SPO with a catalog item
  And the PO is in In Approval status

  When I click on Remind approver action against the PO

  Then I should be able to send reminder to the approver


@Non-COA @L1 @93noncoa
  Scenario: To verify that user is able to close a Req_PO

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"

  When I am on PO listing page
  And I search for the converted PO
  And I click on option icon
  And I click on Close PO action against the PO
  And I enter close PO comments
  And I click on Close PO button on the confirmation Popup
  And I click on closed po success message Done button
  And I am on PO listing page
  And I search for the converted PO

  Then I should be able to see the PO in closed status


@Non-COA @L1 @95noncoa
  Scenario: To verify that user is able to cancel a Req_PO

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"

  When I am on PO listing page
  And I search for the converted PO
  And I view the PO
  And I click on Cancel PO action within Actions tab
  And I fill Cancel comments
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the converted PO in Cancelled status


@Non-COA @L1 @109noncoa
  Scenario: To verify remind approver for req to PO

  Given I am logged in eProc 
  And I have created a req to PO with PO in In Approval status

  When I click on Remind approver action against the PO

  Then I should be able to send reminder to the approver


# //**********************COA**********************//


@COA @L1 @121coa
  Scenario: COA _ To verify that user is able to recall a PO after it is submitted

  Given I am logged in eProc
  And I am on PO listing page

  When I click on Create PO button
  And I click on Create SPO button
  And I fetch PO number
  And I fill Order Description
  And I add Purchase type
  And I select supplier details
  And I select Buyer
  And I add Required by date
  And I search catalog item with "search_term"
  And I add costing and accounting details for that item
  And I submit the PO
  And I am on PO listing page
  And I search for the created po
  And I click on option icon
  And I click on Recall option
  And I enter recall comments
  And I click on Recall button
  And I click on recalled success message Done button
  And I am on PO listing page
  And I search for the created po

  Then PO status should be draft


@COA @L1 @123coa
  Scenario: COA _ To verify that user is able to close a SPO

  Given I am logged in eProc
  And I have created and released a PO

  When I click on option icon
  And I click on Close PO action against the PO
  And I enter close PO comments
  And I click on Close PO button on the confirmation Popup
  And I click on closed po success message Done button
  And I am on PO listing page
  And I search for the created po

  Then I should be able to see the PO in closed status


@COA @L1 @125coa
  Scenario: COA _ To verify that user is able to cancel a SPO 

  Given I am logged in eProc
  And I have created and released a PO

  When I view the PO
  And I click on Cancel PO action within Actions tab
  And I fill Cancel comments
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the PO in Cancelled status


@COA @L1 @139coa
  Scenario: COA _ To verify remind approver action for SPO

  Given I am logged in eProc 
  And I have submitted a SPO with a catalog item
  And the PO is in In Approval status

  When I click on Remind approver action against the PO

  Then I should be able to send reminder to the approver


@COA @L1 @124coa
  Scenario: COA _ To verify that user is able to close a Req_PO

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"

  When I am on PO listing page
  And I search for the converted PO
  And I click on option icon
  And I click on Close PO action against the PO
  And I enter close PO comments
  And I click on Close PO button on the confirmation Popup
  And I click on closed po success message Done button
  And I am on PO listing page
  And I search for the converted PO

  Then I should be able to see the PO in closed status


@COA @L1 @126coa
  Scenario: COA _ To verify that user is able to cancel a Req_PO

  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"

  When I am on PO listing page
  And I search for the converted PO
  And I view the PO
  And I click on Cancel PO action within Actions tab
  And I fill Cancel comments
  And I click on Cancel PO button on the confirmation Popup

  Then I should be able to see the converted PO in Cancelled status


@COA @L1 @140coa
  Scenario: COA _ To verify remind approver for req to PO

  Given I am logged in eProc 
  And I have created a req to PO with PO in In Approval status

  When I click on Remind approver action against the PO

  Then I should be able to send reminder to the approver