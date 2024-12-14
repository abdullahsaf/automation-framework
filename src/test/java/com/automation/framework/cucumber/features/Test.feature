Feature: Login Feature

  Scenario Outline: Testing Assignment
    Given user is on the testing page
    When User clicks on link text
    Then the page loads
    And User type "<name>" in textbox
    And User clicks submit button
    Then submit button turns blue
    When User clicks double click button
    Then accept the alert box
    And click "<gender>" radio button
    And check "automation" testing checkbox
    And check "performance" testing checkbox
    And select "Manual Testing" from dropdown
    When user clicks on generate alert box
    Then accept the alert box
    When user clicks on generate confirm box
    And accept the confirm box
    Then the confirmation text is "You pressed OK!"
    When user clicks on generate confirm box
    Then cancel the confirm box
    But the confirmation text is "You pressed Cancel!"
    When drag image to target box
    Then the image is placed in target box
    Examples:
      | name | gender |
      | Ab   | male   |
      | Am   | female   |