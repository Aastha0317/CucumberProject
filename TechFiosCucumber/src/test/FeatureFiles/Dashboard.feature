@Dashboard 
Feature: Verify background color
  @Dashboard01
  Scenario: Set Skyblue background
    Given Set SkyBlue background Button exists
    When I click on the button
    Then the background color will change to sky blue
    
  @Dashboard02
  Scenario: Set white background
    Given Set white background Button exists
    When I click on the white button
    Then the background color will change to white

  