@DD_Homes @DD_Desk
Feature: My Approval

Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "username" and "password"
        Then I should be logged in

@tag71
Scenario Outline: Verify whether all the listing pages are working in My Approval
Given I am on home page
When I navigate to Oneview page
When I navigate back to home page
When I click on hamburger icon
And I click on "My Approvals" module
And I click on "<Tab Name>" page
Then I should see details of the "<Tab Name>" page

Examples:
| Tab Name |
| Requisitions |
| Standard PO |
| Blanket PO |
| Invoices |
| Recurring Contracts |
| Operational Supplier Requests |
| Potential Supplier Requests |
| Contracts |
| Savings Approvals |
| Task Approvals |
| Phase Approvals |
| Sourcing Approvals |
| Request |