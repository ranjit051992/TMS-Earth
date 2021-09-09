@CreateReport @L1 @Staging @L1CA
Feature: Report Creation

        @L1 @Staging @L1CA @CreateReport
        Scenario: Check Company admin is able to Create Report
            Given I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And  I navigate to Reports tab
              And I select Create New Report option
              And I click on Next button for Step1
              And I click on Next button for Step2
              And  I fill all the data at Step3
              And I click on Next button for Step3
              And I click on Next button for Step5
              And  I fill all the data at Step6
              And I click on Run Report
             # And  I fill all the data at Step7
              #And I click on Next button for Step7
              And I should see the report
              And I close report
              And I close popup
             Then User Logout From Classic TMS


        @L2CA @ReportsActivityCreateReport @TMS-5977
        Scenario: Check Report Activity user is able to Create Report
            Given I logged in TMS for Specific user role "Reports"
              And Navigate to TMS Page "TMS" "TMS"
              And I select Create New Report option
              And I click on Next button for Step1
              And I click on Next button for Step2
              And  I fill all the data at Step3
              And I click on Next button for Step3
              And I click on Next button for Step5
              And  I fill all the data at Step6
            #   And I click on Run Report
            #  # And  I fill all the data at Step7
            #   #And I click on Next button for Step7
            #   And I should see the report
            #   And I close report
            #   And I close popup
            #  Then User Logout From Classic TMS