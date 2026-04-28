package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FacebookSignupForm;
import services.ErrorExtractor;
import utilities.ExcelUtil;
import utilities.ScreenshotUtil;

public class FacebookSignupTest extends BaseTest {

    @Test(priority = 1)
    public void verifyFacebookSignupPageTest() {

        String expectedUrlPart = "/reg";
        String actualUrl = driver.getCurrentUrl();

        System.out.println("Actual URL: " + actualUrl);

        Assert.assertTrue(
                actualUrl.contains(expectedUrlPart),
                "Application is NOT on the Facebook signup page."
        );

        System.out.println("Signup page loaded successfully. Execution starts.");
    }

    @Test(priority = 2, dependsOnMethods = "verifyFacebookSignupPageTest")
    public void signupValidationTest() throws InterruptedException {

        String excelPath = System.getProperty("user.dir")+ "/src/test/resources/testdata/TestCases.xlsx";
        String resultPath = System.getProperty("user.dir")+ "/src/test/resources/testdata/TestResults.xlsx";

        ExcelUtil.loadExcel(excelPath);

        FacebookSignupForm form = new FacebookSignupForm(driver);
        ErrorExtractor errorExtractor = new ErrorExtractor(driver);

        for (int i = 1; i <= ExcelUtil.getRowCount(); i++) {

            System.out.println("===== Executing TC_" + i + " =====");

            String fname = ExcelUtil.getCellData(i, 1);
            String lname = ExcelUtil.getCellData(i, 2);
            String day = ExcelUtil.getCellData(i, 3);
            String month = ExcelUtil.getCellData(i, 4);
            String year = ExcelUtil.getCellData(i, 5);
            String gender = ExcelUtil.getCellData(i, 6);
            String mobile = ExcelUtil.getCellData(i, 7);

            form.enterFirstName(fname);
            form.enterSurname(lname);
            form.selectDOB(day, month, year);
            form.selectGender(gender);
            form.enterMobile(mobile);

            form.clickSubmit();

            String result = errorExtractor.getErrors();
            System.out.println("Result: " + result);

            ScreenshotUtil.captureScreenshot(driver, "TC_" + i);
            ExcelUtil.writeResult(i, 9, result);
            
            driver.navigate().refresh();
        }

        ExcelUtil.saveExcel(resultPath);
        ExcelUtil.closeExcel();
    }
}