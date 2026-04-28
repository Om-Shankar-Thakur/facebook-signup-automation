package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookSignupForm {

    private WebDriver driver;
    private WebDriverWait wait;

    public FacebookSignupForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Text fields
    public void enterFirstName(String fname) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='First name']/preceding-sibling::input")));
        e.sendKeys(fname);
    }

    public void enterSurname(String lname) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='Surname']/preceding-sibling::input")));
        e.sendKeys(lname);
    }

    public void enterMobile(String mobile) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='Mobile number or email address']/preceding-sibling::input")));
        e.sendKeys(mobile);
    }

    // DOB
    public void selectDOB(String day, String month, String year) {
        selectFromDropdown("Select day", day);
        selectFromDropdown("Select month", month);
        selectFromDropdown("Select year", year);
    }

    private void selectFromDropdown(String ariaLabel, String value) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='combobox' and @aria-label='" + ariaLabel + "']")));
        dropdown.click();

        String listId = dropdown.getAttribute("aria-controls");
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(listId)));

        for (WebElement option : list.findElements(By.xpath(".//div[@role='option']"))) {
            if (option.getText().trim().equals(value)) {
                option.click();
                break;
            }
        }
    }

    // Gender
    public void selectGender(String gender) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Select your gender']/ancestor::div[@role='combobox']")));
        dropdown.click();

        String listId = dropdown.getAttribute("aria-controls");
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(listId)));

        for (WebElement option : list.findElements(By.xpath(".//div[@role='option']"))) {
            if (option.getText().equalsIgnoreCase(gender)) {
                option.click();
                break;
            }
        }
    }

    // Submit
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='button'][.//span[text()='Submit']]"))
        ).click();
    }
}