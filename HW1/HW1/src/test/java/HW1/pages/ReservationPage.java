package HW1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservationPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Your reservation is complete!')]")
    private WebElement reservationCompleteHeader;

    @FindBy(xpath = "//h2[contains(text(),'Here's your token to check it...Keep it well.')]")
    private WebElement tokenMessage;

    @FindBy(xpath = "//p[contains(text(),'Your token is: ')]/span")
    private WebElement tokenSpan;

    @FindBy(xpath = "//button[contains(text(),'Check my reservation')]")
    private WebElement checkReservationButton;

    public ReservationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getReservationCompleteHeaderText() {
        return reservationCompleteHeader.getText();
    }

    public String getTokenMessageText() {
        return tokenMessage.getText();
    }

    public String getToken() {
        return tokenSpan.getText();
    }

    public void clickCheckReservationButton() {
        checkReservationButton.click();
    }
}
