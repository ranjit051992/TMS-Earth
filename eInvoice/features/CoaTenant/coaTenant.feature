Feature: COA Tenant settings and features
    I will be able to see the settimgs for COA tenant and the functionlity of the same

    Background:
        Given I logged in to the application for COA tenant
        And I navigate to TMS

    @L1
    Scenario: setting for header level coa split is present in CMD
        Given I navigate to the cost booking settings in master data
        Then I verify setting is present for header level coa split
    @L1
    Scenario: checking option for "book cost at line level"
        Given I navigate to the cost booking settings in master data
        When I verify setting is enabled for header level COA split
        And I navigate to the eform listing
        Then I see the setting book cost at line level disabled
    @L1
    Scenario: header level sum up to the document total
        Given I navigate to the nonpo invoice creation
        And I fill the splits at header level
        Then I find splits added at header level sum up to the document total
    @L1
    Scenario: adding COA details using only account as split type
        Given I navigate to the nonpo invoice creation
        And I add COA details using only account as split type
        Then I submit the invoice
    @L1
    Scenario: view the cost booking and accounting split information in the Cost Booking and Accounting Section
        Given I navigate to the nonpo invoice creation
        And I add COA details using only account as split type
        And I submit the invoice
        Then I should be able to view the cost booking and accounting split information in the invoice