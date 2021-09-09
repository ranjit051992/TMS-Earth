@Impersonation @Staging
Feature: View Impersonation

        @ViewImpersonation @L1 @L1CA
        Scenario: Impersonation Page view for Company Admin
            Given   I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And Navigate to Impersonation Page
             Then Impersonation page should be accessible
             
        

        