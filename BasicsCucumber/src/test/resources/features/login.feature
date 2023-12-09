@login @regression
Feature:Validate login for successful and unsuccessful credentials

  Background:
    Given I landed to login page
    When I enter username "webdriver"

  Scenario: Validate  successfull login
    And I enter password "webdriver123"
    And I click on submit btn
    Then I validate successful login

  Scenario: Validate  unsuccessfull login

    And I enter password "and"
    And I click on submit btn
    Then I validate unsuccessful login

