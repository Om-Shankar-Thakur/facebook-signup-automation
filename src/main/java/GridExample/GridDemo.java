package GridExample;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class GridDemo {
 
    public static void main(String[] args) throws Exception {
 
        // Connect to Selenium Grid (default)
        URL gridUrl = new URL("http://localhost:4444");
 
        ChromeOptions options = new ChromeOptions();
 
        WebDriver driver = new RemoteWebDriver(gridUrl, options);
 
        // ShareLane site
        driver.get("https://sharelane.com/cgi-bin/main.py");
 
        // Check title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
 
        // Simple validation
        if (title.contains("ShareLane")) {
            System.out.println("✅ TITLE CHECK PASSED");
        } else {
            System.out.println("❌ TITLE CHECK FAILED");
        }
 
        driver.quit();
    }
}
 