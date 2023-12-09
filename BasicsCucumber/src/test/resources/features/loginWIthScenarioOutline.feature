@loginOutline
Feature:Validate login for successful and unsuccessful credentials

  Background:
    Given I landed to login page


  Scenario Outline: Validate  successfull and unsuccessful login
    When I enter username "webdriver"
    And I enter password "webdriver123"
    And I click on submit btn
    Then I validate message
    Examples:
      | username  | password       | message              |
      | webdriver | webdriver123   | validation succeeded |
      | webdriver | webdriver12345 | validation failed    |



