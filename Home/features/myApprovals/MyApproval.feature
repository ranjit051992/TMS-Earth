Feature: My Approval

Scenario: Verify whether all the listing pages are working in My Approval
Given I am logged in as: "GDQA-P2P@zycus.com", "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
And I am on home page
When I click on hamburger icon
And I click on "My Approvals" module
And I see all the listing page
And I click on "Standard PO" page
Then I should see details of the "Standard PO" page


