package web_automation;

import java.util.List;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlazeDemoSteps {

    static final Logger log = getLogger(lookup().lookupClass());
    
    private final WebDriver driver = new ChromeDriver();
    
    @Given("I am on the Blaze Demo home page")
    public void I_visit_blaze_demo() {
        driver.get("https://blazedemo.com/");
    }

    @And("I select {string} on the {string} dropdown")
    public void select_dropdown(String option, String dropdown){
        WebElement dropdown_element = driver.findElement(By.name(dropdown));
        dropdown_element.click();
        WebElement option_element = driver.findElement(By.xpath("//option[. = '" + option + "']"));
        option_element.click();
    }

    @And("I click on the {string} button")
    public void click_button(String button){
        WebElement button_element = driver.findElement(By.xpath("//input[@type='submit' and @value='" + button + "']"));
        button_element.click();
    }

    @Then("I should be redirected to a page with the title {string}")
    public void check_title(String title){
        assert driver.getTitle().equals(title);
    }

    @When("I click the {string} button for flight {int}")
    public void choose_flight(String button, int flight){
        List<WebElement> flights = driver.findElements(By.xpath(".//td[2]"));
        for(WebElement flight_element : flights){
            log.debug(flight_element.getText());
            if(flight_element.getText().equals(String.valueOf(flight))){
                WebElement button_element = driver.findElement(By.cssSelector("tr:nth-child(" + (flights.indexOf(flight_element)+1) + ") .btn"));
                button_element.click();
                break;
            }
        }
    }

    @When("I write {string} on the {string} input")
    public void write_input(String text, String input){
        WebElement input_element = driver.findElement(By.id(input));
        input_element.clear();
        input_element.sendKeys(text);
    }   
}
