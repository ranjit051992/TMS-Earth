@verifyImpersonation
Feature: Company Admin Accept request
        Scenario: To verify Company Admin is able to accept
            Given I logged in TMS with user role "LA"
              And I Select Allow impersonate from user profile
              And I select allow company admin to impersonate me
              And Dewdrop Logout
              And I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Impersonation Page
              And I accept the impersonate request
              And I should be login as Impersonate User
              And Remove impersonate request
             Then Dewdrop Logout