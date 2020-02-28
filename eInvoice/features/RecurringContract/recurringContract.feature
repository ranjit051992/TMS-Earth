Feature: Recurring Contract 
    I should be able to verify Recurring Contract functionalities

    Background:
        Given I logged in to the application
        And I navigates to eInvoice product
        And I navigates to Recurring Contracts module

    Scenario: Verify the presence of Recurring Contracts module in the module list of eInvoice
        Given I can see the list of eInvoice modules
        Then I should be able to see the Recurring Contracts option in the list

    Scenario: Verify that I can customize the table columns of Recurring Contracts listing page
        Given I select the required field(s) to be shown on listing 
        When I applied the customized filter 
        Then I should able to see the customized list on the page

    Scenario: Verify I can able to view Recurring Contract if has access to activity 'Access Recurring Contracts'
        Given I have access to given activity in TMS
        Then I should see the list of recurring contracts in contracts listing 

    Scenario: Verify that I can create a Recurring Contract
        Given I navigated to creation page of manual contract 
        When I select the supplier, contract name, contract owner
        And I provided the contract details
        And I added release schedule
        And I added line items
        And I provided cost booking information
        And I submit the recurring contract
        Then I should see that recurring contract is created successfully
        
    Scenario: To approve the Recurring Contract
        Given I created a recurring contract 
        And I see that it is in approval state
        When I navigates to recurring contract approval listing 
        And I approve the recurring contract
        And I navigates to recurring contract module
        Then I should be able to see recurring contract in approved state

    Scenario: To reject the Recurring Contract
        Given I created a recurring contract 
        And I see that it is in approval state
        When I navigates to recurring contract approval listing 
        And I reject the recurring contract
        And I navigates back to recurring contract module
        Then I should be able to see recurring contract in rejected state

     Scenario: To deactivate the activated Recurring Contract
        Given I created a recurring contract 
        When I deactivated the contract from actions
        Then I should be able to see the contract in deactivated state in listing 

    Scenario: To activate the deactivated Recurring Contract
        Given I created a recurring contract
        And I deactivated it 
        When I click on "Activate" action againt the created recurring contract 
        And I click on Activate after adding comments
        Then I should be able to see the recurring contract in activated state

    Scenario: To verify that I should be able to resubmit a rejected Recurring Contract
        Given I created a recurring contract 
        When it is in approval state
        And I rejected it from recurring contract approval tab
        And I navigates to contract listing
        And I edited the rejected contract after updating info
        Then I should be able to see the recurring contract in listing with updated details

    Scenario: Verify that validation message is shown to user on submission for duplicate error message
        Given I created a recurring contract 
        When I create a new recurring contract with same name providing all details
        Then I should be thrown a validation message on submit for duplicate contract name

    Scenario: Verify that I can able to access Audit trail section present at the end in the contract view page
        Given I created a recurring contract
        When I view the same recurring contract 
        Then I should able to see the audit trail on bottom of the page