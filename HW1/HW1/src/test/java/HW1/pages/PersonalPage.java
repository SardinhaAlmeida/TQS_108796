package HW1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[2]")
    private WebElement surnameInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[3]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[4]")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[5]")
    private WebElement addressInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[6]")
    private WebElement cityInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[7]")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[8]")
    private WebElement countryInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[9]")
    private WebElement creditCardNumberInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[10]")
    private WebElement creditCardMMInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[11]")
    private WebElement creditCardYYInput;

    @FindBy(xpath = "//*[@id=\"reservationForm\"]/form/input[12]")
    private WebElement creditCardCVVInput;

    @FindBy(xpath = "//form[@class='form-container']")
    private WebElement reservationForm;

    @FindBy(xpath = "//button[@type='submit' and text()='Submit']")
    private WebElement submitButton;

    public PersonalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterPersonalDetails(String name, String surname, String email, String phoneNumber, String address,
            String city, String postalCode, String country) {
        nameInput.sendKeys(name);
        surnameInput.sendKeys(surname);
        emailInput.sendKeys(email);
        phoneNumberInput.sendKeys(phoneNumber);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        postalCodeInput.sendKeys(postalCode);
        countryInput.sendKeys(country);
    }

    public void enterReservationDetails(String creditCardNumber, String creditCardMM, String creditCardYY,
            String creditCardCVV) {
        creditCardNumberInput.sendKeys(creditCardNumber);
        creditCardMMInput.sendKeys(creditCardMM);
        creditCardYYInput.sendKeys(creditCardYY);
        creditCardCVVInput.sendKeys(creditCardCVV);
    }

    public void submitReservationForm() {
        submitButton.click();
    }

    public boolean isReservationFormDisplayed() {
        return reservationForm.isDisplayed();
    }
}
