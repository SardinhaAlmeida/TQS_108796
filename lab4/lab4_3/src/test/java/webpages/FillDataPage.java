package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillDataPage {

    private WebDriver driver;

    @FindBy(id = "inputName")
    private WebElement inputName;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "zipCode")
    private WebElement zipCode;

    @FindBy(id = "cardType")
    private WebElement cardType;

    @FindBy(id = "creditCardNumber")
    private WebElement creditCardNumber;

    @FindBy(id = "creditCardMonth")
    private WebElement creditCardMonth;

    @FindBy(id = "creditCardYear")
    private WebElement creditCardYear;

    @FindBy(css = "form")
    private WebElement form;

    @FindBy(id = "nameOnCard")
    private WebElement nameOnCard;

    @FindBy(css = ".checkbox")
    private WebElement checkbox;

    @FindBy(id = "rememberMe")
    private WebElement remember_me;

    @FindBy(css = ".btn-primary")
    private WebElement btn_primary;

    @FindBy(css = "tr:nth-child(1) > td:nth-child(2)")
    private WebElement weird_btn;

    public FillDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void setInputName(String user_name) {
        inputName.sendKeys(user_name);
    }

    public void setAddress(String user_address) {
        address.sendKeys(user_address);
    }

    public void setCity(String user_city) {
        city.sendKeys(user_city);
    }

    public boolean isCityInputEditable() {
        return city.isEnabled() && city.getAttribute("readonly") == null;
    }

    public void setState(String user_state) {
        state.sendKeys(user_state);
    }

    public void setZipCode(String user_zipCode) {
        zipCode.sendKeys(user_zipCode);
    }

    public boolean CardType() {
        return cardType.getText() != "-0.5,0";
    }

    public void setCreditCardNumber(String user_creditCardNumber) {
        creditCardNumber.sendKeys(user_creditCardNumber);
    }

    public void setCreditCardMonth(String user_creditCardMonth) {
        creditCardMonth.sendKeys(user_creditCardMonth);
    }

    public void setCreditCardYear(String user_creditCardYear) {
        creditCardYear.sendKeys(user_creditCardYear);
    }

    public void setForm() {
        form.click();
    }

    public void setNameOnCard(String user_nameOnCard) {
        nameOnCard.sendKeys(user_nameOnCard);
    }

    public void setCheckbox() {
        checkbox.click();   
    }

    public void setRemember_me() {
        remember_me.click();
    }

    public void setBtn_primary() {
        btn_primary.click();
    }

    public void setWeird_btn() {
        weird_btn.click();
    }

    

    
    
}
