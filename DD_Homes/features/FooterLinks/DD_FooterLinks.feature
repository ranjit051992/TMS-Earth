@DD_Homes
Feature: DD_FooterLinks

Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "GDQA-P2P@zycus.com" and "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
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

#check submenus wise menu