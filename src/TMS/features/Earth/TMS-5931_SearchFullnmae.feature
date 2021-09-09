@REQ_TMS-5931
Feature: Able to search user with Full Name

        @TEST_TMS-6063         @Searchuserwithfullname @id:1 @TMS-5931 @L1CA
        Scenario: Verify able to search user with Full Name
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Search on User Listing Page by Full Name
              And Verify user search result
             Then User Logout From Classic TMS
			 
        @TEST_TMS-6064         @SearchuserCasesensetivefullname @id:2 @TMS-5931 @L1CA
        Scenario: Verify able to search user with CaseSensetive Full Name
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Search on User Listing Page by CaseSensetive Full Name
              And Verify user search result
             Then User Logout From Classic TMS
			 
        @TEST_TMS-6065         @SearchuserwithPartialfullname @id:3 @TMS-5931 @L1CA
        Scenario: Verify able to search user with Partial Full Name
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Search on User Listing Page by Partial Full Name
              And Verify user search result
             Then User Logout From Classic TMS