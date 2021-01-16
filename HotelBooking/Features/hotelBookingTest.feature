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

Feature: Verify the hotel booking

	Scenario Outline: Title of your scenario
		Given user launch the application on the browser
    When user is on the login page
    And user clicks and enters username "<username>"
    And user clicks and enters password "<password>"
    And user now clicks login
    And user verifies the title after login
    And user clicks firstname and enters value "<firstname>"
    And user clicks lastname and enters value "<lastname>"
    And user clicks email and enters value "<email>"
    And user clicks mobile and enters value "<mobile>"
    And user clicks address and enters value "<address>"
    And user clicks city and selects value "<city>"
    And user clicks state and selects value "<state>"
    And user clicks guest and selects value "<noofguest>"
    And user clicks card holder name and enters value "<holdername>"
    And user clicks card number and enters value "<cardnumber>"
    And user clicks cvv and enters value "<cvv>"
    And user clicks expiry month and enters value "<expirymonth>"
    And user clicks expiry year and enters value "<expiryyear>"
    And user verifies the booking confirmation
    Then user close the application
    
    Examples:
    |username|password|firstname|lastname|email|mobile|address|city|state|noofguest|holdername|cardnumber|cvv|expirymonth|expiryyear|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|3|GS Madhu|4444555544445555|454|12|2032|
    |admin|admin||GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|1|GS Madhu|4444555544445555|454|12|2032|
    |admin|admin|Madhu||testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|2|GS Madhu|4444555544445555|454|12|2032|
    |admin|admin|Madhu|GS||9999999999|Flat-203|Bangalore|Karnataka|3|GS Madhu|4444555544445555|454|12|2032|
    |admin|admin|Madhu|GS|testemail|9999999999|Flat-203|Bangalore|Karnataka|4|GS Madhu|4444555544445555|454|12|2032|
    |admin|admin|Madhu|GS|testemail@gmail.com||Flat-203|Bangalore|Karnataka|5|GS Madhu|4444555544445555|454|12|2032|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999|Flat-203|Bangalore|Karnataka|6|GS Madhu|4444555544445555|454|12|2032|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999||Bangalore|Karnataka|7|GS Madhu|4444555544445555|454|12|2032|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|2||4444555544445555|454|12|2032|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|1|GS Madhu||454|12|2032|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|3|GS Madhu|4444555|454|12|2032|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|3|GS Madhu|4444555544445555||12|2032|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|3|GS Madhu|4444555544445555|454||2032|
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|3|GS Madhu|4444555544445555|454|12||
    |admin|admin|Madhu|GS|testemail@gmail.com|9999999999|Flat-203|Bangalore|Karnataka|3|GS Madhu|4444555544445555|454|12|2032|