@DD_Homes
Feature: Notification

 Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "GDQA-P2P@zycus.com" and "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
        Then I should be logged in

Scenario: Verify the notification count properly shown on UI.
Given I am on home page
Then I see notification count

Scenario: Verify the filter on the document failure notifications
Given I am on home page
When I click on notification icon
And click on document failure notification
Then i see list of document failure

Scenario: Verify whether user is able to Approve from the Approval Notification
Given I am on home page
When I click on notification icon
And click on "APPROVALS" notification
And I click on "Approve" button in notification
And I click on "Approve" button;
# And I "Approve" data;
Then "Data" status should be shown as approved in Notification


Scenario: Verify whether user is able to Reject from the Approval Notification
Given I am on home page
When I click on notification icon
And click on "APPROVALS" notification
And I click on "Reject" button in notification
And I click on "Reject" button;
Then "Data" status should be shown as Rejected in Notification


Scenario: Verify whether user is able to Delegate from the Approval Notification
Given I am on home page
When I click on notification icon
And click on "APPROVALS" notification
And I click on "Delegate" button in notification
And I click on "Delegate" button;
Then "Data" status should be shown as Delegated in notification


Scenario: Verify whether data is displayed for Alerts and Reminders Notification
Given I am on home page
When I click on notification icon
And click on "ALERTS & REMINDERS" notification
Then i see list of "ALERTS & REMINDERS" notifications


Scenario: Verify whether data is displayed for Other Notification
Given I am on home page
When I click on notification icon
And click on "OTHERS" notification
Then i see list of "OTHERS" notifications

# Scenario: Verify whether user is able to download the documents
# Given I am on home page
# When I click on notification icon
# And I click on "OU_1-226/24292"
# And i click on download button
# Then document should be download on user system





