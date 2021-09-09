@REQ_TMS-5897
Feature: DSSO Concurrent login page for dsso
 
        @TEST_TMS-6061         @ConcurrentLoginPage @TMS-5897 @id:1
        Scenario: Dsso user able to view concurrent login page
            Given User hits SP DSSO Login Okta Link
              And User Redirect to okta Login Page
              And Concurrent okta login "OctaTestingUser","OctaUserpass","OctaURL" creds
             Then User should be able to view concurrent login page
 
        @TEST_TMS-6062         @Logoutandloginfromconcurrentloginpage @TMS-5897 @id:2
        Scenario: Able to login after clicking on logout link on Concurrent Login Page for Dsso user
            Given User hits SP DSSO Login Okta Link
              And User Redirect to okta Login Page
              And Concurrent okta login "OctaTestingUser","OctaUserpass","OctaURL" creds
              And User should be able to view concurrent login page
              And User able to login after clicking on logout link
             Then Dewdrop Logout