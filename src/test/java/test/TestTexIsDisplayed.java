package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.SalaryInsights;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTexIsDisplayed {

    /*
    URL: https://growth.deel.training/dev/salary-insights
Select the role: QA Engineer
Select the country: Canada
Click the Search
Verify that:
- The text with the selected role and country is displayed in the header of the chart
-Data inputs work only with defined in the dropdown values.
     */

    SalaryInsights salaryInsights;
    public String role = "QA Engineer";
    public String country = "Canada";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://growth.deel.training/dev/salary-insights";
        Configuration.browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        Configuration.browserCapabilities = options;
    }
    @BeforeEach
    void setUp() {
        open("https://growth.deel.training/dev/salary-insights");
        salaryInsights = new SalaryInsights();
    }
    @Test
    public void checkTextIsDisplayed() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        step("Assert that " + role + " role and " + country + " country are selected" +
                " and the Submit button is clicked", () -> {
            salaryInsights.clickSubmitBtn(role, country);
        });
        step("Assert that " + role + " role is displayed in the header of the chart", () -> {
            assertThat(salaryInsights.headerField.getText()).contains(role);
        });
        step("Assert that " + country + " country is displayed in the header of the chart", () -> {
            assertThat(salaryInsights.headerField.getText()).contains(country);
        });


        SelenideLogger.removeListener("AllureSelenide");
    }

}
