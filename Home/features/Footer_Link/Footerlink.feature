Feature: DD_FooterLinks

Backgroud: Given I am logged into the application

Scenario: To Verify whether user is able to navigate to products from Footer menu links
    Given I am on Landing Page
    When I click on "Footer Link"
    Then I should be redirected to selected "Footer Link" product
