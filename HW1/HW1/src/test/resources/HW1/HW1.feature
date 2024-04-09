@hw1_sample
Feature: HW1

    Scenario: Reserve Ticket
        Given the user is on the index page
        When the user writes 'São Pedro do Sul' on the from input
        And the user writes 'Aveiro' on the to input
        And the user writes '2024-04-12' on the date input
        And the user clicks on the Search button
        Then the user should be redirected to the table page
        When the user the user selects the first available bus, with the bus_number 24 and price 7
        Then the user is redirected to the personal page
        When the user fills in the information needed:
            | Name              | Sara                      |
            | Surname           | Almeida                   |
            | Email             | sarafalmeida@ua.pt        |
            | PhoneNumber       | 123456789                 |
            | Address           | Rua da Alegria            |
            | City              | Viseu                     |
            | PostalCode        | 3660-231                  |
            | Country           | Portugal                  |
            | CreditCardNumber  | 21312332534653            |
            | CreditCardMM      | 12                        |
            | CreditCardYY      | 26                        |
            | CreditCardCVV     | 123                       |
        And the user clicks the Submit button

        
        
