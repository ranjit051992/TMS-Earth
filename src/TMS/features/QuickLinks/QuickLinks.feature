@QuickLink
Feature: Quick Link Check
 
        @QuickLinkcheck @L2CA
        Scenario: Check quick link is working properly
            Given I logged in TMS with user role "CA"
              And Adding TMS in quick link
              And Check TMS added in quick link
              And Remove TMS from quick link
             Then Dewdrop Logout