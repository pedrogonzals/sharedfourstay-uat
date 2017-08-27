@staytest_37
Feature: search stay for specific stays


Scenario: Verity results in DC metro area
	Given I am on the fourstay homepage
	And I enter school name "dupont circle"
	And I enter dates "03/01/2018" and "03/02/2018"
	And I click the search button
	Then the results should contain specific dates
		|03/01/2018|
		|03/02/2018|
		