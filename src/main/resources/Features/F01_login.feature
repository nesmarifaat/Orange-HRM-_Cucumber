@SmokeScenario

Feature: Check Login Feature


  @LoginTest


  Scenario: SC01:Check Login with Valid Data
    Given  User Enter Valid Username and Password
    When   User Click Button
    Then   User Shall Navigate to Home Page

  @LoginTest
  Scenario: SD01:Check Login with Invalid Username
    Given  User Enter Invalid Username and Valid Password
    When   User click login Button
    Then   Error Message should be displayed

  @LoginTest

  Scenario: SD01:Check Login With Invalid Password
    Given User Enter Invalid Password and Valid Username
    When User click on login Button
    Then Error Message should be displayed II
