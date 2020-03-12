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
And I click on "OU_1-226/24292";
And i see details page for "OU_1-226/24292"
And I click on "Approve" button;
# And I "Approve" data;
Then "Data" status should be shown as approved in Notification


Scenario: Verify whether user is able to Reject from the Approval Notification
Given I am on home page
When I click on notification icon
And I click on "OU_1-226/24292";
And i see details page for "OU_1-226/24292"
And I click on "Reject" button;
# And I "Reject" data;
Then "Data" status should be shown as Rejected in Notification


Scenario: Verify whether user is able to Delegate from the Approval Notification
Given I am on home page
When I click on notification icon
And I click on "OU_1-226/24292"
And i see details page for "OU_1-226/24292"
And I click on "Delegate" button
# And I "Delegate" data;
Then "Data" status should be shown as Delegated in notification


Scenario: Verify whether user is able to download the documents
Given I am on home page
When I click on notification icon
And I click on "OU_1-226/24292"
And i click on download button
Then document should be download on user system


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


# Scenario: Verify Whether same data is displayed across products for the same user
# Given I am logged in as: "data.user.username" , "data.user.password"
# And I am in "i18n.I_CONTRACT" module and "i18n.AUTHORING_CONTRACTS" section
# When I click on notification icon
# And click on "Other" notification
# Then i see list of "Other" notifications


