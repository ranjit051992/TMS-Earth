Feature: view and create reports
    I will be able to view or create Reports

    Background:
        Given I logged in to the application
        And I navigate to Reports

    Scenario: viewing pre canned reports in Reports section
        Given I navigate to the pre canned reports
        When I modify the credit memo line level report 
        Then I should be able to see the modified entry in the reports

    Scenario: modifing existing reports in Reports section
        Given I navigate to the existing report
        When I modify the existing report 
        Then I should be able to see the modified entry in the reports
I