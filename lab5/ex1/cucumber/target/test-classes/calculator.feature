Feature: BBasic Arithmetic
  Background: A Calculator
    Given a calculator I just turned on

  Scenario: Add numbers
    When I add 4 and 5
    Then the result is 9

  Scenario: Subtraction
    When I substract 11 to 9
    Then the result is 2
    
  Scenario: Multiply
    When I multiply 2 by 2
    Then the result is 4

  Scenario: Divide
    When I divide 10 by 5
    Then the result is 2

  Scenario Outline: Several multiplications
    When I multiply <a> by <b>
    Then the result is <c>
    Examples: Single digits
    | a  | b | c  |
    | 4  | 2 | 8  |
    | 10 | 5 | 50 |

  Scenario Outline: Several additions
    When I add <a> and <b>
    Then the result is <c>
    Examples: Single digits
    | a | b | c  |
    | 1 | 2 | 3  |
    | 3 | 7 | 10 |