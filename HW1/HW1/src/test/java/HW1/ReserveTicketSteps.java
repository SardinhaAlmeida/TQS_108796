// package HW1;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.util.List;
// import java.util.Map;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

// import HW1.pages.Index;
// import HW1.pages.CheckPage;
// import HW1.pages.PersonalPage;
// import HW1.pages.TablePage;
// import HW1.pages.ReservationPage;
// import io.cucumber.datatable.DataTable;
// import io.cucumber.java.en.*;
// import io.github.bonigarcia.wdm.WebDriverManager;

// public class ReserveTicketSteps {
//     private Index index;
//     private CheckPage check_page;
//     private PersonalPage personal_page;
//     private TablePage table_page;
//     private ReservationPage reserve_page;

//     private final WebDriver driver = new FirefoxDriver();

//     @Given("the user is on the index page")
//     public void theUserIsOnTheIndexPage() {
//         // Implementation to navigate to the index page
//         driver.get("http://localhost:8080/");
//         index = new Index(driver);
//     }

//     @When("the user writes {string} on the from input")
//     public void theUserWritesOnTheFromInput(String origin) {
//         index.setFrom(origin);
//         assertEquals(origin, index.getFrom());
//     }

//     @And("the user writes {string} on the to input")
//     public void theUserWritesOnTheToInput(String destination) {
//         index.setTo(destination);
//         assertEquals(destination, index.getTo());
//     }

//     @And("the user writes {string} on the date input")
//     public void theUserWritesOnTheDateInput(String date) {
//         // Implementation to select date on the date input
//         index.setChoosenDate(date);
//         assertEquals(date, index.getChoosenDate());
//     }

//     @And("the user clicks on the Search button")
//     public void theUserClicksOnTheSearchButton() {
//         // Implementation to click on the Search button
//         index.submitSearchForm();
//     }

//     @Then("the user should be redirected to the table page")
//     public void theUserShouldBeRedirectedToTheTablePage() {
//         // Implementation to verify redirection to the table page
//         table_page = new TablePage(driver);
//     }

//     @When("the user the user selects the first available bus, with the bus_number {int} and price {int}")    public void theUserSelectsTheFirstAvailableBusWithBusNumberAndPrice(Integer busNumber, Integer price) {
//         // Implementation to select the first available bus with given busNumber and
//         // price
//         table_page.reserveBus(busNumber.toString(), price.toString());
//     }

//     @Then("the user is redirected to the personal page")
//     public void theUserIsRedirectedToThePersonalPage() {
//         // Implementation to verify redirection to the personal page
//         personal_page = new PersonalPage(driver);
//     }

//     @When("the user fills in the information needed:")
//     public void theUserFillsInTheInformationNeeded(DataTable dataTable) {
//         // Implementation to fill in the personal information from the DataTable
//         List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

//         // Iterate over each row of the DataTable
//         for (Map<String, String> row : rows) {
//             // Extract data from each row
//             String name = row.get("Name");
//             String surname = row.get("Surname");
//             String email = row.get("Email");
//             String phoneNumber = row.get("PhoneNumber");
//             String address = row.get("Address");
//             String city = row.get("City");
//             String postalCode = row.get("PostalCode");
//             String country = row.get("Country");
//             String creditCardNumber = row.get("CreditCardNumber");
//             String creditCardMM = row.get("CreditCardMM");
//             String creditCardYY = row.get("CreditCardYY");
//             String creditCardCVV = row.get("CreditCardCVV");

//             personal_page.enterPersonalDetails(name, surname, email, phoneNumber, address, city, postalCode, country);

//             personal_page.enterReservationDetails(creditCardNumber, creditCardMM, creditCardYY, creditCardCVV);
//         }
//     }

//     @And("the user clicks the Submit button")
//     public void theUserClicksTheSubmitButton() {
//         // Implementation to click on the Submit button
//         personal_page.submitReservationForm();
//     }

//     // @Then("the user is redirected to the reservation page")
//     // public void theUserIsRedirectedToTheReservationPage() {
//     //     // Implementation to verify redirection to the reservation page
//     // }

//     // @And("the token is presented")
//     // public void theTokenIsPresented() {
//     //     // Implementation to verify if the token is presented
//     // }

//     // @And("the user clicks the Check Reservation button")
//     // public void theUserClicksTheCheckReservationButton() {
//     //     // Implementation to click on the Check Reservation button
//     // }

//     // @Then("the user is redirected to the check page")
//     // public void theUserIsRedirectedToTheCheckPage() {
//     //     // Implementation to verify redirection to the check page
//     // }

//     // @When("the user pastes the token in the token input")
//     // public void theUserPastesTheTokenInTheTokenInput() {
//     //     // Implementation to paste the token in the token input
//     // }

//     // @And("the user clicks the Check button")
//     // public void theUserClicksTheCheckButton() {
//     //     // Implementation to click on the Check button
//     // }

//     // @Then("the user sees the reservation details")
//     // public void theUserSeesTheReservationDetails() {
//     //     // Implementation to verify if the user sees the reservation details
//     // }
// }
