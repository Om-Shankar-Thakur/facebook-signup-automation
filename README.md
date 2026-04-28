# Facebook Signup Automation – Mini Project

## Overview

This project is a **Selenium WebDriver automation framework** developed using **Java and TestNG** to validate the **Facebook Signup page** behavior for multiple negative and edge‑case scenarios.

The automation focuses on:
- Navigating to the Facebook Signup page
- Entering invalid user data
- Submitting the signup form
- Capturing UI validation error messages
- Storing test results and screenshots for traceability

---

## Tech Stack

- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **IDE:** Eclipse  
- **Version Control:** Git & GitHub  

---

## Project Structure



## Key Design Features

### Page Object Model (POM)
- UI interaction logic is separated from test logic
- Improves code readability, maintainability, and scalability

### TestNG Lifecycle Management
- `@BeforeClass` → Browser initialization and navigation
- `@Test` → Test execution
- `@AfterMethod` → Page reset for test isolation
- `@AfterClass` → Browser teardown

### Explicit Waits
- Uses `WebDriverWait` with `ExpectedConditions`
- Ensures stable synchronization for dynamic Facebook UI

### Externalized Test Data
- Test data maintained in Excel sheets
- Easy modification without changing test code

### Dynamic Error Validation
- Extracts only visible validation messages
- Avoids dependency on hard‑coded expected text

### Full‑Page Screenshot Capture
- Dynamically resizes browser window to full page height
- Captures complete UI including validation messages

---

## Test Execution Flow

1. Launch browser
2. Navigate to Facebook homepage
3. Click **Create New Account**
4. Validate signup page URL
5. Fill signup form with invalid data
6. Submit the form
7. Extract validation error messages
8. Capture full‑page screenshot
9. Store results in Excel
10. Reset page for next test execution

---

## How to Run the Project



1. **Clone the repository**
```bash
git clone https://github.com//facebook-automation.git
```

2. **Import into Eclipse**
```
- Open Eclipse
- Go to Import → Existing Maven Project
- Select the project directory
```

3. **Execute tests**
```
- Right‑click on `testng.xml`
- Run As → TestNG Suite
```
---

## Reporting

- **Console Logs:** Execution details and validation results
- **Excel File:** Input data and validation messages per test case
- **Screenshots:** Full‑page UI evidence captured per execution

---

## Why Page Factory and DataProvider Were Not Used

- **Page Factory** was avoided due to Facebook’s highly dynamic UI which may lead to stale element issues.
- **DataProvider** was not used as multiple datasets were executed on the same signup page instance to reflect real user behavior.

---

## Future Enhancements

- Integration with ExtentReports for HTML reporting
- Parallel test execution using TestNG
- CI/CD integration with Jenkins
- Cross‑browser execution support

---

## Author

**OM SHANKAR THAKUR**  
Quality Engineering & Assurance – Automation  
(Java | Selenium | TestNG)

