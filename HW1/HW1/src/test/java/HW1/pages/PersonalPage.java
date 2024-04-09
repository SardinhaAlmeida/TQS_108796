package HW1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalPage {
    private WebDriver driver;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "surname")
    private WebElement surnameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "phoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(name = "address")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postalCode")
    private WebElement postalCodeInput;

    @FindBy(name = "country")
    private WebElement countryInput;

    @FindBy(name = "creditCardNumber")
    private WebElement creditCardNumberInput;

    @FindBy(name = "creditCardMM")
    private WebElement creditCardMMInput;

    @FindBy(name = "creditCardYY")
    private WebElement creditCardYYInput;

    @FindBy(name = "creditCardCVV")
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
