Feature: Activating and deactivating the workflow
    I will be able to activate and deactivate the workflow.

    Background:
        Given I logged in to the application
        And I navigate to workflow module
        
    @L1
    Scenario: Activate the workflow
        Given I search the workflow
        When I activate the workflow
        Then I should be able to see the workflow as activated

    @L1
    Scenario: Deactivate the workflow
        Given I search the workflow
        When I deactivate the workflow
        Then I should be able to see the workflow as deactivated
