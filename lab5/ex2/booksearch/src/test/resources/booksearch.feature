Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.

  Background: initial library
    Given a book with the title 'One good book', written by 'Fred and George', published in 14 March 2013
    And another book with the title 'Some other book', written by 'Tim Tomson', published in 23 August 2014
    And another book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 01 January 2012

  Scenario: Search books by publication year
    When the customer searches for books published between 2013-01-01 and 2014-12-31
    Then 2 books should have been found
    And Book 1 should have the title 'Some other book'
    And Book 2 should have the title 'One good book'

  Scenario: Search book by author
    When the customer searches for books by 'Tim'
    Then 2 books should have been found
    And Book 1 should have the title 'One good book'
    And Book 2 should have the title 'How to cook a dino'