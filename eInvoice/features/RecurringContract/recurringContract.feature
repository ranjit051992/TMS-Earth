Feature: Recurring Contract 
    I should be able to verify Recurring Contract functionalities

    Background:
        Given I logged in to the application
        And I navigates to Recurring Contracts module

    @L1
    Scenario: Verify the presence of Recurring Contracts module in the module list of eInvoice
        Given I can see the list of eInvoice modules
        Then I should be able to see the Recurring Contracts option in the list
    
    @L1
    Scenario: Customize the table columns of Recurring Contracts listing 
        Given I select the required field to be shown on listing
        When I applied the customized filter 
        Then I should able to see the customized list on the page
    
    
    Scenario: To view Recurring Contract if has access to activity 'Access Recurring Contracts'
        Given I have access to given activity in TMS
        Then I should see the list of recurring contracts in contracts listing 

    @L1
    Scenario: Verify that I can create a Recurring Contract
        Given I navigated to creation page of manual contract 
        When I select the supplier, contract name, contract owner
        And I added supplier details
        And I added contract details
        And I added release schedule
        And I added line items
        And I provided cost booking information
        And I submit the recurring contract
        Then I should see that recurring contract is created successfully

    @L1
    Scenario: To approve the Recurring Contract
        Given I created a recurring contract 
        And I see that it is in approval state
        When I navigates to recurring contract approval listing 
        And I approve the recurring contract
        And I navigates to recurring contract module
        Then I should be able to see recurring contract in approved state
    
    @L1
    Scenario: To reject the Recurring Contract
        Given I created a recurring contract 
        And I see that it is in approval state
        When I navigates to recurring contract approval listing 
        And I reject the recurring contract
        And I navigates to recurring contract module
        Then I should be able to see recurring contract in rejected state

    @L1
    Scenario: To deactivate the activated Recurring Contract
        Given I have a activated recurring contract 
        When I deactivate the contract from actions
        Then I should be able to see the contract in deactivated state in listing 

    @L1
    Scenario: To activate the deactivated Recurring Contract
        Given I have a deactivated recurring contract
        When I activate the recurring contract 
        Then I should be able to see the recurring contract in activated state
    
    @L1
    Scenario: To verify that I should be able to resubmit a rejected Recurring Contract
        Given I have a rejected recurring contract
        When I edit the rejected contract after updating info
        Then I should be able to see that rejected recurring contract is edited successfully
    
    @L1
    Scenario: Verify that validation message is shown to user on submission for duplicate error message
        Given I have a recurring contract
        When I create a new recurring contract with same name providing all details
        Then I should be thrown a validation message on submit for duplicate contract name
    
    @L1
    Scenario: Verify that I can able to access Audit trail section present at the end in the contract view page
        Given I have a recurring contract in listing 
        When I view the same recurring contract
        Then I should able to see the audit trail on bottom of the page