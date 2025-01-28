@SmokeScenario

  Feature: Check Employee Search Functionality


    @SearchEmployee

    Scenario: SD02:Check Search Functionality

      Given User Choose Admin From Side Menu
      When User fill System User Information and search
      Then Data Should be Displaying inside Record Grid