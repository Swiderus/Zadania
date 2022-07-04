package pl.coderslab.MyStore.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.MyStore.Page.*;
import java.time.Duration;
import java.util.Locale;

public class MyStore1Steps {
        private WebDriver driver;

    @Given("I am at mystore page with valid user account")
    public void openMyStorePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl");
        MyStore1Main main = new MyStore1Main(driver);
        main.signIn();
    }

    @When("^I sign using mail: (.+) password: (.+)$")
    public void signIn(String email, String password) {
        MyStore1AuthPage authPage = new MyStore1AuthPage(driver);
        authPage.enterLoginData(email, password);
    }

    @And("Add new address clicking Addresses tile and then link to createNewAddress")
    public void goToCreateAddressForm() {
        MyStore1Logged logged = new MyStore1Logged(driver);
        logged.addressesTileClick();
        logged.createNewAddressClick();
    }

    @And("^Type alias in new address: (.+)$")
    public void fillAlias(String alias) {
        MyStore1AddressForm addressForm = new MyStore1AddressForm(driver);
        addressForm.fillAlias(alias);

    }

    @And("^Type First name in new address: (.+)$")
    public void fillFirstName(String firstName) {
        MyStore1AddressForm addressForm = new MyStore1AddressForm(driver);
        addressForm.fillFirstName(firstName);
    }

    @And("^Type Last name in new address: (.+)$")
    public void fillLastNameLastName(String lastName) {
        MyStore1AddressForm addressForm = new MyStore1AddressForm(driver);
        addressForm.fillLastName(lastName);
    }

    @And("^Type Address in new address: (.+)$")
    public void fillAddressAddress(String address) {
        MyStore1AddressForm addressForm = new MyStore1AddressForm(driver);
        addressForm.fillAddress(address);
    }


    @And("^Type City in new address: (.+)$")
    public void fillCityCity(String city) {
        MyStore1AddressForm addressForm = new MyStore1AddressForm(driver);
        addressForm.fillCity(city);
    }


    @And("^Type zip code in new address: (.+)$")
    public void fillZipCodeZipCode(String zipCode) {
        MyStore1AddressForm addressForm = new MyStore1AddressForm(driver);
        addressForm.fillZipCode(zipCode);
    }

    @And("^Type phone number in new address: (.+)$")
    public void fillPhoneNumberPhoneNumber(String phoneNumber) {
        MyStore1AddressForm addressForm = new MyStore1AddressForm(driver);
        addressForm.fillPhoneNumber(phoneNumber);
    }

    @And("Save new address")
    public void saveTheNewAddress() {
        MyStore1AddressForm addressForm = new MyStore1AddressForm(driver);
        addressForm.signInClick();
    }

    @Then("^Find proper tile with new address, and compare data of alias, and compare data of (.+), (.+), (.+), (.+), (.+), (.+), (.+), (.+)$")
    public void findProperTileWithNewAddress(String alias, String firstName, String lastName, String address, String city, String zipCode, String phoneNumber , String country) {
        String data = alias + firstName + lastName + address + city + zipCode + phoneNumber + country;
        data=data.toLowerCase(Locale.ROOT).replaceAll("\\s","");
        String childrenOfAlias = driver.findElement(By.xpath("//*[text() = '" + alias + "']/..")).getText();
        childrenOfAlias=childrenOfAlias.toLowerCase(Locale.ROOT).replaceAll("\\s","");
        Assertions.assertEquals(childrenOfAlias,data);



    }
}