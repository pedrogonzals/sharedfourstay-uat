Feature: displaying user information

Background: 
Given I am on the fourstay login dialog

Scenario: Verify host user information

And I enter email "testscooper@test.mail.com"
And I enter password "password"
When I click on the login button
Then the user name should be "Sheldon Cooper"

Scenario: Verify host user information
 Given I am on the fourstay login dialog
 And I enter email "testafowler@test.mail.com"
 And I enter password "password"
 When I click on the login button
 Then the user name should be "Amy Fowler"
 
 @smoke
 Scenario Outline: Verify host user information
 Given I am on the fourstay login dialog
 And I enter email "<email>"
 And I enter password "<password>"
 When I click on the login button
 Then the user name should be "<name>"
 
 Examples:
 |name            | email                       | password|
 |Orlando Wolf	|	OrlandoWolf@test.mail.com	|Orlandob74cf|
 |Lenora Ferry 	|LenoraFerry@test.mail.com|	Lenoradb1d1|
 |Charlotte Heller|	CharlotteHeller@test.mail.com|	Charlotte6b8a2|
 