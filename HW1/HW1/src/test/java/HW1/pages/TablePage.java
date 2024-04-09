package HW1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePage {
    
    private WebDriver driver;

    @FindBy(id = "currencySelector")
    private WebElement currencySelector;

    @FindBy(id = "origin")
    private WebElement originElement;

    @FindBy(id = "destination")
    private WebElement destinationElement;

    @FindBy(id = "date")
    private WebElement dateElement;

    @FindBy(css = "form[method='post']")
    private WebElement reserve;

    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCurrency(String currency) {
        currencySelector.sendKeys(currency);
    }

    public String getOriginText() {
        return originElement.getText();
    }

    public String getDestinationText() {
        return destinationElement.getText();
    }

    public String getDateText() {
        return dateElement.getText();
    }

    public void reserve() {
        reserve.submit();
    }
}
