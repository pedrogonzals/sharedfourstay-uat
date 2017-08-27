@staytest_36
Feature: verify price listing functionality
	As a user, when i to go the Fourstay homepage,
	I should be able to login as a guest,
	I should be able to see my result page containing the prices for my stay
	
Scenario: Login as a guest
	Given I am on the fourstay homepage 
	When I login as a guest 
	And I enter school name in User Account Page "Dupont circle washington dc"
	And I enter dates User Account Page "07/29/2017" and "09/22/2017"
	Then the results should contain price tags
	
	
