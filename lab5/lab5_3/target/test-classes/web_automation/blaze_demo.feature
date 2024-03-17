@blaze_demo_sample
Feature: BlazeDemo

    Scenario: Booking Flight
        Given I am on the Blaze Demo home page
        And I select "Paris" on the "fromPort" dropdown
        And I select "New York" on the "toPort" dropdown
        And I click on the "Find Flights" button
        Then I should be redirected to a page with the title "BlazeDemo - reserve"
        When I click the "Choose This Flight" button for flight 12
        Then I should be redirected to a page with the title "BlazeDemo Purchase"
        When I write "ola" on the "inputName" input
        And I write "blabla 123" on the "address" input
        And I write "não sei" on the "city" input
        And I write "também não" on the "state" input
        And I write "132131" on the "zipCode" input
        And I select "Visa" on the "cardType" dropdown
        And I write "21312332534653" on the "creditCardNumber" input
        And I write "09" on the "creditCardMonth" input
        And I write "2007" on the "creditCardYear" input
        And I write "ola adeus" on the "nameOnCard" input
        And I click on the "Purchase Flight" button
        Then I should be redirected to a page with the title "BlazeDemo Confirmation"









