package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorExtractor {

    private WebDriver driver;

    public ErrorExtractor(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrors() {

        StringBuilder errors = new StringBuilder();

        append(errors, "First Name", "name contains|What's your name");
        append(errors, "Surname", "surname");
        append(errors, "DOB", "date of birth");
        append(errors, "Gender", "choose a gender");
        append(errors, "Mobile", "mobile number");
        append(errors, "Password", "combination of at least");

        return errors.length() == 0 ? "SUCCESS" : errors.toString();
    }

    private void append(StringBuilder sb, String label, String matcher) {
        try {
            sb.append(label)
              .append(": ")
              .append(driver.findElement(
                      By.xpath("//*[contains(text(),'" + matcher + "')]"))
                      .getText())
              .append(" | ");
        } catch (Exception ignored) {}
    }
}
