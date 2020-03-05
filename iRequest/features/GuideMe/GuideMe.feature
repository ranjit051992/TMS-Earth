Feature: GuideMe

  Background:
    Given logged in on iRequest Page

@L1
  Scenario:To verify that user can able to map through GuideMe

    Given I am on MyRequest Listing Page
    Then I access GuideMe
    And  I select any Request Type option
    Then I should able to Map through GuideMe