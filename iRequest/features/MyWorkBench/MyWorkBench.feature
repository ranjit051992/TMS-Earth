    Scenario: Action items on My Workbench listing page

    Background:
        Given logged in on iRequest Page
        When I am on My Workbench Listing

    Scenario: To verify the RequestManager can able to see action items

        Given  I see the three dots in action tab
        Then I should be able to see available actions

    Scenario: To verify the RequestManager can able to return the request

        Given  I see the request in WithRM status
        When  I return a request
        Then I should be able to see the return successful  message

    Scenario: To verify the RequestManager can able to complete the request

        Given  I see request in WithRM status
        When I mark a request as complete
        Then I should be able to see the MarkAsComplete successful  message

    Scenario: To verify the RequestManager can able to review the request

        Given  I find request in WithRM status
        When  I review the request
        Then I should be able to see the request details

    Scenario: To verify the RequestManager can able to Save the request in PDF format
        Given I view the request
        When   I save the request as PDF
        Then I should be able to see the saved request in PDF format

    Scenario: To verify the RequestManager can able to print
        Given I  view the request
        When   I print a request
        Then I should be able to print

    Scenario: To verify the RequestManager can able to do createactivity of iSource
        Given I see the request in WithRM status
        Then I able to access action tab
        When I do createactivity action for iSource
        Then I do the sourcing activity
        Then I should be able to complete the createactivity for iSource

    Scenario: To verify the RequestManager can able to do createactivity of iManage
        Given I see the request in WithRM status on listing
        Then I access action tab
        When I do createactivity action for iManage
        Then I do the  activity for iManage
        Then I should be able to complete the createactivity for iManage

    Scenario: To verify the RequestManager can able to do createactivity of iContract
        Given I see the request in WithRM status on listing Page
        Then I access action option
        When I do createactivity action for iContract
        Then I do the  activity for iContract
        Then I should be able to complete the createactivity for iContract

