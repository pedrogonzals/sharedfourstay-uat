@staytest_234
Feature: Fourday search using maps

Scenario: Verify results in DC metro area using maps

Given I am on the fourstay homepage

When I enter this search criteria

|  school              |   start    |  end      |

|Georgetown university | 07/29/2017 | 09/22/2017|

Then the results should contain

|District of Columbia |

|Maryland             |

|Virginia             |

