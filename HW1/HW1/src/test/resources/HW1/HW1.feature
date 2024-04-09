@hw1_sample
Feature: HW1

    Scenario: Reserve Ticket
        Given the user is on the index page
        When the user writes 'São Pedro do Sul' on the from input
        And the user writes 'Aveiro' on the to input
        And the user writes '2024-04-12' on the date input
        And the user clicks on the Search button
        Then the user should be redirected to the page with the title 'Table'
        When the user the user selects the first available bus, with the bus_number 24 and price 7
        Then the user should be redirected to the page with the title 'Personal'
        When the user fills in the information needed:
            | name              | Sara                      |
            | surname           | Almeida                   |
            | email             | sarafalmeida@ua.pt        |
            | phoneNumber       | 123456789                 |
            | address           | Rua da Alegria            |
            | city              | Viseu                     |
            | postalCode        | 3660-231                  |
            | country           | Portugal                  |
            | creditCardNumber  | 21312332534653            |
            | creditCardMM      | 12                        |
            | creditCardYY      | 26                        |
            | creditCardCVV     | 123                       |
        And the user clicks the Submit button
        Then the user should be redirected to the page with the title 'Reservation completed'
        And the token is presented
        And the user clicks the Check Reservation button
        Then the user should be redirected to the page with the title 'Check'
        When the user pastes the token in the token input
        And the user clicks the Check button
        Then the user sees the reservation details
        And the user clicks the BackHome button
        Then the user should be redirected to the page with the title 'Bus Reservation System'

        
        
