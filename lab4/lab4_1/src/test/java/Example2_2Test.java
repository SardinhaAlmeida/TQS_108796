import static java.lang.invoke.MethodHandles.lookup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class Example2_2Test {

    static final Logger log = org.slf4j.LoggerFactory.getLogger(lookup().lookupClass());

    @Test
    void test(FirefoxDriver driver) {
        // Exercise
        String sutUrl = "https://flexigather.github.io/comunication_website/";
        driver.get(sutUrl); 
        String title = driver.getTitle(); 
        log.debug("The title of {} is {}", sutUrl, title); 

        // Verify
        assertThat(title).isEqualTo("Hello from FlexiGather | FlexiGather"); 
    }
}
