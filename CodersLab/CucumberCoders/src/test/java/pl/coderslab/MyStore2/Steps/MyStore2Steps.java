package pl.coderslab.MyStore2.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.MyStore2.Page.MyStore2CheckOut;
import pl.coderslab.MyStore2.Page.MyStore2Clothes;
import pl.coderslab.MyStore2.Page.MyStore2MainAndLogin;
import pl.coderslab.MyStore2.Page.MyStore2Sweater;

import java.io.IOException;
import java.time.Duration;

public class MyStore2Steps {
    private WebDriver driver;

    @Given("I am at mystore page with valid user account and go to sign in button")
    public void openMyStorePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl");
        MyStore2MainAndLogin main = new MyStore2MainAndLogin(driver);
        main.signInClick();
    }

    @When("^I sign in with data (.+) password (.+)$")
    public void signInWithMailAndPassword(String mail, String password) {
    MyStore2MainAndLogin mainAndLogin = new MyStore2MainAndLogin(driver);
        mainAndLogin.signInMailAndPassword(mail, password);
    }

    @And("Go to clothes and pick Hummingbird Printed Sweater")
    public void goToTlothesAndPickHummingbirdPrintedSweater() {
        MyStore2Clothes clothes = new MyStore2Clothes(driver);
        clothes.chooseSweaterClick();

    }

    @And("^Check if discount is 20% pick size M pick amount (.+) and add to cart$")
    public void checkDiscountPickSizePickQuantityAddToCart (int gulag) throws InterruptedException {
        MyStore2Sweater sweater = new MyStore2Sweater(driver);
        boolean discountCheck = sweater.discountCheck();
        boolean a = true;
        Assertions.assertEquals(a, discountCheck);
        sweater.setSizeToM();
        sweater.setQuantity(gulag);
        sweater.addToCart();
        sweater.proceedButton();
        sweater.secondProceed();
    }

    @And("Pick address pick payment Pay by Check pick order with obligation to pay use PrintScreen")
    public void pickAddressPickPaymentPayByCheckPickOrderWithObligationToPayUsePrintScreen() throws IOException {
        MyStore2CheckOut checkOut = new MyStore2CheckOut(driver);
        checkOut.confirmAddress();
        checkOut.setPickUpInStore();
        checkOut.setPayByCheck();
        checkOut.makePrtScr();
    }

    @Then("Check order confirmation header")
    public void checkOrderConfirmationHeader() {
        MyStore2CheckOut checkOut = new MyStore2CheckOut(driver);
        String shouldBe = "YOUR ORDER IS CONFIRMED";
        String getTextFromHeader = checkOut.getHeader();
        Assertions.assertEquals(shouldBe, getTextFromHeader);
    }
}
