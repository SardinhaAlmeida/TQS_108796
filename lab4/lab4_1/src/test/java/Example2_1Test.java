import static java.lang.invoke.MethodHandles.lookup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example2_1Test {

    static final Logger log = org.slf4j.LoggerFactory.getLogger(lookup().lookupClass());

    private WebDriver driver; 

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup(); 
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver(); 
    }

    @Test
    void test() {
        // Exercise
        String sutUrl = "https://flexigather.github.io/comunication_website/";
        driver.get(sutUrl); 
        String title = driver.getTitle(); 
        log.debug("The title of {} is {}", sutUrl, title); 

        // Verify
        assertThat(title).isEqualTo("Hello from FlexiGather | FlexiGather"); 
    }

    @AfterEach
    void teardown() {
        driver.quit(); 
    }

}
