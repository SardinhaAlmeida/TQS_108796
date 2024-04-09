package HW1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckPage {

    private WebDriver driver;

    @FindBy(id = "tokenInputField")
    private WebElement tokenInputField;

    @FindBy(xpath = "//form[@id='checkReservationForm']//button")
    private WebElement checkButton;

    @FindBy(id = "reservationDetails")
    private WebElement reservationDetails;

    @FindBy(id = "noReservationMessage")
    private WebElement noReservationMessage;

    @FindBy(id = "busNumber")
    private WebElement busNumber;

    @FindBy(id = "origin")
    private WebElement origin;

    @FindBy(id = "destination")
    private WebElement destination;

    @FindBy(id = "date")
    private WebElement date;

    @FindBy(id = "departureTime")
    private WebElement departureTime;

    @FindBy(id = "arrivalTime")
    private WebElement arrivalTime;

    @FindBy(id = "price")
    private WebElement price;

    @FindBy(id = "capacity")
    private WebElement capacity;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "surname")
    private WebElement surname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "postalCode")
    private WebElement postalCode;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "creditCardNumber")
    private WebElement creditCardNumber;

    @FindBy(id = "creditCardMM")
    private WebElement creditCardMM;

    @FindBy(id = "creditCardYY")
    private WebElement creditCardYY;

    @FindBy(id = "creditCardCVV")
    private WebElement creditCardCVV;

    public CheckPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterToken(String token) {
        tokenInputField.sendKeys(token);
    }

    public void clickCheckButton() {
        checkButton.click();
    }

    public boolean isReservationDetailsDisplayed() {
        return reservationDetails.isDisplayed();
    }

    public boolean isNoReservationMessageDisplayed() {
        return noReservationMessage.isDisplayed();
    }

    // Getters for reservation details
    public String getBusNumber() {
        return busNumber.getText();
    }

    public String getOrigin() {
        return origin.getText();
    }

    public String getDestination() {
        return destination.getText();
    }

    public String getDate() {
        return date.getText();
    }

    public String getDepartureTime() {
        return departureTime.getText();
    }

    public String getArrivalTime() {
        return arrivalTime.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getCapacity() {
        return capacity.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getSurname() {
        return surname.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    public String getAddress() {
        return address.getText();
    }

    public String getCity() {
        return city.getText();
    }

    public String getPostalCode() {
        return postalCode.getText();
    }

    public String getCountry() {
        return country.getText();
    }

    public String getCreditCardNumber() {
        return creditCardNumber.getText();
    }

    public String getCreditCardMM() {
        return creditCardMM.getText();
    }

    public String getCreditCardYY() {
        return creditCardYY.getText();
    }

    public String getCreditCardCVV() {
        return creditCardCVV.getText();
    }
}
