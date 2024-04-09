package HW1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import HW1.pages.Index;
import HW1.pages.TablePage;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.openqa.selenium.support.ui.ExpectedConditions;


@ExtendWith(SeleniumJupiter.class)
public class SeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Disabled
    @Test
    void test(ChromeDriver driver) {
        driver.get("http://localhost:8080/");

        driver.manage().window().setSize(new Dimension(1550, 1001));

        Index index = new Index(driver);
        
        index.setFrom("São Pedro do Sul");
        assertEquals("São Pedro do Sul", index.getFrom());

        index.setTo("Aveiro");
        assertEquals("Aveiro", index.getTo());

        index.setDate("2024-04-12");
        assertEquals("2024-04-12", index.getDate());

        index.submitSearchForm();

        TablePage tablePage = new TablePage(driver);
        
        assertEquals("São Pedro do Sul", tablePage.getOriginText());
        assertEquals("Aveiro", tablePage.getDestinationText());
        assertEquals("2024-04-12", tablePage.getDateText());

        tablePage.reserve();

    }
}