Feature: Design an API Automation test to achieve the below scenario


  @API @TestCase-1
  Scenario: Validate the title of the popup windows with API Response
    Given I invoke Nakuri URL
    Then I hit the banners api to get the details of window popups
    And I validate count be should matched between UI and API
    And I validate the company name in the UI with api response