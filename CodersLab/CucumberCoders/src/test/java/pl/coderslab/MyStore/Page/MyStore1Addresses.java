package pl.coderslab.MyStore.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyStore1Addresses {
    private WebDriver driver;

    public MyStore1Addresses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

    public void addressesTileFinderByAliasAndGetChildText(String alias){
        WebElement aliasLocation = driver.findElement(By.xpath("//*[text() = '"+alias+"']"));
        String childrenOfAlias = driver.findElement(By.xpath("//*[text() = '"+alias+"']/..")).getText();

    }
}
