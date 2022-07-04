package pl.coderslab.MyStore2.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStore2Sweater {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]/span")
    private WebElement priceBeforeDiscount;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]")
    private WebElement priceAfterDiscount;

    @FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
    private WebElement chooseMSize;

    @FindBy(css = "i.material-icons.touchspin-up")
    private WebElement buttonIncreaseQuantity;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantityOfSweaters;

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement secondProceedButton;

    public MyStore2Sweater(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean discountCheck() {

        String before = priceBeforeDiscount.getText();
        before = before.substring(1);
        double doubleBefore = Double.parseDouble(before);
        double discount = doubleBefore * 0.8;

        String after = priceAfterDiscount.getText();
        after = after.substring(1);
        double doubleAfter = Double.parseDouble(after);

        boolean resultOfEquals = discount == doubleAfter;

        return resultOfEquals;

    }

    public void setSizeToM() {
        chooseMSize.click();
    }

    public void setQuantity(int quantOfSweater) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        for (int i = 0; i < quantOfSweater; i++) {
            buttonIncreaseQuantity.click();
            Thread.sleep(150);
        }
    }

    public void addToCart() {
        buttonAddToCart.click();
    }

    public void proceedButton() {
        proceedToCheckoutButton.click();
    }

    public void secondProceed() {
        secondProceedButton.click();
    }
}

