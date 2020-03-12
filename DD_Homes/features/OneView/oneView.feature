@DD-Home
Feature: DD_OneView

Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "GDQA-P2P@zycus.com" and "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
        Then I should be logged in


    Scenario: Verify whether on OneView listing individual suppliers are displayed
        Given I navigate to Oneview page
        When I search the supplier with name "PEGDUMMY13"
        Then I see oneview card for "PEGDUMMY13" is displayed
      

    Scenario: Verify whether user is able to export the data in excel file
        Given I navigate to Oneview page
        When I search the supplier with name "PEGDUMMY13"
        When I click on export option
        Then Supplier data is exported in excel format


    Scenario: Verify whether supplier data is loaded as per the filters applied
        Given I navigate to Oneview page
        When I search the supplier with name "PEGDUMMY13"
        When I filter the data with "PEGDUMMY13"
        Then I see results satisfying the filter conditions "PEGDUMMY13" are displayed

    #Scenario:Verify whether on OneView listing group of suppliers are displayed
       # Given I navigate to Oneview page
       # When I search the supplier group with name "ss"
       # Then I see oneview card for supplier is displayed
      


