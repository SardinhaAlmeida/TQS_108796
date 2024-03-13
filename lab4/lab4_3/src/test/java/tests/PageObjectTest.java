package tests;

//Generated by Selenium IDE
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.extension.ExtendWith;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import webpages.ChooseFlightPage;
import webpages.ConfirmationPage;
import webpages.FillDataPage;
import webpages.HomePage;

@ExtendWith(SeleniumJupiter.class)
public class PageObjectTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void PageObject() {

        HomePage home = new HomePage(driver);
        home.setFromPort1();
        home.setPhiladelphia();
        home.setToPort();
        home.setNewYork();
        home.setFromPort();
        home.setParis();
        home.setBtn_primary();

        ChooseFlightPage choose = new ChooseFlightPage(driver);
        choose.setBtn();

        FillDataPage data = new FillDataPage(driver);
        data.setInputName("ola");
        data.setAddress("blabla 123");
        data.setCity("não sei");
        assertTrue(data.isCityInputEditable());
        data.setState("também não");
        data.setZipCode("132131");
        assertTrue(data.CardType());
        data.setCreditCardNumber("21312332534653");
        data.setCreditCardMonth("09");
        data.setCreditCardYear("2007");
        data.setForm();
        data.setNameOnCard("ola adeus");
        data.setCheckbox();
        data.setRemember_me();
        data.setBtn_primary();
        data.setWeird_btn();

        ConfirmationPage confirm = new ConfirmationPage(driver);
        assertThat(confirm.getTitle(), is("BlazeDemo Confirmation"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
