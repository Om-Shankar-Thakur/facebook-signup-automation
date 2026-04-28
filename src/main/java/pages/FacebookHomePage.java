package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FacebookHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Create new account']")
        )).click();
    }
}