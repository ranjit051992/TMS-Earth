@Company
Feature: Create Company

        @CreateCompany @L1
        Scenario: Create Company
            Given I logged in TMS with user role "ZA"
             Then   Navigate to Company Listing
              And User on Create Company Page
              And I Fill Basic Information
              And I Fill Component Selection & Product Allocation
              And I Fill Company Admin Details
              And I Fill Preferences
              And Define Company
              And Company Creation Success Popup should be seen
             Then Company is shown on Company Listing Page

        @ActivateCompany @L1
        Scenario: Check Company Activate Scenario
            Given I logged in TMS with user role "ZA"
             Then   Navigate to Company Listing
              And I activate Company
             Then Company should get activate

        @DeactivateCompany @L1
        Scenario: Check Company Deactivate Scenario
            Given I logged in TMS with user role "ZA"
             Then   Navigate to Company Listing
              And I deactivate Company
             Then Company should get deactivate

        @EditCompany @L1
        Scenario: Edit Company Basic Details
            Given I logged in TMS with user role "ZA"
             Then   Navigate to Company Listing
              And Go to the Edit Company Summary Page
              And Update Company Basic Details
              And Update Company
             Then Company Popup should be seen

        