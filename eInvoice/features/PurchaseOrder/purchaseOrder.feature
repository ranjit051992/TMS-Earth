Feature:Purchase Order

    Background:
        Given I logged in to the application
    
    Scenario: To verify that the user is able to create an Invoice from PO tab
        Given I create po in eproc
        And I navigate to PurchaseOrder module
        When I create invoice against po
        Then I should be able to create and see the created invoice on invoice listing
    
    Scenario: To verify that the user is able to create an credit memo from PO tab
        Given I create po in eproc
        And I navigate to Invoice module
        And I create invoice against po
        And I navigate to PurchaseOrder module
        When I create credit memo from po
        Then I should be able to create and see the created credit memo on credit memo listing