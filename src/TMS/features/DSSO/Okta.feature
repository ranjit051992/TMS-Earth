@DSSO
Feature: NAVIPROD Sanity2 SP DSSO-Login Okta
        
        @OktaLoginSuccess
        Scenario: DSSOLoginSuccess Okta AD Login Page Redirection
            Given User hits SP DSSO Login Okta Link
             Then User Redirect to okta Login Page
              And Login thorugh Octa creds "OctaUser"
             #When Login thorugh okta "UserLoginDummy@zycus.com","Admin@12345" creds
              And Dewdrop Login Successful
             Then Dewdrop Logout

        @OktaLoginLogoutSuccess
        Scenario: DSSOLoginSuccess Okta AD Login Page Redirection
            Given User hits SP DSSO Login Okta Link
             Then User Redirect to okta Login Page
              And Login thorugh Octa creds "OctaUser"
             #When Login thorugh okta "UserLoginDummy@zycus.com","Admin@12345" creds
              And Dewdrop Login Successful
              And Dewdrop Logout
             Then Verify zAuth Logout Page

        @OktaUserNotPresent
        Scenario: DSSO Login User Not Present Okta AD Login Page Redirection
            Given User hits SP DSSO Login Okta Link
             Then User Redirect to okta Login Page
              And Login thorugh Octa creds "OktaUserNotPresent"
            # When Login thorugh okta "dummy8np@tms.com","Admin@12345" creds
             Then zAuth Error Page shown User "OctaTestingUser" not Found

        @OktaUserinactive
        Scenario: DSSO Login User is inactve Okta AD Login Page Redirection
            Given User hits SP DSSO Login Okta Link
             Then User Redirect to okta Login Page
              And Login thorugh Octa creds "OktaUserinactive"
            # When Login thorugh okta "dummy6inactive@tms.com","Admin@12345" creds
             Then zAuth Error Page shown User "OctaTestingUser" inactive

        @OktaConcurrentLoginIssue
        Scenario: DSSO Login User ConcurrentLoginIssue Okta AD Login Page Redirection
            Given User hits SP DSSO Login Okta Link
             Then User Redirect to okta Login Page
              #And Login thorugh Octa creds "OktaUserConcurrent"
             When Concurrent okta login "OctaTestingUser","OctaUserpass","OctaURL" creds
             Then zAuth Error Page shown User "OctaTestingUser" Exceed Concurrent