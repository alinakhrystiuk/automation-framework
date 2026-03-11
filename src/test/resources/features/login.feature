Feature: Login Functionality
  As a registered user
  I want to login to Automation Exercise
  So that I can access my account

  Background:
    Given user is on the home page

  Scenario: Successful login with valid credentials
    When user clicks on Signup Login button
    And user enters valid email and password
    And user clicks login button
    Then user should be logged in successfully

  Scenario: Unsuccessful login with invalid credentials
    When user clicks on Signup Login button
    And user enters invalid email and password
    And user clicks login button
    Then user should see incorrect login message