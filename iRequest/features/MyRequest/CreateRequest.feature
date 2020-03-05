Feature: Create Request with different Request Types and Request Definition

  Background:
    Given I logged in on iRequest Page
    Then I am on MyRequest Listing Page


  Scenario:To verify the user can able to create a request with None Request Type
    Given I create a requestdefinition with none requesttype
    Then I create a request with that particular requestdefinition
    And  I submit the request with none requesttype
    Then I should be able to see the particular request got created on listing Page

  Scenario:To verify the user can able to save a request as SaveAsDraft with None Request Type
    Given I create a requestdefinition
    Then I create a request with requestdefinition with none requesttype
    And  I save the request as SaveAsDraft with none requesttype
    Then  I should be able to see the particular request got created on listing Page in draft status


  Scenario:To verify the user can able to create a request with Sourcing as Request Type
    Given I create a requestdefinition with sourcing requesttype
    Then I create a request with that particular requestdefinition
    And  I submit the request with sourcing requesttype
    Then I should be able to see the particular request got created on listing Page

  Scenario:To verify the user can able to save a request as SaveAsDraft with Sourcing Request Type
    Given I create a requestdefinition
    Then I create a request with requestdefinition with sourcing requesttype
    And  I save the request as SaveAsDraft with Sourcing requesttype
    Then  I should be able to see the particular request got created on listing Page in draft status

  Scenario:To verify the user can able to create a request with iContract as Request Type
    Given I create a requestdefinition with iContract requesttype
    Then I create a request with that particular requestdefinition
    And  I submit the request with iContract requesttype
    Then I should be able to see the particular request got created on listing Page

  Scenario:To verify the user can able to save a request as SaveAsDraft with Contract Request Type
    Given I create a requestdefinition
    Then I create a request with requestdefinition with contract requesttype
    And  I save the request as SaveAsDraft with iContract requesttype
    Then  I should be able to see the particular request got created on listing Page in draft status

  Scenario:To verify the user can able to create a request with iManage as Request Type
    Given I create a requestdefinition with iManage requesttype
    Then I create a request with that particular requestdefinition
    And  I submit the request with iManage requesttype
    Then I should be able to see the particular request got created on listing Page

  Scenario:To verify the user can able to save a request as SaveAsDraft with iManage Request Type
    Given I create a requestdefinition
    Then I create a request with requestdefinition with contract requesttype
    And  I save the request as SaveAsDraft with iManage requesttype
    Then  I should be able to see the particular request got created on listing Page in draft status

  Scenario: To verify the user can able to submit the request after adding urgent requirement
    Given I create a requestdefinition
    Then I create a request making uregent requirement marked
    Then I should be able to create a request

  Scenario: To verify the user can able to save the request as SaveAsDraft after adding urgent requirement
    Given I create a requestdefinition
    Then I create a request making uregent requirement marked
    Then I should be able to create a request with urgent requirement added

  Scenario:To verify the user can able to edit the returned request
    Given I check the status of the request as returned
    Then I should be able to edit the request

  Scenario:To verify the user can able to edit the recalled request
    Given I check the status of the request as recalled
    Then I should be able to edit the request

  Scenario: To verify the requester can able to Save the request in PDF format
    Given I view the request
    When   I save the request as PDF
    Then i should be able to see the saved request in PDF format

  Scenario: To verify the requester can able to print
    Given I  view the request
    When   I print a request
    Then I should be able to print

  Scenario: To verify the requester can able to view the already created request
    Given I  view the  already created request
    Then  I should be able to see all the details of the request

  Scenario: To verify the status of the requests on MyRequest listing
    Given I see the status tab
    Then I should be able to see the required status as per MyRequest listing

  Scenario:To verify requester can able to access Activity Tab
    Given I view the request
    Then I aceess the Activity Tab
    Then I should be able to see all the actions being performed in the Activity Tab

  Scenario:To verify requester can able to add addhoc approver in the workflow and submit the request
    Given I create a requestdefinition with addhoc checkbox enabled
    Then I Create a request with particular requestdefinition
    When I mark checkbox  to add approver selector node
    Then I should be able to add approver on the selected workflow node
    And I should be able to submit the request with addhoc workflow node being added

  Scenario:To verify requester can able to add addhoc approver in the workflow and save the request as draft
    Given I create a requestdefinition with addhoc checkbox enabled with none requesttype
    Then I Create a request with that requestdefinition
    When I enable checkbox  to add approver selector node
    Then I should be able to add approver at selected position in workflow node
    And I should be able to save the request in draft status with addhoc workflow node being added

  Scenario:To verify requester can able to view the workflow while viewing the request
    Given I view the request being created
    Then I should be able to view the workflow being configured

  Scenario: To verify requester can able to create a request with ZSN
    Given I Create a requestdefinition with external suppliers
    When  I am on ZSN page
    Then I create a request with that particular requestdefinition
    And I should be able to submit that particular request

  Scenario: To verify requester can able to create a request with workflow
    Given I Create a requestdefinition with workflow
    When I create a request with the workflow configured requestdefinition
    Then I should be able to submit the  workflow configured request
    And I should be able to see the configured workflow

  Scenario: To verify requester can able to create a request with FlexiForm
    Given I Create a requestdefinition with FlexiForm
    When I create a request with the FlexiForm configured requestdefinition
    Then I should be able to submit the  FlexiForm configured request
    And I should be able to see the configured FlexiForm





















