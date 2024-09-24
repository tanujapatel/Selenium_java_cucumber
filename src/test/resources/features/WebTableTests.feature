Feature: Webtables Tests
  Automate webtables scenarios

  Background: Webtables page is launched

  @addUser1
  Scenario Outline: Add a user and validate the user has been added to the table
    When Click on add user button
    And  Enter below user details
    |firstName|lastName|userName|password|company|role|email|mobileNumber|
    |<firstName>|<lastName>|<userName>|<password>|<company>|<role>|<email>|<mobileNumber>|
    And Click on save button
    Then Verify added user details as below
    |firstName|lastName|userName|company|role|email|mobileNumber|
    |<firstName>|<lastName>|<userName>|<company>|<role>|<email>|<mobileNumber>|
    Examples:
      |firstName|lastName|userName|password|company|role|email|mobileNumber|
      |tuser1first|tuser1last|tuser1|pass1234|Company AAA|Sales Team|tuser1@example.com|9085436267|

  @removeUserNovak
  Scenario: Remove user novak from table
    When I remove user "novak"
    Then  I verify user "novak" should not be displayed on table
