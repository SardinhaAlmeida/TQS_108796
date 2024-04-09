package HW1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Index {

    private WebDriver driver;

    @FindBy(id = "from")
    private WebElement fromInput;

    @FindBy(id = "to")
    private WebElement toInput;

    @FindBy(id = "date")
    private WebElement dateInput;

    @FindBy( css = "button:nth-child(7)")
    private WebElement searchForm;

    @FindBy(css = "form.check")
    private WebElement checkReservationForm;

    public Index(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFrom(String origin) {
        fromInput.sendKeys(origin);
    }

    public void setTo(String destination) {
        toInput.sendKeys(destination);
    }

    public void setDate(String date) {
        dateInput.sendKeys(date);
    }

    public void submitSearchForm() {
        searchForm.submit();
    }

    public void submitCheckReservationForm() {
        checkReservationForm.submit();
    }

    public String getFrom() {
        return fromInput.getAttribute("value");
    }

    public String getTo() {
        return toInput.getAttribute("value");
    }

    public String getDate() {
        return dateInput.getAttribute("value");
    }
}
