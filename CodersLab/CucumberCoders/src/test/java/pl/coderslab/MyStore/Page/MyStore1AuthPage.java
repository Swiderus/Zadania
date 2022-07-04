package pl.coderslab.MyStore.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStore1AuthPage {
    private WebDriver driver;

    @FindBy(css = "input[name=email]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='login-form']/section/div[2]/div[1]/div/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='submit-login']")
    private WebElement signInButton;

    public MyStore1AuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void enterLoginData(String email, String password){
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
