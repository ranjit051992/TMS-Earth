Feature: Receipt

@L1
    Scenario: To verify that buyer is able to save as draft or create a receipt /return note for the items received

    Given I am logged in eproc 
    And I have submitted a SPO with a catalog item
    And I have approved the PO to release it.

    When I navigate to PO listing
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I Saved the receipt as draft

    Then I should be able to see the status of reciept created as Draft

    
@L1
    Scenario: To verify that requester is able to save a receipt as draft for the items received

    Given I am logged in eproc 
    And I have submitted a Req-PO with a catalog item
    And I have approved the PO to release it.

    When I navigate to My Purchase Orders listing
    And I view the PO
    And I navigate to Receipt subtab
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I Saved the receipt as draft

    Then I should be able to see the status of reciept created as Draft


@L1
    Scenario: To verify that buyer is able to create a receipt for the partial items received

    Given I am logged in eproc 
    And I have submitted a SPO with  catalog item with 2 qty
    And I have approved the PO to release it.

    When I navigate to PO listing
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty less than ordered qty
    And I  again click on create receipt action 
    And I create another receipt
    And I submit it.
    And I check the status of the latest Receipt created on Receipt listing page

    Then I should be able to see the status of receipt as confirmed


@L1
    Scenario: To verify that requester is able to create a receipt for the partial items received

    Given I am logged in eproc 
    And I have created a Req-PO with  catalog item with 2 qty
    And I have approved the PO to release it

    When I navigate to My Purchase Orders listing
    And I view the PO
    And I navigate to receipt subtab
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty less than ordered qty
    And I submit the receipt
    And I again click on create receipt action 
    And I create another receipt
    And I submit it.
    And I check the status of the latest Receipt created on Receipt listing page

    Then I should be able to see the status of receipt as confirmed


@L1
    Scenario: To verify that requester is able to cancel a receipt created

    Given I am logged in eproc 
    And I have submitted a Req-PO with a catalog item
    And I have approved the PO to release it.

    When I navigate to PO listing
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I submitted the receipt
    And I checked the status of receipt created
    And I navigate to My Purchase Orders listing
    And I view the PO created
    And I navigate to Receipt subtab
    And I cancelled the receipt created
    And I checked the status of that receipt again

    Then I should be able to see the status of reciept as cancelled


@L1
    Scenario: To verify that buyer is able to save as draft a return note for a PO

    Given I am logged in eproc 
    And I have submitted a SPO with a catalog item
    And I have approved the PO to release it.

    When I navigate to PO listing
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I submitted the receipt
    And I clicked on Create return note action on the receipt listing page
    And I entered quantity same as ordered quantity
    And I entered reason for return
    And I entered return method
    And I saved the return note as draft

    Then I should be able to see the return note in draft status on the receipt listing page


@L1
    Scenario: To verify that requester is able to save as draft a return note for a PO

    Given I am logged in eproc 
    And I have submitted a Req-PO with a catalog item
    And I have approved the PO to release it.

    When I navigate to My purchase orders listing
    And I view the PO created
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I submitted the receipt
    And I clicked on Create return note action on the receipt listing page
    And I entered quantity same as ordered quantity
    And I entered reason for return
    And I entered return method
    And I saved the return note as draft

    Then I should be able to see the return note in draft status on the receipt listing page


@L1
    Scenario: To verify that buyer is able to create a return note for a PO

    Given I am logged in eproc 
    And I have submitted a SPO with a catalog item
    And I have approved the PO to release it.

    When I navigate to PO listing
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I submitted the receipt
    And I clicked on Create return note action on the receipt listing page
    And I entered quantity same as ordered quantity
    And I entered reason for return
    And I entered return method
    And I submitted the return note

    Then I should be able to see the return note created on the receipt listing page


@L1
    Scenario: To verify that requester is able to create a return note for a PO

    Given I am logged in eproc 
    And I have submitted a Req-PO with a catalog item
    And I have approved the PO to release it.

    When I navigate to My Purchase Orders listing
    And I view the PO
    And I navigate to receipt subtab
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I submitted the receipt
    And I clicked on Create return note action on the receipt listing page
    And I entered quantity same as ordered quantity
    And I entered reason for return
    And I entered return method
    And I submitted the return note

    Then I should be able to see the return note created on the receipt listing page


@L1
    Scenario: To verify that buyer is able to delete the receipt which is in draft state

    Given I am logged in eproc 
    And I have submitted a SPO with a catalog item
    And I have approved the PO to release it.

    When I navigate to PO listing
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I saved the receipt in draft status
    And I delete the receipt in draft status, from receipt listing page

    Then I should be able to delete the receipt in draft status


@L1
    Scenario: To verify that requester is able to delete the receipt which is in draft state

    Given I am logged in eproc 
    And I have submitted a Req-PO with a catalog item
    And I have approved the PO to release it.

    When I navigate to My Purchase Orders listing
    And I view the PO created
    And I navigate to receipt subtab
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I saved the receipt in draft status
    And I delete the receipt in draft status, from receipt listing page

    Then I should be able to delete the receipt in draft status


@L1
    Scenario: To verify that buyer is able to delete the return note which is in draft state

    Given I am logged in eproc 
    And I have submitted a SPO with a catalog item
    And I have approved the PO to release it.

    When I navigate to PO listing
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I submitted the receipt
    And I clicked on Create return note action on the receipt listing page
    And I entered quantity same as ordered quantity
    And I entered reason for return
    And I entered return method
    And I saved return note as draft
    And I deleted the return note in draft status

    Then I should be able to delete the return note in draft state


@L1
    Scenario: To verify that requester is able to delete the return note which is in draft state

    Given I am logged in eproc 
    And I have submitted a Req-PO with a catalog item
    And I have approved the PO to release it.

    When I navigate to My Purchase Orders listing
    And I view the PO created
    And I navigate to receipt subtab
    And I click on Create receipt action against the PO created 
    And I select the items at item level on receipt creation page
    And I enter received qty same as ordered qty
    And I submitted the receipt
    And I clicked on Create return note action on the receipt listing page
    And I entered quantity same as ordered quantity
    And I entered reason for return
    And I entered return method
    And I saved return note as draft
    And I deleted the return note in draft status

    Then I should be able to delete the return note in draft state