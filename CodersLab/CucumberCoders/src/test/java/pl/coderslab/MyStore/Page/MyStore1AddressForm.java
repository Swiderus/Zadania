package pl.coderslab.MyStore.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStore1AddressForm {
    private WebDriver driver;

    @FindBy(xpath="//*[@id='content']/div/div/form/section/div[1]/div[1]/input")
    private WebElement aliasField;

    @FindBy(xpath="//*[@id='content']/div/div/form/section/div[2]/div[1]/input")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id='content']/div/div/form/section/div[3]/div[1]/input")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id='content']/div/div/form/section/div[6]/div[1]/input")
    private WebElement addressField;

    @FindBy(xpath = "//*[@id='content']/div/div/form/section/div[8]/div[1]/input")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id='content']/div/div/form/section/div[9]/div[1]/input")
    private WebElement zipCodeField;

    @FindBy(xpath = "//*[@id='content']/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id='content']/div/div/form/footer/button")
    private WebElement signInButton;

    public MyStore1AddressForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void fillAlias(String alias) {

        aliasField.clear();
        aliasField.sendKeys(alias);
    }

    public void fillFirstName(String firstName) {

        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {

        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void fillAddress(String address) {

        addressField.clear();
        addressField.sendKeys(address);
    }
    public void fillCity(String city) {

        cityField.clear();
        cityField.sendKeys(city);
    }
    public void fillZipCode(String zipCode) {
        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);
    }
    public void fillPhoneNumber(String phoneNumber) {
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);
    }
    public void signInClick(){
        signInButton.click();
    }
}
