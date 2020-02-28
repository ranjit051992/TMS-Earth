Feature: Functionality of process form
    I will be able to see process form functionality

    Background:
        Given I logged in to the application
        And   I navigate to eforms module

    Scenario: create new process form by online editor
        Given I navigate to the new eForms online editor
        When  I fill the online editor form
        And   I submit the form
        Then  I should be able to see the created eForms

    Scenario: create new process form by file upload
        Given I navigate to the file upload
        When  I upload the eForm file
        Then  I should be able to see the created eForms

    Scenario: update the process form
        Given I see the process eForm listing
        When  I edit the eForm
        Then  I should be able to see the updated values

    Scenario: delete the process form
        Given I see the process eForm listing
        When  I delete the eForm
        Then  I should not be able to see the deleted eForm

    Scenario: create & activate an eform for recurring by online editor
        Given I navigate to the new eForms online editor
        When  I fill the online editor form
        And   I publish the eform
        Then  I should see the activated eform

    Scenario: create & activate an eform for recurring by file upload
        Given I navigate to the new eForms file upload
        When  I import the eform file
        Then  I should able to see the created eform

    Scenario: recurring contract creation with created eform
        Given I navigate to recurring contract creation page
        And   I create the recurring contract
        When  I view the created recurring contract
        Then  I should be able to view the eform field

    Scenario: filtering the created eform
        Given I navigate to the eform listing page
        When  I filter the eForm
        Then  I should able to see the filterd eForms