package pl.coderslab.MyStore2.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStore2MainAndLogin {
        private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    private WebElement mailInputField;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@id=\"submit-login\"]")
    private WebElement signInButton2;

    @FindBy(xpath = "//*[@id=\"category-3\"]/a")
    private WebElement clothesButton;

    public MyStore2MainAndLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void signInClick(){
        signInButton.click();
    }

    public void signInMailAndPassword(String mail, String password){
        mailInputField.sendKeys("swiderus@interia.pl");
        passwordInputField.sendKeys("jklopol1");
        signInButton2.click();
        clothesButton.click();
    }
}
