package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SalaryInsights {
    public final SelenideElement
            roleInput = $x("//input[@name='role']")
            .as("Role input field"),
            countryInput = $x("//input[@name='country']")
                    .as("Country input field"),
            submitBtn = $x("//button[@type='submit']")
                    .as("Submit button"),
            headerField = $x("//div[@data-qa='salary-table']")
                    .as("Header field");

    public void clickSubmitBtn(String role, String country) {
        roleInput.shouldBe(visible, enabled);
        roleInput.sendKeys(role);
        sleep(2000);
        roleInput.sendKeys(Keys.DOWN);
        roleInput.sendKeys(Keys.DOWN);
        sleep(2000);
        roleInput.sendKeys(Keys.RETURN);
        sleep(2000);
        countryInput.shouldBe(visible, enabled).setValue(country);
        sleep(2000);
        countryInput.sendKeys(Keys.DOWN,Keys.RETURN);
        sleep(2000);
        submitBtn.shouldBe(visible,enabled).click();
    }

}
