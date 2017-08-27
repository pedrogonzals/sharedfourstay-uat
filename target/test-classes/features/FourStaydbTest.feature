@Regression
Feature: Login functionality for different users, 
	As as user, when I go to the FourStay home page,
  	I should be able to login, go to account page,
  	once in account page verify user name credentials 

 Scenario Outline: Verify host user information
 Given I am on the fourstay login dialog
 And I enter email "<email>"
 And I enter password "<password>"
 When I click on the login button
 Then I am on the General Account Setting page
 #And I get first name, last name and phone number from page
 Then I verify credentials with database
 
 
 Examples:
| email                 | password |
| sking@testmail.com    | password |
#| dlorentz@testmail.com | password |
#| daustin@testmail.com  | password |
#| isciarra@testmail.com | password |	
#| imikkili@testmail.com | password |
#| jnayer@testmail.com	| password |
#| shiggins@testmail.com | password |
#| acabrio@testmail.com  | password |
#| rperkins@testmail.com | password |
#| doconnel@testmail.com | password |