@DD_Homes
Feature: DD_FooterLinks

Background: To Login into Application
Given I navigate to the login page
When I submit username and password
Then I should be logged in

@tag5
Scenario Outline: To Verify whether user is able to navigate to products from Footer menu links
    Given I am on Home page
    When I click on footer-link "<Footer Link>"
    Then I should be redirected to selected "<Footer Link>" product

Examples:
| Footer Link |
| Suppliers  |
| Spend Analysis  |
| Savings Projects  |
| Contracts  |
| Invoices  |
| Requisitions  |
| PO  |
| Sourcing Event  |
| Performance Events  |
| iManage Projects  |
| Reports  |

