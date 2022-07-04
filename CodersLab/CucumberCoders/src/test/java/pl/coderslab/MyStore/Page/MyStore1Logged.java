package pl.coderslab.MyStore.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStore1Logged {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id='addresses-link']/span")
    private WebElement addressesTile;
    @FindBy(xpath = "//*[@id='content']/div[3]/a/span")
    private WebElement createNewAddressButton;

    public MyStore1Logged(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void addressesTileClick(){
        addressesTile.click();
    }
    public void createNewAddressClick(){
        createNewAddressButton.click();

    }
}
