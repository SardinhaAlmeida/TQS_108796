package HW1;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Hw1Application.class)
class Hw1ApplicationTest {

    @Autowired
    private Hw1Application hw1Application;

    @Test
    @DisplayName("Application context loads successfully beacuse excludes in pom not working")
    void contextLoads() {
        // Ensure that the application context loads successfully
        assertNotNull(hw1Application);
    }
}
