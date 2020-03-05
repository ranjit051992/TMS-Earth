
Feature: Action items on My Approval listing page

    Background:
        Given logged in on iRequest Page
        When I am on MyApproval Listing

    Scenario: To verify the approver can able to approve the request
        Given I see the request in InApproval status
        Then I approve a request
        Then I should be able to see the approval successful  message

    Scenario: To verify the approver can able to reject the request
        Given I see request in InApproval status
        Then I reject a request
        Then I should be able to see the rejection successful message

    Scenario: To verify the approver can able to delegate the request
        Given I find the the request status in InApproval
        Then I delegate the request
        Then I should be able to see the delegated successful message

    Scenario: To verify the approver can able to review the request
        Given I find the request on InApproval status
        Then I am reviewing the request
        Then I should be able to see the request details

    Scenario: To verify the approver can able to Save the request in PDF format
        Given I view the Request
        When I Save the request as PDF
        Then I should be able to see the request in PDF format

    Scenario: To verify the approver can able to print
        Given I am viewing the request
        When  I print a request
        Then I should be able to print that particular request
