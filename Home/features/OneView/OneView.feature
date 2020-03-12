Feature: DD_OneView

Backgroud: Given I am logged on to the application
   
 
Scenario: Verify whether on OneView listing individual suppliers are displayed
Given User has access to OneView 
And I am on Oneview page
When I search the supplier with name ""
Then I see oneview card for supplier is dispalyed 
And Supplier information are displayed

Scenario: Verify whether user is able to export the data in excel file
Given User has access to OneView 
And I am on Oneview page
When I search the supplier with name ""
And I click on export option
Then Supplier data is exported in excel format

Scenario: Verify whether user is able to export the data in excel file
Given User has access to OneView 
And I am on Oneview page
When I search the supplier with name ""
And I filter the data
Then I see results satisfying the filter conditions are dispalyed.

Scenario:Verify whether on OneView listing group of suppliers are displayed
Given User has access to OneView 
And I am on Oneview page
When I search the supplier group with name ""
Then I see oneview card for supplier is dispalyed 
And Supplier information are displayed

Scenario: Verify whether user is able to export the data in excel file
Given User has access to OneView 
And I am on Oneview page
When I search the supplier with name ""
And I click on export option
Then Supplier data is exported in excel format

Scenario: Verify whether user is able to export the data in excel file
Given User has access to OneView 
And I am on Oneview page
When I search the supplier with name ""
And I filter the data
Then I see results satisfying the filter conditions are dispalyed.

