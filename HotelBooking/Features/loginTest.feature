#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Verify the login functionality of the application

  Scenario Outline: User Login
    Given user launched browser and the application
    When user is on the applicaion login page
    And user clicks username and enters value "<username>"
    And user clicks password and enters value "<password>"
    And user clicks login button
    Then user close the browser
    
    Examples:
    |username|password|
    | | |
    |abcd|efgh|
    | |admin|
    |admin| |
    |admin|admin|