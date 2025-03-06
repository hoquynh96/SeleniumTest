Feature: Go to Clients > All Clients > select client name "Client Test "page

  Scenario: User is go to the Client Test page
    Given User verify to information in the Clients page
    When User input your email address and your password in the Clients page
    Then User verify to information in the All Client page
    Given User select client name "Client Test" page
    Then User verify to information in the Client Test page
    Then User choose the Goal and Countdown
    Then User input to information new Goal successfully
    Then User verify to information in the Goal page

  Scenario: User create to Add New Goal
    Given User input to information new Goal successfully
    Then User verify to newly entered information

  Scenario: User edit information in General Goal
    Given User select to edit button
    Then User input newly information of Goal successfully

  Scenario: User delete information in General Goal successfully
    Given User select to delete button
    Then User delete information of Goal successfully

  Scenario: User delete information in General Goal is fail
    Given User select to delete button
    Then User delete information of Goal is fail

  Scenario: User edit information in General Goal is fail
    Given User select to edit button
    Then User input newly information of Goal is fail

