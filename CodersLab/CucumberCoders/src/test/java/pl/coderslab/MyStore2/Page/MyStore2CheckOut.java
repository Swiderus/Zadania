package pl.coderslab.MyStore2.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MyStore2CheckOut {
    private WebDriver driver;


    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
    private WebElement confirmAddressButton;

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/label/div/div[2]/span")
    private WebElement pickUpInStore;

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    private WebElement confirmPickUpInStore;

    @FindBy(xpath = "//*[@id=\"payment-option-1-container\"]/label/span")
    private WebElement payByCheck;

    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement agreeTermsOfService;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement orderWithAnObligationToPay;

    @FindBy(xpath = "//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3")
    private WebElement headerOfConfirmation;

    public MyStore2CheckOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void confirmAddress() {
        confirmAddressButton.click();
    }

    public void setPickUpInStore() {
        pickUpInStore.click();
        confirmPickUpInStore.click();
    }

    public void setPayByCheck() {
        payByCheck.click();
        agreeTermsOfService.click();
        orderWithAnObligationToPay.click();
    }

    public void makePrtScr() throws IOException {
        String title = driver.getTitle();
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        ImageIO.write(screenshot.getImage( ), "jpg", new File("./fullimage.jpg"));

    }
    public String getHeader(){
        String header = headerOfConfirmation.getText().substring(1);
        return header;
    }
}
