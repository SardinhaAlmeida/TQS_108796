package webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    private static String PAGE_URL="https://blazedemo.com/";

    @FindBy(name = "fromPort")
    private WebElement fromPort1;
    
    @FindBy(xpath = "//option[. = 'Philadelphia']")
    private WebElement philadelphia;

    @FindBy(name = "toPort")
    private WebElement toPort;

    @FindBy(xpath = "//option[. = 'New York']")
    private WebElement newYork;

    @FindBy(name = "fromPort")
    private WebElement fromPort;

    @FindBy(xpath = "//option[. = 'Paris']")
    private WebElement paris;

    @FindBy(css = ".btn-primary")
    private WebElement btn_primary;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);

    }

    public void setFromPort1() {
        fromPort1.click();
    }

    public void setPhiladelphia() {
        philadelphia.click();
    }

    public void setToPort() {
        toPort.click();
    }

    public void setNewYork() {
        newYork.click();
    }

    public void setFromPort() {
        fromPort.click();
    }

    public void setParis() {
        paris.click();
    }

    public void setBtn_primary() {
        btn_primary.click();
    }
}
