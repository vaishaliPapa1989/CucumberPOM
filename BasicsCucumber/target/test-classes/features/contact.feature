@contactUs @regression
Feature: Webdriver University Contact Us Page

  Scenario: Validate successfull submission unique data
    Given I landed on contact page
    When I enter first name
    And I enter last name
    Then I verify I am successfully logged in.


  Scenario: Validate successfull submission specific data
    Given I landed on contact page
    When I enter a specific first name vaishali
    And I enter a specific last name jain
    And I enter specific email address v@gmail.com
    And I enter specific message "hello"
    And I click on submit button
    Then Successful login should happen.
