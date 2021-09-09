@CreateUG @Staging
Feature: UserGroup Functionality

        @addUG @L1 @L1CA
        Scenario: Add New UserGroup
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And  Navigate to UserGroup Page
              And I click on Add New UserGroup
              And I enter all the required data
              And I click on CreateNewGroup
              And UserGroup should be created
              And  Navigate to Audit Trail Page
              And I click on UserGroup
              And I should see the Usergroup that was created
             Then User Logout From Classic TMS

        @ViewSelUser @L2 @L1CA
        Scenario: Check CA is able to view selected users in Usergroup
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And  Navigate to UserGroup Page
              And I click on Actions
              And I click on Modify
              And I can click on View Selected link
              And I should be able to see users in the UserGroup
             Then User Logout From Classic TMS

        @ViewUGCreateOption @L1 @L1CA
        Scenario: Check CA is able to view create UG option
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And  Navigate to UserGroup Page
              And I should be able to view create new user group option
             Then User Logout From Classic TMS




       