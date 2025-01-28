@SmokeScenario

Feature: Check Employee Search Functionality


  @AddNewEmployee

  Scenario: SD03:Check Adding New Employee Functionality

    Given User Choose TO Add New Employee
    When User fill All Mandatory Fields Required
    Then New Employee Should be Added