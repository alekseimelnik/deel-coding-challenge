package Test;

import PageObject.SalaryInsights;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.open;
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

    public String role = "QA ";
    public String country = "Canada";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://growth.deel.training/dev/salary-insights";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp() {
        open(Configuration.baseUrl);
        salaryInsights = new SalaryInsights();
    }
    @Test
    public void testTextIsDisplayed() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        salaryInsights.clickSubmitBtn(role, country);
        assertThat(salaryInsights.headerField.getText()).contains(role);
        assertThat(salaryInsights.headerField.getText()).contains(country);

//        SelenideLogger.removeListener("AllureSelenide");
    }

}
