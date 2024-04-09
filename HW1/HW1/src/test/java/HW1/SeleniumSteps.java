package HW1;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import java.util.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumSteps {

  private WebDriver driver = new FirefoxDriver();
  private String token;

  @Given("the user is on the index page")
  public void on_index_page() {
    driver.get("http://localhost:8080/");
    driver.manage().window().setSize(new Dimension(1472, 764));
  }

  @When("the user writes {string} on the from input")
  public void write_from_input(String from) {
    driver.findElement(By.id("from")).click();
    driver.findElement(By.id("from")).sendKeys(from);
  }

  @And("the user writes {string} on the to input")
  public void write_to_input(String to) {
    driver.findElement(By.id("to")).click();
    driver.findElement(By.id("to")).sendKeys(to);
  }

  @And("the user writes {string} on the date input")
  public void write_date_input(String date) {
    driver.findElement(By.id("date")).click();
    driver.findElement(By.id("date")).sendKeys(date);
  }

  @And("the user clicks on the Search button")
  public void click_search_button() {
    driver.findElement(By.cssSelector("button:nth-child(7)")).click();
  }

  @Then("the user should be redirected to the page with the title {string}")
  public void redirected_to_page(String title) {
    assertEquals(title, driver.getTitle());
  }

  @When("the user the user selects the first available bus, with the bus_number {int} and price {int}")
  public void select_first_bus(int bus_number, int price) {
    driver.findElement(By.id("button")).click();
  }

  @When("the user fills in the information needed:")
  public void fill_information(Map<String, String> information) {
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys(information.get("name"));
    driver.findElement(By.id("surname")).click();
    driver.findElement(By.id("surname")).sendKeys(information.get("surname"));
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys(information.get("email"));
    driver.findElement(By.id("phoneNumber")).click();
    driver.findElement(By.id("phoneNumber")).click();
    driver.findElement(By.id("phoneNumber")).sendKeys(information.get("phoneNumber"));
    driver.findElement(By.id("address")).click();
    driver.findElement(By.id("address")).sendKeys(information.get("address"));
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys(information.get("city"));
    driver.findElement(By.id("postalCode")).click();
    driver.findElement(By.id("postalCode")).sendKeys(information.get("postalCode"));
    driver.findElement(By.id("country")).click();
    driver.findElement(By.id("country")).sendKeys(information.get("country"));
    driver.findElement(By.name("creditCardNumber")).click();
    driver.findElement(By.name("creditCardNumber")).sendKeys(information.get("creditCardNumber"));
    driver.findElement(By.name("creditCardMM")).click();
    driver.findElement(By.name("creditCardMM")).sendKeys(information.get("creditCardMM"));
    driver.findElement(By.name("creditCardYY")).click();
    driver.findElement(By.name("creditCardYY")).sendKeys(information.get("creditCardYY"));
    driver.findElement(By.name("creditCardCVV")).click();
    driver.findElement(By.name("creditCardCVV")).sendKeys(information.get("creditCardCVV"));
  }

  @And("the user clicks the Submit button")
  public void click_submit_button() {
    driver.findElement(By.cssSelector(".btn:nth-child(29)")).click();
  }

  @And("the token is presented")
  public void token_presented() {
    driver.findElement(By.cssSelector("p")).click();
    WebElement tokenElement = driver.findElement(By.xpath("/html/body/p/span"));
    token = tokenElement.getText();
  }

  @And("the user clicks the Check Reservation button")
  public void click_check_reservation_button() {
    driver.findElement(By.cssSelector("button")).click();
    assertNotNull(token);

  }

  @When("the user pastes the token in the token input")
  public void paste_token() {
    driver.findElement(By.id("tokenInputField")).click();
    driver.findElement(By.id("tokenInputField")).sendKeys(token);
  }

  @And("the user clicks the Check button")
  public void click_check_button() {
    driver.findElement(By.cssSelector("button:nth-child(2)")).click();
  }

  @Then("the user sees the reservation details")
  public void reservation_details() {
    assertTrue(driver.findElement(By.id("reservationDetails")).isDisplayed());
  }

  @And("the user clicks the BackHome button")
  public void click_back_home_button() {
    driver.findElement(By.cssSelector("button:nth-child(1)")).click();
  }
}
