Feature: Upload paper invoice
    I will be able to verify uploads functionality.

    Background:
        Given I logged in to the application
        And I navigate to the Uploads module

    Scenario: Uploading the image of paper invoice
        Given I upload image of paper invoice
        Then I should be able to see the status of Uploaded File

    Scenario: Edit the details of uploaded image
        Given I upload image of paper invoice
        When I edit the Uploaded invoice
        Then I should be able to see the changes


    Scenario: Delete the details of uploaded image 
        Given I upload image of paper invoice
        When I delete the Uploaded invoice
        Then I should not be able to see the uploaded invoice