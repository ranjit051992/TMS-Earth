@DD_Homes @DD_Branding
Feature: Branding&Customization

Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "username" and "password"
        Then I should be logged in



Scenario: Verify whether user is able to change color or logo, if he is a company admin
Given I am on home page
Then I should see BrandingIcon

@tag99
Scenario Outline: Verify whteher the updated changes are reflected in all products and for all user of the tenant
Given I am on home page         
When I modify the branding color "#ff8c00" 
When I navigate to Oneview page
When I navigate back to home page
And I click on hamburger icon
And I click on "My Approvals" module
And I click on "<Tab Name>" page
Then I should see modified color

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