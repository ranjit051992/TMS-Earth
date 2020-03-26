@DD_Homes @DD_Desk
Feature: My Desk
Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "username" and "password"
        Then I should be logged in

@tag89
Scenario Outline: Verify whether able to move into listing pages are working in My Desk
Given I am on home page
When I click on hamburger icon
And I click on "My Desk" module
And I click on "<Tab Name>" page
Then I should see details of the "<Tab Name>" page

Examples:
| Tab Name |
| Analyze Spend |
| Full Source Events |
| Quick Source Events |
| Authoring Contracts |
| Repository Contracts |
| Programs |
| Projects |
| Request |
| Requisitions |
| Buyer |
| Purchase Orders |
| Invoices |
| Credit Memo  |
| eInvoice Mailbox  |
| Performance Events |
| Supplier Requests |
| All Supplier Requests |
#| Savings Projects |
| Operational Suppliers |
| Potential Suppliers |
| Reports |
