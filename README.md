# README

## Project Overview

This project is designed to automate tests for the web application available at [https://growth.deel.training/dev/salary-insights](https://growth.deel.training/dev/salary-insights). The primary focus of these tests is to validate functionality related to selecting a specific role and country, and verifying the corresponding outputs on the website.

## Test Scenario

The automated test performs the following actions:

1. **Navigate to the Web Application:**
   - Opens the URL: [https://growth.deel.training/dev/salary-insights](https://growth.deel.training/dev/salary-insights)

2. **Interact with the Web Elements:**
   - Selects the role as 'QA Engineer'.
   - Chooses the country as 'Canada'.
   - Clicks the 'Search' button.

3. **Verify Outputs:**
   - Checks if the text with the selected role ('QA Engineer') and country ('Canada') is correctly displayed in the header of the chart.

## Test Automation

The test is automated using the following technologies:

- **Selenide:** A framework for test automation powered by Selenium WebDriver, which provides a simpler API to write robust and maintainable UI tests.
- **JUnit 5:** A powerful testing framework for Java, used to write and execute repeatable tests.

## GitHub Actions Integration

- The automated tests are configured to run through GitHub Actions, ensuring that tests are executed automatically upon designated triggers (e.g., push, pull request).
- The workflow is defined in the `test.yaml` file within the `.github/workflows` directory.

## Allure Reporting

- Post test execution, an Allure report is generated to provide a detailed overview of the test results.
- The Allure framework is integrated into the project to create comprehensive and interactive reports. This report can be used to analyze test results and failures effectively.

## Setup and Execution

1. **Clone the Repository:**
   - Clone this repository to your local machine to get started.

2. **Run Tests via GitHub Actions:**
   - Tests are automatically triggered in GitHub Actions based on the defined workflow.
   - Navigate to the 'Actions' tab in the GitHub repository to view the test execution status and results.

3. **View Allure Reports:**
   - Upon completion of the test run in GitHub Actions, an Allure report is generated and published.
   - Access the report via the link provided in the GitHub Actions workflow output or in the 'gh-pages' branch of the repository.

## Local Execution (Optional)

To run tests locally:

1. **Prerequisites:**
   - Ensure Java and Gradle are installed on your machine.

2. **Execute Tests:**
   - Run the following command in the terminal at the root of the project:
     ```
     ./gradlew clean test
     ```

3. **Generate and View Allure Report:**
   - Generate the Allure report using:
     ```
     allure serve build/allure-results
     ```
   - This command will open the report in your default web browser.

Note: For local execution, ensure the local setup aligns with the configurations used in GitHub Actions (e.g., browser versions, web driver configurations).
