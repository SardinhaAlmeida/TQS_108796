package HW1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;

import java.util.List;

public class TablePage {
    
    private WebDriver driver;

    @FindBy(id = "currencySelector")
    private WebElement currencySelector;

    @FindBy(css = "tbody tr")
    private List<WebElement> busRows;

    @FindBy(xpath = "//*[@id=\"busNumber\"]")
    private WebElement busNumberElement;

    @FindBy(xpath = "//*[@id=\"price\"]")
    private WebElement priceElement;

    @FindBy(css = "button")
    private WebElement reserveButton;

    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCurrency(String currency) {
        currencySelector.sendKeys(currency);
    }

    public void reserveBus(String busNumber, String price) {
        for (WebElement row : busRows) {
            if (busNumberElement.getText().equals(busNumber) &&
                priceElement.getText().equals(price)) {
                reserveButton.click();
            break;
            }
        }
    }
}

