Feature: My Approval



Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "GDQA-P2P@zycus.com" and "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
        Then I should be logged in

@tag7
Scenario Outline: Verify whether all the listing pages are working in My Approval
Given I am on home page
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
| Operational Supplier Approvals |
| Potential Supplier Approvals |
| Contracts |
| Savings Approvals |
| Task Approvals |
| Phase Approvals |
| Sourcing Approvals |
| Request |
| Change of Classification |
| Vendor Normalization |
| My Opportunities |


