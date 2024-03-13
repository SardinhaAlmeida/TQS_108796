package webpages;

import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }
    
}
