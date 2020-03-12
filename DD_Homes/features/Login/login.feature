@DD_Homes @Login
Feature: Login 


Scenario: verify Login with valid credential.
Given user navigates to the login page
And user enter valid "GDQA-P2P@zycus.com","YoDeHaCoPoBiBaIoAiWiYeQe8&7" credentials
Then login must be successful

Scenario: verify Login with Invalid credential.
Given user navigates to the login page
And user enter invalid "GDQA-P2P@zycus.com","YoDeHaCoPoBiBaIoAiWiYeQe28&7" credentials
Then login must give validation error


