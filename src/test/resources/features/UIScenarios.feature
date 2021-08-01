Feature: Design an automation framework and develop the given frontend automation test cases for the below website

  Background:
    Given I invoke Herokuapp URL

  @UI @TestCase-1
  Scenario: TestCase-1
    When I click on "Form Authentication"
    Then I extract the username and password from the text
    And I enter the extracted username
    And I enter the extracted password
    And I click on Login button
    And I validate the flash message as "You logged into a secure area!"
    And I take screenshot of the page

  @UI @TestCase-2
  Scenario: TestCase-2
    When I click on "Dynamic Loading"
    Then I click on "Example 2: Element rendered after the fact" in Dynamic Loading page
    And I click on start button
    And I validate the progress bar is displayed
    And I wait for the progress bar to complete
    And I validate the message as "Hello World!"
    And I take screenshot of the page

  @UI @TestCase-3
  Scenario: TestCase-3
    When I click on "Multiple Windows"
    Then I click on "Click Here" on windows page
    And I log the URL of the newly opened tab
    And I close the new tab
    And I log the title of the current page
    And I take screenshot of the page

  @UI @TestCase-4
  Scenario: TestCase-4
    When I click on "Drag and Drop"
    Then I drag box A to box B
    And I validate the header of box B should be "A"
    And I take screenshot of the page


  @UI @TestCase-5
  Scenario: TestCase-5
    When I click on "Frames"
    Then I click on iFrame
    Then I clear the default text from the text area
    Then I enter the text "I entered some text in frame text box" in the frame text box
    And I make the entered text as Bold
    And I take screenshot of the page


  @UI @TestCase-6
  Scenario: TestCase-6
    When I click on "JavaScript Alerts"
    Then I click on "Click for JS Confirm" button
    And I cancel the Alert
    Then I validate the alert cancelled message as "You clicked: Cancel"
    And I take screenshot of the page