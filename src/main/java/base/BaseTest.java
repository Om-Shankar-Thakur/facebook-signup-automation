package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import pages.FacebookHomePage;
import utilities.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    

    protected void openSignupPage() {
        FacebookHomePage signup = new FacebookHomePage(driver);
        signup.clickCreateAccount();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BEFORE SUITE CALLED");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BEFORE TEST CALLED");
    }

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser) {

        System.out.println("BEFORE CLASS CALLED - Opening facebook url");

        if (browser == null || browser.isEmpty()) {
            browser = ConfigReader.getProperty("browser");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        
 	   openSignupPage();

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BEFORE METHOD CALLED");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AFTER METHOD CALLED - Resetting page");

        if (driver != null) {
            driver.navigate().refresh();
        }
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AFTER CLASS CALLED - driver closed");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AFTER TEST CALLED");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AFTER SUITE CALLED");
    }
}
