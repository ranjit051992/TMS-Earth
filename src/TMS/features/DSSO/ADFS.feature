@DSSO
Feature: NAVIPROD Sanity1 IDP DSSO-Login ADFS

        @ADFSLoginSuccess
        Scenario: DSSOLoginSuccess ADFS AD Login Page Redirection
            Given User hits IDP DSSO Login ADFS Link
             Then User Redirect to ADFS Login Page
              And Login thorugh ADFS creds "ADFSUser"
              And Dewdrop Login Successful
             Then Dewdrop Logout

        @ADFSLoginLogoutSuccess
        Scenario: DSSOLoginSuccess ADFS AD Login Page Redirection
            Given User hits IDP DSSO Login ADFS Link
             Then User Redirect to ADFS Login Page
              And Login thorugh ADFS creds "ADFSUser"
              And Dewdrop Login Successful
              And Dewdrop Logout
             Then Verify zAuth Logout Page

        @ADFSUserNotPresent
        Scenario: DSSO Login User Not Present ADFS AD Login Page Redirection
            Given User hits IDP DSSO Login ADFS Link
             Then User Redirect to ADFS Login Page
              And Login thorugh ADFS creds "ADFSUserNotPresent"
          #   When Login thorugh ADFS "amar.pawar@zycus.com","nina@1910" creds
             Then zAuth ADFS Error Page shown User "ADFSTestingUser" not Found

        @ADFSUserinactive
        Scenario: DSSO Login User is inactve ADFS AD Login Page Redirection
            Given User hits IDP DSSO Login ADFS Link
             Then User Redirect to ADFS Login Page
              And Login thorugh ADFS creds "ADFSUserinactive"
         #    When Login thorugh ADFS "karan.shinde@zycus.com","Tata@111" creds
             Then zAuth ADFS Error Page shown User "ADFSTestingUser" inactive