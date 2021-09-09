@Login
Feature: Login


        @L0 @Staging @L0CA @L1CA
        Scenario: verify Login with valid credential.
            Given I logged in TMS with user role "CA"
             Then Dewdrop Logout